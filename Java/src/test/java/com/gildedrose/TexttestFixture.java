package com.gildedrose;

public class TexttestFixture {

	public static void main(String[] args) {
		ItemFactory itemFactory = new ItemFactory();

		Item[] items = new Item[]{
				itemFactory.build("+5 Dexterity Vest", SellIn.days(10), Quality.of(20)),
				itemFactory.build("Aged Brie", SellIn.days(2), Quality.of(0)),
				itemFactory.build("Elixir of the Mongoose", SellIn.days(5), Quality.of(7)),
				itemFactory.build("Sulfuras, Hand of Ragnaros", SellIn.days(0)),
				itemFactory.build("Sulfuras, Hand of Ragnaros", SellIn.days(-1)),
				itemFactory.build("Backstage passes to a TAFKAL80ETC concert", SellIn.days(15), Quality.of(20)),
				itemFactory.build("Backstage passes to a TAFKAL80ETC concert", SellIn.days(10), Quality.of(49)),
				itemFactory.build("Backstage passes to a TAFKAL80ETC concert", SellIn.days(5), Quality.of(49)),
				// this conjured item does not work properly yet
				itemFactory.build("Conjured Mana Cake", SellIn.days(3), Quality.of(6)),
		};

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}
	}
}
