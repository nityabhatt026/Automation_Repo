package com.SignUpPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

import junit.framework.Assert;

public class VerifySignupSuccess {
	WebDriver driver;
	WaitClass wait=new WaitClass(driver);
	getProperties prop=new getProperties();
	public VerifySignupSuccess(WebDriver driver) throws MyFileNotFoundException, MyNoSuchElementException{
			this.driver=driver;
		}
		
	public WebDriver successMessage() throws MyNoSuchElementException, MyFileNotFoundException{
        wait.waitVisibilityConditionByCss(".signupConfirmationPanel", driver);
		if(driver.findElement(By.cssSelector(".signupConfirmationPanel")).isDisplayed()){
        Reporter.log("Success Message Displayed.... Thanks for registering.We have sent a verification email to your signup email id."
        		+ "Please check your inbox and click the link to activate your account.",true);
        Assert.assertTrue(true);
	}   
		driver.navigate().back();
		return driver;
   }
	
}
