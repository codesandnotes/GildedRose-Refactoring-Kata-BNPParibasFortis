package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void instantiateTheAppWithOneItem() {
        Item[] items = new Item[] { new Item("myFirstItem", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("myFirstItem", app.items[0].name);
    }
}
