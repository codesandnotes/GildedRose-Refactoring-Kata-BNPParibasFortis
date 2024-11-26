package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.StandardItemAssertions.assertStandardItemHasProperties;

class BackstagePassTest {

	@Test
	void instantiatesABackstagePassObject() {
		BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));
		assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(20), Quality.of(30));
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));
			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(19), Quality.of(31));
		}

		@Test
		void neverUpdatesTheQualityAbove50() {
			BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 49));
			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(19), Quality.of(50));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(18), Quality.of(50));
		}

		@Test
		void updatesQualityByTwoWhenSellInDaysAreOver5ButLessOrEqualThan10() {
			BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30));
			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(11), Quality.of(31));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(10), Quality.of(32));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(9), Quality.of(34));
		}

		@Test
		void updatesQualityByThreeWhenSellInDaysAreLessOrEqualThan5() {
			BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 7, 30));
			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(6), Quality.of(32));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(5), Quality.of(34));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(4), Quality.of(37));
		}

		@Test
		void freezesQualityTo0WhenTheConcertIsOver() {
			BackstagePass backstagePass = BackstagePass.create(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30));
			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(0), Quality.of(33));

			backstagePass.updateQuality();
			assertStandardItemHasProperties(backstagePass, BackstagePass.class, SellIn.days(-1), Quality.of(0));
		}
	}
}