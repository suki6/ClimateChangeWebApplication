package com.climatechangeapp.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface ClimateChangeService extends RemoteService {
	ArrayList<ArrayList<String>> parseDataFromCsvFile();
}
