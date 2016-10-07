package com.epam.trainings.di.ejb;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;


public class KungFuPandaApplication {

    public static void main(String... args) throws Exception {

        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addClass(FightersEndpoint.class);
        deployment.addAllDependencies();
        swarm.start().deploy(deployment);

    }
}
