package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SellInTest {

	@Test
	void implementsEquality() {
		//noinspection EqualsWithItself
		assertEquals(SellIn.days(15), SellIn.days(15));
		assertNotEquals(SellIn.days(10), SellIn.days(20));
	}

	@Test
	void implementsHashCode() {
		assertEquals(SellIn.days(15).hashCode(), SellIn.days(15).hashCode());
		assertNotEquals(SellIn.days(10).hashCode(), SellIn.days(20).hashCode());
	}

	@Test
	void returnsTheSellInDaysAsAnInteger() {
		SellIn sellIn = SellIn.days(3);
		assertEquals(3, sellIn.daysAsInteger());
	}
}