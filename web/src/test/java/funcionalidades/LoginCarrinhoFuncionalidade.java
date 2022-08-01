package funcionalidades;

import pages.ComprarLivroPage;
import pages.LoginPage;
import utils.BaseTest;

public class LoginCarrinhoFuncionalidade extends BaseTest
{
    LoginPage loginpage ;

    public LoginCarrinhoFuncionalidade()
    {
        this.loginpage = new LoginPage(webDriver);
    }

    public void clicaLogin() throws InterruptedException {
        loginpage.getLoginLink().click();
        Thread.sleep(500);
    }

    public void preencheCamposLogin() throws InterruptedException {
        Thread.sleep(500);
        loginpage.getEmailTxtField().sendKeys("johan@yahoo.com");
        Thread.sleep(500);
    }


    public void preencheCamposPassword() throws InterruptedException {
        Thread.sleep(500);
        loginpage.getPasswordTxtField().sendKeys("123456");
        Thread.sleep(500);
    }

    public void clicaLoginBtn() throws InterruptedException {
        Thread.sleep(500);
        loginpage.getLoginBtn().click();
        Thread.sleep(500);
    }

}
