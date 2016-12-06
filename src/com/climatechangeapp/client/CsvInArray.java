package com.climatechangeapp.client;

import java.util.ArrayList;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CsvInArray {

	private static TextArea textArea = new TextArea();
	private static VerticalPanel vp = new VerticalPanel();
	private static TemperatureList tempList;
	private static ArrayList<Temperature> test = new ArrayList<Temperature>();

	public static void test() {

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
								String temp[] = new String[7];
								temp = str.split(" ");

								Temperature temperature = new Temperature(temp[0], temp[1], temp[2], temp[3], temp[4],
										temp[5], temp[6]);
								test.add(temperature);
								// tempList.addTemperature(temperature);

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
		vp.add(textArea);
		RootPanel.get("temperatureList").add(vp);
	}

	public static ArrayList<Temperature> getTemperatures() {
		return test;
	}

	public int getTemperatureListSize() {
		return test.size();
	}

	public Temperature get(int i) {
		return test.get(i);
	}

}
