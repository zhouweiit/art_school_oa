package com.chengzi.art.school.oa.persistence.mysql.artoa.dao;

import com.chengzi.art.school.framework.dao.AbstractDaoSupport;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.Clazz;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserTeacherExt;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserTeacherExtDao extends AbstractDaoSupport<UserTeacherExt, Integer> {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return UserTeacherExt.class.getName();
    }

}
