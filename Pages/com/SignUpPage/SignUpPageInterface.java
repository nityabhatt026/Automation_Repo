package com.SignUpPage;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.PageChecker.SignupPageChecker;

public interface SignUpPageInterface {
	public SignupPageChecker signupPageCheckerObject(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public SignupPageChecker signupID(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public SignupPage submitSignupId(WebDriver driver);
}
