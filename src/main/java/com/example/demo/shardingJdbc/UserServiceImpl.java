package com.example.demo.shardingJdbc;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/6  | 修改内容
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoMapper userDao;

    @Override
    public List<User> list() {
        //可以在sql中直接进行排序，归并后的list就是有序的。
        List<User> list = userDao.list();
        //排序下：id升序
//        list.sort(Comparator.comparing(User::getId));
        //createTime降序
//        list.sort(((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime())));
        //createTime降序,id降序
        //students.sort(comparing(Student::getScore).reversed().thenComparing(Student::getHeight));
//        list.sort(Comparator.comparing(User::getCreateTime).reversed().thenComparing((o1, o2) -> o2.getId().compareTo(o1.getId())));
        return list;
    }
    @Override
    public Long add(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public List<User> page(Integer pageNum, Integer pageSize) {
        return userDao.listPage((pageNum-1) * pageSize, pageSize);
    }

    @Override
    public Object pageHelper(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.list();
    }
}
