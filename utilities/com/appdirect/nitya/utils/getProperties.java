package com.appdirect.nitya.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;

import com.ExceptionHandling.MyFileNotFoundException;
import com.ExceptionHandling.MyNoSuchElementException;

public class getProperties {
    Properties prop=new Properties();
    String element;
	public String getPropertyFile(String filePath,String fileElement) throws MyNoSuchElementException, MyFileNotFoundException{
	try
	{
	InputStream input = new FileInputStream(new File(filePath));
	prop.load(input);
	}
	catch(Exception e)
	{
		throw new MyFileNotFoundException("Property File detail not found");
	}
	element=(prop.getProperty(fileElement));
	if(element==null){
		Reporter.log("Element in Property File not found",true);
		throw new MyNoSuchElementException("Element in Property File not found");
	}
	return element;
	}
	
}
