package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage  indexPage ;
	
	
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
public void verifyLogo() {
	  
	       boolean result   =indexPage.validateLogo();
	       Assert.assertTrue(result);
}

@Test(groups = "Smoke")
public void verifyTitle() {
	
	String actTitle =indexPage.getMyStoreTitle();
	Assert.assertEquals(actTitle, "My Shop");
	
}


}
