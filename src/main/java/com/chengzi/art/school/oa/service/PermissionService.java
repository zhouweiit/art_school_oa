package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.PermissionResourceDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.PermissionResourceRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    private PermissionResourceDao permissionResourceDao;

    @Autowired
    private PermissionResourceRoleDao permissionResourceRoleDao;



}
