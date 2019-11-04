package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.ClazzDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClazzService {

    @Autowired
    private ClazzDao clazzDao;

    @Transactional
    public void test() {
        Clazz clazz = new Clazz();
        clazz.setSchoolId(1);
        clazz.setName("name");
        clazz.setSchoolGroupId(1);
        clazzDao.insert(clazz);
        System.out.println(clazz.getId());
    }

}
