package com.waptech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(name="firstName") WebElement un;
	@FindBy(name="lastName") WebElement pwd;
	@FindBy(xpath="//input[@type='submit']") WebElement loginButton;
	
	public void loginToApplication(String userName,String pw) throws InterruptedException {
		Thread.sleep(5000);
		un.sendKeys(userName);
		pwd.sendKeys(pw);
		Thread.sleep(5000);
		//loginButton.click();
		
	}

}
