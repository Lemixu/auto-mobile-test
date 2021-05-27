package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static final String
    LOGIN_BUTTON = "xpath://a[text()='Log in']",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "id:wpLoginAttempt";

    public void clickAuthButton() {
        this.tryClickElementWithFewAttempts(LOGIN_BUTTON, "Cannot find the auth button", 5);
//        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find the auth button", 5);
//        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click the auth button", 5);
    }

    public void enterLoginData(String login, String password) throws InterruptedException {
        this.waitForElementAndSenKeys(LOGIN_INPUT, login, "Cannot find and put the login to the login input", 5);
        Thread.sleep(1000);
        this.waitForElementAndSenKeys(PASSWORD_INPUT, login, "Cannot find and put the password to the password input", 5);
    }

    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click auth button", 5);
    }
}
