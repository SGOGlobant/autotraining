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
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
