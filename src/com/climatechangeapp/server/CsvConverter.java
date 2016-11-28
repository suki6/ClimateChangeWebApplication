package com.climatechangeapp.server;

import java.util.ArrayList;

import com.climatechangeapp.client.Temperature;
import com.climatechangeapp.client.TemperatureList;
/**
 * 
 * @author suki
 *
 */
public class CsvConverter {

	//String line gets split up with seperator "," and the string values will be assigned to a String array
	//Those String arrays will be summarized (each line) in the Temperature object
	public static Temperature convertLine(String line) {
		// TODO Auto-generated method stub
		String[] row = line.split(",");
		
		String date = row[0];
		String averageTemp = row[1];
		String averageTempUncertainty = row[2];
		String city = row[3];
		String country = row[4];
		String latitude = row[5];
		String longitude = row[6];
		 		
		return new Temperature(date, averageTemp, averageTempUncertainty, city, country, latitude, longitude);
		
		
	
	}

}
