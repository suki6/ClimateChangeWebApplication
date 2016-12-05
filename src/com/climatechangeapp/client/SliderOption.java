package com.climatechangeapp.client;

//An enumeration of all the options you can set for a slider
public enum SliderOption {
    /**
     * disabled. Type Boolean. Default: false
     * Disables (true) or enables (false) the slider. Can be set when initialising (first creating) the slider.
     */
    DISABLED("disabled"),

    /**
     * animate. Type: Boolean, String, Number. Default: false
     * Whether to slide handle smoothly when user click outside handle on the bar. 
     * Will also accept a string representing one of the three predefined speeds ("slow", "normal", or "fast") 
     * or the number of milliseconds to run the animation (e.g. 1000).
     */
    ANIMATE("animate"),

	// The maximum value of the slider.
    MAX("max"),

	// The minimum value of the slider.
    MIN("min"),

    /**
     * step. Type: Number. Default: 1
     * Determines the size or amount of each interval or step the slider takes between min and max. 
     * The full specified value range of the slider (max - min) needs to be evenly divisible by the step.
     */
    STEP("step"),
    
    /**
     * value. Type: Number. Default: 0
     * Determines the value of the slider, if there's only one handle. 
     * If there is more than one handle, determines the value of the first handle.
     */
    VALUE("value"),

	// values. Type: Array. Default: null
	// This option can be used to specify multiple handles. If range is set to true, the length of 'values' should be 2.
    VALUES("values");

    private String m_name;

    private SliderOption(String name) {
        m_name = name;
    }

    @Override
    public String toString() {
        return m_name;
    }
}