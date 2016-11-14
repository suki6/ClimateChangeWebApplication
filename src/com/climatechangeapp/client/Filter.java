package com.climatechangeapp.client;

/**
 * This class provides the filter methods
 * @author Daniel Klaus
 *
 */

public class Filter {
	//Filter arguments according to the csv file and user stories.
	private String date= "";
	private String country="";
	private String city="";
	private String averageTemp="";
	private String averageTempUncertainty="";
	private String latitude=""; //German: Breitengrad
	private String longitude=""; //German: Längengrad
	private Temperature data = null; //Calling it data because it doesn't only contain temperatures
	
	//Constructor with all variables for convenient testing
	public Filter(String date, String averageTemp, String averageTempUncertainty, String city, String country, String latitude, String longitude, Temperature temperature){
		this.date = date;
		this.averageTemp = averageTemp;
		this.averageTempUncertainty = averageTempUncertainty;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.data = temperature;
	}
	
	//Constructor for no variables
	public Filter(){}
	
	//Constructor with only data provided
	public Filter(Temperature temperature) {
		data = temperature;
		
	}
	
	public void resetFilter() {
		date = "";
		averageTemp = "";
		averageTempUncertainty = "";
		city = "";
		country = "";
		latitude="";
		longitude="";
	}
	
	public void setTemperature (Temperature temp){
		data = temp;
	}
	
	public Temperature getTemperature (){
		return data;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		
	}
	
	/**
	 * Checks if date in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterDate(){
		if(data.getDate().contains(date)){ //Actually works!
			return data;}
		else return null;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Checks if country in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterCountry(){
		if(data.getCountry().contains(country)){
			return data;}
		else return null;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Checks if city in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterCity(){
		if(data.getCity().contains(city)){
			return data;}
		else return null;
	}

	public String getAverageTemp() {
		return averageTemp;
	}

	public void setAverageTemp(String averageTemp) {
		this.averageTemp = averageTemp;
	}
	
	/**
	 * Checks if averageTemp in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterAverageTemp(){
		if(data.getAverageTemp().contains(averageTemp)){
			return data;}
		else return null;
	}

	public String getAverageTempUncertainty() {
		return averageTempUncertainty;
	}

	public void setAverageTempUncertainty(String averageTempUncertainty) {
		this.averageTempUncertainty = averageTempUncertainty;
	}
	
	/**
	 * Checks if averageTempUncertainty in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterAverageTempUncertainty(){
		if(data.getAverageTempUncertainty().contains(averageTempUncertainty)){
			return data;}
		else return null;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Checks if latitude in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterLatitude(){
		if(data.getLatitude().contains(latitude)){
			return data;}
		else return null;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Checks if longitude in Temperature Object contains the input of the Filter
	 * @return Temperature or NULL 
	 */
	public Temperature filterLongitude(){
		if(data.getLongitude().contains(longitude)){
			return data;}
		else return null;
	}
	
}
