package sham.study.functionvalidation.domain.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.Item;

@UtilityClass
public class DataTypeValidation {

	public static CustomValidation<String, String> optional() {
		return ValidationOptional.of();
	}

	public static CustomValidation<String, String> notNull() {
		return ValidationNotNull.of();
	}

	public static CustomValidation<String, Integer> integer() {
		return ValidationInteger.of();
	}

	public static CustomValidation<String, String> cutText() {
		return ValidationCutText.of();
	}

	public static CustomValidation<String, LocalDate> date() {
		return ValidationDate.of();
	}

	public static CustomValidation<String, Item.CodeType> type() {
		return ValidationType.of();
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationOptional extends CustomValidation<String, String> {

		@Override
		public String validate(final String i) {
			try {
				return i.trim();
			} catch (final Exception e) {
				throw new ExceptionManager("Optional error");
			}
		}
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationNotNull extends CustomValidation<String, String> {

		@Override
		public String validate(final String i) {
			try {
				if (Objects.nonNull(i)) {
					return i.trim();
				}
				throw new Exception();
			} catch (final Exception e) {
				throw new ExceptionManager("Null Error");
			}
		}
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationInteger extends CustomValidation<String, Integer> {

		@Override
		public Integer validate(final String i) {

			try {
				return Integer.parseInt(i);
			} catch (final Exception e) {
				throw new ExceptionManager("Integer error");
			}
		}
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationCutText extends CustomValidation<String, String> {

		@Override
		public String validate(final String i) {
			try {
				return i.substring(0, 2);
			} catch (final Exception e) {
				throw new ExceptionManager("CutText error");
			}
		}
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationDate extends CustomValidation<String, LocalDate> {

		@Override
		public LocalDate validate(final String i) {
			try {
				final DateTimeFormatter formmater = DateTimeFormatter.ofPattern(CustomValidation.config.pattern);
				return LocalDate.parse(i.substring(0, 10), formmater);
			} catch (final Exception e) {
				throw new ExceptionManager("Date error");
			}
		}
	}

	@NoArgsConstructor(staticName = "of")
	public static class ValidationType extends CustomValidation<String, Item.CodeType> {

		@Override
		public Item.CodeType validate(final String i) {

			try {
				final Integer parseInt = Integer.parseInt(i);
				return Item.CodeType.valueOfKey(parseInt);
			} catch (final Exception e) {
				throw new ExceptionManager("Type code error");
			}
		}
	}

}
