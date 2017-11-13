package com.xugc.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by xuguocheng on 2017/9/21.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UmUserDaoTest {

    @Autowired
    private UmUserDao userDao;

    @Test
    public void test() {

        List<?> list = userDao.selectAllUsers();

        System.out.println(list.size());
    }
}
