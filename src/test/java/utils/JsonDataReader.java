package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	 public static JSONObject readData(String FilePath) {
	        ConfigPropertyReader configReader = new ConfigPropertyReader();
	        String projectRootDir = configReader.getProperty("project_root_dir");
	        String project_root_dir = System.getProperty("user.dir");
	        String jsonFilePath = project_root_dir + File.separator + "data" + File.separator + FilePath;
	        
	        JSONParser parser = new JSONParser();
	        JSONObject testData = null;
	        
	        try {
	            FileReader reader = new FileReader(jsonFilePath);
	            testData = (JSONObject) parser.parse(reader);
	            reader.close();
	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
	        
	        return testData;
	    }
}
