package com.chengzi.art.school.oa.config.mysql;


import com.chengzi.art.school.oa.persistence.mysql.artoa.model.*;
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

    @Value("${spring.datasource.artoa.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.artoa.url}")
    private String url;

    @Value("${spring.datasource.artoa.username}")
    private String username;

    @Value("${spring.datasource.artoa.password}")
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
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/Clazz.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/ClazzSchedule.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/ClazzStudentRef.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/SchoolRoom.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/School.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/SchoolGroup.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/SchoolConfig.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/StudentSubjectHour.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/PermissionResource.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/PermissionResourceRole.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/UserBase.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/UserAuth.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/UserStudentExt.xml"),
                new ClassPathResource("/com/chengzi/art/school/oa/persistence/mysql/artoa/model/UserTeacherExt.xml")
        );

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        //注册相关的类的别名
        configuration.getTypeAliasRegistry().registerAlias("Clazz", ClazzSchedule.class);
        configuration.getTypeAliasRegistry().registerAlias("ClazzSchedule", Clazz.class);
        configuration.getTypeAliasRegistry().registerAlias("ClazzStudentRef", ClazzStudentRef.class);
        configuration.getTypeAliasRegistry().registerAlias("SchoolRoom", SchoolRoom.class);
        configuration.getTypeAliasRegistry().registerAlias("School", School.class);
        configuration.getTypeAliasRegistry().registerAlias("SchoolGroup", SchoolGroup.class);
        configuration.getTypeAliasRegistry().registerAlias("SchoolConfig", SchoolConfig.class);
        configuration.getTypeAliasRegistry().registerAlias("StudentSubjectHour", StudentSubjectHour.class);
        configuration.getTypeAliasRegistry().registerAlias("UserBase", UserBase.class);
        configuration.getTypeAliasRegistry().registerAlias("PermissionResource", PermissionResource.class);
        configuration.getTypeAliasRegistry().registerAlias("PermissionResourceRole", PermissionResourceRole.class);
        configuration.getTypeAliasRegistry().registerAlias("UserAuth", UserAuth.class);
        configuration.getTypeAliasRegistry().registerAlias("UserStudentExt", UserStudentExt.class);
        configuration.getTypeAliasRegistry().registerAlias("UserTeacherExt", UserTeacherExt.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "OASqlSession")
    public SqlSessionTemplate getOASqlSession(@Autowired @Qualifier("OASqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
