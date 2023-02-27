package com.htmlProject.objectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageClass {
		
		WebDriver ldriver;
		
		@FindBy(xpath ="//input[@name='username']")
		WebElement username;
		
		@FindBy(xpath = "//input[@name='password'] ")
		WebElement password;
		
		@FindBy(xpath ="//button[text()=' Login ']")
		WebElement login;
		
		public loginPageClass(WebDriver rdriver)
		{
			ldriver= rdriver;
			PageFactory.initElements(rdriver,this);
		}

		
		public void setUsersName(String Admin)
		{
			username.sendKeys(Admin);
		}
		
		public void setPassword(String admin123) {
			password.sendKeys(admin123);
		}
		
		public void clickOnloginButton()
		{
			login.click();
		}
		}
