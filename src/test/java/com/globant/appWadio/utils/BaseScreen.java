package com.globant.appWadio.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseScreen {

    public AppiumDriver driver;
    protected static final int TIMEOUT = 10;
    protected WebDriverWait wait;

    public BaseScreen(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * This method is used to wait for an element to appear.
     */
    public boolean waitForElementToAppear(WebElement element) {
        try {
            WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
            return element1 != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is used to tap.
     */
    public void tap(WebElement element) {
        int centerX = element.getRect().getX() + element.getRect().getWidth() / 2;
        int centerY = element.getRect().getY() + element.getRect().getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY))//Aquí me muevo hacia el elemento
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(125))) // Pausa para simular un toque
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tapSequence));
    }

    /**
     * This method is used to swipe a finger from bottom to top.
     */
    public void swipeVertical() {
       PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(435, 1935);
        Point end = new Point(435, 348);
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    /**
     * This method is used to swipe a finger from left to right.
     */
    public void swipeHorizontal(WebElement element1, WebElement element2) {
        int centerXElement1 = element1.getRect().getX() + element1.getRect().getWidth() / 2;
        int centerYElement1 = element1.getRect().getY() + element1.getRect().getHeight() / 2;
        int centerXElement2 = element2.getRect().getX() + element2.getRect().getWidth() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), centerXElement1, centerYElement1))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(), centerXElement2, centerYElement1))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }
}
