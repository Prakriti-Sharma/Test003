package com.qa.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class PageClass {
		public static ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReportTest.html");
		public static WebDriver driver;
		@BeforeSuite()
		public void start()
		{	
			extent.attachReporter(spark);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//java//com//qa//resources//chromedriver");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		@AfterSuite
		public void end()
		{
			extent.flush();
			driver.close();
		}

	}
