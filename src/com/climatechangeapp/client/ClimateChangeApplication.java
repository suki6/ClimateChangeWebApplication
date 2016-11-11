package com.climatechangeapp.client;
/*
 * 
 *
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.climatechangeapp.server.CsvDataImport;
*/
//import com.climatechangeapp.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
/**	
 * import com.google.gwt.core.client.GWT;
	import com.google.gwt.event.dom.client.ClickEvent;
	import com.google.gwt.event.dom.client.ClickHandler;
	import com.google.gwt.event.dom.client.KeyCodes;
	import com.google.gwt.event.dom.client.KeyUpEvent;
	import com.google.gwt.event.dom.client.KeyUpHandler;
	
**/

//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {
	
	

	public void onModuleLoad() {

		TableFilter.initFilter();
		Table.initialize();

		
	}
		 
		
}
