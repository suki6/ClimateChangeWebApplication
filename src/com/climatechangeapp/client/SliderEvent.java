package com.climatechangeapp.client;

import com.google.gwt.user.client.Event;


//A class to hold event values for the Slider
public class SliderEvent {
    private int m_value;
    private boolean m_hasOriginalEvent = true;
    private Event m_event;
    
    /**
     * Create a new slider event.
     * @param event - the event received by JSNI called
     * @param source - the Slider that fires the event
     * @param values - int array of values
     */
    public SliderEvent(Event event, Slider source, int[] values) {
        this(event, source, values, true);
    }

    /**
     * Create a new slider event.
     * @param event - the event received by JSNI called
     * @param source - the Slider that fires the event
     * @param values - int array of values
     * @param hasOriginalEvent - boolean if the change came from a non-programmatic change such as mouse or keyboard event
     */
    public SliderEvent(Event event, Slider source, int[] values, boolean hasOriginalEvent) {
        m_event = event;
        m_value = values[0];
        m_hasOriginalEvent = hasOriginalEvent;
    }
    
	// @return Returns the JSNI returned JavaScriptObject event.
    public Event getEvent() {
        return m_event;
    }
    
    /**
     * Get the values from the event.
     * @return Returns the value.
     */
    public int getValue() {
        return m_value;
    }

    /**
     * Does this event have an original event.
     * @return Returns the hasOriginalEvent.
     */
    public boolean hasOriginalEvent() {
        return m_hasOriginalEvent;
    }
}