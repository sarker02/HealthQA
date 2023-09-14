package utils;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertyReader {

	
    private Properties properties;

    public ConfigPropertyReader() {
        properties = new Properties();
        try {
        	String path = System.getProperty("user.dir");
            FileInputStream fileInputStream = new FileInputStream(path+"/config/global.properties");
            properties.load(fileInputStream);
            System.out.println("Browser Type: "+ properties.getProperty("browser"));
            fileInputStream.close();
        } catch (IOException e) {
        	System.out.println("Inside config properties exception block");
            e.printStackTrace();
        }
        
    
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
