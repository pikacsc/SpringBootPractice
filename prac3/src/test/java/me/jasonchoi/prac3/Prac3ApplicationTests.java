package me.jasonchoi.prac3;

import me.jasonchoi.prac3.model.Task;
import me.jasonchoi.prac3.model.User;
import me.jasonchoi.prac3.service.TaskService;
import me.jasonchoi.prac3.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Prac3ApplicationTests {


    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @Before
    public void initDB() {
        {
            User newUser = new User("testUser@mail.com","testUser","123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@mail.com","testAdmin","123456");
            userService.createUser(newUser);
        }
        Task userTask =new Task("11/12/2018","12:24","14:00","You need to work today");
            User user =userService.findOne("testUser@mail.com");
            taskService.addTask(userTask,user);
    }

    @Test
    public void testUser() {
        User user =userService.findOne("testUser@mail.com");
        Assert.assertNotNull(user);
        User admin =userService.findOne("testAdmin@mail.com");
        Assert.assertEquals(admin.getEmail(),"testAdmin@mail.com");
    }

    @Test
    public void testTask() {
        User user =userService.findOne("testUser@mail.com");
        List<Task> task = taskService.findUserTask(user);
        Assert.assertNotNull(task);
    }
}
