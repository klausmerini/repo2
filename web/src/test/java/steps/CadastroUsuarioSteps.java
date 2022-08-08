package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.AdicionarContasFuncionalidade;
import funcionalidades.CompraLivroFuncionalidade;
import funcionalidades.ORIGINALLoginFuncionalidade;

import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CadastroUsuarioSteps {

    private ORIGINALLoginFuncionalidade login;
    private AdicionarContasFuncionalidade addContas;

    private CompraLivroFuncionalidade compralivro;


    public CadastroUsuarioSteps() {
        this.login = new ORIGINALLoginFuncionalidade();
        this.addContas = new AdicionarContasFuncionalidade();
    }

    @Dado("^que estou logado com usuario \"([^\"]*)\"$")
    public void que_estou_logado_com_usuario(String user) {
        this.login.LoginSrBarriga(user);
    }

    @Dado("^clico em adicionar um novo usuario$")
    public void clico_em_adicionar_um_novo_usuario() throws InterruptedException, IOException, AWTException {
        this.addContas.clickAdicionar();
    }

    @Quando("^adiciono o novo usuario")
    public void adicionoONovoUsuario() throws InterruptedException, IOException, AWTException {
        this.addContas.adicionarUsuario();
    }

    @Entao("^apresanta a mensagem \"([^\"]*)\"$")
    public void apresanta_a_mensagem(String msg) throws InterruptedException, IOException, AWTException {
        assertEquals(msg, this.addContas.obterTextoConfirmacao());
    }


}
