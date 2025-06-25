package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Sign up\")")
    private WebElement SignUpTap;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement txtInputEmail;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement txtInputPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement txtInputRepeatPassword;

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").instance(17)")
    private WebElement btnSingUp;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/alertTitle\")")
    private WebElement alertTitle;

    @AndroidFindBy(uiAutomator = "resourceId(\"android:id/message\")")
    private WebElement lblAlertMessage;

    @AndroidFindBy(id ="android:id/message")
    private WebElement lblAlertMessage2;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement btnAlert;

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").instance(17)")
    private WebElement btnLogin;

    private String randomEmail;
    private String randomPassword;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is used to tap on the "Sign Up" tab.
     */
    public void tapOnSignUpTab() {
        if (waitForElementToAppear(SignUpTap)) {
            System.out.println("Sign Up button is visible, proceeding to click.");
        } else {
            System.out.println("Sign Up button is not visible, cannot proceed.");
        }
        SignUpTap.click();
    }

    /**
     * This method is used to enter the email, password and confirm the password in the sign-up form.
     */
    public void inputDetails(String email, String password) {
        try{
            if (waitForElementToAppear(txtInputRepeatPassword)) {
                System.out.println("Proceeding to enter email.");
                txtInputEmail.sendKeys(email);
                System.out.println("Proceeding to enter password.");
                txtInputPassword.sendKeys(password);
                System.out.println("Proceeding to enter repeat password.");
                txtInputRepeatPassword.sendKeys(password);
            } else{
                System.out.println("Proceeding to enter email.");
                txtInputEmail.sendKeys(email);
                System.out.println("Proceeding to enter password.");
                txtInputPassword.sendKeys(password);
            }
        }catch (Exception e){
            System.out.println("An error occurred while entering details: " + e.getMessage());
        }
    }

    /**
     * This method is used to create random email may be generated.
     * or an action should be done after the test to delete the created account.
     */
    public void randonInput(){
        randomEmail = "test" + System.currentTimeMillis() + "@example.com";
        randomPassword = "password" + System.currentTimeMillis();
        inputDetails(randomEmail, randomPassword);
    }

    public void tapOnLoginButton() {
        randonInput();
        btnLogin.click();
    }

    /**
     * This method is used to tap on the "Sign Up" button.
     */
    public void tapOnSignUpButton() {
        randonInput();
        btnSingUp.click();
    }

    /**
     * This method is used to verify the alert message after signing up.
     */
    public String getAlertMessage() {
        try{
            waitForElementToAppear(alertTitle);
            System.out.println("Alert message element is visible.");
            String message = lblAlertMessage.getDomAttribute("text");
            btnAlert.click();
            return message;

        } catch (Exception e) {
            System.out.println("Alert message not found.");
            return null;
        }
    }

}
