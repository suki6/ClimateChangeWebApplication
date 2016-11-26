package com.climatechangeapp.client;


import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.table.TableOptions;

public class TableVisualization {
	private TemperatureList tl;
	
	private Table table;
	
	private HorizontalPanel hp = new HorizontalPanel();


	public TableVisualization() {
		initialize();
	}

	private void initialize() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.TABLE);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				table = new Table();
				hp.add(table);
				draw();
			}
		});
	}

	private void draw() {

		// Prepare the data
		DataTable dataTable = DataTable.create();
		
		dataTable.addColumn(ColumnType.STRING, "Datum");
		dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperatur");
		dataTable.addColumn(ColumnType.STRING, "Temperaturunsicherheit");
		dataTable.addColumn(ColumnType.STRING, "Stadt");
		dataTable.addColumn(ColumnType.STRING, "Land");
		dataTable.addColumn(ColumnType.STRING, "Längengrad");
		dataTable.addColumn(ColumnType.STRING, "Breitengrad");
		
//		dataTable.addColumn(ColumnType.NUMBER, "Temperature");
	//	dataTable.addColumn(ColumnType.BOOLEAN, "Higher than last year");
		dataTable.addRows(1);
		dataTable.setCell(0, 0, "01.01.2013");

		
	//	dataTable.setCell(0, 0, tl.get(0).getDate());
	//	dataTable.setCell(0, 1, tl.get(0).getAverageTemp());
	//	dataTable.setCell(0, 2, "test");

		// Set options
		TableOptions options = TableOptions.create();
		options.setAlternatingRowStyle(true);
		options.setShowRowNumber(true);

		// Draw the chart
		table.draw(dataTable, options);
		
		RootPanel.get().add(hp);
	}
}