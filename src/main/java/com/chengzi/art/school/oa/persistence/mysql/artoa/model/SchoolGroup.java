package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolGroup {

    private Integer id;

    private String name;

    private String simpleName;

    private String logoImgUrl;

    private String introduce;

    private String address;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
