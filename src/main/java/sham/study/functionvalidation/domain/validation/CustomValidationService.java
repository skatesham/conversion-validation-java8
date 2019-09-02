package sham.study.functionvalidation.domain.validation;

import static sham.study.functionvalidation.domain.validation.DataTypeValidation.cutText;
import static sham.study.functionvalidation.domain.validation.DataTypeValidation.date;
import static sham.study.functionvalidation.domain.validation.DataTypeValidation.integer;
import static sham.study.functionvalidation.domain.validation.DataTypeValidation.notNull;
import static sham.study.functionvalidation.domain.validation.DataTypeValidation.type;

import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.BruteItem;
import sham.study.functionvalidation.domain.model.Item;

@UtilityClass
public class CustomValidationService {

	@NoArgsConstructor(staticName = "of")
	public static class ConverterDataType {

		public <I, O> void fromTo(final Supplier<I> data, final Consumer<O> target,
				final CustomValidation<I, O> validation) {
			try {
				target.accept(validation.validate(data.get()));
			} catch (final ExceptionManager e) {
//				System.out.println("Logging error...");
			}
		}

	}

	public static void validate(final BruteItem bruteItem, final Item.ItemBuilder itemBuilder,
			final ConverterDataType validator) {
		validator.fromTo(bruteItem::getCode, itemBuilder::code, integer());
		validator.fromTo(bruteItem::getDescription, itemBuilder::description, cutText());
		validator.fromTo(bruteItem::getType, itemBuilder::type, type());
		validator.fromTo(bruteItem::getDate, itemBuilder::date, date());
		validator.fromTo(bruteItem::getNullableField, itemBuilder::extra, notNull());

	}

}
