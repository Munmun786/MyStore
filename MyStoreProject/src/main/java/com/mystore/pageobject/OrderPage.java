package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
      @FindBy(xpath = "//span[text()='proceed to checkout']")
      WebElement proceedToChekOut;
      
     @FindBy(id="total_price")
     WebElement totalprice;
      
      public OrderPage() {
    	  
    	  PageFactory.initElements(getDriver(), this);
      }
      
      public double getUnitPrice() {
    	 String unitPrice1 =unitPrice.getText();
    	String unit  =unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
    Double finalUnitPrice	=Double.parseDouble(unit);
    	
    	return finalUnitPrice/100;
      }
      
      public Double getTotalPrice() {
    	  
     String totalPrice1	 = totalprice.getText();
                       
         String tot= totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
         Double finalTotalPrice = Double.parseDouble(tot);
                   return finalTotalPrice;
      }
      
      public LoginPage clickOnCheckOut() {
    	  Action.click(getDriver(), proceedToChekOut);
    	  return new LoginPage();
      }
      
}
