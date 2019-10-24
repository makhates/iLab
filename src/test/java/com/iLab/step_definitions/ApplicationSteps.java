package com.iLab.step_definitions;

import com.iLab.pages.ApplicationPage;
import com.iLab.utilities.ConfigurationReader;
import com.iLab.utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;


public class ApplicationSteps {

    ApplicationPage applyPage = new ApplicationPage();
    private WebDriver driver = Driver.getDriver();
    Logger log = Logger.getLogger(ApplicationSteps.class);

    @And("^User applies for a preferred position \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userAppliesForAPreferredPosition(String Name, String Email, String PhoneNumber) throws Throwable {


        try {
            //capturing application details and submit
            applyPage.applicantName.clear();
            applyPage.applicantName.sendKeys(Name);

            applyPage.applicantEmail.clear();
            applyPage.applicantEmail.sendKeys(Email);

            applyPage.applicantPhone.clear();
            applyPage.applicantPhone.sendKeys(PhoneNumber);

            applyPage.sendApplication.click();
        }catch (Exception err)
        {
            log.info("unable to capture all application details " + err.getMessage());
        }

    }

    @Then("^Excepted error message to upload documents is displayed$")
    public void exceptedErrorMessageToUploadDocumentsIsDisplayed() {


        //validating that the error message is displayed
        try {
            String isTheTextDisplayed = applyPage.UploadMessage.getText();


            if(isTheTextDisplayed.equalsIgnoreCase("You need to upload at least one file.")) {

                log.info("Successful validation");

            }else {

                log.info("UnSuccessful validation");
                Assert.fail();
            }

        }
        catch(Exception error)
        {

            log.info(error.getMessage());

        }
    }

    @Given("^The user is navigated to the dashboard$")
    public void theUserIsNavigatedToTheDashboard() throws Exception
    {

        try {
            //loading the home page
            driver.get(ConfigurationReader.getProperty("url"));
            WebDriver driver= Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }catch (Exception err){
           log.info("failed to load home page " + err.getMessage());
        }

    }

    @Then("^User navigates to apply page$")
    public void userNavigatesToApplyPage() throws Exception {

        try {
            //User navigates to apply page
            applyPage.careers.click();
            applyPage.country.click();
            applyPage.availableJob.click();
            applyPage.applyOnline.click();
        }catch (Exception err)
        {
           log.info("unable to navigate to apply page" + err.getMessage());
        }
    }

}
