package com.Rutukanta.parabank.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {
	public static String read(String dataR) throws IOException {
		String path = "config.properties";
		Properties pr = new Properties();
		FileInputStream fis = new FileInputStream(path);
		pr.load(fis);
		String val = pr.getProperty(dataR);
//		String val1 = pr.getProperty("LastName");
//		System.out.println(val + "\n" + val1);
		System.out.println(val + "\n" );
		return val;
	}
}