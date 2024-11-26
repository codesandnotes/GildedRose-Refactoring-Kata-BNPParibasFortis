package com.gildedrose;

final class AgedBrie extends StandardItem {

	private AgedBrie(Item item) {
		super(item);
	}

	@Override
	protected void assessQuality() {
		int qualityIncrease = sellIn().daysAsInteger() < 0 ? 2 : 1;
		setQuality(Quality.of(Math.min(50, quality().valueAsInteger() + qualityIncrease)));
	}

	static AgedBrie create(Item item) {
		return new AgedBrie(item);
	}
}
