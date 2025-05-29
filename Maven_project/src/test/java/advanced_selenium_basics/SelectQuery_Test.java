 package advanced_selenium_basics;

import java.sql.Connection;

import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery_Test {
	@Test
	public void selectquery() throws Throwable
	{
		Connection conn=null;
		try {
			//Step 1 load/register the database driver
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		//step 2 connect to database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
		System.out.println("done");
		
		//step 3: Create sql statement
		Statement stat=conn.createStatement();
		//step 4: execute select query and get the   result
		ResultSet resultset=stat.executeQuery("select * from EMP;");
		while(resultset.next())
		{
			System.out.println(resultset.getString(1) + "\t" + resultset.getString(2)+  "\t" +resultset.getString(3) + "\t" +resultset.getString(4));
		}
			
		}
		catch(Exception e) {
			System.out.println("handle exception");
		}
		finally {
			//step 5 close the connection
			conn.close();
		}
	}

}
