package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Baseclass.Base_class;


@Listeners(com.crm.listenerutility.Listimpclass.class)

public class InvoiceTest extends Base_class {
 @Test(retryAnalyzer = com.crm.listenerutility.RetryListenerImp.class)
 public void createinvoiceTest()
 {
	
	 System.out.println("execute create invoicetest");
	 String actTitle=sdriver.getTitle();
	 Assert.assertEquals(actTitle, "login");
	 System.out.println("step-1");
	 System.out.println("step-2");
 }
 @Test
 public void createinvoicecontactTest()
 {
	 System.out.println("execute createinvoicecontactTest");
	 System.out.println("step-1");
	 System.out.println("step-2");
	 
 }
 

}
