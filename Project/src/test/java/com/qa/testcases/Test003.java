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
import com.qa.testscript.Checkout;

public class Test003 extends PageClass{
	
	@Test(priority=3)
	public static void method3() throws InterruptedException, IOException
	{
		Checkout.CheckTotal();
		ExtentTest test = extent.createTest("Checkout"); 
		test.log(Status.INFO, "Cart checkout").assignAuthor("Prakriti").assignDevice("MAC");
		WebElement Checkout1 = driver.findElement(By.xpath("//a[@title='Proceed to checkout' and  contains(@class,'standard-checkout')]"));
		String ActualCheckout = Checkout1.getText();
		if(ActualCheckout.equals("Proceed to checkout"))
		{
			test.pass("Cart checkout reached");
			//System.out.println("Cart checkout reached");	
		}
		else
		{
			//System.out.println("Cart checkout not reached");	
			Assert.fail("Cart checkout not reached");
		}
	}
}
