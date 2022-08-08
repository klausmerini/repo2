package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginENewsletterPage
{
    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(id = "Email")
    private WebElement emailTxtField;

    @FindBy(id = "Password")
    private WebElement PasswordTxtField;


    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginBtn;

    @FindBy(id = "newsletter-email")
    private WebElement campoEmailNewsletter;

    @FindBy(id = "newsletter-subscribe-button")
    private WebElement newsletterSubscribeBtn;


    @FindBy(id = "newsletter-result-block")
    private WebElement newsletterResposta;
    public LoginENewsletterPage(WebDriver driver)
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

    public WebElement getCampoEmailNewsletter() {
        return campoEmailNewsletter;
    }

    public WebElement getNewsletterSubscribeBtn() {
        return newsletterSubscribeBtn;
    }

    public WebElement getNewsletterResposta() {
        return newsletterResposta;
    }


}
