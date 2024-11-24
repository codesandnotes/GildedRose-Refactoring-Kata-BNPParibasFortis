package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemAssertions {

	public static void assertItemHasProperties(Item item, SellIn sellIn, Quality quality) {
		assertEquals(sellIn.daysAsInteger(), item.sellIn);
		assertEquals(quality.valueAsInteger(), item.quality);
	}
}
