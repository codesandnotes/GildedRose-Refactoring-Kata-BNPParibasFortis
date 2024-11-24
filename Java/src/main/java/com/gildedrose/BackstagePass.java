package com.gildedrose;

final class BackstagePass extends Item {

	private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

	private BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static BackstagePass create(SellIn sellIn, Quality quality) {
		return new BackstagePass(ITEM_NAME, sellIn.daysAsInteger(), quality.valueAsInteger());
	}
}
