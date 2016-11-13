package com.climatechangeapp.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResetFilter {
	
	
	@Test
	public void testResetFilter() {
		Temperature temperatures = new Temperature("20.07.2016", "12°C.", "5°C", "NewYork", "USA", "12.34N", "34.25W");
		Filter filter = new Filter("20.07.2016", "12°C.", "5°C", "Manhattan", "USA", "12.34N", "34.25W", temperatures);
		
		filter.resetFilter();
		assertEquals("",filter.getDate());
		assertEquals("",filter.getAverageTemp());
		assertEquals("",filter.getAverageTempUncertainty());
		assertEquals("",filter.getCity());
		assertEquals("",filter.getCountry());
		assertEquals("",filter.getLatitude());
		assertEquals("",filter.getLongitude());
	}

}
