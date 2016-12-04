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
		private StringFilter stringFilter;
		
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
					vp.add(getStringFilter());
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

		private StringFilter getStringFilter() {
			if (stringFilter == null) {
				stringFilter = new StringFilter();
			}
			return stringFilter;
		}
		/**
		 * draws the data of the table
		 */
		private void draw() {
			// Set control options
			StringFilterOptions stringFilterOptions = StringFilterOptions.create();
			stringFilterOptions.setFilterColumnIndex(0);
			stringFilterOptions.setMatchType(MatchType.ANY);
			stringFilter.setOptions(stringFilterOptions);
			

			// Generate data
			JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['Datum', 'Durchschnittliche Temperatur', 'Durchschnittliche Temperaturunsicherheit', 'Stadt', 'Land', 'Längengrad', 'Breitengrad'],"
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
			dashboard.bind(stringFilter, tableWrapper);
			dashboard.draw(dataTable);
		
			RootPanel.get("newTable").add(vp);
			RootPanel.get("newTableFilter").add(stringFilter);
		}
	
		
}
