package com.fz.mybatis.dao;

import com.fz.mybatis.daoDo.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/11.
 */
@Slf4j
public class UserDaoTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession session;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//通过全局配置文件生成输入流
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//通过输入流构建会话工厂
        /*session = sqlSessionFactory.openSession();*/
        //默认创建session是false 手动提交事物 ，如果是设置true，自动提交事物
        //也可以理解为 false: 开启事物 true:关闭事物
        session = sqlSessionFactory.openSession(true);
    }
    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    /*执行测试类CTrl+shift+F10*/
    public void testQueryById() throws Exception {
        UserDo userdo = new UserDo();
        userdo.setId(35);

        UserDo user = session.selectOne("user.queryById", userdo);
        /*log.info()方法使用的前提示安装过lombok插件（file--setting--plugins）*/
        log.info("UserDo : {}", user);
        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        session.commit();*/


    }

    @Test
    public void testFindById() throws Exception {

        UserDo user = session.selectOne("user.findById",35);

        log.info("UserDo : {}", user);
        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        session.commit();*/

    }

    @Test
    public void testQueryByList() throws Exception {
        UserDo user = new UserDo();
        user.setAddress("广");

        List<UserDo> list = session.selectList("user.queryByList", user);

        for (UserDo use : list) {
            log.info("UserDo : {}", use);
            /*日志里打印出来的是对象*/
        }
        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        session.commit();*/


    }

    @Test
    public void testAddUser() throws Exception {
        UserDo user = new UserDo();

        user.setName("皓月");
        user.setRealname("王五");
        user.setPassword("123456");
        /*0为女     1为男*/
        user.setSex("1");
        user.setEmail("1358579976@qq.com");
        user.setPhone("15286825796");
        user.setAddress("广东深圳");
        user.setStatus("0");
        Integer res = session.insert("user.addUser", user);
        //默认情况下mybatis是手动提交的(开启事物的)
//        session.commit();
        log.info("新增影响的行数 ： {}", res);
        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        session.commit();*/
    }
    @Test
    /*修改表*/
    public void testModifyUser() throws Exception {
        UserDo user = new UserDo();
        user.setId(38);
        user.setPassword("45356456");
        Integer res = session.update("user.modifyUser", user);
        log.info("修改影响的行数 ： {}", res);

        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        */


    }

    @Test
    /*删除用户*/
    public void testDelUser() throws Exception {
        UserDo user = new UserDo();

        user.setId(29);

        Integer res = session.update("user.delUser", user);

        log.info("修改影响的行数 ： {}", res);
        /*上面已经设置过了session = sqlSessionFactory.openSession(true);，所以这里就不需要提交了
        session.commit();*/

    }
}