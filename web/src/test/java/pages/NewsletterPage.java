package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage
{
    public NewsletterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "newsletter-email")
    private WebElement campoEmailNewsletter;

    @FindBy(id = "newsletter-subscribe-button")
    private WebElement newsletterSubscribeBtn;


    @FindBy(id = "newsletter-result-block")
    private WebElement newsletterResposta;

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
