package com.train.gdmt;

import com.train.gdmt.user.dao.UserDao;
import com.train.gdmt.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:29
 */


@SpringBootTest
public class UserDaoTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void getUserTest(){

        User user = userDao.getUser("jerry");
        System.out.println(user);
        assertThat(user).isNotNull();



    }


}
