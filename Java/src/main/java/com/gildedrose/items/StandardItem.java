package com.gildedrose.items;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class StandardItem {

	static final int STANDARD_QUALITY_CEILING = 50;

	private static final Map<String, Function<Item, StandardItem>> FACTORY_FUNCTIONS = new HashMap<>();

	private final Item item;

	StandardItem(Item item) {
		this.item = item;
	}

	public final Item item() {
		return item;
	}

	public final Quality quality() {
		return Quality.of(item.quality);
	}

	public final SellIn sellIn() {
		return SellIn.days(item.sellIn);
	}

	public final void updateQuality() {
		decreaseSellIn();
		assessQuality();
	}

	final void setQuality(Quality quality) {
		item.quality = quality.valueAsInteger();
	}

	void assessQuality() {
		item.quality = item.sellIn < 0 ? item.quality - 2 : item.quality - 1;
		if (item.quality < 0) {
			item.quality = 0;
		}
	}

	void decreaseSellIn() {
		item.sellIn--;
	}

	public static StandardItem from(Item item) {
		Optional<Function<Item, StandardItem>> factoryFunction = factoryFunctions(item.name);
		Item itemClone = new Item(item.name, item.sellIn, item.quality);
		return factoryFunction.map(fn -> fn.apply(itemClone)).orElse(new StandardItem(itemClone));
	}

	private static Optional<Function<Item, StandardItem>> factoryFunctions(String name) {
		if (FACTORY_FUNCTIONS.isEmpty()) {
			initializeFactoryFunctions();
		}
		Function<Item, StandardItem> factoryFunction = FACTORY_FUNCTIONS.get(name);
		return Optional.ofNullable(factoryFunction);
	}

	private static void initializeFactoryFunctions() {
		FACTORY_FUNCTIONS.put("Aged Brie", AgedBrie::create);
		FACTORY_FUNCTIONS.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass::create);
		FACTORY_FUNCTIONS.put("Conjured Mana Cake", Conjured::create);
		FACTORY_FUNCTIONS.put("Sulfuras, Hand of Ragnaros", Sulfuras::create);
	}
}
