package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@action='/search']/input[@value='Search store']")
    private WebElement campoSearch;
 //   /html/body/div[4]/div[1]/div[1]/div[3]

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchBtn;

    public WebElement getCampoSearch() {
        return campoSearch;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

}
