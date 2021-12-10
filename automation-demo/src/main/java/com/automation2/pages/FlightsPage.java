package com.automation2.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;

public class FlightsPage extends WebBase {
	private WebWrapper webWrapper;
	
	public FlightsPage() {
		webWrapper = new WebWrapper();
	}
	
	
	@FindBy(how = How.NAME, using = "fromPort")	
	private WebElement fromFlight;
	@FindBy(how = How.NAME, using = "fromMonth")	
	private WebElement fromMonth;
	@FindBy(how = How.NAME, using = "toPort")	
	private WebElement toFlight;
	@FindBy(how = How.NAME, using = "toMonth")	
	private WebElement toMonth;
	@FindBy(how = How.NAME, using = "findFlights")	
	private WebElement continueButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/p/font/b/font[1]")	
	private WebElement confirmationMessage;
	
	/**
	 * 
	 * Method for Select Departure City 
	 */
	public void selectDepartureCity(int indexValue) {
		webWrapper.selectDropDownByIndex(fromFlight, indexValue);
	}
	
	/**
	 * 
	 * Method for Select Destination City
	 */
	public void selectDestinationCity(int indexValue) {
		webWrapper.selectDropDownByIndex(toFlight, indexValue);
	}
	
	/**
	 * 
	 * Method for Select Departure Month 
	 */
	public void selectDepartureMonth(int indexValue) {
		webWrapper.selectDropDownByIndex(fromMonth, indexValue);
	}
	
	/**
	 * 
	 * Method for Select Returning Month
	 */
	public void selectReturningMonth(int indexValue) {
		webWrapper.selectDropDownByIndex(toMonth, indexValue);
	}
	
	/**
	 * 
	 * Method for Click Continue Button
	 */
	public void clickContinueButton() {
		webWrapper.clickOnElement(continueButton, 90);
	}
	
	/**
	 * 
	 * Method for Get Confirmation Message
	 */
	public String getConfirmationMessage() {
		return webWrapper.getTextValue(confirmationMessage, 90);		
	}
}