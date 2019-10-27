package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class SchoolRoom {

    private Integer id;

    private String name;

    private Integer maxNum;

    private Integer floor;

    private Integer useType;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
