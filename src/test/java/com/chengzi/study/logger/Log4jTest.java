package com.chengzi.study.logger;

/**
 * Created by zhouwei on 2019/10/17
 **/
public class Log4jTest {
    /**
     <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-to-slf4j</artifactId>
        <version>2.12.1</version>
     </dependency>

     各个日志工具框架，他们会自己实现sfl4j（各个门面框架）的相关jar包，getLogger的时候，最后会调用slf4j的getLog，

     具体参考：SLF4JLoggerContext、SLF4JLoggerContextFactory

     * @param args
     */

    public static void main(String[] args) {
        org.apache.logging.log4j.LogManager.getLogger(Log4jTest.class);
    }
}
