package DDT;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class InsertDataInProperty {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		p.setProperty("url", "https://demowebshop.tricentis.com/login");
		p.setProperty("email", "sksubhani550@gmail.com");
		//p.setProperty("password", "0123456789");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/prop1.properties");
        p.store(fos, "prop1");
        System.out.println("values is inserted");
	}

}
