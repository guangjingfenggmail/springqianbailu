/*
 Navicat MySQL Data Transfer

 Source Server         : qianbailu
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : lao62

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 16/01/2019 11:26:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gallery
-- ----------------------------
DROP TABLE IF EXISTS `gallery`;
CREATE TABLE `gallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '摘要',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `updateTime` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '时间',
  `submenuId` int(11) DEFAULT NULL COMMENT '子菜单id',
  `pageNo` int(11) DEFAULT NULL COMMENT 'web页面页码',
  `createDate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1696 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for gallery_image
-- ----------------------------
DROP TABLE IF EXISTS `gallery_image`;
CREATE TABLE `gallery_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gallery_id` int(11) NOT NULL,
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`gallery_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'menu标题',
  `type` int(255) NOT NULL COMMENT '类型0:图片1:小说2视频3电影',
  `href` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'menu地址',
  `updateTime` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '邮箱',
  `updateTime` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for novel
-- ----------------------------
DROP TABLE IF EXISTS `novel`;
CREATE TABLE `novel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '摘要',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `updateTime` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '时间',
  `submenuId` int(11) DEFAULT NULL COMMENT '子菜单id',
  `pageNo` int(11) DEFAULT NULL COMMENT 'web页面页码',
  `createDate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1301 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for novel_article
-- ----------------------------
DROP TABLE IF EXISTS `novel_article`;
CREATE TABLE `novel_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `novel_id` int(11) NOT NULL,
  `content` longtext COLLATE utf8_bin COMMENT '分页内容',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '小说地址',
  `page` int(11) DEFAULT NULL COMMENT '当前第几页',
  PRIMARY KEY (`id`,`novel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for novel_page
-- ----------------------------
DROP TABLE IF EXISTS `novel_page`;
CREATE TABLE `novel_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `novel_id` int(11) NOT NULL,
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `page` int(11) DEFAULT NULL COMMENT '页顺序',
  PRIMARY KEY (`id`,`novel_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for rabbit_mq
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_mq`;
CREATE TABLE `rabbit_mq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `routingKey` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `message` varchar(2550) COLLATE utf8_bin DEFAULT NULL COMMENT 'json格式',
  `status` int(11) DEFAULT NULL COMMENT '-2:重新发送-1:未知；0:生成；1:发送；2:confirm;3:消费；4重复消费失败',
  `createTime` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for rabbit_mq_queue
-- ----------------------------
DROP TABLE IF EXISTS `rabbit_mq_queue`;
CREATE TABLE `rabbit_mq_queue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rabbit_mq_id` int(11) NOT NULL,
  `uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `routingKey` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '-2:重新发送-1:未知；0:生成；1:发送；2:confirm;3:消费；4重复消费失败',
  `ack` int(11) DEFAULT NULL COMMENT '1:成功0:失败',
  `cause` varchar(2550) COLLATE utf8_bin DEFAULT NULL COMMENT '失败异常',
  PRIMARY KEY (`id`,`rabbit_mq_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '子menu标题',
  `menuId` int(11) NOT NULL COMMENT '父menu主键',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `updateTime` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '更新时间',
  `menuName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '父菜单名称',
  PRIMARY KEY (`id`,`menuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pageNo` int(11) DEFAULT NULL,
  `createDate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `submenuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for video_source
-- ----------------------------
DROP TABLE IF EXISTS `video_source`;
CREATE TABLE `video_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`video_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
