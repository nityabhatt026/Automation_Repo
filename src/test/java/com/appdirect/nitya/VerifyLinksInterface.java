package com.appdirect.nitya;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyIOException;
import com.ExceptionHandling.MyNoSuchElementException;
import com.ExceptionHandling.MyNullPointerException;

public interface VerifyLinksInterface {
	public void testSignUpSuccess() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException;
	public void testSignUpFailure() throws MyNoSuchElementException, MyNullPointerException, MyIOException, MyFileNotFoundException;
}
