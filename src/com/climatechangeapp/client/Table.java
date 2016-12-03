package com.climatechangeapp.client;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Table {

	private static FlexTable flexTable = new FlexTable();
	private static VerticalPanel vp = new VerticalPanel();

	private static TemperatureList tl;


	

	/**
	 * Initializes the table and displays the content of TemperatureList
	 */
	public static void initialize(){		

		
		
		List<Temperature> temperatures = new ArrayList<Temperature>(){

			
			
			private static final long serialVersionUID = 1L;
	
			{	
				  try {
					
			            new RequestBuilder(RequestBuilder.GET, "GlobalLandTemperaturesByMajorCity_v1.csv").sendRequest("", new RequestCallback() {
			                String arr[] = new String[200];
			                @Override
			                public void onResponseReceived(Request req, Response resp) {
			                	String text = resp.getText();
			                    arr = text.split("\n");
			                    for(String str: arr) {
			                       String temp[] = str.split(",");
			                       add(new Temperature(temp[0], temp[1], temp[2],temp[3],temp[4],temp[5], temp[6]));
			   						
			   					
			                    }
			                }
			                
			                @Override
			                public void onError(Request res, Throwable throwable) {
			                    // handle errors
			                	add(new Temperature("01.07.1980", "23°C", "1°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
			                }
			            });
			        } catch (RequestException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			            add(new Temperature("01.07.1980", "23°C", "1°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
			        }

			
						
//						add(new Temperature("01.07.1980", "23°C", "1°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
//			add(new Temperature("01.09.2014", "12°C", "2°C", "TEST", "Switzerland", "12.34N", "34.25W"));
//			add(new Temperature("01.06.1989", "3°C", "1.4°C", "TEST2", "Switzerland", "12.34N", "34.25W"));
//			add(new Temperature("01.07.2010", "43°C", "1°C", "NewYork", "USA", "12.34N", "34.25W"));
//			add(new Temperature("01.07.1994", "1°C", ".3°C", "Sydney", "Australia", "12.34N", "34.25W"));
//			add(new Temperature("01.07.2013", "12°C", "0.3°C", "Tokyo", "Japan", "12.34N", "34.25W"));
//			add(new Temperature("01.07.2002", "14°C", "1.3°C", "Rio", "Brazil", "12.34N", "34.25W"));
//			add(new Temperature("01.07.2000", "5°C", "2.3°C", "Berlin", "Germany", "12.34N", "34.25W"));
//			add(new Temperature("01.07.1985", "15°C", "1.3°C", "Johannesburg", "South Africa", "12.34N", "34.25W"));
//			add(new Temperature("01.07.2001", "6°C", "3.2°C", "Moscow", "Russia", "12.34N", "34.25W"));
// 			add(new Temperature(tl.get(0).getDate(), tl.get(0).getAverageTemp(), tl.get(0).getAverageTempUncertainty(), tl.get(0).getCity(), tl.get(0).getCountry(), tl.get(0).getLatitude(), tl.get(0).getLongitude()));
			
			
//			CSVReader reader = new CSVReader();
//			tl = reader.read();
//			for(int i=0; i<tl.getTemperatureListSize(); i++) {
//				add(tl.get(i));
//			}
				
			
			/**
			CsvDataImport csv = new CsvDataImport();
			for(Temperature t : csv.parseDataFromCsvFile().getTemperature())
			{
				add(t);
			}
			*/
			
		/**
			for(int i=0; i<tl.getTemperatureListSize(); i++) {
				
				add(new Temperature(tl.getTemperature().get(i).getDate(), tl.getTemperature().get(i).getAverageTemp(), tl.getTemperature().get(i).getAverageTempUncertainty(), tl.getTemperature().get(i).getCity(), tl.getTemperature().get(i).getCountry(), tl.getTemperature().get(i).getLatitude(), tl.getTemperature().get(i).getLongitude()));

			}
		*/	
			}
		};
		
		
		
		CellTable<Temperature> cellTableOfTemperature = new CellTable<Temperature>();
		
		// policy that determines how keyboard selection will work
		cellTableOfTemperature.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a text columns to show the details.
		TextColumn<Temperature> date = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getDate();
			}
		};
		cellTableOfTemperature.addColumn(date, "Datum");
		
		TextColumn<Temperature> averageTemp = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getAverageTemp();
			}
		};
		cellTableOfTemperature.addColumn(averageTemp, "Durchschnittliche Temperatur");
		
		TextColumn<Temperature> averageTempUncertainty = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getAverageTempUncertainty();
			}
		};
		cellTableOfTemperature.addColumn(averageTempUncertainty, "Durchschnittliche Temperaturunsicherheit");
		
		
		
			
		TextColumn<Temperature> city = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getCity();
			}
		};
		cellTableOfTemperature.addColumn(city, "Stadt");

		TextColumn<Temperature> country = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getCountry();
			}
		};
		cellTableOfTemperature.addColumn(country, "Land");
		
		TextColumn<Temperature> latitude = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getLatitude();
			}
		};
		cellTableOfTemperature.addColumn(latitude, "Längengrad");
		
		TextColumn<Temperature> longitude = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getLongitude();
			}
		};
		cellTableOfTemperature.addColumn(longitude, "Breitengrad");
		


		vp.setBorderWidth(1);
		vp.add(flexTable);
		vp.add(cellTableOfTemperature);
		
		RootPanel.get("temperatureList").add(vp);
	

		
		cellTableOfTemperature.setRowCount(temperatures.size(), true);
		cellTableOfTemperature.setRowData(0, temperatures);
		
	

	
	}

}
