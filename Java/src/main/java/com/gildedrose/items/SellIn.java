package com.gildedrose.items;

import java.util.Objects;

public final class SellIn {

	private final int days;

	private SellIn(int days) {
		this.days = days;
	}

	public int daysAsInteger() {
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

	public static SellIn days(int days) {
		return new SellIn(days);
	}

	public boolean isLowerThan(int days) {
		return this.days < days;
	}
}
