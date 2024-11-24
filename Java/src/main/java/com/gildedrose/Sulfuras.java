package com.gildedrose;

class Sulfuras extends Item {

	private static final int IMMUTABLE_QUALITY = 80;
	private static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

	private Sulfuras(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static Sulfuras create(int sellIn) {
		return new Sulfuras(ITEM_NAME, sellIn, IMMUTABLE_QUALITY);
	}
}
