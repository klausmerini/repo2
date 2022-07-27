package utils.communs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.interfaces.WebApplication;

public enum Web implements WebApplication {

	CHROME {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
			return new ChromeDriver();
		}


	},

	CHROME_WINDOWS {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			return new ChromeDriver();
		}

	}

}
