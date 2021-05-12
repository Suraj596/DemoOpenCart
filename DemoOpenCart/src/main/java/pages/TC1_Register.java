package pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import root.base;

public class TC1_Register extends base {
	
	 /****************************************************************************
    '* NAME                : Register
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	
		public void Register() throws Exception {
		
		TC1_Register ob= new TC1_Register();
		ob.initializeDriver();
		
		File src = new File("F:\\Wells fargo\\OpenCart\\credentials.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("OpenCart");
		String Fname = sheet.getRow(1).getCell(0).getStringCellValue();
		String Lname = sheet.getRow(1).getCell(1).getStringCellValue();
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		long Telephone = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		wb.close();

		driver.get(obj.getProperty("url"));
		driver.findElement(By.xpath(obj.getProperty("myaccount"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("register"))).click();
		driver.findElement(By.xpath(obj.getProperty("firstname"))).sendKeys(Fname);
		driver.findElement(By.xpath(obj.getProperty("lastname"))).sendKeys(Lname);
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("telephone"))).sendKeys(String.valueOf(Telephone));
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("confirmpassword"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("checkbox"))).click();
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();

	}

}
