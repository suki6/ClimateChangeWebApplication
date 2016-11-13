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
	
	Temperature temp = new Temperature();
	
	public ArrayList<ArrayList<String>> parseDataFromCsvFile()
	{
	     ArrayList<ArrayList<String>> dataFromFile = new ArrayList<ArrayList<String>>();
	     try{
	    	 // scans csv file and breaks into different token, between "," 
	         Scanner scanner=new Scanner(new FileReader("/Users/suki/Documents/UZH/Wirtschaftsinformatik/Bachelorstufe/HS2016/Subjects/Major/Informatics/Software Engineering/Excercises/Übung 4/ClimateChangeApplication/src/com/climatechangeapp/server/GlobalLandTemperaturesByMajorCity_v1.csv"));
	         //scanner.useDelimiter(",");
	         
	         //token converted in String
	         //String line split between "," and saved in array list
	         while(scanner.hasNextLine())
	         {
	            String dataInRow=scanner.nextLine();
	            String []dataInRowArray=dataInRow.split(",");
	            ArrayList<String> rowDataFromFile=new ArrayList<String>(Arrays.asList(dataInRowArray));
	            dataFromFile.add(rowDataFromFile);
	         }
	         scanner.close();
	     }catch (FileNotFoundException e){
	        e.printStackTrace();
	     }
	     for(ArrayList<String> row : dataFromFile)
	     {
	    	 for(String s : row)
	    	 {
	    		 temp = new Temperature(s, s, s, s, s, s, s);
	    	 }
	    	
	    	 TemperatureList.addTemperature(temp);
	     }
	     return dataFromFile;
	}
	

}

