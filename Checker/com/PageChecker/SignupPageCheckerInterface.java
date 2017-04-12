package com.PageChecker;

import org.openqa.selenium.WebDriver;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.SignUpPage.SignupPage;

public interface SignupPageCheckerInterface {
	public SignupPageChecker signupPageStatus(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public SignupPage signupTextBoxStatus(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
	public SignupPage signupButtonStatus(WebDriver driver) throws MyNoSuchElementException, MyFileNotFoundException;
}
