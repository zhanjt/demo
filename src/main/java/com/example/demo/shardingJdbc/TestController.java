package com.example.demo.shardingJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/6  | 修改内容
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    public Object add() {
        for (long i = 1; i <= 100; i++) {
            User user = new User();
            user.setId(i);
            user.setCity("深圳");
            user.setUsername("李四"+ i);
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            userService.add(user);
        }
        return "success";
    }

    @GetMapping("/users/{id}")
    public Object get(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/query")
    public Object get(String username) {
        return userService.findByName(username);
    }

    //分页查询
    @GetMapping("/users/page")
    public Object page(Integer pageNum, Integer pageSize) {
        return userService.page(pageNum, pageSize);
    }

    //pageHelper实现分页查询
    @GetMapping("/users/pageHelper")
    public Object pageHelper(Integer pageNum, Integer pageSize) {
        return userService.pageHelper(pageNum, pageSize);
    }

}
