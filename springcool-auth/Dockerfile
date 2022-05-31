# 基础镜像
FROM  openjdk:8-jre
# author
MAINTAINER xueyi

# 挂载目录
VOLUME /home/xueyi
# 创建目录
RUN mkdir -p /home/xueyi
# 指定路径
WORKDIR /home/xueyi
# 复制jar文件到路径
COPY ./target/springcool-auth.jar /home/xueyi/springcool-auth.jar

# 启动认证服务
ENTRYPOINT ["java","-jar","springcool-auth.jar"]