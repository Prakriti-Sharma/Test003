package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.baseclass.PageClass;
import com.qa.testscript.Login;

public class Test001 extends PageClass{
	
	@Test (priority= 1)
	public void method1() throws InterruptedException, IOException
	{
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		Login.LoginAcc();	
		Thread.sleep(5000);
		ExtentTest test = extent.createTest("Login"); 
		test.log(Status.INFO, "User logged in").assignAuthor("Prakriti").assignDevice("MAC");
		WebElement accholder = driver.findElement(By.xpath("//a[@class='account']/span"));
		String ActualName = accholder.getText();
		if(ActualName.equals("Prakriti Sharma"))
		{
			test.pass("correct user logged in");	
			//System.out.println("Login Success");
		}
		else
		{
			//System.out.println("Login Failure"); 
			Assert.fail("Login Failure");
		}
	}

}
