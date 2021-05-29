package com.seleniumAutomation;

import java.awt.Window;

import org.openqa.selenium.By;

public class Testcase_01 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		System.out.println("step1");
		launch("firefoxbrowser");
		System.out.println("Testca");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
		
		//windowMaximize();
		Thread.sleep(5000);
		
		deleteCookies();
		
		Thread.sleep(5000);
		String currentUrl = WindowCurrentUrl();
		System.out.println(currentUrl);
		
		String title = getTitle();
		System.out.println(title);
		
		windowBack();
		
		Thread.sleep(5000);
		windowForward();
		
		Thread.sleep(10000);
		WindowRefresh();
		
		Thread.sleep(5000);
		//windowQuit();
				
		
	}



}
