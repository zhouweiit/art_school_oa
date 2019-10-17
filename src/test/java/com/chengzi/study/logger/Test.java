package com.chengzi.study.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhouwei on 2019/10/17
 **/
public class Test {

    /**
     *
     * slf4j只是一个门面框架，并没有相关的具体实现，需要使用相关的桥梁，用来使用具体的日志框架
     *
     * slf4j-jdk14：slf4j到jdk-logging的桥梁
       slf4j-log4j12：slf4j到log4j1的桥梁
       log4j-slf4j-impl：slf4j到log4j2的桥梁
       logback-classic：slf4j到logback的桥梁
       slf4j-jcl：slf4j到commons-logging的桥梁
     *
     *
     * 总结下：
     * 1. 每个具体的日志框架要对接slf4j，需要实现两个东西：
     *    A. 为slf4j提供一个桥梁，让slf4j可以使用这个日志工具
     *    B. 为slf4j提供一个桥梁，让自己的LoggerFactory。getlogger的时候，可以获取到slf4j的配置，采用slf4j的配置来书写文档
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("test");
        logger.error("test");
    }
}
