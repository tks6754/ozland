package com.demo.dao;

import com.demo.po.UserAccount;

import java.util.List;

/**
 * Created by miaomu on 17-1-8.
 */
public interface UserAccountDao {

    public UserAccount findUserById(int id) throws Exception;

    public List<UserAccount> findUserByAccountNO(String accouontNO) throws Exception;

    public void insertUser(UserAccount userAccout) throws Exception;

    public void deleteUser(Integer id) throws Exception;

    public Integer updateUser(UserAccount userAccout) throws Exception;

}
