package StepDefinition;

import java.io.IOException;
import java.util.Properties;

import OpenCart.FunctionalLibrary.DriverActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC007_PlaceOrderRegisterAccountCheckout {
	
	DriverActions action = new DriverActions();
	Properties p1, p2, p3, p4, p5 = new Properties();
	
	//Invoke Constructor
	public TC007_PlaceOrderRegisterAccountCheckout() throws IOException {
		p1 = action.getPropertyFile("AppLink");
		p2 = action.getPropertyFile("TC006_PlaceOrderGuestCheckout");
		p3 = action.getPropertyFile("TC007_PlaceOrderRegisterAccountCheckout");
	}
	
	
	@Given("^User should able to Login with User Credentials$")
	public void user_should_able_to_Login_with_User_Credentials() throws Throwable {
		action.getBrowser("Chrome");
		action.getWebLink(p1.getProperty("getAppLink"));
	}

	@When("^User click Laptops and Notebooks$")
	public void user_click_Laptops_and_Notebooks() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickLaptopsandNotebooks"));
	}

	@When("^User click on Show all Laptops and Notebooks$")
	public void user_click_on_Show_all_Laptops_and_Notebooks() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickShowAll"));
	}

	@When("^User select Laptop Type$")
	public void user_select_Laptop_Type() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("selectLaptop"));
	}

	@When("^User change \"([^\"]*)\" to future$")
	public void user_change_to_future(String DeliveryDate) throws Throwable {
		action.clearTextArea("xpath", p2.getProperty("inputDeliveryDate"));
		action.inputValues("xpath", p2.getProperty("inputDeliveryDate"), DeliveryDate);
	}

	@When("^User click on Add to Cart Button$")
	public void user_click_on_Add_to_Cart_Button() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickAddtoCart"));
	}

	@When("^User click on Items Basket$")
	public void user_click_on_Items_Basket() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickShoppingCart"));
	}

	@When("^User click on Check Out Button$")
	public void user_click_on_Check_Out_Button() throws Throwable {
		action.ExplicitWait(p2.getProperty("clickCheckout"));
		action.clickWebElement("xpath", p2.getProperty("clickCheckout"));
	}
	
	@When("^User click on Register Account Checkout Button and click Continue$")
	public void user_click_on_Register_Account_Checkout_Button_and_click_Continue() throws Throwable {
		action.ExplicitWait(p3.getProperty("clickRegisterCheckout"));
		action.clickWebElement("xpath", p3.getProperty("clickRegisterCheckout"));
		action.clickWebElement("xpath", p2.getProperty("clickGuestContinue"));
	}
	
	@When("^User enter the Mandatory Fields \"([^\"]*)\" and \"([^\"]*)\" and "
			+ "\"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" "
			+ "and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_Mandatory_Fields_and_and_and_and_and_and_and_and_and_and(String FirstName, 
			String LastName, String Email, String Telephone, String Password, String ConfirmPassword, 
			String Address, String City, String PostalCode, String Country, String RegionState) 
					throws Throwable {
		action.ExplicitWait(p2.getProperty("inputFirstName"));
		action.inputValues("xpath", p2.getProperty("inputFirstName"), FirstName);
		action.inputValues("xpath", p2.getProperty("inputLastName"), LastName);
		action.inputValues("xpath", p2.getProperty("inputEmail"), Email);
		action.inputValues("xpath", p2.getProperty("inputTelephone"), Telephone);
		action.inputValues("xpath", p3.getProperty("inputPassword"), Password);
		action.inputValues("xpath", p3.getProperty("inputConfirmPassword"), ConfirmPassword);
		action.inputValues("xpath", p2.getProperty("inputAddress"), Address);
		action.inputValues("xpath", p2.getProperty("inputCity"), City);
		action.inputValues("xpath", p2.getProperty("inputPostalCode"), PostalCode);
		action.SelList("xpath", p2.getProperty("selectCountry"), Country);
		action.Wait();
		action.SelList("xpath", p2.getProperty("selectRegion/State"), RegionState);
	}

	@When("^User click on Privacy Policy and click Continue$")
	public void user_click_on_Privacy_Policy_and_click_Continue() throws Throwable {
		action.clickWebElement("xpath", p3.getProperty("clickPrivacyPolicy"));
		action.ExplicitWait(p3.getProperty("clickContinue"));
		action.clickWebElement("xpath", p3.getProperty("clickContinue"));
		action.ExplicitWait(p3.getProperty("clickContinueShip"));
		action.clickWebElement("xpath", p3.getProperty("clickContinueShip"));
		
	}
	
	@When("^User \"([^\"]*)\" under Delivery Method and click Continue$")
	public void user_under_Delivery_Method_and_click_Continue(String Addcomments) throws Throwable {
		action.ExplicitWait(p2.getProperty("inputComment"));
		action.inputValues("xpath", p2.getProperty("inputComment"), Addcomments);
	}

	@When("^User check in Terms and Conditions and click Continue$")
	public void user_check_in_Terms_and_Conditions_and_click_Continue() throws Throwable {
		action.clickWebElement("xpath", p2.getProperty("clickContinue3"));
		action.ExplicitWait(p2.getProperty("clickTerms"));
		action.clickWebElement("xpath", p2.getProperty("clickTerms"));
		action.clickWebElement("xpath", p2.getProperty("clickContinue4"));
	}

	@When("^User click on Confirm Order$")
	public void user_click_on_Confirm_Order() throws Throwable {
		action.ExplicitWait(p2.getProperty("clickConfirmOrder"));
		action.clickWebElement("xpath", p2.getProperty("clickConfirmOrder"));
	}

	@Then("^Order should Placed Successfully$")
	public void order_should_Placed_Successfully() throws Throwable {
		action.Wait();
		action.TakeScreenShot("TC007-01-OrderConfirmation");
		action.Quit();
	}
}
