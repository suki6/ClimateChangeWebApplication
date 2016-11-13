package com.climatechangeapp.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Class which handles the asynchronous callback from the server
 *
 * Need to react on server communication failure and success
 */
public class ClimateChangeCallback {

	  public void onFailure(Throwable caught) {
		  // handle failure from server.
		  Window.alert("Not able to process client reuest. Exception occured at server: " + caught);
  
	  }
  
  	 
	  public void onSuccess(String result) {
  
		  // handle the successful scenario.
		  Window.alert("Client request processed sucessfully. Result from server: " + result);
  
  	   }
  
}

