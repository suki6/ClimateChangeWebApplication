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

		public void dataReader(){
			try {
				fileReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("GlobalLandTemperaturesByMajorCity_v1.csv")));
			
				String row = "";
				fileReader.readLine();
				while(null!=(row=fileReader.readLine())){
					String[] split = row.split(",");
					System.out.println("split[i]");
					Temperature temperature = new Temperature(split[0], split[1], split[2], split [3], split[4], split[5], split[6]);
					
					TemperatureList tl = new TemperatureList();
					
					tl.addTemperature(temperature);
					
					
					
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

	public TemperatureList getTemperature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTemperatrue(Temperature addedTemperature) {
		
		TemperatureList tl = new TemperatureList();
		Temperature temperature = new Temperature("zürich", "2", "3", "sf", "3", "rt", "43e");
		tl.addTemperature(temperature);
	}

	
}
