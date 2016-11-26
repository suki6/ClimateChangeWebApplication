import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.climatechangeapp.client.Temperature;
import com.google.gwt.thirdparty.guava.common.base.Stopwatch;

public class Serializer {
	public static void main(String[] args) throws IOException,
		ClassNotFoundException {
		Serializer serializer = new Serializer();
		List<Temperature> allTemperatures = new ArrayList<>();
		FileInputStream input = new FileInputStream("/ClimateChangeApplication/src/com/climatechangeapp/GlobalLandTemperaturesByMajorCity_v1.csv");
		allTemperatures = serializer.generateTemperatureObjects(input);
		input.close();
	/**	
		for (Temperature temperature : allTemperatures) {
			System.out.println(temperature.getAverageTemp());
		}
	*/
		
	}

	private List<Temperature> generateTemperatureObjects(InputStream inputStream) {
		
		List<Temperature> temperatures = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				temperatures.add(this.parseTemperature(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return temperatures;
	}

	private Temperature parseTemperature(String line) {
		List<String> columns = com.google.appengine.labs.repackaged.com.google.common.base.Splitter
				.on(',').trimResults().splitToList(line);		
		
		String date = columns.get(0);
		String averageTemp = columns.get(1);
		String averageTempUncertainty = columns.get(2);
		String city = columns.get(3);
		String country = columns.get(4);
		String latitude = columns.get(5);
		String longitude = columns.get(6); 
		
		Temperature temperature = new Temperature(date, averageTemp, averageTempUncertainty, city, country, longitude, latitude);
		
		return temperature;
	}
}