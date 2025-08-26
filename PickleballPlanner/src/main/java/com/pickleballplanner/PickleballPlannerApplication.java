package com.pickleballplanner;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pickleballplanner.core.Game;
import com.pickleballplanner.core.Player;
import com.pickleballplanner.db.dao.GameDAO;
import com.pickleballplanner.db.dao.PlayerDAO;
import com.pickleballplanner.resources.GamesResource;
import com.pickleballplanner.resources.PlayerResource;

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

    private final HibernateBundle<PickleballPlannerConfiguration> hibernate = new HibernateBundle<>(Game.class, Player.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(PickleballPlannerConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<PickleballPlannerConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final PickleballPlannerConfiguration configuration,
                    final Environment environment) {

        final GameDAO gameDAO = new GameDAO(hibernate.getSessionFactory());
        final PlayerDAO playerDAO = new PlayerDAO(hibernate.getSessionFactory());
        
        final GamesResource gamesResource = new GamesResource(gameDAO, playerDAO);
        final PlayerResource playerResource = new PlayerResource(playerDAO);

        environment.jersey().register(gamesResource);
        environment.jersey().register(playerResource);
    }

}
