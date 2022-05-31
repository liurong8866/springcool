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
COPY ./target/cool-modules-file.jar /home/springcool/cool-modules-file.jar

# 启动文件服务
ENTRYPOINT ["java","-jar","cool-modules-file.jar"]