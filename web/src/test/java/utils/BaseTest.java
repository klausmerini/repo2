package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.interfaces.WebApplication;

import java.util.concurrent.TimeUnit;

public class BaseTest {
	
	protected static WebDriver webDriver;
	protected static WebDriverWait wait;
	protected static WebDriverWait shortWait;

	protected static ComprarLivroPage compraLivroPg;
	protected static RegisterPage registerPg;
	protected static CompraOutrosPage compraOutrosPage;
	protected static CompraGiftCardPage compraGiftCardPage;
	protected static LoginENewsletterPage loginpage;


	public static NewsletterPage newsletterPage;

	public BaseTest()
	{
		System.out.println("instancia BaseTest");
		registerPg= new RegisterPage(webDriver);
		newsletterPage = new NewsletterPage(webDriver);
	}
	
	/**
	 * Inicializa o {@code WebDriver} e o {@code WebDriverWait}
	 */
	
	protected void initializeWebApplication(WebApplication webApplication) {
		webDriver = webApplication.getDriver();
		webDriver.manage().window().fullscreen();
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(webDriver, 20);
	}
	/**
	 * fecha o driver web
	 */
	protected static void closeWeb() {
		webDriver.quit();
	}

	public static void espera5s()
	{
		synchronized (webDriver) {
			try {
				webDriver.wait(5000);   }
			catch (InterruptedException e) {   e.printStackTrace();       }        }
	}
	public static void espera2s()
	{
		synchronized (webDriver) {
			try {
				webDriver.wait(2000);   }
			catch (InterruptedException e) {   e.printStackTrace();       }        }
	}


	public static NewsletterPage getNewsletterPage() {
		return newsletterPage;
	}
}
