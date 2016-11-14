package com.climatechangeapp.client;


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
	
	//Constructor may not be needed
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

	public void resetFilter() {
		date = "";
		averageTemp = "";
		averageTempUncertainty = "";
		city = "";
		country = "";
		latitude="";
		longitude="";
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		
	}
	
	public String filterDate(){
		if(data.getDate().contains(date)){ //Actually works!
			return data.getDate();}
		else return "";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String filterCountry(){
		if(data.getCountry().contains(country)){
			return data.getCountry();}
		else return "";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String filterCity(){
		if(data.getCity().contains(city)){
			return data.getCity();}
		else return "";
	}

	public String getAverageTemp() {
		return averageTemp;
	}

	public void setAverageTemp(String averageTemp) {
		this.averageTemp = averageTemp;
	}
	
	public String filterAverageTemp(){
		if(data.getAverageTemp().contains(averageTemp)){
			return data.getAverageTemp();}
		else return "";
	}

	public String getAverageTempUncertainty() {
		return averageTempUncertainty;
	}

	public void setAverageTempUncertainty(String averageTempUncertainty) {
		this.averageTempUncertainty = averageTempUncertainty;
	}
	
	public String filterAverageTempUncertainty(){
		if(data.getAverageTempUncertainty().contains(averageTempUncertainty)){
			return data.getAverageTempUncertainty();}
		else return "";
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String filterLatitude(){
		if(data.getLatitude().contains(latitude)){
			return data.getLatitude();}
		else return "";
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String filterLongitude(){
		if(data.getLongitude().contains(longitude)){
			return data.getLongitude();}
		else return "";
	}
	
	/* Used this for testing
	public static void main(String[] args) {
		Temperature temperatures = new Temperature("20.07.2016", "12°C.", "5°C", "NewYork", "USA", "12.34N", "34.25W");
		Filter filter = new Filter("20.07.2016", "12°C.", "5°C", "Manhattan", "USA", "12.34N", "34.25W", temperatures);
		System.out.println(filter.filterCountry());
		System.out.println(filter.filterCity());
	} */
}
