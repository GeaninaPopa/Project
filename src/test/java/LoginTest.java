import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.setUsernameButton();
        loginPage.setPasswordButton();
        loginPage.clickLoginIcon();
        assertEquals(loginPage.getCorrectName().getText(), "dino");
    }

    @Test
    public void negativeLoginTest1() throws InterruptedException {
        loginPage.clickLoginButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "informatii");
        loginPage.setPasswordButton();
        loginPage.clickLoginIcon();
        assertEquals(loginPage.getLoginErrorMessage().getText(), "Please fill in the username!");

    }
    @Test
    public void negativeLoginTest2() throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.setUsernameButton();
        loginPage.clickLoginIcon();
        assertEquals( loginPage.getLoginErrorMessage().getText(),"Please fill in the password!");
    }
    @Test
    public void negativeLoginTest3() throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.setUsernameButton();
        loginPage.setIncorrectPaswoard();
        loginPage.clickLoginIcon();
        assertEquals(loginPage.getLoginErrorMessage().getText(), "Incorrect username or password!");
    }
}