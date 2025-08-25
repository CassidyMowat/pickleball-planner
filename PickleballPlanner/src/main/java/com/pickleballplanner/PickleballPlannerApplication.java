package com.pickleballplanner;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pickleballplanner.resources.GamesResource;

public class PickleballPlannerApplication extends Application<PickleballPlannerConfiguration> {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PickleballPlannerApplication.class);

    public static void main(final String[] args) throws Exception {
        LOGGER.info("Start Application");
        new PickleballPlannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "PickleballPlanner";
    }

    @Override
    public void initialize(final Bootstrap<PickleballPlannerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PickleballPlannerConfiguration configuration,
                    final Environment environment) {
        
        final GamesResource gamesResource = new GamesResource();

        environment.jersey().register(gamesResource);
    }

}
