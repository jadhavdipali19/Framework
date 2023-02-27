package com.htmlProject.objectclass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.htmlProject.utilities.readconfiguration;

public class BaseClass {

	
	readconfiguration read = new readconfiguration();
	public String baseURL = read.getAppURL();
	public String Username = read.getUsername();
	public String password = read.getPassword();
	
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static WebDriver driver;
	@BeforeSuite
	public void setReport()
	{
		sparkreporter = new ExtentSparkReporter("C:\\Users\\Lalit\\eclipse-workspace\\Framework\\reports\\newsreport"+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Operating System","windows");
		extent.setSystemInfo("Environment", "QA");
		sparkreporter.config().setReportName("Intergration Test Execution");
		sparkreporter.config().setDocumentTitle("QA Automation Testing Report");
		sparkreporter.config().setTheme(Theme.STANDARD);
		}

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String str) throws InterruptedException
	{
		if(str.equals("chrome"))
		{System.setProperty("webdriver.chrome.driver","D:\\DIPALI\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);

		//test.log(Status.PASS, "URL successfully open");
		}
		else if (str.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\DIPALI\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(baseURL);
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
	public static String captureScreen() throws IOException
	{
		Random random = new Random();
		int y = random.nextInt(2000);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest ="C:\\Users\\Lalit\\eclipse-workspace\\Framework\\screenshot\\newss"+y+".jpg";
		FileUtils.copyFile(source,new File(dest));
		
		return dest;
	}
	
}
