package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage 
{
	@FindBy(xpath = "//div[@id='fullname_field']/div/div[1]/div/div/input")
	private WebElement firstNameTB;

	@FindBy(xpath = "//div[@id='fullname_field']/div/div[2]/div/div/input")
	private WebElement surNameTB;

	@FindBy(xpath = "//div[@id='reg_form_box']/div[2]/div/div/input")
	private WebElement emailTB;

	@FindBy(xpath = "//div[@id='reg_form_box']/div[3]/div/div/div/input")
	private WebElement reEnterEmailTB;

	@FindBy(xpath = "//div[@id='reg_form_box']/div[4]/div/div/input")
	private WebElement newPasswordTB;

	@FindBy(id = "day")
	private WebElement birthDayField;

	@FindBy(id = "month")
	private WebElement birthMonthField;

	@FindBy(id = "year")
	private WebElement birthYearField;

	@FindBy(xpath = "//div[@id='reg_form_box']/div[7]/span/span[2]/input")
	private WebElement maleRadioButton;

	@FindBy(xpath = "//div[@id='reg_form_box']/div[11]/button")
	private WebElement signUpButton;

	public RegisterPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setFirstName(String firstName) 
	{
		firstNameTB.sendKeys(firstName);
	}

	public void setSurName(String surName) 
	{
		surNameTB.sendKeys(surName);
	}

	public void setEmail(String email) 
	{
		emailTB.sendKeys(email);
	}

	public void setReEnterEmail(String reEnterEmail) 
	{
		reEnterEmailTB.sendKeys(reEnterEmail);
	}

	public void setPassword(String password) 
	{
		newPasswordTB.sendKeys(password);
	}

	public void clickOnBirthDayField() 
	{
		birthDayField.click();

		Select s1 = new Select(birthDayField);
		s1.selectByIndex(26);

	}

	public void clickOnBirthMonthField() 
	{
		birthMonthField.click();

		Select s2 = new Select(birthMonthField);
		s2.selectByValue("7");
	}

	public void clickOnBirthYearField() 
	{
		birthYearField.click();

		Select s3 = new Select(birthYearField);
		s3.selectByVisibleText("1992");
	}

	public void clickMaleOnRadioButton() 
	{
		maleRadioButton.click();
	}

	public void clickOnSignUpButton() 
	{
		signUpButton.click();
	}
	
	//Business Methods

	public void registerNewUser(String firstName, String surName, String email, String reEnterEmail,
			String password) 
	{
		setFirstName(firstName);
		setSurName(surName);
		setEmail(email);
		setReEnterEmail(reEnterEmail);
		setPassword(password);
		clickOnBirthDayField();
		clickOnBirthMonthField();
		clickOnBirthYearField();
		clickMaleOnRadioButton();
		clickOnSignUpButton();
	}

}
