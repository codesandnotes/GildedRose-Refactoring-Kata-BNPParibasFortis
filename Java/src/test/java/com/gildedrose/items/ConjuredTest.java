package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.StandardItemAssertions.assertStandardItemHasProperties;

class ConjuredTest {

	@Test
	void instantiatesAConjuredObject() {
		Conjured conjured = Conjured.create(new Item("Conjured Mana Cake", 10, 20));
		assertStandardItemHasProperties(conjured, Conjured.class, SellIn.days(10), Quality.of(20));
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			Conjured conjured = Conjured.create(new Item("Conjured Mana Cake", 10, 20));
			conjured.updateQuality();
			assertStandardItemHasProperties(conjured, Conjured.class, SellIn.days(9), Quality.of(18));
		}

		@Test
		void preventsQualityToBecomeNegative() {
			Conjured conjured = Conjured.create(new Item("Conjured Mana Cake", 2, 1));
			conjured.updateQuality();
			assertStandardItemHasProperties(conjured, Conjured.class, SellIn.days(1), Quality.of(0));

			conjured.updateQuality();
			assertStandardItemHasProperties(conjured, Conjured.class, SellIn.days(0), Quality.of(0));

			conjured.updateQuality();
			assertStandardItemHasProperties(conjured, Conjured.class, SellIn.days(-1), Quality.of(0));
		}
	}
}