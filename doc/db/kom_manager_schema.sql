/*
Navicat MySQL Data Transfer

Source Server         : 10.151.170.30(kom-mgr-dev)
Source Server Version : 50717
Source Host           : 10.151.170.30:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-10 13:44:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_AREA
-- ----------------------------
DROP TABLE IF EXISTS `T_AREA`;
CREATE TABLE `T_AREA` (
  `AREA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `AREA_NAME` varchar(64) NOT NULL,
  `AREA_TYPE` tinyint(8) DEFAULT NULL,
  `PARENT_ID` bigint(20) NOT NULL,
  `IS_INACTIVE` tinyint(1) DEFAULT '1' COMMENT '1:启用 2：停用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`AREA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_AREA_REGION
-- ----------------------------
DROP TABLE IF EXISTS `T_AREA_REGION`;
CREATE TABLE `T_AREA_REGION` (
  `RECORD_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `AREA_ID` bigint(20) NOT NULL,
  `REGION_ID` bigint(20) NOT NULL,
  `IS_INACTIVE` tinyint(1) DEFAULT '1' COMMENT '1:启用 2：停用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for T_BRAND
-- ----------------------------
DROP TABLE IF EXISTS `T_BRAND`;
CREATE TABLE `T_BRAND` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_CODE` varchar(64) DEFAULT NULL,
  `BRAND_NAME` varchar(64) NOT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `IS_SELF` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：是自有品牌 2：不是自有品牌',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1074 DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Table structure for T_COMPANY
-- ----------------------------
DROP TABLE IF EXISTS `T_COMPANY`;
CREATE TABLE `T_COMPANY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_CODE` varchar(16) NOT NULL,
  `COMPANY_NAME` varchar(128) NOT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

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
-- Table structure for T_CURRENCY
-- ----------------------------
DROP TABLE IF EXISTS `T_CURRENCY`;
CREATE TABLE `T_CURRENCY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `FINDEX` decimal(8,0) DEFAULT NULL,
  `REGION_ID` decimal(8,0) NOT NULL,
  `WERKS` varchar(16) NOT NULL COMMENT '参数的实际值，可能有多种数据类型，但同一按照字符串的方式保存',
  `CURRENCY_NAME` varchar(64) DEFAULT NULL COMMENT '参数的中文名称',
  `EXCHANGERATE` decimal(10,4) DEFAULT NULL,
  `EXCHANGERATE2` decimal(10,4) DEFAULT NULL,
  `BEGINDATE` datetime DEFAULT NULL,
  `ENDDATE` datetime DEFAULT NULL,
  `IS_INACTIVE` decimal(1,0) DEFAULT '1' COMMENT '1：启用 2：禁用',
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '1' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=677 DEFAULT CHARSET=utf8 COMMENT='公司结算货币';

-- ----------------------------
-- Table structure for T_DUTY
-- ----------------------------
DROP TABLE IF EXISTS `T_DUTY`;
CREATE TABLE `T_DUTY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DUTY_CODE` decimal(8,0) DEFAULT NULL,
  `DUTY_NAME` varchar(64) CHARACTER SET utf8 NOT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `IDX_DUTY` (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_EMPLOYEE
-- ----------------------------
DROP TABLE IF EXISTS `T_EMPLOYEE`;
CREATE TABLE `T_EMPLOYEE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMP_ID` decimal(8,0) DEFAULT NULL COMMENT 'keep for align with kom pc ',
  `EMP_CODE` varchar(8) DEFAULT NULL COMMENT '员工编码[可做用户名登录用]',
  `EMP_NAME` varchar(128) NOT NULL,
  `U_ID` bigint(32) DEFAULT NULL,
  `ID_NO` varchar(32) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL,
  `ORG_ID` decimal(8,0) NOT NULL,
  `DUTY_ID` decimal(8,0) DEFAULT NULL,
  `UPPER_ID` bigint(20) DEFAULT NULL,
  `REGION_ID` bigint(20) DEFAULT NULL,
  `UPPER_NAME` varchar(128) DEFAULT NULL,
  `GENDER` decimal(8,0) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `NATION` varchar(32) DEFAULT NULL,
  `MARRIED` tinyint(1) DEFAULT NULL,
  `PHONE_NO` varchar(32) DEFAULT NULL,
  `MOBILE_NO` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `NATIVE_PLACE` varchar(64) DEFAULT NULL,
  `ZIP_CODE` varchar(8) DEFAULT NULL,
  `IS_HISTORY` tinyint(1) NOT NULL DEFAULT '2' COMMENT '1:逻辑删除 2:正常 ',
  `IN_SERVICE` decimal(1,0) DEFAULT NULL COMMENT '是否在职 1:是 2:否',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2748 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_FILE_TEMPLATE
-- ----------------------------
DROP TABLE IF EXISTS `T_FILE_TEMPLATE`;
CREATE TABLE `T_FILE_TEMPLATE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BIZ_TYPE` char(1) NOT NULL COMMENT '业务类型',
  `TEMPLATE_NAME` varchar(200) NOT NULL COMMENT '模板名称',
  `FILE_ID` varchar(200) NOT NULL COMMENT '文件名称（ID)',
  `FILE_SUFFIX` varchar(45) NOT NULL COMMENT '文件后缀',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '修改人',
  `UPDATED_TIME` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_GOAL_MODEL
-- ----------------------------
DROP TABLE IF EXISTS `T_GOAL_MODEL`;
CREATE TABLE `T_GOAL_MODEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '促销员目标销量表,ID自动增长',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '事业部ID',
  `GOAL_MONTH` date NOT NULL COMMENT '目标设定年月 格式:201702',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '店铺id',
  `SHOP_CODE` varchar(50) DEFAULT NULL COMMENT '店铺编码',
  `MODEL_ID` bigint(20) NOT NULL COMMENT '店铺id',
  `MODEL_CODE` varchar(50) DEFAULT NULL COMMENT '店铺编码',
  `SALE_TARGET` bigint(20) DEFAULT NULL,
  `SALE_CURRENT` bigint(20) DEFAULT NULL,
  `SALE_FOURWEEKS` bigint(20) DEFAULT NULL COMMENT '前四周累计销量',
  `ACHIEVED` decimal(8,4) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_GOAL_PROMOTER
-- ----------------------------
DROP TABLE IF EXISTS `T_GOAL_PROMOTER`;
CREATE TABLE `T_GOAL_PROMOTER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '促销员目标销量表,ID自动增长',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '事业部ID',
  `GOAL_MONTH` date NOT NULL COMMENT '目标设定年月 格式:201702',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `USER_CODE` varchar(50) DEFAULT NULL COMMENT '用户编码',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '店铺id',
  `SHOP_CODE` varchar(50) DEFAULT NULL COMMENT '店铺编码',
  `SALE_TARGET` bigint(20) DEFAULT NULL,
  `SALE_CURRENT` bigint(20) DEFAULT NULL,
  `ACHIEVED` decimal(8,4) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_GOAL_SUPERVISOR
-- ----------------------------
DROP TABLE IF EXISTS `T_GOAL_SUPERVISOR`;
CREATE TABLE `T_GOAL_SUPERVISOR` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '促销员目标销量表,ID自动增长',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '事业部ID',
  `GOAL_MONTH` date NOT NULL COMMENT '目标设定年月 格式:201702',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `USER_CODE` varchar(50) DEFAULT NULL COMMENT '用户编码',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '店铺id',
  `SHOP_CODE` varchar(50) DEFAULT NULL COMMENT '店铺编码',
  `SALE_TARGET` bigint(20) DEFAULT NULL,
  `SALE_CURRENT` bigint(20) DEFAULT NULL,
  `ACHIEVED` decimal(8,4) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_IMEI_TAC
-- ----------------------------
DROP TABLE IF EXISTS `T_IMEI_TAC`;
CREATE TABLE `T_IMEI_TAC` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TAC` varchar(16) NOT NULL,
  `BRAND_CODE` varchar(10) DEFAULT NULL,
  `MODEL_MAT_CODE` varchar(32) DEFAULT NULL COMMENT '机型代码',
  PRIMARY KEY (`ID`),
  KEY `IDX_TImeiTac_TAC` (`TAC`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1437 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_CALENDARS`;
CREATE TABLE `T_JOB_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_CRON_TRIGGERS`;
CREATE TABLE `T_JOB_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `T_JOB_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `T_JOB_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_FIRED_TRIGGERS`;
CREATE TABLE `T_JOB_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_T_JOB_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_T_JOB_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_T_JOB_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_T_JOB_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_T_JOB_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_T_JOB_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_JOB_DETAILS`;
CREATE TABLE `T_JOB_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_T_JOB_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_T_JOB_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_LOCKS`;
CREATE TABLE `T_JOB_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `T_JOB_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_RESULT
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_RESULT`;
CREATE TABLE `T_JOB_RESULT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(64) DEFAULT NULL,
  `JOB_GROUP` varchar(64) DEFAULT NULL,
  `JOB_CONTEXT` varchar(512) DEFAULT NULL,
  `FIRE_TIME` varchar(20) DEFAULT NULL,
  `TAKE_TIME` bigint(13) DEFAULT NULL,
  `IS_FAILED` smallint(2) DEFAULT NULL,
  `RESULT` varchar(256) DEFAULT NULL,
  `DETAIL` text,
  `MESSAGE` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35075 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_SCHEDULER_STATE`;
CREATE TABLE `T_JOB_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_SIMPLE_TRIGGERS`;
CREATE TABLE `T_JOB_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `T_JOB_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `T_JOB_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_SIMPROP_TRIGGERS`;
CREATE TABLE `T_JOB_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `T_JOB_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `T_JOB_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_JOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB_TRIGGERS`;
CREATE TABLE `T_JOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_T_JOB_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_T_JOB_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_T_JOB_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_T_JOB_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_T_JOB_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_T_JOB_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_T_JOB_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_T_JOB_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_T_JOB_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_T_JOB_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_T_JOB_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_T_JOB_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `T_JOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `T_JOB_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_MATERIEL
-- ----------------------------
DROP TABLE IF EXISTS `T_MATERIEL`;
CREATE TABLE `T_MATERIEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME_EN` varchar(64) NOT NULL,
  `NAME_CN` varchar(64) DEFAULT NULL,
  `BRAND_CODE` varchar(16) DEFAULT NULL,
  `TYPE` varchar(64) DEFAULT NULL,
  `COMPANY_ID` bigint(20) DEFAULT NULL,
  `IS_INACTIVE` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用：1、启用 2、禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_MODEL
-- ----------------------------
DROP TABLE IF EXISTS `T_MODEL`;
CREATE TABLE `T_MODEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRAND_ID` bigint(20) DEFAULT NULL,
  `BRAND_CODE` varchar(10) NOT NULL,
  `SERIES_CODE` varchar(10) NOT NULL,
  `MODEL_CODE` varchar(32) NOT NULL COMMENT '机型代码',
  `MODEL_NAME` varchar(128) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `SALE_TIME` datetime DEFAULT NULL,
  `PRICE_SCALE` decimal(8,0) DEFAULT NULL,
  `ELEMENT_TYPE` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `ELEMENT_CODE` varchar(32) DEFAULT NULL COMMENT '保留字段',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '0' COMMENT '1激活 2停用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2957 DEFAULT CHARSET=utf8 COMMENT='1）定义组成整车可配置物料的特征之间的关系，即定义整车可配置物料的品牌、车系、排量、车型、配置、颜色、选配特征，以及这些';

-- ----------------------------
-- Table structure for T_MODEL_PRICE
-- ----------------------------
DROP TABLE IF EXISTS `T_MODEL_PRICE`;
CREATE TABLE `T_MODEL_PRICE` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `TABLE_TYPE` varchar(100) NOT NULL,
  `PRICE_SCALE` varchar(100) NOT NULL COMMENT '价格档位',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for T_OPTION
-- ----------------------------
DROP TABLE IF EXISTS `T_OPTION`;
CREATE TABLE `T_OPTION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OPTION_CODE` decimal(8,0) DEFAULT NULL,
  `OPTION_NAME` varchar(128) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `PARENT_ID` decimal(8,0) DEFAULT NULL,
  `OPTION_TYPE` decimal(8,0) DEFAULT NULL COMMENT '字典编号：1101，标明选项的业务类型，如操作、仓库、服务大区、索赔组等',
  `OBJECT_ID` varchar(32) DEFAULT NULL COMMENT '实际的被授权业务对象ID，如仓库、服务大区、索赔组等ID号，有些可能是动态新增的',
  `IS_INACTIVE` decimal(1,0) DEFAULT '1' COMMENT '1：启用 2：禁用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_OPTION_OBJID` (`OBJECT_ID`,`OPTION_CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4910 DEFAULT CHARSET=utf8 COMMENT='用户选项指的是对该用户的特殊授权，这些权限不依赖于具体的功能模块，被授予的权限在用户拥有的全部功能模块内是有效的，比如：';

-- ----------------------------
-- Table structure for T_ORG_BIZ
-- ----------------------------
DROP TABLE IF EXISTS `T_ORG_BIZ`;
CREATE TABLE `T_ORG_BIZ` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `BIZ_ATTRIBUTE` varchar(200) NOT NULL COMMENT '业务属性',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=352 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE`;
CREATE TABLE `T_PROTOTYPE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `SHOP_ID` bigint(20) NOT NULL,
  `BRAND_ID` bigint(20) DEFAULT NULL,
  `BRAND_CODE` varchar(32) NOT NULL,
  `MODEL_ID` bigint(20) DEFAULT NULL,
  `MODEL_CODE` varchar(32) DEFAULT NULL COMMENT '机型代码',
  `IMEI_NO` varchar(32) NOT NULL,
  `IMEI_LIST` varchar(64) DEFAULT NULL,
  `IMG_PROTOTYPE_URL` varchar(256) DEFAULT NULL,
  `IMG_SHOP_URL` varchar(256) DEFAULT NULL,
  `IMG_IMEI_URL` varchar(256) DEFAULT NULL,
  `STATUS` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,publish; 2,unpublish',
  `PUBLISH_BY` varchar(32) DEFAULT NULL,
  `PUBLISH_TIME` datetime DEFAULT NULL,
  `UNPUBLISH_BY` varchar(32) DEFAULT NULL,
  `UNPUBLISH_TIME` datetime DEFAULT NULL,
  `UNPUBLISH_CAUSE` varchar(64) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE_COUNTING
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE_COUNTING`;
CREATE TABLE `T_PROTOTYPE_COUNTING` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `PROTOTYPE_ID` bigint(20) NOT NULL,
  `IMG_PROTOTYPE_URL` varchar(256) DEFAULT NULL,
  `IMG_SHOP_URL` varchar(256) DEFAULT NULL,
  `IMG_IMEI_URL` varchar(256) DEFAULT NULL,
  `STATUS` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,undo; 2,done; 3,delay;4,expired',
  `COUNTING_BY` varchar(32) DEFAULT NULL COMMENT '计划盘点人',
  `COUNTING_TIME` datetime DEFAULT NULL COMMENT '计划盘点日期',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE_SETTING
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE_SETTING`;
CREATE TABLE `T_PROTOTYPE_SETTING` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `EFFECTIVE_MONTH` varchar(20) NOT NULL,
  `IS_INACTIVE` tinyint(1) DEFAULT '1' COMMENT '1:启用 2：停用',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE_SETTING_MODEL
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE_SETTING_MODEL`;
CREATE TABLE `T_PROTOTYPE_SETTING_MODEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SETTING_ID` bigint(20) NOT NULL,
  `MODEL_ID` bigint(20) NOT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE_SETTING_REGION
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE_SETTING_REGION`;
CREATE TABLE `T_PROTOTYPE_SETTING_REGION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SETTING_ID` bigint(20) NOT NULL,
  `REGION_ID` bigint(20) NOT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_PROTOTYPE_SETTING_TIME
-- ----------------------------
DROP TABLE IF EXISTS `T_PROTOTYPE_SETTING_TIME`;
CREATE TABLE `T_PROTOTYPE_SETTING_TIME` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SETTING_ID` bigint(20) NOT NULL,
  `COUNT_DATE` date NOT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8 COMMENT='国家、省市、城市、区县定义表，地域由车厂端统一定义并下发，经销商端不可自定义地域，只能选择是否使用某部分地域，此表的地域';

-- ----------------------------
-- Table structure for T_REGION_TYPE
-- ----------------------------
DROP TABLE IF EXISTS `T_REGION_TYPE`;
CREATE TABLE `T_REGION_TYPE` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `REGION_TYPE` varchar(200) NOT NULL COMMENT '区域类型',
  `TYPE_CODE` varchar(255) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_REPORT_SALE_DAILY
-- ----------------------------
DROP TABLE IF EXISTS `T_REPORT_SALE_DAILY`;
CREATE TABLE `T_REPORT_SALE_DAILY` (
  `REPORT_SALE_DAILY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复',
  `REGION_ID` bigint(20) DEFAULT NULL,
  `COUNTRY_ID` bigint(20) DEFAULT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  `GRADE_ID` bigint(8) DEFAULT NULL,
  `SHOP_CODE` varchar(125) COLLATE utf8_bin DEFAULT NULL COMMENT '生成方式：国家简称加六位数的序号。',
  `USER_CODE` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `BRAND_CODE` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `MODEL_CODE` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '机型代码',
  `SALE_DATE` datetime DEFAULT NULL,
  `WEEK` int(2) DEFAULT NULL,
  `COMPANY_NAME` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `SHOP_NAME` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺名',
  `GRADE_NAME` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺等级',
  `EMP_NAME` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `REGION_NAME` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `COUNTRY_NAME` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '国家名',
  `CITY_NAME` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SALE_QTY` int(11) DEFAULT NULL,
  `STOCK_QTY` int(11) DEFAULT NULL,
  `CREATED_BY` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`REPORT_SALE_DAILY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1048561 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for T_REPORT_SALE_WEEK
-- ----------------------------
DROP TABLE IF EXISTS `T_REPORT_SALE_WEEK`;
CREATE TABLE `T_REPORT_SALE_WEEK` (
  `REPORT_SALE_WEEK_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '指使用系统的公司，即事业部或经销商对应的公司',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '服务站或者经销商的唯一标识，不可修改，所有业务数据根据此ID号检索数据，而不是根据服务站或经销商代码，此ID号在整个主机厂端是唯一存在的，不能重复',
  `REGION_ID` bigint(20) DEFAULT NULL,
  `COUNTRY_ID` bigint(20) DEFAULT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  `GRADE_ID` bigint(8) DEFAULT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `SHOP_CODE` varchar(125) DEFAULT NULL COMMENT '生成方式：国家简称加六位数的序号。',
  `BRAND_CODE` varchar(32) DEFAULT NULL,
  `MODEL_CODE` varchar(32) DEFAULT NULL COMMENT '机型代码',
  `YEAR` int(4) DEFAULT NULL,
  `WEEK` int(2) DEFAULT NULL,
  `COMPANY_NAME` varchar(128) DEFAULT NULL,
  `SHOP_NAME` varchar(256),
  `GRADE_NAME` varchar(50) DEFAULT NULL COMMENT '店铺等级',
  `EMP_NAME` varchar(128) DEFAULT NULL,
  `REGION_NAME` varchar(64) DEFAULT NULL,
  `COUNTRY_NAME` varchar(64),
  `CITY_NAME` varchar(64),
  `SALE_QTY` int(11) DEFAULT NULL,
  `STOCK_QTY` int(11) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`REPORT_SALE_WEEK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=458747 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_ROLE_MENU
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE_MENU`;
CREATE TABLE `T_ROLE_MENU` (
  `ROLE_MENU_ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `MENU_ID` bigint(16) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ROLE_MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3422 DEFAULT CHARSET=utf8 COMMENT='T_ROLE_MENU';

-- ----------------------------
-- Table structure for T_ROLE_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE_RESOURCE`;
CREATE TABLE `T_ROLE_RESOURCE` (
  `ROLE_RES_ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `RES_ID` bigint(16) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ROLE_RES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=925 DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

-- ----------------------------
-- Table structure for T_SALE
-- ----------------------------
DROP TABLE IF EXISTS `T_SALE`;
CREATE TABLE `T_SALE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BILLNO` char(12) NOT NULL COMMENT '上下端单据编码相同',
  `MODEL_CODE` varchar(32) DEFAULT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `USER_ID` decimal(8,0) NOT NULL,
  `SHOP_CODE` decimal(8,0) DEFAULT NULL,
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
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopSales_BILLNO` (`BILLNO`) USING BTREE,
  KEY `index4` (`SHOP_ID`,`USER_ID`,`ID`),
  KEY `index1` (`USER_CODE`),
  KEY `index5` (`SALE_DATE`),
  KEY `index6` (`CREATED_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=529662 DEFAULT CHARSET=utf8 COMMENT='业务员上报门店每日销量，含竞品销量。\r\n业务员登录系统只能查看自己分管门店。\r\n';

-- ----------------------------
-- Table structure for T_SALE_GOAL
-- ----------------------------
DROP TABLE IF EXISTS `T_SALE_GOAL`;
CREATE TABLE `T_SALE_GOAL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  `FACTORY_CODE` varchar(5) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2416672 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1）手机品牌的基础定义\r\n2）共享数据，COMPANY_ID = 0';

-- ----------------------------
-- Table structure for T_SHOP
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP`;
CREATE TABLE `T_SHOP` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` bigint(20) DEFAULT NULL COMMENT 'keep for align with kom pc',
  `SHOP_CODE` varchar(125) CHARACTER SET utf8 DEFAULT NULL COMMENT '生成方式：国家简称加六位数的序号。',
  `SHOP_NAME` varchar(256) CHARACTER SET utf8 NOT NULL,
  `COMPANY_ID` decimal(8,0) DEFAULT NULL,
  `PARENT_ID` bigint(8) DEFAULT NULL,
  `REGION_ID` bigint(8) DEFAULT NULL,
  `COUNTRY` decimal(8,0) DEFAULT NULL COMMENT '保留字段 对应区域表的国家字段',
  `CITY` decimal(8,0) DEFAULT NULL COMMENT '保留字段 对应区域表的城市字段',
  `SHOP_ICON` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ADDRESS` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `OWNER_NAME` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `OWNER_PHONE` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `PROMOTER` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `ASSISTANT` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `MATERIEL_ID` decimal(8,0) DEFAULT NULL,
  `GRADE_ID` bigint(8) DEFAULT NULL,
  `BIZ_ID` bigint(8) DEFAULT NULL,
  `TOTAL_NUM` decimal(8,0) DEFAULT NULL,
  `CURRENT_NUM` decimal(8,0) DEFAULT NULL,
  `CLERK_NUM` decimal(8,0) DEFAULT NULL COMMENT '店员数',
  `BRANDS_FIRST` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `BRANDS_TWO` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `BRANDS_THREE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `COUNTER_NUM` decimal(8,0) DEFAULT NULL,
  `DARK_PRO` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `PURCHAS_CHANNEL` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '供货渠道',
  `IS_KOM` decimal(1,0) DEFAULT NULL,
  `RELATIONSHIP` bigint(20) DEFAULT NULL,
  `BIZ_CATEGORY` bigint(20) DEFAULT NULL,
  `INCORPORATOR` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `INCORPORATOR_TEL` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `FWIDTH` decimal(8,2) DEFAULT NULL,
  `FDEPTH` decimal(8,2) DEFAULT NULL,
  `SHOP_AREA` tinyint(8) DEFAULT NULL COMMENT '10、10-20、 >20三选一',
  `SHOW_NUM` bigint(20) DEFAULT NULL,
  `STAFF_NUM` bigint(20) DEFAULT NULL,
  `SALES_NUM` bigint(20) DEFAULT NULL,
  `OPEN_DATE` timestamp NULL DEFAULT NULL COMMENT '信息上传当天的北京时间',
  `IS_INACTIVE` tinyint(1) DEFAULT '1' COMMENT '1:启用 2：停用',
  `STATUS` tinyint(8) DEFAULT '2' COMMENT '审核状态：1：已生效 2：新申请',
  `REMARK` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `CREATE_BY` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Table User ID',
  `CREATE_DATE` timestamp NULL DEFAULT NULL,
  `UPDATE_BY` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `INDEX_SHOP_SHOPID` (`SHOP_ID`,`ID`) USING BTREE,
  KEY `index3` (`REGION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4490 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SHOP_DAMAGE
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_DAMAGE`;
CREATE TABLE `T_SHOP_DAMAGE` (
  `DAMAGE_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `MATERIEL_ID` bigint(20) NOT NULL,
  `DAMAGE_TIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(512) DEFAULT NULL,
  `IMG_FIRST_URL` varchar(256) DEFAULT NULL COMMENT '损坏照片',
  `IMG_SECOND_URL` varchar(256) DEFAULT NULL,
  `IMG_THIRD_URL` varchar(256) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`DAMAGE_ID`),
  KEY `IDX_SHOPMATERIEL_SHOPID` (`SHOP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SHOP_EXTENSION
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_EXTENSION`;
CREATE TABLE `T_SHOP_EXTENSION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` bigint(20) NOT NULL,
  `SHOP_AREA` bigint(20) DEFAULT NULL,
  `CLERK_TOTAL_QTY` int(8) DEFAULT NULL,
  `CLERK_BRAND_QTY` int(8) DEFAULT NULL,
  `RELATIONSHIP` bigint(20) DEFAULT NULL,
  `BIZ_CATEGORY` bigint(20) DEFAULT NULL,
  `BRAND_ONE` varchar(64) DEFAULT NULL,
  `BRAND_TWO` varchar(64) DEFAULT NULL,
  `BRAND_THREE` varchar(64) DEFAULT NULL,
  `BRAND_FOUR` varchar(64) DEFAULT NULL,
  `BRAND_FIVE` varchar(64) DEFAULT NULL,
  `BRAND_SIX` varchar(64) DEFAULT NULL,
  `CLERK_ONE_QTY` int(8) DEFAULT NULL,
  `CLERK_TWO_QTY` int(8) DEFAULT NULL,
  `CLERK_THREE_QTY` int(8) DEFAULT NULL,
  `CLERK_FOUR_QTY` int(8) DEFAULT NULL,
  `CLERK_FIVE_QTY` int(8) DEFAULT NULL,
  `CLERK_SIX_QTY` int(8) DEFAULT NULL,
  `SUPERVISOR` varchar(128) DEFAULT NULL,
  `PROMOTER` varchar(128) DEFAULT NULL,
  `SALE_TOTAL_QTY` bigint(20) DEFAULT NULL,
  `SALE_SP_QTY` bigint(20) DEFAULT NULL,
  `SALE_BRAND_QTY` bigint(20) DEFAULT NULL,
  `SALE_BRANDSP_QTY` bigint(20) DEFAULT NULL COMMENT '自有品牌销量',
  PRIMARY KEY (`ID`),
  KEY `INDEX_SHOPEXTENSION_SHOPID` (`SHOP_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4488 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SHOP_MATERIEL
-- ----------------------------
DROP TABLE IF EXISTS `T_SHOP_MATERIEL`;
CREATE TABLE `T_SHOP_MATERIEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` bigint(20) NOT NULL,
  `MATERIEL_ID` bigint(20) NOT NULL,
  `MATERIEL_QTY` int(11) NOT NULL DEFAULT '0',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_DATE` timestamp NULL DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_SHOPMATERIEL_SHOPID` (`SHOP_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

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
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopstockMain_EMPID` (`USER_ID`,`STOCK_DATE`) USING BTREE,
  KEY `IDX_TShopstockMain_BILLNO` (`BILLNO`) USING BTREE,
  KEY `index4` (`CREATED_TIME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='业务员上报门店每日库存，不含竞品，目前仅上报TECNO品牌库存。\r\n业务员登录系统只能查看自己分管门店。\r\n                                     -';

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
  `ISHISTORY` decimal(1,0) DEFAULT NULL COMMENT '0：历史记录 1：当前记录',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_TShopstockDetail_STOCKID` (`STOCK_ID`,`MODEL_CODE`) USING BTREE,
  KEY `IDX_TShopstockDetail_BILLNO` (`BILLNO`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 COMMENT='T_SYSTEM_MENU';

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
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Table structure for T_SYSTEM_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_SYSTEM_ROLE`;
CREATE TABLE `T_SYSTEM_ROLE` (
  `ROLE_ID` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `IS_INACTIVE` decimal(1,0) DEFAULT '1' COMMENT '是否停用：1、启用 2、停用。',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for T_TAC
-- ----------------------------
DROP TABLE IF EXISTS `T_TAC`;
CREATE TABLE `T_TAC` (
  `ID` bigint(32) NOT NULL AUTO_INCREMENT,
  `TAC` varchar(16) NOT NULL,
  `IMEI` varchar(16) DEFAULT NULL,
  `BRAND_CODE` varchar(16) DEFAULT NULL,
  `MODEL_CODE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1438 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_TASK
-- ----------------------------
DROP TABLE IF EXISTS `T_TASK`;
CREATE TABLE `T_TASK` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `TASK_TYPE` varchar(100) NOT NULL COMMENT '任务类型',
  `FILE_NAME` varchar(256) NOT NULL COMMENT '上传文件名称',
  `UPLOAD_PATH` varchar(512) NOT NULL,
  `STAGE` tinyint(1) DEFAULT NULL COMMENT '当前文件上传阶段：1 待上传；2 上传中；3 已上传；4 处理中 5 已完成。',
  `STATUS` tinyint(1) DEFAULT NULL,
  `UPLOAD_TIME` datetime NOT NULL COMMENT '上传时间',
  `USER_NAME` varchar(100) NOT NULL COMMENT '记录当前导入用户',
  `REMARK` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=309 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_TASK_DETAIL
-- ----------------------------
DROP TABLE IF EXISTS `T_TASK_DETAIL`;
CREATE TABLE `T_TASK_DETAIL` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `TASK_ID` bigint(8) NOT NULL,
  `MESSAGE` varchar(512) DEFAULT NULL COMMENT '描述，如失败，阐述失败原因',
  `STATUS` tinyint(1) DEFAULT '1' COMMENT '记录上传的状态： 1成功 2失败。',
  `CREATE_TIME` datetime DEFAULT NULL,
  `CONTEXT` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2883 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` decimal(8,0) DEFAULT NULL COMMENT 'keep for align with kom pc',
  `USER_CODE` varchar(32) NOT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL COMMENT '保留字段',
  `EMP_ID` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `COMPANY_ID` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `DUTY_ID` decimal(8,0) DEFAULT NULL COMMENT '保留字段',
  `PASSWORD` varchar(128) NOT NULL COMMENT '加密保存',
  `USER_CATEGORY` decimal(8,0) DEFAULT NULL COMMENT '字典编号：1007',
  `FORBIDDEN_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `PWD_UPDATED` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `LOGIN_TIMES` decimal(8,0) DEFAULT NULL,
  `LAST_LOGIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `IS_ONLINE` decimal(1,0) DEFAULT '0',
  `IS_INACTIVE` decimal(1,0) NOT NULL DEFAULT '1' COMMENT '是否启用：1、启用 2、禁用',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注-512',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据创建用户，用于审计，无业务含义',
  `CREATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '系统保留字段，记录数据最后更新用户，用于审计，无业务含义',
  `UPDATED_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统保留字段，记录数据最后时间，用于审计，无业务含义',
  `VERSION` decimal(8,0) DEFAULT '0' COMMENT '系统保留字段，表示当前数据版本，用于控制业务并发，无其它业务含义',
  PRIMARY KEY (`ID`),
  KEY `IDX_USER_EMP_ID` (`EMP_ID`) USING BTREE,
  KEY `IDX_USER_USERID` (`USER_ID`,`ID`) USING BTREE,
  KEY `index4` (`USER_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=33345 DEFAULT CHARSET=utf8 COMMENT='系统用户信息表：存放所有的系统用户，用户关联员工和组织，每个用户只能属于一个组织，同一个员工可以创建多个用户，业务数据中';

-- ----------------------------
-- Table structure for T_USER_LOG
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_LOG`;
CREATE TABLE `T_USER_LOG` (
  `LOG_ID` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
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
  `OPTION_CODE` decimal(8,0) DEFAULT NULL,
  `COMPANY_ID` decimal(8,0) NOT NULL COMMENT 'æŒ‡ä½¿ç”¨ç³»ç»Ÿçš„å…¬å¸ï¼Œå³äº‹ä¸šéƒ¨æˆ–ç»é”€å•†å¯¹åº”çš„å…¬å¸',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT 'ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºç”¨æˆ·ï¼Œç”¨äºŽå®¡è®¡ï¼Œæ— ä¸šåŠ¡å«ä¹‰',
  `CREATED_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'ç³»ç»Ÿä¿ç•™å­—æ®µï¼Œè®°å½•æ•°æ®åˆ›å»ºæ—¶é—´ï¼Œç”¨äºŽç³»ç»Ÿå®¡è®¡ï¼Œæ— å®žé™…ä¸šåŠ¡å«ä¹‰',
  `UPDATE_BY` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_USEROPTION` (`OPTION_ID`,`USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71725 DEFAULT CHARSET=utf8 COMMENT='ç”¨æˆ·æ‹¥æŠ¤çš„ç”¨æˆ·é€‰é¡¹æŽˆæƒå­˜æ”¾äºŽæ­¤è¡¨ï¼Œæ¯æ¬¡æŽˆæƒæ“ä½œåªéœ€æ–°å¢žæˆ–åˆ é™¤ï¼Œä¸éœ€è¦ä¿®æ”¹';

-- ----------------------------
-- Table structure for T_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_ROLE`;
CREATE TABLE `T_USER_ROLE` (
  `USER_ROLE_ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(16) DEFAULT NULL,
  `ROLE_ID` bigint(16) DEFAULT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `IS_INACTIVE` decimal(1,0) DEFAULT '1' COMMENT '1：启用 2：禁用',
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
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COMMENT='T_USER_ROLE';

-- ----------------------------
-- Table structure for T_USER_SHOP
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_SHOP`;
CREATE TABLE `T_USER_SHOP` (
  `ID` bigint(8) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(8) NOT NULL,
  `SHOP_ID` bigint(8) DEFAULT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=132844 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VERSION
-- ----------------------------
DROP TABLE IF EXISTS `T_VERSION`;
CREATE TABLE `T_VERSION` (
  `ID` bigint(16) NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(16) NOT NULL,
  `VERSION` varchar(32) NOT NULL,
  `URL` varchar(128) NOT NULL,
  `DOWNLOAD_FLAG` tinyint(1) NOT NULL COMMENT '是否强制下载:  1表示非强制 2表示强制下载',
  `DOWNLOAD_HINT` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT`;
CREATE TABLE `T_VISIT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_DATE` date NOT NULL COMMENT '巡店日期',
  `VISTOR` varchar(32) NOT NULL,
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '事业部ID',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '门店id',
  `PLAN_TYPE` tinyint(8) DEFAULT '1' COMMENT '1,plan; 2, not plan',
  `SALE_CURRENT` bigint(20) DEFAULT NULL,
  `SALE_TARGET` bigint(20) DEFAULT NULL,
  `ACHIEVED` decimal(8,4) DEFAULT NULL,
  `SALE_TOTAL_QTY` bigint(20) DEFAULT NULL,
  `SALE_PB_QTY` bigint(20) DEFAULT NULL COMMENT 'private brand sale qty',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_COMPETITOR
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_COMPETITOR`;
CREATE TABLE `T_VISIT_COMPETITOR` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `BRAND_NAME` varchar(64) NOT NULL,
  `SALE_QTY` bigint(20) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_FEEDBACK
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_FEEDBACK`;
CREATE TABLE `T_VISIT_FEEDBACK` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `ISSUE` varchar(512) NOT NULL,
  `ACTION` varchar(512) DEFAULT NULL,
  `IMG_FIRST_URL` varchar(256) DEFAULT NULL,
  `IMG_SECOND_URL` varchar(256) DEFAULT NULL,
  `IMG_THIRD_URL` varchar(256) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_MATERIEL
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_MATERIEL`;
CREATE TABLE `T_VISIT_MATERIEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `MATERIEL_ID` bigint(20) NOT NULL,
  `MATERIEL_QTY` int(11) NOT NULL DEFAULT '0',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_MODEL
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_MODEL`;
CREATE TABLE `T_VISIT_MODEL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `BRAND_ID` bigint(20) NOT NULL,
  `MODEL_ID` bigint(20) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_MODEL_SETTING
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_MODEL_SETTING`;
CREATE TABLE `T_VISIT_MODEL_SETTING` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACTION_DATE` varchar(7) NOT NULL,
  `COMPANY_ID` bigint(20) NOT NULL,
  `BRAND_ID` bigint(20) NOT NULL,
  `MODEL_ID` bigint(20) NOT NULL,
  `REGION_ID` bigint(20) DEFAULT '-1' COMMENT 'itel requirement',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_PLAN
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_PLAN`;
CREATE TABLE `T_VISIT_PLAN` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '事业部ID',
  `SHOP_ID` bigint(20) NOT NULL COMMENT '门店id',
  `PLAN_DATE` date NOT NULL COMMENT '计划巡店时间',
  `PLANNER` varchar(32) NOT NULL,
  `VISIT_ID` bigint(20) DEFAULT NULL,
  `VISIT_DATE` datetime DEFAULT NULL COMMENT '实际巡店时间',
  `STATUS` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,undo; 2,done; 3,expired ',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_SALE
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_SALE`;
CREATE TABLE `T_VISIT_SALE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `BRAND_ID` bigint(20) NOT NULL,
  `MODEL_ID` bigint(20) NOT NULL,
  `SALE_QTY` bigint(20) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_SCORE
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_SCORE`;
CREATE TABLE `T_VISIT_SCORE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `SHOP_SCORE` decimal(20,2) NOT NULL,
  `SALE_SCORE` decimal(20,2) NOT NULL,
  `STAFF_SCORE` decimal(20,2) NOT NULL,
  `TOTAL_SCORE` decimal(20,2) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_SCORE_ITEM
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_SCORE_ITEM`;
CREATE TABLE `T_VISIT_SCORE_ITEM` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `SCORE_SETTING_ID` bigint(20) NOT NULL,
  `SCORE` decimal(20,2) NOT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_SCORE_SETTING
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_SCORE_SETTING`;
CREATE TABLE `T_VISIT_SCORE_SETTING` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) NOT NULL,
  `TYPE` bigint(20) NOT NULL,
  `DESC_EN` varchar(256) NOT NULL,
  `DESC_CN` varchar(256) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_VISIT_STOCK
-- ----------------------------
DROP TABLE IF EXISTS `T_VISIT_STOCK`;
CREATE TABLE `T_VISIT_STOCK` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VISIT_ID` bigint(20) NOT NULL,
  `SHOP_ID` bigint(20) NOT NULL,
  `BRAND_ID` bigint(20) NOT NULL,
  `MODEL_ID` bigint(20) NOT NULL,
  `STOCK_QTY` bigint(20) NOT NULL,
  `SALE_CURRENT` bigint(20) DEFAULT NULL,
  `SALE_TARGET` bigint(20) DEFAULT NULL,
  `SALE_AVG` decimal(20,2) DEFAULT NULL COMMENT 'avg sale per four weeks',
  `STOCK_ITO` decimal(20,2) DEFAULT NULL COMMENT 'Inventory turn over, STOCK_QTY/SALE_AVG',
  `REMARK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for SALE_LIST_VIEW
-- ----------------------------
DROP VIEW IF EXISTS `SALE_LIST_VIEW`;
CREATE ALGORITHM=UNDEFINED DEFINER=`kom`@`%` SQL SECURITY DEFINER VIEW `SALE_LIST_VIEW` AS select `i`.`ID` AS `ID`,`s`.`COMPANY_ID` AS `COMPANY_ID`,`s`.`BILLNO` AS `BILLNO`,`s`.`SALE_DATE` AS `SALE_DATE`,`c`.`ID` AS `COUNTRY`,`c`.`REGION_NAME` AS `COUNTRY_NAME`,`r`.`ID` AS `CITY`,`r`.`REGION_NAME` AS `CITY_NAME`,`p`.`ID` AS `SHOP_ID`,`p`.`SHOP_NAME` AS `SHOP_NAME`,`i`.`BRAND_CODE` AS `BRAND_CODE`,`i`.`MODEL_CODE` AS `MODEL_CODE`,`i`.`IMEI_NO` AS `IMEI_NO`,`i`.`IMEI_LIST` AS `IMEI_LIST`,`i`.`SALE_QTY` AS `SALE_QTY`,`i`.`SALE_PRICE` AS `SALE_PRICE`,`i`.`SALE_AMOUNT` AS `SALE_AMOUNT`,`s`.`CURRENCY_RATIO` AS `EXCHANGERATE`,`u`.`USER_CODE` AS `USER_CODE`,`s`.`CREATED_TIME` AS `CREATED_TIME` from (((((`T_SALE` `s` left join `T_SALE_ITEM` `i` on((`i`.`SALE_ID` = `s`.`ID`))) left join `T_SHOP` `p` on((`p`.`ID` = `s`.`SHOP_ID`))) left join `T_REGION` `r` on((`r`.`ID` = `p`.`REGION_ID`))) left join `T_REGION` `c` on((`c`.`ID` = `r`.`PARENT_ID`))) left join `T_USER` `u` on((`u`.`ID` = `s`.`USER_ID`))) where ((1 = 1) and (`i`.`ID` is not null)) ;

-- ----------------------------
-- View structure for VIEW_ORG
-- ----------------------------
DROP VIEW IF EXISTS `VIEW_ORG`;
CREATE ALGORITHM=UNDEFINED DEFINER=`kom`@`%` SQL SECURITY DEFINER VIEW `VIEW_ORG` AS select `T_ORGANIZATION`.`ID` AS `ID`,`T_ORGANIZATION`.`ORG_ID` AS `ORG_ID` from `T_ORGANIZATION` ;

-- ----------------------------
-- View structure for VIEW_USERSHOP
-- ----------------------------
DROP VIEW IF EXISTS `VIEW_USERSHOP`;
CREATE ALGORITHM=UNDEFINED DEFINER=`kom`@`%` SQL SECURITY DEFINER VIEW `VIEW_USERSHOP` AS select `u`.`ID` AS `uid`,`p`.`ID` AS `pid` from (((`T_SHOP` `p` join `T_OPTION` `o` on((`o`.`OBJECT_ID` = `p`.`SHOP_ID`))) join `T_USER_OPTION` `uo` on((`uo`.`OPTION_ID` = `o`.`OPTION_CODE`))) join `T_USER` `u` on((`u`.`USER_ID` = `uo`.`USER_ID`))) group by `u`.`ID`,`p`.`ID` ;

-- ----------------------------
-- Procedure structure for update_org_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_org_id`;
DELIMITER ;;
CREATE DEFINER=`kom`@`%` PROCEDURE `update_org_id`()
BEGIN
DECLARE finished INTEGER DEFAULT 0;
DECLARE id BIGINT(20) DEFAULT 0;
DECLARE orgid CHAR(12) DEFAULT "";
DECLARE org_cur CURSOR FOR SELECT o.ID, o.ORG_ID FROM T_ORGANIZATION o ORDER BY o.ID;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;

OPEN org_cur;

update_org_id: LOOP
FETCH org_cur INTO id, orgid;
IF finished THEN
LEAVE update_org_id;
END IF;
UPDATE T_EMPLOYEE SET ORG_ID = id WHERE ORG_ID = orgid;
IF (MOD(id, 5000) = 0) THEN
SELECT  "................";
END IF;
END LOOP update_org_id;

CLOSE org_cur;
SELECT  "last id " + id;

END
;;
DELIMITER ;
