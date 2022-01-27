package com.example.demo.service;

import com.example.demo.model.user.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    @Mock
    UserService userService;

    @InjectMocks
    RegistrationService registrationService;

    @Test
    public void when_register_should_create_new_user() {
        RegistrationRequest request = new RegistrationRequest("George", "Georgescu", "george90",
                "george@ymail.com", "password");

        when(userService.singUpNewUser(any(AppUser.class))).thenReturn(new AppUser());

        String message =  registrationService.register(request);

        assertThat((message)).isSameAs("User was successfully registered");

    }


}
