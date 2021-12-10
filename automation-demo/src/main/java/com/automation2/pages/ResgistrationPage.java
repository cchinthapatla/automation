package com.automation2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;

public class ResgistrationPage extends WebBase {
	private WebWrapper webWrapper;
	public ResgistrationPage() {
		webWrapper = new WebWrapper();
	}

	@FindBy(how = How.NAME, using = "firstName")
	private WebElement firstNameField;
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement lastNameField;
	@FindBy(how = How.NAME, using = "phone")
	private WebElement phoneField;
	@FindBy(how = How.ID, using = "userName")
	private WebElement emailField;
	@FindBy(how = How.NAME, using = "address1")
	private WebElement addressField;
	@FindBy(how = How.ID, using = "email")
	private WebElement userNameField;
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;
	@FindBy(how = How.NAME, using = "confirmPassword")
	private WebElement confirmPasswordField;
	@FindBy(how = How.NAME, using = "submit")
	private WebElement submitButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td")
	private WebElement confirmationMessage;
	
	

	/**
	 * 
	 * Method for Set First Name
	 */
	public void setFirstNameField(String inputValue) {
		webWrapper.setInputBox(firstNameField, 90, inputValue);		
	}
	
	/**
	 * 
	 * Method for Set Last Name
	 */
	public void setLastNameField(String inputValue) {
		webWrapper.setInputBox(lastNameField, 90, inputValue);		
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
	 * Method for Email Field
	 */
	public void setEmailField(String inputValue) {
		webWrapper.setInputBox(emailField, 90, inputValue);		
	}
	
	/**
	 * 
	 * Method for Set UserName Field
	 */
	public void setUserNameField(String inputValue) {
		webWrapper.setInputBox(userNameField, 90, inputValue);		
	}
	
	/**
	 * 
	 * Method for Set Password Field
	 */
	public void setPasswordField(String inputValue) {
		webWrapper.setInputBox(passwordField, 90, inputValue);		
	}
	
	/**
	 * 
	 * Method for Set Phone Number Field
	 */
	public void setPhoneNumberField(String inputValue) {
		webWrapper.setInputBox(phoneField, 90, inputValue);		
	}
	/**
	 * 
	 * Method for Set Confirmation Field
	 */
	public void setConfirmationPasswordField(String inputValue) {
		webWrapper.setInputBox(confirmPasswordField, 90, inputValue);		
	}
	
	
	/**
	 * 
	 * Method for Click Submit button
	 */
	public void clickSubmitButton() {
		webWrapper.clickOnElement(submitButton, 90);		
	}
	
	/**
	 * Method for Get Confirmation Message
	 * 
	 */
	public String getConfirmationMessage() {
		return webWrapper.getTextValue(confirmationMessage, 90);		
	}
}
