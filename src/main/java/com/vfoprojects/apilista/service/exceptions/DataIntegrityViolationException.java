package com.vfoprojects.apilista.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    
    public DataIntegrityViolationException(String msg){
        super(msg);
    }

}
