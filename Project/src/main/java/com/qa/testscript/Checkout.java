package com.qa.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.baseclass.PageClass;
import com.qa.utility.CommonFunction;

public class Checkout extends PageClass{
	public static void CheckTotal() throws InterruptedException, IOException
	{
		CommonFunction.explicitwait("//a[@title='View my shopping cart']",20);
		WebElement element4 = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		Actions ac4 = new Actions(driver);
		ac4.moveToElement(element4).build().perform();
		CommonFunction.capture("Hover over cart");
		CommonFunction.explicitwait("//a[@id='button_order_cart']",20);
		driver.findElement(By.xpath("//a[@id='button_order_cart']")).click();
		System.out.println("Checked out successfully");
		Thread.sleep(2000);
		//Check total cost
		String prod1 = driver.findElement(By.xpath("(//tr[@class='cart_total_price']/td)[3]")).getText();
		String substr1 = prod1.substring(1);
		float items = Float.parseFloat(substr1);
		//Get cost for shipping
		String shipping = driver.findElement(By.xpath("(//tr[@class='cart_total_delivery']/td)[2]")).getText();
		String substr2 = shipping.substring(1);
		float shipcharge = Float.parseFloat(substr2);
		float calculate = items + shipcharge;
		//Getting overall total
		String total = driver.findElement(By.xpath("//td[@id='total_price_container']/span")).getText();
		String substr3 = total.substring(1);
		float carttotal = Float.parseFloat(substr3);
		CommonFunction.capture("Items in cart");
		System.out.println("Checking the cart");
		//Using assertion to check
		Assert.assertEquals(carttotal, calculate);
		System.out.println("Verified cart total successfully");
		Thread.sleep(3000);
	}

}
