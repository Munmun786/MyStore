package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.datadriver.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest  extends BaseClass{

	IndexPage  indexPage ;
	LoginPage loginPage;	
	HomePage homePage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Resgression"} )
	public void setup(String browser) {
		launchApp(browser);
		indexPage = new IndexPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Resgression"} )
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups={"Sanity, Smoke"} )
	
	public void loginTest (String uname, String pswd) {
		Log.startTestCase("loginTest");
		Log.info("user is going to clickOnSignin");
		loginPage =indexPage.clickOnSignIn();
		Log.info("Enter UserName aand Password");
		
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("passWord"));
		homePage=loginPage.login(uname,pswd);
		
		String actualURL=homePage.getUrl();
		String expectedURL = "http://www.automationpractice.pl/index.php";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login Is Sucess");
		Log.endTestCase("loginTest");
	}
	
}
