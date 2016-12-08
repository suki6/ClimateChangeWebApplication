package com.climatechangeapp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.cellview.client.CellTable;
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
	private static ArrayList<TestTemperatures> testList = new ArrayList<TestTemperatures>();

	private static Dashboard dashboard;

	public static void importData() {

		try {
			new RequestBuilder(RequestBuilder.GET, "GlobalLandTemperaturesByMajorCity_v1.txt").sendRequest("",
					new RequestCallback() {

						String arr[] = new String[228180];

						@Override
						public void onResponseReceived(Request req, Response resp) {
							String text = resp.getText();
							arr = text.split("\n");
							for (String str : arr) {
								if (str.startsWith("1890"))
									textArea.setText(textArea.getText() + str + "\n");
									
									TestTemperatures tt = new TestTemperatures("str");
								
									testList.add(tt);
								
//									String temp[] = new String[20000];	
//									temp = str.split(",");
//
//								
//								
//								Temperature temperature = new Temperature(temp[0], temp[1], temp[2], temp[3], temp[4],
//										temp[5], temp[6]);
//								test.add(temperature);
//								tempList.addTemperature(temperature);

							}
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

		textArea.setHeight("300px");
		textArea.setWidth("600px");
		vp.add(textArea);
		vp.add(textArea1);
		RootPanel.get("temperatureList").add(vp);
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

	public static void initialize(){
		
		List<TestTemperatures> testTemp = new ArrayList<TestTemperatures>(){
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new TestTemperatures("ss"));
				add(new TestTemperatures(testList.get(0)));
			}
		};
		
		
		CellTable<TestTemperatures> cellTableOfTestTemperatures = new CellTable<TestTemperatures>();
		
		// Add a text columns to show the details.
		TextColumn<TestTemperatures> testStrings = new TextColumn<TestTemperatures>() {
			public String getValue(TestTemperatures object) {
				return object.gettestString();
			}
		};
		cellTableOfTestTemperatures.addColumn(testStrings, "Spalte 1");
		
		vp.add(cellTableOfTestTemperatures);
		
		RootPanel.get("temperatureList").add(vp);
		
		cellTableOfTestTemperatures.setRowCount(200, true);
		cellTableOfTestTemperatures.setRowData(2, testTemp);
	}
	
	public static void draw() {
		JsArrayMixed dataArray = JsonUtils.unsafeEval(
				"[test.get(0).getDate(), test.get(0).getAverageTemp(), test.get(0).getAverageTempUncertainty(), test.get(0).getCity(), test.get(0).getCountry(), test.get(0).getLatitude(), test.get(0).getLongitude()]");

		DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);

		dashboard.draw(dataTable);
		vp.add(dashboard);
		RootPanel.get("temperatureList").add(vp);
		
		
	}
}
