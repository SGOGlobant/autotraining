package com.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuCoffeePage extends MenuPage {

	private WebElement menuCoffe;
	@FindBy(id = "find-my-coffee")
	private WebElement btnFindCoffee;
	private final By byIdRecommend = By.id("all-results-headings");
	private final By byNav = By.id("nav_coffee");
	private final By byLinkButtonFindCoffee = By.linkText("Find Your Perfect Coffee");

	public MenuCoffeePage(WebDriver driver) {
		super(driver);
		menuCoffe = getNav().findElement(byNav);
	}

	public boolean clickMenu(int answer1, int answer2, int answer3, int answer4) {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		menuCoffe.click();
		WebElement linkFindCoffee = getDriver().findElement(byLinkButtonFindCoffee);
		linkFindCoffee.click();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		QuestionPage question1 = new QuestionPage(getDriver(), 1);
		question1.clickOption(answer1-1);
		QuestionPage question2 = new QuestionPage(getDriver(), 2);
		question2.clickOption(answer2-1);
		QuestionPage question3 = new QuestionPage(getDriver(), 3);
		question3.clickOption(answer3-1);
		QuestionPage question4 = new QuestionPage(getDriver(), 4);
		question4.clickOption(answer4-1);
		btnFindCoffee.sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement divRecommend = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(byIdRecommend));
		return divRecommend.isDisplayed();
	}
}
