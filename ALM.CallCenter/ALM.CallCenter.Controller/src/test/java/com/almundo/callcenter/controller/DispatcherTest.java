package com.almundo.callcenter.controller;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.EmployeeManagerTest;
import com.almundo.callcenter.model.Profile;
import com.almundo.callcenter.util.Constant;
import com.almundo.tracemanager.GenericLogger;
import com.almundo.tracemanager.LoggerFactory;

/**
 * Unit test for simple DispatcherTest.
 */
public class DispatcherTest {

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
	 * Dispatches ten concurrent calls
	 */
	@Test
	public void dispatchTenConcurrentCalls() {

		EmployeeManager employeeManager = new EmployeeManager(Constant.NUMBER_OF_OPERATORS,
				Constant.NUMBER_OF_SUPERVISOR, Constant.NUMBER_OF_DIRECTOR);

		Dispatcher dispatcher = new Dispatcher(10, employeeManager);

		IntStream.range(0, 10).forEach(i -> dispatcher
				.dispatchCall(new Call(System.nanoTime(), Constant.CALL_MIN_DURATION, Constant.CALL_MAX_DURATION)));
		 dispatcher.shutdown();

	}

	/**
	 * Dispatches ten concurrent calls
	 */
	 @Test
	public void dispatchTenConcurrentCallsWithFourEmployee() {

		EmployeeManager employeeManager = new EmployeeManager(2, 1, 1);

		Dispatcher dispatcher = new Dispatcher(10, employeeManager);

		IntStream.range(0, 10).forEach(i -> dispatcher
				.dispatchCall(new Call(System.nanoTime(), Constant.CALL_MIN_DURATION, Constant.CALL_MAX_DURATION)));
		dispatcher.shutdown();

	}
}
