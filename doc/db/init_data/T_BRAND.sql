/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:48:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_BRAND
-- ----------------------------
DROP TABLE IF EXISTS `T_BRAND`;
CREATE TABLE `T_BRAND` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_CODE` varchar(64) DEFAULT NULL,
  `BRAND_NAME` varchar(64) NOT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `IS_SELF` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：是自有品牌 2：不是自有品牌',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Records of T_BRAND
-- ----------------------------
INSERT INTO `T_BRAND` VALUES ('1', 'ASUS', 'ASUS', '0', '0', '2', null, 'system', '2014-06-20 12:05:02', 'system', '2014-06-20 12:05:02', '0');
INSERT INTO `T_BRAND` VALUES ('2', 'INTEL', 'INTEL', '0', '0', '2', null, 'system', '2014-06-20 12:05:58', 'system', '2014-06-20 12:05:58', '0');
INSERT INTO `T_BRAND` VALUES ('3', 'ADHOC', 'ADHOC', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('4', 'ALCATEL', 'ALCATEL', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('5', 'APPLE', 'APPLE', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('6', 'BE', 'Be', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('7', 'BIRD', 'BIRD', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('8', 'GEOTEL', 'Geotel', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('9', 'GIONEE', 'Gionee', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('10', 'G-TIDE', 'G-tide', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('11', 'HDASE', 'HDASE', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('12', 'HTC', 'HTC', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('13', 'HUAWEI', 'HUAWEI', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2015-05-13 05:58:46', '0');
INSERT INTO `T_BRAND` VALUES ('14', 'INFINIX', 'INFINIX', '3', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2015-05-13 06:00:02', '0');
INSERT INTO `T_BRAND` VALUES ('15', 'LENOVO', 'Lenovo', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('16', 'LG', 'LG', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('17', 'NOKIA', 'Nokia', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('18', 'OKING', 'OKING', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('19', 'OPSSON', 'Opsson', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('20', 'RLG', 'RLG', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('21', 'SAMSUNG', 'SAMSUNG', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('22', 'SMADL', 'Smadl', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('23', 'SOLO', 'Solo', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2015-03-31 11:31:23', '0');
INSERT INTO `T_BRAND` VALUES ('24', 'SONY', 'Sony', '0', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('25', 'TECNO', 'Tecno', '2', '1', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2017-03-07 19:02:55', '0');
INSERT INTO `T_BRAND` VALUES ('26', 'ITEL', 'Itel', '4', '0', '2', null, 'system', '2017-03-07 19:02:48', 'system', '2015-05-13 02:30:36', '0');
INSERT INTO `T_BRAND` VALUES ('27', 'Archos', 'Archos', '0', '0', '2', null, 'system', '2015-03-31 10:43:18', 'system', '2015-03-31 10:43:18', '0');
INSERT INTO `T_BRAND` VALUES ('28', 'OBI', 'OBI', '0', '0', '2', null, 'system', '2015-03-31 10:50:37', 'system', '2015-03-31 10:50:37', '0');
INSERT INTO `T_BRAND` VALUES ('29', 'Yxtel', 'Yxtel', '0', '0', '2', null, 'system', '2015-03-31 11:34:09', 'system', '2015-03-31 11:34:09', '0');
INSERT INTO `T_BRAND` VALUES ('30', 'Yezz', 'Yezz', '0', '0', '2', null, 'system', '2015-03-31 11:42:31', 'system', '2015-03-31 11:42:31', '0');
INSERT INTO `T_BRAND` VALUES ('31', 'iDROID', 'iDROID', '0', '0', '2', null, 'system', '2015-03-31 12:21:01', 'system', '2015-03-31 12:21:01', '0');
INSERT INTO `T_BRAND` VALUES ('32', 'X Touch', 'X Touch', '0', '0', '2', null, 'system', '2015-03-31 12:47:46', 'system', '2015-03-31 12:47:46', '0');
INSERT INTO `T_BRAND` VALUES ('33', 'OPPO', 'OPPO', '0', '0', '2', null, 'system', '2015-03-31 11:37:27', 'system', '2015-03-31 11:37:27', '0');
INSERT INTO `T_BRAND` VALUES ('34', 'Xiaomi', 'Xiaomi', '0', '0', '2', null, 'system', '2015-03-31 11:40:16', 'system', '2015-03-31 11:40:16', '0');
INSERT INTO `T_BRAND` VALUES ('35', 'ZTE', 'ZTE', '0', '0', '2', null, 'system', '2015-03-31 11:21:35', 'system', '2015-03-31 11:21:35', '0');
INSERT INTO `T_BRAND` VALUES ('36', 'WIKO', 'WIKO', '0', '0', '2', null, 'system', '2015-03-31 12:07:08', 'system', '2015-03-31 12:07:08', '0');
INSERT INTO `T_BRAND` VALUES ('37', 'FLY', 'FLY', '0', '0', '2', null, 'system', '2015-03-31 12:15:57', 'system', '2015-03-31 12:15:57', '0');
INSERT INTO `T_BRAND` VALUES ('38', 'KONKA', 'KONKA', '0', '0', '2', null, 'system', '2015-03-31 12:17:44', 'system', '2015-03-31 12:17:44', '0');
INSERT INTO `T_BRAND` VALUES ('39', 'Blackberry', 'Blackberry', '0', '0', '2', null, 'system', '2014-09-29 07:19:35', 'system', '2014-09-29 07:19:35', '0');
INSERT INTO `T_BRAND` VALUES ('40', 'Hr', 'Hr', '0', '0', '2', null, 'system', '2015-03-31 11:26:23', 'system', '2015-03-31 11:26:23', '0');
INSERT INTO `T_BRAND` VALUES ('41', 'Hisense', 'Hisense', '0', '0', '2', null, 'system', '2015-03-31 11:31:51', 'system', '2015-03-31 11:31:51', '0');
INSERT INTO `T_BRAND` VALUES ('42', 'ACER', 'ACER', '0', '0', '2', null, 'system', '2015-03-31 11:48:38', 'system', '2015-03-31 11:48:38', '0');
INSERT INTO `T_BRAND` VALUES ('43', 'Microsoft', 'Microsoft', '0', '0', '2', null, 'system', '2015-03-31 11:49:48', 'system', '2015-03-31 11:49:48', '0');
INSERT INTO `T_BRAND` VALUES ('44', 'VIWA', 'VIWA', '0', '0', '2', null, 'system', '2015-03-31 12:04:04', 'system', '2015-03-31 12:04:04', '0');
INSERT INTO `T_BRAND` VALUES ('45', 'MALATA', 'MALATA', '0', '0', '2', null, 'system', '2015-03-31 12:08:58', 'system', '2015-03-31 12:08:58', '0');
INSERT INTO `T_BRAND` VALUES ('46', 'MTN', 'MTN', '0', '0', '2', null, 'system', '2015-03-31 12:19:55', 'system', '2015-03-31 12:19:55', '0');
