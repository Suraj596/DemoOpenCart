package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC003_Login {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4 = new Properties();
	
	//Invoke Constructor
	public TC003_Login() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
	}
	
	@Given("^User should able to access the Application Link$")
	public void user_should_able_to_access_the_Application_Link() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));	    
	}

	@When("^User click My Account and Login$")
	public void user_click_My_Account_and_Login() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
	}

	@When("^User enter EmailAddress and Password$")
	public void user_enter_EmailAddress_and_Password() throws Throwable {
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
	}

	@When("^User click on Login Button$")
	public void user_click_on_Login_Button() throws Throwable {
	    action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@Then("^User should able to Login successfully$")
	public void user_should_able_to_Login_successfully() throws Throwable {
		System.out.println("Login Successfully");
		action.TakeScreenShot("TC003-01-Login");
		action.Quit();
	}
}
