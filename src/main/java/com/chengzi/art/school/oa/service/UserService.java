package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.UserAuthDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.UserBaseDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResource;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserAuth;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private UserBaseDao userBaseDao;

    @Autowired
    private PermissionService permissionService;

    public UserAuth loadUserAuth(Integer id) {
        return userAuthDao.selectByPrimaryKey(id);
    }

    public UserBase loadUserBaes(Integer id) {
        return userBaseDao.selectByPrimaryKey(id);
    }

    public Set<PermissionResource> loadUserPermission(Integer id) {
        UserAuth userAuth = loadUserAuth(id);
        Set<Integer> roleIds = UserAuth.splitRoleId(userAuth.getRoleId());
        Set<Integer> resourceIds = UserAuth.splitPermissionResourceId(userAuth.getPermissionResourceId());
        return permissionService.loadPermissionResource(roleIds, resourceIds);
    }

    public void updateUserPassword(Integer userBaseId, String salt, String password) {
        String newPassword = UserAuth.createPassword(salt, password);
        userAuthDao.updateUserPassword(userBaseId, newPassword);
    }

}
