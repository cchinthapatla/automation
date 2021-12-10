package com.automation1.pages;
import java.util.List;

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
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")	
	private List<WebElement> chooseFlight;
	
	/**
	 * 
	 * Method for Choose this flight
	 */
	public void clickChooseThisFlight() {
		webWrapper.clickFirstElement(chooseFlight);		
	}
}