package com.climatechangeapp.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClimateChangeServiceAsync {

	void parseDataFromCsvFile(AsyncCallback<ArrayList<ArrayList<String>>> callback);

}
