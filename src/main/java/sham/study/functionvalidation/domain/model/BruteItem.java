package sham.study.functionvalidation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class BruteItem {

	private String code;
	private String description;
	private String type;
	private String date;
	private String nullableField;

}
