package com.longya.dao;

import com.longya.pojo.po.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Administrator
 * Date: 2017/11/13
 * Time: 15:38
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbUserMapperTest {

    @Autowired
    private TbUserMapper userDao;

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        TbUser tbUser = userDao.selectByPrimaryKey(5L);
        System.out.println(tbUser);
    }

}