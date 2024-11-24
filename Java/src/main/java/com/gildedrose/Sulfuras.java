package com.gildedrose;

final class Sulfuras extends Item {

	private static final int IMMUTABLE_QUALITY = 80;
	private static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

	private Sulfuras(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static Sulfuras create(SellIn sellIn) {
		return new Sulfuras(ITEM_NAME, sellIn.daysAsInteger(), IMMUTABLE_QUALITY);
	}

	void updateQuality() {
		// Nothing is updated because it's a legendary item: never sold, never loses its quality.
	}
}
