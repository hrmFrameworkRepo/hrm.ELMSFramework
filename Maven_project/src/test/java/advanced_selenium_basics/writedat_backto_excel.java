package advanced_selenium_basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class writedat_backto_excel {
	@Test
	public void TC() throws Exception {
       
		FileInputStream fis = new FileInputStream("./Excell/Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("mobile_brands");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowcount);
		System.out.println(colcount);
		 Row row1 = sheet.getRow(1);
		 Cell cell1 = row1.createCell(4);
		 cell1.setCellType(CellType.STRING);
		 cell1.setCellValue("PASS");
		
		 FileOutputStream fos=new FileOutputStream("./Excell/Vtiger.xlsx");
		 book.write(fos);
		 book.close();
		 System.err.println("   executed      ");

}
}
