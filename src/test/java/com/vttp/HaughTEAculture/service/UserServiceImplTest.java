package com.vttp.HaughTEAculture.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.vttp.HaughTEAculture.model.User;
import com.vttp.HaughTEAculture.repository.CartRepo;
import com.vttp.HaughTEAculture.repository.UserRepo;
import com.vttp.HaughTEAculture.service.implementation.UserServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private CartRepo cartRepository;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setPassword("password");
        user.setEmail("email@email.com");
        user.setName("Name");
        user.setPhone("Phone Test");
        user.setAddress("Address Test");
    }

    @Test
    public void createUserTest() {
        when(userRepository.save(user)).thenReturn(user);

        userService.save(user);

        Mockito.verify(userRepository, Mockito.times(2)).save(user);
    }

    @Test(expected = Exception.class)
    public void createUserExceptionTest() {
        userService.save(user);
    }

    @Test
    public void updateTest() {
        User oldUser = new User();
        oldUser.setEmail("email@test.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(oldUser);
        when(userRepository.save(oldUser)).thenReturn(oldUser);

        User userResult = userService.update(user);

        assertThat(userResult.getName(), is(oldUser.getName()));
    }
}
