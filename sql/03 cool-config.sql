/*
 Navicat Premium Data Transfer

 Source Server         : localhost-cool
 Source Server Type    : MySQL
 Source Server Version : 100604
 Source Host           : 192.168.0.130:3306
 Source Schema         : cool-config

 Target Server Type    : MySQL
 Target Server Version : 100604
 File Encoding         : 65001

 Date: 02/06/2022 11:03:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8mb3_bin DEFAULT NULL,
  `encrypted_data_key` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
BEGIN;
INSERT INTO `config_info` VALUES (1, 'application-dev.yml', 'DEFAULT_GROUP', 'spring:\n  autoconfigure:\n    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n\n# feign 配置\nfeign:\n  sentinel:\n    enabled: true\n  okhttp:\n    enabled: true\n  httpclient:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 10000\n        readTimeout: 10000\n  compression:\n    request:\n      enabled: true\n    response:\n      enabled: true\n\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', 'aaa73b809cfd4d0058893aa13da57806', '2022-02-01 16:11:30', '2022-05-25 03:51:16', 'nacos', '192.168.0.101', '', '', '通用配置', 'null', 'null', 'yaml', '', NULL);
INSERT INTO `config_info` VALUES (2, 'application-secret-dev.yml', 'DEFAULT_GROUP', 'secret:\n  #redis参数信息\n  redis:\n    host: 192.168.0.130\n    port: 6379\n    password:\n  #服务状态监控参数信息\n  security:\n    name: cool\n    password: cool123\n    title: 服务状态监控\n  # swagger参数信息\n  swagger:\n    title: 接口文档\n    license: Powered By cool\n    licenseUrl: https://doc.cooltt.cn\n    basePackage: com.springcool.cool\n  # datasource主库参数信息\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://cool-mysql:3306/cool?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: 123456\n  # druid控制台参数信息\n  druid:\n    stat-view-servlet:\n      enabled: true\n      loginUsername: admin\n      loginPassword: 123456\n  # nacos参数信息\n  nacos:\n    serverAddr: cool-nacos:8848', '7e0b1618670e07a1d33672f993505581', '2022-02-01 16:11:30', '2022-06-01 23:42:15', 'nacos', '192.168.0.101', '', '', '通用参数配置', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (3, 'application-datasource-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring: \n  redis:\n    host: ${secret.redis.host}\n    port: ${secret.redis.port}\n    password: ${secret.redis.password}\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: ${secret.druid.stat-view-servlet.enabled}\n        loginUsername: ${secret.druid.stat-view-servlet.loginUsername}\n        loginPassword: ${secret.druid.stat-view-servlet.loginPassword}\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        breakAfterAcquireFailure: true\n        ConnectionErrorRetryAttempts: 2\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: ${secret.datasource.driver-class-name}\n            url: ${secret.datasource.url}\n            username: ${secret.datasource.username}\n            password: ${secret.datasource.password}\n          # 数据源信息会通过master库进行获取并生成，请在主库的cool_tenant_source中配置即可\n      # seata: true    # 开启seata代理，开启后默认每个数据源都代理，如果某个不需要代理可单独关闭\n\n# mybatis-plus配置\nmybatis-plus:\n  global-config:\n    # 是否控制台 print mybatis-plus 的 LOGO\n    banner: false\n    db-config:\n      # 字段验证策略之 select\n      selectStrategy: NOT_EMPTY\n      # 字段验证策略之 insert\n      insertStrategy: NOT_EMPTY\n      # 字段验证策略之 update\n      updateStrategy: NOT_EMPTY\n  # configuration:\n    # log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\n\n# seata配置\nseata:\n  # 默认关闭，如需启用spring.datasource.dynami.seata需要同时开启\n  enabled: false\n  # Seata 应用编号，默认为 ${spring.application.name}\n  application-id: ${spring.application.name}\n  # Seata 事务组编号，用于 TC 集群名\n  tx-service-group: ${spring.application.name}-group\n  # 关闭自动代理\n  enable-auto-data-source-proxy: false\n  config:\n    type: nacos\n    nacos:\n      serverAddr: ${secret.nacos.serverAddr}\n      group: SEATA_GROUP\n      namespace:\n  registry:\n    type: nacos\n    nacos:\n      application: seata-server\n      server-addr: ${secret.nacos.serverAddr}\n      namespace:\n', 'b121a215be33fcefadd0447186ee2126', '2022-02-01 16:11:30', '2022-06-01 17:47:18', 'nacos', '192.168.0.101', '', '', '通用动态多数据源配置', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (4, 'cool-gateway-dev.yml', 'DEFAULT_GROUP', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n  cloud:\r\n    gateway:\r\n      discovery:\r\n        locator:\r\n          lowerCaseServiceId: true\r\n          enabled: true\r\n      routes:\r\n        # 认证中心\r\n        - id: cool-auth\r\n          uri: lb://cool-auth\r\n          predicates:\r\n            - Path=/auth/**\r\n          filters:\r\n            # 验证码处理\r\n            - CacheRequestFilter\r\n            - ValidateCodeFilter\r\n            - StripPrefix=1\r\n        # 代码生成\r\n        - id: cool-gen\r\n          uri: lb://cool-gen\r\n          predicates:\r\n            - Path=/code/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 定时任务\r\n        - id: cool-job\r\n          uri: lb://cool-job\r\n          predicates:\r\n            - Path=/schedule/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 系统模块\r\n        - id: cool-system\r\n          uri: lb://cool-system\r\n          predicates:\r\n            - Path=/system/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 租户模块\r\n        - id: cool-tenant\r\n          uri: lb://cool-tenant\r\n          predicates:\r\n            - Path=/tenant/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 文件服务\r\n        - id: cool-file\r\n          uri: lb://cool-file\r\n          predicates:\r\n            - Path=/file/**\r\n          filters:\r\n            - StripPrefix=1\r\n\r\n# 安全配置\r\nsecurity:\r\n  # 验证码\r\n  captcha:\r\n    enabled: true\r\n    type: math\r\n  # 防止XSS攻击\r\n  xss:\r\n    enabled: true\r\n    excludeUrls:\r\n      - /system/notice\r\n  # 不校验白名单\r\n  ignore:\r\n    whites:\r\n      - /auth/logout\r\n      - /auth/login\r\n      - /auth/register\r\n      - /*/v2/api-docs\r\n      - /csrf\r\n', '20c5e882255155e0594f03af0877804a', '2022-02-01 16:11:30', '2022-04-07 07:47:32', NULL, '192.168.73.204', '', '', '网关模块', 'null', 'null', 'yaml', NULL, NULL);
INSERT INTO `config_info` VALUES (5, 'cool-auth-dev.yml', 'DEFAULT_GROUP', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n', 'b7354e1eb62c2d846d44a796d9ec6930', '2022-02-01 16:11:30', '2022-02-01 16:11:30', NULL, '0:0:0:0:0:0:0:1', '', '', '认证中心', 'null', 'null', 'yaml', NULL, NULL);
INSERT INTO `config_info` VALUES (6, 'cool-monitor-dev.yml', 'DEFAULT_GROUP', '# spring配置\r\nspring:\r\n  security:\r\n    user:\r\n      name: ${secret.security.name}\r\n      password: ${secret.security.password}\r\n  boot:\r\n    admin:\r\n      ui:\r\n        title: ${secret.security.title}\r\n', 'd8997d0707a2fd5d9fc4e8409da38129', '2022-02-01 16:11:30', '2022-02-01 16:11:30', NULL, '0:0:0:0:0:0:0:1', '', '', '监控中心', 'null', 'null', 'yaml', NULL, NULL);
INSERT INTO `config_info` VALUES (7, 'cool-tenant-dev.yml', 'DEFAULT_GROUP', 'springcool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - te_source\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.tenant\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 租户模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-tenant-group: default\n', '92c5115c882739ff47cb110946dd32a4', '2022-02-01 16:11:30', '2022-06-02 00:16:11', 'nacos', '192.168.0.101', '', '', '租户管理模块', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (8, 'cool-system-dev.yml', 'DEFAULT_GROUP', 'springcool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n  basePackage: ${secret.swagger.basePackage}\n  basePath:\n    - system.authority.controller\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', 'e26775ad66da4162453276fff4c603c2', '2022-02-01 16:11:30', '2022-06-02 00:15:57', 'nacos', '192.168.0.101', '', '', '系统模块', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (9, 'cool-gen-dev.yml', 'DEFAULT_GROUP', 'springcool:\n  # 租户配置\n  tenant:\n    # 非租户表配置\n    exclude-table:\n      - gen_table\n      - gen_table_column\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.gen\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n  configuration:\n    jdbc-type-for-null: \'null\'\n\n# swagger配置\nswagger:\n  title: 代码生成${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n# 代码生成\ngen: \n  # 作者\n  author: cool\n  # ui路径（空代表生成在后端主路径下，可设置为ui项目地址如：C:UserscoolMultiSaas-UI）\n  uiPath: \n  # 自动去除表前缀，默认是true\n  autoRemovePre: true\n  # 数据库映射\n  data-base:\n    # 字符串类型\n    type-str: [\"char\", \"varchar\", \"nvarchar\", \"varchar2\"]\n    # 文本类型\n    type-text: [\"tinytext\", \"text\", \"mediumtext\", \"longtext\"]\n    # 日期类型\n    type-date: [\"datetime\", \"time\", \"date\", \"timestamp\"]\n    # 时间类型\n    type-time: [\"datetime\", \"time\", \"date\", \"timestamp\"]\n    # 数字类型\n    type-number: [\"tinyint\", \"smallint\", \"mediumint\", \"int\", \"number\", \"integer\"]\n    # 长数字类型\n    type-long: [\"bigint\"]\n    # 浮点类型\n    type-float: [\"float\", \"double\", \"decimal\"]\n  # 字段配置\n  operate:\n    # 隐藏详情显示\n    not-view: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏新增显示\n    not-insert: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏编辑显示\n    not-edit: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏列表显示\n    not-list: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\n    # 隐藏查询显示\n    not-query: [\"id\", \"sort\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\n    # 隐藏导入显示\n    not-import: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏导出显示\n    not-export: [\"id\", \"sort\", \"createBy\", \"updateBy\"]\n  # 基类配置\n  entity:\n    # 必定隐藏字段（前后端均隐藏）\n    must-hide: [\"delFlag\", \"tenantId\", \"ancestors\"]\n    # 后端基类\n    back:\n      base: [\"id\", \"name\", \"status\", \"sort\", \"remark\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"delFlag\"]\n      tree: [\"parentId\", \"ancestors\"]\n      sub: []\n      tenant: [\"tenantId\"]\n    # 前端基类\n    front:\n      base: [\"createBy\", \"createName\", \"createTime\", \"updateBy\", \"updateName\", \"updateTime\", \"delFlag\"]\n      tree: [\"parentId\", \"ancestors\"]\n      sub: []\n      tenant: [\"tenantId\"]\n  # 表前缀（与remove-lists对应）\n  dict-type-remove: [\"sys_\", \"te_\", \"gen_\"]\n  # 表更替配置\n  remove-lists:\n      # 表前缀（生成类名不会包含表前缀）\n    - prefix: sys_\n      # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n      packageName: com.cool.system\n      frontPackageName: system\n    - prefix: te_\n      packageName: com.cool.tenant\n      frontPackageName: tenant\n    - prefix: gen_\n      packageName: com.cool.gen\n      frontPackageName: gen\n', '329e88a8de7fb74e8e6e66c4c55bbe67', '2022-02-01 16:11:30', '2022-06-02 00:16:29', 'nacos', '192.168.0.101', '', '', '代码生成', 'null', 'null', 'yaml', '', '');
INSERT INTO `config_info` VALUES (10, 'cool-job-dev.yml', 'DEFAULT_GROUP', '# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.job\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 定时任务${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n# seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-job-group: default\n', '70e79c9aa279bb7a47ac4ec3edd0689f', '2022-02-01 16:11:30', '2022-05-25 03:54:39', 'nacos', '192.168.0.101', '', '', '定时任务', 'null', 'null', 'yaml', '', NULL);
INSERT INTO `config_info` VALUES (11, 'cool-file-dev.yml', 'DEFAULT_GROUP', '# 本地文件上传\r\nfile:\r\n  domain: http://127.0.0.1:9300\r\n  path: D:/cool/uploadPath\r\n  prefix: /statics\r\n\r\n# FastDFS配置\r\nfdfs:\r\n  domain: http://8.129.231.12\r\n  soTimeout: 3000\r\n  connectTimeout: 2000\r\n  trackerList: 8.129.231.12:22122\r\n\r\n# Minio配置\r\nminio:\r\n  url: http://8.129.231.12:9000\r\n  accessKey: minioadmin\r\n  secretKey: minioadmin\r\n  bucketName: test', 'e507ba4ba82516bd5b9d1bea147bd910', '2022-02-01 16:11:30', '2022-04-07 07:45:53', NULL, '192.168.73.204', '', '', '文件服务', 'null', 'null', 'yaml', NULL, NULL);
INSERT INTO `config_info` VALUES (12, 'sentinel-cool-gateway', 'DEFAULT_GROUP', '[\r\n    {\r\n        \"resource\": \"cool-auth\",\r\n        \"count\": 500,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"cool-system\",\r\n        \"count\": 1000,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"cool-tenant\",\r\n        \"count\": 500,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"cool-gen\",\r\n        \"count\": 200,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"cool-job\",\r\n        \"count\": 300,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    }\r\n]', '9f3a3069261598f74220bc47958ec252', '2022-02-01 16:11:30', '2022-02-01 16:11:30', NULL, '0:0:0:0:0:0:0:1', '', '', '限流策略', 'null', 'null', 'json', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='增加租户字段';

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_beta';

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  `src_user` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source user',
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_info_tag';

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='config_tag_relation';

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='集群、各Group容量信息表';

-- ----------------------------
-- Records of group_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info` (
  `id` bigint(64) unsigned NOT NULL,
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `group_id` varchar(128) COLLATE utf8mb3_bin NOT NULL,
  `app_name` varchar(128) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'app_name',
  `content` longtext COLLATE utf8mb3_bin NOT NULL,
  `md5` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp(),
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp(),
  `src_user` text COLLATE utf8mb3_bin DEFAULT NULL,
  `src_ip` varchar(50) COLLATE utf8mb3_bin DEFAULT NULL,
  `op_type` char(10) COLLATE utf8mb3_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text COLLATE utf8mb3_bin DEFAULT NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='多租户改造';

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
BEGIN;
INSERT INTO `his_config_info` VALUES (2, 1, 'application-secret-dev.yml', 'DEFAULT_GROUP', '', 'secret:\r\n  #redis参数信息\r\n  redis:\r\n    host: localhost\r\n    port: 6379\r\n    password:\r\n  #服务状态监控参数信息\r\n  security:\r\n    name: cool\r\n    password: cool123\r\n    title: 服务状态监控\r\n  # swagger参数信息\r\n  swagger:\r\n    title: 接口文档\r\n    license: Powered By cool\r\n    licenseUrl: https://doc.cooltt.cn\r\n  # datasource主库参数信息\r\n  datasource:\r\n    driver-class-name: com.mysql.cj.jdbc.Driver\r\n    url: jdbc:mysql://localhost:3306/cool-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\r\n    username: root\r\n    password: password\r\n  # druid控制台参数信息\r\n  druid:\r\n    stat-view-servlet:\r\n      enabled: true\r\n      loginUsername: admin\r\n      loginPassword: 123456\r\n  # nacos参数信息\r\n  nacos:\r\n    serverAddr: 127.0.0.1:8848', '65616df6c07cd55cdf71ed9f80abfd75', '2022-05-24 20:03:35', '2022-05-25 00:03:35', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (8, 2, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\r\n  # 租户配置\r\n  tenant:\r\n    # 公共表配置\r\n    common-table:\r\n      - sys_menu\r\n      - sys_module\r\n    # 非租户表配置\r\n    exclude-table:\r\n      - te_tenant\r\n      - te_strategy\r\n      - sys_dict_type\r\n      - sys_dict_data\r\n      - sys_config\r\n\r\n# mybatis-plus配置\r\nmybatis-plus:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.cool.system\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath:mapper/**/*.xml\r\n\r\n# swagger配置\r\nswagger:\r\n  title: 系统模块${secret.swagger.title}\r\n  license: ${secret.swagger.license}\r\n  licenseUrl: ${secret.swagger.licenseUrl}\r\n\r\n#seata配置\r\nseata:\r\n  # 服务配置项\r\n  service:\r\n    # 虚拟组和分组的映射\r\n    vgroup-mapping:\r\n      cool-system-group: default', 'baa88834ecaed5842a837397e66f4c59', '2022-05-24 23:19:59', '2022-05-25 03:19:59', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (1, 3, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  autoconfigure:\r\n    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure\r\n  mvc:\r\n    pathmatch:\r\n      matching-strategy: ant_path_matcher\r\n\r\n# feign 配置\r\nfeign:\r\n  sentinel:\r\n    enabled: true\r\n  okhttp:\r\n    enabled: true\r\n  httpclient:\r\n    enabled: false\r\n  client:\r\n    config:\r\n      default:\r\n        connectTimeout: 10000\r\n        readTimeout: 10000\r\n  compression:\r\n    request:\r\n      enabled: true\r\n    response:\r\n      enabled: true\r\n\r\n# 暴露监控端点\r\nmanagement:\r\n  endpoints:\r\n    web:\r\n      exposure:\r\n        include: \'*\'\r\n', 'fd32652eb3baec85e5c92385dbbfa81a', '2022-05-24 23:49:06', '2022-05-25 03:49:06', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (1, 4, 'application-dev.yml', 'DEFAULT_GROUP', '', 'spring:\n  autoconfigure:\n    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n\n# feign 配置\nfeign:\n  sentinel:\n    enabled: false\n  okhttp:\n    enabled: true\n  httpclient:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 10000\n        readTimeout: 10000\n  compression:\n    request:\n      enabled: true\n    response:\n      enabled: true\n\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', '0139c28368d7e9ddb35dd1f09c277854', '2022-05-24 23:51:16', '2022-05-25 03:51:16', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (7, 5, 'cool-tenant-dev.yml', 'DEFAULT_GROUP', '', 'cool:\r\n  # 租户配置\r\n  tenant:\r\n    # 公共表配置\r\n    common-table:\r\n      - sys_menu\r\n      - sys_module\r\n    # 非租户表配置\r\n    exclude-table:\r\n      - te_tenant\r\n      - te_strategy\r\n      - te_source\r\n\r\n# mybatis-plus配置\r\nmybatis-plus:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.cool.tenant\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath:mapper/**/*.xml\r\n\r\n# swagger配置\r\nswagger:\r\n  title: 租户模块${secret.swagger.title}\r\n  license: ${secret.swagger.license}\r\n  licenseUrl: ${secret.swagger.licenseUrl}\r\n\r\n#seata配置\r\nseata:\r\n  # 服务配置项\r\n  service:\r\n    # 虚拟组和分组的映射\r\n    vgroup-mapping:\r\n      cool-tenant-group: default\r\n', 'b4dc974093db74bc231ff01659aac6c0', '2022-05-24 23:53:56', '2022-05-25 03:53:56', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (9, 6, 'cool-gen-dev.yml', 'DEFAULT_GROUP', '', 'cool:\r\n  # 租户配置\r\n  tenant:\r\n    # 非租户表配置\r\n    exclude-table:\r\n      - gen_table\r\n      - gen_table_column\r\n\r\n# mybatis-plus配置\r\nmybatis-plus:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.cool.gen\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath:mapper/**/*.xml\r\n  configuration:\r\n    jdbc-type-for-null: \'null\'\r\n\r\n# swagger配置\r\nswagger:\r\n  title: 代码生成${secret.swagger.title}\r\n  license: ${secret.swagger.license}\r\n  licenseUrl: ${secret.swagger.licenseUrl}\r\n\r\n# 代码生成\r\ngen: \r\n  # 作者\r\n  author: cool\r\n  # ui路径（空代表生成在后端主路径下，可设置为ui项目地址如：C:UserscoolMultiSaas-UI）\r\n  uiPath: \r\n  # 自动去除表前缀，默认是true\r\n  autoRemovePre: true\r\n  # 数据库映射\r\n  data-base:\r\n    # 字符串类型\r\n    type-str: [\"char\", \"varchar\", \"nvarchar\", \"varchar2\"]\r\n    # 文本类型\r\n    type-text: [\"tinytext\", \"text\", \"mediumtext\", \"longtext\"]\r\n    # 日期类型\r\n    type-date: [\"datetime\", \"time\", \"date\", \"timestamp\"]\r\n    # 时间类型\r\n    type-time: [\"datetime\", \"time\", \"date\", \"timestamp\"]\r\n    # 数字类型\r\n    type-number: [\"tinyint\", \"smallint\", \"mediumint\", \"int\", \"number\", \"integer\"]\r\n    # 长数字类型\r\n    type-long: [\"bigint\"]\r\n    # 浮点类型\r\n    type-float: [\"float\", \"double\", \"decimal\"]\r\n  # 字段配置\r\n  operate:\r\n    # 隐藏详情显示\r\n    not-view: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\r\n    # 隐藏新增显示\r\n    not-insert: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\r\n    # 隐藏编辑显示\r\n    not-edit: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\r\n    # 隐藏列表显示\r\n    not-list: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\r\n    # 隐藏查询显示\r\n    not-query: [\"id\", \"sort\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\r\n    # 隐藏导入显示\r\n    not-import: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\r\n    # 隐藏导出显示\r\n    not-export: [\"id\", \"sort\", \"createBy\", \"updateBy\"]\r\n  # 基类配置\r\n  entity:\r\n    # 必定隐藏字段（前后端均隐藏）\r\n    must-hide: [\"delFlag\", \"tenantId\", \"ancestors\"]\r\n    # 后端基类\r\n    back:\r\n      base: [\"id\", \"name\", \"status\", \"sort\", \"remark\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"delFlag\"]\r\n      tree: [\"parentId\", \"ancestors\"]\r\n      sub: []\r\n      tenant: [\"tenantId\"]\r\n    # 前端基类\r\n    front:\r\n      base: [\"createBy\", \"createName\", \"createTime\", \"updateBy\", \"updateName\", \"updateTime\", \"delFlag\"]\r\n      tree: [\"parentId\", \"ancestors\"]\r\n      sub: []\r\n      tenant: [\"tenantId\"]\r\n  # 表前缀（与remove-lists对应）\r\n  dict-type-remove: [\"sys_\", \"te_\", \"gen_\"]\r\n  # 表更替配置\r\n  remove-lists:\r\n      # 表前缀（生成类名不会包含表前缀）\r\n    - prefix: sys_\r\n      # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\r\n      packageName: com.cool.system\r\n      frontPackageName: system\r\n    - prefix: te_\r\n      packageName: com.cool.tenant\r\n      frontPackageName: tenant\r\n    - prefix: gen_\r\n      packageName: com.cool.gen\r\n      frontPackageName: gen\r\n', '5ff9aadb9fa3431e30971b2f74a53f56', '2022-05-24 23:54:26', '2022-05-25 03:54:26', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (10, 7, 'cool-job-dev.yml', 'DEFAULT_GROUP', '', '# mybatis-plus配置\r\nmybatis-plus:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.cool.job\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath:mapper/**/*.xml\r\n\r\n# swagger配置\r\nswagger:\r\n  title: 定时任务${secret.swagger.title}\r\n  license: ${secret.swagger.license}\r\n  licenseUrl: ${secret.swagger.licenseUrl}\r\n\r\n# seata配置\r\nseata:\r\n  # 服务配置项\r\n  service:\r\n    # 虚拟组和分组的映射\r\n    vgroup-mapping:\r\n      cool-job-group: default\r\n', '1c829aaec16b457690e1aa8d447a66f4', '2022-05-24 23:54:39', '2022-05-25 03:54:39', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (2, 8, 'application-secret-dev.yml', 'DEFAULT_GROUP', '', 'secret:\n  #redis参数信息\n  redis:\n    host: cool-redis\n    port: 6379\n    password:\n  #服务状态监控参数信息\n  security:\n    name: cool\n    password: cool123\n    title: 服务状态监控\n  # swagger参数信息\n  swagger:\n    title: 接口文档\n    license: Powered By cool\n    licenseUrl: https://doc.cooltt.cn\n  # datasource主库参数信息\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://cool-mysql:3306/cool?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: 123456\n  # druid控制台参数信息\n  druid:\n    stat-view-servlet:\n      enabled: true\n      loginUsername: admin\n      loginPassword: 123456\n  # nacos参数信息\n  nacos:\n    serverAddr: cool-nacos:8848', 'e38dd5a41f147c7b347dcc7952dc7e1d', '2022-05-25 00:44:57', '2022-05-25 04:44:57', 'nacos', '192.168.0.101', 'U', '', NULL);
INSERT INTO `his_config_info` VALUES (0, 9, 'xueyi-gateway-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n  cloud:\r\n    gateway:\r\n      discovery:\r\n        locator:\r\n          lowerCaseServiceId: true\r\n          enabled: true\r\n      routes:\r\n        # 认证中心\r\n        - id: cool-auth\r\n          uri: lb://cool-auth\r\n          predicates:\r\n            - Path=/auth/**\r\n          filters:\r\n            # 验证码处理\r\n            - CacheRequestFilter\r\n            - ValidateCodeFilter\r\n            - StripPrefix=1\r\n        # 代码生成\r\n        - id: cool-gen\r\n          uri: lb://cool-gen\r\n          predicates:\r\n            - Path=/code/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 定时任务\r\n        - id: cool-job\r\n          uri: lb://cool-job\r\n          predicates:\r\n            - Path=/schedule/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 系统模块\r\n        - id: cool-system\r\n          uri: lb://cool-system\r\n          predicates:\r\n            - Path=/system/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 租户模块\r\n        - id: cool-tenant\r\n          uri: lb://cool-tenant\r\n          predicates:\r\n            - Path=/tenant/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 文件服务\r\n        - id: cool-file\r\n          uri: lb://cool-file\r\n          predicates:\r\n            - Path=/file/**\r\n          filters:\r\n            - StripPrefix=1\r\n\r\n# 安全配置\r\nsecurity:\r\n  # 验证码\r\n  captcha:\r\n    enabled: true\r\n    type: math\r\n  # 防止XSS攻击\r\n  xss:\r\n    enabled: true\r\n    excludeUrls:\r\n      - /system/notice\r\n  # 不校验白名单\r\n  ignore:\r\n    whites:\r\n      - /auth/logout\r\n      - /auth/login\r\n      - /auth/register\r\n      - /*/v2/api-docs\r\n      - /csrf\r\n', '9502154a3355c60d3c0f4a108ab7e29a', '2022-05-25 03:29:15', '2022-06-01 17:30:06', NULL, '192.168.0.101', 'I', '', '');
INSERT INTO `his_config_info` VALUES (0, 10, 'xueyi-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 03:31:48', '2022-06-01 17:32:27', NULL, '192.168.0.101', 'I', '', '');
INSERT INTO `his_config_info` VALUES (22, 11, 'xueyi-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 03:32:52', '2022-06-01 17:33:26', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (3, 12, 'application-datasource-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\r\nspring: \r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n  datasource:\r\n    druid:\r\n      stat-view-servlet:\r\n        enabled: ${secret.druid.stat-view-servlet.enabled}\r\n        loginUsername: ${secret.druid.stat-view-servlet.loginUsername}\r\n        loginPassword: ${secret.druid.stat-view-servlet.loginPassword}\r\n    dynamic:\r\n      druid:\r\n        initial-size: 5\r\n        min-idle: 5\r\n        maxActive: 20\r\n        maxWait: 60000\r\n        timeBetweenEvictionRunsMillis: 60000\r\n        minEvictableIdleTimeMillis: 300000\r\n        validationQuery: SELECT 1 FROM DUAL\r\n        testWhileIdle: true\r\n        testOnBorrow: false\r\n        testOnReturn: false\r\n        poolPreparedStatements: true\r\n        breakAfterAcquireFailure: true\r\n        ConnectionErrorRetryAttempts: 2\r\n        maxPoolPreparedStatementPerConnectionSize: 20\r\n        filters: stat,slf4j\r\n        connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000\r\n      datasource:\r\n          # 主库数据源\r\n          master:\r\n            driver-class-name: ${secret.datasource.driver-class-name}\r\n            url: ${secret.datasource.url}\r\n            username: ${secret.datasource.username}\r\n            password: ${secret.datasource.password}\r\n          # 数据源信息会通过master库进行获取并生成，请在主库的cool_tenant_source中配置即可\r\n      # seata: true    # 开启seata代理，开启后默认每个数据源都代理，如果某个不需要代理可单独关闭\r\n\r\n# mybatis-plus配置\r\nmybatis-plus:\r\n  global-config:\r\n    # 是否控制台 print mybatis-plus 的 LOGO\r\n    banner: false\r\n    db-config:\r\n      # 字段验证策略之 select\r\n      selectStrategy: NOT_EMPTY\r\n      # 字段验证策略之 insert\r\n      insertStrategy: NOT_EMPTY\r\n      # 字段验证策略之 update\r\n      updateStrategy: NOT_EMPTY\r\n  # configuration:\r\n    # log-impl: org.apache.ibatis.logging.stdout.StdOutImpl\r\n\r\n# seata配置\r\nseata:\r\n  # 默认关闭，如需启用spring.datasource.dynami.seata需要同时开启\r\n  enabled: false\r\n  # Seata 应用编号，默认为 ${spring.application.name}\r\n  application-id: ${spring.application.name}\r\n  # Seata 事务组编号，用于 TC 集群名\r\n  tx-service-group: ${spring.application.name}-group\r\n  # 关闭自动代理\r\n  enable-auto-data-source-procool: false\r\n  config:\r\n    type: nacos\r\n    nacos:\r\n      serverAddr: ${secret.nacos.serverAddr}\r\n      group: SEATA_GROUP\r\n      namespace:\r\n  registry:\r\n    type: nacos\r\n    nacos:\r\n      application: seata-server\r\n      server-addr: ${secret.nacos.serverAddr}\r\n      namespace:\r\n', 'a4fa48455b5ab1cff8499c895456012f', '2022-05-25 03:47:52', '2022-06-01 17:47:18', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (0, 13, 'xueyi-auth-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n', '56ea04390f33dc91dc8e1f730120bf36', '2022-05-25 03:55:40', '2022-06-01 17:54:29', NULL, '192.168.0.101', 'I', '', '');
INSERT INTO `his_config_info` VALUES (0, 14, 'xueyi-file-dev.yml', 'DEFAULT_GROUP', '', '# 本地文件上传\r\nfile:\r\n  domain: http://127.0.0.1:9300\r\n  path: D:/cool/uploadPath\r\n  prefix: /statics\r\n\r\n# FastDFS配置\r\nfdfs:\r\n  domain: http://8.129.231.12\r\n  soTimeout: 3000\r\n  connectTimeout: 2000\r\n  trackerList: 8.129.231.12:22122\r\n\r\n# Minio配置\r\nminio:\r\n  url: http://8.129.231.12:9000\r\n  accessKey: minioadmin\r\n  secretKey: minioadmin\r\n  bucketName: test', 'a2e544b7c911083132fbe7967d4598d0', '2022-05-25 03:58:05', '2022-06-01 17:56:43', NULL, '192.168.0.101', 'I', '', '');
INSERT INTO `his_config_info` VALUES (21, 15, 'xueyi-gateway-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n  cloud:\r\n    gateway:\r\n      discovery:\r\n        locator:\r\n          lowerCaseServiceId: true\r\n          enabled: true\r\n      routes:\r\n        # 认证中心\r\n        - id: cool-auth\r\n          uri: lb://cool-auth\r\n          predicates:\r\n            - Path=/auth/**\r\n          filters:\r\n            # 验证码处理\r\n            - CacheRequestFilter\r\n            - ValidateCodeFilter\r\n            - StripPrefix=1\r\n        # 代码生成\r\n        - id: cool-gen\r\n          uri: lb://cool-gen\r\n          predicates:\r\n            - Path=/code/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 定时任务\r\n        - id: cool-job\r\n          uri: lb://cool-job\r\n          predicates:\r\n            - Path=/schedule/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 系统模块\r\n        - id: cool-system\r\n          uri: lb://cool-system\r\n          predicates:\r\n            - Path=/system/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 租户模块\r\n        - id: cool-tenant\r\n          uri: lb://cool-tenant\r\n          predicates:\r\n            - Path=/tenant/**\r\n          filters:\r\n            - StripPrefix=1\r\n        # 文件服务\r\n        - id: cool-file\r\n          uri: lb://cool-file\r\n          predicates:\r\n            - Path=/file/**\r\n          filters:\r\n            - StripPrefix=1\r\n\r\n# 安全配置\r\nsecurity:\r\n  # 验证码\r\n  captcha:\r\n    enabled: true\r\n    type: math\r\n  # 防止XSS攻击\r\n  xss:\r\n    enabled: true\r\n    excludeUrls:\r\n      - /system/notice\r\n  # 不校验白名单\r\n  ignore:\r\n    whites:\r\n      - /auth/logout\r\n      - /auth/login\r\n      - /auth/register\r\n      - /*/v2/api-docs\r\n      - /csrf\r\n', '9502154a3355c60d3c0f4a108ab7e29a', '2022-05-25 05:25:41', '2022-06-01 19:17:35', NULL, '192.168.0.101', 'D', '', '');
INSERT INTO `his_config_info` VALUES (22, 16, 'xueyi-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.xueyi.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '41b196ac3f7fa75fcc2d3f55803961dc', '2022-05-25 05:25:41', '2022-06-01 19:17:35', NULL, '192.168.0.101', 'D', '', '');
INSERT INTO `his_config_info` VALUES (25, 17, 'xueyi-auth-dev.yml', 'DEFAULT_GROUP', '', '# spring配置\r\nspring:\r\n  redis:\r\n    host: ${secret.redis.host}\r\n    port: ${secret.redis.port}\r\n    password: ${secret.redis.password}\r\n', '56ea04390f33dc91dc8e1f730120bf36', '2022-05-25 05:25:41', '2022-06-01 19:17:35', NULL, '192.168.0.101', 'D', '', '');
INSERT INTO `his_config_info` VALUES (26, 18, 'xueyi-file-dev.yml', 'DEFAULT_GROUP', '', '# 本地文件上传\r\nfile:\r\n  domain: http://127.0.0.1:9300\r\n  path: D:/cool/uploadPath\r\n  prefix: /statics\r\n\r\n# FastDFS配置\r\nfdfs:\r\n  domain: http://8.129.231.12\r\n  soTimeout: 3000\r\n  connectTimeout: 2000\r\n  trackerList: 8.129.231.12:22122\r\n\r\n# Minio配置\r\nminio:\r\n  url: http://8.129.231.12:9000\r\n  accessKey: minioadmin\r\n  secretKey: minioadmin\r\n  bucketName: test', 'a2e544b7c911083132fbe7967d4598d0', '2022-05-25 05:25:41', '2022-06-01 19:17:35', NULL, '192.168.0.101', 'D', '', '');
INSERT INTO `his_config_info` VALUES (0, 19, 'xueyi-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 06:06:22', '2022-06-01 19:55:08', NULL, '192.168.0.101', 'I', '', '');
INSERT INTO `his_config_info` VALUES (8, 20, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 06:48:04', '2022-06-01 20:33:38', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (8, 21, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.cool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '4b4d65fe42df1454bc47c29f96414baa', '2022-05-25 07:00:51', '2022-06-01 20:45:25', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (27, 22, 'xueyi-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 08:11:30', '2022-06-01 21:50:39', NULL, '192.168.0.101', 'D', '', '');
INSERT INTO `his_config_info` VALUES (8, 23, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 09:56:41', '2022-06-01 23:27:44', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (8, 24, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n  basePackage: com.springcool.system\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '7ea2ca0a2c146b328df07b438fb3a9c0', '2022-05-25 10:01:13', '2022-06-01 23:31:55', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (8, 25, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n  base-package: com.springcool.system\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', 'ea50ce9716a0155da06387283c8c4926', '2022-05-25 10:11:55', '2022-06-01 23:41:48', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (2, 26, 'application-secret-dev.yml', 'DEFAULT_GROUP', '', 'secret:\n  #redis参数信息\n  redis:\n    host: 192.168.0.130\n    port: 6379\n    password:\n  #服务状态监控参数信息\n  security:\n    name: cool\n    password: cool123\n    title: 服务状态监控\n  # swagger参数信息\n  swagger:\n    title: 接口文档\n    license: Powered By cool\n    licenseUrl: https://doc.cooltt.cn\n  # datasource主库参数信息\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://cool-mysql:3306/cool?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: 123456\n  # druid控制台参数信息\n  druid:\n    stat-view-servlet:\n      enabled: true\n      loginUsername: admin\n      loginPassword: 123456\n  # nacos参数信息\n  nacos:\n    serverAddr: cool-nacos:8848', 'bcec5c70903e3ff51b1160dbb2bdfe0f', '2022-05-25 10:12:25', '2022-06-01 23:42:15', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (8, 27, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', '8b4664b32f3520ba8f00f6b962ce3c23', '2022-05-25 10:16:59', '2022-06-01 23:46:29', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (8, 28, 'cool-system-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - sys_dict_type\n      - sys_dict_data\n      - sys_config\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.system\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n  basePackage: ${secret.swagger.basePackage}\n  basePath:\n    - system.authority.controller\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-system-group: default', 'cea5d399ff4c443b2907094c1e20d679', '2022-05-25 10:48:55', '2022-06-02 00:15:57', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (7, 29, 'cool-tenant-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 公共表配置\n    common-table:\n      - sys_menu\n      - sys_module\n    # 非租户表配置\n    exclude-table:\n      - te_tenant\n      - te_strategy\n      - te_source\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.tenant\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 租户模块${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n#seata配置\nseata:\n  # 服务配置项\n  service:\n    # 虚拟组和分组的映射\n    vgroup-mapping:\n      cool-tenant-group: default\n', 'e3ba7299aa84c607d4a90d43b2fad011', '2022-05-25 10:49:10', '2022-06-02 00:16:11', 'nacos', '192.168.0.101', 'U', '', '');
INSERT INTO `his_config_info` VALUES (9, 30, 'cool-gen-dev.yml', 'DEFAULT_GROUP', '', 'cool:\n  # 租户配置\n  tenant:\n    # 非租户表配置\n    exclude-table:\n      - gen_table\n      - gen_table_column\n\n# mybatis-plus配置\nmybatis-plus:\n  # 搜索指定包别名\n  typeAliasesPackage: com.springcool.gen\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath:mapper/**/*.xml\n  configuration:\n    jdbc-type-for-null: \'null\'\n\n# swagger配置\nswagger:\n  title: 代码生成${secret.swagger.title}\n  license: ${secret.swagger.license}\n  licenseUrl: ${secret.swagger.licenseUrl}\n\n# 代码生成\ngen: \n  # 作者\n  author: cool\n  # ui路径（空代表生成在后端主路径下，可设置为ui项目地址如：C:UserscoolMultiSaas-UI）\n  uiPath: \n  # 自动去除表前缀，默认是true\n  autoRemovePre: true\n  # 数据库映射\n  data-base:\n    # 字符串类型\n    type-str: [\"char\", \"varchar\", \"nvarchar\", \"varchar2\"]\n    # 文本类型\n    type-text: [\"tinytext\", \"text\", \"mediumtext\", \"longtext\"]\n    # 日期类型\n    type-date: [\"datetime\", \"time\", \"date\", \"timestamp\"]\n    # 时间类型\n    type-time: [\"datetime\", \"time\", \"date\", \"timestamp\"]\n    # 数字类型\n    type-number: [\"tinyint\", \"smallint\", \"mediumint\", \"int\", \"number\", \"integer\"]\n    # 长数字类型\n    type-long: [\"bigint\"]\n    # 浮点类型\n    type-float: [\"float\", \"double\", \"decimal\"]\n  # 字段配置\n  operate:\n    # 隐藏详情显示\n    not-view: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏新增显示\n    not-insert: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏编辑显示\n    not-edit: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏列表显示\n    not-list: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\n    # 隐藏查询显示\n    not-query: [\"id\", \"sort\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"remark\"]\n    # 隐藏导入显示\n    not-import: [\"id\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\"]\n    # 隐藏导出显示\n    not-export: [\"id\", \"sort\", \"createBy\", \"updateBy\"]\n  # 基类配置\n  entity:\n    # 必定隐藏字段（前后端均隐藏）\n    must-hide: [\"delFlag\", \"tenantId\", \"ancestors\"]\n    # 后端基类\n    back:\n      base: [\"id\", \"name\", \"status\", \"sort\", \"remark\", \"createBy\", \"createTime\", \"updateBy\", \"updateTime\", \"delFlag\"]\n      tree: [\"parentId\", \"ancestors\"]\n      sub: []\n      tenant: [\"tenantId\"]\n    # 前端基类\n    front:\n      base: [\"createBy\", \"createName\", \"createTime\", \"updateBy\", \"updateName\", \"updateTime\", \"delFlag\"]\n      tree: [\"parentId\", \"ancestors\"]\n      sub: []\n      tenant: [\"tenantId\"]\n  # 表前缀（与remove-lists对应）\n  dict-type-remove: [\"sys_\", \"te_\", \"gen_\"]\n  # 表更替配置\n  remove-lists:\n      # 表前缀（生成类名不会包含表前缀）\n    - prefix: sys_\n      # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n      packageName: com.cool.system\n      frontPackageName: system\n    - prefix: te_\n      packageName: com.cool.tenant\n      frontPackageName: tenant\n    - prefix: gen_\n      packageName: com.cool.gen\n      frontPackageName: gen\n', 'f25b4299dde95698fb24bd687a1f89d3', '2022-05-25 10:49:29', '2022-06-02 00:16:29', 'nacos', '192.168.0.101', 'U', '', '');
COMMIT;

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `role` varchar(50) NOT NULL,
  `resource` varchar(255) NOT NULL,
  `action` varchar(8) NOT NULL,
  UNIQUE KEY `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permissions
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `idx_user_role` (`username`,`role`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='租户容量信息表';

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='tenant_info';

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
