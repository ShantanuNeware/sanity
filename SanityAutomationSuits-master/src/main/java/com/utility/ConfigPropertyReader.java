package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {

	/**
	 * This method reads all details that are mentioned in configuration.properties
	 * file
	 *
	 * @return properties value
	 */
	public Properties propertyInitialization() {
		Properties properties = new Properties();

		try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/Configuration.properties")) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}
}
