package com.gildedrose;

public class TexttestFixture {

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                AgedBrie.create( SellIn.days(2), Quality.of(0)),
                new Item("Elixir of the Mongoose", 5, 7),
                Sulfuras.create(SellIn.days(0)),
                Sulfuras.create(SellIn.days(-1)),
                BackstagePasses.create(SellIn.days(15), Quality.of(20)),
                BackstagePasses.create(SellIn.days(10), Quality.of(49)),
                BackstagePasses.create(SellIn.days(5), Quality.of(49)),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6),
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
