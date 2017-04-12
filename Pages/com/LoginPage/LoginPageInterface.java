package com.LoginPage;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.PageChecker.LoginPageChecker;

public interface LoginPageInterface {
	public LoginPageChecker loginPageCheckerObject(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public WebDriver clicksignup(WebDriver driver);
}
