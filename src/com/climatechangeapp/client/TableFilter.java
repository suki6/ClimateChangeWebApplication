package com.climatechangeapp.client;


import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class is the visualization of the table filter
 * @author suki
 *
 */

public class TableFilter {
	
	private static HorizontalPanel filterMenu = new HorizontalPanel();
	private static PopupPanel filterPop = new PopupPanel();
	private static Button filterButton = new Button("Filter");
	private static Button filterSubmit = new Button("Submit");
	private static VerticalPanel filterVer = new VerticalPanel();

	
	private static MultiWordSuggestOracle oracleDate = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleAverageTemp = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleAverageTempUncertainty = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleCity = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleCountry = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleLatitude = new MultiWordSuggestOracle();
	private static MultiWordSuggestOracle oracleLongitude = new MultiWordSuggestOracle();
	
	private static SuggestBox filterDate = new SuggestBox(oracleDate);
	private static SuggestBox filterAverageTemp = new SuggestBox(oracleAverageTemp);
	private static SuggestBox filterAverageTempUncertainty = new SuggestBox(oracleAverageTempUncertainty);
	private static SuggestBox filterCity = new SuggestBox(oracleCity);
	private static SuggestBox filterCountry = new SuggestBox(oracleCountry);
	private static SuggestBox filterLatitude = new SuggestBox(oracleLatitude);
	private static SuggestBox filterLongitude = new SuggestBox(oracleLongitude);
	
	private static TemperatureList temperatureList = new TemperatureList();
	private static ArrayList<Temperature> temperature = temperatureList.getTemperature();
	// private static ArrayList<String> input = new ArrayList<String>();
	private static Filter filter = new Filter();

	public static void initFilter() {

		
		
		filterMenu.setTitle("Search, filter or group by categories");
		filterDate.setSize("102px", "20px");
		filterAverageTemp.setSize("197px", "20px");
		filterAverageTempUncertainty.setSize("275px", "20px");
		filterCity.setSize("58px", "20px");
		filterCountry.setSize("90px", "20px");
		filterLatitude.setSize("90px", "20px");
		filterLongitude.setSize("72px", "20px");
		
		filterDate.getElement().setAttribute("placeholder", "   Datum");
		filterAverageTemp.getElement().setAttribute("placeholder", "Durchschnittliche Temperatur");
		filterAverageTempUncertainty.getElement().setAttribute("placeholder", "Durchschnittliche Temperaturunsicherheit");
		filterCity.getElement().setAttribute("placeholder", "Stadt");
		filterCountry.getElement().setAttribute("placeholder", "Land");
		filterLatitude.getElement().setAttribute("placeholder", "Längengrad");
		filterLongitude.getElement().setAttribute("placeholder", "Breitengrad");
		

		filterPop.setSize("600px", "200px");
		filterPop.setAutoHideEnabled(true);
		filterPop.hide();
		filterPop.setPopupPosition(5, 200);

		filterButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				filterPop.show();	
				filterSubmittedValues(); //Should filter the values on click
				// oracleYear.add("aaaaaa");
			}
		});
		
		
		filterSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				filter.resetFilter();
				filter.setDate(getFilterDate().getText());
				filter.setAverageTemp(getFilterAverageTemp().getText());
				filter.setAverageTempUncertainty(getFilterAverageTempUncertainty().getText());
				filter.setCity(getFilterCity().getText());
				filter.setCountry(getFilterCountry().getText());
				filter.setLatitude(getFilterLatitude().getText());
				filter.setLongitude(getFilterLongitude().getText());
				
				
			}
		});

		filterVer.add(filterMenu);
		filterMenu.add(getFilterDate());
		filterMenu.add(getFilterAverageTemp());
		filterMenu.add(getFilterAverageTempUncertainty());
		filterMenu.add(getFilterCity());
		filterMenu.add(getFilterCountry());
		filterMenu.add(getFilterLatitude());
		filterMenu.add(getFilterLongitude());
		filterMenu.add(filterSubmit);
		filterMenu.add(filterButton);
		
		RootPanel.get("temperatureList").add(filterVer);

	}
	

	public static TemperatureList filterSubmittedValues() {
		TemperatureList returnedTemperatures = new TemperatureList();
		for (int i=0;i<temperature.size();i++){
			filter.setTemperature(temperature.get(i));
			if (filter.filterDate() != null || filter.filterCity() != null || filter.filterCountry() != null || filter.filterAverageTemp() != null || filter.filterAverageTempUncertainty() != null || filter.filterLatitude() != null || filter.filterLongitude() != null){
					returnedTemperatures.addTemperature(temperature.get(i)); }
			
		}
		return returnedTemperatures;
	}

	public static SuggestBox getFilterDate() {
		return filterDate;
	}
	public static SuggestBox getFilterAverageTemp() {
		return filterAverageTemp;
	}

	public static SuggestBox getFilterAverageTempUncertainty() {
		return filterAverageTempUncertainty;
	}
	
	public static SuggestBox getFilterCity() {
		return filterCity;
	}
	
	public static SuggestBox getFilterCountry() {
		return filterCountry;
	}

	public static SuggestBox getFilterLatitude() {
		return filterLatitude;
	}
	public static SuggestBox getFilterLongitude() {
		return filterLongitude;
	}


}