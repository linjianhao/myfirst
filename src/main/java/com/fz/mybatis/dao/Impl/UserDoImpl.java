package com.fz.mybatis.dao.Impl;

import com.fz.mybatis.dao.UserDao;
import com.fz.mybatis.daoDo.UserDo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public class UserDoImpl implements UserDao {

    SqlSessionFactory sqlSessionFactory;

    SqlSession session;
    @Override
    public UserDo queryById(UserDo user) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        return user;
    }

    @Override
    public UserDo findById(Integer Id) {
        return null;
    }

    @Override
    public List<UserDo> queryByList(UserDo user) {
        return null;
    }

    @Override
    public Integer addUser(UserDo user) {
        return null;
    }

    @Override
    public Integer modifyUser(UserDo user) {
        return null;
    }

    @Override
    public Integer delUser(UserDo user) {
        return null;
    }
/*实现未实现的方法还是用Alt+insert*/

}
