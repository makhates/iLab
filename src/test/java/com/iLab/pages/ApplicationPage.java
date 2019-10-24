package com.iLab.pages;

import com.iLab.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage {

    private WebDriver driver;

    public ApplicationPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Application page elements: Author by Dr Phill

    @FindBy(how = How.XPATH,using = "/html/body/header/div/div/div[3]/nav/ul/li[4]/a")
    public WebElement careers;

    @FindBy(how = How.CSS, using = "div.vc_btn3-container:nth-child(9)")
    public WebElement country;

    @FindBy(how = How.CSS, using = "div.wpjb-grid-row:nth-child(1) > div:nth-child(2) > span:nth-child(1) > a:nth-child(1)")
    public WebElement availableJob;

    @FindBy(how = How.CSS, using = ".wpjb-form-toggle")
    public WebElement applyOnline;

    @FindBy(how = How.ID, using = "applicant_name")
    public WebElement applicantName;

    @FindBy(how = How.ID, using = "email")
    public WebElement applicantEmail;

    @FindBy(how = How.ID, using = "phone")
    public WebElement applicantPhone;

    @FindBy(how = How.CSS, using = "#wpjb_submit")
    public WebElement sendApplication;

    @FindBy(how = How.XPATH, using = "//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li")
    public WebElement UploadMessage;
}
