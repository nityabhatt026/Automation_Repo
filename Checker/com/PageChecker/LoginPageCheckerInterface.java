package com.PageChecker;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;
import com.LoginPage.LoginPage;

public interface LoginPageCheckerInterface {
	public LoginPage signupButtonStatus(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public LoginPageChecker LoginPageStatus(WebDriver driver) throws MyNullPointerException, MyNoSuchElementException, MyFileNotFoundException;
}
