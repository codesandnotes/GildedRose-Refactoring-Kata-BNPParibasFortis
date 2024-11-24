package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Nested
	class Instantiation {

		@Test
		void instantiatesTheAppWithOneItem() {
			Item[] items = new Item[]{new Item("some item", 0, 0)};
			GildedRose app = new GildedRose(items);

			assertEquals("some item", app.items[0].name);
		}

		@Test
		void instantiatesTheAppWithMultipleItems() {
			Item[] items = new Item[]{
					AgedBrie.create(SellIn.days(0), Quality.of(0)),
					AgedBrie.create(SellIn.days(0), Quality.of(0)),
			};

			GildedRose app = new GildedRose(items);

			assertEquals("Aged Brie", app.items[0].name);
			assertEquals("Aged Brie", app.items[1].name);
		}
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesTheQualityOfAStandardItem() {
			GildedRose app = new GildedRose(new Item[]{new Item("Harry Potter's Magic Wand", 10, 30)});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(9), Quality.of(29));
		}

		@Test
		void updatesTheQualityOfASulfuras() {
			GildedRose app = new GildedRose(new Item[]{Sulfuras.create(SellIn.days(-1))});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(-1), Quality.of(80));
		}

		@Test
		void updatesTheQualityOfAnAgedBrie() {
			GildedRose app = new GildedRose(new Item[]{AgedBrie.create(SellIn.days(10), Quality.of(10))});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(9), Quality.of(11));
		}

		@Test
		void updatesTheQualityOfABackstagePass() {
			GildedRose app = new GildedRose(new Item[]{BackstagePass.create(SellIn.days(10), Quality.of(10))});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(9), Quality.of(12));
		}

		private void assertItemHasProperties(Item item, SellIn sellIn, Quality quality) {
			assertEquals(sellIn.daysAsInteger(), item.sellIn);
			assertEquals(quality.valueAsInteger(), item.quality);
		}
	}
}
