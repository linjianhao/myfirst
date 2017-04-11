package com.fz.mybatis.dao;

import com.fz.mybatis.daoDo.UserDo;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public interface UserDao {
    /*点击接口名字ctrl+shift+T是创建对应的测试类*/
    public UserDo queryById(UserDo user) throws IOException;

    public UserDo findById(Integer Id);

    public List<UserDo> queryByList(UserDo user);

    public Integer addUser(UserDo user);

    public Integer modifyUser(UserDo user);

    public Integer delUser(UserDo user);

}
