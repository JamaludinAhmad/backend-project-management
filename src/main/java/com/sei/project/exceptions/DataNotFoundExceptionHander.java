package com.sei.project.exceptions;

public class DataNotFoundExceptionHander extends RuntimeException{
    public DataNotFoundExceptionHander(String message){
        super(message);
    }
}
