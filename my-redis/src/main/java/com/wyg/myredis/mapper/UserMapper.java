package com.wyg.myredis.mapper;

import com.wyg.myredis.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 根据id查询User
     *
     * @param id id
     * @return UserVO 查询到的user
     * @throws Exception Exception
     */
    UserVO getUserById(int id) throws Exception;

    /**
     * 添加user信息
     *
     * @param user 需要添加的user信息
     * @return 成功添加的行数
     * @throws Exception exception
     */
    int insertUser(UserVO user) throws Exception;

    int updateUser(UserVO user) throws Exception;

    int delete(int id) throws Exception;
}
