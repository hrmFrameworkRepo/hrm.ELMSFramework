package advanced_selenium_basics;


	import java.io.File;
	import java.io.FileInputStream;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.testng.annotations.Test;
	public class Createorg_excelfileTest {
		@Test
		public void TC() throws Exception
		{
			String data1="";
			String data2="";
			String data3="";
			String expectedTest_id="TC_02";
			boolean flag=false;
			
			FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
			 Workbook book = WorkbookFactory.create(fis);

			Sheet sheet = book.getSheet("mobile_brands");
	      int rowcount=sheet.getLastRowNum();
	      for(int i=1;i<=rowcount;i++)
	      {
	    	  String data="";
	    	  try {
	    		   data=sheet.getRow(i).getCell(0).toString();
	    		   if(data.equals(expectedTest_id))
	    		   {
	    			  flag=true;
	    			   data1=sheet.getRow(i).getCell(1).toString();
	    			   data2=sheet.getRow(i).getCell(2).toString();
	    			   data3=sheet.getRow(i).getCell(3).toString();
	    		   }
	    		 
	    	  }catch(Exception e)
	    	  {
	    		  
	    	  }
	      }
	      if(flag==true)
	      {
	    	  System.out.println(data1);
	    	  System.out.println(data2);
	    	  System.out.println(data3);
	    	  
	      }
	      else {
	    	  System.out.println(expectedTest_id +"data is not available");
	      }
	}
	}




