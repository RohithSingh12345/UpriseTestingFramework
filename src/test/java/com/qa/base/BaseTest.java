package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utilities.Utils;

public class BaseTest {
	WebDriver driver;
	public Properties prop;
	public Properties testDataprop;
	
	public BaseTest() {
		prop = new Properties();
		File propFile = new File("C:\\Users\\Rohith\\eclipse-workspace\\UpriseFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		} catch(Throwable t) {
			t.printStackTrace();
		};
		testDataprop = new Properties();
		File testFile = new File("C:\\Users\\Rohith\\eclipse-workspace\\UpriseFramework\\src\\main\\java\\com\\qa\\testdata\\testData.properties");
		try {
		FileInputStream fis2 = new FileInputStream(testFile);
		testDataprop.load(fis2);
		} catch(Throwable t) {
			t.printStackTrace();
		}
	
	}
	
	public WebDriver initializeBrowser(String browserName) {
		//String browserName= "chrome";//firefox and edge
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
        }
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.Implicit_Wait));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PageLoad_Timeout));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
