package com.epam.trainings.di.ejb;

import com.epam.trainings.di.ejb.rest.RestApplicationActivator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

import static io.restassured.RestAssured.given;

@RunWith(Arquillian.class)
public class RestControllersTest {
    private static final String RESOURCE_PREFIX = RestApplicationActivator.class.getAnnotation(ApplicationPath.class).value().substring(1);

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static Archive createDeployment() throws Exception {
        Archive archive = new ArchiveBuilder().buildArchive();
        return archive;
    }

    @Test
    @InSequence(1)
    @RunAsClient
    public void doGetMessage() throws Exception {
        String urlToBeUsed = deploymentURL.toString() + RESOURCE_PREFIX + "/fighters/";
        given()
                .accept(MediaType.APPLICATION_JSON)
                .get(urlToBeUsed)
                .then()
                .log().ifError()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
