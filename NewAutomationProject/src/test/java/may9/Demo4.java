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

public class Demo4 
{
	//read the data from the excel file
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//open the excel file
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File("./data/input2.xlsx")));
		//getting the row count 
		Sheet sheet = wb.getSheet("sheet1");
		int rowCount = sheet.getLastRowNum();//returns the index of last row where data is present. 
		System.out.println("row count is "+rowCount);
		
		//getting column count
		//returns the sequential number of last column where data is present.
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Coulmn count is "+colCount);

		//Handling dynamic rows and columns of excel file.
		for(int i=0;i<=rowCount;i++)
		{
			try
			{
				int column = sheet.getRow(i).getLastCellNum();
				for(int j=0;j<column;j++)
				{
					try {
						String value = wb.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue();
						System.out.print(value+" ");
					}
					catch (Exception e) {
						System.out.print("-- ");
					}
				}
			}
			catch (Exception e) {
				System.out.print("-- -- -- -- -- ");
			}
			System.out.println();
		}
		wb.close();
		
	}
}
