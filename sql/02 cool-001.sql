/*
 Navicat Premium Data Transfer

 Source Server         : localhost-cool
 Source Server Type    : MySQL
 Source Server Version : 100604
 Source Host           : 192.168.0.130:3306
 Source Schema         : cool-001

 Target Server Type    : MySQL
 Target Server Version : 100604
 File Encoding         : 65001

 Date: 02/06/2022 11:03:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cool_material
-- ----------------------------
DROP TABLE IF EXISTS `cool_material`;
CREATE TABLE `cool_material` (
  `id` bigint(20) NOT NULL COMMENT '素材Id',
  `folder_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '分类Id',
  `nick` varchar(100) NOT NULL COMMENT '素材昵称',
  `name` varchar(100) NOT NULL COMMENT '素材名称',
  `original_name` varchar(100) NOT NULL COMMENT '原图名称',
  `url` varchar(500) NOT NULL COMMENT '素材地址',
  `original_url` varchar(500) NOT NULL COMMENT '原图地址',
  `size` decimal(8,4) NOT NULL COMMENT '素材大小',
  `type` char(1) NOT NULL DEFAULT '0' COMMENT '素材类型（0默认素材 1系统素材）',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志（0正常 1删除）',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材信息表';

-- ----------------------------
-- Records of cool_material
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cool_material_folder
-- ----------------------------
DROP TABLE IF EXISTS `cool_material_folder`;
CREATE TABLE `cool_material_folder` (
  `id` bigint(20) NOT NULL COMMENT '分类Id',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父类Id',
  `name` varchar(100) NOT NULL COMMENT '分类名称',
  `ancestors` varchar(500) DEFAULT '' COMMENT '祖级列表',
  `type` char(1) NOT NULL DEFAULT '0' COMMENT '分类类型（0默认文件夹 1系统文件夹）',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志（0正常 1删除）',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='素材分类信息表';

-- ----------------------------
-- Records of cool_material_folder
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '父部门id',
  `code` varchar(64) DEFAULT NULL COMMENT '部门编码',
  `name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `ancestors` varchar(2000) DEFAULT '' COMMENT '祖级列表',
  `leader` varchar(20) DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) DEFAULT '' COMMENT '联系电话',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门信息表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES (99, 0, '99', '雪忆科技', '0', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 1);
INSERT INTO `sys_dept` VALUES (100, 0, '100', '雪忆科技', '0', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (101, 100, '101', '深圳总公司', '0,100', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (102, 100, '102', '长沙分公司', '0,100', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (103, 101, '103', '研发部门', '0,100,101', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (104, 101, '104', '市场部门', '0,100,101', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (105, 101, '105', '测试部门', '0,100,101', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (106, 101, '106', '财务部门', '0,100,101', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (107, 101, '107', '运维部门', '0,100,101', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (108, 102, '108', '市场部门', '0,100,102', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_dept` VALUES (109, 102, '109', '财务部门', '0,100,102', '', '', '', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志Id',
  `job_id` bigint(20) NOT NULL COMMENT '任务Id',
  `name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `invoke_tenant` varchar(500) NOT NULL COMMENT '调用租户字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `del_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '删除时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问Id',
  `enterprise_name` varchar(50) DEFAULT '' COMMENT '企业账号',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `user_nick` varchar(50) DEFAULT '' COMMENT '用户名称',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示信息',
  `access_time` datetime DEFAULT current_timestamp() COMMENT '访问时间',
  `del_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '删除时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1532036128489545731 DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_login_log` VALUES (1532033726449393665, 'administrator', -2, 'admin', '', '127.0.0.1', '1', '用户账号不存在', '2022-05-25 10:51:06', NULL, 0, -2);
INSERT INTO `sys_login_log` VALUES (1532033777280163842, 'administrator', -2, 'admin', '', '127.0.0.1', '1', '用户账号不存在', '2022-05-25 10:51:20', NULL, 0, -2);
INSERT INTO `sys_login_log` VALUES (1532034018846908417, 'administrator', -2, 'admin', '', '127.0.0.1', '1', '用户账号不存在', '2022-05-25 10:52:22', NULL, 0, -2);
INSERT INTO `sys_login_log` VALUES (1532034198904184833, 'cool', -2, 'admin', '', '127.0.0.1', '1', '用户账号不存在', '2022-05-25 10:53:08', NULL, 0, -2);
INSERT INTO `sys_login_log` VALUES (1532036128489545730, 'administrator', 1, 'admin', 'admin', '127.0.0.1', '0', '登录成功', '2022-05-25 11:01:27', NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` bigint(20) NOT NULL COMMENT '公告Id',
  `name` varchar(50) NOT NULL COMMENT '公告标题',
  `type` char(1) NOT NULL DEFAULT '0' COMMENT '公告类型（0通知 1公告）',
  `content` longblob DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0待发送 1已发送 2已关闭 3发送失败 4发送异常）',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_notice_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice_log`;
CREATE TABLE `sys_notice_log` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `notice_id` bigint(20) NOT NULL COMMENT '公告Id',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `receive_status` char(1) NOT NULL COMMENT '发送状态（0成功 1失败）',
  `status` char(1) DEFAULT '0' COMMENT '阅读状态（0未读 1已读）',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='通知公告记录表';

-- ----------------------------
-- Records of sys_notice_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate_log`;
CREATE TABLE `sys_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` char(2) DEFAULT '00' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operate_type` char(2) DEFAULT '00' COMMENT '操作类别（00其它 01后台 02手机端）',
  `user_id` bigint(20) NOT NULL COMMENT '操作人员',
  `user_name` varchar(50) NOT NULL COMMENT '操作人员账号',
  `user_nick` varchar(50) NOT NULL COMMENT '操作人员名称',
  `url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` char(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `operate_time` datetime DEFAULT current_timestamp() COMMENT '操作时间',
  `del_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '删除时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1532039415603339267 DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_operate_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_operate_log` VALUES (1532038011904008193, '部门管理', '01', 'com.springcool.system.organize.controller.SysDeptController.add()', 'POST', '01', 1, 'admin', 'admin', '/dept', '127.0.0.1', '{\"code\":\"002\",\"id\":1532038011300028417,\"ancestors\":\"0,99\",\"sort\":0,\"params\":{},\"parentId\":99,\"createBy\":1,\"name\":\"技术部\",\"status\":\"0\"}', '', '{\"code\":200,\"type\":\"success\",\"message\":\"操作成功\"}', '0', '', '2022-05-25 11:09:33', NULL, 0, 1);
INSERT INTO `sys_operate_log` VALUES (1532038286266015745, '部门管理', '01', 'com.springcool.system.organize.controller.SysDeptController.add()', 'POST', '01', 1, 'admin', 'admin', '/dept', '127.0.0.1', '{\"leader\":\"刘荣\",\"code\":\"10000\",\"id\":1532038286081466370,\"ancestors\":\"0,99\",\"sort\":0,\"params\":{},\"parentId\":99,\"createBy\":1,\"name\":\"技术部\",\"status\":\"0\"}', '', '{\"code\":200,\"type\":\"success\",\"message\":\"操作成功\"}', '0', '', '2022-05-25 11:10:44', NULL, 0, 1);
INSERT INTO `sys_operate_log` VALUES (1532038585093398530, '岗位管理', '01', 'com.springcool.system.organize.controller.SysPostController.add()', 'POST', '01', 1, 'admin', 'admin', '/post', '127.0.0.1', '{\"code\":\"100\",\"deptId\":99,\"sort\":0,\"params\":{},\"createBy\":1,\"name\":\"产品经理\",\"id\":1532038585055649794,\"status\":\"0\"}', '', '{\"code\":200,\"type\":\"success\",\"message\":\"操作成功\"}', '0', '', '2022-05-25 11:12:01', NULL, 0, 1);
INSERT INTO `sys_operate_log` VALUES (1532039415603339266, '部门管理', '01', 'com.springcool.system.organize.controller.SysDeptController.add()', 'POST', '01', 1, 'admin', 'admin', '/dept', '127.0.0.1', '{\"code\":\"10\",\"id\":1532039415452344322,\"ancestors\":\"0,99\",\"sort\":0,\"params\":{},\"parentId\":99,\"createBy\":1,\"name\":\"技术部\",\"status\":\"0\"}', '', '{\"code\":200,\"type\":\"success\",\"message\":\"操作成功\"}', '0', '', '2022-05-25 11:15:36', NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_organize_role_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_organize_role_merge`;
CREATE TABLE `sys_organize_role_merge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `post_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dept_id` (`dept_id`,`post_id`,`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织和角色关联表';

-- ----------------------------
-- Records of sys_organize_role_merge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `id` bigint(20) NOT NULL COMMENT '岗位Id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门Id',
  `code` varchar(64) DEFAULT NULL COMMENT '岗位编码',
  `name` varchar(50) NOT NULL COMMENT '岗位名称',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_post` VALUES (1, 99, 'ceo', '超级管理员', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 1);
INSERT INTO `sys_post` VALUES (2, 100, 'ceo', '董事长', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_post` VALUES (3, 100, 'se', '项目经理', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_post` VALUES (4, 100, 'hr', '人力资源', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_post` VALUES (5, 100, 'user', '普通员工', 0, '0', NULL, NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_post` VALUES (1532038585055649794, 99, '100', '产品经理', 0, '0', NULL, 1, '2022-05-25 11:12:01', NULL, NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '角色Id',
  `code` varchar(64) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) DEFAULT NULL COMMENT '角色权限字符串',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1全部数据权限 2自定数据权限 3本部门数据权限 4本部门及以下数据权限 5本岗位数据权限  6仅本人数据权限）',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志（0正常 1删除）',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '001', '超级管理员', 'admin', '1', 0, '0', '超级管理员', NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 1);
INSERT INTO `sys_role` VALUES (2, '002', '管理员', 'common', '1', 0, '0', '普通角色', NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_dept_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept_merge`;
CREATE TABLE `sys_role_dept_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `dept_id` bigint(20) NOT NULL COMMENT '部门Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门-岗位关联表';

-- ----------------------------
-- Records of sys_role_dept_merge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_merge`;
CREATE TABLE `sys_role_menu_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu_merge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_module_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module_merge`;
CREATE TABLE `sys_role_module_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `module_id` bigint(20) NOT NULL COMMENT '模块Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和模块关联表';

-- ----------------------------
-- Records of sys_role_module_merge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_post_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_post_merge`;
CREATE TABLE `sys_role_post_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色Id',
  `post_id` bigint(20) NOT NULL COMMENT '岗位Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门-岗位关联表';

-- ----------------------------
-- Records of sys_role_post_merge
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant_menu_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant_menu_merge`;
CREATE TABLE `sys_tenant_menu_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_id` (`menu_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='租户和菜单关联表';

-- ----------------------------
-- Records of sys_tenant_menu_merge
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841858, 13000000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841863, 13010000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841873, 13010100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841874, 13010200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841875, 13010300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841876, 13010400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841877, 13010500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841878, 13010600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841879, 13010700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841864, 13020000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841880, 13020100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841881, 13020200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841882, 13020300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841883, 13020400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841884, 13020500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841885, 13020600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841886, 13020700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841865, 13030000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841887, 13030100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841888, 13030200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841889, 13030300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841890, 13030400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841891, 13030500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841892, 13030600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841893, 13030700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841859, 14000000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841866, 14010000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841894, 14010100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841895, 14010200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841896, 14010300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841897, 14010400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841898, 14010500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841899, 14010600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841900, 14010700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841867, 14020000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841901, 14020100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841902, 14020200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841903, 14020300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841904, 14020400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841905, 14020500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841906, 14020600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841907, 14020700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841868, 14030000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841908, 14030100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841909, 14030200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841910, 14030300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841911, 14030400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841912, 14030500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841913, 14030600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841914, 14030700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841915, 14030800, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841860, 15000000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841869, 15010000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841916, 15010100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841917, 15010200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841918, 15010300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841919, 15010400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841920, 15010500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841921, 15010600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841922, 15010700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841861, 16000000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841870, 16010000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841923, 16010100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841924, 16010200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841925, 16010300, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841926, 16010400, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841927, 16010500, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841928, 16010600, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841929, 16010700, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841930, 16010800, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841862, 17000000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841871, 17010000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841931, 17010100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841872, 17020000, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841932, 17020100, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841937, 17020101, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841938, 17020102, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841933, 17020200, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841934, 17020201, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841935, 17020202, 2);
INSERT INTO `sys_tenant_menu_merge` VALUES (1501811101614841936, 17020203, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_tenant_module_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant_module_merge`;
CREATE TABLE `sys_tenant_module_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `module_id` bigint(20) NOT NULL COMMENT '模块Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `module_id` (`module_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='租户和模块关联表';

-- ----------------------------
-- Records of sys_tenant_module_merge
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant_module_merge` VALUES (1501811101547732994, 1, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '用户Id',
  `code` varchar(64) DEFAULT NULL COMMENT '用户编码',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '01' COMMENT '用户类型（00超管用户 01普通用户）',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `sex` char(1) DEFAULT '2' COMMENT '用户性别（0男 1女 2保密）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `profile` varchar(100) DEFAULT '这个人很懒，暂未留下什么' COMMENT '个人简介',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `sort` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `del_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标志(0正常 1删除)',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, '001', 'admin', 'admin', '00', '', '', '2', 'https://images.gitee.com/uploads/images/2021/1101/141155_f3dfce1d_7382127.jpeg', '这个人很懒，暂未留下什么', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '', NULL, 0, '0', '超级管理员', NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 1);
INSERT INTO `sys_user` VALUES (2, '001', 'admin', 'admin', '00', '', '', '2', 'https://images.gitee.com/uploads/images/2021/1101/141155_f3dfce1d_7382127.jpeg', '这个人很懒，暂未留下什么', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '', NULL, 0, '0', '系统管理员', NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
INSERT INTO `sys_user` VALUES (3, '002', 'cool', 'cool', '01', '', '', '2', 'https://images.gitee.com/uploads/images/2021/1101/141155_f3dfce1d_7382127.jpeg', '这个人很懒，暂未留下什么', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '', NULL, 0, '0', '管理员', NULL, '2022-05-24 21:57:28', NULL, NULL, 0, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_post_merge
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post_merge`;
CREATE TABLE `sys_user_post_merge` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `post_id` bigint(20) NOT NULL COMMENT '职位Id',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户Id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-岗位关联表';

-- ----------------------------
-- Records of sys_user_post_merge
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_post_merge` VALUES (1, 1, 1, 1);
INSERT INTO `sys_user_post_merge` VALUES (2, 2, 2, 2);
INSERT INTO `sys_user_post_merge` VALUES (3, 3, 3, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
