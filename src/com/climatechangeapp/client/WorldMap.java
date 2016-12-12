package com.climatechangeapp.client;

import java.util.ArrayList;

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
	
	private static SliderEntry sliderEntry;
	
	public static int actualYear = 2011;
	//private String aYear = temperaturesList.get(0).getDate(); 
	
	//private static ArrayList<Temperature> temperaturesList = new ArrayList<>();				//full Database
	private static ArrayList<Temperature> temperaturesList = CsvInArray.getTemperaturesList();		//full Database
	
	public static void sliderUpdate() {
		//method to update the map
		//actualYear = sliderEntry.getYear();			//Marked as comment cause of performance problems
	}

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
	
	private void valuesThisYear(DataTable dataTable) {
		int j = 50;
		for(int i = 0; i < temperaturesList.size(); i++) {						//TemperaturList = full database
		//for(int i = 0; i < 1000; i++) {												//TemperaturList in Test size
			String StringDate = temperaturesList.get(i).getDate();					//change string to int
			String StringYear = StringDate.substring(0, 3);
			int Year = Integer.parseInt(StringYear);
			System.out.println("" + Year);
			if(Year == actualYear) {												//If year = actualYear; row one must contain year only;
				dataTable.setValue(j, 0, temperaturesList.get(i).getCountry());		
				dataTable.setValue(j, 1, temperaturesList.get(i).getCity());		
				dataTable.setValue(j, 2, temperaturesList.get(i).getTemp());	//Problem: getAverageTemp() returns String instead of int or float.
				dataTable.setValue(j, 3, Year);
				j++;
			}
		}
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
		dataTable.addRows(1000);
		valuesThisYear(dataTable);
		
		dataTable.setValue(0, 0, "Cote D'Ivoire");
		dataTable.setValue(0, 1, "Abidjan");
		dataTable.setValue(0, 2, 27.01758);
		dataTable.setValue(0, 3, 2011);
		dataTable.setValue(1, 0, "Ethiopia");
		dataTable.setValue(1, 1, "Addis Abeba");
		dataTable.setValue(1, 2, 17.515);
		dataTable.setValue(1, 3, 2011);
		dataTable.setValue(2, 0, "India");
		dataTable.setValue(2, 1, "Ahmadabad");
		dataTable.setValue(2, 2, 26.59975);
		dataTable.setValue(2, 3, 2011);
		dataTable.setValue(3, 0, "Syria");
		dataTable.setValue(3, 1, "Aleppo");
		dataTable.setValue(3, 2, 18.01658);
		dataTable.setValue(3, 3, 2011);
		dataTable.setValue(4, 0, "Egypt");
		dataTable.setValue(4, 1, "Alexandria");
		dataTable.setValue(4, 2, 21.1815);
		dataTable.setValue(4, 3, 2011);
		dataTable.setValue(5, 0, "Turkey");
		dataTable.setValue(5, 1, "Ankara");
		dataTable.setValue(5, 2, 10.3897);
		dataTable.setValue(5, 3, 2011);
		dataTable.setValue(6, 0, "Iraq");
		dataTable.setValue(6, 1, "Baghdad");
		dataTable.setValue(6, 2, 20.9849);
		dataTable.setValue(6, 3, 2011);
		dataTable.setValue(7, 0, "Thailand");
		dataTable.setValue(7, 1, "Bangkok");
		dataTable.setValue(7, 2, 27.135);
		dataTable.setValue(7, 3, 2011);
		dataTable.setValue(8, 0, "Brazil");
		dataTable.setValue(8, 1, "Belo Horizonte");
		dataTable.setValue(8, 2, 20.70275);
		dataTable.setValue(8, 3, 2011);
		dataTable.setValue(9, 0, "Germany");
		dataTable.setValue(9, 1, "Berlin");
		dataTable.setValue(9, 2, 10.5564);
		dataTable.setValue(9, 3, 2011);
		dataTable.setValue(10, 0, "Colombia");
		dataTable.setValue(10, 1, "Bogota");
		dataTable.setValue(10, 2, 19.665);
		dataTable.setValue(10, 3, 2011);
		dataTable.setValue(11, 0, "Egypt");
		dataTable.setValue(11, 1, "Cairo");
		dataTable.setValue(11, 2, 20.77825);
		dataTable.setValue(11, 3, 2011);
		dataTable.setValue(12, 0, "South Africa");
		dataTable.setValue(12, 1, "Cape Town");
		dataTable.setValue(12, 2, 11.038);
		dataTable.setValue(12, 3, 2011);
		dataTable.setValue(13, 0, "Morocco");
		dataTable.setValue(13, 1, "Casablanca");
		dataTable.setValue(13, 2, 18.533);
		dataTable.setValue(13, 3, 2011);
		dataTable.setValue(14, 0, "China");
		dataTable.setValue(14, 1, "Chengdu");
		dataTable.setValue(14, 2, 11.07433333);
		dataTable.setValue(14, 3, 2011);
		dataTable.setValue(15, 0, "USA");
		dataTable.setValue(15, 1, "Chicago");
		dataTable.setValue(15, 2, 11.214);
		dataTable.setValue(15, 3, 2011);
		dataTable.setValue(16, 0, "Senegal");
		dataTable.setValue(16, 1, "Dakar");
		dataTable.setValue(16, 2, 25.411);
		dataTable.setValue(16, 3, 2011);		
		dataTable.setValue(17, 0, "Tanzania");
		dataTable.setValue(17, 1, "Dar Es Salaam");
		dataTable.setValue(17, 2, 26.5579);
		dataTable.setValue(17, 3, 2011);	
		dataTable.setValue(18, 0, "Pakistan");
		dataTable.setValue(18, 1, "Faisalabad");
		dataTable.setValue(18, 2, 24.97525);
		dataTable.setValue(18, 3, 2011);		
		dataTable.setValue(19, 0, "Zimbabwe");
		dataTable.setValue(19, 1, "Harare");
		dataTable.setValue(19, 2, 20.78175);
		dataTable.setValue(19, 3, 2011);	
		dataTable.setValue(20, 0, "Vietnam");
		dataTable.setValue(20, 1, "Ho Chi Minh City");
		dataTable.setValue(20, 2, 27.67541667);
		dataTable.setValue(20, 3, 2011);	
		dataTable.setValue(21, 0, "Nigeria");
		dataTable.setValue(21, 1, "Ibadan");
		dataTable.setValue(21, 2, 27.1323);
		dataTable.setValue(21, 3, 2011);	
		dataTable.setValue(22, 0, "Indonesia");
		dataTable.setValue(22, 1, "Jakarta");
		dataTable.setValue(22, 2, 25.2342);
		dataTable.setValue(22, 3, 2011);	
		dataTable.setValue(23, 0, "Saudi Arabia");
		dataTable.setValue(23, 1, "Jiddah");
		dataTable.setValue(23, 2, 29.3243);
		dataTable.setValue(23, 3, 2011);	
		dataTable.setValue(24, 0, "Afghanistan");
		dataTable.setValue(24, 1, "Kabul");
		dataTable.setValue(24, 2, 13.23423);
		dataTable.setValue(24, 3, 2011);	
		dataTable.setValue(25, 0, "Vietnam");
		dataTable.setValue(25, 1, "Ho Chi Minh City");
		dataTable.setValue(25, 2, 27.67541667);
		dataTable.setValue(25, 3, 2011);	
		dataTable.setValue(26, 0, "Ukraine");
		dataTable.setValue(26, 1, "Kiew");
		dataTable.setValue(26, 2, 4.2343);
		dataTable.setValue(26, 3, 2011);	
		dataTable.setValue(27, 0, "Congo");
		dataTable.setValue(27, 1, "Kinshasa");
		dataTable.setValue(27, 2, 25.23423);
		dataTable.setValue(27, 3, 2011);	
		dataTable.setValue(28, 0, "Peru");
		dataTable.setValue(28, 1, "Lima");
		dataTable.setValue(28, 2, 17.67547);
		dataTable.setValue(28, 3, 2011);	
		dataTable.setValue(29, 0, "United Kingdom");
		dataTable.setValue(29, 1, "London");
		dataTable.setValue(29, 2, 5.234234);
		dataTable.setValue(29, 3, 2011);	
		dataTable.setValue(30, 0, "Angola");
		dataTable.setValue(30, 1, "Luanda");
		dataTable.setValue(30, 2, 25.234234);
		dataTable.setValue(30, 3, 2011);	
		dataTable.setValue(31, 0, "Spain");
		dataTable.setValue(31, 1, "Madrid");
		dataTable.setValue(31, 2, 16.3243);
		dataTable.setValue(31, 3, 2011);
		dataTable.setValue(32, 0, "Phillipines");
		dataTable.setValue(32, 1, "Manila");
		dataTable.setValue(32, 2, 26.234234);
		dataTable.setValue(32, 3, 2011);
		dataTable.setValue(33, 0, "Iran");
		dataTable.setValue(33, 1, "Mashhad");
		dataTable.setValue(33, 2, 20.234234);
		dataTable.setValue(33, 3, 2011);
		dataTable.setValue(34, 0, "Australia");
		dataTable.setValue(34, 1, "Melbourne");
		dataTable.setValue(34, 2, 14.23213);
		dataTable.setValue(34, 3, 2011);
		dataTable.setValue(35, 0, "Mexico");
		dataTable.setValue(35, 1, "Mexico");
		dataTable.setValue(35, 2, 13.23423);
		dataTable.setValue(35, 3, 2011);
		dataTable.setValue(36, 0, "Somalia");
		dataTable.setValue(36, 1, "Mogadishu");
		dataTable.setValue(36, 2, 28.234234);
		dataTable.setValue(36, 3, 2011);
		dataTable.setValue(37, 0, "Canada");
		dataTable.setValue(37, 1, "Montreal");
		dataTable.setValue(37, 2, 6.5125);
		dataTable.setValue(37, 3, 2011);
		dataTable.setValue(38, 0, "Russia");
		dataTable.setValue(38, 1, "Moscow");
		dataTable.setValue(38, 2, 6.0092);
		dataTable.setValue(38, 3, 2011);
		dataTable.setValue(39, 0, "Japan");
		dataTable.setValue(39, 1, "Nagoya");
		dataTable.setValue(39, 2, 11.234234);
		dataTable.setValue(39, 3, 2011);
		dataTable.setValue(40, 0, "Kenya");
		dataTable.setValue(40, 1, "Nairobi");
		dataTable.setValue(40, 2, 18.234234);
		dataTable.setValue(40, 3, 2011);
		dataTable.setValue(41, 0, "France");
		dataTable.setValue(41, 1, "Paris");
		dataTable.setValue(41, 2, 8.234234);
		dataTable.setValue(41, 3, 2011);
		dataTable.setValue(42, 0, "Burma");
		dataTable.setValue(42, 1, "Rangoon");
		dataTable.setValue(42, 2, 28.234234);
		dataTable.setValue(42, 3, 2011);
		dataTable.setValue(43, 0, "Italy");
		dataTable.setValue(43, 1, "Rome");
		dataTable.setValue(43, 2, 18.234234);
		dataTable.setValue(43, 3, 2011);
		dataTable.setValue(44, 0, "Chile");
		dataTable.setValue(44, 1, "Santiago");
		dataTable.setValue(44, 2, 15.234234);
		dataTable.setValue(44, 3, 2011);
		dataTable.setValue(45, 0, "Dominican Republic");
		dataTable.setValue(45, 1, "Santo Domingo");
		dataTable.setValue(45, 2, 25.234234);
		dataTable.setValue(45, 3, 2011);
		dataTable.setValue(46, 0, "South Korea");
		dataTable.setValue(46, 1, "Seoul");
		dataTable.setValue(46, 2, 14.234234);
		dataTable.setValue(46, 3, 2011);
		dataTable.setValue(47, 0, "Singapore");
		dataTable.setValue(47, 1, "Singapore");
		dataTable.setValue(47, 2, 26.234234);
		dataTable.setValue(47, 3, 2011);
		dataTable.setValue(48, 0, "Taiwan");
		dataTable.setValue(48, 1, "Taipei");
		dataTable.setValue(48, 2, 22.234234);
		dataTable.setValue(48, 3, 2011);
		dataTable.setValue(49, 0, "Sudan");
		dataTable.setValue(49, 1, "Umm Durman");
		dataTable.setValue(49, 2, 28.234234);
		dataTable.setValue(49, 3, 2011);

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