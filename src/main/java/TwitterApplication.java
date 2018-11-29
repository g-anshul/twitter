import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.Path;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by anshul.gupta on 11/15/18.
 */
@EnableCaching
public class TwitterApplication extends Application<Configuration>{

    public static void main(String[] args) throws Exception {
        new TwitterApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration config, Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        context.start();
        //context.getBeanFactory().registerSingleton("configuration",config);
        Map<String, Object> resources = context.getBeansWithAnnotation(Path.class);
        for (Map.Entry<String, Object> entry : resources.entrySet()) {
            environment.jersey().register(entry.getValue());
        }
    }
}