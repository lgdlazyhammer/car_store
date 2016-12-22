/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : car_fix_store

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2016-12-22 17:19:19
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

-- ----------------------------
-- Table structure for `service_car_price`
-- ----------------------------
DROP TABLE IF EXISTS `service_car_price`;
CREATE TABLE `service_car_price` (
  `id` varchar(255) NOT NULL default '',
  `serivce_id` varchar(255) NOT NULL COMMENT 'service id',
  `car_type_id` varchar(255) NOT NULL COMMENT 'car type id',
  `price` decimal(10,0) NOT NULL COMMENT 'price',
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`),
  KEY `service_car_price_car_type` (`car_type_id`),
  KEY `serivce_car_price_service_id` (`serivce_id`),
  CONSTRAINT `serivce_car_price_service_id` FOREIGN KEY (`serivce_id`) REFERENCES `service` (`id`),
  CONSTRAINT `service_car_price_car_type` FOREIGN KEY (`car_type_id`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_car_price
-- ----------------------------

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
  KEY `user_role_id` (`role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_car`
-- ----------------------------
DROP TABLE IF EXISTS `user_car`;
CREATE TABLE `user_car` (
  `id` varchar(255) NOT NULL default '' COMMENT 'primary key',
  `car_type` varchar(255) NOT NULL COMMENT 'car type',
  `description` varchar(255) default NULL,
  `del_flag` tinyint(4) NOT NULL default '0' COMMENT 'del flag',
  PRIMARY KEY  (`id`),
  KEY `user_car_car_type` (`car_type`),
  CONSTRAINT `user_car_car_type` FOREIGN KEY (`car_type`) REFERENCES `car_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_car
-- ----------------------------

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
