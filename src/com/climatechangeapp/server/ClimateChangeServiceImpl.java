package com.climatechangeapp.server;

import com.climatechangeapp.client.ClimateChangeService;
import com.climatechangeapp.client.Temperature;
import com.climatechangeapp.client.TemperatureList;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ClimateChangeServiceImpl extends RemoteServiceServlet implements ClimateChangeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1710368063913021854L;
	private java.io.BufferedReader fileReader;

	public TemperatureList parseDataFromCsvFile()
	{
		CsvDataImport csv = new CsvDataImport();
		return csv.parseDataFromCsvFile();
	}
	
	public TemperatureList getTemperature() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addTemperature(Temperature addedTemperature)
	{
		
	}
}
