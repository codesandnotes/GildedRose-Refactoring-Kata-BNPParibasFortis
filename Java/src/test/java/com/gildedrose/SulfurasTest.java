package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemAssertions.assertItemHasProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasTest {

	@Test
	void instantiatesASulfurasObject() {
		Sulfuras item = Sulfuras.create(SellIn.days(-1));

		assertEquals("Sulfuras, Hand of Ragnaros", item.name);
		assertItemHasProperties(item, SellIn.days(-1), Quality.of(80));
	}

	@Test
	void updatesItsQualityByMaintainingItsProperties() {
		Sulfuras item = Sulfuras.create(SellIn.days(-1));
		item.updateQuality();
		assertItemHasProperties(item, SellIn.days(-1), Quality.of(80));
	}
}