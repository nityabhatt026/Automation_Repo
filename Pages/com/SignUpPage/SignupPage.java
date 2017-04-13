package com.SignUpPage;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.PageChecker.SignupPageChecker;
import com.appdirect.nitya.VerifyLinks;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

public class SignupPage {
	WebDriver driver;
	String signupTextboxPath,
	signupButton,
	navigateSignupTextboxPath, 
	navigateSignupButton;
	static String signupId;
	WaitClass wait=new WaitClass(driver);
	getProperties prop=new getProperties();

	public SignupPage(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;	
	}
	
	public SignupPageChecker signupPageCheckerObject() throws MyNoSuchElementException, MyFileNotFoundException{
		return new SignupPageChecker(driver);
	}
	public SignupPage signupID() throws MyNoSuchElementException, MyFileNotFoundException{
	  signupId = (RandomStringUtils.randomAlphabetic(5, 10)+"."+RandomStringUtils.randomAlphabetic(5,10)+"@yopmail.com").toLowerCase();
		Reporter.log(signupId,true);
		signupTextboxPath=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "signupTextboxPath");
		driver.findElement(By.cssSelector(signupTextboxPath)).sendKeys(signupId);
		return new SignupPage(driver);
	}
   
   public SignupPage navigateSignupID() throws MyNoSuchElementException, MyFileNotFoundException{
	    wait.waitVisibilityConditionByCss(navigateSignupTextboxPath, driver);
	    System.out.println("redtfygvhbjkn");
	    navigateSignupTextboxPath=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "navigateSignupTextboxPath");
	    driver.findElement(By.cssSelector(navigateSignupTextboxPath)).sendKeys(signupId);  
	    System.out.println("wdfvbredtfygvhbjkn");
	    return new SignupPage(driver);
	   
   }
   public VerifySignupSuccess submitSignupId() throws MyNoSuchElementException, MyFileNotFoundException{
	   signupButton=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "signupButton");
	   Reporter.log("Clicked on Signup",true);
	   driver.findElement(By.cssSelector(signupButton)).click(); 
	   return new VerifySignupSuccess(driver);
   }
   
public VerifySignupFailure navigateSubmitSignupId() throws MyNoSuchElementException, MyFileNotFoundException{
	   
	   Reporter.log("Clicked on the final Signup again ",true);
	   navigateSignupButton=prop.getPropertyFile("Pages/com/SignUpPage/SignUp.properties", "navigateSignupButton");
	   driver.findElement(By.cssSelector(navigateSignupButton)).click(); 
	   return new VerifySignupFailure(driver);
   }
   
   
}
