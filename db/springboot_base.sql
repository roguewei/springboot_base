/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : springboot_base

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 02/12/2019 15:21:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for excel
-- ----------------------------
DROP TABLE IF EXISTS `excel`;
CREATE TABLE `excel`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of excel
-- ----------------------------
INSERT INTO `excel` VALUES (33, 'test2019-11-29-403.xlsx', 'J:/DEV-TOOLS/nginx-1.14.0/html/upload/test2019-11-29-403.xlsx');
INSERT INTO `excel` VALUES (34, 'test2019-11-29-55f.xlsx', 'J:/DEV-TOOLS/nginx-1.14.0/html/upload/test2019-11-29-55f.xlsx');
INSERT INTO `excel` VALUES (35, 'test2019-11-29-ee1.xlsx', 'J:/DEV-TOOLS/nginx-1.14.0/html/upload/test2019-11-29-ee1.xlsx');

-- ----------------------------
-- Table structure for excel_entity
-- ----------------------------
DROP TABLE IF EXISTS `excel_entity`;
CREATE TABLE `excel_entity`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of excel_entity
-- ----------------------------
INSERT INTO `excel_entity` VALUES (1, '测试1', 1, '1543593600000');
INSERT INTO `excel_entity` VALUES (2, '测试2', 2, '1543680000000');
INSERT INTO `excel_entity` VALUES (3, '测试3', 1, '1543766400000');
INSERT INTO `excel_entity` VALUES (4, '测试4', 2, '1543852800000');
INSERT INTO `excel_entity` VALUES (5, '测试5', 1, '1543939200000');
INSERT INTO `excel_entity` VALUES (6, '测试6', 2, '1544025600000');
INSERT INTO `excel_entity` VALUES (7, '测试7', 1, '1544112000000');
INSERT INTO `excel_entity` VALUES (8, '测试8', 2, '1544198400000');
INSERT INTO `excel_entity` VALUES (9, '测试9', 1, '1544284800000');
INSERT INTO `excel_entity` VALUES (10, '测试10', 2, '1544371200000');
INSERT INTO `excel_entity` VALUES (11, '测试11', 1, '1544457600000');
INSERT INTO `excel_entity` VALUES (12, '测试12', 2, '1544544000000');
INSERT INTO `excel_entity` VALUES (13, '测试13', 1, '1544630400000');
INSERT INTO `excel_entity` VALUES (14, '测试14', 1, '1544716800000');
INSERT INTO `excel_entity` VALUES (15, '测试15', 2, '1544803200000');


-- ----------------------------
-- Table structure for log_info
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(8) DEFAULT NULL COMMENT '操作者id',
  `result_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果状态(1成功,0失败)',
  `log_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '日志类型',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `ip_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'ip地址',
  `operatordesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter`  (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `param_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数名',
  `param_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数代码',
  `param_value` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数值',
  `param_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数表-' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `pername` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源名称',
  `perurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源路径',
  `type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源类型（0：菜单 1：按钮）',
  `parentid` int(8) DEFAULT NULL COMMENT '父资源id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '用户列表', '/web/user', '1', 5);
INSERT INTO `permission` VALUES (2, '用户注册', '/web/user/regester', '2', 1);
INSERT INTO `permission` VALUES (3, '用户修改', '/web/user/update', '2', 1);
INSERT INTO `permission` VALUES (4, '用户删除', '/web/user/del', '2', 1);
INSERT INTO `permission` VALUES (5, '系统管理', '/system', '0', 0);
INSERT INTO `permission` VALUES (6, '角色列表', '/web/role', '1', 5);
INSERT INTO `permission` VALUES (7, '角色新增', '/web/role/add', '2', 6);
INSERT INTO `permission` VALUES (8, '角色修改', '/web/role/update', '2', 6);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '超级管理员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `per_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`, `per_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色—权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, '1');
INSERT INTO `role_permission` VALUES (1, '2');
INSERT INTO `role_permission` VALUES (1, '3');
INSERT INTO `role_permission` VALUES (1, '4');
INSERT INTO `role_permission` VALUES (1, '5');
INSERT INTO `role_permission` VALUES (1, '6');
INSERT INTO `role_permission` VALUES (1, '7');
INSERT INTO `role_permission` VALUES (1, '8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
  `rel_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `open_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信登录标识',
  `openid_hex` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'openid加密',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信昵称',
  `towns_id` int(8) DEFAULT NULL COMMENT '所属村镇id',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `enable` int(10) DEFAULT NULL COMMENT '是否启用',
  `operator_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作者类型（0：后台，1：前端）',
  `state` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '状态（0：删除 1：正常 2：冻结',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `create_opr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` bigint(13) DEFAULT NULL COMMENT '修改时间',
  `update_opr` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `last_logon` bigint(13) DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '0a984d9c008009ee217b62251014865d', NULL, '1', NULL, NULL, NULL, NULL, '15622285997', 1, '0', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'winston', '09d993cc215d57cb434e2e824d98b4e3', NULL, '1', NULL, NULL, NULL, NULL, '13560000000', 1, '0', '1', 1574927835953, 'system', 1574927835953, 'system', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(8) NOT NULL COMMENT '用户id',
  `role_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户—角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '1');

SET FOREIGN_KEY_CHECKS = 1;
