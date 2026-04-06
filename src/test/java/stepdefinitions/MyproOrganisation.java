package stepdefinitions;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import driver.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.MyprofileOrgPage;
import utils.WindowUtils;

public class MyproOrganisation {

	
	WebDriver driver;
	MyprofileOrgPage myprofile_orgPage;
	LoginPage loginpage;
	
	
@Given("User has navigated to Myprofile page")
public void user_has_navigated_to_myprofile_page() {
//	   driverfactory = new driverfactory();
//	   driver = driverfactory.getDriver();
//	   driver.get("https://fpostage.arthagri.in/");
//	   loginpage = new LoginPage(driver);
//	   loginpage.enterEmailAddress("nikhilm@arthagri.in");
//	   loginpage.enterPassword("123456789");
//	   loginpage.clickLoginButton();
	   
		driver = DriverFactory.initDriver(); 
		DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
		
//		driver.get("https://fpostage.arthagri.in/");
		
// 		loginpage = new LoginPage(driver);
//		loginpage.login("nikhilm@arthagri.in", "123456789");
 		
 		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(
                config.ConfigReader.getProperty("username"),
                config.ConfigReader.getProperty("password")
        );
	   
}

@When("User enters all valid input fields")
public void user_enters_all_valid_input_fields()  {
	
	myprofile_orgPage = new MyprofileOrgPage(driver);
	 
	 myprofile_orgPage.orgnsationClick();
	 myprofile_orgPage.myprofileClick();
	 myprofile_orgPage.firstname("biru");
	 myprofile_orgPage.midlename("biru");
	 myprofile_orgPage.lstname("biru");
	 myprofile_orgPage.mobilenumber("9874561230");
	 
}

@When("User click enter button")
public void user_click_enter_button() {
	myprofile_orgPage.Submit();
}

@Then("User should get successfully message")
public void user_should_get_successfully_message() {
	myprofile_orgPage.erormssage();
	
	String parent = driver.getWindowHandle();
    
	// switch
	WindowUtils.switchToNewTab(driver);
	
	// do actions in new tab
	driver.close();
	driver.switchTo().window(parent);
	
}
}