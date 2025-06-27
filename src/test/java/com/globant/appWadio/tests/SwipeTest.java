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
        swipeScreen.swipeFromRightToLeft();
        softAssert.assertEquals(swipeScreen.getLblLastCard(),"COMPATIBLE");
        System.out.println("Swipe left test executed successfully.");
    }
}
