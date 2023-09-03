package utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public Properties properties;

	public void ConfigFileReader() {
		BufferedReader bufferedReader;
		FileReader fileReader;
		String propertyFilePath = "config/config.properties";

		try {
			fileReader = new FileReader(propertyFilePath);
			bufferedReader = new BufferedReader(fileReader);
			properties = new Properties();

			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}
	}

}
