package com.demo.dao.impl;

import com.demo.dao.UserAccountDao;
import com.demo.po.UserAccount;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by miaomu on 17-1-8.
 */
public class UserAccountDaoImpl implements UserAccountDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserAccountDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public UserAccount findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserAccount userAccount = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return userAccount;
    }

    public List<UserAccount> findUserByAccountNO(String accouontNO) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserAccount> userAccounts = sqlSession.selectList("test.findUserByAccountNO", accouontNO);
        sqlSession.close();
        return userAccounts;
    }

    public void insertUser(UserAccount userAccout) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", userAccout);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }

    public Integer updateUser(UserAccount userAccout) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer flag = sqlSession.update("test.updateUser", userAccout);
        sqlSession.commit();
        sqlSession.close();

        return flag;
    }
}
