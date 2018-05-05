package com.almundo.callcenter.controller;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.util.Constant;
import com.almundo.tracemanager.GenericLogger;
import com.almundo.tracemanager.LoggerFactory;

/**
 * Clase que se encarga de atender las llamadas del CallCenter
 * 
 * @author ealtamar2
 *
 */
public class Dispatcher extends ThreadPoolExecutor {

	private transient GenericLogger logger;
	private EmployeeManager employeeManager;

	public Dispatcher(int numberOfCall, EmployeeManager employeeManager) {
		super((employeeManager.size() < numberOfCall ? employeeManager.size() : numberOfCall),
				(employeeManager.size() < numberOfCall ? employeeManager.size() : numberOfCall), 15000L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		logger = LoggerFactory.getLogger(Dispatcher.class);
		this.employeeManager = employeeManager;

	}

	/**
	 * Metodo que se encarga de despachar las lladamas a los recursos
	 * disponibles
	 */
	public void dispatchCall(Call call) {

		submit(new Runnable() {
			public void run() {

				Employee employee = null;

				try {
					employee = employeeManager.getAvailableEmployee();

					if (null == employee) {
						logger.traceError("There are no employees available!" + call.getId(), null);
					} else {
						Thread.currentThread().setName(employee.toString());
						logger.traceInfo("Processing " + call.getId());
						Thread.sleep(call.getDuration());
						logger.traceInfo("Completed " + call.toString());
					}

				} catch (InterruptedException e) {
					logger.traceError(Constant.CALL_ANSWER_ERROR, e);

				} finally {
					if (null != employee) {
						employeeManager.free(employee);
						logger.traceInfo("Employee available: " + employee.toString());

					}
				}

			}
		});
	}

}
