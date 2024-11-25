package com.gildedrose;

final class BackstagePass extends Item {

	private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

	private BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	static BackstagePass create(SellIn sellIn, Quality quality) {
		return new BackstagePass(ITEM_NAME, sellIn.daysAsInteger(), quality.valueAsInteger());
	}

	void updateQuality() {

		int qualityIncrease = 1;
		if (sellIn <= 10 && sellIn > 5) {
			qualityIncrease = 2;
		}
		if (sellIn <= 5) {
			qualityIncrease = 3;
		}

		this.sellIn--;
		if (sellIn < 0) {
			this.quality = 0;
			return;
		}

		this.quality = Math.min(50, quality + qualityIncrease);
	}
}
