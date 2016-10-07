package com.epam.trainings.di.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.api.Assertions.assertThat;


@RunWith(Arquillian.class)
public class KungFuPandaSystemUITest {

    @Drone
    WebDriver browser;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIt() {
        browser.navigate().to("http://localhost:8181/");
        assertThat(browser.getPageSource()).contains("hello: wildfly swarm + gradle + java");
    }
}
