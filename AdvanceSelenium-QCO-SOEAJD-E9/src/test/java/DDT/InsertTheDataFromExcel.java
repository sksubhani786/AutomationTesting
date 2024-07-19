package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertTheDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
        
		Workbook wb = WorkbookFactory.create(fis);
		
		
		Sheet sh = wb.getSheet("sheet2");
		sh.createRow(0).createCell(0).setCellValue("https://demowebshop.tricentis.com/");
		sh.createRow(1).createCell(1).setCellValue("javaselenium");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/exceldata.xlsx");
		
		wb.write(fos);
	fos.flush();
		wb.close();
		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
	}

}
