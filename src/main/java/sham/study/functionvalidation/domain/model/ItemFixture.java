package sham.study.functionvalidation.domain.model;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class ItemFixture {

	public static final String DEFAULT = "DEFAULT";

	public static void loadTemplate() {
		loadBruteItems();
	}

	private static void loadBruteItems() {
		Fixture.of(BruteItem.class).addTemplate(DEFAULT, new Rule() {
			{
				this.add("code", "123456789");
				this.add("description", "STRING EXEMPLE");
				this.add("type", "1");
				this.add("date", "01/01/2000");
				this.add("nullableField", "true");
			}
		});
	}

}
