package com.climatechangeapp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class TestTable {
	
	private TestTemperatures tt;
	
	public static void initialize(){
		
		List<TestTemperatures> testTemp = new ArrayList<TestTemperatures>(){
			
//			{
//				add(new TestTemperatures(tt.get(0)));
//			}
		};
		
		
		CellTable<TestTemperatures> cellTableOfTestTemperatures = new CellTable<TestTemperatures>();
		
		// Add a text columns to show the details.
		TextColumn<TestTemperatures> testStrings = new TextColumn<TestTemperatures>() {
			public String getValue(TestTemperatures object) {
				return object.gettestString();
			}
		};
		cellTableOfTestTemperatures.addColumn(testStrings, "Datum");
	}
	
}
