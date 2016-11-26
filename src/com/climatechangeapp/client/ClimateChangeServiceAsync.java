package com.climatechangeapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClimateChangeServiceAsync {

	void dataReader(AsyncCallback<Void> callback);
	
	void getTemperature(AsyncCallback<TemperatureList> callback);

	void addTemperatrue(Temperature addedTemperature, AsyncCallback<Void> callback);



}
