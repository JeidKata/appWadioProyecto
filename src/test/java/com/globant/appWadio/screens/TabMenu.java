package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TabMenu extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Home\")")
    private WebElement bntHome;

    @AndroidFindBy(uiAutomator = "description(\"Webview\")")
    private WebElement btnWebview;

    @AndroidFindBy(accessibility = "Login")
    private WebElement btnLogin;

    @AndroidFindBy(uiAutomator = "text(\"Forms\")")
    private WebElement btnForms;

    @AndroidFindBy(uiAutomator = "text(\"Swipe\")")
    private WebElement btnSwipe;

    @AndroidFindBy(uiAutomator = "text(\"Drag\")")
    private WebElement btnDrag;


    public TabMenu(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is used to tap on the "Home" tab.
     */
    public void tapOnHomeTab() {
        if(waitForElementToAppear(bntHome)){
            System.out.println("Home button is visible, proceeding to click.");
        }
        else {
            System.out.println("Home button is not visible, cannot proceed.");
        }

        bntHome.click();
    }

    /**
     * This method is used to tap on the "Webview" tab.
     */
    public void tapOnWebviewTab() {
        if(waitForElementToAppear(btnWebview)){
            System.out.println("Webview button is visible, proceeding to click.");
        }
        else {
            System.out.println("Webview button is not visible, cannot proceed.");
        }
        btnWebview.click();
    }

    /**
     * This method is used to tap on the "Login" tab.
     */
    public void tapOnLoginTab() {
        if(waitForElementToAppear(btnLogin)){
            System.out.println("Login button is visible, proceeding to click.");
        }
        else {
            System.out.println("Login button is not visible, cannot proceed.");
        }
        btnLogin.click();
    }

    /**
     * This method is used to tap on the "Forms" tab.
     */
    public void tapOnFormsTab() {
        if(waitForElementToAppear(btnForms)){
            System.out.println("Forms button is visible, proceeding to click.");
        }
        else {
            System.out.println("Forms button is not visible, cannot proceed.");
        }
        btnForms.click();
    }

    /**
     * This method is used to tap on the "Swipe" tab.
     */
    public void tapOnSwipeTab() {
        if(waitForElementToAppear(btnSwipe)){
            System.out.println("Swipe button is visible, proceeding to click.");
        }
        else {
            System.out.println("Swipe button is not visible, cannot proceed.");
        }
        btnSwipe.click();
    }

    /**
     * This method is used to tap on the "Drag" tab.
     */
    public void tapOnDragTab() {
        if(waitForElementToAppear(btnDrag)){
            System.out.println("Drag button is visible, proceeding to click.");
        }
        else {
            System.out.println("Drag button is not visible, cannot proceed.");
        }
        btnDrag.click();
    }
}
