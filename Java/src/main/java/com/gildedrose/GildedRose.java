package com.gildedrose;

final class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            StandardItem standardItem = StandardItem.from(items[i]);
            standardItem.updateQuality();
            items[i] = standardItem.item();
        }
    }
}
