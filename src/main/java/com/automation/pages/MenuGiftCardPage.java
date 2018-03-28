package com.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuGiftCardPage extends MenuPage {

	WebElement menuGiftCard;
	@FindBy(css = "button.action")
	WebElement btnAddToCart;
	private final By byLinkTextGiveGift = By.linkText("Give a Gift by Email");
	private final By byLinkTextTankYou = By.linkText("Thank You");
	private final By byIdRecipientName = By.id("recipient_name");
	private final By byIdMessage = By.id("message");
	private final By byCssSelectorAmount = By.cssSelector("li > label[for=defined-amount_50]");
	private final By byIdSenderName = By.id("sender_name");
	private final By byIdSenderEmail = By.id("sender_email");
	private final By byIdRecipientEmail = By.id("recipient_email");
	private final By byIdDeliveryDate = By.id("delivery_date");
	private final By byIdNacGift = By.id("nav_gift_cards");

	public MenuGiftCardPage(WebDriver driver) {
		super(driver);
		menuGiftCard = getNav().findElement(byIdNacGift);
	}

	public ShoppingCardPage clickMenu(String recipientName, String message, String senderName, String senderEmail,
			String recipientEmail, String deliverydate) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menuGiftCard.click();
		WebElement linkGiveAGiftByEmail = getDriver().findElement(byLinkTextGiveGift);
		linkGiveAGiftByEmail.click();
		WebElement card = getDriver().findElement(byLinkTextTankYou);
		card.click();
		WebElement inputRecipentName = getDriver().findElement(byIdRecipientName);
		inputRecipentName.sendKeys(recipientName);
		WebElement inputMessage = getDriver().findElement(byIdMessage);
		inputMessage.sendKeys(message);
		WebElement inputAmount = getDriver().findElement(byCssSelectorAmount);
		inputAmount.click();
		WebElement inputSenderName = getDriver().findElement(byIdSenderName);
		inputSenderName.sendKeys(senderName);
		WebElement inputSernderEmail = getDriver().findElement(byIdSenderEmail);
		inputSernderEmail.sendKeys(senderEmail);
		WebElement inputRecipientEmail = getDriver().findElement(byIdRecipientEmail);
		inputRecipientEmail.sendKeys(recipientEmail);
		WebElement inputDeliveryDate = getDriver().findElement(byIdDeliveryDate);
		inputDeliveryDate.clear();
		inputDeliveryDate.sendKeys(deliverydate);
		btnAddToCart.click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new ShoppingCardPage(getDriver());
	}

}
