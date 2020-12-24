package com.waptech.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {
	
	public static String captureScreenShot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir")+"/Screenshots/applicationName_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src,new File(screenshot));
		} catch (Exception e) {
			System.out.println("Unable to capture Screenshot >> "+e.getMessage());
		}
		System.out.println("Screen shot captured!");
		return screenshot;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

}
