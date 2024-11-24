package com.gildedrose;

final class Quality {

	private final int qualityValue;

	private Quality(int quality) {
		this.qualityValue = quality;
	}

	int valueAsInteger() {
		return qualityValue;
	}

	static Quality of(int value) {
		return new Quality(value);
	}
}
