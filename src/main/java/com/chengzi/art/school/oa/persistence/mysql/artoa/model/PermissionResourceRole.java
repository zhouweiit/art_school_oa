package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class PermissionResourceRole {

    private Integer id;

    private Integer name;

    private String permissionResourceId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
