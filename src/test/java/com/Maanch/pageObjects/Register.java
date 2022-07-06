package com.Maanch.pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	
	WebDriver ldriver;
	
	public Register(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(linkText = "Login/Sign up")
	WebElement SignupButton;
	
	@FindBy(id = "name")
	WebElement User_name;
	
	@FindBy(id = "reg-email")
	WebElement email;
	
	@FindBy(id = "reg-password")
	WebElement password;
	
	@FindBy(id = "password-confirm")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//button[@class='btn btn-grad col-6 mt-2']")
	WebElement regButton;
	
	@FindBy(xpath = "//strong[text() = 'The password confirmation does not match.']")
	WebElement Errormsg;
	
	@FindBy(xpath = "//strong[text() = 'The email has already been taken.']")
	WebElement EmailErrormsg;

	
	@FindBy(xpath = "/html/body/div/div/section/div/div/div/h2")
	WebElement WelcomeMsg;
	
	@FindBy(tagName = "a")
	List<WebElement> allLinks;
	
	@FindBy(linkText = "Forgot Password?")
	WebElement passwordLink;
	
	public void Signup() {
		SignupButton.click();
	}

	public void Entername(String name) {
		User_name.sendKeys(name);
	}
	
	public void EnterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void Enterpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void EnterConfirmpass(String confirmpass) {
		confirmpassword.sendKeys(confirmpass);
	}
	
	public void RegisterButton() {
		regButton.click();
	}

	public String ErrorMsg() {
		String ErrorMessage = Errormsg.getText();
		return ErrorMessage;
	}
	
	public String EmailIdErrorMsg() {
		String EmailMessage = EmailErrormsg.getText();
		return EmailMessage;
	}
	
	public String ValidationMsg() {
		String validMsg = User_name.getAttribute("validationMessage");
		return validMsg;
	}
	
	public String WelcomeMsg() {
		String welMsg = WelcomeMsg.getText();
		return welMsg;
	}
	

	public void VerifyLinks() throws InterruptedException {
		//int respCode =200;
		
		System.out.println(allLinks.size());
		
		for(int i=0; i<=allLinks.size(); i++) {
			
			WebElement element = allLinks.get(i);
			String url = element.getAttribute("href");
			String urlname = element.getText();
			
			
				try {
					HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
					Thread.sleep(2000);
					huc.connect();
					int respcode = huc.getResponseCode();
					
					if(respcode>=400) {
						System.out.println(urlname+ " is a broken link");
					}else {
						System.out.println(urlname + " is a valid link");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(urlname + " is empty");
				}
				
			
			
			
		}
	}
}






















