package com.frank.my_test;

import com.frank.dao.UserMapper;
import com.frank.model.User;
import com.frank.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {
    @Autowired
    private UserService userService;


    @Test
    @Transactional
    public void testController() {
        User user = userService.findByUserName("test");
        System.out.println(user);
    }
}
