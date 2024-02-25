package com.example.spring.superuser.service;

import com.example.spring.superuser.dto.Userdto;
import com.example.spring.superuser.entity.User;
import com.example.spring.superuser.exception.Resourcenotfoundexception;
import com.example.spring.superuser.modelmapper.Usermapper;
import com.example.spring.superuser.repository.Userrepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Userservice {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Userrepository userrepository;

    public Userdto createuse(Userdto userdto) {
        //convert userdto to user
       // User user1= Usermapper.maptoUser(userdto);
        User user1= modelMapper.map(userdto,User.class);
        User saveuser= userrepository.save(user1);
        //convert user to userdto
        //Userdto userdto1=Usermapper.mapTouserDto(user1);
        Userdto userdto1=modelMapper.map(user1,Userdto.class);
        return userdto1  ;
    }

    public Userdto getuserbyid(Long id) {
        User user = userrepository.findById(id).orElseThrow(
                ()->new Resourcenotfoundexception("user","id",id)
        );
        //Userdto user1 = Usermapper.mapTouserDto(user);
        Userdto user1 = modelMapper.map(user,Userdto.class);
        return user1;

    }

    public List<Userdto> findalluser(){
        List<User> all = userrepository.findAll();

        //return all.stream().map(user -> Usermapper.mapTouserDto(user)).collect(Collectors.toList());
        return all.stream().map(user -> modelMapper.map(user,Userdto.class)).collect(Collectors.toList());
    }

    public Userdto updateuser(Userdto user){
        User existinguser = userrepository.findById(user.getId()).orElseThrow(
                ()-> new Resourcenotfoundexception("user","id", user.getId())
        );
        existinguser.setEmail(user.getEmail());
        existinguser.setFirstname(user.getFirstname());
        User save = userrepository.save(existinguser);
        //return Usermapper.mapTouserDto(save);
        return modelMapper.map(save,Userdto.class);
    }
}
