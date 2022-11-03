package com.facebook.scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest 
{
	public WebDriver driver;

	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void setUp(String br) 
	{
		if (br.equalsIgnoreCase("chrome")) 
		{
			// System.setProperty("webdriver.chrome.driver",
			// ".//drivers//chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (br.equalsIgnoreCase("firefox")) 
		{
			// System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (br.equalsIgnoreCase("edge")) 
		{
			// System.setProperty("webdriver.ie.driver", ".//drivers//edgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://en-gb.facebook.com/reg/");
	}

	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.close();

		// driver.quit();
	}

	public void captureScreenShot(String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//screenshots//" + tname + ".png");
		FileUtils.copyFile(source, target);

		System.out.println("Screenshot taken");
	}

}
