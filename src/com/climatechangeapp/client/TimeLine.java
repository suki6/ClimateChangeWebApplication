package com.climatechangeapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.kiouri.sliderbar.client.view.SliderBarHorizontal;

/**
 *
 * @author suki
 *
 */
public class TimeLine extends SliderBarHorizontal{
	
	private VerticalPanel vp = new VerticalPanel();

    ImagesTimeLine images = GWT.create(ImagesTimeLine.class);
	
	public TimeLine (int minValue, int maxValue, String width, String height) {
		setLessWidget(new Image(images.less()));
        setScaleWidget(new Image(images.scale().getSafeUri()), 20);
        setDragWidget(new Image(images.drag()));
        setMoreWidget(new Image(images.more()));
        this.setWidth(width);
        this.setHeight(height);
        this.setMaxValue(maxValue); 
        this.setMinMarkStep(10);
	}

		
	
	interface ImagesTimeLine extends ClientBundle{
        @Source("com/kiouri/sliderbar/client/solution/simplehorizontal/draghthin.png")
        ImageResource drag();

        @Source("com/kiouri/sliderbar/client/solution/simplehorizontal/minush.png")
        ImageResource less();

        @Source("com/kiouri/sliderbar/client/solution/simplehorizontal/plush.png")
        ImageResource more();

        @Source("com/kiouri/sliderbar/client/solution/simplehorizontal/scalehthinblack.png")
        DataResource scale();  
	}
	



}
