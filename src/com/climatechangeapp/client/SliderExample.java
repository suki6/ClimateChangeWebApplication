package com.climatechangeapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SliderExample {

    private Slider m_slider;
    private Label m_sliderLabel;
    
    // This is the entry point method.
    public SliderExample() {
        // Create a slider with default behavior: minimum possible value of 1850, maximum possible value of 2013
        m_sliderLabel = new Label("1850");					//StartWert
        m_sliderLabel.addStyleName("slider-values");		//Für CSS
        m_slider = new Slider("slider");					//Erstellt den Slider
        RootPanel.get("sliderContainer").add(m_sliderLabel);//Für HTML-Element
        RootPanel.get("sliderContainer").add(m_slider);
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