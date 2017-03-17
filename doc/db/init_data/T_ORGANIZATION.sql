/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:51:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_ORGANIZATION
-- ----------------------------
DROP TABLE IF EXISTS `T_ORGANIZATION`;
CREATE TABLE `T_ORGANIZATION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `ORG_ID` bigint(20) DEFAULT NULL COMMENT '保留字段',
  `ORG_NAME` varchar(128) NOT NULL,
  `BIZ_ID` bigint(16) DEFAULT NULL COMMENT '保留字段',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ORGANIZATION
-- ----------------------------
INSERT INTO `T_ORGANIZATION` VALUES ('1', '2', '200', '1220', 'TECNO事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2016-07-07 10:46:19', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('2', '4', '200', '1221', 'ITEL事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('3', '3', '200', '1222', 'infinix事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('4', '2', '200', '1223', '移动互联事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('5', '2', '200', '1224', '3C HUB事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('6', '6', '200', '1225', '商务配件事业部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('7', '2', '200', '1226', '上海传众', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('8', '2', '200', '1227', '上海展扬', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('9', '2', '1', '2100', 'TECNO事业部-尼日利亚Nigeria', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:11:50', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('10', '2', '1', '2105', 'TECNO事业部-马里Mali', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2016-07-07 10:45:21', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('11', '2', '1', '2106', 'TECNO事业部-加纳Ghana', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:08:16', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('12', '2', '1', '2107', 'TECNO事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('13', '2', '1', '2108', 'TECNO事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('14', '2', '1', '2109', 'TECNO事业部-大客户管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('15', '2', '1', '2110', 'TECNO事业部-市场部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('16', '2', '1', '2111', 'TECNO事业部-销售管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('17', '2', '1', '2112', 'TECNO事业部-肯尼亚Kenya', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:10:32', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('18', '2', '1', '2113', 'TECNO事业部-坦桑尼亚Tanzania', null, '1', '', 'System', '2017-03-13 11:05:52', '02459', '2017-03-16 19:20:31', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('19', '2', '1', '2114', 'TECNO事业部-乌干达Uganda', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:09:24', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('20', '2', '1', '2115', 'TECNO事业部-埃塞俄比亚Ethiopia', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:09:47', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('21', '2', '1', '2116', 'TECNO事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('22', '2', '1', '2117', 'TECNO事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('23', '2', '1', '2118', 'TECNO事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('24', '2', '1', '2119', 'TECNO事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('25', '2', '1', '2120', 'TECNO事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('26', '2', '1', '2121', 'TECNO事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('27', '2', '1', '2122', 'TECNO事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('28', '2', '1', '2123', 'TECNO事业部-几内亚Guinea', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2016-09-14 02:40:07', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('29', '2', '1', '2124', 'TECNO事业部-卢旺达Rwanda', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:10:00', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('30', '2', '1', '2125', 'TECNO事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('31', '2', '1', '2126', 'TECNO事业部-埃及Egypt', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:10:14', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('32', '2', '1', '2127', 'TECNO事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('33', '2', '1', '2128', 'TECNO事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('34', '2', '1', '2129', 'TECNO事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('35', '2', '1', '2130', 'TECNO事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('36', '2', '1', '2131', 'TECNO事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('37', '2', '1', '2132', 'TECNO事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('38', '2', '1', '2133', 'TECNO事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('39', '2', '1', '2134', 'TECNO事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('40', '2', '1', '2135', 'TECNO事业部-沙特阿拉伯KSA', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2016-07-28 02:10:41', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('41', '2', '3', '2301', 'infinix事业部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('42', '2', '3', '2302', 'infinix事业部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('43', '2', '3', '2303', 'infinix事业部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('44', '2', '3', '2304', 'infinix事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('45', '2', '3', '2305', 'infinix事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('46', '2', '3', '2306', 'infinix事业部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('47', '2', '3', '2307', 'infinix事业部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('48', '2', '3', '2308', 'infinix事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('49', '2', '3', '2309', 'infinix事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('50', '2', '3', '2310', 'infinix事业部-大客户管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('51', '2', '2', '2225', 'itel事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('52', '2', '2', '2226', 'itel事业部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('53', '2', '2', '2227', 'itel事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('54', '2', '2', '2228', 'itel事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('55', '2', '2', '2229', 'itel事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('56', '2', '2', '2230', 'itel事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('57', '2', '2', '2231', 'itel事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('58', '2', '2', '2232', 'itel事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('59', '2', '2', '2233', 'itel事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('60', '2', '2', '2234', 'itel事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('61', '2', '2', '2235', 'itel事业部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('62', '2', '4', '2401', '移动互联事业部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('63', '2', '4', '2402', '移动互联事业部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('64', '2', '4', '2403', '移动互联事业部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('65', '2', '4', '2404', '移动互联事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('66', '2', '4', '2405', '移动互联事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('67', '2', '4', '2406', '移动互联事业部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('68', '2', '4', '2407', '移动互联事业部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('69', '2', '4', '2408', '移动互联事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('70', '2', '4', '2409', '移动互联事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('71', '2', '4', '2410', '移动互联事业部-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('72', '2', '4', '2411', '移动互联事业部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('73', '2', '4', '2412', '移动互联事业部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('74', '2', '4', '2413', '移动互联事业部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('75', '2', '4', '2414', '移动互联事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('76', '2', '4', '2415', '移动互联事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('77', '2', '4', '2416', '移动互联事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('78', '2', '4', '2417', '移动互联事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('79', '2', '4', '2418', '移动互联事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('80', '2', '4', '2419', '移动互联事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('81', '2', '4', '2420', '移动互联事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('82', '2', '4', '2421', '移动互联事业部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('83', '2', '4', '2422', '移动互联事业部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('84', '2', '4', '2423', '移动互联事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('85', '2', '4', '2424', '移动互联事业部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('86', '2', '4', '2425', '移动互联事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('87', '2', '4', '2426', '移动互联事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('88', '2', '4', '2427', '移动互联事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('89', '2', '4', '2428', '移动互联事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('90', '2', '4', '2429', '移动互联事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('91', '2', '4', '2430', '移动互联事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('92', '2', '4', '2431', '移动互联事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('93', '2', '4', '2432', '移动互联事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('94', '2', '4', '2433', '移动互联事业部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('95', '2', '4', '2434', '移动互联事业部-总经办', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('96', '2', '4', '2435', '移动互联事业部-移动互联', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('97', '2', '4', '2436', '移动互联事业部-palmchat', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('98', '2', '223', '1038', '北山工厂', '11030010', '1', null, 'System', '2014-06-18 11:22:38', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('99', '2', '172', '1041', 'Workshop 2', '11030015', '1', null, 'System', '2014-06-18 11:24:01', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('100', '2', '172', '1040', 'Workshop 1', '11030015', '1', null, 'System', '2014-06-18 11:23:44', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('101', '2', '1', '3001', 'TECNO事业部-加蓬Gabon', '11030005', '1', null, 'System', '2015-03-17 06:11:26', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('102', '2', '1', '3003', 'TECNO事业部-乍得Chad', '11030005', '1', null, 'System', '2016-08-25 07:58:01', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('103', '2', '200', '3004', '平板事业部', '11030005', '1', null, 'System', '2016-10-27 08:29:29', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('104', '2', '103', '3005', '平板事业部-尼日利亚Nigeria', '11030005', '1', null, 'System', '2016-10-27 08:30:24', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('105', '2', '200', '3006', '客户服务中心', '11030005', '1', null, 'System', '2016-11-17 06:34:51', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('106', '2', '105', '3007', '客户服务中心-肯尼亚', '11030005', '1', null, 'System', '2016-11-19 03:37:13', 'System', '2016-11-21 02:42:42', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('107', '2', '105', '3010', '客户服务中心-乌干达', '11030005', '1', null, 'System', '2016-11-21 06:13:41', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('108', '2', '105', '3011', '客户服务中心-总部', '11030005', '1', null, 'System', '2016-11-21 08:18:42', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('109', '2', '105', '3012', '客户服务中心-科特迪瓦', '11030005', '1', null, 'System', '2016-11-23 08:43:53', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('110', '2', '1', '3013', 'TECNO事业部-南苏丹S.Sudan', '11030005', '1', null, 'System', '2016-12-30 09:02:36', 'System', '2017-02-08 10:28:07', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('111', '2', '1', '3014', 'TECNO事业部-冈比亚Gambia', '11030005', '1', null, 'System', '2016-12-30 11:00:39', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('112', '2', '224', '2019', '平台管理部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('113', '2', '224', '2020', '平台管理部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('114', '2', '224', '2021', '平台管理部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('115', '2', '224', '2022', '平台管理部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('116', '2', '224', '2023', '平台管理部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('117', '2', '224', '2024', '平台管理部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('118', '2', '224', '2025', '平台管理部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('119', '2', '224', '2026', '平台管理部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('120', '2', '224', '2027', '平台管理部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('121', '2', '224', '2028', '平台管理部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('122', '2', '224', '2029', '平台管理部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('123', '2', '224', '2030', '平台管理部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('124', '2', '224', '2031', '平台管理部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('125', '2', '224', '2032', '平台管理部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('126', '2', '224', '2033', '平台管理部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('127', '2', '224', '2034', '平台管理部-塞舌尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('128', '2', '2', '2201', 'itel事业部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('129', '2', '2', '2203', 'itel事业部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('130', '2', '2', '2204', 'itel事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('131', '2', '2', '2205', 'itel事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('132', '2', '2', '2206', 'itel事业部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('133', '2', '2', '2207', 'itel事业部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('134', '2', '2', '2208', 'itel事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('135', '2', '2', '2209', 'itel事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('136', '2', '2', '2210', 'itel事业部-市场部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('137', '2', '2', '2211', 'itel事业部-销售管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('138', '2', '2', '2212', 'itel事业部-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('139', '2', '2', '2213', 'itel事业部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('140', '2', '2', '2214', 'itel事业部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('141', '2', '2', '2215', 'itel事业部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('142', '2', '2', '2216', 'itel事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('143', '2', '2', '2217', 'itel事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('144', '2', '2', '2218', 'itel事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('145', '2', '2', '2219', 'itel事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('146', '2', '2', '2220', 'itel事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('147', '2', '2', '2221', 'itel事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('148', '2', '2', '2222', 'itel事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('149', '2', '2', '2223', 'itel事业部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('150', '2', '2', '2224', 'itel事业部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('151', '5', '221', '2731', '客户服务中心-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('152', '5', '221', '2732', '客户服务中心-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('153', '5', '221', '2733', '客户服务中心-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('154', '5', '221', '2734', '客户服务中心-塞舌尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('155', '2', '7', '2801', '上海传众-INFINIX', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('156', '2', '7', '2802', '上海传众-移动互联', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('157', '2', '7', '2803', '上海传众-总裁办', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('158', '2', '7', '2804', '上海传众-财务管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('159', '2', '7', '2805', '上海传众-人力资源部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('160', '2', '7', '2806', '上海传众-产品开发部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('161', '2', '7', '2807', '上海传众-产品规划部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('162', '2', '7', '2808', '上海传众-项目部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('163', '2', '8', '2901', '上海展扬-软件部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('164', '2', '8', '2902', '上海展扬-硬件部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('165', '2', '8', '2903', '上海展扬-总裁办', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('166', '2', '8', '2904', '上海展扬-财务管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('167', '2', '8', '2905', '上海展扬-人力资源部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('168', '2', '8', '2906', '上海展扬-项目部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('169', '2', '8', '1032', 'test', '11030005', '1', null, 'System', '2014-04-11 15:37:21', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('170', '2', '100', '1043', 'LineB', '11030020', '1', null, 'System', '2014-06-18 11:25:47', 'System', '2014-06-18 11:27:18', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('171', '2', '223', '1037', '盐田工厂', '11030010', '1', null, 'System', '2014-06-18 11:21:46', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('172', '2', '223', '1039', '埃塞工厂', '11030010', '1', null, 'System', '2014-06-18 11:22:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('173', '2', '99', '1046', 'LineSG', '11030020', '1', null, 'System', '2014-06-18 11:28:05', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('174', '2', '2', '2202', 'itel事业部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('175', '2', '224', '2001', '平台管理部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('176', '2', '224', '2002', '平台管理部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('177', '2', '224', '2003', '平台管理部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('178', '2', '224', '2004', '平台管理部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('179', '2', '224', '2005', '平台管理部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('180', '2', '224', '2006', '平台管理部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('181', '2', '224', '2007', '平台管理部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('182', '2', '224', '2008', '平台管理部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('183', '2', '224', '2009', '平台管理部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('184', '2', '224', '2010', '平台管理部-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('185', '2', '224', '2011', '平台管理部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('186', '2', '224', '2012', '平台管理部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('187', '2', '224', '2013', '平台管理部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('188', '2', '224', '2014', '平台管理部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('189', '2', '224', '2015', '平台管理部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('190', '2', '224', '2016', '平台管理部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('191', '2', '224', '2017', '平台管理部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('192', '2', '224', '2018', '平台管理部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('193', '2', '105', '3009', '客户服务中心-马里', '11030005', '1', null, 'System', '2016-11-21 06:13:16', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('194', '2', '1', '3016', 'TECNO事业部-莫桑比克Mozambique', '11030005', '1', null, 'System', '2017-02-22 03:30:51', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('195', '2', '1', '3015', 'TECNO事业部-毛里塔尼亚Maruitania', '11030005', '1', null, 'System', '2016-12-30 11:05:13', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('196', '2', '100', '1042', 'LineA', '11030020', '1', null, 'System', '2014-06-18 11:24:55', 'System', '2014-06-18 11:27:11', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('197', '2', '100', '1044', 'LineC', '11030020', '1', null, 'System', '2014-06-18 11:26:24', 'System', '2014-06-18 11:27:27', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('198', '2', '99', '1045', 'LineSF', '11030020', '1', null, 'System', '2014-06-18 11:27:45', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('199', '2', '100', '1047', 'LineD', '11030020', '1', null, 'System', '2014-06-18 14:25:31', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('200', '1', '0', '1001', '传音科技', '11030005', '1', '传音科技_计调部', 'System', '2013-07-16 15:33:02', 'System', '2013-08-23 15:26:30', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('201', '2', '1', '2101', 'TECNO事业部-科特迪瓦Cote DIvoire', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-01-03 05:49:09', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('202', '2', '1', '2102', 'TECNO事业部-喀麦隆Cameroon', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:09:09', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('203', '2', '200', '1200', '总裁办', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('204', '2', '1', '2103', 'TECNO事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('205', '2', '1', '2104', 'TECNO事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('206', '2', '200', '1201', '总裁办-行政部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('207', '2', '200', '1202', '总裁办-战略管理', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('208', '2', '200', '1203', '投资法务部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('209', '2', '200', '1204', '财务管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('210', '2', '200', '1205', '审计部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('211', '2', '200', '1206', '人力资源部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('212', '2', '200', '1207', '信息工程部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('213', '2', '200', '1208', '产品开发部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('214', '2', '200', '1209', '品牌管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('215', '2', '200', '1210', '产品规划部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('216', '2', '200', '1211', '项目部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('217', '2', '200', '1212', '计调部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('218', '2', '200', '1213', '计调部-HK仓库', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('219', '2', '200', '1214', '上游采购部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('220', '2', '200', '1215', '质量管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('221', '5', '200', '1216', '客户服务中心', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('222', '2', '200', '1217', '运营商部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('223', '2', '200', '1218', '制造管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('224', '2', '200', '1219', '平台管理部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('225', '2', '5', '2527', '3C HUB事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('226', '2', '5', '2526', '3C HUB事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('227', '2', '5', '2528', '3C HUB事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('228', '2', '5', '2529', '3C HUB事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('229', '2', '5', '2530', '3C HUB事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('230', '2', '5', '2531', '3C HUB事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('231', '2', '5', '2532', '3C HUB事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('232', '2', '5', '2533', '3C HUB事业部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('233', '6', '6', '2601', '商务配件事业部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('234', '6', '6', '2602', '商务配件事业部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('235', '6', '6', '2603', '商务配件事业部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('236', '6', '6', '2604', '商务配件事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('237', '6', '6', '2605', '商务配件事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('238', '6', '6', '2606', '商务配件事业部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('239', '6', '6', '2607', '商务配件事业部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('240', '6', '6', '2608', '商务配件事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('241', '6', '6', '2609', '商务配件事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('242', '6', '6', '2610', '商务配件事业部-肯尼亚', '11030005', '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-07-21 05:56:38', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('243', '6', '6', '2611', '商务配件事业部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('244', '6', '6', '2612', '商务配件事业部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('245', '6', '6', '2613', '商务配件事业部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('246', '6', '6', '2614', '商务配件事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('247', '6', '6', '2615', '商务配件事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('248', '6', '6', '2616', '商务配件事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('249', '6', '6', '2617', '商务配件事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('250', '6', '6', '2618', '商务配件事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('251', '6', '6', '2619', '商务配件事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('252', '6', '6', '2620', '商务配件事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('253', '6', '6', '2621', '商务配件事业部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('254', '6', '6', '2622', '商务配件事业部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('255', '6', '6', '2623', '商务配件事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('256', '6', '6', '2624', '商务配件事业部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('257', '6', '6', '2625', '商务配件事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('258', '6', '6', '2626', '商务配件事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('259', '6', '6', '2627', '商务配件事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('260', '6', '6', '2628', '商务配件事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('261', '6', '6', '2629', '商务配件事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('262', '6', '6', '2630', '商务配件事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('263', '6', '6', '2631', '商务配件事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('264', '6', '6', '2632', '商务配件事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('265', '6', '6', '2633', '商务配件事业部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('266', '5', '221', '2701', '客户服务中心-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('267', '5', '221', '2702', '客户服务中心-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('268', '5', '221', '2703', '客户服务中心-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('269', '5', '221', '2704', '客户服务中心-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('270', '5', '221', '2705', '客户服务中心-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('271', '5', '221', '2706', '客户服务中心-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('272', '5', '221', '2707', '客户服务中心-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('273', '5', '221', '2708', '客户服务中心-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('274', '5', '221', '2709', '客户服务中心-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('275', '5', '221', '2710', '客户服务中心-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('276', '5', '221', '2711', '客户服务中心-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('277', '5', '221', '2712', '客户服务中心-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('278', '5', '221', '2713', '客户服务中心-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('279', '5', '221', '2714', '客户服务中心-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('280', '5', '221', '2715', '客户服务中心-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('281', '5', '221', '2716', '客户服务中心-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('282', '5', '221', '2717', '客户服务中心-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('283', '5', '221', '2718', '客户服务中心-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('284', '5', '221', '2719', '客户服务中心-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('285', '5', '221', '2720', '客户服务中心-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('286', '5', '221', '2721', '客户服务中心-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('287', '5', '221', '2722', '客户服务中心-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('288', '5', '221', '2723', '客户服务中心-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('289', '5', '221', '2724', '客户服务中心-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('290', '5', '221', '2725', '客户服务中心-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('291', '5', '221', '2726', '客户服务中心-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('292', '5', '221', '2727', '客户服务中心-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('293', '5', '221', '2728', '客户服务中心-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('294', '5', '221', '2729', '客户服务中心-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('295', '5', '221', '2730', '客户服务中心-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('296', '2', '3', '2311', 'infinix事业部-市场部', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('297', '2', '3', '2312', 'infinix事业部-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('298', '2', '3', '2313', 'infinix事业部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('299', '2', '3', '2314', 'infinix事业部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('300', '2', '3', '2315', 'infinix事业部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('301', '2', '3', '2316', 'infinix事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('302', '2', '3', '2317', 'infinix事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('303', '2', '3', '2318', 'infinix事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('304', '2', '3', '2319', 'infinix事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('305', '2', '3', '2320', 'infinix事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('306', '2', '3', '2321', 'infinix事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('307', '2', '3', '2322', 'infinix事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('308', '2', '3', '2323', 'infinix事业部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('309', '2', '3', '2324', 'infinix事业部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('310', '2', '3', '2325', 'infinix事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('311', '2', '3', '2326', 'infinix事业部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('312', '2', '3', '2327', 'infinix事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('313', '2', '3', '2328', 'infinix事业部-安哥拉', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('314', '2', '3', '2329', 'infinix事业部-利比里亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('315', '2', '3', '2330', 'infinix事业部-布隆迪', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('316', '2', '3', '2331', 'infinix事业部-所罗门', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('317', '2', '3', '2332', 'infinix事业部-索马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('318', '2', '3', '2333', 'infinix事业部-塞内加尔', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('319', '2', '3', '2334', 'infinix事业部-法国', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('320', '2', '3', '2335', 'infinix事业部-沙特阿拉伯', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('321', '2', '5', '2501', '3C HUB事业部-尼日利亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('322', '2', '5', '2502', '3C HUB事业部-科特迪瓦', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('323', '2', '5', '2503', '3C HUB事业部-喀麦隆', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('324', '2', '5', '2504', '3C HUB事业部-刚果金', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('325', '2', '5', '2505', '3C HUB事业部-刚果布', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('326', '2', '5', '2506', '3C HUB事业部-马里', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('327', '2', '5', '2507', '3C HUB事业部-加纳', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2015-03-17 06:09:09', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('328', '2', '5', '2508', '3C HUB事业部-迪拜', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('329', '2', '5', '2509', '3C HUB事业部-迪拜办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('330', '2', '5', '2510', '3C HUB事业部-肯尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('331', '2', '5', '2511', '3C HUB事业部-坦桑尼亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('332', '2', '5', '2512', '3C HUB事业部-乌干达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('333', '2', '5', '2513', '3C HUB事业部-埃塞俄比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('334', '2', '5', '2514', '3C HUB事业部-东非办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('335', '2', '5', '2515', '3C HUB事业部-香港办事处', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('336', '2', '5', '2516', '3C HUB事业部-马达加斯加', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('337', '2', '5', '2517', '3C HUB事业部-多哥', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('338', '2', '5', '2518', '3C HUB事业部-马拉维', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('339', '2', '5', '2519', '3C HUB事业部-塞拉利昂', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('340', '2', '5', '2520', '3C HUB事业部-赞比亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('341', '2', '5', '2521', '3C HUB事业部-几内亚', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('342', '2', '5', '2522', '3C HUB事业部-卢旺达', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('343', '2', '5', '2523', '3C HUB事业部-斐济', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('344', '2', '5', '2524', '3C HUB事业部-埃及', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('345', '2', '5', '2525', '3C HUB事业部-南非', null, '1', null, 'System', '2017-03-13 11:05:52', 'System', '2017-03-13 11:05:52', '0');
INSERT INTO `T_ORGANIZATION` VALUES ('346', '2', '1', '3016', 'TECNO事业部-莫桑比克Mozambique', '11030005', '1', null, 'System', '2017-02-22 03:30:51', 'System', '2017-03-13 11:05:52', '0');
