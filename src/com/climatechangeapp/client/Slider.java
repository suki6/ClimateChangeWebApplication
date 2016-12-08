package com.climatechangeapp.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * This widget wraps the JQuery UI Slider and allows for single slider or double slider with range.
 * 
 * All options can be get or set using generic get/setIntOption, get/setStringOption, get/setBooleanOption
 * methods, but some convenience methods are provided for most popular such as
 * setValues and setMinimum and setMaximum.  See SliderOptions for full list of options.
 * @see SliderOption
 */
@SuppressWarnings("deprecation")
public class Slider extends Widget {    
    private JSONObject m_defaultOptions;
	private SliderEntry m_listener;
    
    /**
     * Create a slider with the specified ID.  The ID is required because the slider needs a specific ID to connect to.
     * @param id - id of the element
     * @param min - default minimum of the slider
     * @param max - default maximum of the slider
     * @param defaultValue - default point of a single anchor
     */
    public Slider(String id, int min, int max, int defaultValue) {
    	this(id, getOptions(min, max, defaultValue));
    }
        
    /**
     * Create the default slider with the specified ID.  The ID is required because the slider needs a specific ID to connect to.
     * @param id - id of the element to create
     */
    public Slider(String id) {           
        this(id, null);        
    }
    
    /**
     * Create a slider with the specified ID.  The ID is required
     * because the slider needs a specific ID to connect to.
     * @param id - id of the element to create
     * @param options - JSONObject of any possible option, can be null for defaults
     */
    public Slider(String id, JSONObject options) {           
        super();
        Element divEle = DOM.createDiv();
        setElement(divEle);
        divEle.setId(id);
        
        m_defaultOptions = options;
        if (m_defaultOptions == null) {
            m_defaultOptions = getOptions(1850, 2013, 2011);
        }        
    }
    
    /**
     * A convenient way to create an options JSONObject.  Use SliderOption for keys.
     * @param min - default minimum of the slider
     * @param max - default maximum of the slider
     * @param defaultValues - default points of each anchor
     * @return a JSONObject of Slider options
     */
    public static JSONObject getOptions(int min, int max, int defaultValue) {		// Wichtig
        JSONObject options = new JSONObject();
        options.put(SliderOption.MIN.toString(), new JSONNumber(min));
        options.put(SliderOption.MAX.toString(), new JSONNumber(max));
        JSONArray vals = intArrayToJSONArray(defaultValue);
        options.put(SliderOption.VALUES.toString(), vals);
        return options;
    }

    private static JSONArray intArrayToJSONArray(int value) {
        JSONArray vals = new JSONArray(); 
        vals.set(0, new JSONNumber(value));
        return vals;
    }
    
    @Override
    protected void onLoad() {
        createSliderJS(this, getElement().getId(), m_defaultOptions.getJavaScriptObject());
        super.onLoad();
    }
    
    @Override
    protected void onUnload() {
        destroySliderJS(this, getElement().getId());
        super.onUnload();        
    }

    /**
     * Convenience method for only 1 anchor
     * @return Returns the value.
     */
    public int getValue() {
        return getValueJS(getElement().getId(), 0);
    }
    
    /**
     * Convenience method for only 1 anchor
     * @param value to set.
     */
    public void setValue(int value) {
        JSONArray vals = intArrayToJSONArray(value);
        setValuesJS(getElement().getId(), vals.getJavaScriptObject());
    }    
   
    /**
     * Set an option numeric value
     * @param option the SliderOption
     * @param value the numeric
     */
    public void setIntOption(SliderOption option, int value) {
        setIntOptionJS(getElement().getId(), option.toString(), value);
    }
    
    /**
     * Get an option numeric value
     * @param option the SliderOption
     * @return value the numeric
     */
    public int getIntOption(SliderOption option) {
        return getIntOptionJS(getElement().getId(), option.toString());
    }
    
    /**
     * Set an option boolean value
     * @param option the SliderOption
     * @param value the boolean
     */
    public void setBooleanOption(SliderOption option, boolean value) {
        setBooleanOptionJS(getElement().getId(), option.toString(), value);
    }
    
    /**
     * Get an option boolean value
     * @param option the SliderOption
     * @return value the boolean
     */
    public boolean getBooleanOption(SliderOption option) {
        return getBooleanOptionJS(getElement().getId(), option.toString());
    }
    
    /**
     * Set an option string value
     * @param option the SliderOption
     * @param value the String
     */
    public void setStringOption(SliderOption option, String value) {
        setStringOptionJS(getElement().getId(), option.toString(), value);
    }
    
    /**
     * Set an option string value
     * @param option the SliderOption
     * @return value the String
     */
    public String setStringOption(SliderOption option) {
        return getStringOptionJS(getElement().getId(), option.toString());
    }
    
    // New Try: Add a Listener: Joh
    public void addListener(SliderEntry one) {
        m_listener = one;
    }
    
    private void fireOnStartEvent(Event evt, JsArrayInteger values) {
        int[] vals = jsArrayIntegerToIntArray(values);
        SliderEvent e = new SliderEvent(evt, this, vals);
        m_listener.onStart(e);
    }
    
    private boolean fireOnSlideEvent(Event evt, JsArrayInteger values) {
        int[] vals = jsArrayIntegerToIntArray(values);
        SliderEvent e = new SliderEvent(evt, this, vals);
        m_listener.onStart(e);
        boolean ret = true;
        if (!m_listener.onSlide(e)) ret = false;
        return ret;
    }
    
    private void fireOnChangeEvent(Event evt, JsArrayInteger values, boolean hasOriginalEvent) {
        int[] vals = jsArrayIntegerToIntArray(values);        
        SliderEvent e = new SliderEvent(evt, this, vals, hasOriginalEvent);
        m_listener.onChange(e);
    }
    
    private void fireOnStopEvent(Event evt, JsArrayInteger values) {
        int[] vals = jsArrayIntegerToIntArray(values);
        SliderEvent e = new SliderEvent(evt, this, vals);
        m_listener.onStop(e);
    }
    
    private int[] jsArrayIntegerToIntArray(JsArrayInteger values) {
        int len = values.length();
        int[] vals = new int[len];
        for (int i = 0; i < len; i++) {
            vals[i] = values.get(i);
        }
        return vals;
    }
    
    // JSNI methods 
    private native void setIntOptionJS(String id, String option, int value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;
    
    private native int getIntOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;

    private native void setBooleanOptionJS(String id, String option, boolean value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;
    
    private native boolean getBooleanOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;

    private native void setStringOptionJS(String id, String option, String value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;
    
    private native String getStringOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;

    private native void setValuesJS(String id, JavaScriptObject values) /*-{
        $wnd.$("#" + id).slider("option", "values", values);
    }-*/;
    
    private native int getValueJS(String id, int index) /*-{
        return $wnd.$("#" + id).slider("values", index);
    }-*/;
    
    private native void createSliderJS(Slider x, String id, JavaScriptObject options) /*-{
        options.start = function(event, ui) {
            x.@com.climatechangeapp.client.Slider::fireOnStartEvent(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/core/client/JsArrayInteger;)(event, ui.values);
        };
        options.slide = function(event, ui) {
            return x.@com.climatechangeapp.client.Slider::fireOnSlideEvent(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/core/client/JsArrayInteger;)(event, ui.values);
        };
        options.change = function(event, ui) {
            var has = event.originalEvent ? true : false;
            x.@com.climatechangeapp.client.Slider::fireOnChangeEvent(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/core/client/JsArrayInteger;Z)(event, ui.values, has);                
        };
        options.stop = function(event, ui) {
            x.@com.climatechangeapp.client.Slider::fireOnStopEvent(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/core/client/JsArrayInteger;)(event, ui.values);
        };
        
        $wnd.$("#" + id).slider(options);
    }-*/;

    private native void destroySliderJS(Slider x, String id) /*-{
        $wnd.$("#" + id).slider("destroy");
    }-*/;
}