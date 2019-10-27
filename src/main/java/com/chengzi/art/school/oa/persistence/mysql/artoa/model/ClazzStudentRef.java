package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class ClazzStudentRef {

    private Integer id;

    private Integer clazzId;

    private Integer studentId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
