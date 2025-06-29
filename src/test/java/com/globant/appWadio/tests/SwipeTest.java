package com.globant.appWadio.tests;

import com.globant.appWadio.screens.SwipeScreen;
import com.globant.appWadio.screens.TabMenu;
import com.globant.appWadio.utils.BaseTest;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void testSwipeSection() {
        TabMenu menu = new TabMenu(appiumDriver);
        SwipeScreen swipeScreen = menu.tapOnSwipeTab();
        swipeScreen.swipeCards();
        softAssert.assertTrue(swipeScreen.isLastCardDisplayed(),
                "The last card is not displayed as expected.");
        softAssert.assertEquals(swipeScreen.getLblLastCard(),
                "COMPATIBLE", "The last card label is not as expected.");
        swipeScreen.swipeBottomToTop();
        softAssert.assertEquals(swipeScreen.getLblYouFoundMe(),
                "You found me!!!", "The last card label is not as expected.");
        System.out.println("Swipe left test executed successfully.");
    }
}
