package com.gildedrose;

final class Sulfuras extends StandardItem {

	private static final int IMMUTABLE_QUALITY = 80;

	private Sulfuras(Item item) {
		super(item);
	}

	@Override
	protected void assessQuality() {
		setQuality(Quality.of(IMMUTABLE_QUALITY));
	}

	@Override
	protected void decreaseSellIn() {
		// sell-in never updates
	}

	static Sulfuras create(Item item) {
		return new Sulfuras(item);
	}
}
