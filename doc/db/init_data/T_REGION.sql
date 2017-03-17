/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:51:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_REGION
-- ----------------------------
DROP TABLE IF EXISTS `T_REGION`;
CREATE TABLE `T_REGION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `REGION_CODE` decimal(8,0) DEFAULT NULL COMMENT '地域定义表中包括了国家、省份、城市、区县等',
  `REGION_NAME` varchar(64) NOT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `REGION_TYPE` decimal(8,0) DEFAULT NULL COMMENT '字典编号：1020',
  `TYPE_CODE` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` varchar(50) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`),
  KEY `index2` (`PARENT_ID`,`COMPANY_ID`),
  KEY `index3` (`REGION_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=utf8 COMMENT='国家、省市、城市、区县定义表，地域由车厂端统一定义并下发，经销商端不可自定义地域，只能选择是否使用某部分地域，此表的地域';

-- ----------------------------
-- Records of T_REGION
-- ----------------------------
INSERT INTO `T_REGION` VALUES ('1', null, '30273', 'Kafr El-Shekh', '169', '4', null, '1', null, 'system', '2016-10-28 17:00:30', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('2', null, '30274', 'Kinshasa', '43', '4', null, '1', null, 'system', '2016-11-09 18:39:10', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('3', null, '0', '销售区域', '0', '0', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2013-09-26 20:00:01', '0');
INSERT INTO `T_REGION` VALUES ('4', null, '10', 'B01 北京', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('5', null, '20', 'B02 天津', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('6', null, '30', 'B03 河北', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('7', null, '40', 'B04 山西', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('8', null, '50', 'B05 辽宁', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('9', null, '60', 'B06 吉林', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('10', null, '70', 'B07 黑龙江', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('11', null, '80', 'B08 内蒙古', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('12', null, '90', 'B09 甘肃', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('13', null, '100', 'B10 陕西', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('14', null, '110', 'B11 宁夏', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('15', null, '120', 'B12 青海', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('16', null, '130', 'B13 西藏', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('17', null, '140', 'B14 新疆', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('18', null, '150', 'B15 山东', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('19', null, '160', 'B16 河南', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('20', null, '170', 'B17 湖南', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('21', null, '180', 'B18 湖北', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('22', null, '190', 'B19 江西', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('23', null, '200', 'B20 福建', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('24', null, '210', 'B21 浙江', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('25', null, '220', 'B22 江苏', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('26', null, '230', 'B23 上海', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('27', null, '240', 'B24 安徽', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('28', null, '250', 'B25 四川', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('29', null, '260', 'B26 重庆', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('30', null, '270', 'B27 云南', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('31', null, '280', 'B28 贵州', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('32', null, '290', 'B29 广东', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('33', null, '300', 'B30 广西', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('34', null, '310', 'B31 海南', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('35', null, '320', 'B32 台湾', '176', '3', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('36', null, '1064', '尼日利亚Nigeria', '3', '2', null, '1', null, 'system', '2013-09-26 20:15:22', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('37', null, '1066', '加蓬Gabon', '3', '2', null, '1', null, 'system', '2013-09-26 20:15:50', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('38', null, '1067', '坦桑尼亚Tanzania', '3', '2', null, '1', null, 'system', '2013-09-26 20:16:33', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('39', null, '1068', '肯尼亚Kenya', '3', '2', null, '1', null, 'system', '2013-09-26 20:16:42', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('40', null, '1069', '多哥Togo', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('41', null, '1071', '加纳Ghana', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-03-17 18:38:19', '0');
INSERT INTO `T_REGION` VALUES ('42', null, '1072', '喀麦隆Cameroon', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('43', null, '1073', '刚果金The Democratic Republic of the Congo', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-04-03 00:20:59', '0');
INSERT INTO `T_REGION` VALUES ('44', null, '1074', '马里Mali', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('45', null, '1075', '乌干达Uganda', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-03-18 18:23:43', '0');
INSERT INTO `T_REGION` VALUES ('46', null, '1076', '迪拜', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('47', null, '1077', '冈比亚Gambia', '3', '2', null, '1', null, 'system', '2017-01-04 14:21:37', 'system', '2017-01-04 14:25:04', '0');
INSERT INTO `T_REGION` VALUES ('48', null, '1078', '马达加斯加Madagascar', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('49', null, '1079', '马拉维Malawi', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('50', null, '1081', '塞舌尔Seychelles', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('51', null, '1082', '巴基斯坦Pakistan', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('52', null, '1083', '孟加拉Bangladesh', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('53', null, '30221', 'Bamako', '44', '4', null, '1', null, 'system', '2016-03-16 11:21:41', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('54', null, '30222', 'El Kanater', '169', '4', null, '1', null, 'system', '2016-03-16 19:23:21', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('55', null, '30223', 'Mansoura', '169', '4', null, '1', null, 'system', '2016-05-19 22:35:37', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('56', null, '30224', 'Orlu', '36', '4', null, '1', null, 'system', '2016-05-27 17:44:38', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('57', null, '30225', 'Sikasso', '44', '4', null, '1', null, 'system', '2016-06-12 11:17:06', 'system', '2016-07-11 14:36:19', '0');
INSERT INTO `T_REGION` VALUES ('58', null, '30226', 'Saint Louis', '172', '4', null, '1', null, 'system', '2016-06-15 14:02:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('59', null, '30227', 'Kaolack', '172', '4', null, '1', null, 'system', '2016-06-15 14:03:09', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('60', null, '30228', 'Mopti', '44', '4', null, '1', null, 'system', '2016-06-27 12:11:59', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('61', null, '30229', 'Ikot Ekpene', '36', '4', null, '1', null, 'system', '2016-07-01 14:48:03', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('62', null, '30230', 'Welikite', '162', '4', null, '1', null, 'system', '2016-07-05 18:27:20', 'system', '2017-02-04 17:18:18', '0');
INSERT INTO `T_REGION` VALUES ('63', null, '30231', 'Debiremarkos', '62', '4', null, '1', null, 'system', '2016-07-05 18:27:26', 'system', '2017-02-04 17:18:18', '0');
INSERT INTO `T_REGION` VALUES ('64', null, '30232', '沙特阿拉伯KSA', '3', '2', null, '1', null, 'system', '2016-07-07 18:28:03', 'system', '2016-07-28 10:05:22', '0');
INSERT INTO `T_REGION` VALUES ('65', null, '30233', 'Okigwe', '36', '4', null, '1', null, 'system', '2016-07-11 11:30:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('66', null, '30234', 'Mingar', '162', '4', null, '1', null, 'system', '2016-07-15 11:42:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('67', null, '30235', 'Agbor', '36', '4', null, '1', null, 'system', '2016-07-26 11:26:07', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('68', null, '30237', 'Riyadh', '64', '4', null, '1', null, 'system', '2016-07-28 12:03:35', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('69', null, '30238', 'Jeddah', '64', '4', null, '1', null, 'system', '2016-07-28 12:03:48', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('70', null, '30239', 'Nkubu', '39', '4', null, '1', null, 'system', '2016-08-09 11:35:33', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('71', null, '30240', 'Sapele', '36', '4', null, '1', null, 'system', '2016-08-12 15:01:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('72', null, '30241', 'Sevare', '44', '4', null, '1', null, 'system', '2016-08-12 17:12:53', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('73', null, '30242', 'Kayes', '44', '4', null, '1', null, 'system', '2016-08-12 17:14:19', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('74', null, '30243', 'Zguinchor', '172', '4', null, '1', null, 'system', '2016-08-15 16:44:13', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('75', null, '30244', 'Entebbe', '45', '4', null, '1', null, 'system', '2016-08-24 11:53:59', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('76', null, '30245', 'Mararaba', '36', '4', null, '1', null, 'system', '2016-08-24 12:46:09', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('77', null, '30246', 'Masaka', '45', '4', null, '1', null, 'system', '2016-08-24 12:47:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('78', null, '30248', 'Masindi', '45', '4', null, '1', null, 'system', '2016-08-25 16:09:44', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('79', null, '30249', '乍得Chad', '3', '2', null, '1', null, 'system', '2016-08-25 16:14:05', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('80', null, '30250', 'Ndjamena', '79', '4', null, '1', null, 'system', '2016-08-25 16:16:13', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('81', null, '30251', 'Soroti', '45', '4', null, '1', null, 'system', '2016-08-30 15:28:34', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('82', null, '30252', 'Suez', '169', '4', null, '1', null, 'system', '2016-08-30 15:28:56', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('83', null, '30253', 'Domiat', '169', '4', null, '1', null, 'system', '2016-08-30 15:29:16', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('84', null, '30254', 'Dakhlia', '169', '4', null, '1', null, 'system', '2016-08-30 15:29:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('85', null, '30255', 'Mubi', '36', '4', null, '1', null, 'system', '2016-08-31 20:49:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('86', null, '30256', 'Conakry', '161', '4', null, '1', null, 'system', '2016-09-14 10:27:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('87', null, '30257', 'Mbour', '172', '4', null, '1', null, 'system', '2016-09-23 16:00:15', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('88', null, '30258', 'Ruiru', '39', '4', null, '1', null, 'system', '2016-09-28 09:57:00', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('89', null, '30259', 'San', '44', '4', null, '1', null, 'system', '2016-09-28 17:29:12', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('90', null, '30260', 'Helwan', '169', '4', null, '1', null, 'system', '2016-09-28 17:57:44', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('91', null, '30261', 'Kisangani', '43', '4', null, '1', null, 'system', '2016-09-30 14:38:38', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('92', null, '30262', 'Nyanza', '163', '4', null, '1', null, 'system', '2016-09-30 14:38:55', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('93', null, '30263', 'Ogoja', '36', '4', null, '1', null, 'system', '2016-10-08 13:52:35', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('94', null, '30264', 'Lafia', '36', '4', null, '1', null, 'system', '2016-10-13 09:50:24', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('95', null, '30265', 'Bihara', '169', '4', null, '1', null, 'system', '2016-10-21 14:50:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('96', null, '30266', 'Welayita Sodo', '162', '4', null, '1', null, 'system', '2016-10-21 14:52:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('97', null, '30267', 'Maiduguri', '36', '4', null, '1', null, 'system', '2016-10-28 16:05:25', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('98', null, '30268', 'Yobe', '36', '4', null, '1', null, 'system', '2016-10-28 16:09:23', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('99', null, '30269', 'Segou', '44', '4', null, '1', null, 'system', '2016-10-28 16:18:35', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('100', null, '30270', 'Touba', '172', '4', null, '1', null, 'system', '2016-10-28 16:21:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('101', null, '30271', 'Sharqia', '169', '4', null, '1', null, 'system', '2016-10-28 16:59:46', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('102', null, '30272', 'Monufia', '169', '4', null, '1', null, 'system', '2016-10-28 17:00:02', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('103', null, '30080', 'Huye', '163', '4', null, '1', null, 'system', '2015-03-12 19:21:24', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('104', null, '30081', 'Kayonza', '163', '4', null, '1', null, 'system', '2015-03-12 19:21:36', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('105', null, '30082', 'Kibuye', '163', '4', null, '1', null, 'system', '2015-03-12 19:21:45', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('106', null, '30083', 'Kigali', '163', '4', null, '1', null, 'system', '2015-03-12 19:21:56', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('107', null, '30084', 'Muhanga', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:06', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('108', null, '30085', 'Musanze', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('109', null, '30086', 'Ngoma', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:26', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('110', null, '30087', 'Nyamata', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:37', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('111', null, '30088', 'Rubavu', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:48', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('112', null, '30089', 'Rusizi', '163', '4', null, '1', null, 'system', '2015-03-12 19:22:59', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('113', null, '30090', 'Kampala', '45', '4', null, '1', null, 'system', '2015-03-12 19:39:48', 'system', '2015-03-18 18:23:43', '0');
INSERT INTO `T_REGION` VALUES ('114', null, '30091', 'Abdel Aziz', '169', '4', null, '1', null, 'system', '2015-03-12 19:44:28', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('115', null, '30092', 'Alex', '169', '4', null, '1', null, 'system', '2015-03-12 19:44:40', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('116', null, '30093', 'Banha', '169', '4', null, '1', null, 'system', '2015-03-12 19:44:49', 'system', '2016-07-01 10:39:25', '0');
INSERT INTO `T_REGION` VALUES ('117', null, '30094', 'Cairo', '169', '4', null, '1', null, 'system', '2015-03-12 19:44:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('118', null, '30095', 'Giza', '169', '4', null, '1', null, 'system', '2015-03-12 19:45:08', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('119', null, '30096', 'Ismailia', '169', '4', null, '1', null, 'system', '2015-03-12 19:45:16', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('120', null, '30097', 'Tanta', '169', '4', null, '1', null, 'system', '2015-03-12 19:45:25', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('121', null, '30098', 'Upper', '169', '4', null, '1', null, 'system', '2015-03-12 19:45:35', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('122', null, '30099', 'Bungoma', '39', '4', null, '1', null, 'system', '2015-03-12 19:52:26', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('123', null, '30100', 'Kakamega', '39', '4', null, '1', null, 'system', '2015-03-12 19:52:37', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('124', null, '30101', 'Kitale', '39', '4', null, '1', null, 'system', '2015-03-12 19:52:48', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('125', null, '30102', 'Maua', '39', '4', null, '1', null, 'system', '2015-03-12 19:52:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('126', null, '30103', 'Naivasha', '39', '4', null, '1', null, 'system', '2015-03-12 19:53:08', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('127', null, '30104', 'Nanyuki', '39', '4', null, '1', null, 'system', '2015-03-12 19:53:16', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('128', null, '30105', 'Narok', '39', '4', null, '1', null, 'system', '2015-03-12 19:53:25', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('129', null, '30106', 'Agaro', '162', '4', null, '1', null, 'system', '2015-03-12 19:57:14', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('130', null, '30107', 'Alamata', '162', '4', null, '1', null, 'system', '2015-03-12 19:57:25', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('131', null, '30108', 'Asela', '162', '4', null, '1', null, 'system', '2015-03-12 19:57:35', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('132', null, '30109', 'Bale Robe', '162', '4', null, '1', null, 'system', '2015-03-12 19:57:44', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('133', null, '30110', 'Debrezeyit', '162', '4', null, '1', null, 'system', '2015-03-12 19:57:54', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('134', null, '30111', 'Gonder', '162', '4', null, '1', null, 'system', '2015-03-12 19:58:03', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('135', null, '30112', 'Woldiya', '162', '4', null, '1', null, 'system', '2015-03-12 19:58:20', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('136', null, '30113', 'Woliso', '162', '4', null, '1', null, 'system', '2015-03-12 19:58:33', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('137', null, '30114', 'Ziway', '162', '4', null, '1', null, 'system', '2015-03-12 19:58:43', 'system', '2017-01-03 15:22:09', '0');
INSERT INTO `T_REGION` VALUES ('138', null, '30115', 'Arusha', '38', '4', null, '1', null, 'system', '2015-03-12 20:01:32', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('139', null, '30116', 'Dodoma', '38', '4', null, '1', null, 'system', '2015-03-12 20:01:41', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('140', null, '30117', 'Iringa', '38', '4', null, '1', null, 'system', '2015-03-12 20:01:48', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('141', null, '30118', 'Kigamboni', '38', '4', null, '1', null, 'system', '2015-03-12 20:01:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('142', null, '30119', 'Kigoma', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:06', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('143', null, '30120', 'Kilimanjaro', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:15', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('144', null, '30121', 'Korogwe', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:23', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('145', null, '30122', 'Lindi', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:32', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('146', null, '30123', 'Morogoro', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:41', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('147', null, '30124', 'Mpanda', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:49', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('148', null, '30125', 'Mtwara', '38', '4', null, '1', null, 'system', '2015-03-12 20:02:57', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('149', null, '30126', 'Mwanza', '38', '4', null, '1', null, 'system', '2015-03-12 20:03:04', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('150', null, '30127', 'Zanzibar', '38', '4', null, '1', null, 'system', '2015-03-12 20:03:13', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('151', null, '30128', 'Zaria', '36', '4', null, '1', null, 'system', '2015-03-12 20:06:10', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('152', null, '30129', 'Sokoto', '36', '4', null, '1', null, 'system', '2015-03-12 20:06:26', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('153', null, '1084', '总部', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('154', null, '1085', '香港办', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('155', null, '1086', '迪拜办', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('156', null, '1087', '芒果肯尼亚', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('157', null, '1088', '刚果布Congo', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('158', null, '1089', '塞拉利昂Sierra Leone', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('159', null, '1090', '印度India', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('160', null, '1091', '老挝Laos', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('161', null, '1092', '几内亚Guinea', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('162', null, '1093', '埃塞俄比亚Ethiopia', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-04-03 00:20:59', '0');
INSERT INTO `T_REGION` VALUES ('163', null, '1094', '卢旺达Rwanda', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-03-17 18:38:19', '0');
INSERT INTO `T_REGION` VALUES ('164', null, '1095', '斐济Fiji', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('165', null, '1097', '安哥拉Angola', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('166', null, '1098', '利比里亚Liberia', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('167', null, '1100', '布隆迪Burundi', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-04-02 23:54:47', '0');
INSERT INTO `T_REGION` VALUES ('168', null, '1101', '所罗门Solomon Islands', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('169', null, '1102', '埃及Egypt', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-08-30 15:29:31', '0');
INSERT INTO `T_REGION` VALUES ('170', null, '1103', '索马里Somalia', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('171', null, '1104', '丹麦Denmark', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('172', null, '1105', '塞内加尔Senegal', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('173', null, '1106', '突尼斯Tunisia', '3', '2', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('174', null, '1124', '南非South Africa', '3', '2', null, '1', null, 'system', '2014-04-19 17:41:14', 'system', '2014-04-19 17:41:14', '0');
INSERT INTO `T_REGION` VALUES ('175', null, '1135', 'TEST01', '159', '4', null, '2', null, 'system', '2014-06-18 22:22:39', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('176', null, '10045', '中国China', '3', '2', null, '2', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('177', null, '30001', 'Nairobi', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('178', null, '30002', 'Meru', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('179', null, '30003', 'Nyeri', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('180', null, '30004', 'Thika', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('181', null, '30005', 'Embu', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('182', null, '30006', 'Machakos', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('183', null, '30007', 'Eldoret', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('184', null, '30008', 'Kisumu', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('185', null, '30009', 'Nakuru', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('186', null, '30010', 'Kericho', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('187', null, '30011', 'Kisii', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('188', null, '30012', 'Mombasa', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('189', null, '30013', 'Accra', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('190', null, '30014', 'Kumasi', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('191', null, '30015', 'Techiman', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('192', null, '30016', 'Sunyani', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('193', null, '30017', 'Koforidua', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('194', null, '30019', 'Cape Coast', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('195', null, '30020', 'Tarkwa', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('196', null, '30021', 'Takoradi', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('197', null, '30022', 'Bolgatanga', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('198', null, '30023', 'Tamale', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('199', null, '30024', 'Wa', '41', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('200', null, '30026', 'Bafoussam', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('201', null, '30027', 'Bamenda', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('202', null, '30028', 'Garoua', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('203', null, '30029', 'Ngaoundere', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('204', null, '30030', 'Yaounde', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('205', null, '30031', 'Douala', '42', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('206', null, '30033', 'Dar', '38', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('207', null, '30034', 'Addis Ababa', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('208', null, '30035', 'Nazret', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2014-08-27 22:11:11', '0');
INSERT INTO `T_REGION` VALUES ('209', null, '30036', 'Jimma', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('210', null, '30037', 'Dire Dawa', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('211', null, '30038', 'Harer', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('212', null, '30039', 'Bahir Dar', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('213', null, '30040', 'Hawasa', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('214', null, '30041', 'Shashemene', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('215', null, '30042', 'Mekelle', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('216', null, '30043', 'Dessie', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('217', null, '30044', 'Kombolcha', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('218', null, '30045', 'Seqota', '162', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('219', null, '30046', 'Lagos', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('220', null, '30047', 'Enugu', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('221', null, '30048', 'Owerri', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('222', null, '30049', 'Warri', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('223', null, '30050', 'Benin', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-06-16 18:00:52', '0');
INSERT INTO `T_REGION` VALUES ('224', null, '30051', 'Calabar', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('225', null, '30052', 'Uyo', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('226', null, '30053', 'Aba', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('227', null, '30054', 'Phc', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('228', null, '30055', 'Abuja', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('229', null, '30056', 'Ilorin', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('230', null, '30057', 'Makurdi', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('231', null, '30058', 'Minna', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('232', null, '30059', 'Lokoja', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('233', null, '30060', 'Jos', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('234', null, '30061', 'Abeokuta', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('235', null, '30062', 'Akure', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('236', null, '30063', 'Ekiti', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2015-03-12 18:38:33', '0');
INSERT INTO `T_REGION` VALUES ('237', null, '30064', 'Ibadan', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('238', null, '30065', 'Ife', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('239', null, '30066', 'Kano', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('240', null, '30067', 'Yola', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('241', null, '30068', 'Gombe', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('242', null, '30069', 'Jalingo', '36', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('243', null, '30070', 'Migori', '39', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('244', null, '30071', 'Libreville', '37', '4', null, '1', null, 'system', '2016-11-14 09:43:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('245', null, '30073', 'Amakohia', '36', '4', null, '1', null, 'system', '2015-03-12 18:38:33', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('246', null, '30074', 'Ughelli', '36', '4', null, '1', null, 'system', '2015-03-12 18:38:51', 'system', '2016-07-01 12:14:59', '0');
INSERT INTO `T_REGION` VALUES ('247', null, '30075', 'Bayelsa', '36', '4', null, '1', null, 'system', '2015-03-12 18:39:27', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('248', null, '30076', 'Eket', '36', '4', null, '1', null, 'system', '2015-03-12 18:39:43', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('249', null, '30077', 'Bujumbura', '167', '4', null, '1', null, 'system', '2015-03-12 19:20:38', 'system', '2015-04-03 00:20:44', '0');
INSERT INTO `T_REGION` VALUES ('250', null, '30078', 'Bukavu', '43', '4', null, '1', null, 'system', '2015-03-12 19:20:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('251', null, '30079', 'Goma', '43', '4', null, '1', null, 'system', '2015-03-12 19:21:12', 'system', '2016-10-21 16:36:38', '0');
INSERT INTO `T_REGION` VALUES ('252', null, '30130', 'Katsina', '36', '4', null, '1', null, 'system', '2015-03-12 20:06:37', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('253', null, '30131', 'Zamfara', '36', '4', null, '1', null, 'system', '2015-03-12 20:06:48', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('254', null, '30132', 'Bauchi', '36', '4', null, '1', null, 'system', '2015-03-12 20:07:07', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('255', null, '30133', 'Jigawa', '36', '4', null, '1', null, 'system', '2015-03-12 20:07:36', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('256', null, '30134', 'Asaba', '36', '4', null, '1', null, 'system', '2015-03-12 20:08:04', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('257', null, '30135', 'Awka', '36', '4', null, '1', null, 'system', '2015-03-12 20:08:14', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('258', null, '30136', 'Nnewi', '36', '4', null, '1', null, 'system', '2015-03-12 20:08:23', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('259', null, '30137', 'Hohoe', '41', '4', null, '1', null, 'system', '2015-03-17 18:23:52', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('260', null, '30138', 'Swedru', '41', '4', null, '1', null, 'system', '2015-03-17 18:24:54', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('261', null, '30139', 'Tema', '41', '4', null, '1', null, 'system', '2015-03-17 18:25:25', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('262', null, '30141', 'Kitui', '39', '4', null, '1', null, 'system', '2015-03-17 18:26:42', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('263', null, '30142', 'Kaduna', '36', '4', null, '1', null, 'system', '2015-03-17 18:29:09', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('264', null, '30144', 'Bukave', '43', '4', null, '1', null, 'system', '2015-03-17 18:31:08', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('265', null, '30145', 'Butare', '163', '4', null, '1', null, 'system', '2015-03-17 18:31:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('266', null, '30146', 'Cyangugu', '163', '4', null, '1', null, 'system', '2015-03-17 18:31:52', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('267', null, '30147', 'Gisenyi', '163', '4', null, '1', null, 'system', '2015-03-17 18:32:07', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('268', null, '30148', 'Kibungo', '163', '4', null, '1', null, 'system', '2015-03-17 18:32:34', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('269', null, '30149', 'Ruhengeri', '163', '4', null, '1', null, 'system', '2015-03-17 18:33:17', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('270', null, '30150', 'Katavi', '38', '4', null, '1', null, 'system', '2015-03-17 18:33:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('271', null, '30151', 'Tanga', '38', '4', null, '1', null, 'system', '2015-03-17 18:34:40', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('272', null, '30156', '测试城市', '174', '4', null, '1', null, 'system', '2015-03-18 22:26:27', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('273', null, '30157', 'Bertoua', '42', '4', null, '1', null, 'system', '2015-03-21 19:19:46', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('274', null, '30158', 'Athi River', '39', '4', null, '1', null, 'system', '2015-04-02 22:42:12', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('275', null, '30159', 'Mbeya', '38', '4', null, '1', null, 'system', '2015-04-28 00:49:31', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('276', null, '30160', 'Berekum', '41', '4', null, '1', null, 'system', '2015-05-18 23:22:12', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('277', null, '30161', 'Mbale', '45', '4', null, '1', null, 'system', '2015-05-19 00:46:58', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('278', null, '30162', 'Arua', '45', '4', null, '1', null, 'system', '2015-05-19 00:47:06', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('279', null, '30163', 'Jinja', '45', '4', null, '1', null, 'system', '2015-05-19 00:47:14', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('280', null, '30164', 'Gulu', '45', '4', null, '1', null, 'system', '2015-05-19 00:47:20', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('281', null, '30165', 'Mbarara', '45', '4', null, '1', null, 'system', '2015-05-19 00:47:26', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('282', null, '30166', 'Lira', '45', '4', null, '1', null, 'system', '2015-05-19 00:47:33', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('283', null, '30167', 'Gitarama', '163', '4', null, '1', null, 'system', '2015-05-20 20:10:57', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('284', null, '30168', 'Rwamagana', '163', '4', null, '1', null, 'system', '2015-05-20 20:11:13', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('285', null, '30169', 'Onitsha', '36', '4', null, '1', null, 'system', '2015-05-20 21:44:00', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('286', null, '30205', 'Oshogbo', '36', '4', null, '1', null, 'system', '2015-09-06 13:55:54', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('287', null, '30206', 'Ebolowa', '42', '4', null, '1', null, 'system', '2015-10-08 09:55:52', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('288', null, '30207', 'HO', '41', '4', null, '1', null, 'system', '2015-10-12 16:39:20', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('289', null, '30208', 'Port Said', '169', '4', null, '1', null, 'system', '2015-10-21 11:37:48', 'system', '2016-09-28 17:59:28', '0');
INSERT INTO `T_REGION` VALUES ('290', null, '30209', 'RUSANZE', '163', '4', null, '1', null, 'system', '2015-10-29 17:58:12', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('291', null, '30210', 'Umuahia', '36', '4', null, '1', null, 'system', '2015-11-02 17:41:55', 'system', '2017-02-05 14:14:06', '0');
INSERT INTO `T_REGION` VALUES ('292', null, '30211', 'Gusau', '36', '4', null, '1', null, 'system', '2015-11-03 10:20:29', 'system', '2016-03-31 12:04:09', '0');
INSERT INTO `T_REGION` VALUES ('293', null, '30212', 'Abakaliki', '36', '4', null, '1', null, 'system', '2015-11-03 15:29:01', 'system', '2016-03-30 15:15:02', '0');
INSERT INTO `T_REGION` VALUES ('294', null, '30213', 'Kahama', '38', '4', null, '1', null, 'system', '2015-12-23 10:02:36', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('295', null, '30214', 'Debre Birhan', '162', '4', null, '1', null, 'system', '2016-01-06 15:45:57', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('296', null, '30215', 'Hara', '162', '4', null, '1', null, 'system', '2016-02-26 16:06:29', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('297', null, '30216', 'Hossna', '162', '4', null, '1', null, 'system', '2016-02-26 16:07:11', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('298', null, '30217', 'Shire', '162', '4', null, '1', null, 'system', '2016-02-26 16:07:36', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('299', null, '30218', 'Dakar', '172', '4', null, '1', null, 'system', '2016-03-09 16:27:13', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('300', null, '30219', 'Monofaya', '169', '4', null, '1', null, 'system', '2016-03-15 13:47:41', 'system', '2016-12-24 10:31:14', '0');
INSERT INTO `T_REGION` VALUES ('301', null, '30220', 'Qalubia', '169', '4', null, '1', null, 'system', '2016-03-15 15:18:24', 'system', '2016-11-14 09:43:43', '0');
INSERT INTO `T_REGION` VALUES ('302', null, '30275', 'Malindi', '39', '4', null, '1', null, 'system', '2016-11-15 18:28:42', 'system', '2016-11-15 18:26:50', '0');
INSERT INTO `T_REGION` VALUES ('303', null, '30276', 'Voi', '39', '4', null, '1', null, 'system', '2016-11-15 18:38:36', 'system', '2016-11-15 18:36:55', '0');
INSERT INTO `T_REGION` VALUES ('304', null, '30277', 'Ikom', '36', '4', null, '1', null, 'system', '2016-11-15 18:52:55', 'system', '2016-11-15 18:51:12', '0');
INSERT INTO `T_REGION` VALUES ('305', null, '30278', 'Axum', '162', '4', null, '1', null, 'system', '2016-11-21 18:36:07', 'system', '2016-11-21 18:34:17', '0');
INSERT INTO `T_REGION` VALUES ('306', null, '30279', 'Mekele', '162', '4', null, '1', null, 'system', '2016-11-21 18:49:56', 'system', '2016-11-21 18:47:47', '0');
INSERT INTO `T_REGION` VALUES ('307', null, '30280', 'Dangila', '162', '4', null, '1', null, 'system', '2016-11-21 18:50:09', 'system', '2016-11-21 18:48:17', '0');
INSERT INTO `T_REGION` VALUES ('308', null, '30281', 'Maystebri', '162', '4', null, '1', null, 'system', '2016-11-21 18:51:11', 'system', '2016-11-21 18:49:17', '0');
INSERT INTO `T_REGION` VALUES ('309', null, '30282', 'Byumba', '163', '4', null, '1', null, 'system', '2016-11-21 18:52:41', 'system', '2016-11-21 18:50:47', '0');
INSERT INTO `T_REGION` VALUES ('310', null, '30203', 'Bani Swef', '169', '4', null, '1', null, 'system', '2016-11-29 15:16:43', 'system', '2016-11-29 15:14:10', '0');
INSERT INTO `T_REGION` VALUES ('311', null, '30204', 'Fayom', '169', '4', null, '1', null, 'system', '2016-11-29 15:16:55', 'system', '2016-11-29 15:14:40', '0');
INSERT INTO `T_REGION` VALUES ('312', null, '30283', 'Mania', '169', '4', null, '1', null, 'system', '2016-11-29 15:35:54', 'system', '2016-11-29 15:33:41', '0');
INSERT INTO `T_REGION` VALUES ('313', null, '30284', 'Chuka', '39', '4', null, '1', null, 'system', '2016-12-21 21:03:07', 'system', '2016-12-21 20:59:57', '0');
INSERT INTO `T_REGION` VALUES ('314', null, '30285', 'Ekwulobia', '36', '4', null, '1', null, 'system', '2016-12-22 21:09:28', 'system', '2016-12-22 21:06:32', '0');
INSERT INTO `T_REGION` VALUES ('315', null, '30286', 'Kebbi', '36', '4', null, '1', null, 'system', '2016-12-22 21:26:51', 'system', '2016-12-22 21:23:32', '0');
INSERT INTO `T_REGION` VALUES ('316', null, '30287', 'Mtwapa', '39', '4', null, '1', null, 'system', '2016-12-22 21:28:24', 'system', '2016-12-22 21:25:32', '0');
INSERT INTO `T_REGION` VALUES ('317', null, '30288', 'Kapsabet', '39', '4', null, '1', null, 'system', '2016-12-22 21:28:51', 'system', '2016-12-22 21:25:32', '0');
INSERT INTO `T_REGION` VALUES ('318', null, '30289', 'Kapenguria', '39', '4', null, '1', null, 'system', '2016-12-22 21:29:02', 'system', '2016-12-22 21:26:02', '0');
INSERT INTO `T_REGION` VALUES ('319', null, '30290', 'Kerugoya', '39', '4', null, '1', null, 'system', '2016-12-22 21:29:44', 'system', '2016-12-22 21:26:32', '0');
INSERT INTO `T_REGION` VALUES ('320', null, '30291', 'Karatina', '39', '4', null, '1', null, 'system', '2016-12-22 21:30:06', 'system', '2016-12-22 21:27:02', '0');
INSERT INTO `T_REGION` VALUES ('321', null, '30292', 'Banjul', '47', '4', null, '1', null, 'system', '2016-12-30 19:09:23', 'system', '2016-12-30 19:06:14', '0');
INSERT INTO `T_REGION` VALUES ('322', null, '30293', '南苏丹S.Sudan', '3', '2', null, '1', null, 'system', '2016-12-30 19:13:53', 'system', '2017-02-08 18:33:32', '0');
INSERT INTO `T_REGION` VALUES ('323', null, '30294', 'Juba', '322', '4', null, '1', null, 'system', '2016-12-30 19:14:20', 'system', '2017-02-04 17:13:55', '0');
INSERT INTO `T_REGION` VALUES ('324', null, '30296', 'Abidjan', '325', '4', null, '1', null, 'system', '2016-12-30 19:14:57', 'system', '2017-02-04 17:14:27', '0');
INSERT INTO `T_REGION` VALUES ('325', null, '30295', '科特迪瓦Cote DIvoire', '3', '2', null, '1', null, 'system', '2016-12-30 19:14:49', 'system', '2017-01-04 14:27:17', '0');
INSERT INTO `T_REGION` VALUES ('326', null, '30297', '毛里塔尼亚Maruitania', '3', '2', null, '1', null, 'system', '2016-12-30 19:15:46', 'system', '2017-01-04 14:25:11', '0');
INSERT INTO `T_REGION` VALUES ('327', null, '30298', 'Nouakchott', '326', '4', null, '1', null, 'system', '2016-12-30 19:15:58', 'system', '2017-02-04 17:14:11', '0');
INSERT INTO `T_REGION` VALUES ('328', null, '30299', 'Aswan', '169', '4', null, '1', null, 'system', '2016-12-30 19:40:16', 'system', '2017-01-16 01:28:15', '0');
INSERT INTO `T_REGION` VALUES ('329', null, '30300', 'Luxor', '169', '4', null, '1', null, 'system', '2016-12-30 19:40:28', 'system', '2016-12-30 19:37:14', '0');
INSERT INTO `T_REGION` VALUES ('330', null, '30301', 'Qina', '169', '4', null, '1', null, 'system', '2016-12-30 19:41:05', 'system', '2016-12-30 19:37:44', '0');
INSERT INTO `T_REGION` VALUES ('331', null, '30302', 'Assuit', '169', '4', null, '1', null, 'system', '2016-12-30 19:42:12', 'system', '2016-12-30 19:38:44', '0');
INSERT INTO `T_REGION` VALUES ('332', null, '30303', 'Sohag', '169', '4', null, '1', null, 'system', '2016-12-30 19:42:38', 'system', '2016-12-30 19:39:14', '0');
INSERT INTO `T_REGION` VALUES ('333', null, '30304', 'Metu', '162', '4', null, '1', null, 'system', '2016-12-30 19:43:14', 'system', '2016-12-30 19:39:44', '0');
INSERT INTO `T_REGION` VALUES ('334', null, '30305', 'Debre Tabor', '162', '4', null, '1', null, 'system', '2016-12-30 19:45:08', 'system', '2016-12-30 19:41:44', '0');
INSERT INTO `T_REGION` VALUES ('335', null, '30306', 'Nateete', '45', '4', null, '1', null, 'system', '2016-12-30 19:45:31', 'system', '2016-12-30 19:42:14', '0');
INSERT INTO `T_REGION` VALUES ('336', null, '30307', 'Gayaza', '45', '4', null, '1', null, 'system', '2016-12-30 19:45:49', 'system', '2016-12-30 19:42:44', '0');
INSERT INTO `T_REGION` VALUES ('337', null, '30308', 'Mukono', '45', '4', null, '1', null, 'system', '2016-12-30 19:46:03', 'system', '2016-12-30 19:42:44', '0');
INSERT INTO `T_REGION` VALUES ('338', null, '30309', 'Kawempe', '45', '4', null, '1', null, 'system', '2016-12-30 19:46:22', 'system', '2016-12-30 19:43:14', '0');
INSERT INTO `T_REGION` VALUES ('339', null, '30310', 'Kamwokya', '45', '4', null, '1', null, 'system', '2016-12-30 19:46:37', 'system', '2016-12-30 19:43:14', '0');
INSERT INTO `T_REGION` VALUES ('340', null, '30311', 'Kolda', '172', '4', null, '1', null, 'system', '2016-12-30 19:46:52', 'system', '2016-12-30 19:43:44', '0');
INSERT INTO `T_REGION` VALUES ('341', null, '30312', 'Assosa', '162', '4', null, '1', null, 'system', '2016-12-30 19:49:54', 'system', '2016-12-30 19:46:44', '0');
INSERT INTO `T_REGION` VALUES ('342', null, '30313', 'Kyaliwajala', '45', '4', null, '1', null, 'system', '2017-01-04 15:26:20', 'system', '2017-01-04 15:22:37', '0');
INSERT INTO `T_REGION` VALUES ('343', null, '30315', 'Auchi', '36', '4', null, '1', null, 'system', '2017-02-06 14:13:29', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('344', null, '30317', 'Kamokya', '45', '4', null, '1', null, 'system', '2017-02-06 14:15:19', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('345', null, '30319', 'Kabale', '45', '4', null, '1', null, 'system', '2017-02-06 14:16:03', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('346', null, '30321', 'Chagni', '162', '4', null, '1', null, 'system', '2017-02-06 14:16:55', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('347', null, '30314', 'Ilesha', '36', '4', null, '1', null, 'system', '2017-02-06 14:12:55', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('348', null, '30316', 'Wakiso', '45', '4', null, '1', null, 'system', '2017-02-06 14:14:58', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('349', null, '30318', 'Kyaliwajjalla', '45', '4', null, '1', null, 'system', '2017-02-06 14:15:48', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('350', null, '30320', 'Nekemet', '162', '4', null, '1', null, 'system', '2017-02-06 14:16:38', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('351', null, '30322', 'Mota', '162', '4', null, '1', null, 'system', '2017-02-06 14:17:15', 'system', '2017-02-06 17:53:23', '0');
INSERT INTO `T_REGION` VALUES ('352', null, '30323', '莫桑比克Mozambique', '3', '2', null, '1', null, 'system', '2017-02-22 11:32:37', 'system', '2017-02-22 11:27:44', '0');
INSERT INTO `T_REGION` VALUES ('353', null, '30324', 'Maputo', '352', '4', null, '1', null, 'system', '2017-02-22 11:33:06', 'system', '2017-02-22 11:27:44', '0');
