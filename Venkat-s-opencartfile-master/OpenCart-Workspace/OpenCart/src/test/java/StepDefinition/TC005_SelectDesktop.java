package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import OpenCart.FunctionalLibrary.DriverActions;
import OpenCart.Logs.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC005_SelectDesktop {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5 = new Properties();
	
	//Invoke Constructor
	public TC005_SelectDesktop() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC001_RegisterAccount");
		p3 = action.getPropertyFile("TC003_Login");
		p4 = action.getPropertyFile("LoginCredientials");
		p5 = action.getPropertyFile("TC005_SelectDesktop");
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	
	@Given("^User able to Login the Application$")
	public void user_able_to_Login_the_Application() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
		action.clickWebElement("xpath", p2.getProperty("clickMyAccount"));
		action.clickWebElement("xpath", p3.getProperty("clickLogin"));
		action.inputValues("xpath", p3.getProperty("inputEmailAddress"), p4.getProperty("EmailAddress"));
		action.inputValues("xpath", p3.getProperty("inputPassword"), p4.getProperty("Password"));
		action.clickWebElement("xpath", p3.getProperty("clickLoginButton"));
	}

	@When("^User mouseover on desktop$")
	public void user_mouseover_on_desktop() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickDesktop"));
	}

	@When("^User click Mac from the dropdown$")
	public void user_click_Mac_from_the_dropdown() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickMac"));
	}

	@When("^User click Add to Cart$")
	public void user_click_Add_to_Cart() throws Throwable {
		action.clickWebElement("xpath", p5.getProperty("clickAddtoCart"));
	}

	@Then("^User should able to log Success Message successfully$")
	public void user_should_able_to_log_Success_Message_successfully() throws Throwable {
		action.ExplicitWait(p5.getProperty("getSuccessMessage"));
		String SuccessMessage = action.getStoreValue("xpath", p5.getProperty("getSuccessMessage"));
		Log.info(SuccessMessage);
		action.Wait();
		action.TakeScreenShot("TC005-01-SuccessMessage");
		action.Quit();
	}
}
