package com.climatechangeapp.client;

import java.util.ArrayList;

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
	private TemperatureList tempList;

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

		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Datum");
		dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperatur");
		dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperaturunsicherheit");
		dataTable.addColumn(ColumnType.STRING, "Stadt");
		dataTable.addColumn(ColumnType.STRING, "Land");
		dataTable.addColumn(ColumnType.STRING, "Längengrad");
		dataTable.addColumn(ColumnType.STRING, "Breitengrad");

		ArrayList<Temperature> temperatureList1 = tempList.getTemperature();
		dataTable.addRows(temperatureList1.size());

		// Populate DataTable
		int i = 0;
		for (Temperature t : temperatureList1) {
			dataTable.setValue(i, 0, t.getDate());
			dataTable.setValue(i, 1, t.getAverageTemp());
			dataTable.setValue(i, 2, t.getAverageTempUncertainty());
			dataTable.setValue(i, 3, t.getCity());
			dataTable.setValue(i, 4, t.getCountry());
			dataTable.setValue(i, 5, t.getLongitude());
			dataTable.setValue(i, 6, t.getLatitude());
			i++;
		}

		// Table options
		TableOptions options = TableOptions.create();
		// Enable row numbering
		options.setShowRowNumber(true);
		// Enable paging to improve the performance of displaying large tables
		options.setAlternatingRowStyle(true);
		// Limit the number of displayed movies per page to 100
		options.setPageSize(100);

		// Set options
		options.setAlternatingRowStyle(true);
		options.setShowRowNumber(true);

		// Draw the chart
		table.draw(dataTable, options);

		RootPanel.get("temperatureList").add(hp);
	}
}