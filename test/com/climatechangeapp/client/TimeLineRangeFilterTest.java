package com.climatechangeapp.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.googlecode.gwt.charts.client.controls.filter.NumberRangeFilterOptions;

public class TimeLineRangeFilterTest {

	@Test
	public void test() {
		NumberRangeFilterOptions numberRangeFilterOptions = NumberRangeFilterOptions.create();
		numberRangeFilterOptions.setMinValue(1850);
		
		JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['City', 'Age'],['Zürich' , 1980],['Berlin', 2000],['Paris', 1970],['Toronto', 1954],['Sydney', 2002],['New York', 1903],['Rio', 1942],['Moscow', 1933]]");

		
	//	assertEquals();
	}

}
