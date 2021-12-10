package com.demo.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.WebBase;

import junit.framework.Assert;

public class WebWrapper extends WebBase{

	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public WebElement waitForExpectedElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param inputValue
	 */
	public void setInputBox(WebElement element, long timeOutInSeconds, String inputValue) {
		waitForExpectedElement(element, timeOutInSeconds);
		element.clear();
		element.sendKeys(inputValue);
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param inputValue
	 */
	public void setInputClickBox(WebElement element, long timeOutInSeconds, String inputValue) {
		waitForExpectedElement(element, timeOutInSeconds);
		element.click();
		element.sendKeys(inputValue);
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void clickOnElement(WebElement element, long timeOutInSeconds) {
		waitForExpectedElement(element, timeOutInSeconds);
		element.click();
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean clickOnIfElementDisplayed(WebElement element, long timeOutInSeconds) {
		try {
			WebElement ele = waitForExpectedElement(element, timeOutInSeconds);
			if (ele.isDisplayed()) {
				ele.click();
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean elementDisplayed(WebElement element, long timeOutInSeconds) {
		try {
			WebElement elemDisplayed = waitForExpectedElement(element, timeOutInSeconds);
			if (elemDisplayed.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	//Don't use if not required 
	public void waitForElement() {
		try {
		Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public String getTextValue(WebElement element, long timeOutInSeconds) {
		WebElement ele = waitForExpectedElement(element, timeOutInSeconds);
		String textValue = ele.getText();
		return textValue;
	}
	/**
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void selectDropDownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		select.selectByIndex(1);
	}
	
	/**
	 * 
	 * @param element
	 * @param indexValue
	 */
	public void selectDropDownByIndex(WebElement element, int indexValue) {
		Select select = new Select(element);
		select.selectByIndex(indexValue);
	}
	
	/**
	 * 
	 * @param elements
	 */
	
	public void clickFirstElement(List<WebElement> elements){
		for(int i=0; i<elements.size(); i++) {
			if(elements.size()>0) {
				elements.get(i).click();
				break;
			}else {
				Assert.fail();
			}
		}
	}
}
