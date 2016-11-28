package com.climatechangeapp.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsonUtils;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.util.ChartHelper;

public class TableStringFilterTest {

	@Test
	public void test() {
		
		JsArrayMixed dataArray = JsonUtils
				.unsafeEval("[['Datum', 'Durchschnittliche Temperatur', 'Durchschnittliche Temperaturunsicherheit', 'Stadt', 'Land', 'Längengrad', 'Breitengrad'],"
						+ "['01.01.1970' , 23, 1, 'Berlin', 'Germany', '12.34N', '34.23W'],"
			+ "['01.01.1970', 23, 1, 'Berlin', 'Germany', '12.34N', '34.23W'],"
			+ "['01.09.2014', 12, 2, 'TEST', 'Switzerland', '12.34N', '34.25W'],"
			+ "['01.06.1989', 3, 1, 'TEST2', 'Switzerland', '12.34N', '34.25W'],"
			+ "['01.07.2010', 43, 1, 'NewYork', 'USA', '12.34N', '34.25W'],"
			+ "['01.07.1994', 1, 3, 'Sydney', 'Australia', '12.34N', '34.25W'],"
			+ "['01.07.2013', 12, 3, 'Tokyo', 'Japan', '12.34N', '34.25W'],"
			+ "['01.07.2002', 14, 3, 'Rio', 'Brazil', '12.34N', '34.25W'],"
			+ "['01.07.2000', 5, 3, 'Berlin', 'Germany', '12.34N', '34.25W'],"
			+ "['01.07.1985', 15, 3, 'Johannesburg', 'South Africa', '12.34N', '34.25W'],"
			+ "['01.07.2001', 6, 2, 'Moscow', 'Russia', '12.34N', '34.25W']]");
		
	
	
	DataTable dataTable = ChartHelper.arrayToDataTable(dataArray);

	assertEquals(11, dataTable.getNumberOfRows());
	}

}
