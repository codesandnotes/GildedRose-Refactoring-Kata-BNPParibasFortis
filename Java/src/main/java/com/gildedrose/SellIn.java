package com.gildedrose;

class SellIn {

	private final int days;

	private SellIn(int days) {
		this.days = days;
	}

	int daysAsInteger() {
		return days;
	}

	static SellIn days(int days) {
		return new SellIn(days);
	}
}
