package com.climatechangeapp.client;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TemperatureListTest {

	private TemperatureList tl;

	@Test
	public void test() {
		
		
		Temperature temp = new Temperature("data", "data", "data", "data", "data", "data", "data");
		Temperature temp2 = new Temperature("data", "data", "data", "data", "data", "data", "data");
		ArrayList<Temperature> temperature = new ArrayList<Temperature>();

		
		temperature.add(temp);
		temperature.add(temp2);
		
		assertNotNull(temperature);
		assertEquals(temp, temperature.get(0));
		assertEquals(temp2, temperature.get(1));
	
	}

}
