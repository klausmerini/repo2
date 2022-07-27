package steps;

import apis.ApiHeaders;
import apis.ApiRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import user.Users;
import user.UsersConstructor;
import user.UsersGetterSetter;
import user.UsersLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GorestSteps extends ApiRequest {
    PropertiesUtils props = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    //    JSONObject userOriginal;
    UsersLombok userLombokEnvio;
    JSONObject userEnvioJson;
    UsersConstructor usersConstructorEnvio;

    @When("altero os dados do usuario")
    public void alteroOsDadosDoUsuario() throws JSONException {
        String idSt = (response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("alteroOsDadosDoUsuario id : " + idSt);
        super.headers = apiHeaders.gorestHeaders(token);
        super.uri = props.getProp("uri_gorest") +
                "/" + idSt;//userId;
        super.body.put("status", "inactive");
 //       super.body.put("id", Integer.valueOf(idSt));
        userLombokEnvio.setStatus("inactive");

        System.out.println(body.toString());
        super.PUT();
    }

    @When("altero um ou mais dados do usuario")
    public void alteroUmOuMaisDadosDoUsuario() throws JSONException {
        String idSt = (response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("alteroUmOuMaisDadosDoUsuario id : " + idSt);
        super.headers = apiHeaders.gorestHeaders(token);
        super.uri = props.getProp("uri_gorest") +
                "/" + idSt;//userId;
        super.body = new JSONObject("{\"gender\":\"female\"}");
        super.body.put("gender", "female");
        userEnvioJson.put("gender", "female");
        userLombokEnvio.setGender("female");
        System.out.println(body.toString());
        super.PATCH();
    }

    public void assertLombok()
    {
        System.out.println("assertLombok");
        UsersLombok userLombokResponse = response.jsonPath().getObject("data",UsersLombok.class);
        assertEquals(userLombokEnvio.toString(), userLombokResponse.toString());
    }

    public void assertConstructor()
    {
        System.out.println("assertConstructor");
        UsersConstructor userConstructorRetorno =  response.jsonPath().getObject("data",UsersConstructor.class);
        assertEquals(usersConstructorEnvio, userConstructorRetorno );

        System.out.println(usersConstructorEnvio);
        System.out.println(userConstructorRetorno);
    }

    @When("buscar esse usuario")
    public void buscar_esse_usuario() {
        String idSt = (response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("buscar_esse_usuario id : " + idSt);
        super.uri = props.getProp("uri_gorest") +
                "/" + idSt;//userId;
        super.headers = apiHeaders.gorestHeaders(token);
        super.GET();
    }


    @When("deleto esse usuario")
    public void deletoEsseUsuario() {
        String idSt = (response.jsonPath().getJsonObject("data.id")).toString();
        System.out.println("deletoEsseUsuario id : " + idSt);
        super.uri = props.getProp("uri_gorest") +
                "/" + idSt;//userId;
        super.headers = apiHeaders.gorestHeaders(token);
        super.body = new JSONObject();
        super.DELETE();
    }

    @When("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() throws JSONException, IOException
    {
        super.uri = props.getProp("uri_gorest");
        super.headers = apiHeaders.gorestHeaders(token);


        //    super.body = jsonUtils.parseJsonFile();
        //     super.body.put("email",faker.internet().emailAddress());

           setaBodyLombok();
    //         setaBodyVersaoUserObject();
        //     setaBodyLombokXml();
 //       setaBodyVersaoGetterAndSetter();


        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        userEnvioJson = super.body;
        super.POST();
    }


    @Given("existe o usuario cadastrado na API")
    public void existe_o_usuario_cadastrado_na_api() throws JSONException, IOException {
        System.out.println("existe_o_usuario_cadastrado_na_api()");
        envio_um_request_de_cadastro_de_usuario_com_dados_validos();
    }


    @Then("os dados do usuario devem ser retornados")
    public void os_dados_do_usuario_devem_ser_retornados() throws JSONException {
        System.out.println("os_dados_do_usuario_devem_ser_retornados()");
        o_usuario_deve_sr_criado_corretamente();

    }


    @Then("o status code do request deve ser {int}")
    public void o_status_code_do_request_dve_ser(Integer statusesperado) {
        assertEquals(statusesperado, response.getStatusCode(), "Status code diferente do esperedo");
    }

    @Then("o usuario deve sr criado corretamente")
    public void o_usuario_deve_sr_criado_corretamente() throws JSONException {
        //   JSONObject userRetorno=response.jsonPath().getJsonObject("data");
//        assertEquals(userRetorno, userEnvio);
        //      assertEquals(userEnvioJson, userRetorno);
        System.out.println("o_usuario_deve_sr_criado_corretamente");

        assetJson();
        assertLombok();
 //       assertConstructor();

        System.out.println(userEnvioJson.getString("status") + " , " + response.jsonPath().get("data.status"));
        assertEquals(userEnvioJson.getString("status"), response.jsonPath().get("data.status"));
        assertEquals(userEnvioJson.getString("email"), response.jsonPath().get("data.email"));
        assertEquals(userEnvioJson.getString("name"), response.jsonPath().get("data.name"));
        assertEquals(userEnvioJson.getString("gender"), response.jsonPath().get("data.gender"));
    }

    private void assetJson()
    {

        JSONObject userRetorno = new JSONObject(response.getBody().asString());
        userRetorno.getJSONObject("data").remove("id");
        assertEquals(body.toString(), userRetorno.getJSONObject("data").toString() );
    }

    @Then("o usuario deve ser alterado com sucesso")
    public void o_usuario_deve_ser_alterado_com_sucesso() throws JSONException {

        System.out.println("o_usuario_deve_ser_alterado_com_sucesso");
        o_usuario_deve_sr_criado_corretamente();
    }


    @Then("o usuario e deletado corretamente")
    public void oUsuarioEDeletadoCorretamente() {
        System.out.println("response : " + response.asString());
        assertEquals("", response.asString());
    }


    @Given("Que possuo gorest token valido")
    public void que_possuo_gorest_token_valido() {
        token = props.getProp("token_gorest");
    }

    public void setaBodyVersaoUserObject() throws JSONException {
        UsersConstructor user = new UsersConstructor(faker.internet().emailAddress(),
                "male",
                faker.name().fullName(),
                "active");
        super.body = user.getJson();
        usersConstructorEnvio=user;
        System.out.println("goreststeps.setaBodyCersaoUserObject()");
    }

    public void setaBodyVersaoGetterAndSetter() throws JSONException {
        UsersGetterSetter user = new UsersGetterSetter();
        user.setEmail(faker.internet().emailAddress());
        user.setGender("male");
        user.setName(faker.name().fullName());
        user.setStatus("active");

        super.body = user.getJson();
        System.out.println("goreststeps.setaBodyVersaoGetterAndSetter()");
    }

    public void setaBodyLombok() throws JSONException {
        userLombokEnvio = UsersLombok.builder()
                .email(faker.internet().emailAddress())
                .name(faker.name().fullName())
                .gender("male")
                .status("active")
                .build();
        super.body = new JSONObject(new Gson().toJson(
                userLombokEnvio
//                UsersLombok.builder()
//                        .email(faker.internet().emailAddress())
//                        .name(faker.name().fullName())
//                        .gender("male")
//                        .status("active")
//                .build()
        ));
        //userOriginal=super.body;

    }
    public void setaBodyLombokXml() throws JSONException {
        userLombokEnvio = UsersLombok.builder()
                .email(faker.internet().emailAddress())
                .name(faker.name().fullName())
                .gender("male")
                .status("active")
                .build();
        super.body = new JSONObject(new Gson().toJson(userLombokEnvio));
        String xml= XML.toString(super.body);
        System.out.println(xml);
    }

    public void setaBodyXml()
    {

        String xml = new UsersConstructor(faker.internet().emailAddress(),
                "female",
                faker.name().fullName(),
                "active").getXml();
        System.out.println(xml);

    }


    private UsersConstructor pegaUserDoResponse() {
        //new Gson().toJson(response.jsonPath().getObject("data");
        return response.jsonPath().getObject("data", UsersConstructor.class);
    }


}
