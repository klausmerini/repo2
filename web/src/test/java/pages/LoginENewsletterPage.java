package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginENewsletterPage {
    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(id = "Email")
    private WebElement emailTxtField;

    @FindBy(id = "Password")
    private WebElement PasswordTxtField;


    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginBtn;


    @FindBy(xpath = "//a[@href=\"/customer/info\"]")
    private WebElement txtUsuarioLogado;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logoutLink;


    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement verificaLogoutTxt;

    public LoginENewsletterPage(WebDriver driver) {
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



    public WebElement getTxtUsuarioLogado() { return txtUsuarioLogado; }

    public WebElement getLogoutLink() { return logoutLink;  }

    public WebElement getVerificaLogoutTxt() {
        return verificaLogoutTxt;
    }

}
