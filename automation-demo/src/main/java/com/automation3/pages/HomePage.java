package com.automation3.pages;

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
	@FindBy(how = How.ID, using = "EggTimer-start-time-input-text")	
	private WebElement timerInputField;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Start')]")	
	private WebElement startButton;
	
	/**
	 * 
	 * Method for Start Button 
	 */
	public void clickStartButton() {
		webWrapper.clickOnElement(startButton, 120);
	}
	
	/**
	 * 
	 * Method for Fill Timer Input Field
	 *
	 */
	public void fillTimerInputField(String inputValue) throws Exception {
		webWrapper.setInputBox(timerInputField, 120, inputValue);
	} 
	
}
