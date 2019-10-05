package com.chengzi.art.school.oa.config.mysql;


import com.chengzi.art.school.oa.persistence.mysql.oa.model.Student;
import com.chengzi.art.school.oa.persistence.mysql.oa.model.Teacher;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;


/**
 * mysql datasource config
 * Created by zhouwei on 2018/12/24
 **/
@Configuration
public class MysqlOADataSourceConfig {

    @Value("${spring.datasource.oa.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.oa.url}")
    private String url;

    @Value("${spring.datasource.oa.username}")
    private String username;

    @Value("${spring.datasource.oa.password}")
    private String password;

    @Bean(name = "OADataSource")
    public DataSource OADataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(5);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setLogAbandoned(true);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(60);
        return dataSource;
    }

    @Bean(name = "OASqlSessionFactoryBean")
    public SqlSessionFactory getOASqlSessionFactoryBean(@Autowired @Qualifier("OADataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //注册相关的XML
        sqlSessionFactoryBean.setMapperLocations(
            new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/oa/model/teacher.xml"),
            new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/oa/model/student.xml")
        );

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //注册相关的类的别名
        configuration.getTypeAliasRegistry().registerAlias("teacher", Teacher.class);
        configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "OASqlSession")
    public SqlSessionTemplate getOASqlSession(@Autowired @Qualifier("OASqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
