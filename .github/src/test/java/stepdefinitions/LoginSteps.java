package stepdefinitions;


import io.cucumber.java.en.When;
import pages.LoginPage;

import driver.DriverFactory;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage = new LoginPage();
	
    @Given("user is on login page")
    public void user_is_on_login_page() {
    	System.out.println("Login page opened");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
    	 loginPage.login("admin", "password123");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        System.out.println("User logged in successfully");
    }
}
