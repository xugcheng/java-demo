package com.xugc.demo.dao;

import com.xugc.demo.entity.UmUser;

import java.util.List;

/**
 * Created by xuguocheng on 2017/9/21.
 */
public interface UmUserDao {

    List<UmUser> selectAllUsers();

    int insertUser(UmUser user);

    int updateUser(UmUser user);
}
