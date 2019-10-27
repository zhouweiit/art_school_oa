package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class School {

    private Integer id;

    private String name;

    private Integer groupId;

    private String simpleName;

    private String introduce;

    private String address;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
