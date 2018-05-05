package com.almundo.callcenter.model;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.almundo.callcenter.controller.EmployeeManager;
import com.almundo.tracemanager.GenericLogger;
import com.almundo.tracemanager.LoggerFactory;

/**
 * Unit test for simple EmployeeManagerTest.
 */
public class EmployeeManagerTest {

	private EmployeeManager employedManager;
	private GenericLogger logger;

	@Before
	public void setUp() {
		logger = LoggerFactory.getLogger(EmployeeManagerTest.class);
		employedManager = new EmployeeManager();
		employedManager.add(new Employee(1, Profile.OPERATOR));
		employedManager.add(new Employee(2, Profile.SUPERVISOR));
		employedManager.add(new Employee(3, Profile.SUPERVISOR));
		employedManager.add(new Employee(4, Profile.DIRECTOR));
		employedManager.add(new Employee(5, Profile.OPERATOR));
		employedManager.add(new Employee(6, Profile.OPERATOR));

	}

	/**
	 * Get Employee by Priority
	 */
	@Test
	public void getEmployee() {
		try {
			IntStream.range(0, 6).forEach(i -> logger.traceDebug("Employee: " + employedManager.poll()));

		} catch (Exception e) {

			logger.traceDebug(e.getMessage());

		}

	}
}
