package com.gildedrose;

final class Conjured extends StandardItem {

	private Conjured(Item item) {
		super(item);
	}

	@Override
	void assessQuality() {
		setQuality(quality().decreaseBy(2));
	}

	static Conjured create(Item item) {
		return new Conjured(item);
	}
}
