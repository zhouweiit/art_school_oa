package com.chengzi.art.school.oa.persistence.mysql.oa.dao;

import com.chengzi.art.school.framework.dao.AbstractDaoSupport;
import com.chengzi.art.school.oa.persistence.mysql.oa.model.Teacher;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Repository
public class TeacherDao extends AbstractDaoSupport<Teacher, Integer> {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return Teacher.class.getName();
    }
}