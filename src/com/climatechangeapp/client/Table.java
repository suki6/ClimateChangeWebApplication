package com.climatechangeapp.client;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Table {
	
	private static FlexTable flexTable = new FlexTable();
	private static VerticalPanel vp = new VerticalPanel();

	
	public static void initialize(){		
		

		

		flexTable.setBorderWidth(1);

	
		flexTable.getFlexCellFormatter().setColSpan(1, 0, 3);
		
	
		List<Temperature> temperatures = new ArrayList<Temperature>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
			{	
			add(new Temperature("01.07.1980", "23°C", "3°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
		/**	
			for(int i=0; i<temperatures.size(); i++) {
				
				add(new Temperature(temperatures.get(i).getDate(), temperatures.get(i).getAverageTemp(), temperatures.get(i).getAverageTempUncertainty(), temperatures.get(i).getCity(), temperatures.get(i).getCountry(), temperatures.get(i).getLatitude(), temperatures.get(i).getLongitude()));

			}
		*/	
			}
		};
		
		CellTable<Temperature> cellTableOfTemperature = new CellTable<Temperature>();
		// policy that determines how keyboard selection will work
		cellTableOfTemperature.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		
		TextColumn<Temperature> date = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getDate();
			}
		};
		cellTableOfTemperature.addColumn(date, "Date");
		
		TextColumn<Temperature> averageTemp = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getAverageTemp();
			}
		};
		cellTableOfTemperature.addColumn(averageTemp, "Average Temperature");
		
		TextColumn<Temperature> averageTempUncertainty = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getAverageTempUncertainty();
			}
		};
		cellTableOfTemperature.addColumn(averageTempUncertainty, "Average Temperature Uncertainty");
		
		
		
		 // Add a text columns to show the details.	
		TextColumn<Temperature> city = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getCity();
			}
		};
		cellTableOfTemperature.addColumn(city, "City");

		TextColumn<Temperature> country = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getCountry();
			}
		};
		cellTableOfTemperature.addColumn(country, "Country");
		
		TextColumn<Temperature> latitude = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getLatitude();
			}
		};
		cellTableOfTemperature.addColumn(latitude, "Latitude");
		
		TextColumn<Temperature> longitude = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getLongitude();
			}
		};
		cellTableOfTemperature.addColumn(longitude, "Longitude");
		
		vp.setBorderWidth(1);
		vp.add(flexTable);
		vp.add(cellTableOfTemperature);
		
		RootPanel.get("temperatureList").add(vp);
	

		
		cellTableOfTemperature.setRowCount(temperatures.size(), true);
		cellTableOfTemperature.setRowData(0, temperatures);
		
	

	
	}

}
