package root;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static WebDriver driver;
	public static Properties obj;
	public base() {
        
		obj = new Properties();
        FileInputStream objfile;
        try {
			objfile = new FileInputStream(
					"C:\\Users\\hp\\eclipse-workspace\\DemoOpenCart\\src\\main\\java\\utilities\\config.properties");
			obj.load(objfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}    
	public WebDriver initializeDriver() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}
	
	public void waitFor() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
