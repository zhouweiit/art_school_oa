package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResource {

    private Integer id;

    private String name;

    private Integer parentId;

    private String uniqueResourceName;

    private Integer type;

    private String url;

    private String icon;

    private Integer order;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
