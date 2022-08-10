package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.RegisterFuncionalidade;

public class RegisterSteps
{
    private RegisterFuncionalidade registerFunc = new RegisterFuncionalidade();

    @E("^clico em register$")
    public void clicoEmRegister() throws InterruptedException {
        registerFunc.clicaEmRegister();
    }

    @Entao("^preencho os campos corretamente$")
    public void preenchoOsCamposCorretamente()
    {
        try {
            registerFunc.selecionaGenderMale();
            registerFunc.preencheCamposReg();
        }
        catch (InterruptedException e) {      throw new RuntimeException(e);      }
    }



    @Entao("^site inclui usuario com sucesso$")
    public void siteIncluiUsuarioComSucesso() throws InterruptedException {
        registerFunc.clicaEmContinue();
    }

}
