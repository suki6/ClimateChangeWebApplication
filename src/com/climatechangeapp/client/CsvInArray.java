package com.climatechangeapp.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CsvInArray {
	
	private static  TextArea textArea = new TextArea();
	private static  VerticalPanel vp = new VerticalPanel();
	
	public static void test(){
	
	 try {
         new RequestBuilder(RequestBuilder.GET, "GlobalLandTemperaturesByMajorCity_v1.txt").sendRequest("", new RequestCallback() {
             
             String arr[] = new String[228180];
             @Override
             public void onResponseReceived(Request req, Response resp) {
                 String text = resp.getText();
                 arr = text.split("\n");
                 for(String str: arr) 
                 {
					if(str.startsWith("1890"))
                         textArea.setText(textArea.getText()+str+"\n");
                 }
             }

             @Override
             public void onError(Request res, Throwable throwable) {
                 // handle errors
             }
         });
     	} 
	 	catch (RequestException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
	 	}
	 
	 
	 vp.add(textArea);
	 RootPanel.get("temperatureList").add(vp);
     }
}
