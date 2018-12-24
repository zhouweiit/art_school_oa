package com.chengzi.art.school.oa;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class},
		scanBasePackages = {"com.chengzi.art.school.oa"}
)
@Getter
public class Launch {

    private static ApplicationContext context;

	public static void main(String[] args) {
        context = SpringApplication.run(Launch.class, args);
	}

}

