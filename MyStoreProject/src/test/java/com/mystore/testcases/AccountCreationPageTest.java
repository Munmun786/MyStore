 package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.mystore.base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class AccountCreationPageTest extends BaseClass {

	

		IndexPage  indexPage ;
		LoginPage   loginPage;
	AccountCreationPage	accountCreationPage;
	
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

	@Test(groups = "Sanity")
	
	public void wishListTest() {
		loginPage=indexPage.clickOnSignIn();
		 
		accountCreationPage=loginPage.createNewAccount("munmun@gmail.com");
	     boolean result= accountCreationPage.validateAccountPage();
	  Assert.assertTrue(result);
	
	}
	}
