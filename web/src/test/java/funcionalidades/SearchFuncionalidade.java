package funcionalidades;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SearchPage;
import utils.BaseTest;

public class SearchFuncionalidade extends BaseTest {

    SearchPage page = new SearchPage(webDriver);

    public void preencheCampoSearch() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.getCampoSearch()));
        page.getCampoSearch().sendKeys("camcorder");
    }

    public void clicaSearch() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.getSearchBtn()));
        page.getSearchBtn().click();
    }
}
