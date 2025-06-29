package com.globant.appWadio.tests;

import com.globant.appWadio.screens.*;
import com.globant.appWadio.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void testMenuNavigation() {
        SplashScreen splashScreen = new SplashScreen(appiumDriver);
        TabMenu tabMenu = new TabMenu(appiumDriver);
        splashScreen.waitLogoAppears();
        WebviewScreen webviewScreen = tabMenu.tapOnWebviewTab();
        webviewScreen.waitForWebviewToLoad();
        Assert.assertTrue(webviewScreen.isWebviewTitleVisible(), "Webview title is not visible");
        LoginScreen loginScreen = tabMenu.tapOnLoginTab();
        loginScreen.waitForLoginFormToLoad();
        Assert.assertTrue(loginScreen.isLoginFormVisible()," Login form is not visible");
        FormsScreen formsScreen = tabMenu.tapOnFormsTab();
        formsScreen.waitForFormsToLoad();
        Assert.assertTrue(formsScreen.isFormsVisible(), "Forms screen is not visible");
        SwipeScreen swipeScreen = tabMenu.tapOnSwipeTab();
        swipeScreen.waitForSwipeToLoad();
        Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");
        DragScreen dragScreen = tabMenu.tapOnDragTab();
        dragScreen.waitForDragToLoad();
        Assert.assertTrue(dragScreen.isDragAndDropVisible(), "Drag and Drop screen is not visible");
        tabMenu.tapOnHomeTab();
        splashScreen.waitLogoAppears();
    }
}
