package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;
import utilities.LoggerClass;
import utilities.Screenshot_Class;

public class TC8_EditAccount extends base {
	/****************************************************************************
    '* NAME                : EditAccount
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	
	public TC8_EditAccount() {
		
		DOMConfigurator.configure("LogXML\\log4j.xml");
	}
	public void EditAccount() throws Exception {

		TC8_EditAccount ob = new TC8_EditAccount();
		ob.initializeDriver();

		File src = new File("F:\\Wells fargo\\OpenCart\\credentials.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("OpenCart");
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		String changelastname = sheet.getRow(1).getCell(5).getStringCellValue();
		wb.close();

		
		driver.get(obj.getProperty("url"));
		driver.findElement(By.xpath(obj.getProperty("myaccount"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("login"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();
		driver.findElement(By.xpath(obj.getProperty("editaccount"))).click();
		driver.findElement(By.xpath(obj.getProperty("lastname"))).clear();
		driver.findElement(By.xpath(obj.getProperty("lastname"))).sendKeys(changelastname);
		driver.findElement(By.xpath(obj.getProperty("continue"))).click();
		ob.waitFor();
		
		String result = driver.findElement(By.xpath(obj.getProperty("log"))).getText();
		LoggerClass.info(result);
		Screenshot_Class.screenshot(driver);
		driver.findElement(By.xpath(obj.getProperty("logout"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("clickcontinue"))).click();
		
	}
}
