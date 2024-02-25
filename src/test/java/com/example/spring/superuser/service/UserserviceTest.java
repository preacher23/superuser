package com.example.spring.superuser.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.spring.superuser.dto.Userdto;
import com.example.spring.superuser.entity.User;
import com.example.spring.superuser.exception.Resourcenotfoundexception;
import com.example.spring.superuser.repository.Userrepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Userservice.class})
@ExtendWith(SpringExtension.class)
class UserserviceTest {
    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private Userrepository userrepository;

    @Autowired
    private Userservice userservice;

    /**
     * Method under test: {@link Userservice#createuse(Userdto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateuse() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class com.example.spring.superuser.entity.User$MockitoMock$ukzWh4fg cannot be cast to class com.example.spring.superuser.dto.Userdto (com.example.spring.superuser.entity.User$MockitoMock$ukzWh4fg and com.example.spring.superuser.dto.Userdto are in unnamed module of loader com.diffblue.cover.f.g @165b666f)
        //       at com.example.spring.superuser.service.Userservice.createuse(Userservice.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        Userservice userservice = new Userservice();
        userservice.createuse(new Userdto());
    }

    /**
     * Method under test: {@link Userservice#createuse(Userdto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateuse2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class com.example.spring.superuser.entity.User$MockitoMock$ukzWh4fg cannot be cast to class com.example.spring.superuser.dto.Userdto (com.example.spring.superuser.entity.User$MockitoMock$ukzWh4fg and com.example.spring.superuser.dto.Userdto are in unnamed module of loader com.diffblue.cover.f.g @165b666f)
        //       at com.example.spring.superuser.service.Userservice.createuse(Userservice.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        (new Userservice()).createuse(mock(Userdto.class));
    }

    /**
     * Method under test: {@link Userservice#getuserbyid(Long)}
     */
    @Test
    void testGetuserbyid() {
        Userdto userdto = new Userdto();
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(userdto);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");
        Optional<User> ofResult = Optional.of(user);
        when(userrepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(userdto, userservice.getuserbyid(1L));
        verify(modelMapper).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#getuserbyid(Long)}
     */
    @Test
    void testGetuserbyid2() {
        when(modelMapper.map((Object) any(), (Class<Userdto>) any()))
                .thenThrow(new Resourcenotfoundexception("Resource Name", "Field Name", 42L));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");
        Optional<User> ofResults = Optional.of(user);
        when(userrepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(Resourcenotfoundexception.class, () -> userservice.getuserbyid(1L));
        verify(modelMapper).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#getuserbyid(Long)}
     */
    @Test
    void testGetuserbyid3() {
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());
        when(userrepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(Resourcenotfoundexception.class, () -> userservice.getuserbyid(1L));
        verify(modelMapper).map((Object) any(), (Class<Object>) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#findalluser()}
     */
    @Test
    void testFindalluser() {
        when(userrepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userservice.findalluser().isEmpty());
        verify(userrepository).findAll();
    }

    /**
     * Method under test: {@link Userservice#findalluser()}
     */
    @Test
    void testFindalluser2() {
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userrepository.findAll()).thenReturn(userList);
        assertEquals(1, userservice.findalluser().size());
        verify(modelMapper).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).findAll();
    }

    /**
     * Method under test: {@link Userservice#findalluser()}
     */
    @Test
    void testFindalluser3() {
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");

        User user1 = new User();
        user1.setEmail("john.smith@example.org");
        user1.setFirstname("John");
        user1.setId(2L);
        user1.setLastname("Smith");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user);
        when(userrepository.findAll()).thenReturn(userList);
        assertEquals(2, userservice.findalluser().size());
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).findAll();
    }

    /**
     * Method under test: {@link Userservice#findalluser()}
     */
    @Test
    void testFindalluser4() {
        when(modelMapper.map((Object) any(), (Class<Userdto>) any()))
                .thenThrow(new Resourcenotfoundexception("Resource Name", "Field Name", 42L));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userrepository.findAll()).thenReturn(userList);
        assertThrows(Resourcenotfoundexception.class, () -> userservice.findalluser());
        verify(modelMapper).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).findAll();
    }

    /**
     * Method under test: {@link Userservice#updateuser(Userdto)}
     */
    @Test
    void testUpdateuser() {
        Userdto userdto = new Userdto();
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(userdto);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstname("Jane");
        user1.setId(1L);
        user1.setLastname("Doe");
        when(userrepository.save((User) any())).thenReturn(user1);
        when(userrepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(userdto, userservice.updateuser(new Userdto()));
        verify(modelMapper).map((Object) any(), (Class<Userdto>) any());
        verify(userrepository).save((User) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#updateuser(Userdto)}
     */
    @Test
    void testUpdateuser2() {
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");
        Optional<User> ofResult = Optional.of(user);
        when(userrepository.save((User) any()))
                .thenThrow(new Resourcenotfoundexception("Resource Name", "Field Name", 42L));
        when(userrepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(Resourcenotfoundexception.class, () -> userservice.updateuser(new Userdto()));
        verify(modelMapper).map((Object) any(), (Class<Object>) any());
        verify(userrepository).save((User) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#updateuser(Userdto)}
     */
    @Test
    void testUpdateuser3() {
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());
        when(userrepository.save((User) any()))
                .thenThrow(new Resourcenotfoundexception("Resource Name", "Field Name", 42L));
        when(userrepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(Resourcenotfoundexception.class, () -> userservice.updateuser(new Userdto()));
        verify(modelMapper).map((Object) any(), (Class<Object>) any());
        verify(userrepository).findById((Long) any());
    }

    /**
     * Method under test: {@link Userservice#updateuser(Userdto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateuser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.spring.superuser.service.Userservice.updateuser(Userservice.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(modelMapper.map((Object) any(), (Class<Userdto>) any())).thenReturn(new Userdto());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setId(1L);
        user.setLastname("Doe");
        Optional<User> ofResult = Optional.of(user);
        when(userrepository.save((User) any()))
                .thenThrow(new Resourcenotfoundexception("Resource Name", "Field Name", 42L));
        when(userrepository.findById((Long) any())).thenReturn(ofResult);
        userservice.updateuser(null);
    }
}

