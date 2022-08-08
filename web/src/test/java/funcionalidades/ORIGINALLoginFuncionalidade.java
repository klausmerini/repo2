package funcionalidades;

import pages.LoginHerokuPage;
import utils.BaseTest;

public class ORIGINALLoginFuncionalidade extends BaseTest {

	private LoginHerokuPage login;

	public ORIGINALLoginFuncionalidade() {
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
