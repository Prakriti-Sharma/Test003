package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.baseclass.PageClass;

public class CommonFunction extends PageClass{
	public static String filename;
	public static void capture(String FileName) throws IOException
	{
		try {
				File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(File,new File(System.getProperty("user.dir") +"//Screenshots//" + FileName + ".png"));
		} 
		catch (WebDriverException e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		} 
	}
	public static void explicitwait(String Path, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Path)));
	}
}
