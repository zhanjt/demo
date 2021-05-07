package com.example.demo.shardingJdbc;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/6  | 修改内容
 */
@Mapper
public interface UserDaoMapper {

    Long addUser(User user);

    List<User> list();

    User findById(Long id);

    User findByName(String username);

    List<User> listPage(@Param("start") Integer start, @Param("size") Integer size);
}
