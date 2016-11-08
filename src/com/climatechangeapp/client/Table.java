package com.climatechangeapp.client;


import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlexTable;

public class Table {
	
	FlexTable flexTable = createFlexTable();

	CellTable<Temperature> cellTableOfTemperature = new CellTable<Temperature>();
	
	TextColumn<Temperature> city = new TextColumn<Temperature>() {
		public String getValue(Temperature object) {
			return object.getCity();
		}
	};
	
	
	
	
	private FlexTable createFlexTable() {
		FlexTable flexTable = new FlexTable();
		flexTable.setBorderWidth(1);
		flexTable.setText(0, 0, "This is a test of flextable.");
		flexTable.getFlexCellFormatter().setColSpan(1, 0, 3);
		return flexTable;
	}
	
	

}
