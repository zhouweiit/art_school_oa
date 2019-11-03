package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {

    private Integer id;

    private Integer schoolId;

    private String name;

    private Integer subject;

    private Integer teacherId;

    private Integer clazzHour;

    private Integer minStudentNum;

    private Integer maxStudentNum;

    private Integer schoolGroupId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
