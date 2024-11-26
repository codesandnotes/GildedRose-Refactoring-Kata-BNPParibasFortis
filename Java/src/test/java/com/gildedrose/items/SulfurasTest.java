package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.StandardItemAssertions.assertStandardItemHasProperties;

class SulfurasTest {

	@Test
	void instantiatesASulfurasObject() {
		Sulfuras sulfuras = Sulfuras.create(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		assertStandardItemHasProperties(sulfuras, Sulfuras.class, SellIn.days(-1), Quality.of(80));
	}

	@Nested
	class QualityUpdate {

		@Test
		void updatesItsQualityByMaintainingItsProperties() {
			Sulfuras sulfuras = Sulfuras.create(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
			sulfuras.updateQuality();
			assertStandardItemHasProperties(sulfuras, Sulfuras.class, SellIn.days(-1), Quality.of(80));
		}
	}
}