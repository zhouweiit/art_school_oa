package com.chengzi.art.school.oa.persistence.mysql.artoa.dao;

import com.chengzi.art.school.framework.dao.AbstractDaoSupport;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.Clazz;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserAuth;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAuthDao extends AbstractDaoSupport<UserAuth, Integer> {

    @Autowired
    @Qualifier("OASqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return UserAuth.class.getName();
    }

    public UserAuth selectByLoginName(String loginName) {
        return sqlSessionTemplate.selectOne(getNamespace() + ".selectByLoginName", loginName);
    }

    public void updateUserPassword(Integer userBaseId, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("userBaseId", userBaseId);
        params.put("loginPassword", password);
        sqlSessionTemplate.update(getNamespace() + ".updateUserPassword", params);
    }
}
