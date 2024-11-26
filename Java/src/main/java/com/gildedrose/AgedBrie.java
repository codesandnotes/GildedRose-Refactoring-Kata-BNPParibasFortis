package com.gildedrose;

final class AgedBrie extends StandardItem {

	private AgedBrie(Item item) {
		super(item);
	}

	@Override
	void assessQuality() {
		int qualityIncrease = sellIn().daysAsInteger() < 0 ? 2 : 1;
		setQuality(quality().increaseBy(qualityIncrease, STANDARD_QUALITY_CEILING));
	}

	static AgedBrie create(Item item) {
		return new AgedBrie(item);
	}
}
