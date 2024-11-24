package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasTest {

	@Test
	void instantiateASulfurasObject() {
		Item item = Sulfuras.create(-1);

		assertEquals("Sulfuras, Hand of Ragnaros", item.name);
		assertEquals(80, item.quality);
		assertEquals(-1, item.sellIn);
	}
}