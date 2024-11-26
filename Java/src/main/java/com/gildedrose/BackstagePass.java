package com.gildedrose;

final class BackstagePass extends StandardItem {

	private BackstagePass(Item item) {
		super(item);
	}

	@Override
	protected void assessQuality() {
		if (sellIn().daysAsInteger() < 0) {
			setQuality(Quality.of(0));
			return;
		}

		int qualityIncrease = 1;

		int sellInDays = sellIn().daysAsInteger();
		if (sellInDays < 10 && sellInDays >= 5) {
			qualityIncrease = 2;
		}
		if (sellInDays < 5) {
			qualityIncrease = 3;
		}

		setQuality(quality().increaseBy(qualityIncrease, 50));
	}

	static BackstagePass create(Item item) {
		return new BackstagePass(item);
	}
}
