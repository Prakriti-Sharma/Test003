package com.qa.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;


import com.qa.baseclass.PageClass;
import com.qa.utility.CommonFunction;

public class Login extends PageClass{
	public static void LoginAcc() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		//reading data from excel
		File obj1= new File((System.getProperty("user.dir") +"//src//main//java//com//qa//resources//Credentials.xlsx"));
		FileInputStream creds = new FileInputStream(obj1);
		XSSFWorkbook workbook = new XSSFWorkbook(creds);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String data1 = sheet.getRow(2).getCell(0).getStringCellValue();
		String data2 = sheet.getRow(2).getCell(1).getStringCellValue();
		CommonFunction.explicitwait("//input[@id='email']",20);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(data1);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(data2);
		CommonFunction.capture("LoginPage");
		CommonFunction.explicitwait("//button[@name='SubmitLogin']",20);
		driver.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
		System.out.println("User logged in successfully");
	}
}
