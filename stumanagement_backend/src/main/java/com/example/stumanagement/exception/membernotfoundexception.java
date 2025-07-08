package com.example.stumanagement.exception;

public class membernotfoundexception extends RuntimeException{
    public  membernotfoundexception ()
    {

    }
    public  membernotfoundexception (String message)
    {
        super(message);
    }
    public  membernotfoundexception (String message,Throwable cause)
    {
        super(message,cause);
    }
}
