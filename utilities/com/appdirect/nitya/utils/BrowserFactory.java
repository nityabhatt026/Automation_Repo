package com.appdirect.nitya.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.HomePage.HomePage;
import com.PageChecker.BrowserChecker;

import junit.framework.Assert;

public class BrowserFactory implements BrowserFactoryInterface{
	static WebDriver driver;
	public BrowserFactory(WebDriver driver){
		this.driver=driver;
	}
	public WebDriver startBrowser(){
		Properties prop = new Properties();
		try
		{
		InputStream input = new FileInputStream(new File("utilities/resources/value.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String browserName=prop.getProperty("browser");
		String webSiteUrl=prop.getProperty("webSiteUrl");
		BrowserChecker brObj=new BrowserChecker();
		brObj.browserCheck(browserName);

		if(browserName.equalsIgnoreCase("firefox"))
		{   
			System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver = new FirefoxDriver();
			Reporter.log("Opening Firefox",true);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{   System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver=new ChromeDriver();
			Reporter.log("Opening Chrome",true);
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{   System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver=new InternetExplorerDriver();
			Reporter.log("Opening IE",true);
		}
        driver.get(webSiteUrl);
		return driver;
	}
}
