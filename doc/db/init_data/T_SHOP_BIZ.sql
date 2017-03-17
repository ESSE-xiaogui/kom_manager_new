/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:52:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SHOP_BIZ
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_BIZ`;
CREATE TABLE `T_SHOP_BIZ` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `SHOP_TYPE` int(2) DEFAULT NULL COMMENT '1:ä¸“å–åº— 2ï¼šå“ç‰Œåº—',
  `SHOP_AREA` varchar(50) DEFAULT NULL,
  `BIZ_NAME` varchar(50) DEFAULT NULL COMMENT 'ä¸šåŠ¡ç±»åž‹',
  `BRAND_CODE` varchar(50) DEFAULT NULL,
  `CN_NAME` varchar(50) DEFAULT NULL,
  `EN_NAME` varchar(50) DEFAULT NULL,
  `IS_INACTIVE` tinyint(1) DEFAULT '1' COMMENT 'æ˜¯å¦å¯ç”¨ 1å¯ç”¨ 2åœç”¨',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_SHOP_BIZ
-- ----------------------------
INSERT INTO `T_SHOP_BIZ` VALUES ('1', '2', '8', '≥20m²', null, 'TECNO', '标准店', 'Standard Exclusive', '1', '20-30㎡', '02459', '2017-03-17 15:52:00', '02459', '2017-03-17 15:52:00', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('2', '2', '8', '≥30m²', null, 'TECNO', '形象店', 'Image Exclusive', '1', '30-50㎡', '02459', '2017-03-17 15:52:18', '02459', '2017-03-17 15:52:18', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('3', '2', '8', '≥50m²', null, 'TECNO', '旗舰店', 'Flagship Shop', '1', '50㎡以上', '02459', '2017-03-17 15:52:41', '02459', '2017-03-17 15:52:41', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('4', '2', '9', 'm²', null, 'TECNO', '连锁店', 'Chain Shop', '1', 'The retailer owns two shops or above;', '02459', '2017-03-17 15:53:02', '02459', '2017-03-17 15:53:02', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('5', '2', '9', 'm²', null, 'TECNO', '大型商超店', 'Shopping Mall', '1', 'The shop in the mall or supermarket;', '02459', '2017-03-17 15:53:22', '02459', '2017-03-17 15:53:22', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('6', '2', '9', 'm²', null, 'TECNO', '独立小店', 'Independent Shop', '1', 'The shop locates outside phone market;', '02459', '2017-03-17 15:54:32', '02459', '2017-03-17 15:54:32', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('7', '2', '9', 'm²', null, 'TECNO', '区域通信中心市场店', 'Mobile Market Shop', '1', 'The shop locates in phone market;', '02459', '2017-03-17 15:54:50', '02459', '2017-03-17 15:54:50', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('8', '2', '9', 'm²', null, 'TECNO', '运营商店', 'Operator Shop', '1', 'The shop of operator;', '02459', '2017-03-17 15:55:03', '02459', '2017-03-17 15:55:03', null);
INSERT INTO `T_SHOP_BIZ` VALUES ('9', '2', '9', 'm²', null, 'TECNO', '电器卖场店', 'Electronic Appliance Shop', '1', 'The shop sells the electronic appliance and phones;', '02459', '2017-03-17 15:55:22', '02459', '2017-03-17 15:55:22', null);
