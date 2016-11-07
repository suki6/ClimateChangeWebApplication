package com.climatechangeapp.client;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * This class reads the temperature lists and clears the data
 * 
 * @author suki
 *
 */
public class TemperatureList implements Serializable {

	private static final long serialVersionUID = -5258406909930280750L;
	private ArrayList<Temperature> temperatures;
	
	public TemperatureList() {
		temperatures = new ArrayList<Temperature>();
	}
	
	/*
	 * Adds temperature to TemperatureList
	 */
	public void addTemperature(Temperature addedTemperature){
		temperatures.add(addedTemperature);
	}
	
	/*
	 * Returns all temperatures of TemperatureList 
	 */
	public ArrayList<Temperature> getTemperature() {
		return temperatures;
	}
	
	public void setTemperature(ArrayList<Temperature> addedTemperature) {
		this.temperatures = addedTemperature;
	}
	
	
}
