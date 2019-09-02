package sham.study.functionvalidation.application;

import java.util.List;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.BruteItem;
import sham.study.functionvalidation.domain.model.Item;
import sham.study.functionvalidation.domain.model.Item.ItemBuilder;
import sham.study.functionvalidation.domain.validation.CustomValidationService;
import sham.study.functionvalidation.domain.validation.CustomValidationService.ConverterDataType;

@UtilityClass
public class CustomValidationFacade {

	public static List<Item> validate(final List<BruteItem> bruteItems) {
		return bruteItems.stream().map(bruteItem -> {
			final ConverterDataType validator = ConverterDataType.of();
			final ItemBuilder itemBuilder = Item.builder();
			CustomValidationService.validate(bruteItem, itemBuilder, validator);
			return itemBuilder.build();
		}).collect(Collectors.toList());
	}

	public List<String> getError() {
		return ExceptionManager.messages;
	}

}
