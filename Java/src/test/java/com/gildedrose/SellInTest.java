package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellInTest {

	@Test
	void returnsTheSellInDaysAsAnInteger() {
		SellIn sellIn = SellIn.days(3);
		assertEquals(3, sellIn.daysAsInteger());
	}
}