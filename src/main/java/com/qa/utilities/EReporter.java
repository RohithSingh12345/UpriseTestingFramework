package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class EReporter {

	
	public static ExtentReports generateEReports() {
		ExtentReports er = new ExtentReports();
		File file = new File("C:\\Users\\Rohith\\eclipse-workspace\\UpriseFramework\\test-output\\Ereports\\er.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.config().setTheme(Theme.DARK);//theme will be darker in the reports
	    sparkReporter.config().setReportName("Uprise Automation report");
	    sparkReporter.config().setDocumentTitle("Uprise Reports");
	    sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	    
	    
	    er.attachReporter(sparkReporter);
	    Properties prop = new Properties();
		File propFile = new File("C:\\Users\\Rohith\\eclipse-workspace\\UpriseFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
		try {
		FileInputStream fisConfigProp = new FileInputStream(propFile);
		prop.load(fisConfigProp);
		} catch(Throwable t) {
			t.printStackTrace();
		};
	    er.setSystemInfo("App URL", prop.getProperty("url"));
	    er.setSystemInfo("BrowserName", prop.getProperty("browser"));
	    //can write email and pwd used
	    er.setSystemInfo("operating system", System.getProperty("os.name"));
	    er.setSystemInfo("username", System.getProperty("user.name"));
	    er.setSystemInfo("java version", System.getProperty("java.version"));
	    
	    return er;
	    
	}
		
	}

