package funcionalidades;

import pages.LoginHerokuPage;
import utils.BaseTest;

public class LoginFuncionalidade extends BaseTest {

	private LoginHerokuPage login;

	public LoginFuncionalidade() {
		this.login = new LoginHerokuPage(webDriver);
	}

	public void LoginSrBarriga(String user) {
		this.webDriver.get("https://srbarriga.herokuapp.com/login/");
		this.login = new LoginHerokuPage(webDriver);
		login.getEmail().sendKeys(user+"@yaman.com.br");
		login.getSenha().sendKeys("_123@Yaman");
		login.getBtnEntrar().click();
	}

}
