package com.lamp.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao UserDao;

    @Transactional
    public void insert() {
        UserDao.insert();
//        int i1 = 1 / 0;
    }
}
