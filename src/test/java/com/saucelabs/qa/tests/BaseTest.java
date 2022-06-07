package com.saucelabs.qa.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest {

		public WebDriver driver;

		@Parameters({ "browser", "url" })
		@BeforeTest
		public void setUp(String browserName, String url) {

			switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			
			default:
				System.out.println("please pass the right browser name....");
				break;
			}
			driver.get(url);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}

	}


