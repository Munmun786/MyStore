package com.mystore.base;

import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.beust.jcommander.Parameter;
import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.mystore.actiondriver.Action;



public class BaseClass {
	
	
	//gives some comment
public static Properties prop;	

//public static WebDriver driver;	

public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
@BeforeSuite(groups = {"Smoke","Sanity","Resgression"} )
public void beforeSuite() {
	DOMConfigurator.configure("log4j.xml");
	
}




public static WebDriver getDriver() {
	return driver.get();
}

//huybuhno

@BeforeTest(groups = {"Smoke","Sanity","Resgression"} )
public void loadConfig() {
	
	try {
		prop=new Properties();
		
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/configuration/config.properties");
		
		prop.load(fs);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



public static void launchApp(String browserName) {
	
	WebDriverManager.chromedriver().setup();
	
//String browserName	=prop.getProperty("browser");
if (browserName.contains("Chrome")) {
	//driver = new ChromeDriver();
	driver.set(new ChromeDriver());
	
} else if(browserName.contains("FireFox")) {
	//driver = new FirefoxDriver();
	driver.set(new FirefoxDriver());
	
} else if(browserName.contains("IE")) {
	 driver.set(new FirefoxDriver());
}

 Action.implicitWait(getDriver(), 10);
 Action.pageLoadTimeOut(getDriver(), 30);
 getDriver().get(prop.getProperty("url"));
 
}


}


	

