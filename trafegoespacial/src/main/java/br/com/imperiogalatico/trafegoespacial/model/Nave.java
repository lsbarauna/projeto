package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;

public class Nave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String model;
	public Integer passengers;
	 public String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
	
	
	
}
