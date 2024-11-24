package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemFactoryTest {

	public static final Quality QUALITY_OF_30 = Quality.of(30);
	public static final SellIn SELL_IN_10_DAYS = SellIn.days(10);

	@Test
	void buildsAStandardItemByDefault() {
		Item item = new ItemFactory().build("some name", SELL_IN_10_DAYS, QUALITY_OF_30);
		assertItemHasProperties(item, Item.class, "some name", SELL_IN_10_DAYS, QUALITY_OF_30);
	}

	@Test
	void buildsASulfuras() {
		Item item = new ItemFactory().build("Sulfuras, Hand of Ragnaros", SellIn.days(-1));
		assertItemHasProperties(item, Sulfuras.class, "Sulfuras, Hand of Ragnaros", SellIn.days(-1), Quality.of(80));
	}

	@Test
	void buildsAnAgedBrie() {
		Item item = new ItemFactory().build("Aged Brie", SELL_IN_10_DAYS, QUALITY_OF_30);
		assertItemHasProperties(item, AgedBrie.class, "Aged Brie", SELL_IN_10_DAYS, QUALITY_OF_30);
	}

	@Test
	void buildABackstagePass() {
		Item item = new ItemFactory().build("Backstage passes to a TAFKAL80ETC concert", SELL_IN_10_DAYS, QUALITY_OF_30);
		assertItemHasProperties(item, BackstagePasses.class, "Backstage passes to a TAFKAL80ETC concert", SELL_IN_10_DAYS, QUALITY_OF_30);
	}

	private void assertItemHasProperties(Item item, Class<?> itemClass, String name, SellIn sellIn, Quality quality) {
		assertEquals(itemClass, item.getClass());
		assertEquals(name, item.name);
		assertEquals(sellIn.daysAsInteger(), item.sellIn);
		assertEquals(quality.valueAsInteger(), item.quality);
	}
}