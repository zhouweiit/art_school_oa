package com.chengzi.art.school.oa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 所有的配置文件配置到@PropertySource主键里面
 */
@Configuration
@PropertySource(value = {"classpath:/db.properties"})
public class Properties {
}
