package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FeatchTheDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//1)FileInputStream object
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		//2)create workbook object
		Workbook wb = WorkbookFactory.create(fis);
		//3)Fecthing Values
		//System.out.println(wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue());
        //System.out.println(wb.getSheet("sheet1").getRow(2).getCell(1).getNumericCellValue());
        //System.out.println(wb.getSheet("sheet1").getRow(3).getCell(3).getBooleanCellValue());
		
		
		Cell cell1 = wb.getSheet("sheet1").getRow(0).getCell(0);
		Cell cell2 = wb.getSheet("sheet1").getRow(2).getCell(1);
		Cell cell3 = wb.getSheet("sheet1").getRow(3).getCell(3);
		//this is used pass the any data type 
		DataFormatter data = new DataFormatter();
		
		System.out.println(data.formatCellValue(cell1));
		System.out.println(data.formatCellValue(cell2));
		System.out.println(data.formatCellValue(cell3));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
