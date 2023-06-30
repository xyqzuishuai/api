package com.neu.aqimanagementsystem.dao;

import com.neu.aqimanagementsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    Boolean insertUser(User user);

    public User findUser(@Param("mobile") String mobile,
                         @Param("password") String password);

    public User findUserid_card(@Param("id_card") String id_card);
    int insertSelective(User record);

    User selectByid(Integer id);
    User findUserbymobile(@Param("mobile") String mobile);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}