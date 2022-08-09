package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.baseclass.PageClass;
import com.qa.utility.CommonFunction;

public class AddDress extends PageClass{
	public static void NewDress() throws InterruptedException, IOException
	{
		CommonFunction.explicitwait("//a[@title='Women']",20);
		CommonFunction.capture("After Login");
		WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		Thread.sleep(3000);
		List<WebElement> x = driver.findElements(By.xpath("//a[@title='Summer Dresses']"));
		x.get(0).click();
		Thread.sleep(2000);
		//Select dress with size M
		driver.findElement(By.xpath("//div[@id='uniform-layered_id_attribute_group_2']")).click();
		Thread.sleep(2000);
		WebElement y = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select s = new Select(y);
		s.selectByIndex(1);
		CommonFunction.capture("Filtering criteria");
		System.out.println("Filters applied successfully");
		//Add dress1 to cart
		Thread.sleep(3000);
		AddDress.AddCartItem(1);
		//Add dress2 to cart
		Thread.sleep(3000);
		AddDress.AddCartItem(3);
		System.out.println("2 dresses added to the cart successfully");
	}
	public static void AddCartItem(int i) throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("(//a[@class='product_img_link'])["+i+"]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title='Add to cart'])["+i+"]")).click();
		CommonFunction.explicitwait("//span[@title='Continue shopping']",20);
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
		Thread.sleep(2000);
	}
}
