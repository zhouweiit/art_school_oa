package com.chengzi.art.school.oa.controller.admin;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.PermissionResourceDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/test")
@Slf4j
public class TestAdminController {

    @Autowired
    private PermissionResourceDao permissionResourceDao;

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public Object test() {
        List<PermissionResource> permissionResources = permissionResourceDao.selectAll();
        return permissionResources;
    }

}
