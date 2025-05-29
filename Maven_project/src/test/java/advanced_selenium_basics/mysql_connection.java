package advanced_selenium_basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

public class mysql_connection {

	private static String actualUser;

	public static void main(String[] args) throws Throwable {
		String reguser = "GANESH";
		boolean flag = false;
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8081/AppServer/Online_Food_Ordering_System/registration.php");
		driver.findElement(By.id("example-text-input")).sendKeys(reguser);
		driver.findElement(By.name("firstname")).sendKeys("NANI");
		driver.findElement(By.name("email")).sendKeys("verr023@gmail.com");
		driver.findElement(By.name("password")).sendKeys("verra123");
		driver.findElement(By.name("phone")).sendKeys("9840989070");
		driver.findElement(By.name("address")).sendKeys("KPHB");
		driver.findElement(By.name("lastname")).sendKeys("QWERTY");
		driver.findElement(By.name("cpassword")).sendKeys("verra123");
		WebElement ele=driver.findElement(By.name("submit"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);

		Connection conn = null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			System.out.println("====Done====");
			Statement stat = conn.createStatement();
			ResultSet resultset = stat.executeQuery("select * from  EMP");
			while (resultset.next()) {
				String actualUser = resultset.getString(2);
				if (actualUser.equals(reguser)) {

					flag = true;
					System.out.println(actualUser + "is available==>pass");
				}
			}
			if (flag == false) {
				System.out.println(actualUser + "is not available");
			}

			

		} catch (Exception e) {

		} finally {
			conn.close();
		}

	}
}
