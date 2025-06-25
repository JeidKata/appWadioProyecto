package com.globant.appWadio.tests;

import com.globant.appWadio.screens.LoginScreen;
import com.globant.appWadio.screens.TabMenu;
import com.globant.appWadio.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        TabMenu tabMenu = new TabMenu(appiumDriver);
        LoginScreen loginScreen = tabMenu.tapOnLoginTab();
        loginScreen.tapOnLoginButton();
        System.out.println("Login test executed successfully.");
    }
}
