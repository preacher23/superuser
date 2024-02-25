package com.example.spring.superuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfoundexception extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;
    public Resourcenotfoundexception(String resourceName,String fieldName,Long fieldValue){
        super(String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldValue));
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
        this.resourceName=resourceName;
    }
}
