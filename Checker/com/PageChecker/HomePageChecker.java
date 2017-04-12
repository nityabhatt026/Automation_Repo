package com.PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.HomePage.HomePage;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

public class HomePageChecker {
	WebDriver driver;
	WaitClass wc=new WaitClass(driver);
	getProperties prop=new getProperties();
	String loginXpath;
	public HomePageChecker(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;
		
		
	}
    public HomePage loginButtonStatus() throws MyNoSuchElementException, MyFileNotFoundException{
    	loginXpath=prop.getPropertyFile("Pages/com/HomePage/home.properties", "loginPath");
		wc.waitVisibilityConditionByXpath(loginXpath,driver);
		boolean buttonStatus=driver.findElement(By.xpath(loginXpath)).isDisplayed();
		if(buttonStatus==true){
		Assert.assertTrue(buttonStatus, "Login Button Exist");
		Reporter.log("Login Button Exist",true);
		}
		else{
		Assert.assertFalse(buttonStatus, "Login Button Doesn't Exist");	
		Reporter.log("Login Button doesn't Exist",true);
		}
		return new HomePage(driver);
	}
   public HomePageChecker homePageStatus() throws MyNoSuchElementException, MyFileNotFoundException{
    String title= driver.getTitle();
    if(title==null){
    	Reporter.log("homepage title not found in checkers in exception handling",true);
        throw new NullPointerException("home page title not found in checkers in exception handling");
    }
    else{
	Assert.assertEquals(title, "AppDirect","HomePage Title Mismatch");
	Reporter.log("Verified the home page",true);
    }
    return new HomePageChecker(driver);
}	
}
