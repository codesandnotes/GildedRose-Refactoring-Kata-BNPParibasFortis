package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardItems {

	private final List<StandardItem> listOfStandardItems;

	StandardItems(List<StandardItem> standardItems) {
		this.listOfStandardItems = standardItems;
	}

	StandardItem get(int index) {
		return listOfStandardItems.get(index);
	}

	static StandardItems from(Item[] items) {
		List<StandardItem> standardItems = Arrays.stream(items)
				.map(StandardItem::from)
				.collect(Collectors.toList());
		return new StandardItems(standardItems);
	}
}
