package com.globant.appWadio.utils;

//import org.apache.log4j.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    public AppiumDriver driver;
    protected static final int TIMEOUT = 10;
    protected WebDriverWait wait;
//    protected Logger logs;

    public BaseScreen(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        this.logs = Logger.getLogger(this.getClass().getName());
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * This method is used to wait for an element to appear.
     */
    public void waitForElementToAppear(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
//            logs.info("Element has disappeared: " + element);
        } catch (TimeoutException e) {
//            logs.error("Element did not disappear in time: " + element, e);
        }
    }
}
