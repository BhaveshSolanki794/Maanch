package com.Maanch.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login {
		
	WebDriver ldriver;
	
	public Login(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Login/Sign up")
	WebElement login;
	
	@FindBy(id = "email")
	WebElement Email;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div/div/section/div/div/div/h2")
	WebElement Welcomemsg;
	
	@FindBy(xpath = "//strong[text() = 'These credentials do not match our records.']")
	WebElement Emailerr;
	
	@FindBy(linkText = "Forgot Password?")
	WebElement ForgotPass;
	
	@FindBy(id = "dropdownMenuLink")
	WebElement dropdownlink;
	
	public void Login() {
		login.click();
	}

	
	public void EnterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void EnterPassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void LoginButton() {
		loginButton.click();
	}
	
	public String Welcome() {
		String wel = Welcomemsg.getText();
		return wel;
	}
	
	public String Emailerror() {
		String err = Emailerr.getText();
		return err;
	}
	
	public void ForgotPasswordLink() {
		ForgotPass.click();
	}
	
	public String EmptyFieldError() {
		String err = Email.getAttribute("validationMessage");
		return err;
	}
	
	public void Dropdown() {
		Select dropdown = new Select(dropdownlink);
		dropdown.selectByVisibleText("Logout");
	}
}
