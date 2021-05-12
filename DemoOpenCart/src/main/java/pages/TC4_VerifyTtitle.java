package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;

public class TC4_VerifyTtitle  extends base{
	/****************************************************************************
    '* NAME                : VerifyTitle
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : 	Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	
	public void VerifyTitle() throws Exception {
		
	TC4_VerifyTtitle ob = new TC4_VerifyTtitle();
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
	driver.findElement(By.xpath(obj.getProperty("title"))).click();
}
}
