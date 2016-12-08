package com.climatechangeapp.client;

import java.util.ArrayList;
import java.util.List;

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
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.util.ChartHelper;

public class CsvInArray {

	private static TextArea textArea = new TextArea();
	private static TextArea textArea1 = new TextArea();
	private static VerticalPanel vp = new VerticalPanel();
	private static CellTable ct = new CellTable();
	private static TemperatureList tempList;
	private static ArrayList<Temperature> test = new ArrayList<Temperature>();
	private static ArrayList<TestTemperatures> testList = new ArrayList<>();

	
	private static Dashboard dashboard;

	private SimplePager pager;

	
	public static void importData() {
//		textArea.setText("initialized");

		try {
			new RequestBuilder(RequestBuilder.GET, "GlobalLandTemperaturesByMajorCity_v1.txt").sendRequest("",
					new RequestCallback() {

						String arr[] = new String[228180];

						@Override
						public void onResponseReceived(Request req, Response resp) {
							String text = resp.getText();
							arr = text.split("\n");
							
							
							
							int counter = 0;
							for (String str : arr) {
								
								if (str.startsWith("1890") || (str.startsWith("2013"))) {
									
									textArea.setText(textArea.getText() + counter + " " + str + "\n");
									
									TestTemperatures tt = new TestTemperatures(str);
								
									testList.add(tt);
									
								//	textArea.setText(testList.get(0).gettestString());
									
									counter++;
									
								}							


							}
							
									
							List<TestTemperatures> testTemp = new ArrayList<TestTemperatures>(){
								
								/**
								 * 
								 */
								private static final long serialVersionUID = 1L;

								{
									for(int i=0; i<testList.size(); i++){
										add(new TestTemperatures(testList.get(i).gettestString()));
									}
									
								}
							};
									
									
							CellTable<TestTemperatures> cellTableOfTestTemperatures = new CellTable<TestTemperatures>();
							
							// Add a text columns to show the details.
							TextColumn<TestTemperatures> testStrings = new TextColumn<TestTemperatures>() {
								public String getValue(TestTemperatures object) {
									return object.gettestString();
								}
							};
							cellTableOfTestTemperatures.addColumn(testStrings, "Datenimport: 'Datum', 'Durchschnittliche Temperatur', 'Durchschnittliche Temperaturunsicherheit', 'Stadt', 'Land', 'Längengrad', 'Breitengrad'");
							
							vp.add(cellTableOfTestTemperatures);
							
							RootPanel.get("temperatureList").add(vp);
							
							cellTableOfTestTemperatures.setRowCount(testTemp.size(), true);
							cellTableOfTestTemperatures.setRowData(0, testTemp);
							cellTableOfTestTemperatures.setPageSize(10);
							
							SimplePager pager;

							
						    // create pager for page handling and set table as the display
							// Create a Pager to control the table.
						    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
						    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
						    pager.setDisplay(cellTableOfTestTemperatures);
						    
						    
		
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
//		textArea.setText(textArea.getText() + "https://www.youtube.com/watch?v=z5Otla5157c");
		
		textArea.setHeight("3px");
		textArea.setWidth("6px");
		vp.add(textArea);
		RootPanel.get("temperatureList").add(vp);
		
	//	initialize();
	}

	public static ArrayList<Temperature> getTemperatures() {
		return test;
	}

	public int getTemperatureListSize() {
		return test.size();
	}

//	public Temperature get(int i) {
//		return test.get(i);
//	}


	
	public static void draw() {
		JsArrayMixed dataArray = JsonUtils.unsafeEval(
				"[test.get(0).getDate(), test.get(0).getAverageTemp(), test.get(0).getAverageTempUncertainty(), test.get(0).getCity(), test.get(0).getCountry(), test.get(0).getLatitude(), test.get(0).getLongitude()]");

		DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);

		dashboard.draw(dataTable);
		vp.add(dashboard);
		RootPanel.get("temperatureList").add(vp);
		
		
	}
}
