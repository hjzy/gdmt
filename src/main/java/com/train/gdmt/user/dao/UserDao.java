package com.train.gdmt.user.dao;

import com.train.gdmt.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:09
 */



@Mapper
@Repository
public interface UserDao {


    @Select("select * from User where User_Name=#{username}")
    public User getUser(String username);



}
