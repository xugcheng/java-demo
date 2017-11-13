package com.xugc.demo.controller;

import com.xugc.demo.dao.UmUserDao;
import com.xugc.demo.entity.UmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xuguocheng on 2017/9/21.
 */
@RestController
@RequestMapping("test")
public class DemoController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${spring.datasource.url}")
    private String datasource;

    @Value("${mybatis.type-aliases-package}")
    private String mybatis;

    @Autowired
    private UmUserDao userDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("profile")
    public Object profile() {
        return profile;
    }

    @GetMapping("datasource")
    public Object datasource() {
        return datasource;
    }

    @GetMapping("mybatis")
    public Object mybatis() {
        return mybatis;
    }

    @GetMapping("users1")
    public List<UmUser> users1() {
        return userDao.selectAllUsers();
    }

    @GetMapping("users2")
    public List<?> users2() {
        return jdbcTemplate.queryForList("select * from um_user");
    }
}
