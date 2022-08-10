package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.RegisterPage;
import utils.BaseTest;

import java.util.Random;

public class RegisterFuncionalidade extends BaseTest
{
    public void clicaEmRegister() throws InterruptedException {
        espera5s();
        registerPg.getRegisterLink().click();
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


}
