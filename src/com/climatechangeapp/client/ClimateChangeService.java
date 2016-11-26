package com.climatechangeapp.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tempData")
public interface ClimateChangeService extends RemoteService {
	TemperatureList getTemperature();
	void dataReader();
	void addTemperatrue(Temperature addedTemperature);
}
