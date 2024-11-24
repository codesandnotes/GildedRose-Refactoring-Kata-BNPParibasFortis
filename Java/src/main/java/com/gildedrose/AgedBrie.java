package com.gildedrose;

public class AgedBrie extends Item {

	private static final String ITEM_NAME = "Aged Brie";

	private AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static AgedBrie create(SellIn days, Quality quality) {
		return new AgedBrie(ITEM_NAME, days.daysAsInteger(), quality.valueAsInteger());
	}
}
