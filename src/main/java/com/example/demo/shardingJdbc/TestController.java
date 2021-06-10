package com.example.demo.shardingJdbc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "shardingjdbc分表用户测试接口")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ApiOperation("获取用户列表")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    @ApiOperation("新增用户")
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
    @ApiOperation("根据id查询用户")
//    @ApiParam(value = "用户id", required = true, name = "id")
    public Object get(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/query")
    @ApiOperation("根据用户名称查询用户信息")
    @ApiParam(value = "用户名", required = true)
    public Object get(String username) {
        return userService.findByName(username);
    }

    //分页查询
    @GetMapping("/users/page")
    @ApiOperation("分页查询")
    public Object page(Integer pageNum, Integer pageSize) {
        return userService.page(pageNum, pageSize);
    }

    //pageHelper实现分页查询
    @GetMapping("/users/pageHelper")
    @ApiOperation("分页查询pageHelper")
    public Object pageHelper(Integer pageNum, Integer pageSize) {
        return userService.pageHelper(pageNum, pageSize);
    }

}
