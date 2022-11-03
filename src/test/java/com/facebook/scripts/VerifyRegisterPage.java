package com.facebook.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.facebook.pom.RegisterPage;

public class VerifyRegisterPage extends BaseTest 
{
	@Test
	public void verifyRegisterPage() throws IOException 
	{
		RegisterPage rp = new RegisterPage(driver);

		/*
		 * rp.setFirstName("Anil"); 
		 * rp.setSurName("Kumar");
		 * rp.setEmail("anil.krtg@yahoo.com");
		 * rp.setReEnterEmail("anil.krtg@yahoo.com"); 
		 * rp.setPassword("2105");
		 * rp.clickOnBirthDayField(); 
		 * rp.clickOnBirthMonthField();
		 * rp.clickOnBirthYearField(); 
		 * rp.clickMaleOnRadioButton();
		 * rp.clickOnSignUpButton();
		 */
		rp.registerNewUser("Anil", "Kumar", "anil.krtg@yahoo.com", "anil.krtg@yahoo.com", "210527");

		boolean res = driver.getTitle().contains("Sign up for Facebook | Facebook");

		if (res == true) 
		{
			Assert.assertTrue(true);
			//Reporter.log("test case passed");
		} 
		else 
		{
			captureScreenShot("addNewAccount");
			Assert.assertTrue(false);
			//Reporter.log("test case failed");
		}

	}
}
