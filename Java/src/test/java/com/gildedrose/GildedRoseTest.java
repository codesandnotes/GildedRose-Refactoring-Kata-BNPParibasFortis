package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void instantiateTheAppWithOneItem() {
		Item[] items = new Item[]{new Item("myFirstItem", 0, 0)};
		GildedRose app = new GildedRose(items);

		assertEquals("myFirstItem", app.items[0].name);
	}

	@Test
	void instantiateTheAppWithMultipleItems() {
		Item[] items = new Item[]{
				new Item("Aged Brie", 0, 0),
				new Item("Aged Brie", 0, 0)
		};

		GildedRose app = new GildedRose(items);

		assertEquals("Aged Brie", app.items[0].name);
		assertEquals("Aged Brie", app.items[1].name);
	}

	@Test
	void updateItemsQuality() {
		Item[] items = new Item[]{
				new Item("Aged Brie", 10, 30),
				new Item("Harry Potter's Magic Wand", 10, 30),
		};
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, app.items[0].sellIn);
		assertEquals(31, app.items[0].quality);
		assertEquals(9, app.items[1].sellIn);
		assertEquals(29, app.items[1].quality);
	}
}
