package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;
import utilities.Screenshot_Class;

public class TC5_Tab extends base {
	
	public void Tab() throws Exception {
		
		TC5_Tab ob = new TC5_Tab();
		ob.initializeDriver();	
		
		File src = new File("F:\\Wells fargo\\OpenCart\\credentials.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("OpenCart");
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		wb.close();

		driver.get(obj.getProperty("url"));
		driver.findElement(By.xpath(obj.getProperty("myaccount"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("login"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("desktop"))).click();
		driver.findElement(By.xpath(obj.getProperty("mac"))).click();
		driver.findElement(By.xpath(obj.getProperty("cart"))).click();
		ob.waitFor();
		Screenshot_Class.screenshot(driver);
	}
}
