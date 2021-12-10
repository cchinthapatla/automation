package com.demo.test;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation2.pages.FlightsPage;
import com.automation2.pages.HomePage;
import com.automation2.pages.ResgistrationPage;
import com.demo.drivermanager.DriverManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationTest2 extends DriverManager {

	private ExtentReports report;
	private ExtentTest test;
	private Logger logger;
	private HomePage homePage;
	private FlightsPage flightsPage;
	private ResgistrationPage resgistrationPage;
	
	/**
	 * Constructor
	 * 
	 * @throws Exception
	 */
	public AutomationTest2() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(AutomationTest2.class);
		report = new ExtentReports(projectPath + File.separator + "Reports" + File.separator + "ExtentReportAutomationTest2.html");
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		webAppLaunch("http://demo.guru99.com/test/newtours/index.php", "chrome");
		homePage = new HomePage();
		flightsPage = new FlightsPage();
		resgistrationPage = new ResgistrationPage();
	}

	@Test
	public void automationTest2(){
		try {
			Date date = new Date();
			long timeMilli = date.getTime();
			test = report.startTest("AutomationTest2 : Registration");
			homePage.clickRegisterLink();
			logger.info("Clicked on Registration Link");
			test.log(LogStatus.INFO, "Clicked on Registration Link");
			resgistrationPage.setFirstNameField("Test" + timeMilli);
			logger.info("Filled First Name Field");
			test.log(LogStatus.INFO, "Filled First Name Field");
			resgistrationPage.setLastNameField("Te" + timeMilli);
			logger.info("Filled Last Name Field");
			test.log(LogStatus.INFO, "Filled Last Name Field");
			resgistrationPage.setPhoneNumberField("1234567890");
			logger.info("Clicked on Choose This Flight Button");
			test.log(LogStatus.INFO, "Clicked on Choose This Flight Button");
			resgistrationPage.setEmailField("test" + timeMilli +"@yopmail.com");
			resgistrationPage.setAddressField("123City");
			String email = "test" + timeMilli +"@yopmail.com";
			resgistrationPage.setEmailField(email);
			resgistrationPage.setUserNameField(email);
			resgistrationPage.setPasswordField("testtest");
			resgistrationPage.setConfirmationPasswordField("testtest");
			resgistrationPage.clickSubmitButton();
			String registrationConfirmationMessage = resgistrationPage.getConfirmationMessage();
			logger.info("Registration Confirmation Message : " + registrationConfirmationMessage);
			test.log(LogStatus.PASS, "Registration Confirmation Message : " + registrationConfirmationMessage);
			test=report.startTest("AutomationTest2 : Flights Booking");
			homePage.clickFlightsLink();
			logger.info("Clicked on Flights Link");
			test.log(LogStatus.INFO, "Clicked on Flights Link");
			flightsPage.selectDepartureCity(1);
			logger.info("Selected Departure City");
			test.log(LogStatus.INFO, "Filled Last Name Field");
			flightsPage.selectDepartureMonth(11);
			logger.info("Selected Departure Month");
			test.log(LogStatus.INFO, "Selected Departure Month");
			flightsPage.selectDestinationCity(2);
			logger.info("Selected Destination City");
			test.log(LogStatus.INFO, "Selected Destination City");
			flightsPage.selectDestinationCity(3);
			flightsPage.selectReturningMonth(11);
			flightsPage.clickContinueButton();
			logger.info("Clicked on Continue Button");
			test.log(LogStatus.INFO, "Clicked on Continue Button");
			String flightsConfirmationMessage = flightsPage.getConfirmationMessage();
			logger.info("Flights Confirmation Message : " + flightsConfirmationMessage);
			test.log(LogStatus.PASS, "Flights Confirmation Message : " + flightsConfirmationMessage);
	
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
