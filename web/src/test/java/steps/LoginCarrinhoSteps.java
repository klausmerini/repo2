package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.LoginCarrinhoFuncionalidade;

public class LoginCarrinhoSteps
{
    private LoginCarrinhoFuncionalidade loginFuncionalidade= new LoginCarrinhoFuncionalidade();


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
    }

    @Entao("^site loga usuario com sucesso$")
    public void site_loga_usuario_com_sucesso() throws Throwable {
        System.out.println("site_loga_usuario_com_sucesso");
    }


}
