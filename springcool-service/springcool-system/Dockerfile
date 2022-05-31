# 基础镜像
FROM  openjdk:8-jre
# author
MAINTAINER springcool

# 挂载目录
VOLUME /home/springcool
# 创建目录
RUN mkdir -p /home/springcool
# 指定路径
WORKDIR /home/springcool
# 复制jar文件到路径
COPY ./target/springcool-modules-system.jar /home/springcool/springcool-modules-system.jar

# 启动系统服务
ENTRYPOINT ["java","-jar","springcool-modules-system.jar"]