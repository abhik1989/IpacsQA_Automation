package com.ipacs.qa.utilities;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static String getReadData(String key) {
		String value = "";
		try {
			InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream("config.properties");
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return value;
			}
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
			input.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	

}