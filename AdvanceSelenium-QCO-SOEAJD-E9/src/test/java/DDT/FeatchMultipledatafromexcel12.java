package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FeatchMultipledatafromexcel12 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet4");
		int rownum = sh.getPhysicalNumberOfRows();
		int cellnum = sh.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0; i<rownum; i++) {
			for(int j=0; j<cellnum; j++) {
				Cell data = sh.getRow(i).getCell(j);
				DataFormatter datas = new DataFormatter();
				System.out.println(datas.formatCellValue(data));
			}
		}
		

	}

}
