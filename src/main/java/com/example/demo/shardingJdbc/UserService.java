package com.example.demo.shardingJdbc;

import java.util.List;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/6  | 修改内容
 */
public interface UserService {

    List<User> list();

    Long add(User user);

    User findById(Long id);

    User findByName(String name);

    List<User> page(Integer pageNum, Integer pageSize);

    Object pageHelper(Integer pageNum, Integer pageSize);
}
