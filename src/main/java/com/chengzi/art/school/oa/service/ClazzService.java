package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.ClazzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzService {

    @Autowired
    private ClazzDao clazzDao;

}
