package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.LoginFuncionalidade;

public class LoginCarrinhoSteps
{
    private LoginFuncionalidade loginFuncionalidade= new LoginFuncionalidade();


    @E("^clico em login$")
    public void clico_em_login() throws Throwable
    {
        loginFuncionalidade.clicaLogin();
        Thread.sleep(5000);
    }

    @E("^preencho os campos de login corretamente$")
    public void preencho_os_campos_de_login_corretamente() throws Throwable {
        System.out.println("preencho_os_campos_de_login_corretamente");
        loginFuncionalidade.preencheCamposLogin();
        loginFuncionalidade. preencheCamposPassword();
        loginFuncionalidade.clicaLoginBtn();
    }

    @Entao("^site loga usuario com sucesso$")
    public void site_loga_usuario_com_sucesso() throws Throwable {
        loginFuncionalidade.verificaLogin();
        System.out.println("site_loga_usuario_com_sucesso");
    }


    @E("^estou logado$")
    public void estouLogado() throws Throwable {
        clico_em_login();
        preencho_os_campos_de_login_corretamente();
    }

    @Entao("^faço o log out$")
    public void façoOLogOut() throws InterruptedException {
        loginFuncionalidade.clicaLogoutBtn();
    }

    @Entao("^site desloga usuario com sucesso$")
    public void siteDeslogaUsuarioComSucesso()
    {
        loginFuncionalidade.verificaLogout("Register");
    }
}
