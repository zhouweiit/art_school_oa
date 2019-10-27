package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Data
public class ClazzSchedule {

    private Integer id;

    private Integer clazzId;

    private Date startDatetime;

    private Date endDatetime;

    private String checkStudentInfo;

    private Integer teacherId;

    private Integer roomId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
