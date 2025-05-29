package advanced_selenium_basics;

import java.util.Random;

import org.testng.annotations.Test;

public class Randomnumber {
	@Test
	public void random() {
		Random random = new Random();

		int rannumber = random.nextInt(10);
		System.out.println(rannumber);
		int n = 120;
		String alphanumericString = "ASDF0123!@#$%^&*asdf";
		// choose random chaacter from the string

		// create string buffer size of aplhanumeric string
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i <= 10; i++) {
			// to generate random combination of numbers and string
			int index = (int) (alphanumericString.length() * Math.random());
			// add character one by one in end of string builder
			sb.append(alphanumericString.charAt(index));
		}

		System.out.println(sb);
	}

}
