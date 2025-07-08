package com.example.stumanagement.exception;

public class studentnotfoundexception extends RuntimeException {

     public  studentnotfoundexception ()
     {

     }
    public  studentnotfoundexception (String message)
    {
super(message);
    }
    public  studentnotfoundexception (String message,Throwable cause)
    {
        super(message,cause);
    }
}
