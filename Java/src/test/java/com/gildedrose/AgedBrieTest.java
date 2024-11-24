package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

	@Test
	void instantiateAnAgedBrieObject() {
		Item item = AgedBrie.create(10, 20);

		assertEquals("Aged Brie", item.name);
		assertEquals(20, item.quality);
		assertEquals(10, item.sellIn);
	}
}