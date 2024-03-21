package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage  indexPage ;
	LoginPage   loginPage;
	HomePage    homePage;
	
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

@Test(groups = "Smoke")
public void wishListTest() {
	loginPage=indexPage.clickOnSignIn();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	boolean result     = homePage.validateMyWishList();
	 Assert.assertTrue(result);
}

@Test(groups = "Smoke")
public void orderHistoryandDetailsTest() {
	loginPage=indexPage.clickOnSignIn();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	boolean result     = homePage.validateOrderHistory();
	 Assert.assertTrue(result);
}
}
