package com.climatechangeapp.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SliderEntry {

    private Slider mapSlider;
    private Label mapSliderLabel;
    
    public SliderEntry() {
        // Create a slider with default behavior: minimum possible value of 1850, maximum possible value of 2013
        mapSliderLabel = new Label("1850");					
        mapSliderLabel.addStyleName("slider-values");			// Creates Values for CSS file, can be removed before release
        mapSlider = new Slider("slider");					
        RootPanel.get("mapTimeSlider").add(mapSliderLabel);		// Shows value for tests, has to be removed before release
        RootPanel.get("mapTimeSlider").add(mapSlider);
        mapSlider.addListener(this);
    }

    public void onChange(SliderEvent e) {
        //We don't need to do anything, because everything is done in onSlide in this example
    }

    public boolean onSlide(SliderEvent e) {
        mapSliderLabel.setText("" + e.getValue());
        return true;
    }

    public void onStart(SliderEvent e) {
        // We are not going to do anything onStart
    }

    public void onStop(SliderEvent e) {
        // We are not going to do anything onStop        
    }
}