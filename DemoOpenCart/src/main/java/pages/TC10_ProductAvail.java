package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;
import utilities.Screenshot_Class;

public class TC10_ProductAvail extends base {
	/****************************************************************************
    '* NAME                : ProductAvail
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : 	Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	public void ProductAvail() throws Exception {
		
		TC10_ProductAvail ob = new TC10_ProductAvail();
		ob.initializeDriver();	
		

		File src = new File("F:\\Wells fargo\\OpenCart\\credentials.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("OpenCart");
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		String Iphone = sheet.getRow(1).getCell(9).getStringCellValue();
		long quantity = (long)sheet.getRow(1).getCell(10).getNumericCellValue();
		wb.close();
		
		driver.get(obj.getProperty("url"));
		driver.findElement(By.xpath(obj.getProperty("myaccount"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("login"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();
		driver.findElement(By.xpath(obj.getProperty("iphone"))).sendKeys(Iphone);
		driver.findElement(By.xpath(obj.getProperty("search"))).click();
		driver.findElement(By.xpath(obj.getProperty("selectiphone"))).click();
		driver.findElement(By.xpath(obj.getProperty("quantity"))).click();
		driver.findElement(By.xpath(obj.getProperty("quantity"))).clear();
		driver.findElement(By.xpath(obj.getProperty("quantity"))).sendKeys(String.valueOf(quantity));
		driver.findElement(By.xpath(obj.getProperty("buttoncart"))).click();
		driver.findElement(By.xpath(obj.getProperty("itemcart"))).click();
		driver.findElement(By.xpath(obj.getProperty("checkout"))).click();
		Screenshot_Class.screenshot(driver);
	}
}
