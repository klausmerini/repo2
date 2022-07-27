package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AdicionarPage;
import pages.HomePage;
import utils.BaseTest;
import utils.Randon;
import utils.reports.Screenshot;

import java.awt.*;
import java.io.IOException;


public class AdicionarContasFuncionalidade extends BaseTest {
	
	private HomePage home;
	private AdicionarPage adicionar;
    private Screenshot screenCapture;

    public AdicionarContasFuncionalidade() {
        this.screenCapture =  new Screenshot();
        this.home = new HomePage(webDriver);
        this.adicionar = new AdicionarPage(webDriver);
    }

    public void clickAdicionar() throws IOException, AWTException {
		wait.until(ExpectedConditions.elementToBeClickable(this.home.getDropDownContas()));
		this.home.getDropDownContas().click();
		wait.until(ExpectedConditions.visibilityOf(this.home.getContasAdicionar()));
		this.home.getContasAdicionar().click();
		this.screenCapture.takeScreenShoot();
	}
	
	public void adicionarUsuario() throws IOException, AWTException {
		wait.until(ExpectedConditions.visibilityOf(this.adicionar.getTextFild()));
		this.adicionar.getTextFild().sendKeys(Randon.fakeGenerator());
		this.adicionar.getBtnSalvar().click();
        this.screenCapture.takeScreenShoot();


    }
	
	public String obterTextoConfirmacao() throws IOException, AWTException {
		this.adicionar = new AdicionarPage(webDriver); 
		wait.until(ExpectedConditions.visibilityOf(this.adicionar.getMsgConfirmacao()));
        this.screenCapture.takeScreenShoot();
        return this.adicionar.getMsgConfirmacao().getText();
	}

}
