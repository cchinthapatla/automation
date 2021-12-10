package com.demo.test;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation1.pages.ConfirmationPage;
import com.automation1.pages.FlightsPage;
import com.automation1.pages.HomePage;
import com.automation1.pages.PurchasePage;
import com.demo.drivermanager.DriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationTest1 extends DriverManager {

	private ExtentReports report;
	private ExtentTest test;
	private Logger logger;
	private HomePage homePage;
	private FlightsPage flightsPage;
	private PurchasePage purchasePage;
	private ConfirmationPage confirmationPage;
	
	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public AutomationTest1() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(AutomationTest1.class);
		report = new ExtentReports(projectPath + File.separator + "Reports" + File.separator + "ExtentReportAutomationTest1.html");
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		webAppLaunch("http://blazedemo.com/", "chrome");
		homePage = new HomePage();
		flightsPage = new FlightsPage();
		purchasePage = new PurchasePage();
		confirmationPage = new ConfirmationPage();
	}
	
	@Test
	public void automationTest1(){
		try {
			test = report.startTest("AutomationTest1");
			homePage.selectDepartureCity(2);
			logger.info("Selected Departure City");
			test.log(LogStatus.INFO, "Selected Departure City");
			homePage.selectDestinationCity(3);
			logger.info("Selected Destination City");
			test.log(LogStatus.INFO, "Selected Destination City");
			homePage.clickFindFlightsButton();
			logger.info("Clicked on Find Flights Button");
			test.log(LogStatus.INFO, "Clicked on Find Flights Button");
			flightsPage.clickChooseThisFlight();
			logger.info("Clicked on Choose This Flight Button");
			test.log(LogStatus.INFO, "Clicked on Choose This Flight Button");
			purchasePage.setFirstNameField("Chandra");
			logger.info("Filled First Name Field");
			test.log(LogStatus.INFO, "Filled First Name Field");
			purchasePage.setAddressField("123City");
			logger.info("Filled Address Field");
			test.log(LogStatus.INFO, "Filled Address Field");
			purchasePage.clickPurchaseFlight();
			logger.info("Clicked on Purchase Flight Button");
			test.log(LogStatus.INFO, "Clicked on Purchase Flight Button");
			String confirmationMessage = confirmationPage.getConfirmationMessage();
			Assert.assertEquals(confirmationMessage, "Thank you for your purchase today!");
			logger.info("Confirmation Message : " + confirmationMessage);
			test.log(LogStatus.PASS, confirmationMessage);
			String confirmationId = confirmationPage.getConfirmationId();
			logger.info("Confirmation Id : " + confirmationId);
			test.log(LogStatus.PASS, "Confirmation Id : " + confirmationId);
			

		} catch (Exception e) {
			getDriver().quit();
			report.flush();
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
		report.flush();
	}
}
