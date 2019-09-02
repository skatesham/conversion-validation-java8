package sham.study.functionvalidation.domain.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

public abstract class CustomValidation<I, O> {

	public static final Config config = Config.uniqueInstance;

	public abstract O validate(final I i);

	@Builder
	@NoArgsConstructor(staticName = "of")
	@AllArgsConstructor(staticName = "of")
	public static class Config {

		public static final Config uniqueInstance = of();

		@Default
		public String pattern = "dd/MM/yyyy";
	}
}
