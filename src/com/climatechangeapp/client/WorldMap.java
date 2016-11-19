package com.climatechangeapp.client;

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

	public WorldMap() {
	//	super(Unit.PX);
		initialize();
	}

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

	
	private void draw() {
		// Prepare the data
		DataTable dataTable = DataTable.create();
		dataTable.addColumn(ColumnType.STRING, "Country");
		dataTable.addColumn(ColumnType.NUMBER, "Popularity");
		dataTable.addRows(6);
		dataTable.setValue(0, 0, "Germany");
		dataTable.setValue(0, 1, 200);
		dataTable.setValue(1, 0, "United States");
		dataTable.setValue(1, 1, 300);
		dataTable.setValue(2, 0, "Brazil");
		dataTable.setValue(2, 1, 400);
		dataTable.setValue(3, 0, "Canada");
		dataTable.setValue(3, 1, 500);
		dataTable.setValue(4, 0, "France");
		dataTable.setValue(4, 1, 600);
		dataTable.setValue(5, 0, "RU");
		dataTable.setValue(5, 1, 700);

		// Set options
		GeoChartOptions options = GeoChartOptions.create();
		GeoChartColorAxis geoChartColorAxis = GeoChartColorAxis.create();
		options.setColorAxis(geoChartColorAxis);
		options.setDatalessRegionColor("gray");

		// Draw the chart
		geoChart.draw(dataTable, options);
		
		RootPanel.get().add(vp);
	}
}