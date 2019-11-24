/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : 1707e

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-11-24 15:36:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `trademark` varchar(30) DEFAULT NULL,
  `rent` decimal(10,0) DEFAULT NULL,
  `car_type` varchar(2) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('7', '奥迪A6', '奥迪', '600', 'C1', '448a43c4-3cd6-4bcb-874b-af0424a18cef.png', '2019-11-24 13:16:19');
INSERT INTO `t_car` VALUES ('8', '奥迪A6', '奥迪', '600', 'C1', 'ac54c7c6-81d6-44ec-8df3-03cbfdfa6b95.png', '2019-11-24 13:16:21');
INSERT INTO `t_car` VALUES ('9', '朗逸', '大众', '300', 'C1', '921d28e3-5e66-4308-b7f5-60dbc0a83218.png', '2019-11-24 13:16:40');
INSERT INTO `t_car` VALUES ('10', '传奇', '广汽', '280', 'C1', '449e5f1a-8275-4e03-9639-5619cac906bb.png', '2019-11-24 13:17:04');
INSERT INTO `t_car` VALUES ('11', '传奇', '广汽', '280', 'C1', 'f2c5f000-7a7a-4829-a1a8-8a8f4962dbae.png', '2019-11-24 13:17:06');
INSERT INTO `t_car` VALUES ('12', '传奇', '广汽', '280', 'C1', 'f7453665-eb23-45fa-b0a2-7db508a1a006.png', '2019-11-24 13:21:55');
INSERT INTO `t_car` VALUES ('13', '传奇', '广汽', '280', 'C1', '2e750002-50e5-4f1d-8357-dd7d2e4bf747.png', '2019-11-24 13:21:56');
INSERT INTO `t_car` VALUES ('14', '传奇', '广汽', '280', 'C1', '73ddc86e-1b90-4eba-9f3e-896afe908d69.png', '2019-11-24 13:21:58');
INSERT INTO `t_car` VALUES ('15', '奥迪A6', '奥迪', '600', 'C1', 'f0742f0f-abf0-4322-9795-171a7865c7f7.png', '2019-11-24 14:46:35');

-- ----------------------------
-- Table structure for `t_driver`
-- ----------------------------
DROP TABLE IF EXISTS `t_driver`;
CREATE TABLE `t_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `driver_license` varchar(20) DEFAULT NULL,
  `drive_type` varchar(2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_driver
-- ----------------------------
INSERT INTO `t_driver` VALUES ('1', '张三', '138', '123456', '167890', 'C1', '2019-11-13 00:00:00');
INSERT INTO `t_driver` VALUES ('2', '李四', '139', '123456', '13456789', 'D', '2019-11-05 00:00:00');
INSERT INTO `t_driver` VALUES ('3', '王五', '137', '123456', '12345680', 'D', '2019-11-08 00:00:00');
INSERT INTO `t_driver` VALUES ('4', '赵六', '136', '123456', '12345680', 'C1', '2019-11-08 00:00:00');

-- ----------------------------
-- Table structure for `t_driver_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_driver_type`;
CREATE TABLE `t_driver_type` (
  `code` varchar(2) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `include` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_driver_type
-- ----------------------------
INSERT INTO `t_driver_type` VALUES ('A1', '大型载客汽车', 'A3,B1,B2,C1,C2,C3,C4,M');
INSERT INTO `t_driver_type` VALUES ('A2', '牵引车', 'B1,B2,C1,C2,C3,C4,M');
INSERT INTO `t_driver_type` VALUES ('A3', '城市公交车', 'C1,C2,C3,C4');
INSERT INTO `t_driver_type` VALUES ('B1', '中型客车', 'C1,C2,C3,C4,M');
INSERT INTO `t_driver_type` VALUES ('B2', '大型货车', 'C1,C2,C3,C4,M');
INSERT INTO `t_driver_type` VALUES ('C1', '小型汽车', 'C2,C3,C4');
INSERT INTO `t_driver_type` VALUES ('C2', '小型自动挡汽车', null);
INSERT INTO `t_driver_type` VALUES ('C3', '低速载货汽车', 'C4');
INSERT INTO `t_driver_type` VALUES ('C4', '三轮汽车', null);
INSERT INTO `t_driver_type` VALUES ('D', '普通三轮摩托车', 'E,F');
INSERT INTO `t_driver_type` VALUES ('E', '普通二轮摩托车', 'F');
INSERT INTO `t_driver_type` VALUES ('F', '轻便摩托车', null);
