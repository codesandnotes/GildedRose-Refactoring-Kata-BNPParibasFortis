package com.gildedrose;

final class AgedBrie extends Item {

	private static final String ITEM_NAME = "Aged Brie";

	private AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static AgedBrie create(SellIn days, Quality quality) {
		return new AgedBrie(ITEM_NAME, days.daysAsInteger(), quality.valueAsInteger());
	}

	void updateQuality() {
		this.sellIn--;
		int qualityIncrease = sellIn < 0 ? 2 : 1;
		this.quality = Math.min(50, quality + qualityIncrease);
	}
}
