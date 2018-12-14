/*
 Navicat MySQL Data Transfer

 Source Server         : qianbailu
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : xiaomi

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 14/12/2018 18:02:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for home_appinfo
-- ----------------------------
DROP TABLE IF EXISTS `home_appinfo`;
CREATE TABLE `home_appinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tab_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `tab_api` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `word_selected_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `word_unselected_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bg_img` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bg_img_webp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of home_appinfo
-- ----------------------------
BEGIN;
INSERT INTO `home_appinfo` VALUES (1, '推荐', 'home/appInfo', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (2, '手机', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (3, '智能', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (4, '电视', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (5, '笔记本', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (6, '生活周边', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (7, '家电', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (8, 'Super MI', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (9, '新款游戏本', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (10, '影音娱乐', 'home/tab_page', '#ed5b00', '#747474', '', '');
COMMIT;

-- ----------------------------
-- Table structure for home_tab_header
-- ----------------------------
DROP TABLE IF EXISTS `home_tab_header`;
CREATE TABLE `home_tab_header` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img_url_webp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img_url_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `action` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `view_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '小米手机', 0, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (2, '红米', 1, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (3, '电视', 2, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (4, '笔记本', 3, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (5, '空调', 4, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (6, '新品', 5, 'https://www.mi.com/p/2848.html', '1544495040942');
INSERT INTO `menu` VALUES (7, '路由器', 6, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (8, '智能硬件', 7, 'https://www.mi.com', '1544495040942');
INSERT INTO `menu` VALUES (9, '服务', 8, 'https://www.mi.com/service/', '1544495040942');
INSERT INTO `menu` VALUES (10, '社区', 9, 'http://www.xiaomi.cn/', '1544495040942');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of my_user
-- ----------------------------
BEGIN;
INSERT INTO `my_user` VALUES (1, 'root', '123', '', NULL);
INSERT INTO `my_user` VALUES (2, 'admin', '123', '', NULL);
COMMIT;

-- ----------------------------
-- Table structure for slider
-- ----------------------------
DROP TABLE IF EXISTS `slider`;
CREATE TABLE `slider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `log_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `srcset` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='主页导航';

-- ----------------------------
-- Records of slider
-- ----------------------------
BEGIN;
INSERT INTO `slider` VALUES (1, 'https://www.mi.com/a/h/7932.html?client_id=180100031058&masid=17409.0496', '', '//i1.mifile.cn/a4/xmad_15442655379479_zarsh.jpg', '//i1.mifile.cn/a4/xmad_15442655412525_MGCcN.jpg 2x');
INSERT INTO `slider` VALUES (2, 'https://www.mi.com/mix3/', '', '//i1.mifile.cn/a4/xmad_15427942125674_JlLUW.jpg', '//i1.mifile.cn/a4/xmad_15427942125674_JlLUW.jpg');
INSERT INTO `slider` VALUES (3, 'https://www.mi.com/mitv4c/40/', '', '//i1.mifile.cn/a4/xmad_15441768160624_QFmsJ.jpg', '//i1.mifile.cn/a4/xmad_15441768160624_QFmsJ.jpg');
INSERT INTO `slider` VALUES (4, 'https://www.mi.com/milaptop/', '', '//i1.mifile.cn/a4/xmad_15419444592813_JwZlv.jpg', '//i1.mifile.cn/a4/xmad_15419444592813_JwZlv.jpg');
INSERT INTO `slider` VALUES (5, 'https://www.mi.com/a/h/7898.html', '', '//i1.mifile.cn/a4/xmad_15444987648531_gdZTx.jpg', '//i1.mifile.cn/a4/xmad_15444987648531_gdZTx.jpg');
COMMIT;

-- ----------------------------
-- Table structure for splash
-- ----------------------------
DROP TABLE IF EXISTS `splash`;
CREATE TABLE `splash` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '开始时间',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址启动',
  `full_display_img_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '全屏图片',
  `end` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '结束时间',
  `skip_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '目标地址',
  `duration` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '停留时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='启动图片';

-- ----------------------------
-- Records of splash
-- ----------------------------
BEGIN;
INSERT INTO `splash` VALUES (2, '1544609036', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/7a108f8a26b1f1b32764e937a5c64168.jpg', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/58105cec3ce15bd5646f209669aef85d.jpg', '1544609046', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/459dc18c790e5288d8efc27d603ff5a3.png', '5');
INSERT INTO `splash` VALUES (3, '1544696956', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/7a108f8a26b1f1b32764e937a5c64168.jpg', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/58105cec3ce15bd5646f209669aef85d.jpg', '1544696966', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/459dc18c790e5288d8efc27d603ff5a3.png', '5');
COMMIT;

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
  `src` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址',
  `price` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`,`menuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of submenu
-- ----------------------------
BEGIN;
INSERT INTO `submenu` VALUES (1, '小米MIX 3', 0, 'https://www.mi.com', '1544510940757', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/mix3-320.png', '3299元起');
INSERT INTO `submenu` VALUES (2, '小米MIX 3', 0, 'https://www.mi.com/mix3/', '1544510940757', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/mix3-320.png', '3299元起');
INSERT INTO `submenu` VALUES (3, '小米8 青春版', 0, 'https://www.mi.com/mi8youth/', '1544510940757', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (4, '小米8 屏幕指纹版', 0, 'https://www.mi.com/mi8ud/', '1544510940757', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pingmu-320.png', '3199元起');
INSERT INTO `submenu` VALUES (5, '小米8', 0, 'https://www.mi.com/mi8/', '1544510940757', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pc-320-220-mi8.png', '2699元起');
INSERT INTO `submenu` VALUES (6, '红米6 Pro', 1, 'https://www.mi.com', '1544510940757', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/6pro320-220.png', '999元起');
INSERT INTO `submenu` VALUES (7, '红米6 Pro', 1, 'https://www.mi.com/redmi6pro/', '1544510940757', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/6pro320-220.png', '999元起');
INSERT INTO `submenu` VALUES (8, '红米6', 1, 'https://www.mi.com/redmi6/', '1544510940757', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/666320.png', '799元');
INSERT INTO `submenu` VALUES (9, '小米电视4S 75英寸', 2, 'https://www.mi.com', '1544510940757', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4s75.png', '7999元');
INSERT INTO `submenu` VALUES (10, '小米电视4S 75英寸', 2, 'https://www.mi.com/mitv4s/75/', '1544510940757', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4s75.png', '7999元');
INSERT INTO `submenu` VALUES (11, '小米电视4A 32英寸', 2, 'https://www.mi.com/mitv4A/32/', '1544510940757', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/32.png', '899元');
INSERT INTO `submenu` VALUES (12, '小米电视4A 43英寸青春版', 2, 'https://www.mi.com/mitv4A/43y', '1544510940757', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4a43.png', '1499元');
INSERT INTO `submenu` VALUES (13, '小米电视4A 50英寸', 2, 'https://www.mi.com/mitv4A/50/', '1544510940757', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/50.png', '1999元');
INSERT INTO `submenu` VALUES (14, '小米笔记本 Air 12.5', 3, 'https://www.mi.com', '1544510940757', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/video/bijiben32012.5.jpg', '3599起');
INSERT INTO `submenu` VALUES (15, '小米笔记本 Air 12.5', 3, 'https://www.mi.com/mibookair-12/', '1544510940757', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/video/bijiben32012.5.jpg', '3599起');
INSERT INTO `submenu` VALUES (16, '小米笔记本 Air 13.3', 3, 'https://www.mi.com/mibookair-13/', '1544510940757', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/daohang13.3.jpg', '4999元起');
INSERT INTO `submenu` VALUES (17, '小米笔记本 15.6', 3, 'https://www.mi.com/milaptop/', '1544510940757', '笔记本', 'https://i1.mifile.cn/f/i/g/320x220biiben.png', '4199元起');
INSERT INTO `submenu` VALUES (18, '小米笔记本 Pro 15.6', 3, 'https://www.mi.com/mibookpro/', '1544510940757', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/cn-index/WechatIMG603.png', '5599元起');
INSERT INTO `submenu` VALUES (19, '小米8 青春版', 5, 'https://www.mi.com/p/2848.html', '1544510940757', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (20, '小米8 青春版', 5, 'https://www.mi.com/mi8youth/', '1544510940757', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (21, '小米8 屏幕指纹版', 5, 'https://www.mi.com/mi8ud/', '1544510940757', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pingmu-320.png', '3199元起');
INSERT INTO `submenu` VALUES (22, '小米手环3 NFC版', 5, 'https://item.mi.com/product/8810.html', '1544510940757', '新品', 'https://i1.mifile.cn/f/i/g/2015/gif/shouhuanNFC.jpg', '199元');
INSERT INTO `submenu` VALUES (23, '小米米家小白智能摄像机增强版', 5, 'https://item.mi.com/1183800003.html', '1544510940757', '新品', 'https://i1.mifile.cn/f/i/g/2015/gif/shexiangjizengqiang.jpg', '399元');
INSERT INTO `submenu` VALUES (24, '小米路由器 4', 6, 'https://www.mi.com', '1544510940757', '路由器', 'https://i1.mifile.cn/f/i/g/2015/xiaomiluyouqi4.png', '179元');
INSERT INTO `submenu` VALUES (25, '小米路由器 4', 6, 'https://item.mi.com/product/8105.html', '1544510940757', '路由器', 'https://i1.mifile.cn/f/i/g/2015/xiaomiluyouqi4.png', '179元');
INSERT INTO `submenu` VALUES (26, '小米路由器 4Q', 6, 'https://item.mi.com/1182400090.html?cfrom=search', '1544510940757', '路由器', 'https://i1.mifile.cn/f/i/g/2015/4Q.png', '89元');
INSERT INTO `submenu` VALUES (27, '小米路由器 3A', 6, 'https://www.mi.com/miwifi3a/?cfrom=search', '1544510940757', '路由器', 'https://i1.mifile.cn/f/i/g/2015/3A.png', '99元');
INSERT INTO `submenu` VALUES (28, '小米路由器 3G', 6, 'https://www.mi.com/miwifi3g/', '1544510940757', '路由器', 'https://i1.mifile.cn/f/i/g/2015/3G.png', '179元');
INSERT INTO `submenu` VALUES (29, '米家空气净化器Pro', 7, 'https://www.mi.com', '1544510940757', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/gif/kongqijinghuaqi.jpg', '1499元');
INSERT INTO `submenu` VALUES (30, '米家空气净化器Pro', 7, 'https://item.mi.com/product/4802.html', '1544510940757', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/gif/kongqijinghuaqi.jpg', '1499元');
INSERT INTO `submenu` VALUES (31, '小米净水器', 7, 'https://www.mi.com/water2/', '1544510940757', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/xiaomijingshuiqi.jpg', '1999元');
INSERT INTO `submenu` VALUES (32, '米家扫地机器人', 7, 'https://www.mi.com/roomrobot/', '1544510940757', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/cn-index/saodijiqiren320-220.jpg', '1699元');
INSERT INTO `submenu` VALUES (33, '小米小爱音箱mini', 7, 'https://item.mi.com/product/7832.html', '1544510940757', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/xiaoaimini.jpg', '169元');
COMMIT;

-- ----------------------------
-- Table structure for tabcfg
-- ----------------------------
DROP TABLE IF EXISTS `tabcfg`;
CREATE TABLE `tabcfg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon_normal` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '正常图片地址',
  `icon_selected` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选中的图片',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `text_color_normal` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `text_color_selected` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tabcfg
-- ----------------------------
BEGIN;
INSERT INTO `tabcfg` VALUES (1, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/bcdd295c18b01d3bb56f062525f0a9f4.png', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e7f594cbbd14cef74c3301daba5824ef.png', '首页', 'home', '#747474', '#ED5B00');
INSERT INTO `tabcfg` VALUES (2, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/0036c91424c5da4c670b3423757b771a.png', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/1910f5331b957805b8030b78957ed68d.png', '分类', 'category', '#747474', '#ED5B00');
INSERT INTO `tabcfg` VALUES (3, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f12e3e07d4a334a59f73569fed277087.png', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/a701bd19eef30cee89de7533184df15a.png', '发现', 'discovery', '#747474', '#ED5B00');
INSERT INTO `tabcfg` VALUES (4, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/0a801110e3a081836b32ba24046415c6.png', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d967a25eb331aaa3c9fa39b6ca13974e.png', '我的', 'mine', '#747474', '#ED5B00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
