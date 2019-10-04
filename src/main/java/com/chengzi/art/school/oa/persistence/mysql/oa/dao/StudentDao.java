package com.chengzi.art.school.oa.persistence.mysql.oa.dao;

import com.chengzi.art.school.oa.persistence.mysql.oa.model.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    public Student loadById(int id) {
        return sqlSessionTemplate.selectOne("com.chengzi.art.school.oa.persistence.mysql.oa.model.Student.getById", id);
    }

}
