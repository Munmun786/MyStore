package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//a[contain(text(), 'pay by bank wire']")
	WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contain(text(),'pay by check')]")
	WebElement payByCheckMethod;
	
	public PaymentPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	public OrderSummary clickOnPaymentMethod() {
		Action.click(getDriver(),bankWireMethod );
		return new OrderSummary();
	}
	
	
	
	
	
	
}
