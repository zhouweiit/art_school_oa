package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class PermissionResource {

    private Integer id;

    private Integer name;

    private Integer parentId;

    private String uniqueResourceName;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
