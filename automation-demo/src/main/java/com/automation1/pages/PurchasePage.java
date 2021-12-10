package com.automation1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;

public class PurchasePage extends WebBase {
	private WebWrapper webWrapper;
	public PurchasePage() {
		webWrapper = new WebWrapper();
	}

	@FindBy(how = How.ID, using = "inputName")
	private WebElement firstNameField;
	@FindBy(how = How.ID, using = "inputName")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement purchaseFlightButton;

	/**
	 * 
	 * Method for Set First Name
	 */
	public void setFirstNameField(String inputValue) {
		webWrapper.setInputBox(firstNameField, 90, inputValue);		
	}
	
	/**
	 * 
	 * Method for Set Address
	 */
	public void setAddressField(String inputValue) {
		webWrapper.setInputBox(addressField, 90, inputValue);		
	}
	
	
	/**
	 * 
	 * Method for Choose this flight
	 */
	public void clickPurchaseFlight() {
		webWrapper.clickOnElement(purchaseFlightButton, 90);		
	}
}
