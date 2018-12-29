#!/usr/bin/env bash

# 编译打包，并安装到本地仓库
mvn clean compile -DskipTests package install

# 项目打包成tar.gz
mvn assembly:single -Pdev -DskipTests