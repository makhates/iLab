package com.iLab.step_definitions;

import com.iLab.pages.DealxPage;
import com.iLab.utilities.ConfigurationReader;
import com.iLab.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dealxsteps {

    private WebDriver driver = Driver.getDriver();
    DealxPage dealxpage = new DealxPage(driver);
    Logger log = Logger.getLogger(ApplicationSteps.class);
    String searchproduct;

    @Given("i am on the landing page")
    public void iAmOnTheLandingPage() {

        try {
            //loading the home page
            driver.get(ConfigurationReader.getProperty("url"));
            WebDriver driver = Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        } catch (Exception err) {
            log.info("failed to load home page " + err.getMessage());
        }
    }

    @And("Search for {string}")
    public void searchFor(String dress) {

        dealxpage.setSearchforItem(dress);

    }

    @Then("Verify that the correct results are diplayed")
    public void verifyThatTheCorrectResultsAreDiplayed() {
    }

    @And("Search for ")
    public void searchForDress(String dress) {


    }

    @Then("Verify that the correct results are diplayed for {string}")
    public void verifyThatTheCorrectResultsAreDiplayedFor(String dress) {

        dealxpage.getAndValidateSearchResults(dress);
    }

    @Then("Verify that the correct results are diplayed for {string} on TC{int}")
    public void verifyThatTheCorrectResultsAreDiplayedForOnTC(String dress, int arg1) {

        dealxpage.getAndValidateSearchResultsTC2(dress);
    }

    @And("Search for product")
    public void searchForProduct() throws IOException {

        File f = new File("C:\\Users\\Home\\IdeaProjects\\AutomationPractical\\src\\test\\resources\\Data");

        //create an object of the file reader class
        FileReader fr = new FileReader(f);

        //create an object of buffered reader
        BufferedReader br = new BufferedReader(fr);

        //read and print out contents
        searchproduct = br.readLine();
        System.out.println("I will search for a " + searchproduct);

        //close the file
        br.close();

        dealxpage.setSearchforItem(searchproduct);
    }

    @Then("Verify that the correct results are diplayed for product")
    public void verifyThatTheCorrectResultsAreDiplayedForProduct() {

        dealxpage.getAndValidateSearchResults(searchproduct);
    }

    @And("login into the application using {string} and {string}paasword>\"")
    public void loginIntoTheApplicationUsingAndPaasword(String username, String password) throws Throwable {

        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}

        dealxpage.signInLink.click();
        dealxpage.userNameBox.sendKeys(username);
        dealxpage.passwordBox.sendKeys(password);
        dealxpage.signInBtn.click();

    }

    @And("login into the application using {string} and {string}")
    public void loginIntoTheApplicationUsingAnd(String username, String password) {

        dealxpage.signInLink.click();
        dealxpage.userNameBox.sendKeys(username);
        dealxpage.passwordBox.sendKeys(password);
        dealxpage.signInBtn.click();
    }

    @And("adding to cart and processing")
    public void addingToCartAndProcessing() throws InterruptedException {

        String username = "phill@gmail.com";
        String password = "Pa55word";
        String searchWord = "Printed Chiffon Dress";
        String totalPrice;
        String unitPrice;
        BigDecimal calculatedTotal = null;
        int quantity = 5;


        dealxpage.signInLink.click();
        dealxpage.userNameBox.sendKeys(username);
        dealxpage.passwordBox.sendKeys(password);
        dealxpage.signInBtn.click();

        //input search and click search button
        dealxpage.setSearchforItem(searchWord);
        dealxpage.searchbotton.click();
        dealxpage.firstResultName.click();

        //get unit price and add item to cart and view cart
        unitPrice = dealxpage.unitPrice.getText();
        System.out.println("unit price of " + searchWord + ": $" + unitPrice);
        dealxpage.addToCartBtn.click();
        Thread.sleep(5000);
        dealxpage.proceedToCheckout.click();
        System.out.println(searchWord + " added to cart");

        //update quantity and get displayed total price
        dealxpage.itemQuantity.sendKeys("5");
        Thread.sleep(5000);
        System.out.println("Quantity changed to " + quantity);
        totalPrice = dealxpage.totalPrice.getText();
        System.out.println("Displayed total price is $" + totalPrice);
        totalPrice = dealxpage.totalPrice.getText();

        //compares calculated total and displayed total
        try {
            Assert.assertEquals(totalPrice, calculatedTotal);
        } catch (AssertionError e) {
            System.out.println("The displayed total is Not equal to calculated total, test failed");
            throw e;
        }
        System.out.println("The displayed total is equal to calculated total, test passed");
    }

    @And("adding generic test case")
    public void addingGenericTestCase() throws InterruptedException {

        String menu = "women";
        String subMenu = "evening dresses";

        Actions act = new Actions(driver);

        switch (menu.toLowerCase()) {
            case "women" -> {
                act.moveToElement(dealxpage.WomenMenu).build().perform();
                Thread.sleep(2000);
                List<WebElement> links = driver.findElements((By.tagName("a")));
                int totalCount = links.size();

                for (WebElement element : links) {
                    String menuItem = element.getText();
                    if (subMenu.equalsIgnoreCase(menuItem)) {
                        element.click();
                        Thread.sleep(2000);
                        String pageTitle = driver.getTitle();

                        if (pageTitle.toLowerCase().contains(subMenu)){
                            System.out.println(pageTitle + " page was loaded, test passed.");}
                        else {
                            System.out.println("The incorrect page was loaded");
                        }
                        break;
                    }
                }
            }
            case "dresses" -> {
                act.moveToElement(dealxpage.DressesMenu).build().perform();
                Thread.sleep(2000);
                List<WebElement> dressesLinks = driver.findElements((By.tagName("a")));
                int dressesLinkCount = dressesLinks.size();
                for (WebElement element : dressesLinks) {
                    String menuItem = element.getText();

                    if (subMenu.equalsIgnoreCase(menuItem)) {
                        element.click();
                        Thread.sleep(2000);
                        System.out.println(driver.getTitle() + " page was loaded.");
                        break;
                    }
                }break;
            }
            case "t-shirts" -> {
                act.moveToElement(dealxpage.TshirtsMenu).build().perform();
                Thread.sleep(2000);
                if (subMenu.equalsIgnoreCase("t-shirts")) {
                    dealxpage.TshirtsMenu.click();
                    Thread.sleep(2000);
                    System.out.println(driver.getTitle() + " page was loaded.");
                } else System.out.println("Invalid Menu");
                break;
            }

            default -> System.out.println("Invalid Menu");
        }
    }
}
