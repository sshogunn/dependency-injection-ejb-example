package com.epam.trainings.di.ejb;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.wildfly.swarm.it.AbstractIntegrationTest;

import static org.fest.assertions.Assertions.assertThat;


@RunWith(Arquillian.class)
public class GradlePackagedApplicationIT extends AbstractIntegrationTest {

    @Drone
    WebDriver browser;

    @Test
    public void testIt() {
        browser.navigate().to("http://localhost:8181/");
        assertThat(browser.getPageSource()).contains("hello: wildfly swarm + gradle + java");
    }
}
