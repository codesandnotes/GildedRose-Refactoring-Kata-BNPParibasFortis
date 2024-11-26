package com.gildedrose.items;

import com.gildedrose.Item;

final class Sulfuras extends StandardItem {

	private static final int IMMUTABLE_QUALITY = 80;

	private Sulfuras(Item item) {
		super(item);
	}

	@Override
	void assessQuality() {
		setQuality(Quality.of(IMMUTABLE_QUALITY));
	}

	@Override
	void decreaseSellIn() {
		// sell-in never updates
	}

	static Sulfuras create(Item item) {
		return new Sulfuras(item);
	}
}
