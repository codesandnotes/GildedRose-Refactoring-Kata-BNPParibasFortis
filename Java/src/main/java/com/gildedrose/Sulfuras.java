package com.gildedrose;

class Sulfuras extends Item {

	private static final int IMMUTABLE_QUALITY = 80;
	private static final int IMMUTABLE_SELL_IN = -1;
	private static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

	private Sulfuras(String name, int quality, int sellIn) {
		super(name, sellIn, quality);
	}

	static Sulfuras create() {
		return new Sulfuras(ITEM_NAME, IMMUTABLE_QUALITY, IMMUTABLE_SELL_IN);
	}
}
