package com.example.spring.superuser.modelmapper;

import com.example.spring.superuser.dto.Userdto;
import com.example.spring.superuser.entity.User;

public class Usermapper {
    //convert user to userdto
    public static Userdto mapTouserDto(User user){
        Userdto userdto1=new Userdto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
        return userdto1;
    }

    //convert userdto top user

    public static User maptoUser(Userdto userdto){
        User user1=new User(
                userdto.getId(),
                userdto.getFirstname(),
                userdto.getLastname(),
                userdto.getEmail()
        );
        return user1;
    }
}
