package com.climatechangeapp.client;

//import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.table.TableOptions;

public class TableV extends DockLayoutPanel {
	
	private Table tables;
	private FocusPanel tablePanel;
//	private TemperatureList temperature;
	
	public TableV() {
		super(Unit.PX);
		initialize();
	}

	private FocusPanel initialize() {
		tablePanel = new FocusPanel();
		
		ChartLoader chartLoader = new ChartLoader(ChartPackage.TABLE);
		chartLoader.loadApi(new Runnable() {
			
			@Override
			public void run() {
				tables = new Table();
				tablePanel.setWidget((IsWidget) tables);
				draw();
			}

		});
		
		return tablePanel;
	}
	

	private void draw() {
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Date");
		dataTable.addColumn(ColumnType.STRING, "Average Temperature");
		dataTable.addColumn(ColumnType.STRING, "Average Temperature Uncertainty");
		dataTable.addColumn(ColumnType.STRING, "City");
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.STRING, "Latitude");		
		dataTable.addColumn(ColumnType.STRING, "Longitude");
	/**	
		ArrayList<Temperature> temperatureList = temperature.getTemperature();
		dataTable.addRows(temperatureList.size());
		
	*/	
		
		// Set options
		TableOptions options = TableOptions.create();
		options.setAlternatingRowStyle(true);
		options.setShowRowNumber(true);

		// Draw the chart
		tables.draw(dataTable, options);
	}
	
}
