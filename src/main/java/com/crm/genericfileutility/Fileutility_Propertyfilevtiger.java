package com.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileutility_Propertyfilevtiger {

	public String getdataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream("./Property/Vtiger.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
		
	}
}
