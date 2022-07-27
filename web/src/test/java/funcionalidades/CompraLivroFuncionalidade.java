package funcionalidades;

import pages.ComprarLivroPage;
import pages.RegisterPage;
import utils.BaseTest;

public class CompraLivroFuncionalidade  extends BaseTest
{
    private ComprarLivroPage compraLivroPg;
    private RegisterPage registerPg;
    String urlSt;



    public void abrePagina()
    {
        this.webDriver.get("http://demowebshop.tricentis.com/");
        this.compraLivroPg = new ComprarLivroPage(webDriver);
    }


    public void compraLivroAction() {
        compraLivroPg.getSelecionaLivrosBtn().click();
    }

    public void selecionaLivroAction() throws InterruptedException
    {
        Thread.sleep(3000);
       compraLivroPg.getLivroBtn().click();
        Thread.sleep(4000);
    }


    public void confirmaCompraAction() throws InterruptedException
    {
        compraLivroPg.getCarrinhoDeCompraLInk().click();
        Thread.sleep(5000);
        compraLivroPg.getLivroCompradoLink().click();
        Thread.sleep(5000);
    }

    public void clicaEmRegister() throws InterruptedException
    {
        compraLivroPg.getRegisterLink().click();
        Thread.sleep(2000);
    }


    public void clicaEmContinue() throws InterruptedException
    {
        registerPg.getContinueRegistroBtn().click();
        Thread.sleep(2000);
    }


    public void selecionaGenderMale() throws InterruptedException {

        this.registerPg = new RegisterPage(webDriver);
        Thread.sleep(1000);
        registerPg.getGenderMalesRadioBtn().click();
        Thread.sleep(1000);
    }

    public void preencheCamposReg() throws InterruptedException
    {
        registerPg.getFirstNameCampo().sendKeys("chris");
        Thread.sleep(500);
        registerPg.getLastNameCampo().sendKeys("Rosen");
        Thread.sleep(500);
        registerPg.getEmailCampo().sendKeys("cr19822@yahoo.com");
        Thread.sleep(500);
        registerPg.getPasswordCampo().sendKeys("289821");
        Thread.sleep(500);
        registerPg.getConfirmPasswordCampo().sendKeys("289821");
        Thread.sleep(500);
        registerPg.getFinalizaRegistroBtn().click();
        Thread.sleep(5000);


    }
}
