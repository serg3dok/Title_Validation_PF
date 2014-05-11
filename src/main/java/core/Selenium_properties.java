package core;

// BEGIN
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Selenium_properties {
	public static void main(String[] args) {
		
			
		/*
		String text_case_id = "TC-001.01";

 		String url = "http://www.learn2test.net";
 		String title_expected = "learn2test.net";

		String param[] = args[0].split("\\|");
		String url = param[0];
		String title_expected = param[1];
				 */
		
		String text_case_id = null;
		String url = null;
		String title_expected = null;
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream("./src/main/resources/Test.properties"));
			
			text_case_id = properties.getProperty("text_case_id");
			url = properties.getProperty("url");
			title_expected = properties.getProperty("title_expected");
		}
		catch (IOException e) {
			e.printStackTrace();
		
		}
		

		WebDriver driver = new FirefoxDriver(); // Version 1.1 :: Firefox
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		driver.quit();
	}
}

// END