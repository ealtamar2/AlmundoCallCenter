/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.model;

/**
 * Clase que modela el objecto de empleado, categorizado por un tipo para
 * establecer su prioridad
 *
 * @author ealtamar2
 */
public class Employee implements Comparable<Employee> {

	private int id;
	private Profile profile;

	public Employee(int id, Profile profile) {
		this.id = id;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public int compareTo(Employee o) {

		return this.getProfile().compareTo(o.getProfile());

	}

	@Override
	public String toString() {
		return this.id + "-" + this.profile + "";
	}

}
