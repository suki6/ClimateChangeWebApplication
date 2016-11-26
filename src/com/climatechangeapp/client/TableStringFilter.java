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
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.controls.filter.StringFilter;
import com.googlecode.gwt.charts.client.controls.filter.StringFilterOptions;
import com.googlecode.gwt.charts.client.table.TableOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;

	public class TableStringFilter {
		private Dashboard dashboard;
		private ChartWrapper<TableOptions> tableWrapper;
		private StringFilter stringFilter;
		
		private VerticalPanel vp = new VerticalPanel();
		
		private DockLayoutPanel RootLayoutPanel;

		public TableStringFilter() {
			initialize();
		}

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

		private void draw() {
			// Set control options
			StringFilterOptions stringFilterOptions = StringFilterOptions.create();
			stringFilterOptions.setFilterColumnIndex(0);
			stringFilterOptions.setFilterColumnIndex(1);
			stringFilterOptions.setFilterColumnIndex(2);
			stringFilterOptions.setFilterColumnIndex(3);
			stringFilterOptions.setFilterColumnIndex(4);
			stringFilterOptions.setFilterColumnIndex(5);
			stringFilter.setOptions(stringFilterOptions);

			DataTable dataTable = DataTable.create();
			
			dataTable.addColumn(ColumnType.STRING, "Datum");
			dataTable.addColumn(ColumnType.STRING, "Durchschnittliche Temperatur");
			dataTable.addColumn(ColumnType.STRING, "Temperaturunsicherheit");
			dataTable.addColumn(ColumnType.STRING, "Stadt");
			dataTable.addColumn(ColumnType.STRING, "Land");
			dataTable.addColumn(ColumnType.STRING, "Längengrad");
			dataTable.addColumn(ColumnType.STRING, "Breitengrad");
			
//			dataTable.addColumn(ColumnType.NUMBER, "Temperature");
		//	dataTable.addColumn(ColumnType.BOOLEAN, "Higher than last year");
			dataTable.addRows(1);
			dataTable.setCell(0, 0, "01.01.2013");

			
/**
			// Generate data
			JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['City', 'Temperature'],['Michael' , 12],['Elisa', 20],['Robert', 7],['John', 54],['Jessica', 22],['Aaron', 3],['Margareth', 42],['Miranda', 33]]");

			// Prepare the data
			DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);
**/
			// Draw the chart
			dashboard.bind(stringFilter, tableWrapper);
			dashboard.draw(dataTable);
		
			RootPanel.get().add(vp);
		}
	
		
}
