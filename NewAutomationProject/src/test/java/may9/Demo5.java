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

import generic.Excel;

public class Demo5 
{
	//read the data from the excel file
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//reading the data from the excel file using our own developed generic getData() method.
		//calling the method
		String textValue = Excel.getData("./data/input2.xlsx", "sheet1", 0, 0);
		System.out.println("data returned from generic getData() method is "+textValue);
		
	}
}
