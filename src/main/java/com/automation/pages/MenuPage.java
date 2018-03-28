package com.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

	@FindBy(className = "nav_menu")
	private WebElement nav;
	private final By byXpathLi = By.xpath("//li/a/strong");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getNav() {
		return nav;
	}

	public List<String> recoverTextTabs() {
		// System.out.println(nav.getText());
		List<String> texts = new ArrayList<String>();
		List<WebElement> lista = nav.findElements(byXpathLi);
		for (WebElement webElement : lista) {
			// System.out.println(webElement.getText());
			texts.add(webElement.getText());
		}
		return texts;
	}
}
