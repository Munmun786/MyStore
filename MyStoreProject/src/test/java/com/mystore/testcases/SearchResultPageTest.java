/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass {

	
	IndexPage  indexPage ;
	SearchResultPage searchResultPage;
	
	
	
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
	
	public void productAvailabilityTest() {
		searchResultPage=indexPage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
	   Assert.assertTrue(result);
	
	
	}
	
	
}
