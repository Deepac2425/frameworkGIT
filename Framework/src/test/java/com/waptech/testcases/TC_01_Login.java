package com.waptech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.waptech.pages.BaseClass;
import com.waptech.pages.LoginPage;

public class TC_01_Login extends BaseClass {

	@Test
	public void login() throws InterruptedException {
		logger = report.createTest("Login to the Application");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		lp.loginToApplication(excel.getStringData("TC_01_Login", 0, 0), excel.getStringData("TC_01_Login", 0, 1));
		logger.pass("Login done successfully");

	}
	
	@Test
	public void login2() throws InterruptedException {
		logger = report.createTest("Login to the Application");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		lp.loginToApplication(excel.getStringData("TC_01_Login", 0, 0), excel.getStringData("TC_01_Login", 0, 1));
		logger.pass("Login done successfully");

	}
}
