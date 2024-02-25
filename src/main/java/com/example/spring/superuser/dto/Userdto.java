package com.example.spring.superuser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userdto {
    private Long id;
    @NotEmpty(message = "not empty")
    private String firstname;
    @NotEmpty(message = "not empty")
    private String lastname;
    @NotEmpty
    private String email;


}
