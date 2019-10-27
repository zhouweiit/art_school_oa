package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentSubjectSignup {

    private Integer id;

    private Integer studentId;

    private Integer subject;

    private Integer minuteNum;

    private Date signDatetime;

    private Integer teacherId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
