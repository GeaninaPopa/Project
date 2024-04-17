import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

  @FindBy(css=".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginButton;
    public void clickLoginButton(){
        loginButton.click();
    }
    @FindBy(id= "user-name")
    private WebElement usernameButton;
    public void setUsernameButton(){
        usernameButton.sendKeys("dino");
    }
    @FindBy(id="password")
    private WebElement passwordButton;
    public void setPasswordButton(){
        passwordButton.sendKeys("choochoo");
    }
    @FindBy(id="password")
    private WebElement incorrectPaswoard;
    public void setIncorrectPaswoard(){
        incorrectPaswoard.sendKeys("chocho");

    }
    @FindBy(css= ".btn.btn-primary")
    private WebElement loginIcon;
    public void clickLoginIcon(){
        loginIcon.click();
    }
    @FindBy(linkText= "dino")
    private WebElement correctName;
    public WebElement getCorrectName(){
        return correctName;
    }
    @FindBy(css=".error")
    private WebElement loginErrorMessage;
    public WebElement getLoginErrorMessage(){
        return loginErrorMessage;
    }
}
