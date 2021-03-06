package com.climatechangeapp.client;

import java.util.ArrayList;
import java.util.List;

import com.climatechangeapp.server.CsvConverter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;

public class CsvInArray {

	private static Table table;

	
	private static TextArea textArea = new TextArea();
	private static TextArea textArea1 = new TextArea();
	private static VerticalPanel vp = new VerticalPanel();
	private static CellTable ct = new CellTable();
	private static TemperatureList tempList;
	private static ArrayList<Temperature> test = new ArrayList<>();
	private static ArrayList<TestTemperatures> testList = new ArrayList<>();
	private static ArrayList<Temperature> temperaturesList = new ArrayList<>();

	public static ArrayList<Temperature> getTemperaturesList() {				//For Map; Johannes
		return temperaturesList;
	}
	
	private static Dashboard dashboard;

	// Splits up a String line and convert it to a Temperature object
	public static Temperature convertLine(String line) {
		
		String[] row = line.split(",");
		
		String date = row[0];
		String averageTemp = row[1];
		String averageTempUncertainty = row[2];
		String city = row[3];
		String country = row[4];
		String latitude = row[5];
		String longitude = row[6];
		 		
		return new Temperature(date, averageTemp, averageTempUncertainty, city, country, latitude, longitude);}
	
	//takes data from String ArrayList TestTemperatures and puts it into a TemperatureList
	public static TemperatureList changeList(ArrayList<TestTemperatures> testList)	{
		for (int i=0; i<testList.size(); i++) {
			tempList.addTemperature(convertLine(testList.get(i).gettestString()));;
		}
		return tempList;
	}
	
	public static void importData() {
//		textArea.setText("initialized");

		//HTTP Request call
		try {
			new RequestBuilder(RequestBuilder.GET, "GlobalLandTemperaturesByMajorCity_v1.txt").sendRequest("",
					new RequestCallback() {

						String arr[] = new String[228180];

						@Override
						public void onResponseReceived(Request req, Response resp) {
							String text = resp.getText();
							arr = text.split("\n");
							
							//printed in a textArea
							int counter = 0;
							for (String str : arr) {
								
								if (str.startsWith("2012") || (str.startsWith("2013"))) {
									
									textArea.setText(textArea.getText() + counter + " " + str + "\n");
									
									//String line saved in TestTemperatures and added to TestTemperatures Array<list
									TestTemperatures tt = new TestTemperatures(str);
								
									testList.add(tt);
									
//									String snip[] = new String [20000000];
//									snip = str.split(",");
//									for(s : snip){
//									}	
									
									
								//	textArea.setText(testList.get(0).gettestString());
									
									counter++;
									
								}							


							}
							
							String arr1[] = new String[228180000];
							
							for(int i=0; i<testList.size(); i++){
								String text1 = testList.get(i).gettestString();	
								arr1 = text1.split(",");
								Temperature myTemp = new Temperature(arr1[0], arr1[1], arr1[2], arr1[3], arr1[4], arr1[5], arr1[6]);
								temperaturesList.add(myTemp);
							}
							
						
//							ArrayList<Temperature> testTemp = new ArrayList<Temperature>(){
//								
//								private static final long serialVersionUID = 1L;
//								
//								{
//									
//									for(int i=0; i<temperaturesList.size(); i++){
//										add(new Temperature(temperaturesList.get(i).getDate(), temperaturesList.get(i).getAverageTemp(), temperaturesList.get(i).getAverageTempUncertainty(), temperaturesList.get(i).getCity(), temperaturesList.get(i).getCountry(), temperaturesList.get(i).getLongitude(), temperaturesList.get(i).getLatitude()));
//										
//									}
//									
//								}
//							};
//							
//							
//							// create Celltable and change default row settings		
//							int pageSize=228180;
//							CellTable<Temperature> cellTableOfTestTemperatures = new CellTable<Temperature>(pageSize);
//							
//							// Add a text columns to show the date.
//							TextColumn<Temperature> dateColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getDate();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(dateColumn, "Datum");
//							
//							// Add a text columns to show the avg temperature.
//							TextColumn<Temperature> avgTempColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getAverageTemp();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(avgTempColumn, "Durchschnittliche Temperatur");
//							
//							// Add a text columns to show the avg temperature uncertainty.
//							TextColumn<Temperature> avgTempUncertaintyColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getAverageTempUncertainty();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(avgTempUncertaintyColumn, "Durchschnittliche Temperaturunsicherheit");
//							
//							// Add a text columns to show the city.
//							TextColumn<Temperature> cityColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getCity();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(cityColumn, "Stadt");
//							
//							// Add a text columns to show the country.
//							TextColumn<Temperature> countryColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getCountry();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(countryColumn, "Land");
//							
//							// Add a text columns to show the latidude.
//							TextColumn<Temperature> latidudeColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getLongitude();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(latidudeColumn, "Längengrad");
//							
//							// Add a text columns to show the longitude.
//							TextColumn<Temperature> longitudeColumn = new TextColumn<Temperature>() {
//								public String getValue(Temperature object) {
//									return object.getLatitude();
//								}
//							};
//							cellTableOfTestTemperatures.addColumn(longitudeColumn, "Breitengrad");
//							
//							
//							vp.add(cellTableOfTestTemperatures);
//							
//							RootPanel.get("temperatureList").add(vp);
//							
//							cellTableOfTestTemperatures.setRowCount(testTemp.size(), true);
//							cellTableOfTestTemperatures.setRowData(0, testTemp);
//							cellTableOfTestTemperatures.setPageSize(testTemp.size());
//							//cellTableOfTestTemperatures.setVisibleRange(0, 228180);
//							
//							
//							cellTableOfTestTemperatures.setVisibleRange(0, 50);
//			//				cellTableOfTestTemperatures.setPageSize(15);
//							
//							SimplePager pager;
//
//						    // Create pager for page handling and set table as the display
//							// Create a Pager to control the table.
//						    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
//						    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
//						    pager.setDisplay(cellTableOfTestTemperatures);
//						    pager.setVisible(true);
//						    vp.add(pager);
		
						    
						}

						@Override
						public void onError(Request res, Throwable throwable) {
							// handle errors
						}
					});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	textArea.setText(testList.get(0).gettestString());

		
//		textArea.setText(textArea.getText() + "Yolo");
		
		textArea.setHeight("3px");
		textArea.setWidth("6px");
		vp.add(textArea);
		RootPanel.get("temperatureList").add(vp);
		
		changeList(testList);
		
	//	initialize();
	}

	public static ArrayList<Temperature> getTemperatures() {
		return test;
	}

	public int getTemperatureListSize() {
		return test.size();
	}
	
	public TemperatureList getTemperatureList()	{
		return tempList;
	}

//	public Temperature get(int i) {
//		return test.get(i);
//	}


	public static void initialize() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.TABLE);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				table = new Table();
				vp.add(table);
				draw();
			}
		});
	}

	public static void draw() {

		DataTable dataTable1 = DataTable.create();
		dataTable1.addColumn(ColumnType.STRING, "Datum");
		dataTable1.addColumn(ColumnType.STRING, "Durchschnittliche Temperatur");
		dataTable1.addColumn(ColumnType.STRING, "Durchschnittliche Temperaturunsicherheit");
		dataTable1.addColumn(ColumnType.STRING, "Stadt");
		dataTable1.addColumn(ColumnType.STRING, "Land");
		dataTable1.addColumn(ColumnType.STRING, "Längengrad");
		dataTable1.addColumn(ColumnType.STRING, "Breitengrad");

		dataTable1.addRows(temperaturesList.size());

		// Populate DataTable
		int i = 0;
		for (Temperature t : temperaturesList) {
			dataTable1.setValue(i, 0, temperaturesList.get(i).getDate());
			dataTable1.setValue(i, 1, temperaturesList.get(i).getAverageTemp());
			dataTable1.setValue(i, 2, temperaturesList.get(i).getAverageTempUncertainty());
			dataTable1.setValue(i, 3, temperaturesList.get(i).getCity());
			dataTable1.setValue(i, 4, temperaturesList.get(i).getCountry());
			dataTable1.setValue(i, 5, temperaturesList.get(i).getLongitude());
			dataTable1.setValue(i, 6, temperaturesList.get(i).getLatitude());
			i++;
		}

		// Table options
		TableOptions options = TableOptions.create();
		// Enable row numbering
		options.setShowRowNumber(true);
		// Enable paging to improve the performance of displaying large tables
		options.setAlternatingRowStyle(true);
		// Limit the number of displayed movies per page to 50
		options.setPageSize(50);

		
		// Draw the chart
		table.draw(dataTable1, options);

		RootPanel.get("temperatureList").add(vp);
	}

}
