package com.epam.trainings.di.ejb.rest;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

/**
 * REST Interface Initialization
 * All rest call starts with the ApplicationPath
 */
@ApplicationPath("/api")
public class RestApplicationActivator extends Application {
}