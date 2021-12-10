package com.automation1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;


public class HomePage extends WebBase {
	private WebWrapper webWrapper;
	public HomePage() {
		webWrapper = new WebWrapper();
		PageFactory.initElements(webDriver, this);
	}
	@FindBy(how = How.NAME, using = "fromPort")	
	private WebElement fromDropDown;
	@FindBy(how = How.NAME, using = "toPort")
	private WebElement toDropDown;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement findFlightsButton;
	
	/**
	 * 
	 * Method for Select Departure City 
	 */
	public void selectDepartureCity(int indexValue) {
		webWrapper.selectDropDownByIndex(fromDropDown, indexValue);
	}
	
	/**
	 * 
	 * Method for Select Destination City
	 */
	public void selectDestinationCity(int indexValue) {
		webWrapper.selectDropDownByIndex(toDropDown, indexValue);
	}
	
	/**
	 * 
	 * Method for Find Flights Button
	 * @throws Exception 
	 */
	public void clickFindFlightsButton() throws Exception {
		webWrapper.clickOnElement(findFlightsButton, 120);
	} 
	
}
