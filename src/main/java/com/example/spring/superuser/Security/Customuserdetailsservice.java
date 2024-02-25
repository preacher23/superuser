package com.example.spring.superuser.Security;

import com.example.spring.superuser.entity.Myuser;
import com.example.spring.superuser.repository.Userrepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Customuserdetailsservice implements UserDetailsService {
    private Userrepo userrepo;
    public Customuserdetailsservice(Userrepo userrepo) {//database authenication fully
        this.userrepo = userrepo;
    }



    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
      Myuser myuser= userrepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(()->
                new UsernameNotFoundException("user not found"+usernameOrEmail));

        Set<GrantedAuthority> authorities=myuser.getRoles()
                .stream().
                map((role -> new SimpleGrantedAuthority(role.getName()))).collect(Collectors.toSet());
        return new User(myuser.getUsername(),myuser.getPassword(),authorities);
    }
}
