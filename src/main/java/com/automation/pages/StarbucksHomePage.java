package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class StarbucksHomePage extends BasePage {

	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}

	public List<String> getTabsMenu() {
		MenuPage tab = new MenuPage(getDriver());
		return tab.recoverTextTabs();
	}

	public boolean clickMenuCoffe(int answer1, int answer2, int answer3, int answer4) {
		MenuCoffeePage menuCoffe = new MenuCoffeePage(getDriver());
		return menuCoffe.clickMenu(answer1, answer2, answer3, answer4);
	}

	public ShoppingCardPage clickMenuGiftCard(String recipientName, String message, String senderName,
			String senderEmail, String recipientEmail, String deliverydate) {
		MenuGiftCardPage menuGiftPage = new MenuGiftCardPage(getDriver());
		return menuGiftPage.clickMenu(recipientName, message, senderName, senderEmail, recipientEmail, deliverydate);
	}

}
