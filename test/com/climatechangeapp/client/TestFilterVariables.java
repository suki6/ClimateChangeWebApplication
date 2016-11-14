package com.climatechangeapp.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFilterVariables {

	@Test
	public void testFilterVariables() {
		Temperature temperatures = new Temperature("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W");
		Temperature temperatures2 = new Temperature("15.05.2013", "-15°C", "3°C", "Stalingrad", "SovietRussia", "55.55N", "55.55W");
		Filter filter = new Filter("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W", temperatures);
		Filter filter2 = new Filter("20.07.2016", "12°C", "5°C", "NewYork", "USA", "12.34N", "34.25W", temperatures2);
		Filter filter3 = new Filter("2016", "1", "5", "New", "US", "12", "34", temperatures);
		
		assertEquals(temperatures, filter.filterDate());
		assertEquals(temperatures,filter.filterAverageTemp());
		assertEquals(temperatures, filter.filterAverageTempUncertainty());
		assertEquals(temperatures, filter.filterCity());
		assertEquals(temperatures, filter.filterCountry());
		assertEquals(temperatures, filter.filterLatitude());
		assertEquals(temperatures, filter.filterLongitude());
		
		assertEquals(null,filter2.filterDate());
		assertEquals(null,filter2.filterAverageTemp());
		assertEquals(null,filter2.filterAverageTempUncertainty());
		assertEquals(null,filter2.filterCity());
		assertEquals(null,filter2.filterCountry());
		assertEquals(null,filter2.filterLatitude());
		assertEquals(null,filter2.filterLongitude());
		
		//Partial Inputs should return the object too
		assertEquals(temperatures, filter3.filterDate());
		assertEquals(temperatures,filter3.filterAverageTemp());
		assertEquals(temperatures, filter3.filterAverageTempUncertainty());
		assertEquals(temperatures, filter3.filterCity());
		assertEquals(temperatures, filter3.filterCountry());
		assertEquals(temperatures, filter3.filterLatitude());
		assertEquals(temperatures, filter3.filterLongitude());
		
		
		
	}

}
