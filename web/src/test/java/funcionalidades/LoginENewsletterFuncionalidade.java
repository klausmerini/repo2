package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginENewsletterPage;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;

public class LoginENewsletterFuncionalidade extends BaseTest {
    LoginENewsletterPage loginpage;

    public LoginENewsletterFuncionalidade() {
        this.loginpage = new LoginENewsletterPage(webDriver);
    }

    public void clicaLogin() throws InterruptedException {
        loginpage.getLoginLink().click();
    }

    public void preencheCamposLogin() throws InterruptedException {
         wait.until(ExpectedConditions.elementToBeClickable( loginpage.getEmailTxtField()));
        loginpage.getEmailTxtField().sendKeys("johan@yahoo.com");
    }

    public void preencheCamposPassword() throws InterruptedException {
         wait.until(ExpectedConditions.elementToBeClickable(loginpage.getPasswordTxtField()));
        loginpage.getPasswordTxtField().sendKeys("123456");
    }

    public void preencheCampoSubscribeNewsletter() throws InterruptedException {
         wait.until(ExpectedConditions.elementToBeClickable( loginpage.getCampoEmailNewsletter()));
        loginpage.getCampoEmailNewsletter().sendKeys("klya@ya.mem");
    }

    public void clicaLoginBtn() throws InterruptedException {
         wait.until(ExpectedConditions.elementToBeClickable( loginpage.getLoginBtn()));
        loginpage.getLoginBtn().click();
    }
    public void clicaSubscribeBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getNewsletterSubscribeBtn()));
        loginpage.getNewsletterSubscribeBtn().click();
    }
    public void verificaResposta() throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElement(loginpage.getNewsletterResposta(),"Thank you for signing up! A verification email has been sent. We appreciate your interest."));
        String respostaSt = loginpage.getNewsletterResposta().getText();
        assertEquals("Thank you for signing up! A verification email has been sent. We appreciate your interest.", respostaSt);
        System.out.println(respostaSt);
    }
}
