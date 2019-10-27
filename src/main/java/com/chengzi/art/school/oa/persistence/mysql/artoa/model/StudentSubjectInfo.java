package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentSubjectInfo {

    private Integer id;

    private Integer studentId;

    private Integer subject;

    private Integer totalMinuteNum;

    private Integer leftMinuteNum;

    private String checkLog;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
