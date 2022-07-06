package com.Maanch.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Maanch.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	Readconfig config = new Readconfig();
	public String url = config.getBaseUrl();
	public String username = config.getUsername();
	public String password = config.getPassword();
	public String browser = config.getChromePath();
	public static WebDriver driver;
	
	
	@BeforeClass
	public void Setup() {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		System.out.println("Hiii");
				
		
	}
	
//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
	

}
