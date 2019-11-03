package com.chengzi.art.school.oa.persistence.mysql.artoa.dao;

import com.chengzi.art.school.framework.dao.AbstractDaoSupport;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.Clazz;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResourceRole;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PermissionResourceRoleDao extends AbstractDaoSupport<PermissionResourceRole, Integer> {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return PermissionResourceRole.class.getName();
    }

    public List<PermissionResourceRole> selectByIds(Collection<Integer> roleIds) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleIds", roleIds);
        return sqlSessionTemplate.selectList(getNamespace() + ".selectByIds", params);
    }

}
