package com.climatechangeapp.client;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TemperatureTest {

	@Test
	public void test() {
		Temperature temp = new Temperature("test", "test", "test", "test", "test", "test", "test");
		Temperature temp2 = new Temperature("test", "test", "test", "test", "test", "test", "test");
		ArrayList<Temperature> temperature1 = new ArrayList<Temperature>();
		
		temperature1.add(temp);
		temperature1.add(temp2);
		
		assertEquals(temp, temperature1.get(0));
		assertEquals(temp2, temperature1.get(1));
		
	}
	
	
}
