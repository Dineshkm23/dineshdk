package com.seleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLanch 
{
public static void main(String[] args)
	
	{
	
	System.out.println(System.getProperty("user.dir"));
	/*WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\Dinesh\\Java Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
	

		System.setProperty("webdriver.edge.driver", "E:/Dinesh/Java Selenium/Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in");
*/
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prash\\eclipse-workspace\\May2021_6AMSeleniumBatch\\drivers\\geckodriver.exe");
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("https://www.amazon.in");
	 
	}
}
