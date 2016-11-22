package com.climatechangeapp.server;


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
	
	public static void parseDataFromCsvFile()
	{
	     //ArrayList<ArrayList<String>> dataFromFile = new ArrayList<ArrayList<String>>();
	     try{
	    	 Scanner scanner = new Scanner(new FileReader("/Users/suki/git/ClimateChangeWebApplication/war/GlobalLandTemperaturesByMajorCity_v1.csv"));
	    	 
	    	 //test commit and push
	    	 
	         while(scanner.hasNextLine())
	         {
	            String dataInRow=scanner.nextLine();
	            //String []dataInRowArray=dataInRow.split(",");
	            CsvConverter.convertLine(dataInRow);
	            //ArrayList<String> rowDataFromFile=new ArrayList<String>(Arrays.asList(dataInRowArray));
	            //dataFromFile.add(rowDataFromFile);
	         }
	         scanner.close();
	     }catch (FileNotFoundException e){
	        e.printStackTrace();
	     }
	     /*
	     for(ArrayList<String> row : dataFromFile)
	     {
	    	 for(String s : row)
	    	 {
	    		 temp = new Temperature(s, s, s, s, s, s, s);
	    	 }
	    	
	    	 TemperatureList.addTemperature(temp);
	     }
	     */
	}
}