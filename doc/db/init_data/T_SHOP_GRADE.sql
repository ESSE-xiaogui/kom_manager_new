/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:52:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SHOP_GRADE
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_GRADE`;
CREATE TABLE `T_SHOP_GRADE` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `GRADE_NAME` varchar(50) NOT NULL COMMENT 'åº—é“ºç­‰çº§',
  `BRAND_CODE` varchar(16) NOT NULL,
  `SALE_QTY` varchar(32) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  `IS_INACTIVE` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'æ˜¯å¦å¯ç”¨ 1å¯ç”¨ 2åœç”¨',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_SHOP_GRADE
-- ----------------------------
INSERT INTO `T_SHOP_GRADE` VALUES ('1', 'A++', 'TECNO', '21', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('2', 'A+', 'TECNO', '20', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('3', 'A', 'TECNO', '19', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('4', 'B', 'TECNO', '18', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('5', 'C', 'TECNO', '17', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('6', 'D', 'TECNO', '16', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('7', 'E', 'TECNO', '15', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('8', 'F', 'TECNO', '14', '2', null, '1', null, null, null, null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('9', 'test', 'INFINIX', null, '3', null, '1', '', 'Infmanager', '2017-03-17 17:32:55', null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('10', 'KRS', 'ITEL', null, '4', null, '1', '', 'Imanager', '2017-03-17 17:59:54', null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('11', 'NRS', 'ITEL', null, '4', null, '1', '', 'Imanager', '2017-03-17 18:00:06', null, null);
INSERT INTO `T_SHOP_GRADE` VALUES ('12', 'Other', 'ITEL', null, '4', null, '1', '', 'Imanager', '2017-03-17 18:00:25', null, null);
