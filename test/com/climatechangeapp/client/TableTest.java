package com.climatechangeapp.client;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TableTest {

	@Test
	public void test() {

		List<Temperature> temperatures = new ArrayList<Temperature>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
			{	
			add(new Temperature("01.07.1980", "23°C", "3°C", "Zurich", "Switzerland", "12.34N", "34.25W"));
		
			}
		};
		
	}

}
