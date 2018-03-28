package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCardPage extends BasePage {
	
	@FindBy(css = "td.recipient")
	private WebElement recipient;
	@FindBy(css = "td.amount")
	private WebElement amount;
	@FindBy(css = "td.delivery")
	private WebElement deliveryDate;
	@FindBy(css = "p.egift_message")
	private WebElement giftMessage;

	public ShoppingCardPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getRecipient() {
		return recipient;
	}

	public void setRecipient(WebElement recipient) {
		this.recipient = recipient;
	}

	public WebElement getAmount() {
		return amount;
	}

	public void setAmount(WebElement amount) {
		this.amount = amount;
	}

	public WebElement getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(WebElement deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public WebElement getGiftMessage() {
		return giftMessage;
	}

	public void setGiftMessage(WebElement giftMessage) {
		this.giftMessage = giftMessage;
	}

}
