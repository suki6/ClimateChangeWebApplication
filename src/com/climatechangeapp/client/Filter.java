package com.climatechangeapp.client;

//import java.text.SimpleDateFormat;

public class Filter {
	//Filter arguments according to the csv file and user stories.
	private String dateInput;
	/* private Date timestamp = new Date;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); */
	private String country="";
	private String city="";
	private double averageTemperature=0;
	private double uncertainity=0;
	private String Latitude=""; //German: Breitengrad
	private String Longitude=""; //German: Längengrad
	
	public void resetFilter() {
		dateInput = "";
		country = "";
		city = "";
		averageTemperature = 0;
		uncertainity = 0;
		Latitude="";
		Longitude="";
}

	
	public String getDateInput() {
		return dateInput;
	}

	public void setDateInput(String dateInput) {
		this.dateInput = dateInput;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAverageTemperature() {
		return averageTemperature;
	}

	public void setAverageTemperature(double averageTemperature) {
		this.averageTemperature = averageTemperature;
	}

	public double getUncertainity() {
		return uncertainity;
	}

	public void setUncertainity(double uncertainity) {
		this.uncertainity = uncertainity;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	
	
	
}
