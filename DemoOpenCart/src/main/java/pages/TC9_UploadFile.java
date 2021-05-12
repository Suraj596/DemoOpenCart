package pages;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import root.base;
import utilities.Screenshot_Class;

public class TC9_UploadFile extends base{

	/****************************************************************************
    '* NAME                : UploadFile
    '* APPLICATION NAME    : OpenCart
    '* CREATED BY        : 	Suraj Sahoo
    '* CREATED DATE        : 10-05-2021
    '* PARAMETERS        : NA
    '***************************************************************************/
	public void UploadFile() throws Exception {
		
		TC9_UploadFile ob = new TC9_UploadFile();
		ob.initializeDriver();	
		
		File src = new File("F:\\Wells fargo\\OpenCart\\credentials.xlsx");
		FileInputStream input = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("OpenCart");
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		String textarea = sheet.getRow(1).getCell(6).getStringCellValue();
		
		Date date = sheet.getRow(1).getCell(7).getDateCellValue();
		String dateFromat = new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date datetime = sheet.getRow(1).getCell(8).getDateCellValue();
		String dateTimeFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(datetime);
		wb.close();
		
		driver.get(obj.getProperty("url"));
		driver.findElement(By.xpath(obj.getProperty("myaccount"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("login"))).click();
		ob.waitFor();
		driver.findElement(By.xpath(obj.getProperty("email"))).sendKeys(Email);
		driver.findElement(By.xpath(obj.getProperty("password"))).sendKeys(Pass);
		driver.findElement(By.xpath(obj.getProperty("submit"))).click();
		driver.findElement(By.xpath(obj.getProperty("components"))).click();
		driver.findElement(By.xpath(obj.getProperty("monitors"))).click();
		driver.findElement(By.xpath(obj.getProperty("cinema30"))).click();
		driver.findElement(By.xpath(obj.getProperty("clickcheckbox"))).click();
		driver.findElement(By.xpath(obj.getProperty("clicktext"))).click();
		Select dropdown = new Select(driver.findElement(By.name(obj.getProperty("select"))));
	    dropdown.selectByVisibleText(obj.getProperty("blue"));
		driver.findElement(By.xpath(obj.getProperty("textarea"))).sendKeys(textarea);
		driver.findElement(By.xpath(obj.getProperty("date"))).clear();
		driver.findElement(By.xpath(obj.getProperty("date"))).sendKeys(String.valueOf(dateFromat));
		driver.findElement(By.xpath(obj.getProperty("datetime"))).clear();
		driver.findElement(By.xpath(obj.getProperty("datetime"))).sendKeys(String.valueOf(dateTimeFromat));
		driver.findElement(By.xpath(obj.getProperty("addcart"))).click();
		Screenshot_Class.screenshot(driver);
		
	}
}
