/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Modelo de objeto Llamada
 *
 * @author ealtamar2
 */
public class Call {

	private long id;
	private long duration;
	private int iteration;

	public Call(long id, int minDuration, int maxDuration) {
		this.id = id;
		setDuration(ThreadLocalRandom.current().nextInt(minDuration, maxDuration + 1));

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	@Override
	public String toString() {
		return "Call: " + getId() + ", Duration: " + getDuration() + " seg";
	}

}
