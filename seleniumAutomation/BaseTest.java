package com.seleniumAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp,orProp;
	public static FileInputStream fis;
	
	public static void init() throws Exception
	{
		//to Load Data properties file
		//FileInputStream fis = new FileInputStream(projectPath+"//data.properties");
		fis = new FileInputStream(projectPath+"//data.properties");
		p = new Properties();
		p.load(fis);
		
		// to load environment properties file
		//FileInputStream fis =new FileInputStream(projectPath+"//environment.properties");
		fis =new FileInputStream(projectPath+"//environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		//to load test case properties file
		fis=new FileInputStream(projectPath+"//"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		//String value = childProp.getProperty("amazonurl");
		//System.out.println(value);
		
		fis=new FileInputStream(projectPath+"//or.properties");
		orProp = new Properties();
		orProp.load(fis);
	
		
	}
	public static void launch(String browser)
	{
		if (p.getProperty(browser).equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "E:\\Dinesh\\Java Selenium\\Drivers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		else if (p.getProperty(browser).equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "E:/Dinesh/Java Selenium/Drivers/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver.exe");
			ProfilesIni p= new ProfilesIni();
			FirefoxProfile profile = p.getProfile("firefoxpp");
			// to disable the notification:
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option = new FirefoxOptions();
			
			option.setProfile(profile);
			
			driver = new FirefoxDriver(option);
			
			System.out.println("Firefox Launched");
			
		}
		else if (p.getProperty(browser).equals("edge")) 
		{
			//System.setProperty("webdriver.edge.driver", "E:/Dinesh/Java Selenium/Drivers/msedgedriver.exe");
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//drivers//msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", projectPath+"//drivers//msedgedriver.exe");
			
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		
	}
	
	public static void navigateUrl(String url)
	{
		System.out.println(url);
		System.out.println("child url:  "+childProp.getProperty(url));
		driver.get(childProp.getProperty(url));
		//driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void windowQuit() 
	{
	driver.quit();
		
	}

	public static void windowClose() 
	{
	driver.close();
		
	}

	public static String getTitle() 
	{
		String title = driver.getTitle();
		//System.out.println(title);
		return title;
	}

	public static void WindowRefresh() 
	{
	
		driver.navigate().refresh();
		
	}

	public static void windowForward() 
	{
	
		driver.navigate().forward();
	}

	public static void windowBack() 
	{
		driver.navigate().back();
	
	}

	public static void deleteCookies() 
	{
		driver.manage().deleteAllCookies();
		
	}

	public static String WindowCurrentUrl() 
	{
	
		String currentUrl = driver.getCurrentUrl();
		//System.out.println(currentUrl);
		return currentUrl;
	}

	public static void windowMaximize() 
	{
		driver.manage().window().maximize();
		
	}
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void tepyText(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(option);
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}

	public static WebElement getElement(String locatorKey)
	{
		WebElement element = null;
		if (locatorKey.endsWith("_id"))
		{
		element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
			
		}else if (locatorKey.endsWith("_xpath"))
		{
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}
		else if (locatorKey.endsWith("_name"))
		{
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}
		else if (locatorKey.endsWith("_classname"))
		{
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}
		else if (locatorKey.endsWith("_tagname"))
		{
			element = driver.findElement(By.tagName(orProp.getProperty(locatorKey)));
		}
		return element;
	}

}
