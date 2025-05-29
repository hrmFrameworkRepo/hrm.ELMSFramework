package advanced_selenium_basics;

import java.util.Date;

import org.testng.annotations.Test;

public class Capturetimestamp {
	@Test
	public void ist()
	{
		String time=new Date().toString().replace(":","_").replace(" ", "_");
		System.out.println(time);
	}

}
