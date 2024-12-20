package com.gildedrose.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	void indicatesWhetherAGivenNumberOfDaysIsLowerThanTheDaysRepresentedByTheInstance() {
		SellIn sellIn = SellIn.days(10);
		assertTrue(sellIn.isLowerThan(11));
		assertFalse(sellIn.isLowerThan(9));

		sellIn = SellIn.days(0);
		assertFalse(sellIn.isLowerThan(0));
		assertFalse(sellIn.isLowerThan(-1));
	}
}