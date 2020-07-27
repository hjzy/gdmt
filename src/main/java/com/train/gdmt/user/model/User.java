package com.train.gdmt.user.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:10
 */

@Data
public class User {

    private int id;
    private String username;
    private String pwd;
    private String email;
    private String mobile;
    private String realName;    //姓名
    private int role;   //1：燃料业务员 2：监察人员 3：管理人员 4：系统管理员 5：公告发布员',
    private int departMent;//1:燃料部 2:审批部 3：宣传部 4：管理部
    private Date registerTime;
    private Date lastLogin;
    private int status; //0:未激活 1：正常用户 2：已注销',




}
