package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComprarLivroPage
{

    @FindBy(xpath = "//a[contains(text(),'Books')]")
    private WebElement selecionaLivrosBtn;


    @FindBy(linkText = "Desktops")
    private WebElement selecionaDesktopsBtn;

    @FindBy(xpath = "//a[contains(@href, '/computers')]")
    private WebElement selecionaComputerBtn;

    @FindBy(xpath = "//a[contains(@href, '/electronics')]")
    private WebElement selecionaEletronicsBtn;


    @FindBy(linkText = "Cell phones")
    private WebElement selecionaCellphonesBtn;

    @FindBy(xpath = "//a[contains(@href, '/apparel-shoes')]")
    private WebElement selecionaApparelShoesBtn;


    @FindBy(xpath = "//li[5]/a")
    private WebElement selecionaDigitalDownloadsBtn;


    @FindBy(xpath = "//a[contains(@href, '/jewelry')]")
    private WebElement selecionaJewelryBtn;


    @FindBy(xpath = "//a[contains(@href, '/gift-cards')]")
    private WebElement selecionaGiftCardsBtn;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement livroBtn;


    @FindBy(xpath = "//li[@id='topcartlink']/a/span")
    private WebElement carrinhoDeCompraLInk;

    @FindBy(linkText = "Computing and Internet")
    private WebElement livroCompradoLink;


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


    public WebElement getLivroCompradoLink() {
        return livroCompradoLink;
    }


    public WebElement getSelecionaDesktopsBtn() {
        return selecionaDesktopsBtn;
    }

    public WebElement getSelecionaComputerBtn() {
        return selecionaComputerBtn;
    }

    public WebElement getSelecionaEletronicsBtn() {
        return selecionaEletronicsBtn;
    }

    public WebElement getSelecionaCellphonesBtn() {
        return selecionaCellphonesBtn;
    }

    public WebElement getSelecionaApparelShoesBtn() {
        return selecionaApparelShoesBtn;
    }

    public WebElement getSelecionaDigitalDownloadsBtn() {
        return selecionaDigitalDownloadsBtn;
    }

    public WebElement getSelecionaJewelryBtn() {
        return selecionaJewelryBtn;
    }

    public WebElement getSelecionaGiftCardsBtn() {
        return selecionaGiftCardsBtn;
    }

}
