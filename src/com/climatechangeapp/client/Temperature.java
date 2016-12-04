package com.climatechangeapp.client;

import java.util.ArrayList;
//import java.util.Date;

/**
 * This class defines the informations of the temperature 
 * 
 * @author suki
 *
 */
public class Temperature {
	
	private ArrayList<Temperature> temperature = new ArrayList<Temperature>();
	

	private String date;
	private String averageTemp;
	private String averageTempUncertainty;
	private String city;
	private String country;
	private String latitude;
	private String longitude; 
	
	/**
	 * Constructor of the class Temperature 
	 * @param date The date on which the temperature was measured in the format YYYY-MM-DD, DD is always 01
	 * @param averageTemp The average land temperature of a month as floating point number in degree celsius
	 * @param averageTempUncertainty The 95% confidence interval around the average in degrees celsius
	 * @param city The english name of city for which the temperature is given
	 * @param country The english name of country the city is located in
	 * @param latitude The geographical latitude in format ##.##[N|S]
	 * @param longitude The geographical longitude in format ##.##[W|E ]
	 */
	public Temperature(String date, String averageTemp, String averageTempUncertainty, String city, String country, String latitude, String longitude) {
		this.date = date;
		this.averageTemp = averageTemp;
		this.averageTempUncertainty = averageTempUncertainty;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	

	
	public Temperature() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Adds temperature to TemperatureList
	 */
	public void addTemperature(Temperature addedTemperature){
		temperature.add(addedTemperature);
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String getAverageTemp() {
		return averageTemp;
	}
	
	public String getAverageTempUncertainty() {
		return averageTempUncertainty;
	}
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	
}
