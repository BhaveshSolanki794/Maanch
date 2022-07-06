package com.Maanch.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.Maanch.pageObjects.Login;
import com.Maanch.pageObjects.Register;
import com.Maanch.utilities.Readconfig;

public class TC_Login extends BaseClass{
	
	Login login = new Login(driver);
	
	Readconfig config = new Readconfig();
	public String url = config.getBaseUrl();

	
	@Test(priority = 6)
	public void TC_LI_001() {
		
		driver.get(url);
		
		login = new Login(driver);
		
		String ExpectUrl = "http://demo.maanch.com/dashboard";
		
		login.Login();
		
		login.EnterEmail("Bhaveshsolanki794@gmail.com");
		
		login.EnterPassword("Vaccine2021");
		
		login.LoginButton();
		
		String CurrentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(ExpectUrl, CurrentUrl);

		
	}
	
	@Test(priority = 1)
	public void TC_LI_002() {
		
		Login login = new Login(driver);
		
		driver.get(url);
		
		String Expectmsg = " These credentials do not match our records.";
		
		login.Login();
		
		login.EnterEmail("Bha794@gmail.com");
		
		login.EnterPassword("Vine2021");
		
		login.LoginButton();
		
		Assert.assertTrue(Expectmsg.contains(login.Emailerror()));
	}
	
	@Test(priority = 2)
	public void TC_LI_003() {
		
		Login login = new Login(driver);
		
		String Expectmsg = " These credentials do not match our records.";
		
		login.Login();
		
		login.EnterEmail("Bhaveshsolanki794@gmail.com");
		
		login.EnterPassword("Vine202122");
		
		login.LoginButton();
		
		Assert.assertTrue(Expectmsg.contains(login.Emailerror()));
	}
	
	@Test(priority = 3)
	public void TC_LI_004() {
		
		Login login = new Login(driver);
		
		String Expectmsg = " These credentials do not match our records.";
		
		login.Login();
		
		login.EnterEmail("solanki94@gmail.com");
		
		login.EnterPassword("Vaccine2021");
		
		login.LoginButton();
		
		Assert.assertTrue(Expectmsg.contains(login.Emailerror()));
	}
	
	@Test(priority = 4 )
	public void TC_LI_005() {
		
		Login login = new Login(driver);
		
		String Expectmsg = "Please fill out this field.";
		
		login.Login();
		
		login.LoginButton();
		
		Assert.assertTrue(Expectmsg.equals(login.EmptyFieldError()));
	}
	
	@Test (priority = 5)
	public void TC_LI_006() {
		
		Login login = new Login(driver);
		
		String Expecturl = "http://demo.maanch.com/password/reset";
		
		login.Login();
		
		login.ForgotPasswordLink();
		
		String currenturl = driver.getCurrentUrl();
		
		Assert.assertEquals(Expecturl, currenturl);
	}
	
	@Test (priority = 7)
	public void TC_LI_008() {
		
		Login login = new Login(driver);
		
		String ExpectUrl = "http://demo.maanch.com/dashboard";
		
        login.Login();
		
		login.EnterEmail("Bhaveshsolanki794@gmail.com");
		
		login.EnterPassword("Vaccine2021");
		
		login.LoginButton();
		
		driver.navigate().back();
		
		String Currenturl = driver.getCurrentUrl();
		
		Assert.assertEquals(Currenturl, ExpectUrl);
	}
	
	@Test (priority = 8)
	public void TC_LI_009() throws InterruptedException {
		
		Login login = new Login(driver);
		
		String ExpectUrl = "http://demo.maanch.com/dashboard";
		
        login.Login();
		
		login.EnterEmail("Bhaveshsolanki794@gmail.com");
		
		login.EnterPassword("Vaccine2021");
		
		login.LoginButton();
		
		Thread.sleep(8000);
		
		login.Dropdown();
		
		String currentUrl = driver.getCurrentUrl();
		
		driver.navigate().back();
		
		Assert.assertEquals(currentUrl, ExpectUrl);
	}
	
	@Test (priority = 9)
	public void TC_LI_010() throws InterruptedException {
		
		Login login = new Login(driver);
		
		String ExpectUrl = "http://demo.maanch.com/dashboard";
		
		login.Login();
		
		login.EnterEmail("Bhaveshsolanki794@gmail.com");
		
		login.EnterPassword("Vaccine2021");
		
		login.LoginButton();
		
		Thread.sleep(8000);
		
		driver.close();
		
		driver.get(url);
		
		login.Login();
		
		String CurrentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(ExpectUrl, CurrentUrl);
	}

	

}
