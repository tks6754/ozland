package com.demo.mapper;

import com.demo.po.UserAccount;

/**
 * Created by miaomu on 17-1-8.
 */
public interface UserAccountMapper {
    public UserAccount findUserById(Integer id);
}
