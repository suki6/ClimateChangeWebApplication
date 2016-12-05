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
	public void parseDataFromCsvFile()	{
	
		ClimateChangeServiceAsync climateChangeSvc = GWT.create(ClimateChangeService.class);

	//	AsyncCallback callback = new AsyncCallback() {
		public void onSuccess(String result) {

			// handle the successful scenario.
			Window.alert("Client request processed sucessfully. Result from server: " + result);

	   }
		
		public void onFailure(Throwable caught) {
			// handle failure from server.
			Window.alert("Not able to process client reuest. Exception occured at server: " + caught);

		}
	};
	
	climateChangeSvc.parseDataFromCsvFile(callback);
	}
	**/
	
	/**
	 * This is the entry point method
	 */
	public void onModuleLoad() {

		WorldMap map = new WorldMap();
		
		
  //  	TableFilter.initFilter();	    
		
//		Table.initialize();
		
		TableStringFilter tbs = new TableStringFilter();

		//tbs.initialize();

		TimeLine timeLine = new TimeLine(1830, 2015, "1280", "60");
		
		TimeLineRangeFilter tlrf = new TimeLineRangeFilter();
		
		//SliderExample mapslider = new SliderExample();
	}
		 
	
}



