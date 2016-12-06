package com.climatechangeapp.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SliderEntry {

    private Slider m_slider;
    private Label m_sliderLabel;
    
    // This is the entry point method.
    public SliderEntry() {
        // Create a slider with default behavior: minimum possible value of 1850, maximum possible value of 2013
        m_sliderLabel = new Label("1850");					
        m_sliderLabel.addStyleName("slider-values");		// Creates Values for CSS file
        m_slider = new Slider("slider");					
        RootPanel.get("mapTimeSlider").add(m_sliderLabel);	// Shows value for tests, has to be removed before release
        RootPanel.get("mapTimeSlider").add(m_slider);
        m_slider.addListener(this);
    }

    public void onChange(SliderEvent e) {
        //We don't need to do anything, because everything is done in onSlide in this example
    }

    public boolean onSlide(SliderEvent e) {
        m_sliderLabel.setText("" + e.getValue());
        return true;
    }

    public void onStart(SliderEvent e) {
        // We are not going to do anything onStart
    }

    public void onStop(SliderEvent e) {
        // We are not going to do anything onStop        
    }
}