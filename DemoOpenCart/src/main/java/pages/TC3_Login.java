package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;

public class TC3_Login extends base{
	
	/****************************************************************************
    '* NAME                : Login
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : 	Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	 
		public void Login() throws Exception {
		
		TC3_Login ob = new TC3_Login();
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
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();
	}
}
