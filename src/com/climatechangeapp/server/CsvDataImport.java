package com.climatechangeapp.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.climatechangeapp.client.TemperatureList;

//import com.google.api.server.spi.IoUtil;

public class CsvDataImport {
	
	//reads csv file and each String line goes through method convertLine
	//method convertLine returns a Temperature object, which will be added to a TemperatureList
	public TemperatureList parseDataFromCsvFile()
	{
		TemperatureList tempList = new TemperatureList();
	     try{
	    	 Scanner scanner = new Scanner(new FileReader("/ClimateChangeApplication/src/com/climatechangeapp/server/GlobalLandTemperaturesByMajorCity_v1.csv"));
	    	 
	         while(scanner.hasNextLine())
	         {
	            String dataInRow=scanner.nextLine();
	            tempList.addTemperature(CsvConverter.convertLine(dataInRow));
	         }
	         scanner.close();
	     }catch (FileNotFoundException e){
	        e.printStackTrace();
	     }
	     return tempList;
	}
}