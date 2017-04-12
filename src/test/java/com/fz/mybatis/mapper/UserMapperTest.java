package com.fz.mybatis.mapper;



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

/**
 * Created by Administrator on 2017/4/11.
 */
@Slf4j
public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession session;
    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
    public void testQueryById() throws Exception {
        UserDo userDo = new UserDo();
        userDo.setId(37);
        /*session.getMapper（类类型），传入的参数是接口的类类型（以后这一句应该写在service层，写在最外面，里
        面的增删查改的操作最需要用mapper就可以）*/
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = mapper.queryById(userDo);

        log.info("UserDo : {}", user);
    }

    @Test
    public void testFindById() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = mapper.findById(37);

        log.info("UserDo : {}", user);
    }

    @Test
    public void testQueryByList() throws Exception {
        UserDo userDo = new UserDo();
        userDo.setAddress("南");

        UserMapper mapper = session.getMapper(UserMapper.class);

        List<UserDo> list = mapper.queryByList(userDo);

        for (UserDo user : list) {
            log.info("UserDo : {}", user);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setName("背影杀手");
        userDo.setSex("1");
        userDo.setPassword("123456");
        userDo.setRealname("德玛");
        userDo.setEmail("zhaoliu@qq.com");
        userDo.setPhone("17712345678");
        userDo.setAddress("广东深圳");
        userDo.setStatus("0");

        UserMapper mapper = session.getMapper(UserMapper.class);

        Integer res = mapper.addUser(userDo);

//        session.commit();

        log.info("新增影响的行数 ： {}", res);
    }

    @Test
    public void testModifyUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setId(39);
        userDo.setPassword("654321");

        UserMapper mapper = session.getMapper(UserMapper.class);

        Integer res = mapper.modifyUser(userDo);

//        session.commit();

        log.info("修改影响的行数 ： {}", res);
    }

    @Test
    public void testDelUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setId(41);

        UserMapper mapper = session.getMapper(UserMapper.class);

        Integer res = mapper.delUser(userDo);

//        session.commit();

        log.info("修改影响的行数 ： {}", res);
    }
}