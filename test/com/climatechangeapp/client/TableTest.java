package com.climatechangeapp.client;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TableTest {
	
	private int index = 0;

	@Test
	public void test() {

		ArrayList<Temperature> temperatures = new ArrayList<Temperature>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
			{	
			add(new Temperature("01.07.1980", "23°C", "3°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
			add(new Temperature("01.03.2003", "25°C", "8°C", "NewYork", "USA", "54.34N", "74.25W"));
			
			}
		};
		
		assertEquals(2, temperatures.size());
	
		
	}

}
