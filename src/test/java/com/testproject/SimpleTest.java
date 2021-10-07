package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;


public class SimpleTest {

    private WebDriver driver;

    @Before
    public void setup () throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://example.cypress.io/commands/actions");
    }

    @After
    public void tearDown () throws Exception{
        driver.quit();
    }
    @Test
    public void shouldOpen() {
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());

    }

    @Test
    public void shouldType() {
        var inputField = driver.findElement(By.cssSelector(".action_email"));
        inputField.sendKeys("test@test.com");
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());

    }


}
