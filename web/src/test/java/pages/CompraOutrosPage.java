package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraOutrosPage {
    @FindBy(linkText = "Accessories")
    private WebElement selecionaAcessoriosLink;

    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdAcessorioBtn;

    @FindBy(xpath = "//img[@alt='Picture for category Cell phones']")
    private WebElement selecionaCategCellphones;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement selecionaProdCategCellphones;


    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement selecionaProdCategApparelShoes;


    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdShoes;


    @FindBy(xpath = "(//input[@value='Add to cart'])[3]")
    private WebElement selecionaDigitalDownloadsProd;


    @FindBy(xpath = "(//input[@value='Add to cart'])[2]")
    private WebElement selecionaProdJewlery;


    @FindBy(xpath = "//li[@id='topcartlink']/a/span")
    private WebElement carrinhoDeCompraLink;


    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")
    private WebElement txtQtdProd;




    public CompraOutrosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSelecionaAcessoriosLink() {
        return selecionaAcessoriosLink;
    }


    public WebElement getSelecionaProdAcessorioBtn() {
        return selecionaProdAcessorioBtn;
    }

    public WebElement getSelecionaCategCellphones() {
        return selecionaCategCellphones;
    }

    public WebElement getSelecionaProdCategCellphones() {
        return selecionaProdCategCellphones;
    }


    public WebElement getSelecionaProdCategApparelShoes() {
        return selecionaProdCategApparelShoes;
    }

    public WebElement getSelecionaProdShoes() {
        return selecionaProdShoes;
    }

    public WebElement getSelecionaDigitalDownloadsProd() {
        return selecionaDigitalDownloadsProd;
    }

    public WebElement getSelecionaProdJewlery() {
        return selecionaProdJewlery;
    }

    public WebElement getCarrinhoDeCompraLink() {
        return carrinhoDeCompraLink;
    }

    public WebElement getTxtQtdProd() {
        return txtQtdProd;
    }



}
