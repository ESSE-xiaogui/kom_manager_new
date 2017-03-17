/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:53:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SYSTEM_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_RESOURCE`;
CREATE TABLE `T_SYSTEM_RESOURCE` (
  `RES_ID` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `RES_TYPE` char(1) DEFAULT 'B' COMMENT '资源类型(F:前端web资源，B:后台资源）',
  `RES_CODE` varchar(20) DEFAULT NULL COMMENT '资源CODE',
  `RES_NAME` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `RES_URL` varchar(50) DEFAULT NULL COMMENT '资源的url',
  `SHOW_INDEX` bigint(8) DEFAULT NULL COMMENT '显示顺序',
  `IS_ANON_ACCESS` char(1) NOT NULL COMMENT 'N：不可匿名访问 Y：可匿名访问',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`RES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of T_SYSTEM_RESOURCE
-- ----------------------------
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('1', 'B', 'login', '用户登录', '/user/login', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('2', 'B', 'employee', '员工管理', '/employee/**', '1', 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('3', 'B', 'encrypt', 'encrypt', '/user/encrypt', '1', 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('4', 'B', 'systemMenu', 'systemMenu', '/systemMenu/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('5', 'B', 'userShop', 'userShop', '/userShop/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('6', 'B', 'version', 'version', '/versionInfo/getVersionInfo', '1', 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('7', 'B', 'region', 'region', '/region/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('8', 'B', 'shop', 'shop', '/shop/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('9', 'B', 'organization', 'organization', '/organization/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('10', 'B', 'brand', 'brand', '/brand/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('11', 'B', 'getUserInfo', 'getUserInfo', '/user/getUserInfo', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('12', 'B', 'model', 'model', '/model/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('13', 'B', 'duty', 'duty', '/duty/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('14', 'B', 'roleMenu', 'roleMenu', '/roleMenu/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('15', 'B', 'systemRole', 'systemRole', '/systemRole/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('16', 'B', 'roleResource', 'roleResource', '/roleResource/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('17', 'B', 'systemResource', 'systemResource', '/systemResource/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('18', 'B', 'user', 'user', '/user/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('19', 'B', 'task', 'task', '/task/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('20', 'B', 'modelPrice', 'modelPrice', '/modelPrice/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('21', 'B', 'regionType', 'regionType', '/regionType/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('22', 'B', 'orgBiz', 'orgBiz', '/orgBiz/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('23', 'B', 'userRole', 'userRole', '/userRole/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('24', 'B', 'upload', 'upload', '/fastdfs/upload', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('25', 'B', 'taskDetail', 'taskDetail', '/taskDetail/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('26', 'B', 'errorMessage', 'errorMessage', '/errorMessage/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('27', 'B', 'saveSaleTask', 'saveSaleTask', '/**/saveSaleTask/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('28', 'B', 'company', 'company', '/company/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('29', 'B', 'stock', 'stock', '/stock/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('30', 'B', 'sale', 'sale', '/sale/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('31', 'B', 'tac', 'tac', '/tac/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('32', 'B', 'scanValidate', 'scanValidate', '/scanValidate/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('33', 'B', 'shop', 'shop', '/shop/shops', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('34', 'B', 'brand', 'brand', '/brand/brandList', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('35', 'B', 'saleGoal', 'saleGoal', '/saleGoal/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('36', 'B', 'shopGrade', 'shopGrade', '/shopGrade/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('37', 'B', 'saleItem', 'saleItem', '/saleItem/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('38', 'B', 'shopBiz', 'shopBiz', '/shopBiz/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('39', 'B', 'currency', 'currency', '/currency/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('40', 'B', 'materiel', 'materiel', '/materiel/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('41', 'B', 'fileTemplate', '文件模板', '/fileTemplate/*', '100', 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('42', 'B', 'attribute', 'attribute', '/attribute/*', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('43', 'B', 'exportTemplate', 'exportTemplate', '/fileTemplate/exportTemplate/*', '100', 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('44', 'B', 'visitModelSetting', 'visitModelSetting', '/visitModelSetting/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('45', 'B', null, null, '/**/exportExcel/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('46', 'B', 'visitScoreSetting', 'visitScoreSetting', '/visitScoreSetting/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('47', 'B', 'visitStock', 'visitStock', '/visitStock/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('48', 'B', 'shopMateriel', 'shopMateriel', '/shopMateriel/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('49', 'B', 'visitFeedback', 'visitFeedback', '/visitFeedback/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('50', 'B', 'visit', 'visit', '/visit/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('51', 'B', 'visitPlan', 'visitPlan', '/visitPlan/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('52', 'B', 'visitScore', 'visitScore', '/visitScore/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('53', 'B', 'prototype', 'prototype', '/prototype/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('54', 'B', 'visitModel', 'visitModel', '/visitModel/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('55', 'B', 'visitScoreItem', 'visitScoreItem', '/visitScoreItem/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('56', 'B', 'prototypeSetting', 'prototypeSetting', '/prototypeSetting/**', '1', 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('57', 'B', 'visitSale', 'visitSale', '/visitSale/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('58', 'B', 'visitCompetitor', 'visitCompetitor', '/visitCompetitor/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('59', 'B', 'exportShopSaleExcel', 'exportShopSaleExcel', '/visit/exportShopSaleExcel/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('60', 'B', 'prototypeCounting', 'prototypeCounting', '/prototypeCounting/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('61', 'B', '', null, '/visit/exportShopHistoryExcel/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('62', 'B', 'reportSaleDaily', 'reportSaleDaily', '/reportSaleDaily/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('63', 'B', 'goalSupervisor', 'goalSupervisor', '/goalSupervisor/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('64', 'B', 'goalModel', 'goalModel', '/goalModel/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('65', 'B', 'reportSaleWeek', 'reportSaleWeek', '/reportSaleWeek/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('66', 'B', 'shopDamage', 'shopDamage', '/shopDamage/**', null, 'Y', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('67', 'B', 'goalPromoter', 'goalPromoter', '/goalPromoter/**', null, 'N', null, null, null, null, null, null);
INSERT INTO `T_SYSTEM_RESOURCE` VALUES ('68', 'B', 'area', 'area', '/area/**', null, 'N', null, null, null, null, null, null);
