package com.example.demo.shardingJdbc;

import com.example.demo.golbalException.validateGroup.DeleteGroup;
import com.example.demo.golbalException.validateGroup.UpdateGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/6  | 修改内容
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1445215485779542085L;

    @NotNull(message = "id不能为空", groups = {UpdateGroup.class, DeleteGroup.class})
    private Long id;

//    @NotNull(message ="城市不能为空")
    @NotBlank(message ="城市不能为空")
    private String city = "";

    private String username = "";

    @NotNull(message ="创建时间不能为空", groups = {UpdateGroup.class, DeleteGroup.class})
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    @NotNull(message = "修改时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date modifyTime;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
//    private LocalDateTime testDate;

    public User(){}

    public User(Long id, String city, String username) {
        this.id = id;
        this.city = city;
        this.username = username;
    }

    public User( Long id,  String city, String username,  Date createTime,  Date modifyTime) {
        this.id = id;
        this.city = city;
        this.username = username;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
//        this.testDate = testDate;
    }
}
