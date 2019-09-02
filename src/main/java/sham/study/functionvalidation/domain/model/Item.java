package sham.study.functionvalidation.domain.model;

import java.time.LocalDate;
import java.util.Map;

import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
public class Item {

	private int code;
	private String description;
	private CodeType type;
	private LocalDate date;
	private String extra;

	public enum CodeType {
		HIGH(0), LOW(1);

		private Integer classification;
		private static Map<Integer, CodeType> map;

		private CodeType(final int v) {
			this.classification = v;
		}

		static {
			map = Maps.newHashMap();
			for (final CodeType codeType : CodeType.values()) {
				map.put(codeType.classification, codeType);
			}
		}

		public static CodeType valueOfKey(final Integer arg) {
			return map.get(arg);
		}
	}

}
