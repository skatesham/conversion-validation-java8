package sham.study.functionvalidation.domain.management;

import java.util.List;

import com.google.common.collect.Lists;

public class ExceptionManager extends RuntimeException {

	private static final long serialVersionUID = 8598331588399586142L;

	public static final List<String> messages = Lists.newArrayList();

	public ExceptionManager(final String message) {
		super(message);
		messages.add(message);
	}

}
