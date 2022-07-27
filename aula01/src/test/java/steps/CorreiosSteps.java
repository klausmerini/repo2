package steps;

import apis.ApiParams;
import apis.ApiRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorreiosSteps extends ApiRequest {
    PropertiesUtils prop = new PropertiesUtils();
    ApiParams apiParams = new ApiParams();

    @Given("que possuo um token valido")
    public void que_possuo_um_token_valido() {
        System.out.println("que_possuo_um_token_valido - API nao requer token ");
    }

    @When("envio um request com dados validos")
    public void envio_um_request_com_dados_validos() {
        super.uri = prop.getProp("url_correios");
        super.params = apiParams.CorreiosParams();
        super.GET();
    }

    @Then("o valor do frete deve ser calculado")
    public void o_valor_do_frete_deve_ser_calculado() {

        Float valorFloat = Float.parseFloat(response.xmlPath().getString("Servicos.cServico.Valor").replace(",", "."));
        assertTrue(valorFloat > 0);
    }

    @And("o status code deve ser {int}")
    public void oStatusCodeDeveSer(Integer statudCodeEsoerado) {
        assertEquals(statudCodeEsoerado, response.statusCode());
    }

    @When("envio um request com dados validos DataTable")
    public void envioUmRequestComDadosValidosDataTable(DataTable dataTable) {
        super.uri = prop.getProp("url_correios");
        super.params = apiParams.setParams(dataTable.asMaps().get(0));
        super.GET();
    }

    @Then("o valor do frete deve ser {string}")
    public void oValorDoFreteDeveSer(String valor) {
        assertEquals(valor, response.xmlPath().getString("Servicos.cServico.Valor"));
    }

    @When("envio um request com dados {string},{string}")
    public void envioUmRequestComDados(String cepOrigem, String cepDestino) {
        super.uri = prop.getProp("url_correios");
        super.params = apiParams.CorreiosParams();
        super.params.put("sCepOrigem", cepOrigem);
        super.params.put("sCepDestino", cepDestino);
        super.GET();
    }

    @Then("deve ser exibida a {string}")
    public void deveSerExibidaA(String msgEsperada) {
        assertEquals(msgEsperada, response.xmlPath().getString("Servicos.cServico.MsgErro"));
    }
}
