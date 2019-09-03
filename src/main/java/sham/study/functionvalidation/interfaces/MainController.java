package sham.study.functionvalidation.interfaces;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import lombok.experimental.UtilityClass;
import sham.study.functionvalidation.application.CustomValidationFacade;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.BruteItem;
import sham.study.functionvalidation.domain.model.Item;
import sham.study.functionvalidation.domain.model.ItemFixture;
import sham.study.functionvalidation.domain.model.ItemGenerator;
import sham.study.functionvalidation.domain.util.PrintConsole;

@UtilityClass
public class MainController {

	public static List<Item> run(final boolean isDebug) {
		ItemFixture.loadTemplate();
		final List<BruteItem> bruteItems = ItemGenerator.generate(10);
		final List<BruteItem> gimme = Fixture.from(BruteItem.class).gimme(5, ItemFixture.DEFAULT);
		final List<Item> items = convertBruteItemsToItemsWithValidation(bruteItems);
		PrintConsole.printList(items);
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
