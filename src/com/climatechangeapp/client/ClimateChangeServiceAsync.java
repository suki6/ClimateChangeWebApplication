package com.climatechangeapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClimateChangeServiceAsync {
	
	void getTemperature(AsyncCallback<TemperatureList> callback);
	void addTemperature(Temperature addedTemperature, AsyncCallback<Void> callback);
	void parseDataFromCsvFile(AsyncCallback<TemperatureList> callback);


}
