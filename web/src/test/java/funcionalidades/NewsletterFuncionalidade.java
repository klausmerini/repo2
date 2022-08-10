package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.NewsletterPage;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;

public class NewsletterFuncionalidade extends BaseTest
{
   // NewsletterPage newsletterPage;
    public void clicaSubscribeBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterPage.getNewsletterSubscribeBtn()));
        newsletterPage.getNewsletterSubscribeBtn().click();
    }

    public void preencheCampoSubscribeNewsletter() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable( newsletterPage.getCampoEmailNewsletter()));
        newsletterPage.getCampoEmailNewsletter().click();
        newsletterPage.getCampoEmailNewsletter().sendKeys("klya@ya.mem");
        espera2s();
    }
    public void verificaRespostaNewsletter() throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElement(newsletterPage.getNewsletterResposta(),"Thank you for signing up! A verification email has been sent. We appreciate your interest."));
        String respostaSt = newsletterPage.getNewsletterResposta().getText();
        assertEquals("Thank you for signing up! A verification email has been sent. We appreciate your interest.", respostaSt);
        System.out.println(respostaSt);
        espera2s();
    }
}
