package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginENewsletterPage;
import utils.BaseTest;

import static org.junit.Assert.assertEquals;

public class LoginFuncionalidade extends BaseTest {
    LoginENewsletterPage loginpage;

    public LoginFuncionalidade() {
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



    public void clicaLoginBtn() throws InterruptedException {
         wait.until(ExpectedConditions.elementToBeClickable( loginpage.getLoginBtn()));
        loginpage.getLoginBtn().click();
    }

    public void clicaLogoutBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable( loginpage.getLogoutLink()));
        loginpage.getLogoutLink().click();
    }


    public void verificaLogin()
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getTxtUsuarioLogado()));
        String UsuarioLoginSt = loginpage.getTxtUsuarioLogado().getText();
        System.out.println("pega login : "+UsuarioLoginSt);
        String expectedSt = "johan@yahoo.com";
        assertEquals(expectedSt, UsuarioLoginSt);
        espera5s();
    }

    public void verificaLogout( String expectedSt)
    {
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.getVerificaLogoutTxt()));
        String UsuarioLoginSt = loginpage.getVerificaLogoutTxt().getText();
        System.out.println("verificaLogout: "+UsuarioLoginSt);
        assertEquals(expectedSt, UsuarioLoginSt);
        espera5s();
    }
}
