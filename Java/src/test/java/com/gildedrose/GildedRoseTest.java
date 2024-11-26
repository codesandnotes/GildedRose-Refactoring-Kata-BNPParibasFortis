package com.gildedrose;

import com.gildedrose.items.Quality;
import com.gildedrose.items.SellIn;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemAssertions.assertItemHasProperties;
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
					new Item("Aged Brie", 0, 0),
					new Item("Aged Brie", 0, 0)
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
			GildedRose app = new GildedRose(new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(-1), Quality.of(80));
		}

		@Test
		void updatesTheQualityOfAnAgedBrie() {
			GildedRose app = new GildedRose(new Item[]{new Item("Aged Brie", 10, 10)});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(9), Quality.of(11));
		}

		@Test
		void updatesTheQualityOfABackstagePass() {
			GildedRose app = new GildedRose(new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)});
			app.updateQuality();
			assertItemHasProperties(app.items[0], SellIn.days(9), Quality.of(12));
		}
	}
}
