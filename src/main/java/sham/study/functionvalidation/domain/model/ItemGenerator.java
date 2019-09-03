package sham.study.functionvalidation.domain.model;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemGenerator {

	private static Random random = new Random();

	public static List<BruteItem> generate(final int quantity) {
		final List<BruteItem> items = Lists.newArrayList();
		for (int i = 0; i < quantity; i++) {
			final String code = String.valueOf(i + 10000000);
			final String description = randomString();
			final String type = String.valueOf(random.nextInt(2));
			final String date = "01/01/" + (2000 + i);
			final BruteItem bruteItem = BruteItem.of(code, description, type, date, "true");
//			final BruteItem bruteItem = BruteItem.of(null, null, null, null, "null");
			items.add(bruteItem);
		}
		return items;
	}

	public static List<BruteItem> getBruteItems() {
		return null;
	}

	private String randomString() {
		final int leftLimit = 97; // letter 'a'
		final int rightLimit = 122; // letter 'z'
//	    final int targetStringLength = 10;
		final int targetStringLength = random.nextInt(10);
		final StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			final int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString().toUpperCase();
	}
}
