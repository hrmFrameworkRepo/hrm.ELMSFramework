 package advanced_selenium_basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class Dateandcalendar {
	@Test
	public void date() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sim.format(date);
		System.out.println(currentdate);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dateafter_30days=sim.format(cal.getTime());
		System.out.println(dateafter_30days);
	}

}
