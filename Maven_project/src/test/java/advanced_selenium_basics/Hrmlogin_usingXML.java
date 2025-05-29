package advanced_selenium_basics;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Hrmlogin_usingXML {
	@Test
	public void loginadminTest(XmlTest test)
	{
		System.out.println("HRM login");
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}

}
