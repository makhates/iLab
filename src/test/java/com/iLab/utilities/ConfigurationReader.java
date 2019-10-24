package com.iLab.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	private static Properties ConfigFile;

	static {
		try {
			String path = "config.properties";
			FileInputStream input = new FileInputStream(path);
			ConfigFile = new Properties();
			ConfigFile.load(input);
			input.close();
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}
	public  static String getProperty(String Key) {
		return ConfigFile.getProperty(Key);
	}
}
