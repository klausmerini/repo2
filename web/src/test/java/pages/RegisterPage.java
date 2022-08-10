package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
    public RegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(id = "gender-male")
    private WebElement genderMalesRadioBtn;
    @FindBy(id = "FirstName")
    private WebElement firstNameCampo;
    @FindBy(id = "LastName")
    private WebElement lastNameCampo;
    @FindBy(id = "Email")
    private WebElement emailCampo;
    @FindBy(id = "Password")
    private WebElement passwordCampo;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordCampo;


    @FindBy(id = "register-button")
    private WebElement finalizaRegistroBtn;



    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueRegistroBtn;

    public WebElement getFirstNameCampo() {
        return firstNameCampo;
    }

    public WebElement getLastNameCampo() {
        return lastNameCampo;
    }

    public WebElement getEmailCampo() {
        return emailCampo;
    }

    public WebElement getPasswordCampo() {
        return passwordCampo;
    }





    public WebElement getGenderMalesRadioBtn() {
        return genderMalesRadioBtn;
    }

    public WebElement getConfirmPasswordCampo() {
        return confirmPasswordCampo;
    }

    public WebElement getFinalizaRegistroBtn() {
        return finalizaRegistroBtn;
    }

    public WebElement getContinueRegistroBtn() {        return continueRegistroBtn;    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

}
