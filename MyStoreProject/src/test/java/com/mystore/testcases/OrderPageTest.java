package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

public class OrderPageTest extends BaseClass {

	
	IndexPage  indexPage ;
	SearchResultPage searchResultPage;
	 AddToCartPage  addToCartPage;
	 OrderPage orderPage;
	 
	 
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

	@Test(groups = "Regression")
	public void verifyTotalPrice() {
		
		searchResultPage=indexPage.searchProduct("t-shirt");
		 addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("m");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
	       Double   unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totlaExpectedPrice= (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totlaExpectedPrice);
		
	}
	
	
}
