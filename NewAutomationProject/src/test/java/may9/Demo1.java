package may9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Demo1 
{
	//read the data from the excel file
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//open the excel file
		Workbook wb = WorkbookFactory.create(new FileInputStream(new File("./data/input.xlsx")));
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				String value = wb.getSheet("sheet1").getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		wb.close();
		
	}
}
