package com.seleniumAutomation;

import org.openqa.selenium.By;

public class TestCase_03 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
	
		init();
		launch("firefoxbrowser");
		navigateUrl("amazonurl1");
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Appliances");
		selectOption("amazondropdown_id", "Appliances");
				
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("airconditioners");
		tepyText("amazontextbox_id", "Airconditioners");
		
		
		//driver.findElement(By.id("nav-search-submit-button")).click();
		clickElement("amazonserchbutton_xpath");
		
	}

	
}
