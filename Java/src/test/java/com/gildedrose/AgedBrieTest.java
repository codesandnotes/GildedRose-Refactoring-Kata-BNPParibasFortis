package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

	@Test
	void instantiatesAnAgedBrieObject() {
		Item item = AgedBrie.create(SellIn.days(10), Quality.of(20));

		assertEquals("Aged Brie", item.name);
		assertEquals(20, item.quality);
		assertEquals(10, item.sellIn);
	}
}