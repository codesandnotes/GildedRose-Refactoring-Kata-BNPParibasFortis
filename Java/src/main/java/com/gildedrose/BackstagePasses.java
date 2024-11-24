package com.gildedrose;

public class BackstagePasses extends Item {

	private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

	private BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static BackstagePasses create(int sellIn, int quality) {
		return new BackstagePasses(ITEM_NAME, sellIn, quality);
	}
}
