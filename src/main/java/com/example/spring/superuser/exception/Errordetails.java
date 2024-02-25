package com.example.spring.superuser.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errordetails {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorcode;
}
