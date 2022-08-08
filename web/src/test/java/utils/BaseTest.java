package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.interfaces.WebApplication;

import java.util.concurrent.TimeUnit;

public class BaseTest {
	
	protected static WebDriver webDriver;
	protected static WebDriverWait wait;
	protected static WebDriverWait shortWait;
	
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

}
