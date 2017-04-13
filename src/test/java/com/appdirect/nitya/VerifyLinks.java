package com.appdirect.nitya;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;
import com.HomePage.HomePage;
import com.LoginPage.LoginPage;
import com.SignUpPage.SignupPage;
import com.SignUpPage.VerifySignupFailure;
import com.SignUpPage.VerifySignupSuccess;
import com.appdirect.nitya.utils.BrowserFactory;
import com.appdirect.nitya.utils.WaitClass;

public class VerifyLinks implements VerifyLinksInterface {
	WaitClass wait;
	WebDriver driver;
	LoginPage loginPage;
	SignupPage signupPage;
	HomePage homePage;
	VerifySignupSuccess signupSuccess;
	VerifySignupFailure signupFailure;

	@BeforeClass
	public void setUp() throws MyNoSuchElementException, MyFileNotFoundException, MyNullPointerException{
		BrowserFactory browserObj =new BrowserFactory(driver);
		driver=browserObj.startBrowser();
		wait = new WaitClass(driver);
	    wait.Wait();  
	    homePage =new HomePage(driver);
	    signupSuccess=homePage
	    	
	    		   .clickLogin()	
	    		   .clicksignup() 
	               .signupID()
		           .submitSignupId(); 
	}
	@Test
	 public void testSignUpSuccess() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException{
		 driver=signupSuccess
		 .successMessage();
	 }
	 
	 @Test
	 public void testSignUpFailure() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException{
		 
		 driver=loginPage
		.signupClick()
		.navigateSignupID()
		.navigateSubmitSignupId()
		.verifySignupFail();
	 }
	 
	 
	 
}
