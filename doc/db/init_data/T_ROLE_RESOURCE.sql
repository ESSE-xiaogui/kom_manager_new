/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : kom_manager

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-17 19:52:14
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

-- ----------------------------
-- Records of T_ROLE_RESOURCE
-- ----------------------------
INSERT INTO `T_ROLE_RESOURCE` VALUES ('1', '2', '1', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('2', '2', '2', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('3', '2', '3', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('4', '2', '4', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('5', '2', '5', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('6', '2', '6', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('7', '2', '7', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('8', '2', '8', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('9', '2', '9', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('10', '2', '10', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('11', '2', '11', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('12', '2', '12', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('13', '2', '13', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('14', '2', '14', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('15', '2', '15', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('16', '2', '16', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('17', '2', '17', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('18', '2', '18', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('19', '2', '19', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('20', '2', '20', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('21', '2', '21', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('22', '2', '22', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('23', '2', '23', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('24', '2', '24', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('25', '2', '25', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('26', '2', '26', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('27', '2', '27', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('28', '2', '28', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('29', '2', '29', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('30', '2', '30', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('31', '2', '31', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('32', '2', '32', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('33', '2', '33', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('34', '2', '34', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('35', '2', '35', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('36', '2', '36', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('37', '2', '37', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('38', '2', '38', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('39', '2', '39', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('40', '2', '40', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('41', '2', '41', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('42', '2', '42', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('43', '2', '43', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('44', '2', '44', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('45', '2', '45', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('46', '2', '46', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('47', '2', '47', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('48', '2', '48', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('49', '2', '49', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('50', '2', '50', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('51', '2', '51', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('52', '2', '52', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('53', '2', '53', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('54', '2', '54', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('55', '2', '55', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('56', '2', '56', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('57', '2', '57', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('58', '2', '58', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('59', '2', '59', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('60', '2', '60', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('61', '2', '61', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('62', '2', '62', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('63', '2', '63', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('64', '2', '64', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('65', '2', '65', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('66', '2', '66', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('67', '2', '67', null, null, null, null, null, null);
INSERT INTO `T_ROLE_RESOURCE` VALUES ('68', '2', '68', null, null, null, null, null, null);
