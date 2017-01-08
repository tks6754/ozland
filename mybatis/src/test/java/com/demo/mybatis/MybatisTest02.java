package com.demo.mybatis;

import com.demo.mapper.UserAccountMapper;
import com.demo.po.UserAccount;
import com.demo.util.SqlSessionFacUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by miaomu on 17-1-8.
 */
public class MybatisTest02 {

    @Test
    public void testFindUserById(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFacUtil.getSqlSessionFac();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserAccountMapper userAccountMapper = sqlSession.getMapper(UserAccountMapper.class);

        UserAccount userAccount = userAccountMapper.findUserById(16);

        System.out.println(userAccount);
    }
}
