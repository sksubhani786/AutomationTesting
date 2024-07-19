package DDT;

public class newkasw {
	package dataDrivenTesting;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.util.LinkedHashMap;
	import java.util.Map.Entry;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class InsertDataToExcelUsingMap {

		public static void main(String[] args) throws Throwable {
			
		      //Step1:- Path Connection of the physical File
				FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

				        //step2:- keep Excel_File in Read mode
				         Workbook book = WorkbookFactory.create(fis);
					
				         //step3:- get control of the sheet
				         Sheet sheet = book.getSheet("Sheet2");
				         
		  LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		  map.put("10", "Shobha");
		  map.put("20", "rathin");
		  map.put("30", "nithin");
		  map.put("40", "vench");
		  
		  int rowNo=0;
		  for (Entry<String, String> m :map.entrySet())
		  {
			  Row row = sheet.createRow(rowNo++);
			  row.createCell(0).setCellValue((String)m.getKey());
			  row.createCell(1).setCellValue((String)m.getValue());
		}
		  
		  FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelTestData7pm.xlsx");
		  book.write(fos);
		  book.close();
		  
	}

	}


