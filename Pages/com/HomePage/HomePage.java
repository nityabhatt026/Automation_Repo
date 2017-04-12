package com.HomePage;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.LoginPage.LoginPage;
import com.PageChecker.HomePageChecker;
import com.appdirect.nitya.utils.WaitClass;
import com.appdirect.nitya.utils.getProperties;

public class HomePage {
	WebDriver driver;
	String loginXpath;
	getProperties prop=new getProperties();
	
	
	public HomePage(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException{
		this.driver=driver;
		
	}
	public HomePageChecker homePageCheckerObject() throws MyNoSuchElementException, MyFileNotFoundException{
		return new HomePageChecker(driver);
	}
	public LoginPage clickLogin() throws MyNoSuchElementException, MyFileNotFoundException {
		loginXpath=prop.getPropertyFile("Pages/com/HomePage/home.properties", "loginPath");
		driver.findElement(By.xpath(loginXpath)).click();
		Reporter.log("login button clicked",true);
		return new LoginPage(driver);
	}   
}
