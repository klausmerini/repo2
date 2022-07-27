package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComprarLivroPage
{

    @FindBy(xpath = "//a[contains(text(),'Books')]")
    private WebElement selecionaLivrosBtn;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement livroBtn;


    @FindBy(xpath = "//li[@id='topcartlink']/a/span")
    private WebElement carrinhoDeCompraLInk;

    @FindBy(linkText = "Computing and Internet")
    private WebElement livroCompradoLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    public ComprarLivroPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLivroBtn() {
        return livroBtn;
    }

    public WebElement getSelecionaLivrosBtn() {
        return selecionaLivrosBtn;
    }

    public WebElement getCarrinhoDeCompraLInk() {
        return carrinhoDeCompraLInk;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }


    public WebElement getLivroCompradoLink() {
        return livroCompradoLink;
    }

}
