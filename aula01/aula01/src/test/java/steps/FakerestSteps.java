package steps;

import Activities.Activity;
import apis.ApiHeaders;
import apis.ApiRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import user.UsersGetterSetter;
import user.UsersLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;

public class FakerestSteps extends ApiRequest
{

    PropertiesUtils props = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();

    JSONObject userEnvioJson;
    String url;
    @Then(": a atividade deve ser criada corretamente")
    public void a_atividade_deve_ser_criada_corretamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("buscar essa atividade")
    public void buscar_essa_atividade() {
        String idSt = "4";//(response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("buscar_essa_atividade(engessado) id : " + idSt);
        super.uri = props.getProp("url_fakerest") +
                "/" + idSt;//userId;
        super.headers = apiHeaders.fakerestHeaders(token);
        super.GET();
    }

    @When(": Envio um request de cadastro de atividades com dados validos")
    public void envio_um_request_de_cadastro_de_atividades_com_dados_validos() throws JSONException {
        super.uri = props.getProp("url_fakerest");
        super.headers = apiHeaders.fakerestHeaders(token);

        setaBodyVersaoGetterAndSetter();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
      //  userEnvioJson = super.body;
        super.POST();
    }
    @Given("existe a atividade cadastrada na API")
    public void existe_a_atividade_cadastrada_na_api() {
        System.out.println("existe_a_atividade_cadastrada_na_api");
    }

    @Then("os dados da atividade devem ser retornados")
    public void os_dados_da_atividade_devem_ser_retornados() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    public void setaBodyVersaoGetterAndSetter() throws JSONException
    {
        Activity activity = new Activity();
        activity.setCompleted(true);
     //   activity.setDueDate();
        activity.setId(337);
        activity.setTitle("test api fakerest");

        super.body = activity.getJson();
        System.out.println("fakerest setaBodyVersaoGetterAndSetter() "+body.toString());
}

}
