drop database if exists `cool`;
drop database if exists `cool-job`;
drop database if exists `cool-config`;
drop database if exists `cool-seata`;
drop database if exists `cool-codegen`;

-- cool 核心表
create database `cool` default character set utf8mb4 collate utf8mb4_general_ci;

-- cool 任务相关库
create database `cool-job` default character set utf8mb4 collate utf8mb4_general_ci;

-- cool nacos配置相关库
create database `cool-config` default character set utf8mb4 collate utf8mb4_general_ci;

-- cool codegen相关库
create database `cool-codegen` default character set utf8mb4 collate utf8mb4_general_ci;

-- cool seata相关库
create database `cool-seata` default character set utf8mb4 collate utf8mb4_general_ci;
