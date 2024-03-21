package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AddressPage;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummary;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;

public class EndToEndTest extends BaseClass {


	IndexPage  indexPage ;
	SearchResultPage searchResultPage;
	 AddToCartPage  addToCartPage;
	 OrderPage orderPage;
	 LoginPage loginPage;
	 AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
      OrderConfirmationPage orderConfirmationPage;
	
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
	
	public void endToEndTest() {
	
		searchResultPage=indexPage.searchProduct("t-shirt");
		 addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("m");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage   =orderPage.clickOnCheckOut();
		  addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("passWord"));
		  shippingPage =addressPage.clickOnCheckOut();
		  shippingPage.checkTheTerms();
		  paymentPage=shippingPage.clickOnProceedToCheckOut();
		  orderSummary= paymentPage.clickOnPaymentMethod();
		   orderConfirmationPage= orderSummary.clickOnconfirmOrderBtn();
		  String actualMessage =orderConfirmationPage.validateConfirmMessage();
		  String expectedMsg= "Your order on My Store is complete";
		  Assert.assertEquals(actualMessage, expectedMsg);
	}
	
}
