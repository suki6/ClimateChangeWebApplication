package com.climatechangeapp.client;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ChartType;
import com.googlecode.gwt.charts.client.ChartWrapper;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.controls.Dashboard;
import com.googlecode.gwt.charts.client.controls.filter.NumberRangeFilter;
import com.googlecode.gwt.charts.client.controls.filter.NumberRangeFilterOptions;
import com.googlecode.gwt.charts.client.corechart.BarChartOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;;

/**
 * This class visualizes the timeline and the range filter
 * @author suki
 *
 */
public class TimeLineRangeFilter {
	
	private Dashboard dashboard;
	private ChartWrapper<BarChartOptions> barChartWrapper;
	private NumberRangeFilter numberRangeFilter;
	
	private VerticalPanel vp = new VerticalPanel();
	
	public TimeLineRangeFilter() {
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
				vp.add(getNumberRangeFilter());
				vp.add(getBarChartWrapper());
				
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

	private ChartWrapper<BarChartOptions> getBarChartWrapper() {
		if (barChartWrapper == null) {
			barChartWrapper = new ChartWrapper<BarChartOptions>();
			barChartWrapper.setChartType(ChartType.BAR);
		}
		return barChartWrapper;
	}

	private NumberRangeFilter getNumberRangeFilter() {
		if (numberRangeFilter == null) {
			numberRangeFilter = new NumberRangeFilter();
		}
		return numberRangeFilter;
	}
	
	/**
	 * draws the range filter with content of dataArray
	 */
	private void draw() {
		// Set control options
		NumberRangeFilterOptions numberRangeFilterOptions = NumberRangeFilterOptions.create();
		numberRangeFilterOptions.setFilterColumnLabel("Age");
		numberRangeFilterOptions.setMinValue(1850);
		numberRangeFilterOptions.setMaxValue(2013);
		numberRangeFilter.setOptions(numberRangeFilterOptions);

		// Set chart options
		BarChartOptions barChartOptions = BarChartOptions.create();
		barChartWrapper.setOptions(barChartOptions);

		// Generate data
		JsArrayMixed dataArray = JsonUtils
			.unsafeEval("[['City', 'Age'],['Zürich' , 1980],['Berlin', 2000],['Paris', 1970],['Toronto', 1954],['Sydney', 2002],['New York', 1903],['Rio', 1942],['Moscow', 1933]]");

		// Prepare the data
		DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);

		// Draw the chart
		dashboard.bind(numberRangeFilter, barChartWrapper);
		dashboard.draw(dataTable);
		
		RootPanel.get().add(vp);
	}
}
