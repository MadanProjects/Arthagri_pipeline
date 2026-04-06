package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyprofileOrgPage {
	
	
	WebDriver driver;
	

	public MyprofileOrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//elementutils = new ElementUtils()
	}

	
	
	@FindBy (xpath = "//span[text()='Organization']")
	private WebElement Orgnisation;
	@FindBy(xpath="//a[text()='Company Profile']") 
	private WebElement companyprfile;
	@FindBy(xpath="//a[text()='My Profile']") 
	private WebElement myprfile;
	@FindBy(xpath="//a[text()='Shareholder Management']")
	private WebElement Sharehold;



	@FindBy(xpath="//input[@placeholder='First Name']") 
	private WebElement firstname;
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	private WebElement middlename ;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastname;
	@FindBy(xpath="//input[@id='mobilenumber']")
	private WebElement mobilenumber ;
	@FindBy(xpath="//button[@type=\"submit\"][1]")
	private WebElement submit;
	@FindBy(xpath=" //li[text()='The email has already been taken.']") 
	private WebElement errormssage;
	
	
	
	public void orgnsationClick() {
		Orgnisation.click();
	}

	public void CompanyprfleClick() {
		companyprfile.click();
	}

	public void myprofileClick() {
		myprfile.click();
	}

	//////////////////
	
	public void firstname(String title)  {
		firstname.clear();
	
		firstname.sendKeys(title);
	}
	public void midlename(String title)  {
		middlename.clear();
	
		middlename.sendKeys(title);
	}
	public void lstname(String title)  {
		lastname.clear();
		
		lastname.sendKeys(title);
	}
	public void mobilenumber(String title)  {
		mobilenumber.clear();
		
		mobilenumber.sendKeys(title);
	}
	public void Submit()  {

		submit.click();
	}

	public void erormssage()  {

		String actualmessage = errormssage.getText();
		System.out.println(actualmessage);
	
	}

	/////////////////////////////////
	
	
	
	
	
}
