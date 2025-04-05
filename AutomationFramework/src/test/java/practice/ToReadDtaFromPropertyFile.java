package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDtaFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Create fis
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData");
		
		//Create object
		Properties prop = new Properties();
		
		//Call the method
		prop.load(fis);
		String URL = prop.getProperty("url");
		String 	Password = prop.getProperty("username");
		String Username = prop.getProperty("password");
		String Browser = prop.getProperty("browser");
		
		System.out.println(URL);
		System.out.println(Password);
		System.out.println(Username);
		System.out.println(Browser);
		
	}

}
