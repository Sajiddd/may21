package may9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Demo2 
{
	//read the data from the excel file
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//open the excel file
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File("./data/input.xlsx")));
		//getting the row count 
		Sheet sheet = wb.getSheet("sheet1");
		int rowCount = sheet.getLastRowNum();//returns the index of last row where data is present. 
		System.out.println("row count is "+rowCount);
		
		//getting column count
		//returns the sequential number of last column where data is present.
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Coulmn count is "+colCount);

		wb.close();
		
	}
}
