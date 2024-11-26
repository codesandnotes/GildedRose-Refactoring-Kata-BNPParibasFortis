package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.StandardItemAssertions.assertStandardItemHasProperties;

class AgedBrieTest {

	@Test
	void instantiatesAnAgedBrieObject() {
		AgedBrie agedBrie = AgedBrie.create(new Item("Aged Brie", 10, 20));
		assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(10), Quality.of(20));
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			AgedBrie agedBrie = AgedBrie.create(new Item("Aged Brie", 10, 20));
			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(9), Quality.of(21));
		}

		@Test
		void increasesQualityByTwoWhenSellInDaysIsBelowZero() {
			AgedBrie agedBrie = AgedBrie.create(new Item("Aged Brie", 1, 30));
			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(0), Quality.of(31));

			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(-1), Quality.of(33));

			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(-2), Quality.of(35));
		}

		@Test
		void neverUpdatesTheQualityAbove50() {
			AgedBrie agedBrie = AgedBrie.create(new Item("Aged Brie", 4, 49));
			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(3), Quality.of(50));

			agedBrie.updateQuality();
			assertStandardItemHasProperties(agedBrie, AgedBrie.class, SellIn.days(2), Quality.of(50));

			AgedBrie veryOldBrie = AgedBrie.create(new Item("Aged Brie", -1, 49));
			veryOldBrie.updateQuality();
			assertStandardItemHasProperties(veryOldBrie, AgedBrie.class, SellIn.days(-2), Quality.of(50));
		}
	}
}