package com.iLab.pages;

import com.iLab.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DealxPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "search_query_top")
    public WebElement searchfield;

    @FindBy(how = How.NAME, using = "submit_search")
    public WebElement searchbotton;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")
    public WebElement searchresultbutton;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/div/div/div[3]/h1")
    public WebElement serachresultsvalue;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    public WebElement firstResultName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_logo\"]/a/img")
    public WebElement homePageLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_logo\"]/a/img")
    public WebElement signInLink;

    @FindBy(how = How.ID, using = "email")
    public WebElement userNameBox;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement passwordBox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]/span")
    public WebElement signInBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button/span")
    public WebElement addToCartBtn;

    @FindBy(how = How.ID, using = "total_product")
    public WebElement totalPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    public WebElement DressesMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"our_price_display\"]")
    public WebElement unitPrice;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[3]")
    public WebElement TshirtsMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]")
    public WebElement WomenMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"product_5_19_0_651958\"]/td[5]/input[2]")
    public WebElement itemQuantity;

    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    public WebElement proceedToCheckout;

    public DealxPage(WebDriver driver) {
        this.driver = Driver.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void setSearchforItem(String searchproduct){


        searchfield.sendKeys(searchproduct);
        searchbotton.click();
    }
    public boolean getAndValidateSearchResults(String searchproduct){

        boolean validation = false;
    try{

        searchresultbutton.click();
        if(searchproduct.toLowerCase().contains(serachresultsvalue.getText().toLowerCase())){

            validation = true;

        }
        else{

            validation = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        return validation;
    }

    public void getAndValidateSearchResultsTC2(String searchproduct) {

        boolean validation = false;
        try {
            String searchResult;
            String[] searchArray = searchproduct.split(",");
            int numberOfItems = searchArray.length;
            for (int i = 0; i < numberOfItems; i++) {
                String searchWord = searchArray[i];
                searchfield.sendKeys(searchproduct);
                searchbotton.click();
                searchresultbutton.click();
                searchResult = serachresultsvalue.getText();

                if (searchResult.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("correct results displayed ");
                } else System.out.println("incorrect results displayed ");

                homePageLink.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signInBtn() {
    }

    public void homePageLink(String menu, String subMenu) {

    }
}
