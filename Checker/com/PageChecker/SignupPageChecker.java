package com.PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.SignUpPage.SignupPage;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

import junit.framework.Assert;

public class SignupPageChecker {
	
	WebDriver driver;
	String signupTextboxPath;
	String signupButton;
	WaitClass wc=new WaitClass(driver);
	getProperties prop=new getProperties();
	public SignupPageChecker(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;
		
		
		
	}
	public SignupPageChecker signupPageStatus() throws MyNoSuchElementException, MyFileNotFoundException{
		signupTextboxPath=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "signupTextboxPath");
		wc.waitVisibilityConditionByCss(signupTextboxPath,driver);
	    Assert.assertTrue(driver.getTitle().contains("Sign Up for AppDirect"));
	    Reporter.log("Verified the signup page",true);
	    return new SignupPageChecker(driver);
	}
	
    public SignupPageChecker signupTextBoxStatus() throws MyNoSuchElementException, MyFileNotFoundException{
    	signupTextboxPath=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "signupTextboxPath");
		boolean status=driver.findElement(By.cssSelector(signupTextboxPath)).isDisplayed();
		if(status==true){
		Assert.assertTrue("SignUp Text Box Exist", status);
		Reporter.log("SignUp Text Box Exist",true);
		}
		else{
		Assert.assertFalse("SignUp  Text Box Doesn't Exist", status);	
		Reporter.log("SignUp  Text Box doesn't Exist",false);
		}
		return new SignupPageChecker(driver);
	}

	public SignupPage signupButtonStatus() throws MyNoSuchElementException, MyFileNotFoundException{
		signupButton=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "signupButton");
		boolean status=driver.findElement(By.cssSelector(signupButton)).isDisplayed();
		if(status==true){
		Assert.assertTrue("SignUp submit Button Exist", status);
		Reporter.log("SignUp submit Button Exist",true);
		}
		else{
		Assert.assertFalse("SignUp submit Button Doesn't Exist", status);	
		Reporter.log("SignUp submit Button doesn't Exist",false);
		}
		
		return new SignupPage(driver);
	}
}
