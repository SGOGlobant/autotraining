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

	/**
	 * Se ingresa un numero de opcion a la cual se le da clic dependiendo de la
	 * pregunta
	 * 
	 * @param option
	 */
	public void clickOption(int option) {
		List<WebElement> responses = new ArrayList<WebElement>();
		List<WebElement> button = options.findElements(byTagButton);
		// Recorre todas las opciones posibles y las agrega a una lista si estas estan
		// desplegadas en pantalla
		for (WebElement webElement : button) {
			if (webElement.isDisplayed()) {
				// si se muestra en pantalla se agrega
				responses.add(webElement);
			}
		}
		// Dar clic en la opcion que este en pantalla
		responses.get(option).click();
	}

}
