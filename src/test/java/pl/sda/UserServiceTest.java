package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by trot on 11.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceInject() throws Exception {
        assertNotNull(userService);
    }

    @Test
    public void testGetAllUsersMethod() throws Exception {
        testUserServiceInject();
        assertNotNull(userService.getAllUsers());
        assertEquals("Jan", userService.getAllUsers().get(0).getName());
        assertEquals("Kowalski", userService.getAllUsers().get(0).getSurname());
        assertEquals("Kowal01", userService.getAllUsers().get(0).getLogin());
        assertEquals(40, userService.getAllUsers().get(0).getAge());
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        testUserServiceInject();
        assertEquals("Marian", userService.getUserByLogin("Marnow").getName());
        assertEquals("Maria", userService.getUserByLogin("Mania").getName());
    }
}