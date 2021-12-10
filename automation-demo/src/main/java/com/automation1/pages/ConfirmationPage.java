package com.automation1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;

public class ConfirmationPage extends WebBase {
	private WebWrapper webWrapper;
	public ConfirmationPage() {
		webWrapper = new WebWrapper();
	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Thank you for your purchase')]")
	private WebElement confirmationMessage;
	@FindBy(how = How.XPATH, using = "//table[@class='table']/tbody/tr/td")
	private List<WebElement> tableData;

	/**
	 * 
	 * Method for Get Confirmation Message
	 */
	public String getConfirmationMessage() {
		return webWrapper.getTextValue(confirmationMessage, 90);		
	}
	
	/**
	 * 
	 * Method for Get Confirmation Message
	 */
	public String getConfirmationId() {
		for(int i=0; i<tableData.size(); i++) {
			if(tableData.get(i).getText().contains("Id")) {
				return webDriver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + i+1 + "]/td[2]")).getText();
			}
		}
		return "";
	}
}
