package com.globant.appWadio.tests;

import com.globant.appWadio.screens.SplashScreen;
import com.globant.appWadio.screens.TabMenu;
import com.globant.appWadio.screens.WebviewScreen;
import com.globant.appWadio.utils.BaseTest;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void testMenuNavigation() {
        SplashScreen splashScreen = new SplashScreen(appiumDriver);
        TabMenu tabMenu = new TabMenu(appiumDriver);
        splashScreen.waitLogoAppears();
        WebviewScreen webviewScreen = tabMenu.tapOnWebviewTab();
        webviewScreen.waitForWebviewToLoad();
        tabMenu.tapOnLoginTab();
        tabMenu.tapOnFormsTab();
        tabMenu.tapOnSwipeTab();
        tabMenu.tapOnDragTab();
        tabMenu.tapOnHomeTab();
        splashScreen.waitLogoAppears();
    }
}
