package com.automation.training;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.pages.StarbucksHomePage;

public class BaseTests {

	MyDriver myDriver;
	private StarbucksHomePage starbucksHome;

	public StarbucksHomePage getStarbucksHome() {
		return starbucksHome;
	}

	public void setStarbucksHome(StarbucksHomePage starbucksHome) {
		this.starbucksHome = starbucksHome;
	}

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser" })
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		starbucksHome = new StarbucksHomePage(myDriver.getDriver());
	}
	
	@AfterMethod(alwaysRun = true)
	public void beforeMethod() {
		myDriver.getDriver().navigate().to("https://www.starbucks.com/");		
	}
	
	@AfterSuite
	public void closeAll() {
		//starbucksHome.dispose();
	}
}
