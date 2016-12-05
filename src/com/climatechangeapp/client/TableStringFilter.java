package com.climatechangeapp.client;



import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ChartType;
import com.googlecode.gwt.charts.client.ChartWrapper;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.controls.filter.StringFilter;
import com.googlecode.gwt.charts.client.controls.filter.StringFilterOptions;
import com.googlecode.gwt.charts.client.options.MatchType;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;


/**
 * This class visualizes the string filter and the table in the frontend
 * @author suki
 *
 */
	public class TableStringFilter {
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
			

			// Generate data
			JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['Datum', 'Durchschnittliche Temperatur', 'Durchschnittliche Temperaturunsicherheit', 'Stadt', 'Land', 'LÃ¤ngengrad', 'Breitengrad'],"
						+ "['01.01.1970' , 23, 1, 'Berlin', 'Germany', '12.34N', '34.23W'],"
			+ "['01.01.1970', 23, 1, 'Berlin', 'Germany', '12.34N', '34.23W'],"
			+ "['01.09.2014', 12, 2, 'TEST', 'Switzerland', '12.34N', '34.25W'],"
			+ "['01.06.1989', 3, 1, 'TEST2', 'Switzerland', '12.34N', '34.25W'],"
			+ "['01.07.2010', 43, 1, 'NewYork', 'USA', '12.34N', '34.25W'],"
			+ "['01.07.1994', 1, 3, 'Sydney', 'Australia', '12.34N', '34.25W'],"
			+ "['01.07.2013', 12, 3, 'Tokyo', 'Japan', '12.34N', '34.25W'],"
			+ "['01.07.2002', 14, 3, 'Rio', 'Brazil', '12.34N', '34.25W'],"
			+ "['01.07.2000', 5, 3, 'Berlin', 'Germany', '12.34N', '34.25W'],"
			+ "['01.07.1985', 15, 3, 'Johannesburg', 'South Africa', '12.34N', '34.25W'],"
			+ "['01.07.2001', 6, 2, 'Moscow', 'Russia', '12.34N', '34.25W']]");
			
			
			
			// Prepare the data
			DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);

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
			RootPanel.get("newTableFilter47").add(longitudeFilter);
		}
	
		
}
