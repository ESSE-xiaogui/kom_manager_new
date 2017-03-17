/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:53:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_VERSION
-- ----------------------------
DROP TABLE IF EXISTS `T_VERSION`;
CREATE TABLE `T_VERSION` (
  `ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(16) NOT NULL,
  `VERSION` varchar(32) NOT NULL,
  `URL` varchar(128) NOT NULL,
  `DOWNLOAD_FLAG` tinyint(1) NOT NULL COMMENT '是否强制下载:  1表示非强制 2表示强制下载',
  `DOWNLOAD_HINT` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_VERSION
-- ----------------------------
