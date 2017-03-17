/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:48:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_COMPANY
-- ----------------------------
DROP TABLE IF EXISTS `T_COMPANY`;
CREATE TABLE `T_COMPANY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_CODE` varchar(16) NOT NULL,
  `COMPANY_NAME` varchar(128) NOT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_COMPANY
-- ----------------------------
INSERT INTO `T_COMPANY` VALUES ('1', 'TRANSSION', '传音科技', '0', '1', null, 'system', '2017-03-17 18:58:03', 'system', '2017-03-17 18:58:03', '0');
INSERT INTO `T_COMPANY` VALUES ('2', 'TECNO', 'TECNO', '1', '1', null, 'system', '2017-03-17 18:58:03', 'system', '2017-03-17 18:58:03', '0');
INSERT INTO `T_COMPANY` VALUES ('3', 'INFINIX', 'INFINIX', '1', '1', null, 'system', '2017-03-17 18:58:03', 'system', '2017-03-17 18:58:03', '0');
INSERT INTO `T_COMPANY` VALUES ('4', 'ITEL', 'ITEL', '1', '1', null, 'system', '2017-03-17 18:58:04', 'system', '2017-03-17 18:58:04', '0');
INSERT INTO `T_COMPANY` VALUES ('5', 'CARLCARE', '客户服务中心', '1', '1', null, 'system', '2017-03-17 18:58:04', 'system', '2017-03-17 18:58:04', '0');
INSERT INTO `T_COMPANY` VALUES ('6', 'ORAIMO', '配件事业部', '1', '1', null, 'system', '2017-03-17 18:58:04', 'system', '2017-03-17 18:58:04', '0');
