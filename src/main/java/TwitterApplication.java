import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import twitter.Configuration.TwitterStubConfig;
import twitter.Service.TwitterService;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TwitterApplication extends Application<TwitterStubConfig> {

    public static void main(String[] args) throws Exception {
        new TwitterApplication().run(args);
    }

    @Override
    public void run(TwitterStubConfig config, Environment env) {
        final TwitterService personService = new TwitterService();
        env.jersey().register(personService);
    }
}