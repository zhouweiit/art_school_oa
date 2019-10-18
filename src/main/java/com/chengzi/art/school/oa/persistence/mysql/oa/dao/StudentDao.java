package com.chengzi.art.school.oa.persistence.mysql.oa.dao;

import com.chengzi.art.school.framework.dao.AbstractDaoSupport;
import com.chengzi.art.school.oa.persistence.mysql.oa.model.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends AbstractDaoSupport<Student, Integer> {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return Student.class.getName();
    }

}
