/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controller;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.Profile;

/**
 * Employee Manager Class
 *
 * @author ealtamar2
 */
public class EmployeeManager extends PriorityQueue<Employee> {

	private int operator;
	private int supervisor;
	private int director;
	private static final long serialVersionUID = -7743256027987200050L;

	public EmployeeManager(int operator, int supervisor, int director) {
		this.operator = operator;
		this.supervisor = supervisor;
		this.director = director;
		generateEmployee();
	}

	public EmployeeManager() {
	}

	/**
	 * Metodo para inicializar los recursos segun la cantidad establecida
	 */
	private void generateEmployee() {

		AtomicInteger employeeId = new AtomicInteger(0);

		if (operator > 0)
			IntStream.range(0, operator)
					.forEach(i -> this.add(new Employee(employeeId.incrementAndGet(), Profile.OPERATOR)));

		if (supervisor > 0)
			IntStream.range(0, supervisor)
					.forEach(i -> this.add(new Employee(employeeId.incrementAndGet(), Profile.SUPERVISOR)));

		if (director > 0)
			IntStream.range(0, director)
					.forEach(i -> this.add(new Employee(employeeId.incrementAndGet(), Profile.DIRECTOR)));

	}

	/**
	 * Metodo para obtener el proximo recurso disponible segun la prioridad
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Employee getAvailableEmployee() throws InterruptedException {
		return this.poll();
	}

	/**
	 * Una vez el recurso termine la llamada con este metodo se libera, para que
	 * quede disponible.
	 * 
	 * @param employee
	 */
	public void free(Employee employee) {
		this.add(employee);
	}

}
