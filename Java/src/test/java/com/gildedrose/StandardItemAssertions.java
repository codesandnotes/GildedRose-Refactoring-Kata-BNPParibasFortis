package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardItemAssertions{

		public static void assertStandardItemHasProperties(StandardItem standardItem, Class<?> type, SellIn sellIn, Quality quality) {
			assertEquals(type, standardItem.getClass());
			assertEquals(sellIn.daysAsInteger(), standardItem.sellIn().daysAsInteger());
			assertEquals(quality.valueAsInteger(), standardItem.quality().valueAsInteger());
		}
}