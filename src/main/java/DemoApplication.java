import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DemoApplication extends Application<DemoConfiguration> {

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {
        environment
            .jersey()
            .register(new DemoResource(configuration.getDefaultPartyDay()));
    }

    public static void main(String... args) throws Exception {
        new DemoApplication().run(args);
    }
}
