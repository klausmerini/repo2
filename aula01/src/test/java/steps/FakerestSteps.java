package steps;

import Activities.Activity;
import apis.ApiHeaders;
import apis.ApiRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import user.UsersConstructor;
import utils.JsonUtils;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakerestSteps extends ApiRequest
{

    PropertiesUtils props = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();

    JSONObject atividadeEnvioJson;
    String url;


    @Then("a atividade deve ser alterada com sucesso")
    public void aAtividadeDeveSerAlteradaComSucesso() throws JSONException
    {
        assertEquals(atividadeEnvioJson.getBoolean("completed"), response.jsonPath().get("completed"));
        assertEquals(atividadeEnvioJson.getString("title"), response.jsonPath().get("title"));
    }
    @Then(": a atividade deve ser criada corretamente")
    public void a_atividade_deve_ser_criada_corretamente() throws JSONException {
        assertEquals(atividadeEnvioJson.getString("title"), response.jsonPath().get("title"));
        assertEquals(atividadeEnvioJson.getString("dueDate"), response.jsonPath().get("dueDate"));
        assertEquals(atividadeEnvioJson.getBoolean("completed"), response.jsonPath().get("completed"));

    }


    @When("altero os dados da atividade")
    public void altero_os_dados_da_atividade() throws JSONException {
        String idSt ="30"; //(response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("aAtividadeDeveSerAlteradaComSucesso id : " + idSt);
        super.headers = apiHeaders.fakerestHeaders(token);
        super.uri = props.getProp("url_fakerest") +
                "/" + idSt;//userId;
        super.body=new JSONObject();
        super.body.put("completed", false);
        super.body.put("title", faker.job().field());
        atividadeEnvioJson = super.body;
        System.out.println(body.toString());
        System.out.println(super.uri);
        super.PUT();
    }


    @When("altero um ou mais dados da atividade")
    public void alteroUmOuMaisDadosDaAtividade() throws JSONException {
        String idSt ="30"; //(response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("aAtividadeDeveSerAlteradaComSucesso id : " + idSt);
        super.headers = apiHeaders.fakerestHeaders(token);
        super.uri = props.getProp("url_fakerest") +
                "/" + idSt;//userId;
        super.body=new JSONObject();
        super.body.put("completed", false);
        super.body.put("title", faker.job().field());
        atividadeEnvioJson = super.body;
        System.out.println(body.toString());
        System.out.println(super.uri);
        super.PATCH();
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


    @When("deleto essa atividade")
    public void deletoEssaAtividade()
    {
        String idSt = "30";//(response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("deletoEssaAtividade id : " + idSt);
        super.uri = props.getProp("url_fakerest") +
                "/" + idSt;//userId;
        super.headers = apiHeaders.fakerestHeaders("");
        //  super.body = new JSONObject();
        super.DELETE();
    }

    @When(": Envio um request de cadastro de atividades com dados validos")
    public void envio_um_request_de_cadastro_de_atividades_com_dados_validos() throws JSONException {
        super.uri = props.getProp("url_fakerest");
        super.headers = apiHeaders.fakerestHeaders(token);

        setaBodyFakerest();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        atividadeEnvioJson = super.body;
        super.POST();
    }
    @Given("existe a atividade cadastrada na API")
    public void existe_a_atividade_cadastrada_na_api() {
        System.out.println("existe_a_atividade_cadastrada_na_api");
    }

    @Then("os dados da atividade devem ser retornados")
    public void os_dados_da_atividade_devem_ser_retornados() {
        assertEquals("Activity 4",response.jsonPath().get("title"));
    }

    public void setaBodyFakerest() throws JSONException
    {
        Activity activity = new Activity();
        activity.setCompleted(true);
        activity.setDueDate("2021-07-11T19:19:48.751Z");
        activity.setId(faker.number().numberBetween(31,1000000000));
        activity.setTitle(faker.commerce().productName());

        super.body = activity.getJson();
        System.out.println("fakerest setaBodyVersaoGetterAndSetter() "+body.toString());
    }

    @Then("a atividade e deletada corretamente")
    public void aAtividadeEDeletadaCorretamente()
    {

    }


    @Given("existe a atividade cadastrado na API")
    public void existeAAtividadeCadastradoNaAPI() {
    }

}
