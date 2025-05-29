package advanced_selenium_basics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonreadingdataTest {

	@Test
	public void jsondata() throws Throwable, IOException, ParseException
	{
		//step 1 : parse  json physical file into java object using Json parser class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./JSON/adminlogin.json"));
		
		//step 2: converting the java object into JSON object using downcating
		
		JSONObject map=(JSONObject) obj;
		//Step 3 :get the value from json file using key
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
}
