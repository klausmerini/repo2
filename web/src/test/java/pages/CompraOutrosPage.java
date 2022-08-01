package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraOutrosPage {
    @FindBy(linkText = "Accessories")
    private WebElement selecionaAcessoriosLink;

    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdAcessorioBtn;

    @FindBy(xpath = "//img[@alt='Picture for category Cell phones']")
    private WebElement selecionaCategCellphones;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement selecionaProdCategCellphones;


    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement selecionaProdCategApparelShoes;


    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdShoes;


    @FindBy(xpath = "(//input[@value='Add to cart'])[3]")
    private WebElement selecionaDigitalDownloadsProd;


    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdJewlery;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement selecionaProdGiftCards;


    @FindBy(id = "giftcard_1_RecipientName")
    private WebElement campoReciptNameGiftCards;



    @FindBy(id = "giftcard_1_RecipientEmail")
    private WebElement campoReciptEmailGiftCards;

    @FindBy(xpath = "//input[@id='add-to-cart-button-1']")
    private WebElement sendGiftCardsBtn;

    @FindBy(id = "giftcard_1_SenderName")
    private WebElement campoNameGiftCards;


    @FindBy(id = "giftcard_1_SenderEmail")
    private WebElement campoEmailGiftCards;


    public CompraOutrosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSelecionaAcessoriosLink() {
        return selecionaAcessoriosLink;
    }


    public WebElement getSelecionaProdAcessorioBtn() {
        return selecionaProdAcessorioBtn;
    }

    public WebElement getSelecionaCategCellphones() {
        return selecionaCategCellphones;
    }

    public WebElement getSelecionaProdCategCellphones() {
        return selecionaProdCategCellphones;
    }


    public WebElement getSelecionaProdCategApparelShoes() {
        return selecionaProdCategApparelShoes;
    }

    public WebElement getSelecionaProdShoes() {
        return selecionaProdShoes;
    }

    public WebElement getSelecionaDigitalDownloadsProd() {
        return selecionaDigitalDownloadsProd;
    }

    public WebElement getSelecionaProdJewlery() {
        return selecionaProdJewlery;
    }

    public WebElement getSelecionaProdGiftCards() {
        return selecionaProdGiftCards;
    }


    public WebElement getCampoReciptNameGiftCards() {
        return campoReciptNameGiftCards;
    }

    public WebElement getCampoReciptEmailGiftCards() {
        return campoReciptEmailGiftCards;
    }


    public WebElement getSendGiftCardsBtn() {
        return sendGiftCardsBtn;
    }



    public WebElement getCampoNameGiftCards() {
        return campoNameGiftCards;
    }

    public WebElement getCampoEmailGiftCards() {
        return campoEmailGiftCards;
    }
}
