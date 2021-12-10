package com.demo.drivermanager;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static String projectPath = System.getProperty("user.dir");
	public static String mobileReportsPath = projectPath + File.separator + "MobileReports" + File.separator;
	public static WebDriver webDriver;

	/**
	 * 
	 * @param url
	 * @param browserType
	 * @throws Exception
	 */
	public static void webAppLaunch(String url, String browserType) throws Exception {
		if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();			
		}else if(browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			webDriver = new SafariDriver();
		}else if(browserType.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			webDriver = new InternetExplorerDriver();
		}else {
			Assert.fail();
		}
		webDriver.manage().window().maximize();
		webDriver.get(url);
	}
	
	public static WebDriver getDriver() {
		return webDriver;
	}
}
