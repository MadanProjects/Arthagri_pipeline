package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.MyprofileOrgPage;
import pages.ShareholderPage;
import utils.WindowUtils;
import config.ConfigReader;

public class ShreholderPage {


	WebDriver driver;
	MyprofileOrgPage myprofile_orgPage;
	ShareholderPage shareholderpage;
	LoginPage loginpage;
	private ShareholderPage WebDriverUtils;


	@Given("User has navigated to ManageAccount page in Shareholder")
	public void user_has_navigated_to_manage_account_page_in_shareholder() {
		driver = DriverFactory.initDriver(); 
		DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));

		driver.get("https://fpostage.arthagri.in/");
		loginpage = new LoginPage(driver);
		
//		driverfactory = new driverfactory();
//		driver = driverfactory.getDriver();
		
		
//		Properties prop = configReader.intializeProperties();
//
//		String email = prop.getProperty("email");
//		String password = prop.getProperty("Password");
//
//		loginpage.enterEmailAddress(email);
//		loginpage.enterPassword(password);
//		loginpage.clickLoginButton();
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(
                config.ConfigReader.getProperty("username"),
                config.ConfigReader.getProperty("password")
        );

		
		
	}

	@When("User enters all valid fields")
	public void user_enters_all_valid_fields() throws InterruptedException  {
		shareholderpage = new ShareholderPage(driver);
		shareholderpage.orgnsationClick();
	
		shareholderpage.shareholder();
		shareholderpage.search("Pratiksha Efgh");
		By manageaccountButtonLocator = By.xpath("//a[contains(text(),'Manage Account')][1]");
		shareholderpage.scrollToElement(driver, manageaccountButtonLocator, 2000);
        
        shareholderpage.srmanageaccount();
        shareholderpage.srshare_held_add("500");
		shareholderpage.srface_value_add("500");
		shareholderpage.sramount_add();
		//or.srfolio_no("123542");
		shareholderpage.srremark("all done");
		
	}

	@And("User click Submit button")
	public void user_click_submit_button() {
		shareholderpage.srsubmit();
	}

	@Then("User should get successfull message")
	public void user_should_get_successfull_message() {

//     shareholderpage.srsuccessmsg();
//		String msg = shareholderpage.srsuccessmsg();
//		Assert.assertTrue(msg.contains("Success"));
	
    	String parent = driver.getWindowHandle();
	    
		// switch
		WindowUtils.switchToNewTab(driver);
		
		// do actions in new tab
		driver.close();
		driver.switchTo().window(parent);
	}


}
