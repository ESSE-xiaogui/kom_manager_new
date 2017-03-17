/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:48:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_ATTRIBUTE
-- ----------------------------
DROP TABLE IF EXISTS `T_ATTRIBUTE`;
CREATE TABLE `T_ATTRIBUTE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `TYPE` int(8) NOT NULL,
  `SQE` int(8) NOT NULL,
  `NAME_EN` varchar(64) DEFAULT NULL,
  `NAME_CN` varchar(64) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ATTRIBUTE
-- ----------------------------
INSERT INTO `T_ATTRIBUTE` VALUES ('1', '2', '1', '1', 'Close', '亲密', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('2', '2', '1', '2', 'Good', '好', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('3', '2', '1', '3', 'Normal', '一般', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('4', '2', '1', '4', 'Bad', '差', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('5', '2', '2', '1', 'Retail', '零售', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('6', '2', '2', '2', 'Wholesale', '批发', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('7', '2', '2', '3', 'Retail&Wholesale', '零售&批发', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('8', '2', '4', '1', 'Exclusive Shop', '专卖店', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('9', '2', '4', '2', 'Branding Shop', '品牌店', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('10', '2', '3', '1', '0-49USD', '0-49美元', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('11', '2', '3', '2', '50USD-99USD', '50-99美元', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('12', '2', '3', '3', '100-199USD', '100-199美元', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('13', '2', '3', '4', '200UP USD', '200美元以上', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('14', '2', '5', '1', '1~100PCS', '1~100台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('15', '2', '5', '2', '100~200PCS', '100~200台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('16', '2', '5', '3', '200~300PCS', '200~300台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('17', '2', '5', '4', '300~600PCS', '300~600台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('18', '2', '5', '5', '600~800PCS', '600~800台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('19', '2', '5', '6', '800~1500PCS', '800~1500台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('20', '2', '5', '7', '1500~2000PCS', '1500~2000台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('21', '2', '5', '8', '>2000PCS', '>2000台', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('22', '2', '1', '5', 'Not Bad', '不太差', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('23', '2', '6', '1', 'Standard Exclusive', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('24', '2', '6', '2', 'Image Exclusive', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('25', '2', '6', '3', 'Flagship Shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('26', '2', '6', '4', 'Chain shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('27', '2', '6', '5', 'Shopping mall', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('28', '2', '6', '6', 'Independent shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('29', '2', '6', '7', 'Mobile market shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('30', '2', '6', '8', 'Operator shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('31', '2', '6', '9', 'Electronic appliance shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('32', '2', '7', '1', null, '门店形象', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('33', '2', '7', '2', null, '业务技能', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('34', '2', '7', '3', null, '人员形象', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('35', '4', '6', '1', 'Standard Exclusive', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('36', '4', '6', '2', 'Image Exclusive', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('37', '4', '6', '3', 'Flagship Shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('38', '4', '6', '4', 'Chain shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('39', '4', '6', '5', 'Shopping mall', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('40', '4', '6', '6', 'Independent shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('41', '4', '6', '7', 'Mobile market shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('42', '4', '6', '8', 'Operator shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('43', '4', '6', '9', 'Electronic appliance shop', null, null);
INSERT INTO `T_ATTRIBUTE` VALUES ('44', '4', '2', '1', 'Retail', '零售', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('45', '4', '2', '2', 'Wholesale', '批发', null);
INSERT INTO `T_ATTRIBUTE` VALUES ('46', '4', '2', '3', 'Retail&Wholesale', '零售&批发', null);
