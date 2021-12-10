package com.automation3.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.demo.base.WebBase;
import com.demo.utilities.WebWrapper;

public class TimerPage extends WebBase {
	private WebWrapper webWrapper;
	public String timerIncreament = null;
	public String timerDecreament = null;
	
	public TimerPage() {
		webWrapper = new WebWrapper();
	}
	
	
	@FindBy(how = How.XPATH, using = "//p[@class='ClassicTimer-time']")	
	private WebElement timerText;
	
	/**
	 * 
	 * Method for Timer
	 */
	public void getTimer() {
		while(true) {
			timerIncreament = webWrapper.getTextValue(timerText, 90);
			if (timerIncreament.contains("Time Expired!")) {
				break;
			}
			if (!timerIncreament.equals(timerDecreament)) {
				timerDecreament = timerIncreament;
			}
		}
	}
}