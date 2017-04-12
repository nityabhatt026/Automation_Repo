package com.HomePage;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.PageChecker.HomePageChecker;

public interface HomePageInterface {
	public HomePageChecker homePageCheckerObject(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public WebDriver clickLogin(WebDriver driver);
}
