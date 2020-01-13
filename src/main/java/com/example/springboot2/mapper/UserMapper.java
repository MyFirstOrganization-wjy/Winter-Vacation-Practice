package com.example.springboot2.mapper;

import com.example.springboot2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
   //@Select("select * from user where id=#{item}")
    public User findUserById(Integer id);
//    @update user set username=#{username},password=#{password},phone=#{phone},address=#{address},type=#{type},admin_id={admin_id}
//    where id=#{id}
    //@Update("update user set username=#{username},password=#{password},phone=#{phone},address=#{address},type=#{type},admin_id={admin_id} where id=#{id}")
    public void updateUserById(User user);
    //@Select("select * from user")
    public List<User> selectAll();


}
