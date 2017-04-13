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

    @BeforeTest(alwaysRun = true)
    public void openBrowser() throws IOException, MyNoSuchElementException, MyFileNotFoundException{
    	        BrowserFactory browserObj =new BrowserFactory(driver);
		driver=browserObj.startBrowser();
		wait = new WaitClass(driver);
	        wait.Wait();  
	        homePage =new HomePage(driver);
	}
    
    
    @Test
	public void HomePageTest() throws  MyNoSuchElementException, MyFileNotFoundException, MyNullPointerException {
    	
    	       loginPage=homePage
	      .homePageCheckerObject()
	      .homePageStatus()
	      .loginButtonStatus()
	      .clickLogin();  
  }
	
   @Test
   public void LoginPageTest() throws  MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException{
	    
	        signupPage=loginPage
	       .loginPageCheckerObject()
	       .loginPageStatus()
	       .signupButtonStatus()
	       .clicksignup();  
  }

    @Test
   public void SignUpPageTest() throws MyNoSuchElementException, MyNullPointerException, MyFileNotFoundException, MyIOException{
     
    	         signupSuccess= signupPage
                .signupPageCheckerObject()
                .signupPageStatus()
                .signupTextBoxStatus()
                .signupButtonStatus()
                .signupID()
                .submitSignupId(); 
    	
   }
    @Test
	 public void testSignUpSuccess() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException{
		
		 driver=signupSuccess
		 .successMessage();
	 }
	 
	 @Test(dependsOnMethods={"testSignUpSuccess"})
	 public void testSignUpFailure() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException{
		 
		 driver=loginPage
		.signupClick()
		.navigateSignupID()
		.navigateSubmitSignupId()
		.verifySignupFail();
	 }
    
     @AfterSuite(alwaysRun = true)
	 public void endTest(){
		 wait.Wait();
          	driver.close();
		 Reporter.log("Browser Closed");
    }
}
