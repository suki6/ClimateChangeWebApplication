package com.climatechangeapp.client;



import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;

import com.google.gwt.user.client.ui.FlexTable;
//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ClimateChangeApplication implements EntryPoint {

	public void onModuleLoad() {
		
		
		FlexTable flextable = createFlexTable();

		CellTable<Temperature> cellTableOfTemperature = new CellTable<Temperature>();
		// policy that determines how keyboard selection will work
		cellTableOfTemperature.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		 // Add a text columns to show the details.

		TextColumn<Temperature> city = new TextColumn<Temperature>() {
			public String getValue(Temperature object) {
				return object.getCity();
			}
		};
		cellTableOfTemperature.addColumn(city, "City");
		
		VerticalPanel vp = new VerticalPanel();
		vp.setBorderWidth(1);
		vp.add(flextable);
		vp.add(cellTableOfTemperature);
		
		RootPanel.get("container").add(vp);
	
		List<Temperature> temperatures = new ArrayList<Temperature>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{	
			add(new Temperature("29.09.1980", 23, 3, "Zürich", "Switzerland", "12", "56.34W"));
			}
		};
		
		cellTableOfTemperature.setRowCount(temperatures.size(), true);
		cellTableOfTemperature.setRowData(0, temperatures);
		
	}

		
	private FlexTable createFlexTable() {
		FlexTable flexTable = new FlexTable();
		flexTable.setBorderWidth(1);
		flexTable.setText(0, 0, "TEST");
		flexTable.setText(2, 2, "TEST2");

		flexTable.getFlexCellFormatter().setColSpan(1, 0, 3);
		
		return flexTable;
	}
}
