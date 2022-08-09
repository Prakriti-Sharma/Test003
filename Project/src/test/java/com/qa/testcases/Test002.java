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
import com.qa.testscript.AddDress;

public class Test002 extends PageClass{
	
	@Test(priority=2)
	public static void method2() throws InterruptedException, IOException
	{
		AddDress.NewDress();
		ExtentTest test = extent.createTest("Add Dresses"); 
		test.log(Status.INFO, "Dress Added").assignAuthor("Prakriti").assignDevice("MAC");
		WebElement Cart = driver.findElement(By.xpath("(//a[@title='View my shopping cart']/span)[1]"));
		String CartActual = Cart.getText();
		if(CartActual.equals("2"))
		{
			test.pass("Dress added successfully");
			//System.out.println("Dresses added successfully");	
		}
		else
		{
			//System.out.println("Dresses not added to Cart");	
			Assert.fail("Dresses not added to Cart");
		}
	}
}
