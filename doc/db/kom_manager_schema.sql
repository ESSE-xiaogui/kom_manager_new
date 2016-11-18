/*
Navicat MySQL Data Transfer

Source Server         : 10.250.117.2(dev)
Source Server Version : 50712
Source Host           : 10.250.117.2:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-11-18 15:44:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_BRAND
-- ----------------------------
DROP TABLE IF EXISTS `T_BRAND`;
CREATE TABLE `T_BRAND` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_CODE` varchar(10) NOT NULL,
  `BRAND_NAME` varchar(64) NOT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `IS_SELF` decimal(1,0) NOT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Table structure for T_COMPANY
-- ----------------------------
DROP TABLE IF EXISTS `T_COMPANY`;
CREATE TABLE `T_COMPANY` (
  `ID` bigint(20) NOT NULL,
  `COMPANY_CODE` varchar(16) NOT NULL,
  `COMPANY_NAME` varchar(128) CHARACTER SET utf8 NOT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `IS_INACTIVE` decimal(1,0) DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` decimal(8,0) DEFAULT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_BY` decimal(8,0) DEFAULT NULL,
  `UPDATED_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_DUTY
-- ----------------------------
DROP TABLE IF EXISTS `T_DUTY`;
CREATE TABLE `T_DUTY` (
  `ID` bigint(20) NOT NULL,
  `DUTY_CODE` decimal(8,0) NOT NULL,
  `DUTY_NAME` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `IS_INACTIVE` decimal(1,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` decimal(8,0) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` decimal(8,0) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_EMPLOYEE
-- ----------------------------
DROP TABLE IF EXISTS `T_EMPLOYEE`;
CREATE TABLE `T_EMPLOYEE` (
  `ID` bigint(20) NOT NULL,
  `EMP_ID` decimal(8,0) NOT NULL COMMENT 'keep for align with kom pc ',
  `EMP_CODE` varchar(8) NOT NULL,
  `EMP_NAME` varchar(32) CHARACTER SET utf8 NOT NULL,
  `ID_NO` varchar(32) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `ORG_ID` decimal(8,0) NOT NULL,
  `DUTY_ID` decimal(8,0) DEFAULT NULL,
  `UPPER_ID` decimal(8,0) DEFAULT NULL,
  `UPPER_NAME` varchar(20) DEFAULT NULL,
  `GENDER` decimal(8,0) DEFAULT NULL,
  `BIRTHDAY` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NATION` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `MARRIED` tinyint(1) DEFAULT NULL,
  `PHONE_NO` varchar(32) DEFAULT NULL,
  `MOBILE_NO` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `NATIVE_PLACE` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `ZIP_CODE` varchar(8) DEFAULT NULL,
  `IN_SERVICE` decimal(1,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_MATERIEL
-- ----------------------------
DROP TABLE IF EXISTS `T_MATERIEL`;
CREATE TABLE `T_MATERIEL` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `MATERIEL_NAME` varchar(100) NOT NULL COMMENT 'Storefront、Counter、Sticker三项，可多选',
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理店铺的一些物料，为了后期扩展用。';

-- ----------------------------
-- Table structure for T_MODEL
-- ----------------------------
DROP TABLE IF EXISTS `T_MODEL`;
CREATE TABLE `T_MODEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_CODE` varchar(10) NOT NULL,
  `SERIES_CODE` varchar(10) NOT NULL,
  `MODEL_CODE` varchar(32) NOT NULL COMMENT '机型代码',
  `MODEL_NAME` varchar(128) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `ELEMENT_TYPE` decimal(8,0) NOT NULL COMMENT '字典编号：1403 (颜色、软件版本、T卡容量等)',
  `ELEMENT_CODE` varchar(32) NOT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1）定义组成整车可配置物料的特征之间的关系，即定义整车可配置物料的品牌、车系、排量、车型、配置、颜色、选配特征，以及这些';

-- ----------------------------
-- Table structure for T_OPTION
-- ----------------------------
DROP TABLE IF EXISTS `T_OPTION`;
CREATE TABLE `T_OPTION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OPTION_CODE` decimal(8,0) NOT NULL,
  `OPTION_NAME` varchar(128) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `PARENT_ID` decimal(8,0) DEFAULT NULL,
  `OPTION_TYPE` decimal(8,0) DEFAULT NULL COMMENT '字典编号：1101，标明选项的业务类型，如操作、仓库、服务大区、索赔组等',
  `OBJECT_ID` varchar(32) DEFAULT NULL COMMENT '实际的被授权业务对象ID，如仓库、服务大区、索赔组等ID号，有些可能是动态新增的',
  `IS_INACTIVE` decimal(1,0) DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23846 DEFAULT CHARSET=utf8 COMMENT='用户选项指的是对该用户的特殊授权，这些权限不依赖于具体的功能模块，被授予的权限在用户拥有的全部功能模块内是有效的，比如：';

-- ----------------------------
-- Table structure for T_ORGANIZATION
-- ----------------------------
DROP TABLE IF EXISTS `T_ORGANIZATION`;
CREATE TABLE `T_ORGANIZATION` (
  `ID` bigint(20) NOT NULL,
  `ORG_CODE` decimal(8,0) NOT NULL,
  `ORG_NAME` varchar(128) CHARACTER SET utf8 NOT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `TREE_CODE` varchar(50) NOT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) NOT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_REGION
-- ----------------------------
DROP TABLE IF EXISTS `T_REGION`;
CREATE TABLE `T_REGION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `REGION_CODE` decimal(8,0) NOT NULL COMMENT '地域定义表中包括了国家、省份、城市、区县等',
  `REGION_NAME` varchar(64) NOT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `REGION_TYPE` decimal(8,0) NOT NULL COMMENT '字典编号：1020',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` varchar(50) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家、省市、城市、区县定义表，地域由车厂端统一定义并下发，经销商端不可自定义地域，只能选择是否使用某部分地域，此表的地域';

-- ----------------------------
-- Table structure for T_ROLE_MENU
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE_MENU`;
CREATE TABLE `T_ROLE_MENU` (
  `ROLE_MENU_ID` bigint(16) NOT NULL,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `MENU_ID` bigint(16) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ROLE_MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='T_ROLE_MENU';

-- ----------------------------
-- Table structure for T_ROLE_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE_RESOURCE`;
CREATE TABLE `T_ROLE_RESOURCE` (
  `ROLE_RES_ID` bigint(16) NOT NULL,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `RES_ID` bigint(16) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ROLE_RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

-- ----------------------------
-- Table structure for T_SALE
-- ----------------------------
DROP TABLE IF EXISTS `T_SALE`;
CREATE TABLE `T_SALE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BILLNO` char(12) NOT NULL COMMENT '上下端单据编码相同',
  `USER_CODE` varchar(32) DEFAULT NULL,
  `USER_ID` decimal(8,0) DEFAULT NULL,
  `SHOP_ID` decimal(8,0) NOT NULL COMMENT '服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复',
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `TRANTYPE` decimal(8,0) NOT NULL COMMENT '数据字典：2402  传音销售单、竞品销售单',
  `WERKS` varchar(5) NOT NULL COMMENT '参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存',
  `CURRENCY_RATIO` decimal(8,3) DEFAULT NULL,
  `SALE_QTY` decimal(8,2) DEFAULT NULL,
  `SALE_AMOUNT` decimal(12,2) DEFAULT NULL COMMENT '输入金额可自动计算单价',
  `SALE_DATE` datetime DEFAULT NULL,
  `STATUS` decimal(8,0) DEFAULT NULL COMMENT '字典编号：2411  未发送、发送中、发送成功、发送失败',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopSales_EMPID` (`USER_CODE`,`SALE_DATE`) USING BTREE,
  KEY `IDX_TShopSales_BILLNO` (`BILLNO`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务员上报门店每日销量，含竞品销量。\r\n业务员登录系统只能查看自己分管门店。\r\n';

-- ----------------------------
-- Table structure for T_SALE_GOAL
-- ----------------------------
DROP TABLE IF EXISTS `T_SALE_GOAL`;
CREATE TABLE `T_SALE_GOAL` (
  `ID` bigint(20) NOT NULL,
  `GOAL_CODE` varchar(12) DEFAULT NULL,
  `USER_ID` decimal(8,0) DEFAULT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `SHOP_ID` decimal(8,0) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `UPPER_ID` decimal(8,0) DEFAULT NULL,
  `GOAL_MONTH` varchar(8) DEFAULT NULL,
  `SALE_QTY` bigint(20) DEFAULT NULL,
  `GOAL_QTY` bigint(20) DEFAULT NULL,
  `SALE_AMOUNT` bigint(20) DEFAULT NULL,
  `STATUS` decimal(1,0) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SALE_ITEM
-- ----------------------------
DROP TABLE IF EXISTS `T_SALE_ITEM`;
CREATE TABLE `T_SALE_ITEM` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SALE_ID` bigint(20) DEFAULT NULL,
  `BILLNO` char(12) NOT NULL COMMENT '上下端单据编码相同',
  `LINE_ID` decimal(8,0) NOT NULL COMMENT '入库单明细ID号',
  `SHOP_ID` decimal(8,0) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `BRAND_CODE` varchar(10) DEFAULT NULL,
  `MODEL_CODE` varchar(32) DEFAULT NULL COMMENT '机型代码',
  `IMEI_NO` varchar(32) DEFAULT NULL,
  `IMEI_LIST` varchar(64) DEFAULT NULL,
  `SALE_QTY` decimal(8,2) DEFAULT NULL,
  `SALE_PRICE` decimal(12,2) DEFAULT NULL COMMENT '输入单价可自动计算金额',
  `SALE_AMOUNT` decimal(12,2) DEFAULT NULL COMMENT '输入金额可自动计算单价',
  `SELLER_ID` decimal(12,0) DEFAULT NULL,
  `INVOICE_NO` varchar(32) DEFAULT NULL,
  `QR_CODE` varchar(512) DEFAULT NULL,
  `PRODUCT_DATE` date DEFAULT NULL,
  `FACTORY_CODE` char(5) DEFAULT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `GENDER` decimal(1,0) DEFAULT NULL,
  `PHONE_NO` varchar(32) DEFAULT NULL COMMENT '手机或固定电话',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `HOME_ADDRESS` varchar(128) DEFAULT NULL,
  `ZIP_CODE` varchar(8) DEFAULT NULL COMMENT '邮政编码',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopSaleitem_SALEID` (`SALE_ID`,`MODEL_CODE`) USING BTREE,
  KEY `IDX_TShopSaleitem_BILLNO` (`BILLNO`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Table structure for T_SHOP
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP`;
CREATE TABLE `T_SHOP` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` bigint(8) NOT NULL COMMENT 'keep for align with kom pc',
  `SHOP_CODE` decimal(8,0) DEFAULT NULL COMMENT '生成方式：国家简称加六位数的序号。',
  `SHOP_NAME` varchar(256) NOT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `PARENT_ID` bigint(8) DEFAULT NULL,
  `REGION_ID` decimal(8,0) DEFAULT NULL,
  `COUNTRY` decimal(8,0) DEFAULT NULL,
  `CITY` decimal(8,0) DEFAULT NULL COMMENT '根据督导所属国家选择城市列表',
  `SHOP_ICON` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(256) DEFAULT NULL,
  `OWNER_NAME` varchar(200) DEFAULT NULL,
  `OWNER_PHONE` varchar(200) DEFAULT NULL,
  `PROMOTER` varchar(200) DEFAULT NULL,
  `ASSISTANT` varchar(200) DEFAULT NULL,
  `MATERIEL_ID` decimal(8,0) DEFAULT NULL,
  `GRADE_ID` bigint(8) DEFAULT NULL,
  `BIZ_ID` bigint(8) DEFAULT NULL,
  `TOTAL_NUM` decimal(8,0) DEFAULT NULL,
  `CURRENT_NUM` decimal(8,0) DEFAULT NULL,
  `CLERK_NUM` decimal(8,0) DEFAULT NULL,
  `BRANDS_FIRST` varchar(100) DEFAULT NULL,
  `BRANDS_TWO` varchar(100) DEFAULT NULL,
  `BRANDS_THREE` varchar(100) DEFAULT NULL,
  `COUNTER_NUM` decimal(8,0) DEFAULT NULL,
  `DARK_PRO` varchar(100) DEFAULT NULL,
  `PURCHAS_CHANNEL` varchar(500) DEFAULT NULL,
  `IS_KOM` tinyint(1) DEFAULT NULL,
  `RELATIONSHIP` bigint(20) DEFAULT NULL,
  `INCORPORATOR` varchar(32) DEFAULT NULL,
  `INCORPORATOR_TEL` varchar(32) DEFAULT NULL,
  `FWIDTH` decimal(8,2) DEFAULT NULL,
  `FDEPTH` decimal(8,2) DEFAULT NULL,
  `SHOP_AREA` tinyint(8) DEFAULT NULL COMMENT '10、10-20、 >20三选一',
  `SHOW_NUM` bigint(20) DEFAULT NULL,
  `STAFF_NUM` bigint(20) DEFAULT NULL,
  `SALES_NUM` bigint(20) DEFAULT NULL,
  `OPEN_DATE` timestamp NULL DEFAULT NULL COMMENT '信息上传当天的北京时间',
  `STATUS` tinyint(8) NOT NULL DEFAULT '0' COMMENT '审核状态 0:(默认)待审核 1:通过 2:未通过 3:再次申请',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SHOP_BIZ
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_BIZ`;
CREATE TABLE `T_SHOP_BIZ` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `BIZ_NAME` varchar(50) NOT NULL COMMENT '业务类型',
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SHOP_GRADE
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_GRADE`;
CREATE TABLE `T_SHOP_GRADE` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `GRADE_NAME` varchar(50) NOT NULL COMMENT '店铺等级',
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_STOCK
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK`;
CREATE TABLE `T_STOCK` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `BILLNO` char(12) NOT NULL,
  `TRANTYPE` decimal(8,0) NOT NULL,
  `SHOP_ID` decimal(8,0) NOT NULL,
  `STOCK_DATE` date DEFAULT NULL,
  `USER_ID` decimal(8,0) DEFAULT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `WERKS` varchar(5) DEFAULT NULL,
  `CURRENCY_RATIO` decimal(8,3) DEFAULT NULL,
  `STATUS` decimal(8,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopstockMain_EMPID` (`USER_ID`,`STOCK_DATE`) USING BTREE,
  KEY `IDX_TShopstockMain_BILLNO` (`BILLNO`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务员上报门店每日库存，不含竞品，目前仅上报TECNO品牌库存。\r\n业务员登录系统只能查看自己分管门店。\r\n                                     -';

-- ----------------------------
-- Table structure for T_STOCK_ITEM
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_ITEM`;
CREATE TABLE `T_STOCK_ITEM` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STOCK_ID` bigint(20) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `BILLNO` char(12) NOT NULL,
  `LINE_ID` decimal(8,0) NOT NULL,
  `BRAND_CODE` varchar(10) DEFAULT NULL,
  `MODEL_CODE` varchar(32) DEFAULT NULL,
  `QTY` decimal(8,2) DEFAULT NULL,
  `PRICE` decimal(10,2) DEFAULT NULL,
  `AMOUNT` decimal(10,2) DEFAULT NULL,
  `ISHISTORY` decimal(1,0) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopstockDetail_STOCKID` (`STOCK_ID`,`MODEL_CODE`) USING BTREE,
  KEY `IDX_TShopstockDetail_BILLNO` (`BILLNO`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SYSTEM_MENU
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_MENU`;
CREATE TABLE `T_SYSTEM_MENU` (
  `MENU_ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `MENU_CODE` varchar(20) DEFAULT NULL,
  `MENU_NAME` varchar(20) DEFAULT NULL,
  `MENU_ORDER` bigint(8) DEFAULT NULL,
  `PARENT_MENU_ID` bigint(16) DEFAULT NULL,
  `MENU_ICON` varchar(50) DEFAULT NULL,
  `PAGE_URL` varchar(50) DEFAULT NULL,
  `USABLE` bigint(8) DEFAULT NULL COMMENT '是否可用：0表示不可以用，1表示可用',
  `REMARK` varchar(2000) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='T_SYSTEM_MENU';

-- ----------------------------
-- Table structure for T_SYSTEM_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_RESOURCE`;
CREATE TABLE `T_SYSTEM_RESOURCE` (
  `RES_ID` bigint(16) NOT NULL COMMENT '资源ID',
  `RES_CODE` varchar(20) DEFAULT NULL COMMENT '资源CODE',
  `RES_NAME` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `RES_URL` varchar(50) DEFAULT NULL COMMENT '资源的url',
  `SHOW_INDEX` bigint(8) DEFAULT NULL COMMENT '显示顺序',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Table structure for T_SYSTEM_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_ROLE`;
CREATE TABLE `T_SYSTEM_ROLE` (
  `ROLE_ID` bigint(16) NOT NULL COMMENT '角色ID',
  `ROLE_CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `IS_INACTIVE` decimal(1,0) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` decimal(8,0) NOT NULL COMMENT 'keep for align with kom pc',
  `USER_CODE` varchar(32) NOT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `EMP_ID` decimal(8,0) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `DUTY_ID` decimal(8,0) DEFAULT NULL COMMENT '1:销售代表 2:促销员',
  `PASSWORD` varchar(128) NOT NULL COMMENT '加密保存',
  `USER_CATEGORY` decimal(8,0) DEFAULT NULL COMMENT '字典编号：1007',
  `FORBIDDEN_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `PWD_UPDATED` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `LOGIN_TIMES` decimal(8,0) DEFAULT NULL,
  `LAST_LOGIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `IS_ONLINE` decimal(1,0) DEFAULT '0',
  `IS_INACTIVE` decimal(1,0) DEFAULT '0' COMMENT '0表示激活状态，被激活有效的数据可以用于新增业务，1表示停用，被停用无效的数据只能用于历史数据查询中',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  `CREATED_BY` decimal(8,0) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` decimal(8,0) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=348 DEFAULT CHARSET=utf8 COMMENT='系统用户信息表：存放所有的系统用户，用户关联员工和组织，每个用户只能属于一个组织，同一个员工可以创建多个用户，业务数据中';

-- ----------------------------
-- Table structure for T_USER_LOG
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_LOG`;
CREATE TABLE `T_USER_LOG` (
  `LOG_ID` bigint(16) NOT NULL COMMENT '日志ID',
  `USER_ID` bigint(16) DEFAULT NULL COMMENT '客户ID',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '处理人',
  `LOG_NODE` varchar(100) DEFAULT NULL COMMENT '操作环节',
  `LOG_DATE` datetime DEFAULT NULL COMMENT '登录时间',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站长管理日志';

-- ----------------------------
-- Table structure for T_USER_OPTION
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_OPTION`;
CREATE TABLE `T_USER_OPTION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` decimal(8,0) NOT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `OPTION_ID` decimal(8,0) DEFAULT NULL,
  `OPTION_CODE` decimal(8,0) NOT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATE_BY` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=268333 DEFAULT CHARSET=utf8 COMMENT='用户拥护的用户选项授权存放于此表，每次授权操作只需新增或删除，不需要修改';

-- ----------------------------
-- Table structure for T_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_ROLE`;
CREATE TABLE `T_USER_ROLE` (
  `USER_ROLE_ID` bigint(16) NOT NULL,
  `USER_ID` bigint(16) DEFAULT NULL,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `IS_INACTIVE` decimal(1,0) DEFAULT NULL,
  `REQ_DATE` datetime DEFAULT NULL,
  `CHECK_DATE` datetime DEFAULT NULL,
  `CHECK_STAFF` varchar(20) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(64) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='T_USER_ROLE';
