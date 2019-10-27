package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class ClazzTeacherRef {

    private Integer id;

    private Integer clazzId;

    private Integer teacherId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
