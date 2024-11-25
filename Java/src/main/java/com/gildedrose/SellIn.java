package com.gildedrose;

import java.util.Objects;

final class SellIn {

	private final int days;

	private SellIn(int days) {
		this.days = days;
	}

	int daysAsInteger() {
		return days;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SellIn sellIn = (SellIn) o;
		return days == sellIn.days;
	}

	@Override
	public int hashCode() {
		return Objects.hash(days);
	}

	static SellIn days(int days) {
		return new SellIn(days);
	}
}
