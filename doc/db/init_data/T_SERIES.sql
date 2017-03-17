/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:52:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SERIES
-- ----------------------------
DROP TABLE IF EXISTS `T_SERIES`;
CREATE TABLE `T_SERIES` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_CODE` varchar(10) NOT NULL,
  `SERIES_CODE` varchar(10) NOT NULL,
  `SERIES_NAME` varchar(32) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Records of T_SERIES
-- ----------------------------
INSERT INTO `T_SERIES` VALUES ('1', 'Hr', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:26:41', 'system', '2015-03-31 11:26:41', '0');
INSERT INTO `T_SERIES` VALUES ('2', 'Blackberry', 'Smart', 'Smart', '0', '1', null, 'system', '2014-09-29 07:20:36', 'system', '2014-09-29 07:20:36', '0');
INSERT INTO `T_SERIES` VALUES ('3', 'ZTE', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:21:55', 'system', '2015-03-31 11:21:55', '0');
INSERT INTO `T_SERIES` VALUES ('4', 'Hisense', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:32:08', 'system', '2015-03-31 11:32:08', '0');
INSERT INTO `T_SERIES` VALUES ('5', 'VIWA', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:04:17', 'system', '2015-03-31 12:04:17', '0');
INSERT INTO `T_SERIES` VALUES ('6', 'WIKO', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:07:22', 'system', '2015-03-31 12:07:22', '0');
INSERT INTO `T_SERIES` VALUES ('7', 'KONKA', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:17:56', 'system', '2015-03-31 12:17:56', '0');
INSERT INTO `T_SERIES` VALUES ('8', 'INFINIX', 'Feature', 'Feature', '3', '1', null, 'system', '2016-02-17 07:05:43', 'system', '2016-02-17 07:05:43', '0');
INSERT INTO `T_SERIES` VALUES ('9', 'INTEL', 'Smart', 'Smart', '0', '1', null, 'system', '2014-06-20 13:43:04', 'system', '2014-06-20 13:43:04', '0');
INSERT INTO `T_SERIES` VALUES ('10', 'ALCATEL', 'Feature', 'Feature', '0', '1', null, 'system', '2014-06-20 13:40:48', 'system', '2014-06-20 13:40:48', '0');
INSERT INTO `T_SERIES` VALUES ('11', 'ASUS', 'Smart', 'Smart', '0', '1', null, 'system', '2014-06-20 13:41:24', 'system', '2014-06-20 13:41:24', '0');
INSERT INTO `T_SERIES` VALUES ('12', 'ADHOC', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('13', 'BIRD', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('14', 'GEOTEL', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('15', 'GIONEE', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('16', 'G-TIDE', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('17', 'HDASE', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('18', 'HUAWEI', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('19', 'LG', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('20', 'NOKIA', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('21', 'OKING', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('22', 'SAMSUNG', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('23', 'SMADL', 'Feature', 'Feature', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('24', 'ALCATEL', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('25', 'APPLE', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('26', 'BE', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('27', 'GIONEE', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('28', 'G-TIDE', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('29', 'HTC', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('30', 'HUAWEI', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('31', 'INFINIX', 'Smart', 'Smart', '3', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('32', 'LENOVO', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('33', 'LG', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('34', 'NOKIA', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('35', 'OPSSON', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('36', 'RLG', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('37', 'SAMSUNG', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('38', 'SMADL', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('39', 'SOLO', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('40', 'SONY', 'Smart', 'Smart', '0', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('41', 'ITEL', 'Feature', 'Feature', '4', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('42', 'ITEL', 'Smart', 'Smart', '4', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('43', 'TECNO', 'Smart', 'Smart', '2', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('44', 'TECNO', 'Feature', 'Feature', '2', '1', null, 'system', '2017-03-07 19:20:08', 'system', '2017-03-07 19:20:08', '0');
INSERT INTO `T_SERIES` VALUES ('45', 'Yezz', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:42:44', 'system', '2015-03-31 11:42:44', '0');
INSERT INTO `T_SERIES` VALUES ('46', 'MALATA', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:09:10', 'system', '2015-03-31 12:09:10', '0');
INSERT INTO `T_SERIES` VALUES ('47', 'OBI', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 10:50:58', 'system', '2015-03-31 10:50:58', '0');
INSERT INTO `T_SERIES` VALUES ('48', 'OPPO', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:37:39', 'system', '2015-03-31 11:37:39', '0');
INSERT INTO `T_SERIES` VALUES ('49', 'Xiaomi', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:40:29', 'system', '2015-03-31 11:40:29', '0');
INSERT INTO `T_SERIES` VALUES ('50', 'Archos', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 10:45:20', 'system', '2015-03-31 10:45:20', '0');
INSERT INTO `T_SERIES` VALUES ('51', 'Yxtel', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:34:23', 'system', '2015-03-31 11:34:23', '0');
INSERT INTO `T_SERIES` VALUES ('52', 'ACER', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:48:51', 'system', '2015-03-31 11:48:51', '0');
INSERT INTO `T_SERIES` VALUES ('53', 'Microsoft', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 11:50:00', 'system', '2015-03-31 11:50:00', '0');
INSERT INTO `T_SERIES` VALUES ('54', 'FLY', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:16:09', 'system', '2015-03-31 12:16:09', '0');
INSERT INTO `T_SERIES` VALUES ('55', 'MTN', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:20:09', 'system', '2015-03-31 12:20:09', '0');
INSERT INTO `T_SERIES` VALUES ('56', 'iDROID', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:21:16', 'system', '2015-03-31 12:21:16', '0');
INSERT INTO `T_SERIES` VALUES ('57', 'FLY', 'Feature', 'Feature', '0', '1', null, 'system', '2015-03-31 12:29:52', 'system', '2015-03-31 12:29:52', '0');
INSERT INTO `T_SERIES` VALUES ('58', 'X Touch', 'Smart', 'Smart', '0', '1', null, 'system', '2015-03-31 12:48:07', 'system', '2015-03-31 12:48:07', '0');
