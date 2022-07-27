package steps;

import Author.Author;
import apis.ApiHeaders;
import apis.ApiRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelo.Book;
import modelo.Coverphoto;
import modelo.User;
import org.json.JSONException;
import org.json.JSONObject;
import utils.JsonUtils;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeRestSteps extends ApiRequest {

    PropertiesUtils props = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();

    JSONObject objetoDeEnvioJson;
    String urlBook="url_fakerestBooks";
    String urlAuthor="url_fakerestAuthors";
    String urlBase="url_fakerestBase";

    @When("buscar esse autor")
    public void buscar_esse_autor()
    {
        String idSt = "30";//engessado, id retorna 0 e não salva  (response.jsonPath().getJsonObject("id")).toString();
        System.out.println("buscar_esse_autor id : " + idSt);
        super.uri = props.getProp(urlAuthor) + idSt;
        setaHeaders();
        super.GET();
    }

    @When("Envio um request de cadastro de autor com dados validos")
    public void envio_um_request_de_cadastro_de_autor_com_dados_validos() throws JSONException
    {
        setaUriAuthor();
        setaHeaders();
        setaBodyFakerest();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        objetoDeEnvioJson = super.body;
        super.POST();
    }

    private void setaBodyFakerest()
    {
        Author author = new Author(1,faker.name().firstName(),faker.name().lastName());
        super.body = author.getJson();
        System.out.println("author steps setaBody() "+body.toString());
    }

    private void setaHeaders()
    {
        super.headers = apiHeaders.fakerestHeaders(token);
    }

    private void setaUriAuthor()
    {
        super.uri = props.getProp(urlAuthor);
    }

    @Given("existe o autor cadastrado na API")
    public void existe_o_autor_cadastrado_na_api()
    {
        System.out.println("existe_o_autor_cadastrado_na_api engessado");
    }

    @Then("o autor deve ser criado corretamente")
    public void o_autor_deve_ser_criado_corretamente()
    {
        System.out.println("o_autor_deve_ser_criado_corretamente - "+response.getStatusLine());
        assertEquals(super.body.getString("FirstName"), response.jsonPath().get("firstName"));

    }

    @Then("os dados do autor devem ser retornados corretamente")
    public void os_dados_do_autor_devem_ser_retornados_corretamente()
    {
        assertEquals("First Name 30", response.jsonPath().get("firstName"));
        assertEquals("Last Name 30", response.jsonPath().get("lastName"));
        //cria um idbook diferente em cada request assertEquals(11, response.jsonPath().getInt("idBook"));
    }
    @Then("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(Integer statusesperado)
    {
        System.out.println("o_status_code_do_request_deve_ser "+ String.valueOf(response.getStatusCode()));
        assertEquals(statusesperado, response.getStatusCode(), "Status code diferente do esperedo");

    }

    //   *** PUT *** *****
    @When("Envio um request de alteração de autor com dados validos")
    public void envio_um_request_de_alteração_de_autor_com_dados_validos()
    {
        String uriSt =  props.getProp("url_fakerestAuthors")+200;
        super.uri =uriSt;
        setaHeaders();
        super.body=new JSONObject();
        super.body.put("firstName", "filet mignogn");
        System.out.println("envio_um_request_de_alteração_de_autor_com_dados_validos" + body);
        objetoDeEnvioJson = super.body;
        super.PUT();
    }
    @Then("o autor deve ser alterado corretamente")
    public void o_autor_deve_ser_alterado_corretamente()
    {
        System.out.println("o_autor_deve_ser_alterado_corretamente");
  //      String response = response.
        assertEquals(objetoDeEnvioJson.get("firstName"),response.jsonPath().get("firstName"));
    }

    //   *** DELETE *** ****
    
    
    @When("Envio um request  para deletar um autor com dados validos")
    public void envioUmRequestParaDeletarUmAutorComDadosValidos()
    {
        String uriSt =  props.getProp("url_fakerestAuthors")+200;
        super.uri =uriSt;
        setaHeaders();
        System.out.println("envioUmRequestParaDeletarUmAutorComDadosValidos id - " + uriSt);
        super.DELETE();
    }

    @Then("o autor deve ser deletado corretamente")
    public void oAutorDeveSerDeletadoCorretamente()
    {
        System.out.println("oAutorDeveSerDeletadoCorretamente, statuscode :  "+ String.valueOf(response.getStatusCode()));
        assertEquals(200, response.getStatusCode(), "Status code diferente do esperedo");
    }





    //   *** BOOKS *** ****




    @When("buscar esse livro")
    public void buscar_esse_livro()
    {
        String idSt = "30";//engessado, id retorna 0 e não salva  (response.jsonPath().getJsonObject("id")).toString();
        System.out.println("buscar_esse_autor id : " + idSt);
        super.uri = props.getProp(urlBook) + idSt;
        setaHeaders();
        super.GET();
    }


    @When("Envio um request de cadastro de livro com dados validos")
    public void envioUmRequestDeCadastroDeLivroComDadosValidos()
    {
        setaUriBooks();
        setaHeaders();
        setaBodyFakerestBook();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        objetoDeEnvioJson = super.body;
        super.POST();
    }

    private void setaBodyFakerestBook()
    {
        Book book = new Book() ;
        book.setDescription(faker.job().field());
                book.setTitle(faker.book().title());
                book.setExcerpt("excerpt that ");
                book.setPageCount(faker.number().numberBetween(10,1000));
                book.setPublishDate("2022-0"+String.valueOf(faker.number().numberBetween(1,12))+"-22T13:16:36.163Z");
        super.body = book.getJson();
        System.out.println("book steps setaBody() "+body.toString());
    }

    private void setaUriBooks()
    {
        super.uri = props.getProp("url_fakerestBooks");
    }


    @When("Envio um request de alteração de livro com dados validos")
    public void envioUmRequestDeAlteraçãoDeLivroComDadosValidos()
    {

        String uriSt =  props.getProp(urlBook)+10;
        super.uri =uriSt;
        setaHeaders();
        super.body=new JSONObject();
        super.body.put("title", "SAPIENS");
        super.body.put("description", "UMA BREVE HISTORIA DA HUMANIDADE");
        super.body.put("pageCount",550);
        super.body.put("excerpt","exceptions");
        super.body.put("publishDate","2020-07-22T12:15:08.522Z");
        System.out.println("envio_um_request_de_alteração_de_autor_com_dados_validos" + body);
        objetoDeEnvioJson = super.body;
        super.PUT();
    }

    @When("Envio um request  para deletar um livro com dados validos")
    public void envioUmRequestParaDeletarUmLivroComDadosValidos()
    {
        String uriSt =  props.getProp("url_fakerestBooks")+"7";
        super.uri =uriSt;
        setaHeaders();
        System.out.println("envioUmRequestParaDeletarUmAutorComDadosValidos id - " + uriSt);
        super.DELETE();
    }

    @Given("existe o livro cadastrado na API")
    public void existe_o_livro_cadastrado_na_api()
    {
        System.out.println("existe_o_livro_cadastrado_na_api  - engessado, API não grava");
    }

    @Then("os dados do livro devem ser retornados corretamente")
    public void os_dados_do_livro_devem_ser_retornados_corretamente()
    {
        System.out.println("os_dados_do_livro_devem_ser_retornados_corretamente");
        System.out.println("Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.".length());
        String st = "Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.".substring(0,278);
        System.out.println(st);

        System.out.println();

        assertEquals("Book 30", response.jsonPath().get("title"));
        assertEquals("Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n", response.jsonPath().get("description"));
        assertEquals(3000, response.jsonPath().getInt("pageCount"));
        assertEquals("Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n", response.jsonPath().get("excerpt"));
 //       assertEquals("2022-06-25T11:14:36.6697946+00:00", response.jsonPath().get("publishDate"));
    }

    @Then("o livro deve ser criado corretamente")
    public void oLivroDeveSerCriadoCorretamente()
    {
        System.out.println("oLivroDeveSerCriadoCorretamente - statuscode - "+response.getStatusLine());
        assertEquals(super.body.getString("title"), response.jsonPath().get("title"));
        assertEquals(super.body.getString("description"), response.jsonPath().get("description"));
        assertEquals(super.body.getInt("pageCount"), response.jsonPath().getInt("pageCount"));
        assertEquals(super.body.getString("excerpt"), response.jsonPath().get("excerpt"));
        assertEquals(super.body.getString("publishDate"), response.jsonPath().get("publishDate"));
    }

    @Then("o livro deve ser deletado corretamente")
    public void oLivroDeveSerDeletadoCorretamente()
    {
        System.out.println("oLivroDeveSerDeletadoCorretamente, statuscode :  "+ String.valueOf(response.getStatusLine()));
        assertEquals(200, response.getStatusCode(), "Status code diferente do esperedo");
    }

    @Then("o livro deve ser alterado corretamente")
    public void oLivroDeveSerAlteradoCorretamente()
    {
        System.out.println("oLivroDeveSerAlteradoCorretamente");
        assertEquals(super.body.getString("title"), response.jsonPath().get("title"));
        assertEquals(super.body.getString("description"), response.jsonPath().get("description"));
        assertEquals(super.body.getInt("pageCount"), response.jsonPath().getInt("pageCount"));
        assertEquals(super.body.getString("excerpt"), response.jsonPath().get("excerpt"));
        assertEquals(super.body.getString("publishDate"), response.jsonPath().get("publishDate"));

    }



   //    *** COVERPHOTOS *** ****





    @When("buscar esse coverphotos")
    public void buscarEsseCoverphotos()
    {
        System.out.println("buscarEsseCoverphotos");

        String idSt = "/33";//engessado, id retorna 0 e não salva  (response.jsonPath().getJsonObject("id")).toString();
        System.out.println("buscar_esse_autor id : " + idSt);
        super.uri =setaUriCoverphotos()+ idSt;
        setaHeaders();
        super.GET();

    }

    @When("Envio um request de cadastro de coverphotos com dados validos")
    public void envioUmRequestDeCadastroDeCoverphotosComDadosValidos()
    {
      setaUriCoverphotos();
        setaHeaders();
        setaBodyCoverphoto();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        objetoDeEnvioJson = super.body;
        super.POST();
    }

    private String setaUriCoverphotos()
    {
        String uriSt =  props.getProp(urlBase)+"CoverPhotos";
        super.uri = uriSt;

        return uriSt;
    }


    private void setaBodyCoverphoto()
    {
        Coverphoto coverphoto = new Coverphoto() ;
        coverphoto.setIdBook(faker.number().numberBetween(1,200));
        coverphoto.setUrl(faker.internet().url());
        super.body = coverphoto.getJson();

        System.out.println("setaBodyCoverphoto() "+body.toString());
    }


    @When("Envio um request  para deletar um Coverphotos com dados validos")
    public void envioUmRequestParaDeletarUmCoverphotosComDadosValidos()
    {
        String uriSt = setaUriCoverphotos()+"/7";
        super.uri =uriSt;
        setaHeaders();
        System.out.println("envioUmRequestParaDeletarUmAutorComDadosValidos id - " + uriSt);
        super.DELETE();
    }

    @Given("existe o coverphotos cadastrado na API")
    public void existeOCoverphotosCadastradoNaAPI()
    {
        System.out.println("existeOCoverphotosCadastradoNaAPI engessado ñ grava");
    }


    @Then("o coverphotos deve ser criado corretamente")
    public void oCoverphotosDeveSerCriadoCorretamente()
    {
        System.out.println("oCoverphotosDeveSerCriadoCorretamente");
        assertEquals(super.body.getString("url"), response.jsonPath().get("url"));
        assertEquals(super.body.getInt("idBook"), response.jsonPath().getInt("idBook"));
    }

    @Then("o Coverphotos deve ser alterado corretamente")
    public void oCoverphotosDeveSerAlteradoCorretamente()
    {
        System.out.println("oCoverphotosDeveSerAlteradoCorretamente");
        oCoverphotosDeveSerCriadoCorretamente();
    }

    @Then("o Coverphotos deve ser deletado corretamente")
    public void oCoverphotosDeveSerDeletadoCorretamente()
    {
        System.out.println("oCoverphotosDeveSerDeletadoCorretamente, statuscode :  "+ String.valueOf(response.getStatusLine()));
        assertEquals(200, response.getStatusCode(), "Status code diferente do esperedo");

    }


    @Then("os dados do coverphotos devem ser retornados corretamente")
    public void osDadosDoCoverphotosDevemSerRetornadosCorretamente()
    {
        System.out.println("osDadosDoCoverphotosDevemSerRetornadosCorretamente");

        assertEquals( "https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 33&w=250&h=350", response.jsonPath().get("url"));
        assertEquals(33, response.jsonPath().getInt("idBook"));
    }

    @When("Envio um request de alteração de Coverphotos com dados validos")
    public void envioUmRequestDeAlteraçãoDeCoverphotosComDadosValidos()
    {

        String uriSt =  props.getProp(urlBase)+"CoverPhotos/28";
        super.uri =uriSt;
        setaHeaders();
        super.body=new JSONObject();
        super.body.put("url", faker.internet().url());
        super.body.put("idBook", 182);
        System.out.println("envioUmRequestDeAlteraçãoDeCoverphotosComDadosValidos" + body);
        objetoDeEnvioJson = super.body;
        super.PUT();
    }
    
    
    
    
     //  *** USUARIOS *** ****
    
    
    

    @When("Envio um request de cadastro de usuario com dados validos")
    public void envioUmRequestDeCadastroDeUsuarioComDadosValidos() 
    {
        setaUriUser();
        setaHeaders();
        setaBodyUser();
        System.out.println("\"envio um request de cadastro de usuario com dados validos\"" + body);
        objetoDeEnvioJson = super.body;
        super.POST();
    }

    private String setaUriUser()
    {
        String uriSt =  props.getProp(urlBase)+"Users";
        super.uri = uriSt;

        return uriSt;
    }

    private void setaBodyUser()
    {
        User user = new User() ;
        user.setUserName(faker.name().fullName());
        user.setPassword(faker.internet().password());
        super.body = user.getJson();

        System.out.println("setaBodyUser() "+body.toString());
    }

    @Then("o usuario deve ser criado corretamente")
    public void oUsuarioDeveSerCriadoCorretamente()
    {
        System.out.println("oUsuarioDeveSerCriadoCorretamente");
        assertEquals(super.body.getString("userName"), response.jsonPath().get("userName"));
        assertEquals(super.body.getString("password"), response.jsonPath().getString("password"));
    }

    @Given("existe o usuario cadastrado na API")
    public void existeOUsuarioCadastradoNaAPI()
    {
        System.out.println("existeOUsuarioCadastradoNaAPI engessado");
    }

    @When("buscar esse usuario")
    public void buscarEsseUsuario()
    {
        String idSt = "10";//engessado, id retorna 0 e não salva  (response.jsonPath().getJsonObject("id")).toString();
        System.out.println("buscar_esse_usuario id : " + idSt);
        super.uri = props.getProp(urlBase) + "Users/"+idSt;
        setaHeaders();
        super.GET();
    }

    @Then("os dados do usuario devem ser retornados corretamente")
    public void osDadosDoUsuarioDevemSerRetornadosCorretamente()
    {
        System.out.println("osDadosDoUsuarioDevemSerRetornadosCorretamente");
        assertEquals("Password10", response.jsonPath().get("password"));
        assertEquals("User 10", response.jsonPath().get("userName"));

    }

    @When("Envio um request  para deletar um usuario com dados validos")
    public void envioUmRequestParaDeletarUmUsuarioComDadosValidos()
    {
        String uriSt =  props.getProp("url_fakerestBase")+"Users/200";
        super.uri =uriSt;
        setaHeaders();
        System.out.println("envioUmRequestParaDeletarUmUsuarioComDadosValidos id - " + uriSt);
        super.DELETE();
    }

    @Then("o usuario deve ser deletado corretamente")
    public void oUsuarioDeveSerDeletadoCorretamente()
    {
        System.out.println("oUsuarioDeveSerDeletadoCorretamente, statuscode :  "+ String.valueOf(response.getStatusCode()));
        assertEquals(200, response.getStatusCode(), "Status code diferente do esperedo");
    }

    @When("Envio um request de alteração de usuario com dados validos")
    public void envioUmRequestDeAlteraçãoDeUsuarioComDadosValidos()
    {
        String uriSt =  props.getProp("url_fakerestAuthors")+200;
        super.uri =uriSt;
        setaHeaders();
        super.body=new JSONObject();
        super.body.put("firstName", "filet mignogn");
        System.out.println("envio_um_request_de_alteração_de_autor_com_dados_validos" + body);
        objetoDeEnvioJson = super.body;
        super.PUT();
    }
}

