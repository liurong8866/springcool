#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/quartz.sql ./mysql/db
cp ../sql/cool_1.sql ./mysql/db
cp ../sql/cool_2.sql ./mysql/db
cp ../sql/cool_config.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../cool-ui/main/dist/** ./nginx/html/main
cp -r ../cool-ui/administrator/dist/** ./nginx/html/administrator


# copy jar
echo "begin copy cool-gateway "
cp ../cool-gateway/target/cool-gateway.jar ./cool/gateway/jar

echo "begin copy cool-auth "
cp ../cool-auth/target/cool-auth.jar ./cool/auth/jar

echo "begin copy cool-visual "
cp ../cool-visual/cool-monitor/target/cool-visual-monitor.jar  ./cool/visual/monitor/jar

echo "begin copy cool-modules-system "
cp ../cool-modules/cool-system/target/cool-modules-system.jar ./cool/modules/system/jar

echo "begin copy cool-modules-tenant "
cp ../cool-modules/cool-tenant/target/cool-modules-tenant.jar ./cool/modules/tenant/jar

echo "begin copy cool-modules-file "
cp ../cool-modules/cool-file/target/cool-modules-file.jar ./cool/modules/file/jar

echo "begin copy cool-modules-job "
cp ../cool-modules/cool-job/target/cool-modules-job.jar ./cool/modules/job/jar

echo "begin copy cool-modules-gen "
cp ../cool-modules/cool-gen/target/cool-modules-gen.jar ./cool/modules/gen/jar