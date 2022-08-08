package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.SearchFuncionalidade;

public class SearchSteps
{
    SearchFuncionalidade funcionalidade = new SearchFuncionalidade();
    @Entao("^preencho o campo Search com valor valido$")
    public void preencho_o_campo_Search() throws Throwable
    {
       funcionalidade.preencheCampoSearch();
    }

    @E("^clico em Search$")
    public void clico_em_Search() throws Throwable
    {
       funcionalidade.clicaSearch();
    }

    @Entao("^site exibe lista de opções$")
    public void site_exibe_lista_de_opções() throws Throwable
    {

    }

    @Entao("^usuario seleciona um camcorder$")
    public void usuarioSelecionaUmCamcorder() {
    }
}
