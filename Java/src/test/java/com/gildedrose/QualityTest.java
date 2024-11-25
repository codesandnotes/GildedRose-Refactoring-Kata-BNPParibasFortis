package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QualityTest {

	@Test
	void implementsEquality() {
		//noinspection EqualsWithItself
		assertEquals(Quality.of(15), Quality.of(15));
		assertNotEquals(Quality.of(10), Quality.of(20));
	}

	@Test
	void implementsHashCode() {
		assertEquals(Quality.of(15).hashCode(), Quality.of(15).hashCode());
		assertNotEquals(Quality.of(10).hashCode(), Quality.of(20).hashCode());
	}

	@Test
	void returnsTheQualityValueAsAnInteger() {
		Quality quality = Quality.of(50);
		assertEquals(50, quality.valueAsInteger());
	}
}