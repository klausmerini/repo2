package funcionalidades;

import pages.CompraOutrosPage;
import pages.ComprarLivroPage;
import pages.RegisterPage;
import utils.BaseTest;

public class CompraLivroFuncionalidade  extends BaseTest
{
    private ComprarLivroPage compraLivroPg;
    private RegisterPage registerPg;

    private CompraOutrosPage compraOutrosPage;
    String urlSt;



    public void abrePagina()
    {
        this.webDriver.get("http://demowebshop.tricentis.com/");
        this.compraLivroPg = new ComprarLivroPage(webDriver);
        this.compraOutrosPage = new CompraOutrosPage(webDriver);
    }
    public void compraLivroAction() {
        compraLivroPg.getSelecionaLivrosBtn().click();
    }

    public void compraVariosProdAction() throws InterruptedException {
        Thread.sleep(500);
        compraLivroPg.getSelecionaComputerBtn().click();
        Thread.sleep(2000);
        compraOutrosPage.getSelecionaAcessoriosLink().click();
        Thread.sleep(1000);
        compraOutrosPage.getSelecionaProdAcessorioBtn().click();
        Thread.sleep(3000);
        compraLivroPg.getSelecionaEletronicsBtn().click();
        Thread.sleep(1000);
        compraOutrosPage.getSelecionaCategCellphones().click();
        Thread.sleep(1000);
        compraOutrosPage.getSelecionaProdCategCellphones().click();
        Thread.sleep(3000);
        compraLivroPg.getSelecionaApparelShoesBtn().click();
        Thread.sleep(1000);
        compraOutrosPage.getSelecionaProdCategApparelShoes().click();
        Thread.sleep(1500);
        compraOutrosPage.getSelecionaProdShoes().click();
        Thread.sleep(7000);
        compraLivroPg.getSelecionaDigitalDownloadsBtn().click();
        Thread.sleep(1000);
        compraOutrosPage.getSelecionaDigitalDownloadsProd().click();
        Thread.sleep(3000);
        compraLivroPg.getSelecionaJewelryBtn().click();
        Thread.sleep(1500);
        compraOutrosPage.getSelecionaProdJewlery().click();
        Thread.sleep(3000);
        compraLivroPg.getSelecionaGiftCardsBtn().click();
        Thread.sleep(1500);
        compraOutrosPage.getSelecionaProdGiftCards().click();
        Thread.sleep(1500);
        compraOutrosPage.getCampoReciptNameGiftCards().sendKeys("KLluz1");
        Thread.sleep(1500);
        compraOutrosPage.getCampoReciptEmailGiftCards().sendKeys("kl1@ya.brc");
        Thread.sleep(1500);
        compraOutrosPage.getCampoNameGiftCards().sendKeys("RoJohsen");
        Thread.sleep(1500);
        compraOutrosPage.getCampoEmailGiftCards().sendKeys("kl@ya.brc");
        Thread.sleep(1500);
        compraOutrosPage.getSendGiftCardsBtn().click();

        Thread.sleep(15000);
    }
    public void compraApparelShoesAction() throws InterruptedException {
        Thread.sleep(500);
        compraLivroPg.getSelecionaApparelShoesBtn().click();
        Thread.sleep(500);
    }
    public void compraCellphonesAction() throws InterruptedException {
        Thread.sleep(500);
        compraLivroPg.getSelecionaCellphonesBtn().click();
        Thread.sleep(500);
    }
    public void compraDigitalDownloadsAction() throws InterruptedException {
        Thread.sleep(500);
        compraLivroPg.getSelecionaDigitalDownloadsBtn().click();
        Thread.sleep(500);
    }
    public void compraEletronicsAction() throws InterruptedException {

        Thread.sleep(500);
        compraLivroPg.getSelecionaEletronicsBtn().click();

        Thread.sleep(500);
    }
    public void compraGiftCardsAction() throws InterruptedException {

        Thread.sleep(500);
        compraLivroPg.getSelecionaGiftCardsBtn().click();

        Thread.sleep(500);
    }
    public void compraJewelryAction() throws InterruptedException {

        Thread.sleep(500);
        compraLivroPg.getSelecionaJewelryBtn().click();

        Thread.sleep(500);
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
