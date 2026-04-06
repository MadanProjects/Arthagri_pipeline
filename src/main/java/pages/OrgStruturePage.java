package pages;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


	import io.cucumber.java.en.*;

	public class OrgStruturePage {

		WebDriver driver;

		public OrgStruturePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			//elementutils = new ElementUtils()
		}

		@FindBy(xpath="//span[text()='Organization']")
		private WebElement Orgnisation;
		@FindBy(xpath="//a[text()='Organization Structure']") 
		private WebElement organizationstructure;
		@FindBy(xpath="//a[text()='Add Resource']") 
		private WebElement addresource;
		@FindBy(xpath="//input[@id='firstname']")
		private WebElement osfistname;
		@FindBy(xpath="//input[@id='middlename']") 
		private WebElement osmidname;
		@FindBy(xpath="//input[@id='lastname']")
		private WebElement oslasname;
		@FindBy(xpath="//input[@id='address']")
		private WebElement osadres;
		@FindBy(xpath="//select[@id='gender']") 
		private WebElement osgnder;
		@FindBy(xpath="//option[text()='Male'][1]") 
		private WebElement osmale;
		@FindBy(xpath="//input[@role='textbox']") 
		private WebElement ostextbox;
		@FindBy(xpath="//li[text()='Manager']")
		private WebElement osManager;
		@FindBy(xpath="//input[@id='mobile']") 
		private WebElement osmobnumber;
		@FindBy(xpath="//input[@id='email']") 
		private WebElement osmail;
		@FindBy(xpath="//input[@id='password']") 
		private WebElement ospasword;
		@FindBy(xpath="//input[@id='confirm_password']")
		private WebElement osconfirm_pasword;
		@FindBy(xpath="//input[@id='bod-check']")
		private WebElement osbod;
		@FindBy(xpath="//select[@id='category']") 
		private WebElement oscategry;
		@FindBy(xpath="//option[text()='Open / General']")
		private WebElement osOpenGeneral;
		@FindBy(xpath="//input[@id='land-holding']")
		private WebElement oslandhold;
		@FindBy(xpath="//input[@id='tenants']") 
		private WebElement ostents;
		@FindBy(xpath="//input[@id='land-lease']") 
		private WebElement oslandleas;
		@FindBy(xpath="//input[@id='designation']")
		private WebElement osdesnation;
		@FindBy(xpath="//input[@id='education']")
		private WebElement osedu;
		@FindBy(xpath="//input[@id='pan']") 
		private WebElement ospan;
		@FindBy(xpath="//input[@id='aadhar']")
		private WebElement osaadhar;
		@FindBy(xpath="//select[@id='women']") 
		private WebElement oswomen;
		@FindBy(xpath="//option[text()='Yes'][1]")
		private WebElement osYes;
		@FindBy(xpath="//select[@id='saat-bara']") 
		private WebElement ossaatbara;
		@FindBy(xpath="//input[@id='command']")
		private WebElement oscommand;


		@FindBy(xpath="//button[text()='Register Company Member']")
		private WebElement Registerbutton;
		
		@FindBy(xpath="//a[text()='Manage Agencies']")
		private WebElement Agencies;



		public void orgnsationClick() {
			Orgnisation.click();
		}

		public void orgstructure() throws InterruptedException {
			organizationstructure.click();

		}

		public void addresorce() throws InterruptedException {
			addresource.click();

		}

		public void osfirstname(String title) throws InterruptedException {
			osfistname.clear();

			osfistname.sendKeys(title);
		}

		public void osmiddlename(String title) throws InterruptedException {
			osmidname.clear();

			osmidname.sendKeys(title);
		}

		public void oslastname(String title) throws InterruptedException {
			oslasname.clear();

			oslasname.sendKeys(title);
		}
		public void osaddress(String title) throws InterruptedException {


			osadres.sendKeys(title);
		}

		public void osgender(String title) throws InterruptedException {


			osgnder.sendKeys(title);
		}
		public void osmale(String title) throws InterruptedException {


			osmale.sendKeys(title);
		}

		public void osmobile(String title) throws InterruptedException {


			osmobnumber.sendKeys(title);
		}
		public void osrole(String title) throws InterruptedException {


			ostextbox.sendKeys(title);
		}

		public void osManager(String title) throws InterruptedException {


			osManager.sendKeys(title);
		}

		public void osemail(String title) throws InterruptedException {
			osmail.clear();

			osmail.sendKeys(title);
		}
		

		public static void scrollToElement(WebDriver driver, By locator, int waitTimeInMillis) {
			try {
				// Create a WebDriverWait instance to wait for the element to be visible
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				// Wait for the element to be visible
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				// Use JavaScriptExecutor to scroll to the element
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);

				// Wait for a specified amount of time (optional, for observation purposes)
				Thread.sleep(waitTimeInMillis);

				// Click the element after scrolling
				// element.click(); // You can replace this with any other interaction you need

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}



		public void ospassword(String title) throws InterruptedException {


			ospasword.clear();

			ospasword.sendKeys(title);

		}

		public void osconfirm_password(String title) throws InterruptedException {
			osconfirm_pasword.clear();

			osconfirm_pasword.sendKeys(title);
		}

		public void osbodcheck() throws InterruptedException {

			osbod.click();
			}


		public void oscategory(String title) throws InterruptedException {

			oscategry.sendKeys(title);

		}


		public void oslandholding(String title) throws InterruptedException {

			oslandhold.sendKeys(title);

		}

		public void ostenants(String title) throws InterruptedException {

			ostents.sendKeys(title);

		}
		public void oslandlease(String title) throws InterruptedException {

			oslandleas.sendKeys(title);

		}

		public void osdesignation(String title) throws InterruptedException {

			osdesnation.sendKeys(title);

		}

		public void oseducation(String title) throws InterruptedException {

			osedu.sendKeys(title);

		}

		public void ospancard(String title) throws InterruptedException {
			
			ospan.sendKeys(title);

		}
		public void osaadharcard(String title) throws InterruptedException {

			osaadhar.sendKeys(title);

		}
		public void oslandbelongstothebOD(String title) throws InterruptedException {

			ossaatbara.sendKeys(title);

		}


		public void osotherinfo(String title) throws InterruptedException {

			oscommand.sendKeys(title);

		}
		
		public void osRegister() throws InterruptedException {

			Registerbutton.click();

		}
	}


