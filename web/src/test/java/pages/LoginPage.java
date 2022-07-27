package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(id = "Email")
    private WebElement emailTxtField;

    @FindBy(id = "Password")
    private WebElement PasswordTxtField;


    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }


    public WebElement getPasswordTxtField() {
        return PasswordTxtField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

}
