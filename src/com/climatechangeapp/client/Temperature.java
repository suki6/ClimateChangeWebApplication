package com.climatechangeapp.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class defines the informations of the temperature 
 * 
 * @author suki
 *
 */
public class Temperature implements Serializable {
	
	
	private static final long serialVersionUID = -4242872550826180719L;
	private Date date;
	private Integer averageTemp;
	private Integer averageTempUncertainty;
	private ArrayList<String> city = new ArrayList <String>();
	private ArrayList<String> country = new ArrayList <String>();;
	private ArrayList<String> latitude = new ArrayList <String>();;
	private ArrayList<String> longitude = new ArrayList <String>();;
	
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
	public Temperature(Date date, Integer averageTemp, Integer averageTempUncertainty, ArrayList<String> city, ArrayList<String> country,	ArrayList<String> latitude,	ArrayList<String> longitude) {
		this.date = date;
		this.averageTemp = averageTemp;
		this.averageTempUncertainty = averageTempUncertainty;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	
	public Temperature(){
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public Integer getAverageTemp() {
		return averageTemp;
	}
	
	public Integer getAverageTempUncertainty() {
		return averageTempUncertainty;
	}
	
	public ArrayList<String> getCity() {
		return city;
	}

	public ArrayList<String> getCountry() {
		return country;
	}
	
	public ArrayList<String> getLongitude() {
		return longitude;
	}
	
	public ArrayList<String> getLatitude() {
		return latitude;
	}
	
	
}
