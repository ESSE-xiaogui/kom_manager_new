/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:53:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_SYSTEM_MENU
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_MENU`;
CREATE TABLE `T_SYSTEM_MENU` (
  `MENU_ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `MENU_CODE` varchar(32) DEFAULT NULL,
  `MENU_NAME` varchar(20) DEFAULT NULL,
  `MENU_ORDER` bigint(8) DEFAULT NULL,
  `PARENT_MENU_ID` bigint(16) DEFAULT NULL,
  `MENU_ICON` varchar(50) DEFAULT NULL,
  `PAGE_URL` varchar(50) DEFAULT NULL,
  `USABLE` tinyint(1) DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(2000) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_SYSTEM_MENU
-- ----------------------------
INSERT INTO `T_SYSTEM_MENU` VALUES ('1', '1001', '系统管理', '1', '0', 'icon-settings', '/systemManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('2', 'menuManager', '菜单管理', '1', '1', 'system-menu', '/SystemMenuManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('3', 'resource-manager', '资源管理', '2', '1', 'resourceManager', '/SystemResourceManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('4', 'baseManager', '基础数据管理', '2', '0', 'baseManager', '/baseManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('5', 'BrandManager', '品牌管理', '8', '4', 'BrandManager', '/BrandManager', null, '', null, null, 'admin', '2017-03-15 17:36:13', '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('6', 'ModelManager', '机型管理', '9', '4', 'ModelManager', '/ModelManager', null, '', null, null, 'admin', '2017-03-15 17:36:29', '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('7', 'RegionManager', '国家城市', '4', '4', 'RegionManager', '/RegionManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('8', 'bizManager', '销量管理', '4', '0', 'bizManager', '/bizManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('9', 'CompanyManager', '公司管理', '1', '4', 'CompanyManager', '/CompanyManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('10', 'DutyManager', '职位管理', '3', '4', 'DutyManager', '/DutyManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('11', 'OrganizationManager', '机构管理', '2', '4', 'OrganizationManager', '/OrganizationManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('12', 'home', '主页', '0', '0', 'icon-home', '/home-content', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('13', 'ShopBizManager', '门店类型', '10', '4', '/icon-wallet', '/ShopBizManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('14', 'ShopGradeManager', '门店等级', '11', '4', '/icon-wallet', '/ShopGradeManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('15', 'CurrencyManager', '汇率管理', '13', '4', 'CurrencyManager', '/CurrencyManager', '1', null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('16', '73', '门店管理', '9', '0', '/icon-wallet', '/shop_manager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('17', '76', '物料定义', '12', '4', '/icon-wallet', '/MaterielManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('18', 'FileTemplateManager', '模板管理', '3', '1', 'FileTemplate', '/FileTemplateManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('19', '78', '物料统计', '3', '16', '/icon-wallet', '/ShopMaterielManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('20', '87', '巡店管理', '7', '0', '/icon-wallet', '/visit_shop', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('21', 'usermanage', '帐号权限管理', '3', '0', 'usermanage', '/usermanage', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('22', 'SystemRoleManager', '角色管理', '1', '21', 'SystemRoleManager', '/SystemRoleManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('23', 'UserManager', '用户管理', '2', '21', 'UserManager', '/UserManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('24', 'ShopRightManager', '门店授权', '3', '21', '/icon-puzzle', '/ShopRightManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('25', 'EmployeeManager', '员工管理', '4', '21', '/EmployeeManager', '/EmployeeManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('26', 'TaskManager', '导入管理', '14', '4', 'TaskManager', '/TaskManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('27', 'stockmanger', '库存管理', '5', '0', '/stockmanger', '/stockmanger', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('28', 'StockManager', '库存查询', '1', '27', '/StockManager', '/StockManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('29', 'SaleManager', '销量查询', '1', '8', '/SaleManager', '/SaleManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('30', 'ShopManager', '门店审核', '1', '16', '/ShopManager', '/ShopManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('31', '99', '巡店计划管理', '3', '20', '/VisitPlanManager', '/VisitPlanManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('32', '100', '重点机型设置', '1', '20', '/VisitModelSettingManager', '/VisitModelSettingManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('33', '101', '问题反馈查询', '7', '20', '/VisitFeedbackManager', '/VisitFeedbackManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('34', '102', '打分项设置', '2', '20', '/VisitScoreSettingManager', '/VisitScoreSettingManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('35', '103', '重点机型库存查询', '5', '20', '/VisitStockManager', '/VisitStockManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('36', '104', '巡店打分查询', '4', '20', '/VisitScoreManager', '/VisitScoreManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('37', '105', '巡店历史查询', '6', '20', '/VisitManager', '/VisitManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('38', 'ShopManagerItel', '门店审核Itel', '2', '16', '/ShopManagerItel', '/ShopManagerItel', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('39', '110', 'itel竞品销量查询', '12', '20', '/VisitCompetitorManager', '/VisitCompetitorManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('40', '111', 'itel上柜机型查询', '9', '20', '/VisitModelManager', '/VisitModelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('41', '112', 'itel重点机型销量查询', '11', '20', '/VisitSaleManager', '/VisitSaleManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('42', '114', 'itel门店总销量查询', '10', '20', '/VisitTotalSalesManagerItel', '/VisitTotalSalesManagerItel', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('43', 'PrototypeSettingTime', '样机管理', '10', '0', '/icon', '/PrototypeSettingTime', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('44', '116', '盘点日期设置', '2', '43', '/PrototypeSettingTimeManager', '/PrototypeSettingTimeManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('45', '117', '样机查询', '1', '43', '/PrototypeManager', '/PrototypeManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('46', '118', '盘点计划与跟踪', '3', '43', '/PrototypeCountingManager', '/PrototypeCountingManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('47', '119', 'itel巡店历史查询', '13', '20', '/VisitManagerItel', '/VisitManagerItel', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('48', '121', 'itel重点机型设置', '8', '20', '/VisitModelSettingManagerItel', '/VisitModelSettingManagerItel', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('49', '122', '业绩管理', '6', '0', '/performance', '/performance', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('50', '123', '促销员销量目标', '1', '49', '/GoalPromoterManager', '/GoalPromoterManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('51', '124', '巡店员销量目标', '2', '49', '/GoalSupervisorManager', '/GoalSupervisorManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('52', '125', '重点机型销量目标', '3', '49', '/GoalModelManager', '/GoalModelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('53', '126', '报表统计', '11', '0', '/ReportStatistics', '/ReportStatistics', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('54', '127', '销量库存日报', '1', '53', '/ReportSaleDailyManager', '/ReportSaleDailyManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('55', '128', '销量库存周报', '2', '53', '/ReportSaleWeekManager', '/ReportSaleWeekManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('56', 'TopShopManager', 'Top门店查询', '6', '53', '/icon', '/TopShopManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('57', '131', '城市周销量统计', '3', '53', '/CitySalesWeekManager', '/CitySalesWeekManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('58', '132', '门店周销量排名', '4', '53', '/ShopSalesWeekManager', '/ShopSalesWeekManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('59', 'TopModelManager', 'Top机型查询', '8', '53', '/icon', '/TopModelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('60', '134', '重点机型销量统计', '5', '53', '/KeyModelSalesManager', '/KeyModelSalesManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('61', '135', '报修报损管理', '8', '0', '/Damage', '/Damage', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('62', '136', '报修报损查询', '1', '61', '/ShopDamageManager', '/ShopDamageManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('63', 'ShopSaleSRItelManager', 'itel门店总销量走势-按SR', '13', '53', '/icon', '/ShopSaleSRItelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('64', 'ShopSaleCityItelManager', 'itel门店总销量走势-按城市', '12', '53', '/icon', '/ShopSaleCityItelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('65', '139', 'TOP促销员查询', '7', '53', '/TopPromoterManager', '/TopPromoterManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('66', '140', 'itel城市上柜率监控', '9', '53', '/CityModelMonitoringItelManager', '/CityModelMonitoringItelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('67', '141', 'itel销售代表门店覆盖率监控', '10', '53', '/SalesRepresentativeRateItelManager', '/SalesRepresentativeRateItelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('68', '142', 'itel重点机型销量走势', '11', '53', '/KeyModelSaleTrendItelManager', '/KeyModelSaleTrendItelManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('69', '143', '销售区域管理', '6', '4', '/AreaManager', '/AreaManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('70', '144', '国内销售区域管理', '5', '4', '/AreaRegionManager', '/AreaRegionManager', null, null, null, null, null, null, '0');
INSERT INTO `T_SYSTEM_MENU` VALUES ('71', 'AreaShopManager', '门店销售区域关联', '7', '4', '/icon', '/AreaShopManager', null, null, null, null, null, null, '0');
