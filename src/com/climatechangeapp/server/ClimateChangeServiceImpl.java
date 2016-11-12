package com.climatechangeapp.server;

import java.util.ArrayList;

import com.climatechangeapp.client.ClimateChangeService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ClimateChangeServiceImpl extends RemoteServiceServlet implements ClimateChangeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1710368063913021854L;

	@Override
	public ArrayList<ArrayList<String>> parseDataFromCsvFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
