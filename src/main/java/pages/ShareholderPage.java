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

public class ShareholderPage {

	
	WebDriver driver;

	public ShareholderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//elementutils = new ElementUtils()
	}

	@FindBy(xpath="//span[text()='Organization']")
	private WebElement Orgnisation;
	@FindBy(xpath="//a[contains(text(),'Shareholder')]") 
	private WebElement Sharehold;


	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement Searchfield;

	
	@FindBy(xpath=("//a[normalize-space()='Manage Account']"))
	private WebElement manageacc;
	@FindBy(xpath=("//input[@id='share_held_add']"))
	private WebElement share_held;
	@FindBy(xpath=("//input[@id='face_value_add']"))
	private WebElement face_digit;
	@FindBy(xpath=("//input[@id='amount_add']")) 
	private WebElement amount;
	@FindBy(xpath=("(//textarea[@id='textarea'])[1]")) 
	private WebElement folio;
	@FindBy(xpath=("//textarea[@id='remark']"))
	private WebElement mark;
	@FindBy(xpath=("//button[@onclick='closePopupAmountDetails()']"))
	private WebElement closebttn;
	@FindBy(xpath=("//button[text()='Submit']"))
	private WebElement submitbttn;
	@FindBy(xpath=("//div[@role='success']"))
	public WebElement successmsg;
	
	
	public void orgnsationClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Orgnisation)).click();
	}

	
	public void shareholder(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1000,0)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(Sharehold)).click();
		
	
	}

	public void search(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		
		Searchfield.sendKeys(title);
	}
	
	public void srmanageaccount(){
		manageacc.click();

	}

	public void srshare_held_add(String title) {
		share_held.sendKeys(title);;

	}

	public void srface_value_add(String title) {
		face_digit.sendKeys(title);

	}
	public void sramount_add() {
		amount.click();

	}

	public void srfolio_no(String title) {
		folio.sendKeys(title);

	}

	public void srremark(String title) {
		mark.sendKeys(title);

	}
	public void srclosepopup() {
		closebttn.click();;

	}
	public void srsubmit() {
		submitbttn.click();;

	}
	public String srsuccessmsg() {
		return successmsg.getText();

	}


	// Method to scroll to an element and optionally wait before interacting
//	public static void scrollToElement(WebDriver driver, By locator, int waitTimeInMillis) {
//		try {
//			// Find the element by locator
//			WebElement element = driver.findElement(locator);
//
//			// Use JavaScriptExecutor to scroll to the element
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", element);
//
//			// Wait for a specified amount of time (optional, for observation purposes)
//			Thread.sleep(waitTimeInMillis);
//
//			// Click the element after scrolling
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
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

}
