package com.gildedrose;

public class AgedBrie extends Item {

	private static final String ITEM_NAME = "Aged Brie";

	private AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static AgedBrie create(int sellIn, int quality) {
		return new AgedBrie(ITEM_NAME, sellIn, quality);
	}
}
