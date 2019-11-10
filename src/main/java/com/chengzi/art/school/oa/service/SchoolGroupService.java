package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.SchoolGroupDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.SchoolGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolGroupService {

    @Autowired
    private SchoolGroupDao schoolGroupDao;

    public SchoolGroup loadSchoolGroupById(Integer id) {
        return schoolGroupDao.selectByPrimaryKey(id);
    }

}
