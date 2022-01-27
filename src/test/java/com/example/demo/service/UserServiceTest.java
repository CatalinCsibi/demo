package com.example.demo.service;

import com.example.demo.model.user.AppUser;
import com.example.demo.model.user.UserRole;
import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    UserService userService;



    @Test
    public void signUpNewUser_should_create_new_user() {
        AppUser user = new AppUser("George", "Georgescu",
                "George90", "george@ymail.com", "password", UserRole.USER);

        when(userRepository.save(any(AppUser.class))).thenReturn(new AppUser());

        AppUser appUser = userService.singUpNewUser(user);

        assertThat(user.getFirstName()).isSameAs(appUser.getFirstName());
        assertThat(user.getLastName()).isSameAs(appUser.getLastName());
        assertThat(user.getUsername()).isSameAs(appUser.getUsername());
        assertThat(user.getEmail()).isSameAs(appUser.getEmail());
        assertThat(user.getUserRole()).isSameAs(appUser.getUserRole());

    }





}
