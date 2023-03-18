package com.htmlProject.testclass;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.htmlProject.objectclass.BaseClass;
import com.htmlProject.objectclass.loginPageClass;
import com.htmlProject.utilities.exceldata;

public class TC_01_LoginTest extends BaseClass 
{
	@Test
	public void loginverify() throws InterruptedException, IOException
	{
		Thread.sleep(3000);//this will add 3 sec pause
		driver.get(baseURL);
		
		test = extent.createTest("verification of application login");
		
		Thread.sleep(3000);
		loginPageClass login = new loginPageClass(driver);
		
		Thread.sleep(3000);
		login.setUsersName(exceldata.getData(2, 0));
		test.log(Status.PASS,"username successfully entered");
		
		String screen = BaseClass.captureScreen();
		test.addScreenCaptureFromPath(screen);
		
		Thread.sleep(3000);
		login.setPassword(exceldata.getData(2, 1));
		test.log(Status.PASS,"password seccessfully entered");

		Thread.sleep(3000);
		login.clickOnloginButton();
		
		Thread.sleep(3000);
		test.log(Status.PASS,"clicked on login button");
		
		String pageTitle = "OrangeHRM";
		if (driver.getTitle().equals(pageTitle))
		{
			System.out.println("user logged in successfully");

			test.log(Status.PASS,"user logged in to the applilcation successfully");

			String screenshotpath = BaseClass.captureScreen();

			test.addScreenCaptureFromPath(screenshotpath);
		}
		
		else
		{
			System.out.println("user login failed");
		}
	}	
	
}
