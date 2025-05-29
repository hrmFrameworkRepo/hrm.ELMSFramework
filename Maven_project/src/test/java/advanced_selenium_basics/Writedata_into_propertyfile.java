package advanced_selenium_basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class Writedata_into_propertyfile {
	@Test
	public void Property() throws Exception
	{
	
	
	//Covert the property file into java understandable
	FileInputStream fis=new FileInputStream("./Property/crossbrowser.properties");
	
	//Create obj for property file
	Properties prop=new Properties();
	
	//load the file into properties class
	prop.load(fis);

	//call the non-static method to write key and value into the propertyfile
	prop.put("signin", "KTM");
	
	
	//cover the from javaunderstable to physical file
	FileOutputStream fos=new FileOutputStream("./Property/crossbrowser.properties");
	
	//Store the data
	prop.store(fos, "update");
	
	}
}
