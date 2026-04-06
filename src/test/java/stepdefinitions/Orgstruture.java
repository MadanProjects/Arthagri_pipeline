package stepdefinitions;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import utils.WindowUtils;
	
import config.ConfigReader;
import utils.WebDriverUtils;

	import driver.DriverFactory;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import pages.LoginPage;
	import pages.MyprofileOrgPage;
	import pages.OrgStruturePage;
	import pages.ShareholderPage;

	public class Orgstruture {
		
		WebDriver driver;
		MyprofileOrgPage myprofile_orgPage;
		ShareholderPage shareholderpage;
		OrgStruturePage organisationstructurepage ;
		LoginPage loginpage;
		//private ShareholderPage WebDriverUtils;
		
		@Given("User has navigated to Addresource page in Oraganistion structre")
		public void user_has_navigated_to_addresource_page_in_oraganistion_structre() {
		   
			driver = DriverFactory.initDriver(); 
			DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
			
//			driver.get("https://fpostage.arthagri.in/");
			
//     		loginpage = new LoginPage(driver);
//			loginpage.login("nikhilm@arthagri.in", "123456789");
     		
     		LoginPage loginPage = new LoginPage(driver);
			loginPage.login(
	                config.ConfigReader.getProperty("username"),
	                config.ConfigReader.getProperty("password")
	        );
			
		}

		@When("User enters all valid fields in Addresource")
		public void user_enters_all_valid_fields_in_addresource() throws InterruptedException {
			organisationstructurepage = new OrgStruturePage(driver);
			organisationstructurepage.orgnsationClick();
			By orgStruture = By.xpath("//a[text()='Organization Structure']");
			WebDriverUtils.scrollToElement(driver, orgStruture, 2000);
			organisationstructurepage.orgstructure();
			organisationstructurepage.addresorce();
			organisationstructurepage.osfirstname("birjesh");
			organisationstructurepage.osmiddlename("birjesh");
			organisationstructurepage.oslastname("birjesh");
			organisationstructurepage.osaddress("378/a pune station");
			organisationstructurepage.osgender("male");
			organisationstructurepage.osrole("Manager");
			organisationstructurepage.osmobile("8888555585");
			organisationstructurepage.osemail("as@arthagri.in");
			organisationstructurepage.ospassword("123456789");
			By registerButtonLocator = By.xpath("//button[text()='Register Company Member']");
			WebDriverUtils.scrollToElement(driver, registerButtonLocator, 2000);
			organisationstructurepage.osconfirm_password("123456789");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("bod-check")));
			radioButton.click();
			
			organisationstructurepage.osbodcheck();
			By BodButtonLocator = By.xpath("//input[@id='bod-check']");
			WebDriverUtils.scrollToElement(driver, BodButtonLocator, 2000);
		
		}

		@When("User click RegisterCompanyMember button")
		public void user_click_register_company_member_button() throws InterruptedException {
			organisationstructurepage.oscategory("OBC");
			organisationstructurepage.oslandholding("5");
			organisationstructurepage.ostenants("10");
			organisationstructurepage.oslandlease("10");
			organisationstructurepage.osdesignation("manager");
			organisationstructurepage.oseducation("B.ED");
			organisationstructurepage.ospancard("ABCDE1234A");
			organisationstructurepage.osaadharcard("123441231234");
			organisationstructurepage.oslandbelongstothebOD("yes");
			organisationstructurepage.osotherinfo("yes");
			By registerButtonLocator = By.xpath("//button[text()='Register Company Member']");
			WebDriverUtils.scrollToElement(driver, registerButtonLocator, 2000);
			organisationstructurepage.osRegister();
			
		}

		@Then("User should get successfull entry on listing page")
		public void user_should_get_successfull_entry_on_listing_page() {
			
			String parent = driver.getWindowHandle();
			
			// switch
			WindowUtils.switchToNewTab(driver);

			// do actions in new tab

			driver.close();
			driver.switchTo().window(parent);
		}
		
		
		
		
	}


