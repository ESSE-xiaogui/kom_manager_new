/*
Navicat MySQL Data Transfer

Source Server         : 10.151.170.30(kom-mgr-dev)
Source Server Version : 50717
Source Host           : 10.151.170.30:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-09 19:54:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_REGION_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `T_REGION_TYPE`;
CREATE TABLE `T_REGION_TYPE` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `REGION_TYPE` varchar(200) NOT NULL COMMENT '区域类型',
  `TYPE_CODE` varchar(255) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_REGION_TYPE
-- ----------------------------
INSERT INTO `T_REGION_TYPE` VALUES ('1', '洲', '10200005', null, null, null);
INSERT INTO `T_REGION_TYPE` VALUES ('2', '国家', '10200005', null, null, null);
INSERT INTO `T_REGION_TYPE` VALUES ('3', '省份', '10200010', null, null, null);
INSERT INTO `T_REGION_TYPE` VALUES ('4', '城市', '10200015', null, null, null);
