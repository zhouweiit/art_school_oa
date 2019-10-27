package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String name;

    private String loginName;

    private String salt;

    private String password;

    private Integer userType;

    private Integer schoolGroupId;

    private String roleId;

    private String permissionResourceId;

    private String phone;

    private Integer age;

    private Integer sex;

    private String address;

    private Date lastLoginDatetime;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
