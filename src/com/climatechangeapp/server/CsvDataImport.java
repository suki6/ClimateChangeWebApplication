package com.climatechangeapp.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.climatechangeapp.client.Temperature;

//import com.google.api.server.spi.IoUtil;

public class CsvDataImport {
	
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
}

