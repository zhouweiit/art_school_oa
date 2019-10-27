package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Data
public class Clazz {

    private Integer id;

    private String name;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
