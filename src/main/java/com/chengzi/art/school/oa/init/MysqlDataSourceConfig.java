package com.chengzi.art.school.oa.init;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * mysql datasource config
 * Created by zhouwei on 2018/12/24
 **/
@Configuration
public class MysqlDataSourceConfig {

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

    @Bean(name = "OAJdbcTemplate")
    public JdbcTemplate OAJdbcTemplate(@Autowired DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}
