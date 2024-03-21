package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage  extends BaseClass{

	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to  cart']")
	WebElement addToCartBtn;
	@FindBy (xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessag;
	
	@FindBy(xpath = "//span[contains(text(),'proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1,size);
	}
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean valitadeAddtoCart() {
		Action.fluentWait(getDriver(), addToCartBtn,10);
		
		return Action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() {
		Action.JSClick(getDriver(),proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	
	
	
	
	
}
