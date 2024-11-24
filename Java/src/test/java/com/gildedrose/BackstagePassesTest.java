package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesTest {

	@Test
	void instantiateABackstagePassesObject() {
		Item item = BackstagePasses.create(SellIn.days(10), Quality.of(20));

		assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
		assertEquals(20, item.quality);
		assertEquals(10, item.sellIn);
	}
}