package com.saucelabs.qa.tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest extends BaseTest {
	   
       //1. ->  Login as Standard User
	
	@Test(priority =1)
	
	public void Login()
	{
       
       WebElement Username = driver.findElement(By.id("user-name"));
       Username.sendKeys("standard_user");
       

       WebElement Password = driver.findElement(By.id("password"));
       Password.sendKeys("secret_sauce");
       
       WebElement Login_Btn = driver.findElement(By.id("login-button"));
       Login_Btn.click();
       
	}
       
       //2. -> Add random items to the cart (at least three)
	
	@Test(priority = 2)
	
	public void Add_Random_Items()
	{
	
       WebElement SauceLab_Backpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
       SauceLab_Backpack.click();
       
       WebElement SauceLab_bikeLight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
       SauceLab_bikeLight.click();
       
       WebElement SauceLab_Jacket = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
       SauceLab_Jacket.click();
       
	}
       
       //3. -> Go To The Cart
	
	@Test(priority = 3)
	
	public void Add_To_Cart()
	
	{
       WebElement Cart_btn = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
       Cart_btn.click();
       
	}
       
       //4. -> Remove Second item Element
	
	@Test(priority = 4)
	
	public void Remove_Second_Item()
	{
       
       WebElement SauceLab_bikeLight_remove = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
       SauceLab_bikeLight_remove.click();
     
	}
       //5. -> Proceed with checkout 
	
	@Test(priority = 5)
	
	public void Checkout()
	{
       
        WebElement Checkout_btn = driver.findElement(By.id("checkout"));
        Checkout_btn.click();
	}
        
        //6. Fill the details and continue
	
	@Test(priority = 6)
	
	public void Fill_Details()
	{
        
        WebElement First_name = driver.findElement(By.id("first-name"));
        First_name.sendKeys("Ravi");
        
        WebElement Last_Name = driver.findElement(By.id("last-name"));
        Last_Name.sendKeys("Kumar");
        
        WebElement Zip_code = driver.findElement(By.id("postal-code"));
        Zip_code.sendKeys("201301");
        
        WebElement Continue_btn = driver.findElement(By.id("continue"));
        Continue_btn.click();
        
	}
        
        //7. ->  Verify the payment Information 
	
	@Test (priority = 7)
	
	public void Payment_Information()
	{
		String expected = "SauceCard #31337";
	       WebElement m = driver.findElement(By.xpath("//div[@class='summary_value_label'] [1]"));
	       String actual = m.getText();
	       System.out.println("Error message is: "+ actual);
	       Assert.assertEquals(expected, actual);
	       
	}
	
	
	
	//8. ->  Verify the Price
	@Test (priority = 8)
	public void Verify_Price()
	{
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();
			product_price = list_of_products_price.get(i).getText();
			product_price = product_price.replaceAll("[^0-9]", "");
			int_product_price = Integer.parseInt(product_price);
			map_final_products.put(int_product_price,product_name);
		}
		
	}
	

	//9. -> Click on Finish
       @Test (priority = 9)
	public void finish_button()
	{
	
		  WebElement finish_btn = driver.findElement(By.id("finish"));
		  finish_btn.click();
		  
	}
	
	
    //10. -> Verify the text message and the Image.
	
	@Test (priority = 10)
	
	public void Verify_text_msg()
	{
	
	String text_msg = driver.findElement(By.xpath("//div[@class='complete-text']")).getText(); 
	assertTrue(text_msg.contains("Your order has been dispatched"));
	
	WebElement SauceLabs_Image = driver.findElement(By.xpath("//img[@src='/static/media/pony-express.46394a5d.png']"));
	
	//Verify the Image is dispalyed or not
	
	if(SauceLabs_Image.isDisplayed())
	{
		System.out.println("Image is displayed");
	}
	
	else
	{
		System.out.print("Image is not dispalyed");
	}
	
}
	}
	

