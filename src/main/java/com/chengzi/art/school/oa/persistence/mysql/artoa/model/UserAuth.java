package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {

    private Integer userBaseId;

    private String loginName;

    private String salt;

    private String loginPassword;

    private String roleId;

    private String permissionResourceId;

    private Date lastLoginDatetime;

    private Integer schoolGroupId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

}
