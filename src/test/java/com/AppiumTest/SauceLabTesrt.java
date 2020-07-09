package com.AppiumTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.MalformedURLException;
import java.net.URL;
 
 
public class SauceLabTesrt {
    private WebDriver driver;
 
    @Test
    public void shouldOpenChrome() throws MalformedURLException {
        
        String sauceURL = "https://ondemand.saucelabs.com/wd/hub";
        
        DesiredCapabilities caps = DesiredCapabilities.android();
        
        caps.setCapability("username", "imqavickygupta");
        caps.setCapability("accessKey", "343521b4-9a4e-45a9-b2d9-a99325e12ba7");
        
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","Samsung Galaxy S9 Plus FHD GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platformVersion","8.1");
        caps.setCapability("platformName","Android");
        caps.setCapability("build", "Mayank Sample App Test for mobile automation");
        caps.setCapability("name", "Sample Test");
 
        
        driver = new RemoteWebDriver(new URL(sauceURL), caps);
        
        driver.navigate().to("https://www.google.com");
    }
 
    
    @After
    public void cleanUpAfterTestMethod () {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + ("passed"));
        driver.quit();
    }
}
