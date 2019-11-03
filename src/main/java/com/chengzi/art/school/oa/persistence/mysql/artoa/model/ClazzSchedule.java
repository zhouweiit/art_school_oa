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
public class ClazzSchedule {

    private Integer id;

    private Integer clazzId;

    private Date startDatetime;

    private Date endDatetime;

    private Integer clazzHour;

    private String checkStudentInfo;

    private Integer teacherId;

    private Integer schoolRoomId;

    private Integer schoolGroupId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
