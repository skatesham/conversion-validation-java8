package sham.study.functionvalidation.domain.model;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemUtil {

	public static void finalizeOperation(final List<Item> items) {
		System.out.println("-----> Results <-----");
		for (final Object item : items) {
			System.out.println(item.toString());
		}
	}

}
