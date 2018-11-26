import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.Path;
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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        context.start();
        //context.getBeanFactory().registerSingleton("configuration",config);
        Map<String, Object> resources = context.getBeansWithAnnotation(Path.class);
        for (Map.Entry<String, Object> entry : resources.entrySet()) {
            environment.jersey().register(entry.getValue());
        }
    }
}