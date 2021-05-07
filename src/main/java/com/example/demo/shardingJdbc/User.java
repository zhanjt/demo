package com.example.demo.shardingJdbc;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
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

    private Long id;

    private String city = "";

    private String username = "";

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    private Date modifyTime;
}
