package com.climatechangeapp.client;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.table.TablePage;

/**
 * TableVisualization represents the content of the TemperatureList in a table
 * 
 * @author suki
 *
 */


public class TableVisualization extends DockLayoutPanel implements Visualization {

	private Table table;
	private Temperature temperature;
	private TemperatureList temperatureList;
	 
	public TableVisualization(TemperatureList temperatureList) {
		 super(Unit.PX);
		 this.temperatureList = temperatureList;
		 initialize();
	}
	 
	private void initialize() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.TABLE);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				table = new Table();
			//	getSimpleLayoutPanel().setWidget(table);
				draw();
			}
		});
	}
	
	/**
	 * Draws the table, adding the columns and rows of the table, and sets the value in the cell
	 */
		
	public void draw() {
		
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.DATE, "Date");
		dataTable.addColumn(ColumnType.NUMBER, "AverageTemperature");
		dataTable.addColumn(ColumnType.NUMBER, "AverageTemperatureUncertainty"); 
		dataTable.addColumn(ColumnType.STRING, "City");
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.STRING, "Latitude");
		dataTable.addColumn(ColumnType.STRING, "Longitude");
		
		ArrayList<Temperature> temperatureDataList = temperatureList.getTemperature();
		int numberOfRows = temperatureDataList.size();
		dataTable.addRows(numberOfRows);
		
		for(int i=0; i<numberOfRows; i++){
			dataTable.setCell(i, 0, temperature.getDate());
			dataTable.setCell(i, 1, temperature.getAverageTemp());
			dataTable.setCell(i, 2, temperature.getAverageTempUncertainty());
			dataTable.setCell(i, 3, temperature.getCity().toString());
			dataTable.setCell(i, 4, temperature.getCountry().toString());
			dataTable.setCell(i, 5, temperature.getLatitude().toString());
			dataTable.setCell(i, 6, temperature.getLongitude().toString());
				
		}
		
		// Set options
		TableOptions options = TableOptions.create();
		options.setAlternatingRowStyle(true);
		options.setShowRowNumber(true);
		options.setPage(TablePage.ENABLE);
		options.setPageSize(50);

		// Draw the chart
		table.draw(dataTable, options);
	 }
	
}
