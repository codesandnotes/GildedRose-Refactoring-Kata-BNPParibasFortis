package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemAssertions.assertItemHasProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassTest {

	@Test
	void instantiatesABackstagePassesObject() {
		Item item = BackstagePass.create(SellIn.days(20), Quality.of(30));

		assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
		assertEquals(30, item.quality);
		assertEquals(20, item.sellIn);
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			BackstagePass item = BackstagePass.create(SellIn.days(20), Quality.of(30));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(19), Quality.of(31));
		}

		@Test
		void neverUpdatesTheQualityAbove50() {
			BackstagePass item = BackstagePass.create(SellIn.days(20), Quality.of(49));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(19), Quality.of(50));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(18), Quality.of(50));
		}

		@Test
		void updatesQualityByTwoWhenSellInDaysAreOver5ButLessOrEqualThan10() {
			BackstagePass item = BackstagePass.create(SellIn.days(12), Quality.of(30));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(11), Quality.of(31));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(10), Quality.of(32));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(9), Quality.of(34));
		}

		@Test
		void updatesQualityByThreeWhenSellInDaysAreLessOrEqualThan5() {
			BackstagePass item = BackstagePass.create(SellIn.days(7), Quality.of(30));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(6), Quality.of(32));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(5), Quality.of(34));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(4), Quality.of(37));
		}

		@Test
		void freezesQualityTo0WhenTheConcertIsOver() {
			BackstagePass item = BackstagePass.create(SellIn.days(1), Quality.of(30));
			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(0), Quality.of(33));

			item.updateQuality();
			assertItemHasProperties(item, SellIn.days(-1), Quality.of(0));
		}
	}
}