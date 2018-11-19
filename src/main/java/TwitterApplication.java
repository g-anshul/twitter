import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import twitter.Service.TwitterService;
import twitter.Service.TwitterServiceInterface;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TwitterApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new TwitterApplication().run(args);
    }

    @Override
    public void run(Configuration config, Environment env) {
        final TwitterService twitterService = new TwitterService();
        env.jersey().register(twitterService);
    }
}