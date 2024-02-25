package com.example.spring.superuser.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class Globalexception extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Resourcenotfoundexception.class)
    public ResponseEntity<Errordetails> handleresourcenotfoundexception(Resourcenotfoundexception resourcenotfoundexception,
                                                                        WebRequest request){
        Errordetails errordetails=new Errordetails(LocalDateTime.now(),
                resourcenotfoundexception.getMessage(),
                request.getDescription(false),
                "USER_NOT_FOUND");
        return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Errordetails> notfoundexception(Exception exception,
                                                                        WebRequest request){
        Errordetails errordetails=new Errordetails(LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "INTERNAL SERVER");
        return new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String>hashmap=new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        allErrors.forEach((objectError -> {
            String fieldname = ((FieldError)objectError).getField();
            String message= objectError.getDefaultMessage();
            hashmap.put(fieldname,message);
        }));
return new ResponseEntity<>(hashmap,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Errordetails> handleaccessdeniedexception(AccessDeniedException exception,
                                                                        WebRequest request){
        Errordetails errordetails=new Errordetails(LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "USER_NOT_FOUND");
        return new ResponseEntity<>(errordetails, HttpStatus.UNAUTHORIZED);
    }
}
