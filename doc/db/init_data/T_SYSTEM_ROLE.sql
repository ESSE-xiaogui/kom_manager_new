/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:53:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SYSTEM_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_ROLE`;
CREATE TABLE `T_SYSTEM_ROLE` (
  `ROLE_ID` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `IS_INACTIVE` decimal(1,0) DEFAULT '1' COMMENT '是否停用：1、启用 2、停用。',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of T_SYSTEM_ROLE
-- ----------------------------
INSERT INTO `T_SYSTEM_ROLE` VALUES ('1', 'system', 'system', '1', null, 'system', '2017-03-14 14:26:29', 'system', '2017-03-14 14:26:29');
INSERT INTO `T_SYSTEM_ROLE` VALUES ('2', 'admin', 'admin', '1', null, 'system', '2017-03-14 14:26:30', 'system', '2017-03-14 14:26:30');
INSERT INTO `T_SYSTEM_ROLE` VALUES ('3', 'manager', 'manager', '1', null, 'system', '2017-03-14 14:26:30', 'system', '2017-03-14 14:26:30');
INSERT INTO `T_SYSTEM_ROLE` VALUES ('4', 'supervisor', 'supervisor', '1', null, 'system', '2017-03-14 14:26:30', 'system', '2017-03-14 14:26:30');
INSERT INTO `T_SYSTEM_ROLE` VALUES ('5', 'promoter', 'promoter', '1', null, 'system', '2017-03-14 14:26:30', 'system', '2017-03-14 14:26:30');
INSERT INTO `T_SYSTEM_ROLE` VALUES ('6', 'TECNOmanager', 'TECNO大区经理', '1', '', 'admin', '2017-03-15 16:16:39', null, null);
INSERT INTO `T_SYSTEM_ROLE` VALUES ('7', 'ITELmanager', 'ITEL大区经理', '1', '', 'admin', '2017-03-15 16:17:00', null, null);
INSERT INTO `T_SYSTEM_ROLE` VALUES ('8', 'TECNOsupervisor', 'TECNO督导', '1', '', 'admin', '2017-03-15 16:17:23', null, null);
INSERT INTO `T_SYSTEM_ROLE` VALUES ('9', 'ITELsupervisior', 'ITEL督导', '1', '', 'admin', '2017-03-15 16:17:43', null, null);
INSERT INTO `T_SYSTEM_ROLE` VALUES ('10', 'TECNOpromoter', 'TECNO促销员', '1', '', 'admin', '2017-03-15 16:18:10', null, null);
INSERT INTO `T_SYSTEM_ROLE` VALUES ('11', 'ITELpromoter', 'ITEL促销员', '1', '', 'admin', '2017-03-15 16:18:33', null, null);
