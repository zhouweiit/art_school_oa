package com.chengzi.art.school.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
	exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class, RedisAutoConfiguration.class},
	scanBasePackages = {"com.chengzi.art.school.oa"}
)
@EnableTransactionManagement
public class Launch {

    private static ApplicationContext context;

    private static Environment env;

	public static void main(String[] args) {
        context = SpringApplication.run(Launch.class, args);
		env = context.getEnvironment();
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static Environment getEnv() {
		return env;
	}

}

