package com.ExceptionHandling;

public class MyFileNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public MyFileNotFoundException(String message) {
       super(message);
   }
}
