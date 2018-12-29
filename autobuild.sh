#!/usr/bin/env bash

# 编译打包，并安装到本地仓库
mvn clean compile -DskipTests package install

# 项目打包成tar.gz
mvn org.apache.maven.plugins:maven-assembly-plugin:2.5.4:assembly -Ponline -DskipTests