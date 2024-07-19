package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String getexceldata(String sheetname, int rownum, int cellnum) throws Throwable
	{
FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String exceldata = cell.getStringCellValue();
		
		return exceldata;
		
	}


public String getexceldatausingdataformatter(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row row = sh.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	DataFormatter data = new DataFormatter();
	String exceldataformatter = data.formatCellValue(cell);
	return exceldataformatter;
	}

	
public Object[][] readdatausingdataprovider(String sheetname) throws Throwable
{
	
	
	
FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	
	int lastrow = sh.getLastRowNum()+1;
	short lastcell = sh.getRow(0).getLastCellNum();
	Object[][] ObjArry = new Object[lastrow][lastcell];
	for (int i = 0; i < lastrow; i++)
	{
		for (int j = 0; j < lastcell; j++)
		{
			ObjArry[i][j]=sh.getRow(i).getCell(j);
		}
		
	}
	return ObjArry;
	
}
}