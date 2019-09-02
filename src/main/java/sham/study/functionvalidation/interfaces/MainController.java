package sham.study.functionvalidation.interfaces;

import java.util.List;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import sham.study.functionvalidation.application.CustomValidationFacade;
import sham.study.functionvalidation.domain.model.BruteItem;
import sham.study.functionvalidation.domain.model.Item;
import sham.study.functionvalidation.domain.model.ItemGenerator;

@Slf4j
@UtilityClass
public class MainController {

	public static void run(final boolean isDebug) {
		final List<BruteItem> bruteItems = ItemGenerator.generate(10);
		final List<Item> items = CustomValidationFacade.validate(bruteItems);
		activateLog(items, isDebug);

	}

	private void activateLog(final List<Item> items, final boolean isActivate) {
		if (isActivate) {
			finalizeOperation(items);
			printErrors();
		}
	}

	private static void finalizeOperation(final List<Item> items) {
		System.out.println("-----> Results <-----");
		for (final Object item : items) {
			System.out.println(item.toString());
		}
	}

	private static void printErrors() {
		final List<String> errors = CustomValidationFacade.getError();
		System.out.println("-----> ERROS <-------");
		int count = 0;
		for (final Object item : errors) {

			System.out.println((count++) + ": " + item.toString());
		}
	}

}
