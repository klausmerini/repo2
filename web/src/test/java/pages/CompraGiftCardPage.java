package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraGiftCardPage
{


    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement  selecionaProdGiftCards;


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

    public CompraGiftCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
