package com.neu.aqimanagementsystem.sercice;

import com.neu.aqimanagementsystem.entity.User;

public interface UserService {

    User findUser(String mobile,String password);

    Boolean insertUser(User user);

    User findUserid_card(String id_card);

    User findUserbymobile (String mobile);

}
