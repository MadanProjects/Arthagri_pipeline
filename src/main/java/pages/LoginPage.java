package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "loginBtn")
    private WebElement loginButton;

    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOf(username))
                .sendKeys(user);

        wait.until(ExpectedConditions.visibilityOf(password))
                .sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();
    }
}
