package com.globant.appWadio.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AppiumDriver appiumDriver;

    @BeforeSuite
    public void setUp() {
        this.appiumDriver = createDriver();
    }

    @BeforeMethod
    public AppiumDriver createDriver(){
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\Jeidy Katherine\\Downloads\\android.wdio.native.app.v1.0.8.apk")
                .setPlatformVersion("16");
        try{
            AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            return driver;
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    @AfterSuite
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
