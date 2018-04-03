package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class StarbucksHomePage extends BasePage {

	/**
	 * 
	 * @param driver
	 */
	public StarbucksHomePage(WebDriver driver) {
		super(driver);
		driver.get("https://www.starbucks.com/");
	}

	/**
	 * Reccupera los valores del menu
	 * 
	 * @return
	 */
	public List<String> getTabsMenu() {
		MenuPage tab = new MenuPage(getDriver());
		return tab.recoverTextTabs();
	}

	/**
	 * Metodo que devulve un true en caso de encontrar una recomendacion de cafe
	 * 
	 * @param answer1
	 * @param answer2
	 * @param answer3
	 * @param answer4
	 * @return
	 */
	public boolean clickMenuCoffe(int answer1, int answer2, int answer3, int answer4) {
		MenuCoffeePage menuCoffe = new MenuCoffeePage(getDriver());
		return menuCoffe.clickMenu(answer1, answer2, answer3, answer4);
	}

	/**
	 * Devuelve la tarjeta de cafe que se añadio recientemente
	 * 
	 * @param recipientName
	 * @param message
	 * @param senderName
	 * @param senderEmail
	 * @param recipientEmail
	 * @param deliverydate
	 * @return
	 */
	public ShoppingCardPage clickMenuGiftCard(String recipientName, String message, String senderName,
			String senderEmail, String recipientEmail, String deliverydate) {
		MenuGiftCardPage menuGiftPage = new MenuGiftCardPage(getDriver());
		return menuGiftPage.clickMenu(recipientName, message, senderName, senderEmail, recipientEmail, deliverydate);
	}

}
