package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 
{
	@Test(priority = 2)
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//reading the data from the excel file
		//open the excel file.
		Workbook workBook = WorkbookFactory.create(new FileInputStream(new File("./data/input.xlsx")));
		//read the data
		String value = workBook.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue();
		Reporter.log(value,true);
		workBook.close();
	}
}
