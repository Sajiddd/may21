package generic;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	//generic method to read the data from the excel file.
	public static String getData(String path,String sheet, int row, int col)
	{
		String value="";
		try
		{
			//open the excel file
			Workbook wb = WorkbookFactory.create(new FileInputStream(new File(path)));
			value = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		}
		catch (Exception e) 
		{
			
		}
		return value;
	}
}
