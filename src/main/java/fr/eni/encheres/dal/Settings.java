package fr.eni.encheres.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	static private final String PROPERTIES_FILE = "settings.properties";
	
	static private Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			System.err.println("pas de possibilite d'acceder au fichier de proprietes");
			e.printStackTrace();
		}
	}
	
	static public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
