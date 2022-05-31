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
COPY ./target/springcool-auth.jar /home/springcool/springcool-auth.jar

# 启动认证服务
ENTRYPOINT ["java","-jar","springcool-auth.jar"]