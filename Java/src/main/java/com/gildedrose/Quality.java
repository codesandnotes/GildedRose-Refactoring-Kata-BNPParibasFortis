package com.gildedrose;

import java.util.Objects;

final class Quality {

	private final int qualityValue;

	private Quality(int quality) {
		this.qualityValue = quality;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Quality quality = (Quality) o;
		return qualityValue == quality.qualityValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(qualityValue);
	}

	int valueAsInteger() {
		return qualityValue;
	}

	static Quality of(int value) {
		return new Quality(value);
	}
}
