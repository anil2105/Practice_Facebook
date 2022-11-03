package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage 
{
	public WebDriver driver;

	public BasePage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void verifyTitle() 
	{
		String aTitle = driver.getTitle();
		String eTitle = "https://en-gb.facebook.com/reg/";

		Assert.assertEquals(aTitle, eTitle, "Title not displayed...");

		//Reporter.log("True: Title displayed successfully...");
	}
}
