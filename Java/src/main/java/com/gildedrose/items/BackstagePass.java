package com.gildedrose.items;

import com.gildedrose.Item;

final class BackstagePass extends StandardItem {

	public static final int HIGHER_BOUNDARY = 10;
	public static final int LOWER_BOUNDARY = 5;

	private BackstagePass(Item item) {
		super(item);
	}

	@Override
	void assessQuality() {
		if (sellIn().isLowerThan(0)) {
			setQuality(Quality.of(0));
			return;
		}

		int qualityIncrease = 1;

		int sellInDays = sellIn().daysAsInteger();
		if (sellInDays < HIGHER_BOUNDARY && sellInDays >= LOWER_BOUNDARY) {
			qualityIncrease = 2;
		}
		if (sellInDays < LOWER_BOUNDARY) {
			qualityIncrease = 3;
		}

		setQuality(quality().increaseBy(qualityIncrease, STANDARD_QUALITY_CEILING));
	}

	static BackstagePass create(Item item) {
		return new BackstagePass(item);
	}
}
