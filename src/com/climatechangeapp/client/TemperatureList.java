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
	private ArrayList<Temperature> temperature = new ArrayList<Temperature>();


	public TemperatureList() {
		temperature = new ArrayList<Temperature>();
	}

	
	/*
	 * Adds temperature to TemperatureList
	 */
	public void addTemperature(Temperature addedTemperature){
		temperature.add(addedTemperature);
	}
	
	/*
	 * Returns all temperatures of TemperatureList 
	 */
	public ArrayList<Temperature> getTemperature() {
		return temperature;
	}
	
	public void setTemperature(ArrayList<Temperature> addedTemperature) {
		this.temperature = addedTemperature;
	}

	public void initTemperatureList(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
