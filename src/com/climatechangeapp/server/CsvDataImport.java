package com.climatechangeapp.server;

/**
 * This class imports the data from the csv file
 * @author Nithi
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.climatechangeapp.client.Temperature;
import com.climatechangeapp.client.TemperatureList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

//import com.google.api.server.spi.IoUtil;

public class CsvDataImport {
	
	public TemperatureList parseDataFromCsvFile()
	{
		TemperatureList tempList = new TemperatureList();
	     try{
	    	 Scanner scanner = new Scanner(new FileReader("/Users/Nithi/git/ClimateChangeWebApplication/GlobalLandTemperaturesByMajorCity_v1.csv"));
	    	 
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