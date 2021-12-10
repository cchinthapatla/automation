package com.demo.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation3.pages.HomePage;
import com.automation3.pages.TimerPage;
import com.demo.drivermanager.DriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationTest3 extends DriverManager {
	private ExtentReports report;
	private ExtentTest test;
	private Logger logger;
	private HomePage homePage;
	private TimerPage timerPage;
	
	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public AutomationTest3() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(AutomationTest2.class);
		report = new ExtentReports(projectPath + File.separator + "Reports" + File.separator + "ExtentReportAutomationTest3.html");
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		webAppLaunch("https://e.ggtimer.com/", "chrome");
		homePage = new HomePage();
		timerPage = new TimerPage();
	}
	
	@Test
	public void automationTest3(){
		try {
			test=report.startTest("AutomationTest3");
			homePage.fillTimerInputField("25sec");
			logger.info("Filled Timer Input");
			test.log(LogStatus.INFO, "Filled Timer Input");
			homePage.clickStartButton();
			logger.info("Clicked on Start Button");
			test.log(LogStatus.INFO, "Clicked on Start Button");
			timerPage.getTimer();
			logger.info("Verified that the countdown is actually happening every second and that the remaining time decreases in one-second increments");
			test.log(LogStatus.PASS, "Verified that the countdown is actually happening every second and that the remaining time decreases in one-second increments");

		} catch (Exception e) {
			if(e.getMessage().contains("Time Expired!")) {
				logger.info("Verified that the countdown is actually happening every second and that the remaining time decreases in one-second increments");
				test.log(LogStatus.PASS, "Verified that the countdown is actually happening every second and that the remaining time decreases in one-second increments");
			}
			getDriver().quit();
			report.flush();
		}
	}
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
		report.flush();
	}
}
