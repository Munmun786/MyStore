package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formtitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean validateAccountPage() {
		return Action.isDisplayed(getDriver(), formtitle);
		
	}
}
