package sham.study.functionvalidation;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import sham.study.functionvalidation.domain.management.ExceptionManager;
import sham.study.functionvalidation.domain.model.Item;
import sham.study.functionvalidation.interfaces.MainController;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(final String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		final List<Item> items = MainController.run(true);
		assertEquals(10, items.size());
		final List<String> errors = ExceptionManager.messages;
		assertEquals(10, errors.size());
	}
}
