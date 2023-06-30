package com.neu.aqimanagementsystem.sercice.impl;

import com.neu.aqimanagementsystem.dao.UserDao;
import com.neu.aqimanagementsystem.entity.User;
import com.neu.aqimanagementsystem.sercice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServicelmpl implements UserService {
    @Autowired
    private UserDao userDao;

   @Override
   public  User findUser(String mobile, String password) {
        User user= userDao.findUser(mobile,password);
        return user;
   }
    @Override
    public  User findUserbymobile(String mobile) {
        User user= userDao.findUserbymobile(mobile);
        return user;
    }


    @Override
    public Boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUserid_card(String id_card) {
        return userDao.findUserid_card(id_card);
    }





}
