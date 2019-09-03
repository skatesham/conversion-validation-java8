package sham.study.functionvalidation.domain.util;

import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PrintConsole {

	public static void printList(final List<?> list) {
		for (final Object object : list) {
			System.out.println(object);
		}
	}
}
