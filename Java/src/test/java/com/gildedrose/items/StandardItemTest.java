package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.StandardItemAssertions.assertStandardItemHasProperties;

class StandardItemTest {

	@Nested
	class Instantiation {

		@Test
		void instantiatesAStandardItemObject() {
			StandardItem standardItem = StandardItem.from(new Item("Terminator's leather jacket", 10, 20));
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(10), Quality.of(20));
		}

		@Test
		void instantiatesASulfurasObject() {
			StandardItem standardItem = StandardItem.from(new Item("Sulfuras, Hand of Ragnaros", 10, 20));
			assertStandardItemHasProperties(standardItem, Sulfuras.class, SellIn.days(10), Quality.of(20));
		}

		@Test
		void instantiatesABackstagePassObject() {
			StandardItem standardItem = StandardItem.from(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
			assertStandardItemHasProperties(standardItem, BackstagePass.class, SellIn.days(10), Quality.of(20));
		}

		@Test
		void instantiatesAnAgedBrieObject() {
			StandardItem standardItem = StandardItem.from(new Item("Aged Brie", 10, 20));
			assertStandardItemHasProperties(standardItem, AgedBrie.class, SellIn.days(10), Quality.of(20));
		}

		@Test
		void instantiatesAConjuredObject() {
			StandardItem standardItem = StandardItem.from(new Item("Conjured Mana Cake", 10, 20));
			assertStandardItemHasProperties(standardItem, Conjured.class, SellIn.days(10), Quality.of(20));
		}
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQuality() {
			StandardItem standardItem = StandardItem.from(new Item("Conan' sword", 10, 20));
			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(9), Quality.of(19));
		}

		@Test
		void decreasesItsQualityByTwoWhenTheSellInDateHasPassed() {
			StandardItem standardItem = StandardItem.from(new Item("Conan' sword", 1, 20));
			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(0), Quality.of(19));

			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(-1), Quality.of(17));
		}

		@Test
		void preventsQualityToBecomeNegative() {
			StandardItem standardItem = StandardItem.from(new Item("Conan' sword", 2, 1));
			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(1), Quality.of(0));

			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(0), Quality.of(0));

			standardItem.updateQuality();
			assertStandardItemHasProperties(standardItem, StandardItem.class, SellIn.days(-1), Quality.of(0));
		}
	}
}