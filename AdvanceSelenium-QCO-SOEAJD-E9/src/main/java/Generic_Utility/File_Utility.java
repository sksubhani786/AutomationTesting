package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	public String getkeyandvaluepair(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}

}
