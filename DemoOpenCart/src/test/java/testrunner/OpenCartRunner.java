package testrunner;

import org.testng.annotations.Test;

import pages.TC10_ProductAvail;
import pages.TC1_Register;
import pages.TC2_RegisterFailure;
import pages.TC3_Login;
import pages.TC4_VerifyTtitle;
import pages.TC5_Tab;
import pages.TC8_EditAccount;
import pages.TC9_UploadFile;
import root.base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



public class OpenCartRunner extends base {

	TC1_Register register;
	TC2_RegisterFailure registerfailure;
	TC3_Login login;
	TC4_VerifyTtitle verifytitle;
	TC5_Tab tab;
	TC8_EditAccount editaccount;
	TC9_UploadFile uploadfile;
	TC10_ProductAvail productavail;

	public OpenCartRunner() {
		super();

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {

		register = new TC1_Register();
		registerfailure = new TC2_RegisterFailure();
		login = new TC3_Login();
		verifytitle = new TC4_VerifyTtitle();	
		tab = new TC5_Tab();
		editaccount = new TC8_EditAccount();
		uploadfile = new TC9_UploadFile();
		productavail = new TC10_ProductAvail();
	}

	@Test(priority = 0, enabled = true)

	public void TC1Register() throws Exception {

		register.Register();
	}

	@Test(priority = 1, enabled = true)
	public void TC2RegisterFailure() throws Exception {
		registerfailure.RegisterFailure();
	}

	@Test(priority = 2, enabled = true)
	public void TC3_Login() throws Exception {
		login.Login();
	}

	@Test(priority = 3, enabled = true)
	public void TC4_VerifyTtitle() throws Exception {
		verifytitle.VerifyTitle();
	}

	@Test(priority = 4, enabled = true)
	public void TC5_Tab() throws Exception {
		tab.Tab();
	}

	@Test(priority = 5, enabled = true)
	public void TC8_EditAccount() throws Exception {

		editaccount.EditAccount();

	}

	@Test(priority = 6, enabled = true)
	public void TC9_UploadFile() throws Exception {
		uploadfile.UploadFile();
	}

	@Test(priority = 7, enabled = true)
	public void TC10_ProductAvail() throws Exception {
		productavail.ProductAvail();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}

