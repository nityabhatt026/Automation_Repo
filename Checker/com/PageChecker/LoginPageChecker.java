package com.PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;
import com.LoginPage.LoginPage;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

import junit.framework.Assert;

public class LoginPageChecker {
	WebDriver driver;
	String signupPath;
	WaitClass wc=new WaitClass(driver);
	getProperties prop=new getProperties();
	
	
	public LoginPageChecker(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;
	}
	
    public LoginPage signupButtonStatus() throws MyNoSuchElementException, MyFileNotFoundException{
    	signupPath=prop.getPropertyFile("Pages/com/LoginPage/Login.properties", "signupPath");
		boolean buttonStatus=driver.findElement(By.xpath(signupPath)).isDisplayed();
		if(buttonStatus==true){
		Assert.assertTrue("SignUp Button Exist", buttonStatus);
		Reporter.log("SignUp Button Exist",true);
		}
		else{
		Assert.assertFalse("SignUp Button Doesn't Exist", buttonStatus);	
		Reporter.log("SignUp Button doesn't Exist",false);
		}
		return new LoginPage(driver);
	}

    public LoginPageChecker LoginPageStatus() throws MyNullPointerException, MyNoSuchElementException, MyFileNotFoundException{
    	signupPath=prop.getPropertyFile("Pages/com/LoginPage/Login.properties", "signupPath");
    	wc.waitVisibilityConditionByXpath(signupPath,driver);
	    String orignalTitle="Log In | AppDirect";
	    String title= driver.getTitle();
	    if(title==null){
		Reporter.log("login page title not found in checker in exception handling",true);
		throw new MyNullPointerException("login page title not found in checker in exception handling");
    	}
	    else{
		Assert.assertEquals(title, orignalTitle);
	    Reporter.log("Login Page Displayed",true);
	    }
        return new LoginPageChecker(driver);
}
}
