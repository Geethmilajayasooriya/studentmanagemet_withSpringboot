package com.example.stumanagement.exception;

public class coursenotfoundexception extends RuntimeException{
    public  coursenotfoundexception ()
    {

    }
    public  coursenotfoundexception (String message)
    {
        super(message);
    }
    public  coursenotfoundexception (String message,Throwable cause)
    {
        super(message,cause);
    }
}
