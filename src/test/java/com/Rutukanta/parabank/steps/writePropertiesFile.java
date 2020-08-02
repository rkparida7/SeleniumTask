package com.Rutukanta.parabank.steps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class writePropertiesFile {
	public static void write(String dataW) throws IOException {
		String path = "config.properties";
		File file = new File(path);
		file.createNewFile();
		Properties pr = new Properties();
		pr.setProperty("NewAccount", dataW);
		FileOutputStream fis = new FileOutputStream(file);
		pr.store(fis, "Test Data");
		fis.close();
	}
}