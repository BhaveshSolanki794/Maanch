package com.Maanch.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Maanch.pageObjects.Register;
import com.Maanch.utilities.Readconfig;

public class TC_Register extends BaseClass {
	
	Readconfig config = new Readconfig();
	public String url = config.getBaseUrl();
	

	@Test(priority = 7)
	public void TC_RF_001() {
		
		String ExpectedUrl = "http://demo.maanch.com/dashboard";
		
		Register register = new Register(driver);

		register.Signup();

		register.Entername("Bhavyaa");

		register.EnterEmail("Bhavya62353723@gmail.com");

		register.Enterpassword("Vaccine2020");

		register.EnterConfirmpass("Vaccine2020");

		register.RegisterButton();
		
		String CurrentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(ExpectedUrl, CurrentUrl);

	}



	@Test(priority = 1)
	public void TC_RF_002() {
		
		driver.get(url);
		
		Register register = new Register(driver);

		
		String expectedErrorMsg = "The password confirmation does not match.";

		register.Signup();

		register.Entername("Bhavya");

		register.EnterEmail("Bhaveshsola451@gmail.com");

		register.Enterpassword("abc1234");

		register.EnterConfirmpass("def4576");

		register.RegisterButton();
		
		String errorMsg = register.ErrorMsg();
		
		System.out.println(errorMsg);
		
		Assert.assertTrue(errorMsg.contains(expectedErrorMsg), "Test Case Passed");

	}
	
	@Test(priority = 2)
	public void TC_RF_003() {
		
		Register register = new Register(driver);

		
		String expectedErrorMsg = "The email has already been taken.";

		register.Signup();

		register.Entername("Bhavya");

		register.EnterEmail("Bhaveshsolanki794@gmail.com");

		register.Enterpassword("Vaccine2021");

		register.EnterConfirmpass("Vaccine2021");

		register.RegisterButton();
		
		String errorMsg = register.EmailIdErrorMsg();
		
		System.out.println(errorMsg);
		
		Assert.assertTrue(errorMsg.contains(expectedErrorMsg), "Test Case Passed");

	}
	
	@Test(priority = 8 )
	public void TC_RF_004() {
		
		Register register = new Register(driver);

		
		String expectedErrorMsg = "The email is invalid";

		register.Signup();

		register.Entername("Bhavya");

		register.EnterEmail("Bhaveshso5630@gil.com");

		register.Enterpassword("Vaccine2021");

		register.EnterConfirmpass("Vaccine2021");

		register.RegisterButton();
		
		String errorMsg = register.EmailIdErrorMsg();
		
		System.out.println(errorMsg);
		
		Assert.assertTrue(errorMsg.contains(expectedErrorMsg), "Test Case Failed");

	}
	
	@Test(priority = 3)
	public void TC_RF_006() {
		
		Register register = new Register(driver);

		
		String ExpectedMsg = "Please fill out this field.";

		register.Signup();

		register.RegisterButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Assert.assertTrue(ExpectedMsg.contains(register.ValidationMsg()), "Test case Passed");


	}
	
	@Test(priority = 4)
	public void TC_RF_007() {
		
		Register register = new Register(driver);

		
		String ExpectedMsg = "Please enter complex password";

		register.Signup();
		
		register.Entername("Bhavesh");
		
		register.EnterEmail("Bhavesh098vh7@gmail.com");

		register.Enterpassword("1234567");
		
		register.EnterConfirmpass("1234567");
		
		register.RegisterButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Assert.assertTrue(ExpectedMsg.contains(register.ErrorMsg()), "Test case Passed");


	}
	
	
	@Test(priority = 5)
	public void TC_RF_008() {
		
		Register register = new Register(driver);
		
		driver.get(url);
		
		String msg = "Enter only Alphabets";

		register.Signup();
		
		register.Entername("12345");
		
		register.EnterEmail("Bhavesh0989587@gmail.com");

		register.Enterpassword("asdf123");
		
		register.EnterConfirmpass("asdf123");
		
		register.RegisterButton();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Assert.assertTrue(msg.contains(register.WelcomeMsg()));


	}

	
	@Test(priority = 6)
	public void TC_RF_009() throws InterruptedException {
		
		Register register = new Register(driver);


		register.Signup();
		
		register.VerifyLinks();
		
	}
	
}
