package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.drivermanager.DriverManager;

public class WebBase {
	public static WebDriver webDriver;
	public WebBase(){
		webDriver = DriverManager.getDriver();
		PageFactory.initElements(webDriver, this);
	}
}
