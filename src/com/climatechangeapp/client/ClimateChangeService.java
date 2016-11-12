package com.climatechangeapp.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ClimateChangeService extends RemoteService {
	ArrayList<ArrayList<String>> parseDataFromCsvFile();
}
