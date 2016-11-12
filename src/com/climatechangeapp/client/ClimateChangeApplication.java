package com.climatechangeapp.client;


import com.google.gwt.core.client.EntryPoint;

	

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {
	
	/**
	 * This is the entry point method
	 */
	public void onModuleLoad() {

		TableFilter.initFilter();
		
		Table.initialize();

		
	}
		 
		
}
