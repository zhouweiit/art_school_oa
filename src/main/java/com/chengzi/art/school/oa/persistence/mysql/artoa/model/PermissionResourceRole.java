package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResourceRole {

    private Integer id;

    private Integer name;

    private String permissionResourceId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
