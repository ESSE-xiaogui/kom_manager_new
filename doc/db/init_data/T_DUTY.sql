/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:49:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_DUTY
-- ----------------------------
DROP TABLE IF EXISTS `T_DUTY`;
CREATE TABLE `T_DUTY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DUTY_CODE` decimal(8,0) DEFAULT NULL,
  `DUTY_NAME` varchar(64) CHARACTER SET utf8 NOT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `IDX_DUTY` (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of T_DUTY
-- ----------------------------
INSERT INTO `T_DUTY` VALUES ('1', '10001002', 'Senior Supervisor', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('2', '10001004', 'Senior Representative', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('3', '10001003', 'Junior Representative', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('4', '10001005', 'Kom Manager', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('5', '10001006', '事业部总经理', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('6', '10001001', 'Sales Assistant', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('7', '10001007', 'Visiting Ambassador', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('8', '10001008', 'Shop Owner', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('9', '10001009', 'Trainer', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('10', '10001010', 'Agency Staff', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('11', '10001100', '总部人员', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('12', '10001100', '总部客服人员', '5', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('13', '10001001', '维修站人员', '5', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('14', '10001100', '总部事业部人员', '6', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('15', '10001001', '办事处人员', '6', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('16', '10001011', 'Junior Supervisor', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('17', '10001012', 'Regional Supervisor', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('18', '10001013', 'Operator Staff', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('19', '10001014', 'Assistant Manager', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('20', '10001015', 'Marketing Staff', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('21', '10001016', 'Channel Staff', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
INSERT INTO `T_DUTY` VALUES ('22', '10001017', 'Intern', '2', '1', null, 'system', '2017-03-17 18:59:12', 'system', '2017-03-17 18:59:12', '0');
