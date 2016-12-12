package com.climatechangeapp.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.Window;
	

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {
	
	

	/**
	 * This is the entry point method
	 */
	public void onModuleLoad() {

		WorldMap map = new WorldMap();
		
	//	TableVisualization tableV = new TableVisualization();
		
		
  //  	TableFilter.initFilter();	    
		
  //	Table.initialize();
 		
		CsvInArray.importData();
		
		CsvInArray.initialize();
//		CsvInArray.draw();
		
		TableStringFilter tbs = new TableStringFilter();

		//tbs.initialize();

		
		SliderEntry mapSlider = new SliderEntry();
	}
		 
	
}



