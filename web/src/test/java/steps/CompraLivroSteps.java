package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.CarrinhoDeComprasFuncionalidade;

public class CompraLivroSteps {
    private CarrinhoDeComprasFuncionalidade compralivroFunc;


    @Dado("^que estou no site demowebshop$")
    public void que_estou_no_site_demowebshop() throws Throwable {
        System.out.println("que_estou_no_site_demowebshop");

        this.compralivroFunc = new CarrinhoDeComprasFuncionalidade();
        compralivroFunc.abrePagina();
    }

    @E("^clico em books$")
    public void clicoEmBooks()
    {

        compralivroFunc.selecionaCategoriaLivros();
    }

    @Entao("^seleciono um livro$")
    public void selecionoUmLivro() throws InterruptedException {
        compralivroFunc.selecionaLivroAction();
    }

    @Entao("^site adiciona o livro ao carrinho de compras$")
    public void siteAdicionaOLivroAoCarrnhoECompras() throws InterruptedException {
        compralivroFunc.confirmaCompraAction();
    }


    @E("^clico em cada menu selecionando um produto de cada menu$")
    public void clicoEmCadaMenuSelecionandoUmProdutoDeCadaMenu() throws InterruptedException {
    //    compralivroFunc.compraVariosProdAction();
    }

    @E("^clico em cada menu selecionando todos produtos de cada menu$")
    public void clicoEmCadaMenuSelecionandoTodosProdutosDeCadaMenu() throws InterruptedException {
        compralivroFunc.compraTodosProdAction();
    }

    @Entao("^site adiciona os produtos ao carrinho de compras$")
    public void siteAdicionaOsProdutosAoCarrinhoDeCompras() throws InterruptedException {
        compralivroFunc.entraNoCarrinho();
    }

    @Entao("^site adiciona os produtos \\(todos\\) ao carrinho de compras$")
    public void siteAdicionaOsProdutosTodosAoCarrinhoDeCompras() throws InterruptedException {
        compralivroFunc.pegaQtdCarrinho();
        compralivroFunc.entraNoCarrinho();

    }
}