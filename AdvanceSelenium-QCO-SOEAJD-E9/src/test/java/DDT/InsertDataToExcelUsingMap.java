package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet6");
		
		LinkedHashMap<String, String> map = new  LinkedHashMap<String, String>();
		map.put("10", "subhani");
		map.put("20", "khaja");
		map.put("30", "asif");
		map.put("40", "shaida");
		
		int rowno = 0;
		for (Entry<String, String> m: map.entrySet())
		{
			Row row = sh.createRow(rowno++);
			row.createCell(0).setCellValue((String)m.getKey());
			row.createCell(1).setCellValue((String)m.getValue());
		}
			FileOutputStream fos = new FileOutputStream("./src/test/resources/exceldata.xlsx");
			
			wb.write(fos);
			wb.close();
		
		
		
		

	}

}
