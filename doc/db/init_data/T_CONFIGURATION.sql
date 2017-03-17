/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:48:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_CONFIGURATION
-- ----------------------------
DROP TABLE IF EXISTS `T_CONFIGURATION`;
CREATE TABLE `T_CONFIGURATION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) DEFAULT NULL,
  `VALUE` varchar(256) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_CONFIGURATION
-- ----------------------------
INSERT INTO `T_CONFIGURATION` VALUES ('1', 'sale.imei.url', 'http://176.34.150.246:8081/api/komByImei1', '销量上传单个IMEI验证');
INSERT INTO `T_CONFIGURATION` VALUES ('2', 'sale.imeis.url', 'http://176.34.150.246:8081/api/checkBatchImei', '销量上传批量IMEI验证');
INSERT INTO `T_CONFIGURATION` VALUES ('3', 'rq.code.url', 'http://176.34.150.246:8081/api/kom', '扫描二维码');
INSERT INTO `T_CONFIGURATION` VALUES ('4', 'import.task.url', 'http://10.151.170.158:8082/sale/saveSaleTask/', 'Excel文件导入地址');
INSERT INTO `T_CONFIGURATION` VALUES ('5', 'STATISTICS_DAILY_DATE', '2017-03-08 08:55:02', null);
