package com.climatechangeapp.client;



import java.util.ArrayList;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ChartType;
import com.googlecode.gwt.charts.client.ChartWrapper;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataRow;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.DataView;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.controls.filter.StringFilter;
import com.googlecode.gwt.charts.client.controls.filter.StringFilterOptions;
import com.googlecode.gwt.charts.client.options.MatchType;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.table.Table;
import com.googlecode.gwt.charts.client.util.ChartHelper;
import com.googlecode.gwt.charts.client.format.PatternFormat;


/**
 * This class visualizes the string filter and the table in the frontend
 * @author suki
 *
 */
	public class TableStringFilter {
		
		private CsvInArray csvTest;
		
		private TemperatureList tempList;
		
		private Dashboard dashboard;
		private ChartWrapper<TableOptions> tableWrapper;
		private StringFilter dateFilter;
		private StringFilter averageTempFilter;
		private StringFilter averageTempUncertaintyFilter;
		private StringFilter cityFilter;
		private StringFilter countryFilter;
		private StringFilter latitudeFilter;
		private StringFilter longitudeFilter;
		
		private VerticalPanel vp = new VerticalPanel();
		
		private DockLayoutPanel RootLayoutPanel;

		public TableStringFilter() {
			initialize();
		}
		
		/**
		 * initilazes the table and draws the table
		 */
		private void initialize() {
			ChartLoader chartLoader = new ChartLoader(ChartPackage.CONTROLS);
			chartLoader.loadApi(new Runnable() {

				@Override
				public void run() {
					dashboard = new Dashboard();
					vp.add(dashboard);
					vp.add(getDashboardWidget());
					vp.add(getDateFilter());
					vp.add(getAverageTempFilter());
					vp.add(getAverageTempUncertaintyFilter());
					vp.add(getCityFilter());
					vp.add(getCountryFilter());
					vp.add(getLatitudeFilter());
					vp.add(getLongitudeFilter());
					vp.add(getTableWrapper());
					
					draw();
				}
			});
		}

		private Dashboard getDashboardWidget() {
			if (dashboard == null) {
				dashboard = new Dashboard();
			}
			return dashboard;
		}

		private ChartWrapper<TableOptions> getTableWrapper() {
			if (tableWrapper == null) {
				tableWrapper = new ChartWrapper<TableOptions>();
				tableWrapper.setChartType(ChartType.TABLE);
			}
			return tableWrapper;
		}
		
		private StringFilter getDateFilter() {
			if (dateFilter == null) {
				dateFilter = new StringFilter();
			}
			return dateFilter;
		}
		
		private StringFilter getAverageTempFilter() {
			if (averageTempFilter == null) {
				averageTempFilter = new StringFilter();
			}
			return averageTempFilter;
		}
		
		private StringFilter getAverageTempUncertaintyFilter() {
			if (averageTempUncertaintyFilter == null) {
				averageTempUncertaintyFilter = new StringFilter();
			}
			return averageTempUncertaintyFilter;
		}
		
		private StringFilter getCityFilter() {
			if (cityFilter == null) {
				cityFilter = new StringFilter();
			}
			return cityFilter;
		}
		
		private StringFilter getCountryFilter() {
			if (countryFilter == null) {
				countryFilter = new StringFilter();
			}
			return countryFilter;
		}
		
		private StringFilter getLatitudeFilter() {
			if (latitudeFilter == null) {
				latitudeFilter = new StringFilter();
			}
			return latitudeFilter;
		}
		
		private StringFilter getLongitudeFilter() {
			if (longitudeFilter == null) {
				longitudeFilter = new StringFilter();
			}
			return longitudeFilter;
		}
		/**
		 * draws the data of the table
		 */
		private void draw() {
			// Set control options
			StringFilterOptions stringFilterOptions0 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions1 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions2 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions3 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions4 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions5 = StringFilterOptions.create();
			StringFilterOptions stringFilterOptions6 = StringFilterOptions.create();
			
			stringFilterOptions0.setFilterColumnIndex(0);
			stringFilterOptions1.setFilterColumnIndex(1);
			stringFilterOptions2.setFilterColumnIndex(2);
			stringFilterOptions3.setFilterColumnIndex(3);
			stringFilterOptions4.setFilterColumnIndex(4);
			stringFilterOptions5.setFilterColumnIndex(5);
			stringFilterOptions6.setFilterColumnIndex(6);
			
			stringFilterOptions0.setMatchType(MatchType.ANY);
			stringFilterOptions1.setMatchType(MatchType.ANY);
			stringFilterOptions2.setMatchType(MatchType.ANY);
			stringFilterOptions3.setMatchType(MatchType.ANY);
			stringFilterOptions4.setMatchType(MatchType.ANY);
			stringFilterOptions5.setMatchType(MatchType.ANY);
			stringFilterOptions6.setMatchType(MatchType.ANY);
			
			dateFilter.setOptions(stringFilterOptions0);
			averageTempFilter.setOptions(stringFilterOptions1);
			averageTempUncertaintyFilter.setOptions(stringFilterOptions2);
			cityFilter.setOptions(stringFilterOptions3);
			countryFilter.setOptions(stringFilterOptions4);
			latitudeFilter.setOptions(stringFilterOptions5);
			longitudeFilter.setOptions(stringFilterOptions6);
			
//			ArrayList testList = new ArrayList<>();
//			testList = csvTest.getTemperatures();
			
			
			// Generate data
			JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['Datum', 'Durchschnittliche Temperatur', 'Durchschnittliche Temperaturunsicherheit', 'Stadt', 'Land', 'Längengrad', 'Breitengrad'],"

			+ "['2012-01-01', 27.697, 0.329, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-02-01', 28.887, 0.213, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-03-01', 28.025, 0.395, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-04-01', 27.056, 0.347, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-05-01', 24.989, 0.461, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-06-01', 24.657, 0.321, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-07-01', 24.989, 0.461, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-08-01', 24.657, 0.321, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-09-01', 25.793, 0.401, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-10-01', 26.511, 1.526, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-11-01', 27.386, 0.394, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"
			+ "['2012-12-01', 26.777, 0.528, 'Abidjan' ,'Côte D Ivoire', '5.63N', '3.23W'],"

			
//			2013-01-01,27.751,0.856,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-02-01,29.021,0.467,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-03-01,29.129,0.306,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-04-01,28.626,0.219,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-05-01,27.652,0.16,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-06-01,26.157,0.245,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-07-01,24.951,0.221,Abidjan,Côte D'Ivoire,5.63N,3.23W
//			2013-08-01,24.541,0.372,Abidjan,Côte D'Ivoire,5.63N,3.23W
			+ "['2013-01-01', 27.751, 0.856, 'Abidjan', 'Côte D Ivoire', '5.63N', '3.23W']]");
			
			
			
			// Prepare the data
			DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);
			
//			DataTable dataTable = DataTable.create();
//			dataTable.addColumn(ColumnType.STRING, "Datum");
//			dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperatur");
//			dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperaturunsicherheit");
//			dataTable.addColumn(ColumnType.STRING, "Stadt");
//			dataTable.addColumn(ColumnType.STRING, "Land");
//			dataTable.addColumn(ColumnType.STRING, "Längengrad");
//			dataTable.addColumn(ColumnType.STRING, "Breitengrad");
//			
//			ArrayList<Temperature> temperatureList1 = tempList.getTemperature();
//			dataTable.addRows(temperatureList1.size());
//			
//			// Populate DataTable
//			int i = 0;
//			for (Temperature t : temperatureList1) {
//				dataTable.setValue(i, 0, t.getDate());
//				dataTable.setValue(i, 1, t.getAverageTemp());
//				dataTable.setValue(i, 2, t.getAverageTempUncertainty());
//				dataTable.setValue(i, 3, t.getCity());
//				dataTable.setValue(i, 4, t.getCountry());
//				dataTable.setValue(i, 5, t.getLongitude());
//				dataTable.setValue(i, 6, t.getLatitude());
//				i++;
//			}
//
//			// Table options
//			TableOptions options = TableOptions.create();
//			// Enable row numbering
//			options.setShowRowNumber(true);
//			// Enable paging to improve the performance of displaying large tables
//			options.setAlternatingRowStyle(true);
//			// Limit the number of displayed movies per page to 100
//			options.setPageSize(100);

						
			// Draw the chart
			dashboard.bind(dateFilter, tableWrapper);
			dashboard.bind(averageTempFilter, tableWrapper);
			dashboard.bind(averageTempUncertaintyFilter, tableWrapper);
			dashboard.bind(cityFilter, tableWrapper);
			dashboard.bind(countryFilter, tableWrapper);
			dashboard.bind(latitudeFilter, tableWrapper);
			dashboard.bind(longitudeFilter, tableWrapper);
			dashboard.draw(dataTable);
		
			RootPanel.get("newTable").add(vp);
			RootPanel.get("newTableFilter1").add(dateFilter);
			RootPanel.get("newTableFilter2").add(averageTempFilter);
			RootPanel.get("newTableFilter3").add(averageTempUncertaintyFilter);
			RootPanel.get("newTableFilter4").add(cityFilter);
			RootPanel.get("newTableFilter5").add(countryFilter);
			RootPanel.get("newTableFilter6").add(latitudeFilter);
			RootPanel.get("newTableFilter7").add(longitudeFilter);
		}
	
		
}
