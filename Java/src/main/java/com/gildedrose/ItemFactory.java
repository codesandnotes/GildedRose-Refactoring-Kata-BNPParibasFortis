package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

class ItemFactory {

	private static final Map<String, BiFunction<SellIn, Quality, Item>> FACTORY_FUNCTIONS = new HashMap<>();

	Item build(String name, SellIn sellIn) {
		return build(name, sellIn, Quality.of(80));
	}

	Item build(String name, SellIn sellIn, Quality quality) {
		return factoryFunctions(name)
				.map(function -> function.apply(sellIn, quality))
				.orElse(new Item(name, sellIn.daysAsInteger(), quality.valueAsInteger()));
	}

	private Optional<BiFunction<SellIn, Quality, Item>> factoryFunctions(String name) {
		if (FACTORY_FUNCTIONS.isEmpty()) {
			initializeFactoryFunctions();
		}
		BiFunction<SellIn, Quality, Item> factoryFunction = FACTORY_FUNCTIONS.get(name);
		return Optional.ofNullable(factoryFunction);
	}

	private void initializeFactoryFunctions() {
		FACTORY_FUNCTIONS.put("Aged Brie", AgedBrie::create);
		FACTORY_FUNCTIONS.put("Backstage passes to a TAFKAL80ETC concert", BackstagePass::create);
		FACTORY_FUNCTIONS.put("Sulfuras, Hand of Ragnaros", (sellIn, quality) -> Sulfuras.create(sellIn));
	}
}
