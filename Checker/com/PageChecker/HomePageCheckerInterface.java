package com.PageChecker;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.HomePage.HomePage;

public interface HomePageCheckerInterface {
	public HomePage loginButtonStatus(WebDriver driver) throws MyNoSuchElementException;
	public HomePageChecker homePageStatus(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
}
