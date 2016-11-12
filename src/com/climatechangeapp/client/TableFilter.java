package com.climatechangeapp.client;


import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
	private static PopupPanel sysPan = new PopupPanel();
	private static Button sysBut = new Button("System out");
	private static VerticalPanel sysVP = new VerticalPanel();
	private static Label sysLab = new Label();
	private static Button filterBut = new Button("Filter");
	private static Button filterSub = new Button("Submit");
	private static VerticalPanel filterVer = new VerticalPanel();

	private String sysOut = "Start";	
	
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

	public static void initFilter() {

		
		
		filterMenu.setTitle("Search, filter or group by categories");
		filterDate.setSize("100px", "20px");
		filterAverageTemp.setSize("155px", "20px");
		filterAverageTempUncertainty.setSize("225px", "20px");
		filterCity.setSize("58px", "20px");
		filterCountry.setSize("90px", "20px");
		filterLatitude.setSize("70px", "20px");
		filterLongitude.setSize("72px", "20px");
		
		filterDate.getElement().setAttribute("placeholder", "   Date");
		filterAverageTemp.getElement().setAttribute("placeholder", "Average Temperature");
		filterAverageTempUncertainty.getElement().setAttribute("placeholder", "Average Temperature Uncertainty");
		filterCity.getElement().setAttribute("placeholder", "City");
		filterCountry.getElement().setAttribute("placeholder", "Country");
		filterLatitude.getElement().setAttribute("placeholder", "Latitude");
		filterLongitude.getElement().setAttribute("placeholder", "Longitude");
		

		filterPop.setSize("600px", "200px");
		filterPop.setAutoHideEnabled(true);
		filterPop.hide();
		filterPop.setPopupPosition(5, 200);

		filterBut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				filterPop.show();
				// oracleYear.add("aaaaaa");
			}
		});
		
		filterSub.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ArrayList<String> input = new ArrayList<String>();
				input.clear();
				input.add(getFilterDate().getText());
				input.add(getFilterAverageTemp().getText());
				input.add(getFilterAverageTempUncertainty().getText());
				input.add(getFilterCity().getText());
				input.add(getFilterCountry().getText());
				input.add(getFilterLatitude().getText());
				input.add(getFilterLongitude().getText());

		
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
		filterMenu.add(filterSub);


	
		RootPanel.get("temperatureList").add(filterVer);

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