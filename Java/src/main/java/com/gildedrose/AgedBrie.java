package com.gildedrose;

final class AgedBrie extends StandardItem {

	private AgedBrie(Item item) {
		super(item);
	}

	@Override
	protected void assessQuality() {
		int qualityIncrease = sellIn().daysAsInteger() < 0 ? 2 : 1;
		setQuality(quality().increaseBy(qualityIncrease, 50));
	}

	static AgedBrie create(Item item) {
		return new AgedBrie(item);
	}
}
