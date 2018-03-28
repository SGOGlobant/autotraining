package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionPage extends BasePage {

	private WebElement options;
	private final String idQuestion = "question";
	private final By byTagButton = By.tagName("button");

	public QuestionPage(WebDriver driver, int question) {
		super(driver);		
		options = getDriver().findElement(By.id(String.format("%s%d", idQuestion, question)));
	}

	public void clickOption(int option) {
		List<WebElement> responses = new ArrayList<WebElement>();
		List<WebElement> button = options.findElements(byTagButton);
		for (WebElement webElement : button) {
			if (webElement.isDisplayed()) {
				responses.add(webElement);
			}
		}
		responses.get(option).click();	
	}

}
