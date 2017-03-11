package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.model.User;
import pl.sda.service.UserService;

import javax.annotation.Resource;

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
        User user = new User();
        user.setName("Jan");
        user.setSurname("Kowalski");
        user.setLogin("Kowal01");
        user.setAge(40);
        assertEquals(user, userService.getAllUsers().get(0));
    }
}