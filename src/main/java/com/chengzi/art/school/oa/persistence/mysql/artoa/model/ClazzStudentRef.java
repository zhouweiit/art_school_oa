package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzStudentRef {

    private Integer id;

    private Integer clazzId;

    private Integer studentId;

    private Integer schoolGroupId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
