package com.crm.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
	public int getRandomNumber() {
		Random random = new Random();

		int randomnumber = random.nextInt(5000);
		return randomnumber;
	}

	public String getSystemDateyyyymmdd() {

		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;

	}

	public String getRequiredDateyyyymmdd(int days) {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;

	}
}
