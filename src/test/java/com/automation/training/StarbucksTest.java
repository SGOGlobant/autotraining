package com.automation.training;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.ShoppingCardPage;
import com.automation.pages.StarbucksHomePage;

public class StarbucksTest extends BaseTests {
	private final String[] texts = { "COFFEE", "TEA", "MENU", "COFFEEHOUSE", "SOCIAL IMPACT", "STARBUCKS REWARDS",
			"BLOG", "GIFT CARDS" };

	/**
	 * Prueba de titulos de menus
	 */
	@Test(groups = { "navigatorTest" })
	public void testTextNavsHome() {
		StarbucksHomePage home = getStarbucksHome();
		List<String> textNavsHome = home.getTabsMenu();
		assertEquals(texts, textNavsHome.toArray());
	}

	/**
	 * Prueba para encontrar recomendacion de cafe
	 * 
	 * @param answer1
	 * @param answer2
	 * @param answer3
	 * @param answer4
	 */
	@Test(groups = { "recomendationTest" }, dataProvider = "getAnswers")
	public void testMenuCoffe(int answer1, int answer2, int answer3, int answer4) {
		StarbucksHomePage home = getStarbucksHome();
		boolean showRecommendation;
		showRecommendation = home.clickMenuCoffe(answer1, answer2, answer3, answer4);
		assertTrue(showRecommendation, "A recommendation was shown");
	}

	/**
	 * Prueba de Tarjetas de Regalo
	 * 
	 * @param recipientName
	 * @param message
	 * @param senderName
	 * @param senderEmail
	 * @param recipientEmail
	 * @param deliverydate
	 */
	@Test(groups = { "giftCardTest" }, dataProvider = "getDataCard")
	public void testGiftCard(String recipientName, String message, String senderName, String senderEmail,
			String recipientEmail, String deliverydate) {
		StarbucksHomePage home = getStarbucksHome();
		ShoppingCardPage card = home.clickMenuGiftCard(recipientName, message, senderName, senderEmail, recipientEmail,
				deliverydate);
		assertEquals(recipientEmail, card.getRecipient().getText());
		assertEquals(String.format("%s\n%s", recipientName, message.replace("\n", " ")),
				card.getGiftMessage().getText());

		System.out.println(String.format("%s\n%s", recipientName, message.replace("\n", " ")) + "\n"
				+ card.getGiftMessage().getText());
		assertEquals(deliverydate, card.getDeliveryDate().getText());
	}

	/**
	 * Respuestas para obtener cafe
	 * 
	 * @return
	 */
	@DataProvider(name = "getAnswers")
	public Object[][] getAnswers() {
		return new Object[][] { { 1, 1, 1, 1 }, { 1, 2, 3, 1 } };
	}

	/**
	 * Informacion de las tarjetas de regalo
	 * 
	 * @return
	 */
	@DataProvider(name = "getDataCard")
	public Object[][] getDataCard() {
		return new Object[][] {
				{ "Sergio", "This is a message for the GIFT CARD.\nRegards.", "Sergio Garcia", "sergio@correo.com",
						"friend@mail.com", "5/5/2018" },
				{ "Sergio", "This is a message for the GIFT CARD.\nRegards.", "Garcia Sergio", "sergio@correo.com",
						"friend@mail.com", "5/5/2018" } };
	}
}
