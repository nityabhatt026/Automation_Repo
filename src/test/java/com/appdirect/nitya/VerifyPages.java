package com.appdirect.nitya;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;
import com.HomePage.HomePage;
import com.LoginPage.LoginPage;
import com.SignUpPage.SignupPage;
import com.SignUpPage.VerifySignupSuccess;
import com.appdirect.nitya.utils.BrowserFactory;
import com.appdirect.nitya.utils.WaitClass;

public class VerifyPages implements VerifyPageInterface{
	LoginPage loginPage;
	SignupPage signupPage;
	HomePage homePage;
	WebDriver driver;
	WaitClass wait;
	VerifySignupSuccess signupSuccess;
	VerifyLinks verify;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() throws IOException, MyNoSuchElementException, MyFileNotFoundException{
    	BrowserFactory browserObj =new BrowserFactory(driver);
		driver=browserObj.startBrowser();
		wait = new WaitClass(driver);
	    wait.Wait();  
	    homePage =new HomePage(driver);
	}
    
    
    @Test(priority=1)
	public void HomePageTest() throws  MyNoSuchElementException, MyFileNotFoundException, MyNullPointerException {
    	
    	loginPage=homePage
	   .homePageCheckerObject()
	   .homePageStatus()
	   .loginButtonStatus()
	   .clickLogin();  
  }
	
   @Test(priority=2)
   public void LoginPageTest() throws  MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException{
	    
	   signupPage=loginPage
	   .loginPageCheckerObject()
	   .LoginPageStatus()
	   .signupButtonStatus()
	   .clicksignup();  
  }

    @Test(priority=3)
   public void SignUpPageTest() throws MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException, MyIOException{
     
    	verify=signupPage
       .signupPageCheckerObject()
       .signupPageStatus()
       .signupTextBoxStatus()
       .signupButtonStatus()
       .signupID()
	   .submitSignupId(); 
    	
    	verify.testSignUpSuccess();
   }


	
    
    @AfterSuite(alwaysRun = true)
	 public void endTest(){
		wait.Wait();
     	driver.close(); 
    }
}
