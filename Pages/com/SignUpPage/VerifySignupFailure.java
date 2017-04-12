package com.SignUpPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.LoginPage.LoginPage;
import com.appdirect.nitya.utils.getProperties;

import junit.framework.Assert;

public class VerifySignupFailure {
	WebDriver driver;
	WebDriverWait wait;
	String errorMessageXpath,emailId;
	getProperties prop=new getProperties();
	
	
	public VerifySignupFailure(WebDriver driver) throws MyFileNotFoundException, MyNoSuchElementException{
			this.driver=driver;	
		}
	
    public WebDriver verifySignupFail() throws MyNoSuchElementException, MyFileNotFoundException{
    	    errorMessageXpath=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "errorMessage");
    		if(driver.findElement(By.xpath(errorMessageXpath)).isDisplayed()){
            Reporter.log("Error Message Displayed....This email address has already been registered in our system. Please register with a new email address.",true);
            Assert.assertTrue(true);
    	}
    		return driver;
    	
    }
		
}
