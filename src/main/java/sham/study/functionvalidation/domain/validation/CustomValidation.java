package sham.study.functionvalidation.domain.validation;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

public abstract class CustomValidation<I, O> {

	public static final Config config = Config.uniqueInstance;

	public abstract O validate(final I i);

	public <R> CustomValidation<I, R> andThen(final CustomValidation<? super O, ? extends R> after) {
		Objects.requireNonNull(after);

		final CustomValidation<I, O> before = this;
		return new CustomValidation<I, R>() {

			@Override
			public R validate(final I i) {
				final O validate = before.validate(i);
				return after.validate(validate);
			}
		};

	}

	@Builder
	@NoArgsConstructor(staticName = "of")
	@AllArgsConstructor(staticName = "of")
	public static class Config {
		public static final Config uniqueInstance = of();
		@Default
		public String pattern = "dd/MM/yyyy";

	}
}
