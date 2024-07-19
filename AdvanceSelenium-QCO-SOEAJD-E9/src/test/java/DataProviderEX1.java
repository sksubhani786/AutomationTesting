import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEX1 {
	
	@Test(dataProvider ="getData" )
	public void booktickets(String src, String desti, int noppl )
	{
		System.out.println("book tickets "+src+" to "+desti+"," +noppl+"");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArry = new Object[3][3];
		objArry[0][0]= "banglore";
		objArry[0][1]="goa";
		objArry[0][2]=2;
		
		objArry[1][0]="banglore";
		objArry[1][1]="pune";
		objArry[1][2]=3;
		
		objArry[2][0]="banglore";
		objArry[2][1]="mysore";
		objArry[2][2]=4;
		return objArry;
		
	}

}
