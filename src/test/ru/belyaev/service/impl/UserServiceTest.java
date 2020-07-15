/*
 * Created by Vologda Developer
 * Date: 08.07.2020
 * Time: 15:45
 */


package ru.belyaev.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.belyaev.entity.User;
import ru.belyaev.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;



public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private User theUser;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(userRepository.findUserByName("zizo")).thenReturn(new User());
        when(theUser.getName()).thenReturn("zizo");
    }

    @Test
    public void addUserTest() {
        User user = userRepository.findUserByName(theUser.getName());
        assertThat(user).isNotNull();
    }

//    @Test
//    public void addUserTest2() {
//        User user3 = userService.addUserForTest(theUser);
//        verify(userRepository, times(1)).findUserByName(theUser.getName());
//    }
}
