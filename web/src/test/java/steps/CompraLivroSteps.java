package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.CompraLivroFuncionalidade;

public class CompraLivroSteps {
    private CompraLivroFuncionalidade compralivro;

    @Dado("^que estou no site demowebshop$")
    public void que_estou_no_site_demowebshop() throws Throwable {
        System.out.println("que_estou_no_site_demowebshop");

        this.compralivro = new CompraLivroFuncionalidade();
        compralivro.abrePagina();
    }

    @E("^clico em books$")
    public void clicoEmBooks()
    {

        compralivro.compraLivroAction();
    }

    @Entao("^seleciono um livro$")
    public void selecionoUmLivro() throws InterruptedException {
        compralivro.selecionaLivroAction();
    }

    @Entao("^site adiciona o livro ao carrnho e compras$")
    public void siteAdicionaOLivroAoCarrnhoECompras() throws InterruptedException {
        compralivro.confirmaCompraAction();
    }


    @E("^clico em register$")
    public void clicoEmRegister() throws InterruptedException {
        compralivro.clicaEmRegister();
    }

    @Entao("^preencho os campos corretamente$")
    public void preenchoOsCamposCorretamente()
    {
        try {
            compralivro.selecionaGenderMale();
            compralivro.preencheCamposReg();
        }
        catch (InterruptedException e) {      throw new RuntimeException(e);      }
    }

    @Entao("^site inclui usuario com sucesso$")
    public void siteIncluiUsuarioComSucesso() throws InterruptedException {
        compralivro.clicaEmContinue();
    }

    @E("^clico em cada menu selecionando um produto de cada menu$")
    public void clicoEmCadaMenuSelecionandoUmProdutoDeCadaMenu() throws InterruptedException {
        compralivro.compraVariosProdAction();
    }

    @E("^clico em cada menu selecionando todos produtos de cada menu$")
    public void clicoEmCadaMenuSelecionandoTodosProdutosDeCadaMenu() throws InterruptedException {
        compralivro.compraTodosProdAction();
    }

    @Entao("^site adiciona os produtos ao carrinho de compras$")
    public void siteAdicionaOsProdutosAoCarrinhoDeCompras() throws InterruptedException {
        compralivro.entraNoCarrinho();
    }

    @Entao("^site adiciona os produtos \\(todos\\) ao carrinho de compras$")
    public void siteAdicionaOsProdutosTodosAoCarrinhoDeCompras() throws InterruptedException {
        compralivro.pegaQtdCarrinho();
        compralivro.entraNoCarrinho();

    }
}