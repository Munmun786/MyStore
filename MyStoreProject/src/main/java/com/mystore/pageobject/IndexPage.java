package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class = 'login']")
	WebElement singInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	//constructor
	public IndexPage() {
	
	PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		
		Action.click(getDriver(), singInBtn);
		return  new LoginPage();
		
	}
	
	public boolean validateLogo() {
		
		return Action.isDisplayed(getDriver(), myStoreLogo );
		
	}
	
	public String getMyStoreTitle() {
		String myStoreTitleString = getDriver().getTitle();
		return myStoreTitleString ;
		
	}
	
	public SearchResultPage searchProduct(String productName) {
		
		Action.type(searchProductBox,productName );
		Action.click(getDriver(),searchButton );
		return new SearchResultPage();
		
	}
	
	
}
