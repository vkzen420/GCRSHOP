package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configproperties  {

	public String  Configuration() throws IOException {
		
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\vkjai\\eclipse-workspace\\Seleniumnew\\config.properties");
	prop.load(fis);
	String AppURl = prop.getProperty("url");
	return AppURl;
	
	
	
	}
}
