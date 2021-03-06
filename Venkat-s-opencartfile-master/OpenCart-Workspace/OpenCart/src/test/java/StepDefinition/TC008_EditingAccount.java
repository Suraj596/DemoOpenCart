package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import OpenCart.FunctionalLibrary.DriverActions;
import OpenCart.Logs.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC008_EditingAccount {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5 = new Properties();
	
	//Invoke Constructor
	public TC008_EditingAccount() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
		p5 = action.getPropertyFile("TC008_EditingAccount");
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}

	@Given("^User able to acces and login to the Application$")
	public void user_able_to_acces_and_login_to_the_Application() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
		action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@When("^User click on Edit Account Information$")
	public void user_click_on_Edit_Account_Information() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickEditAccount"));
	}

	@When("^User update the \"([^\"]*)\" and click Continue$")
	public void user_update_the_and_click_Continue(String LastName) throws Throwable {
		action.clearTextArea("xpath", p5.getProperty("updateLastName"));
		action.inputValues("xpath", p5.getProperty("updateLastName"), LastName);
		action.clickWebElement("xpath", p5.getProperty("clickContinue"));
	}

	@Then("^Account Information should get updated successfully$")
	public void account_Information_should_get_updated_successfully() throws Throwable {
		String getMessage = action.getStoreValue("xpath", p5.getProperty("logMessage"));
		Log.info(getMessage);
		action.Wait();
		action.TakeScreenShot("TC008-01-LogMessage");
	}

	@Then("^User click on Logout and click on Continue to Return to Home Page$")
	public void user_click_on_Logout_and_click_on_Continue_to_Return_to_Home_Page() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickLogout"));
		action.clickWebElement("xpath", p5.getProperty("clickConLogout"));
		action.Quit();
	}	
}
