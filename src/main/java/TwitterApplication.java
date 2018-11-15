import com.restapi.config.TwitterConfiguration;
import com.restapi.resource.ApplicationResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by anshul.gupta on 11/13/18.
 */
public class TwitterApplication extends Application<TwitterConfiguration> {
    public static void main(String[] args) throws Exception {
        new TwitterApplication().run(args);
    }
    @Override
    public void run(TwitterConfiguration twitterConfiguration, Environment environment) throws Exception {
        final ApplicationResource applicationResource = new ApplicationResource();
        environment.jersey().register(applicationResource);
    }
}