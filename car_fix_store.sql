/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : car_fix_store

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2017-01-01 16:58:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `car_type`
-- ----------------------------
DROP TABLE IF EXISTS `car_type`;
CREATE TABLE `car_type` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `name` varchar(255) NOT NULL COMMENT 'name',
  `description` varchar(255) default NULL COMMENT 'description',
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_type
-- ----------------------------
INSERT INTO `car_type` VALUES ('111', '小型车', '30万以下', '0');
INSERT INTO `car_type` VALUES ('222', '中型车', '30到100万', '0');
INSERT INTO `car_type` VALUES ('333', '商务车', '100到200万', '0');
INSERT INTO `car_type` VALUES ('444', '超大型车', '工程车', '0');
INSERT INTO `car_type` VALUES ('555', '豪华型车', '100万以上', '0');

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `user_id` varchar(255) NOT NULL COMMENT 'user id',
  `service_id` varchar(255) NOT NULL COMMENT 'service id',
  `car_id` varchar(255) NOT NULL,
  `price` decimal(10,0) NOT NULL default '0' COMMENT 'price',
  `time_start` datetime NOT NULL COMMENT 'start time',
  `time_end` datetime NOT NULL COMMENT 'end time',
  `description` varchar(255) default NULL,
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del_flag',
  PRIMARY KEY  (`id`),
  KEY `schedule_user_id` (`user_id`),
  KEY `shedule_service_id` (`service_id`),
  KEY `schedule_car_id` (`car_id`),
  CONSTRAINT `schedule_car_id` FOREIGN KEY (`car_id`) REFERENCES `user_car` (`id`),
  CONSTRAINT `schedule_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `shedule_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('282a6658-424a-4ce7-974f-7795d22175ae', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '102', 'cb700f99-ff15-46bd-b078-575f21b5de0d', '500', '2016-12-31 01:05:00', '2016-12-31 20:07:00', null, '0');
INSERT INTO `schedule` VALUES ('9f2bee94-73f0-40a9-b3ae-31472d37a5d8', 'dbeb733c-5a7f-4134-8437-b07288fc2932', '100', '75aced0c-6911-4454-878d-36a39ea8cbfc', '200', '1979-09-13 09:30:00', '1979-09-14 09:25:00', null, '0');
INSERT INTO `schedule` VALUES ('ae83a580-6868-467c-9361-1c824aee25bc', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '101', 'd9d88e2e-ab32-40f8-baa6-07a62ef4b28f', '0', '2016-12-26 20:50:10', '2016-12-26 20:50:10', null, '0');
INSERT INTO `schedule` VALUES ('b3ffa59d-6b83-46ac-b223-40a63ba0a012', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '104', 'cb700f99-ff15-46bd-b078-575f21b5de0d', '500', '1979-09-13 05:25:00', '1980-02-22 15:45:00', null, '0');
INSERT INTO `schedule` VALUES ('c745c25a-9625-4574-bca8-ccb741506afb', '18eede07-a2b1-415d-b56d-d30e70de76c1', '102', '53741571-d51a-4dfe-a762-542624d54a41', '200', '2017-01-01 16:39:00', '2017-01-01 17:50:00', null, '0');

-- ----------------------------
-- Table structure for `service`
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `name` varchar(255) NOT NULL COMMENT 'service name',
  `description` varchar(255) default NULL,
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('100', '洗车', 'car service', '0');
INSERT INTO `service` VALUES ('101', '换玻璃', 'car service', '0');
INSERT INTO `service` VALUES ('102', '换轮胎', 'car service', '0');
INSERT INTO `service` VALUES ('103', '换座椅', 'car service', '0');
INSERT INTO `service` VALUES ('104', '换引擎', 'car service', '0');
INSERT INTO `service` VALUES ('105', '改装', 'car service', '0');
INSERT INTO `service` VALUES ('106', '换们', 'car service', '0');
INSERT INTO `service` VALUES ('107', '换雨刷', 'car service', '0');
INSERT INTO `service` VALUES ('108', '修刹车', 'car service', '0');
INSERT INTO `service` VALUES ('109', '喷漆', 'car service', '0');
INSERT INTO `service` VALUES ('110', '换灯', 'car service', '0');
INSERT INTO `service` VALUES ('111', '换导航', 'car service', '0');

-- ----------------------------
-- Table structure for `service_car_price`
-- ----------------------------
DROP TABLE IF EXISTS `service_car_price`;
CREATE TABLE `service_car_price` (
  `id` varchar(255) NOT NULL default '',
  `service_id` varchar(255) NOT NULL COMMENT 'service id',
  `car_type_id` varchar(255) NOT NULL COMMENT 'car type id',
  `price` decimal(10,0) NOT NULL COMMENT 'price',
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`),
  KEY `service_car_price_car_type` (`car_type_id`),
  KEY `service_car_price_service_id` (`service_id`),
  CONSTRAINT `service_car_price_car_type` FOREIGN KEY (`car_type_id`) REFERENCES `car_type` (`id`),
  CONSTRAINT `service_car_price_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_car_price
-- ----------------------------
INSERT INTO `service_car_price` VALUES ('100', '100', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('101', '101', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('102', '102', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('103', '103', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('104', '104', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('105', '105', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('106', '106', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('107', '107', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('108', '108', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('109', '109', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('110', '110', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('111', '111', '111', '200', '0');
INSERT INTO `service_car_price` VALUES ('112', '100', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('113', '101', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('114', '102', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('115', '103', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('116', '104', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('117', '105', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('118', '106', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('119', '107', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('120', '108', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('121', '109', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('122', '110', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('123', '111', '222', '300', '0');
INSERT INTO `service_car_price` VALUES ('124', '100', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('125', '101', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('126', '102', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('127', '103', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('128', '104', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('129', '105', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('130', '106', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('131', '107', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('132', '108', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('133', '109', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('134', '110', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('135', '111', '333', '500', '0');
INSERT INTO `service_car_price` VALUES ('136', '100', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('137', '101', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('138', '102', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('139', '103', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('140', '104', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('141', '105', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('142', '106', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('143', '107', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('144', '108', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('145', '109', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('146', '110', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('147', '111', '444', '1000', '0');
INSERT INTO `service_car_price` VALUES ('148', '100', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('149', '101', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('150', '102', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('151', '103', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('152', '104', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('153', '105', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('154', '106', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('155', '107', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('156', '108', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('157', '109', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('158', '110', '555', '1500', '0');
INSERT INTO `service_car_price` VALUES ('159', '111', '555', '1500', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `name` varchar(255) NOT NULL COMMENT 'name',
  `password` varchar(255) NOT NULL COMMENT 'password',
  `role_id` varchar(255) NOT NULL COMMENT 'role',
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `user_name` USING HASH (`name`),
  KEY `user_role_id` (`role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0c1555e4-6051-4a16-95a7-086899bc828c', '1234567@qq.com', '1234567', '111', '0');
INSERT INTO `user` VALUES ('18eede07-a2b1-415d-b56d-d30e70de76c1', '134@qq.com', '134', '111', '0');
INSERT INTO `user` VALUES ('385a556c-7cb7-46dd-9c2c-aec2783a54b6', '456789@qq.com', '456789', '111', '0');
INSERT INTO `user` VALUES ('595ec0ba-2471-4230-8bc4-8610fba59c05', 'asdfasfd@163.com', 'sdfasdfasdfasdfsa', '111', '0');
INSERT INTO `user` VALUES ('87ec8db3-c56c-4444-8f11-30c22f03e431', '45678@qq.com', '45678', '111', '0');
INSERT INTO `user` VALUES ('9d765bde-5e27-4e8a-8629-4f48f64353be', '654321@qq.com', '654321', '111', '0');
INSERT INTO `user` VALUES ('cd89aef2-09e7-4221-aff7-1c487a913ad3', '246@qq.com', '246', '111', '0');
INSERT INTO `user` VALUES ('d165f721-2073-4439-9d2d-24593b38cae1', '123456@qq.com', '123456', '111', '0');
INSERT INTO `user` VALUES ('dbeb733c-5a7f-4134-8437-b07288fc2932', '98765@qq.com', '98765', '111', '0');
INSERT INTO `user` VALUES ('ec369cb0-3df1-428e-b8d4-13170f4df9f4', '135@qq.com', '135', '111', '0');
INSERT INTO `user` VALUES ('f39218d4-bedd-42a7-a758-ac19a5fd4c9c', 'fasfasdf@163.com', 'fasdfsfasdfwerfsdfasfa', '111', '0');

-- ----------------------------
-- Table structure for `user_car`
-- ----------------------------
DROP TABLE IF EXISTS `user_car`;
CREATE TABLE `user_car` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `user_id` varchar(255) NOT NULL,
  `car_type_id` varchar(255) NOT NULL COMMENT 'car type',
  `description` varchar(255) default NULL,
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`),
  KEY `user_car_car_type_id` (`car_type_id`),
  KEY `user_car_user_id` (`user_id`),
  CONSTRAINT `user_car_car_type_id` FOREIGN KEY (`car_type_id`) REFERENCES `car_type` (`id`),
  CONSTRAINT `user_car_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_car
-- ----------------------------
INSERT INTO `user_car` VALUES ('40c5e248-fce7-4031-9652-535212427346', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '222', null, '0');
INSERT INTO `user_car` VALUES ('53741571-d51a-4dfe-a762-542624d54a41', '18eede07-a2b1-415d-b56d-d30e70de76c1', '111', '134', '0');
INSERT INTO `user_car` VALUES ('6673bfb8-3920-497d-9837-813a81fdbff4', '87ec8db3-c56c-4444-8f11-30c22f03e431', '111', '45678', '0');
INSERT INTO `user_car` VALUES ('75aced0c-6911-4454-878d-36a39ea8cbfc', 'dbeb733c-5a7f-4134-8437-b07288fc2932', '111', '98765 小型车', '0');
INSERT INTO `user_car` VALUES ('cb700f99-ff15-46bd-b078-575f21b5de0d', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '333', null, '0');
INSERT INTO `user_car` VALUES ('cc60158d-5708-431b-b1ca-34f3dfbe3738', '0c1555e4-6051-4a16-95a7-086899bc828c', '111', null, '0');
INSERT INTO `user_car` VALUES ('d9d88e2e-ab32-40f8-baa6-07a62ef4b28f', '385a556c-7cb7-46dd-9c2c-aec2783a54b6', '333', null, '0');
INSERT INTO `user_car` VALUES ('f6431c2b-052b-4a8d-9be1-acec33f3e6b9', 'cd89aef2-09e7-4221-aff7-1c487a913ad3', '555', '246', '0');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `name` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `del_flag` tinyint(4) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('111', '顾客', 'other info', '0');
INSERT INTO `user_role` VALUES ('222', '管理员', 'other info', '0');
INSERT INTO `user_role` VALUES ('333', '超级管理员', 'other info', '0');

-- ----------------------------
-- Table structure for `user_role_service`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_service`;
CREATE TABLE `user_role_service` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `user_role_id` varchar(255) NOT NULL COMMENT 'user role id',
  `service_id` varchar(255) NOT NULL COMMENT 'service id',
  `description` varchar(255) default NULL COMMENT 'description',
  `del_flag` tinyint(4) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `user_role_service_user_role_id` (`user_role_id`),
  KEY `user_role_service_service_id` (`service_id`),
  CONSTRAINT `user_role_service_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `user_role_service_user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_service
-- ----------------------------
INSERT INTO `user_role_service` VALUES ('100', '111', '100', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('101', '111', '101', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('102', '111', '102', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('103', '111', '103', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('104', '111', '104', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('105', '111', '105', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('106', '111', '106', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('107', '111', '107', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('108', '111', '108', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('109', '111', '109', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('110', '111', '110', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('111', '111', '111', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('112', '222', '100', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('113', '222', '101', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('114', '222', '102', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('115', '222', '103', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('116', '222', '104', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('117', '222', '105', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('118', '222', '106', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('119', '222', '107', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('120', '222', '108', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('121', '222', '109', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('122', '222', '110', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('123', '222', '111', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('124', '333', '100', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('125', '333', '101', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('126', '333', '102', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('127', '333', '103', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('128', '333', '104', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('129', '333', '105', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('130', '333', '106', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('131', '333', '107', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('132', '333', '108', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('133', '333', '109', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('134', '333', '110', 'user role service permission', '0');
INSERT INTO `user_role_service` VALUES ('135', '333', '111', 'user role service permission', '0');

-- ----------------------------
-- Procedure structure for `trunc_tables`
-- ----------------------------
DROP PROCEDURE IF EXISTS `trunc_tables`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `trunc_tables`()
BEGIN
	#Routine body goes here...
  TRUNCATE TABLE car_fix_store.schedule;
  TRUNCATE TABLE car_fix_store.user_car;
  TRUNCATE TABLE car_fix_store.user;
  TRUNCATE TABLE car_fix_store.service_car_price;
  TRUNCATE TABLE car_fix_store.user_role_service;
  TRUNCATE TABLE car_fix_store.car_type;
  TRUNCATE TABLE car_fix_store.service;
  TRUNCATE TABLE car_fix_store.user_role;
END
;;
DELIMITER ;
