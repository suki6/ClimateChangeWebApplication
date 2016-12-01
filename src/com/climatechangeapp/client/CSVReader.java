package com.climatechangeapp.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	String csvFile = "/ClimateChangeApplication/war/GlobalLandTemperaturesByMajorCity_v1.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

	private Temperature temperature;
	private TemperatureList temperatureList;

	public CSVReader() {
		temperatureList = new TemperatureList();

	}

	public TemperatureList read(){
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null){
				String[] row = line.split(cvsSplitBy);
				
				String date = row[0];
				String averageTemp = row[1];
				String averageTempUncertainty = row[2];
				String city = row[3];
				String country = row[4];
				String latitude = row[5];
				String longitude = row[6];
				 		
				Temperature temperature = new Temperature(date, averageTemp, averageTempUncertainty, city, country, latitude, longitude);
				
				temperatureList.addTemperature(temperature);
			}
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
		
		return temperatureList;
	}
}
