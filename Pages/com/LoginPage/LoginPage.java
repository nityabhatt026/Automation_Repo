package com.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.HomePage.HomePage;
import com.PageChecker.HomePageChecker;
import com.PageChecker.LoginPageChecker;
import com.SignUpPage.SignupPage;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

import junit.framework.Assert;

public class LoginPage {
	
	WebDriver driver;
	String signupPath, navigateBackSignUpPath;
	getProperties prop=new getProperties();
	
	
	public LoginPage(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;
	
	}
	
	public LoginPageChecker loginPageCheckerObject() throws MyNoSuchElementException, MyFileNotFoundException{
		return new LoginPageChecker(driver);
	}
	
	public SignupPage clicksignup() throws MyNoSuchElementException, MyFileNotFoundException{
		signupPath=prop.getPropertyFile("Pages/com/LoginPage/Login.properties", "signupPath");
		driver.findElement(By.xpath(signupPath)).click();
		Reporter.log("Signup Button Clicked",true);
		return new SignupPage(driver);
	}
	
    public SignupPage signupClick() throws MyNoSuchElementException, MyFileNotFoundException{
    	navigateBackSignUpPath=prop.getPropertyFile("Pages/com/LoginPage/Login.properties", "navigateBackSignUpPath");
    	driver.findElement(By.xpath(navigateBackSignUpPath)).click();
    	Reporter.log("Signup Button Clicked again",true);
		return new SignupPage(driver);
    }
	
   

}
