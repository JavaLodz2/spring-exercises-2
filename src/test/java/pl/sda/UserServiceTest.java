package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.model.User;
import pl.sda.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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

    @Test
    public void testAddUser() throws Exception {
        testUserServiceInject();
        userService.addUser(getNewUser());
        assertEquals("Robert", userService.getAllUsers().get(3).getName());
        assertEquals("Lewandowski", userService.getAllUsers().get(3).getSurname());

        assertEquals("Lewy", userService.getUserByLogin("Lewy").getLogin());
    }

    @Test
    public void testRemoveUser() throws Exception {
        testUserServiceInject();
        int sizeBefore = userService.getAllUsers().size();
        userService.addUser(getNewUser());
        userService.removeUser(getNewUser());
        int sizeAfter = userService.getAllUsers().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testUpdateUser() throws Exception {
        testUserServiceInject();
        userService.addUser(getNewUser());
        User user = userService.getUserByLogin("Lewy");
        user.setAge(40);
        userService.updateUser(user);
        assertEquals(40, userService.getUserByLogin("Lewy").getAge());
    }

    private User getNewUser() {
        User newUser = new User();
        newUser.setName("Robert");
        newUser.setSurname("Lewandowski");
        newUser.setLogin("Lewy");
        newUser.setAge(30);
        return newUser;
    }
}