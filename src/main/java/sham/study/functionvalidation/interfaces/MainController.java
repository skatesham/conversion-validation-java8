package sham.study.functionvalidation.interfaces;

import java.util.List;

import lombok.experimental.UtilityClass;
import sham.study.functionvalidation.application.CustomValidationFacade;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.BruteItem;
import sham.study.functionvalidation.domain.model.Item;
import sham.study.functionvalidation.domain.model.ItemGenerator;

@UtilityClass
public class MainController {

	public static List<Item> run(final boolean isDebug) {
		final List<BruteItem> bruteItems = ItemGenerator.generate(10);
		final List<Item> items = convertBruteItemsToItemsWithValidation(bruteItems);
		activateLog(isDebug);
		return items;

	}

	public List<Item> convertBruteItemsToItemsWithValidation(final List<BruteItem> bruteItems) {
		return CustomValidationFacade.validate(bruteItems);
	}

	public List<String> showLogErrors() {
		return ExceptionManager.printErrors();
	}

	private void activateLog(final boolean isActivate) {
		if (isActivate) {
			showLogErrors();
		}
	}

}
