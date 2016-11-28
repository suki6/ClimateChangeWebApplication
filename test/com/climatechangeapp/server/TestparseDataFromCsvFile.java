package com.climatechangeapp.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestparseDataFromCsvFile {

	@Test
	public void test() {
		
		CsvDataImport csv = new CsvDataImport();
		
		assertNotNull(csv.parseDataFromCsvFile());
	}

}
