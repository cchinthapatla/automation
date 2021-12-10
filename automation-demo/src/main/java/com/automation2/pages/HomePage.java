package com.automation2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;


public class HomePage extends WebBase {
	private WebWrapper webWrapper;
	public HomePage() {
		webWrapper = new WebWrapper();
	}
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")	
	private WebElement registerLink;
	@FindBy(how = How.LINK_TEXT, using = "Flights")	
	private WebElement flightsLink;
	
	/**
	 * 
	 * Method for Registration link 
	 */
	public void clickRegisterLink() {
		webWrapper.clickOnElement(registerLink, 120);
	}
	
	/**
	 * 
	 * Method for Flight link
	 *
	 */
	public void clickFlightsLink() throws Exception {
		webWrapper.clickOnElement(flightsLink, 120);
	} 
	
}
