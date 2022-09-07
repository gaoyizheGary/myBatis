package com.gaoyizhe.mybatis.mapper;

import com.gaoyizhe.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 修改用户
     * @return
     */
    int updateUser();

    /**
     * 删除用户
     * @return
     */
    int deleteUser();

    /**
     * 通过id查询用户
     * @return
     */
    User getUserById();

    /**
     * 通过id查询用户
     * @return
     */
    List<User> getALLUser();
}
