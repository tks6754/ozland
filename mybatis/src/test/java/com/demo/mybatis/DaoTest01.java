package com.demo.mybatis;

import com.demo.dao.UserAccountDao;
import com.demo.dao.impl.UserAccountDaoImpl;
import com.demo.po.UserAccount;
import com.demo.util.SqlSessionFacUtil;
import org.junit.Test;

/**
 * Created by miaomu on 17-1-8.
 */
public class DaoTest01 {
    @Test
    public void testFindUserById() throws Exception {
        UserAccountDao userAccountDao = new UserAccountDaoImpl(SqlSessionFacUtil.getSqlSessionFac());
        UserAccount userAccount = userAccountDao.findUserById(15);

        System.out.println(userAccount);
    }

}
