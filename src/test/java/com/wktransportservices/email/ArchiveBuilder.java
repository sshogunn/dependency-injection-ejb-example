package com.wktransportservices.email;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.wildfly.swarm.undertow.WARArchive;

import java.io.File;


public class ArchiveBuilder {
    public Archive buildArchive() throws Exception {
        final WARArchive warArchive = ShrinkWrap.create(WARArchive.class);

        File[] dependenciesFiles = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importDependencies(ScopeType.COMPILE, ScopeType.TEST, ScopeType.PROVIDED, ScopeType.RUNTIME)
                .resolve().withTransitivity().asFile();
        if (dependenciesFiles != null) {
            warArchive.addAsLibraries(dependenciesFiles);
        }

        warArchive.addPackages(true, "com.wktransportservices.email");
        return warArchive;
    }
}
