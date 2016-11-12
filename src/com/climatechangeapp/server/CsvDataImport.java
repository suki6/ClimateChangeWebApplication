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



//import com.google.api.server.spi.IoUtil;

public class CsvDataImport {
	
	public ArrayList<ArrayList<String>> parseDataFromCsvFile()
	{
	     ArrayList<ArrayList<String>> dataFromFile = new ArrayList<ArrayList<String>>();
	     try{
	    	 // scans csv file and breaks into different token, between "," 
	         Scanner scanner=new Scanner(new FileReader("/Users/Nithi/Desktop/Software Engineering"));
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
	    		 System.out.print(s + " | ");
	    	 }
	    	 System.out.println();
	     }
	     return dataFromFile;
	}
	
	/*
	public static List<Temperature> importCsv() throws IOException {
		List<Temperature> temperatures = new ArrayList<Temperature>();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/Users/suki/Documents/UZH/Wirtschaftsinformatik/Bachelorstufe/HS2016/Subjects/Major/Informatics/Software Engineering/Excercises/Übung 4/ClimateChangeApplication/src/com/climatechangeapp/server/CsvDataImport.java");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	//	String fileAsString = IOUtils.toString(fileInputStream, "UTF-8");
	//	FileInputStream fis = new FileInputStream("/ClimateChangeApplication/GlobalLandTemperaturesByMajorCity_v1.csv");
		Scanner scanner  = new Scanner(fis);
		
//				readFile("GlobalLandTemperaturesByMajorCity_v1.csv");
	
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Temperature temperature = CsvConverter.convertLine(line);
			temperatures.add(temperature);
			
		}
		
		scanner.close();
		
		return temperatures;
	}
	*/
}

