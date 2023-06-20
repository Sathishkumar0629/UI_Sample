package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	static {
		properties = new Properties();
		try (InputStream inputstream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"))
		{
			properties.load(inputstream);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getURL() {
		return properties.getProperty("url");
	}
	
	public static String getName() {
		return properties.getProperty("name");
	}
}
