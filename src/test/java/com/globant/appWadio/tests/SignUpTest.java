package com.globant.appWadio.tests;

import com.globant.appWadio.screens.LoginScreen;
import com.globant.appWadio.screens.TabMenu;
import com.globant.appWadio.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    /**
     * This test verifies the sign-up functionality by navigating to the sign-up tab,
     * entering a random email and password, and checking if the success alert message is displayed.
     * Has a Hard Assertion to ensure the test fails if the alert message is not as expected.
     */
    @Test
    public void testSignUp() {
        TabMenu tabMenu = new TabMenu(appiumDriver);
        LoginScreen signUp = tabMenu.tapOnLoginTab();
        signUp.tapOnSignUpTab();
        signUp.tapOnSignUpButton();

        Assert.assertEquals(signUp.getAlertMessage(),
                "You successfully signed up!","The alert message is not as expected.");
    }

    /**
     * This test verifies the sign-up functionality using a soft assertion.
     * It checks if the success alert message is displayed after signing up.
     * The test will not fail immediately if the assertion fails, allowing for further checks.
     */
    @Test
    public void testSignUpWithErrorMessage() {
        TabMenu tabMenu = new TabMenu(appiumDriver);
        LoginScreen signUp = tabMenu.tapOnLoginTab();
        signUp.tapOnSignUpTab();
        signUp.tapOnSignUpButton();

        softAssert.assertEquals(signUp.getAlertMessage(), "You successfully signed up", "The alert message is not as expected.");
        softAssert.assertAll("Look at the soft assertion results");
    }
}
