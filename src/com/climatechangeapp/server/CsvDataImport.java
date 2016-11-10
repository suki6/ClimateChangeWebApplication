package com.climatechangeapp.server;


import java.util.ArrayList;

//import com.climatechangeapp.client.TemperatureList;
import com.climatechangeapp.client.Temperature;


public class CsvDataImport {
//	private int minYear = 1800;
//	private int maxYear = 2016;

	
	private static ArrayList<Temperature> temp = new ArrayList<Temperature>();
	
	public static void dataReader(){
		try {
			@SuppressWarnings("resource")
			java.io.BufferedReader FileReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("GlobalLandTemperaturesByMajorCity_v1.csv")));
		
			String row = "";
			FileReader.readLine();
			while(null!=(row=FileReader.readLine())){
				String[] split=row.split(",");
				Temperature temperature = new Temperature(split[0], split[1], split[2], split [3], split[4], split[5], split[6]);
				temp.add(temperature);
			//	temperature1.addTemperature(temperature);
				
				//			if(this.isDataRelevant(temperatures)) {
					
	//			}
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	//	this.dataConcentrate();
	}

/**
	private void dataConcentrate() {
		// TODO Auto-generated method stub
		int index = 0;
		int divisor = 1;
		
	}
	

	private boolean isDataRelevant(Temperature temperatures) {
		// TODO Auto-generated method stub
		return false;
	}

	private String stringToInt(String string, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object stringToPosition(String string, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
*/
	
}
