package com.climatechangeapp.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SliderEntry {

    private Slider timeSlider;
    private Label timeSliderLabel;
    static int year;
    
    public SliderEntry() {
        // Creates a slider with a minimum possible value of 1850 and a maximum possible value of 2013
        timeSliderLabel = new Label("2011");					
        timeSliderLabel.addStyleName("slider-values");			// Creates Values for CSS file, can be removed before release.
        timeSlider = new Slider("slider");					
        RootPanel.get("mapTimeSlider").add(timeSliderLabel);	// Shows the current year as a text.
        RootPanel.get("mapTimeSlider").add(timeSlider);
        timeSlider.addListener(this);
    }

    public void onChange(SliderEvent e) {
        //We don't need to do anything, because everything is done in onSlide in this example
    }

    public boolean onSlide(SliderEvent e) {
        timeSliderLabel.setText("" + e.getValue());
        year = e.getValue();
        return true;
    }

    public void onStart(SliderEvent e) {
        // We are not going to do anything onStart
    }

    public void onStop(SliderEvent e) {
        // We are not going to do anything onStop        
    }
    public int getYear() {
    	return year;										//getter for WorldMap
    }
}