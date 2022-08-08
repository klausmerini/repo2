package funcionalidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CompraGiftCardPage;
import pages.CompraOutrosPage;
import pages.ComprarLivroPage;
import pages.RegisterPage;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

public class CompraLivroFuncionalidade extends BaseTest {
    private ComprarLivroPage compraLivroPg;
    private RegisterPage registerPg;
    private CompraOutrosPage compraOutrosPage;
    private CompraGiftCardPage compraGiftCardPage;

    String urlSt;

    public void abrePagina() {
        this.webDriver.get("http://demowebshop.tricentis.com/");
        this.compraLivroPg = new ComprarLivroPage(webDriver);
        this.compraOutrosPage = new CompraOutrosPage(webDriver);
        this.compraGiftCardPage = new CompraGiftCardPage(webDriver);
    }
    public void compraComputers() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaComputerBtn()));
        compraLivroPg.getSelecionaComputerBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaAcessoriosLink()));
        compraOutrosPage.getSelecionaAcessoriosLink().click();
        selecionaTodosProdutos();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdAcessorioBtn()));
        compraOutrosPage.getSelecionaProdAcessorioBtn().click();
    }

    public void compraLivroAction() {
        compraLivroPg.getSelecionaLivrosBtn().click();
    }

    public void compraVariosProdAction() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaComputerBtn()));
        compraLivroPg.getSelecionaComputerBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaAcessoriosLink()));
        compraOutrosPage.getSelecionaAcessoriosLink().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdAcessorioBtn()));
        compraOutrosPage.getSelecionaProdAcessorioBtn().click();
        compraEletronicsAction();
        compraApparelShoesAction();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdCategApparelShoes()));
        compraOutrosPage.getSelecionaProdCategApparelShoes().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdShoes()));
        synchronized (webDriver) {
            try {
                webDriver.wait(5000);   }
            catch (InterruptedException e) {   e.printStackTrace();       }
        }
        compraOutrosPage.getSelecionaProdShoes().click();
        compraDigitalDownloadsAction();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaDigitalDownloadsProd()));
        compraOutrosPage.getSelecionaDigitalDownloadsProd().click();
        compraJewelryAction();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdJewlery()));
        compraOutrosPage.getSelecionaProdJewlery().click();
        compraGiftCardsAction();
    }
    public void compraTodosProdAction() throws InterruptedException
    {
        compraComputers();
        compraEletronicsAction();
        compraApparelShoesAction();
        compraDigitalDownloadsAction();
        compraJewelryAction();
        compraGiftCardsAction();
        espera5s();
        espera5s();
    }
    private void espera5s()
    {
        synchronized (webDriver) {
            try {
                webDriver.wait(5000);   }
            catch (InterruptedException e) {   e.printStackTrace();       }        }
    }
    private void espera2s()
    {
        synchronized (webDriver) {
            try {
                webDriver.wait(2000);   }
            catch (InterruptedException e) {   e.printStackTrace();       }        }
    }
    public void compraApparelShoesAction() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaApparelShoesBtn()));
        compraLivroPg.getSelecionaApparelShoesBtn().click();//tipo
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdCategApparelShoes()));
        compraOutrosPage.getSelecionaProdCategApparelShoes().click();//categ
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdShoes()));
        espera5s();
        compraOutrosPage.getSelecionaProdShoes().click();//prod

    }
//
//    public void compraCellphonesAction() throws InterruptedException {
//        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaCellphonesBtn()));
//        compraLivroPg.getSelecionaCellphonesBtn().click();
//    }

    public void compraDigitalDownloadsAction() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaDigitalDownloadsBtn()));
        compraLivroPg.getSelecionaDigitalDownloadsBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaDigitalDownloadsProd()));
        compraOutrosPage.getSelecionaDigitalDownloadsProd().click();
    }

    public void compraEletronicsAction() throws InterruptedException
    {
        espera5s();
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaEletronicsBtn()));
        compraLivroPg.getSelecionaEletronicsBtn().click();//tipo
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaCategCellphones()));
        compraOutrosPage.getSelecionaCategCellphones().click();//categoria
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdCategCellphones()));
        compraOutrosPage.getSelecionaProdCategCellphones().click();//produto
    }

    public void compraGiftCardsAction() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaGiftCardsBtn()));
        compraLivroPg.getSelecionaGiftCardsBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getSelecionaProdGiftCards()));
        compraGiftCardPage.getSelecionaProdGiftCards().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getCampoReciptNameGiftCards()));
        compraGiftCardPage.getCampoReciptNameGiftCards().sendKeys("KLluz1");
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getCampoReciptEmailGiftCards()));
        compraGiftCardPage.getCampoReciptEmailGiftCards().sendKeys("kl1@ya.brc");
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getCampoNameGiftCards()));
        compraGiftCardPage.getCampoNameGiftCards().sendKeys("RoJohsen");
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getCampoEmailGiftCards()));
        compraGiftCardPage.getCampoEmailGiftCards().sendKeys("kl@ya.brc");
        espera2s();
        wait.until(ExpectedConditions.elementToBeClickable(compraGiftCardPage.getSendGiftCardsBtn()));
        compraGiftCardPage.getSendGiftCardsBtn().click();
   }

    public void compraJewelryAction() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getSelecionaJewelryBtn()));
        compraLivroPg.getSelecionaJewelryBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getSelecionaProdJewlery()));
        compraOutrosPage.getSelecionaProdJewlery().click();
    }

    public void selecionaLivroAction() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getLivroBtn()));
        compraLivroPg.getLivroBtn().click();
    }

    public void confirmaCompraAction() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraLivroPg.getLivroCompradoLink()));
        compraLivroPg.getLivroCompradoLink().click();
    }

    public void clicaEmRegister() throws InterruptedException {
        compraLivroPg.getRegisterLink().click();
    }

    public void clicaEmContinue() throws InterruptedException {
        registerPg.getContinueRegistroBtn().click();
    }
    public void selecionaGenderMale() throws InterruptedException {

        this.registerPg = new RegisterPage(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(registerPg.getGenderMalesRadioBtn()));
        registerPg.getGenderMalesRadioBtn().click();
    }
    public void preencheCamposReg() throws InterruptedException {
        registerPg.getFirstNameCampo().sendKeys("chris");
        wait.until(ExpectedConditions.elementToBeClickable(registerPg.getLastNameCampo()));
        registerPg.getLastNameCampo().sendKeys("Rosen");
        Random rand = new Random();
        registerPg.getEmailCampo().sendKeys("cr1982" + String.valueOf(rand.nextInt(10000000)) + "@yahoo.com");
        wait.until(ExpectedConditions.elementToBeClickable(registerPg.getPasswordCampo()));
        registerPg.getPasswordCampo().sendKeys("289821");
        registerPg.getConfirmPasswordCampo().sendKeys("289821");
        wait.until(ExpectedConditions.elementToBeClickable(registerPg.getFinalizaRegistroBtn()));
        registerPg.getFinalizaRegistroBtn().click();
    }

    public void pegaQtdCarrinho() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getTxtQtdProd()));
       String qtdProdSt = compraOutrosPage.getTxtQtdProd().getText();
        System.out.println("pegaQtdCarrinho : "+qtdProdSt);
        assertEquals("(11)", qtdProdSt);

    }

    public void entraNoCarrinho() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(compraOutrosPage.getCarrinhoDeCompraLink()));
        compraOutrosPage.getCarrinhoDeCompraLink().click();

    }

    public ArrayList<WebElement> selecionaTodosProdutos() throws InterruptedException
    {
        int qtdProdutos = verificaQtdProd();
        String xpath = "(//input[@value='Add to cart'])[";
        String xpath2 = "]";
        int i = 2;
        ArrayList<WebElement> weArray = new ArrayList<>();
        while (i < qtdProdutos) {
            String xpathFinal = xpath + String.valueOf(i) + xpath2;
            System.out.println(xpathFinal);
            WebElement weIt = webDriver.findElement(By.xpath(xpathFinal));
            weArray.add(weIt);
            i++;
        }
        int i2 = 0;
        while (i2<qtdProdutos-2)
        {
            espera2s();
            WebElement weIt =weArray.get(i2);
            wait.until(ExpectedConditions.elementToBeClickable(weIt));
            weIt.click();
            i2++;
        }
        return weArray;
    }

    public int verificaQtdProd()
    {
        List<WebElement> webElements = new ArrayList<WebElement>();
        webElements =  webDriver.findElements(By.className("item-box"));
        System.out.println("verificaQtdProd - "+String.valueOf(webElements.size()));
        return webElements.size();
    }
}
