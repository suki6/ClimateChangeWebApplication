package com.climatechangeapp.client;



import com.google.gwt.core.client.EntryPoint;
/**
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
*/
	

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {
	
/**	
	private ClimateChangeServiceAsync climateChangeSvc = GWT.create(ClimateChangeService.class);
*/
	
	/**
	 * This is the entry point method
	 */

	public void onModuleLoad() {



//	    TemperatureList tempL;
//		AsyncCallback<Void> callback = null;
//		climateChangeSvc.dataReader(callback);



		WorldMap map = new WorldMap();
		
	    
    	TableFilter.initFilter();	    
		
		Table.initialize();
		
		

		
	}
		 
		
}



