package com.globant.appWadio.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    public AppiumDriver appiumDriver;

    public BaseScreen(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }
}
