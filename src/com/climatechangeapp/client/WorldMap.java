package com.climatechangeapp.client;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
import com.googlecode.gwt.charts.client.geochart.GeoChartColorAxis;
import com.googlecode.gwt.charts.client.geochart.GeoChartOptions;


/**
 * This class visualizes the data in a world map
 * 
 * @author suki
 *
 */
public class WorldMap {
	protected GeoChart geoChart;
	
	protected VerticalPanel vp = new VerticalPanel();

	protected DockLayoutPanel RootLayoutPanel;
	
	private SliderEntry sliderEntry;
	
	public int actualYear;

	

	public WorldMap() {
		initialize();
	}

	/**
	 * initializes the visualization of the worldmap
	 */
	protected void initialize() {
		ChartLoader chartLoader = new ChartLoader(ChartPackage.GEOCHART);
		chartLoader.loadApi(new Runnable() {

			@Override
			public void run() {
				// Create and attach the chart
				geoChart = new GeoChart();
				vp.add(geoChart);
	
				draw();
			}
		});
	}

	/**
	 * draws the worldmap with data of DataTable and marks them in the worldmap
	 */
	private void draw() {
//		actualYear = sliderEntry.getYear();
		
		// Prepare the data
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.STRING, "City");
		dataTable.addColumn(ColumnType.NUMBER, "Temperature");
		dataTable.addColumn(ColumnType.NUMBER, "Year");
		dataTable.addRows(7);
		dataTable.setValue(0, 0, "Germany");
		dataTable.setValue(0, 1, "Berlin");
		dataTable.setValue(0, 2, 12);
		dataTable.setValue(0, 3, 2004);
		dataTable.setValue(1, 0, "United States");
		dataTable.setValue(1, 1, "New York");
		dataTable.setValue(1, 2, 7);
		dataTable.setValue(1, 3, 2001);
		dataTable.setValue(2, 0, "Brazil");
		dataTable.setValue(2, 1, "Rio");
		dataTable.setValue(2, 2, 30);
		dataTable.setValue(2, 3, 1960);
		dataTable.setValue(3, 0, "Canada");
		dataTable.setValue(3, 1, "Toronto");
		dataTable.setValue(3, 2, -9);
		dataTable.setValue(3, 3, 1978);
		dataTable.setValue(4, 0, "France");
		dataTable.setValue(4, 1, "Paris");
		dataTable.setValue(4, 2, -2);
		dataTable.setValue(4, 3, 2010);
		dataTable.setValue(5, 0, "RU");
		dataTable.setValue(5, 1, "Moscow");
		dataTable.setValue(5, 2, -12);
		dataTable.setValue(5, 3, 1944);
		dataTable.setValue(6, 0, "Australia");
		dataTable.setValue(6, 1, "Sydney");
		dataTable.setValue(6, 2, 37);
		dataTable.setValue(6, 3, 1933);

		
		// Set options
		GeoChartOptions options = GeoChartOptions.create();
		GeoChartColorAxis geoChartColorAxis = GeoChartColorAxis.create();
		options.setColorAxis(geoChartColorAxis);
		options.setBackgroundColor("blue");
		options.setDatalessRegionColor("gray");
		options.setHeight(760);
		options.setWidth(1280);

		// Draw the chart
		geoChart.draw(dataTable, options);
		
		RootPanel.get("worldMap").add(vp);
	}
}