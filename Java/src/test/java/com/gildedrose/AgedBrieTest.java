package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemAssertions.assertItemHasProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

	@Test
	void instantiatesAnAgedBrieObject() {
		Item item = AgedBrie.create(SellIn.days(10), Quality.of(20));

		assertEquals("Aged Brie", item.name);
		assertItemHasProperties(item, SellIn.days(10), Quality.of(20));
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			AgedBrie item = AgedBrie.create(SellIn.days(10), Quality.of(20));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(9), Quality.of(21));
		}

		@Test
		void increasesQualityTwofoldWhenSellInDaysIsBelowZero() {
			AgedBrie item = AgedBrie.create(SellIn.days(1), Quality.of(30));
			item.updateQuality();
			assertEquals(31, item.quality);
			assertEquals(0, item.sellIn);

			item.updateQuality();
			assertEquals(33, item.quality);
			assertEquals(-1, item.sellIn);

			item.updateQuality();
			assertEquals(35, item.quality);
			assertEquals(-2, item.sellIn);
		}

		@Test
		void neverUpdatesTheQualityAbove50() {
			AgedBrie item = AgedBrie.create(SellIn.days(4), Quality.of(49));
			item.updateQuality();
			assertEquals(50, item.quality);

			item.updateQuality();
			assertEquals(50, item.quality);

			AgedBrie veryOldItem = AgedBrie.create(SellIn.days(-1), Quality.of(49));
			veryOldItem.updateQuality();
			assertEquals(50, item.quality);
		}
	}
}