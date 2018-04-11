package com.automation.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {
	private WebDriver driver;

	public MyDriver(String browser) {
		
		if ("firefox".equals(browser)) {
//			FirefoxOptions firefoxOptions = new FirefoxOptions(DesiredCapabilities.firefox());
//	        firefoxOptions.addPreference("browser.popups.showPopupBlocker", false);
//	        firefoxOptions.addPreference("security.sandbox.content.level", 5);
//	        firefoxOptions.setAcceptInsecureCerts(true);
//	        firefoxOptions.setProfile(new FirefoxProfile());
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "../autotraining/resources/chromedriver.exe");
			ChromeOptions chrome = new ChromeOptions();
			driver = new ChromeDriver();
		}
		
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
