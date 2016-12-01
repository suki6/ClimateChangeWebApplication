package com.climatechangeapp.client;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * This class stores the Temperature objects in list
 * 
 * @author suki
 *
 */
public class TemperatureList implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Temperature> temperature = new ArrayList<Temperature>();


	public TemperatureList() {
	}

	
	/**
	 * Adds a new Temperature to the TemperatureList
	 * @param addedTemperature The Temperature which will be added to the TemperatureList
	 */
	public void addTemperature(Temperature addedTemperature){
		temperature.add(addedTemperature);
	}
	
	/**
	 * Returns all Temperature objects of the TemperatureList 
	 * @return
	 */
	public ArrayList<Temperature> getTemperature() {
		return temperature;
	}


	public void setTemperature(ArrayList<Temperature> addedTemperature) {
		temperature = addedTemperature;
	}
 

	/**
	 * Returns the number of Temperatures objects in the TemperatureList
	 * @return int The size of the TemperatureList
	 */
	public int getTemperatureListSize() {
		return temperature.size();
	}


	public Temperature get(int i) {
		return temperature.get(i);
	}
	
	
}
