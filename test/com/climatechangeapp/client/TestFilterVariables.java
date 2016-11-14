package com.climatechangeapp.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFilterVariables {

	@Test
	public void TestFilterVariables() {
		Temperature temperatures = new Temperature("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W");
		Temperature temperatures2 = new Temperature("15.05.2013", "-15°C", "3°C", "Stalingrad", "SovietRussia", "55.55N", "55.55W");
		Filter filter = new Filter("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W", temperatures);
		Filter filter2 = new Filter("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W", temperatures2);
		Filter filter3 = new Filter("2016", "1", "5", "New", "US", "12", "34", temperatures);
		
		assertEquals("20.07.2016", filter.filterDate());
		assertEquals("12°C",filter.filterAverageTemp());
		assertEquals("5°C", filter.filterAverageTempUncertainty());
		assertEquals("NewYork", filter.filterCity());
		assertEquals("USA", filter.filterCountry());
		assertEquals("12.34N", filter.filterLatitude());
		assertEquals("34.25W", filter.filterLongitude());
		
		assertEquals("",filter2.filterDate());
		assertEquals("",filter2.filterAverageTemp());
		assertEquals("",filter2.filterAverageTempUncertainty());
		assertEquals("",filter2.filterCity());
		assertEquals("",filter2.filterCountry());
		assertEquals("",filter2.filterLatitude());
		assertEquals("",filter2.filterLongitude());
		
		//Partial Inputs should return the data too
		assertEquals("20.07.2016", filter3.filterDate());
		assertEquals("12°C",filter3.filterAverageTemp());
		assertEquals("5°C", filter3.filterAverageTempUncertainty());
		assertEquals("NewYork", filter3.filterCity());
		assertEquals("USA", filter3.filterCountry());
		assertEquals("12.34N", filter3.filterLatitude());
		assertEquals("34.25W", filter3.filterLongitude());
		
		
		
	}

}
