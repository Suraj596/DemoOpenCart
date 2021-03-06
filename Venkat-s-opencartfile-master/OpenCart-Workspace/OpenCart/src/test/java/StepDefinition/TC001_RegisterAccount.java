package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC001_RegisterAccount {
	
	DriverActions action = new DriverActions();
	Properties p1, p2 = new Properties();
	
	//Invoke Constructor
	public TC001_RegisterAccount() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
	}
	
	@Given("^User have access to Open Cart Link$")
	public void user_have_access_to_Open_Cart_Link() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
	}

	@When("^User should click My Account and click Register$")
	public void user_should_click_My_Account_and_click_Register() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p2.getProperty("clickRegister"));
	}

	@When("^User should enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" "
			+ "and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_enter_and_and_and_and_and(String FirstName, String LastName, String Email, 
			String Telephone, String Password, String PasswordConfirm) throws Throwable {
		action.inputValues("xpath", p2.getProperty("inputFirstName"), FirstName);
		action.inputValues("xpath", p2.getProperty("inputLastName"), LastName);
		action.inputValues("xpath", p2.getProperty("inputEmail"), Email);
		action.inputValues("xpath", p2.getProperty("inputTelephone"), Telephone);
		action.inputValues("xpath", p2.getProperty("inputPassword"), Password);
		action.inputValues("xpath", p2.getProperty("inputPasswordConfirm"), PasswordConfirm);
	}

	@When("^User should check Privacy Policy$")
	public void user_should_check_Privacy_Policy() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickPrivacyPolicy"));
	}

	@When("^Click continue$")
	public void click_continue() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickContinue"));
	}

	@Then("^User should able to Create Account successfully$")
	public void user_should_able_to_Create_Account_successfully() throws Throwable {
		System.out.println("Account Created Successfully");
		action.Wait();
		action.TakeScreenShot("TC001-01-AccountCreated");
		action.Quit();
	}
}
