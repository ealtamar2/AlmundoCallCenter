/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter;

import java.util.stream.IntStream;

import com.almundo.callcenter.controller.Dispatcher;
import com.almundo.callcenter.controller.EmployeeManager;
import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.util.Constant;

/**
 * CallCenter Application main class
 *
 * @author ealtamar2
 */
public class CallCenter {

	public static void main(String[] args) {

		EmployeeManager employeeManager = new EmployeeManager(Constant.NUMBER_OF_OPERATORS,
				Constant.NUMBER_OF_SUPERVISOR, Constant.NUMBER_OF_DIRECTOR);

		Dispatcher dispatcher = new Dispatcher(10, employeeManager);

		IntStream.range(0, 11).forEach(i -> dispatcher
				.dispatchCall(new Call(System.nanoTime(), Constant.CALL_MIN_DURATION, Constant.CALL_MAX_DURATION)));
		dispatcher.shutdown();

	}

}
