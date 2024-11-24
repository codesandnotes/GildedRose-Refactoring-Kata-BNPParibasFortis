package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityTest {

	@Test
	void returnsTheQualityValueAsAnInteger() {
		Quality quality = Quality.of(50);
		assertEquals(50, quality.valueAsInteger());
	}
}