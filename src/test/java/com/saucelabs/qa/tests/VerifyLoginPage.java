package com.saucelabs.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginPage extends BaseTest {
		   
	       //1. ->  Login with locked-out-user
		
		@Test
		public void Verify_Login()
		{
	       
	       WebElement Username = driver.findElement(By.id("user-name"));
	       Username.sendKeys("locked_out_user");
	       
	       WebElement Password = driver.findElement(By.id("password"));
	       Password.sendKeys("secret_sauce");
	       
	       WebElement Login_Btn = driver.findElement(By.id("login-button"));
	       Login_Btn.click();
	       
	       String expected = "Epic sadface: Sorry, this user has been locked out.";
	       WebElement m = driver.findElement(By.xpath("//button[@class='error-button']"));
	       String actual = m.getText();
	       System.out.println("Error message is: "+ actual);
	       Assert.assertEquals(expected, actual);
	       driver.quit();
	       
	      }

}
