package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Nested
	class Instantiation {

		@Test
		void instantiateTheAppWithOneItem() {
			Item[] items = new Item[]{new Item("some item", 0, 0)};
			GildedRose app = new GildedRose(items);

			assertEquals("some item", app.items[0].name);
		}

		@Test
		void instantiateTheAppWithMultipleItems() {
			Item[] items = new Item[]{
					AgedBrie.create(0, 0),
					AgedBrie.create(0, 0),
			};

			GildedRose app = new GildedRose(items);

			assertEquals("Aged Brie", app.items[0].name);
			assertEquals("Aged Brie", app.items[1].name);
		}
	}

	@Nested
	class QualityUpdate {

		@Test
		void updateTheQualityOfAStandardItem() {
			Item[] items = new Item[]{new Item("Harry Potter's Magic Wand", 10, 30)};
			GildedRose app = new GildedRose(items);

			app.updateQuality();

			assertEquals(9, app.items[0].sellIn);
			assertEquals(29, app.items[0].quality);
		}

		@Test
		void updateTheQualityOfASulfuras() {
			Item[] items = new Item[]{Sulfuras.create(-1)};
			GildedRose app = new GildedRose(items);

			app.updateQuality();

			assertEquals(-1, app.items[0].sellIn);
			assertEquals(80, app.items[0].quality);
		}
	}
}
