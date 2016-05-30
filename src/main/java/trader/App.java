package trader;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class App extends Application<Configuration> {

    public static final String ASSETS_SERVLET_NAME = "assets-servlet";

    public static void main(String[] args) throws Exception {
        new App().run(new String[]{"server", "src/main/resources/config.yml"});
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/static/", "/", "index.html", ASSETS_SERVLET_NAME));
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new TodoResource());

        final FilterRegistration.Dynamic filterBuilder = environment.servlets().addFilter("static-filter", AssetsServingFilter.class);

        filterBuilder.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, ASSETS_SERVLET_NAME);
    }
}