package com.climatechangeapp.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

	

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {
	
	
	private ClimateChangeServiceAsync climateChangeSvc = GWT.create(ClimateChangeService.class);
	private ClimateChangeService CsvDataImport;
	
	
	/**
	 * This is the entry point method
	 */
	public void onModuleLoad() {
		
		if (climateChangeSvc == null) {
			climateChangeSvc = GWT.create(ClimateChangeService.class);
		    }

	     // Set up the callback object.
	    AsyncCallback<TemperatureList[]> callback = new AsyncCallback<TemperatureList[]>() {
	      public void onFailure(Throwable caught) {
	        // TODO: Do something with errors.
	      }

		@Override
		public void onSuccess(TemperatureList[] result) {
			// TODO Auto-generated method stub
			
		}	
	    };      
	    		
	    

		CsvDataImport.parseDataFromCsvFile();
		
		TableFilter.initFilter();
		
		Table.initialize();

		
	}
		 
		
}



