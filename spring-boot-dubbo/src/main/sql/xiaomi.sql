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

 Date: 26/12/2018 16:45:34
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of home_appinfo
-- ----------------------------
BEGIN;
INSERT INTO `home_appinfo` VALUES (1, '推荐', 'home/appInfo', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (2, '手机', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (3, '圣诞特惠', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (4, '智能', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (5, '电视', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (6, '笔记本', 'home/activity_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (7, '生活周边', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (8, '家电', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (9, 'Super MI', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (10, '新款游戏本', 'home/tab_page', '#ed5b00', '#747474', '', '');
INSERT INTO `home_appinfo` VALUES (11, '影音娱乐', 'home/tab_page', '#ed5b00', '#747474', '', '');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '小米手机', 0, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (2, '红米', 1, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (3, '电视', 2, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (4, '笔记本', 3, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (5, '家电', 4, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (6, '新品', 5, 'https://www.mi.com/p/2848.html', '1545621115699');
INSERT INTO `menu` VALUES (7, '路由器', 6, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (8, '智能硬件', 7, 'https://www.mi.com', '1545621115699');
INSERT INTO `menu` VALUES (9, '服务', 8, 'https://www.mi.com/service/', '1545621115699');
INSERT INTO `menu` VALUES (10, '社区', 9, 'http://www.xiaomi.cn/', '1545621115699');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
INSERT INTO `slider` VALUES (1, 'https://item.mi.com/product/10000099.html', '', '//i1.mifile.cn/a4/xmad_15451014207739_KEXog.jpg', '//i1.mifile.cn/a4/xmad_15451014285044_jlmYK.jpg 2x');
INSERT INTO `slider` VALUES (2, 'https://www.mi.com/mix3/', '', '//i1.mifile.cn/a4/xmad_15427942125674_JlLUW.jpg', '//i1.mifile.cn/a4/xmad_15427942125674_JlLUW.jpg');
INSERT INTO `slider` VALUES (3, 'https://www.mi.com/a/h/8005.html?client_id=180100041086&masid=17409.0502', '', '//i1.mifile.cn/a4/xmad_15452706663199_aRFIT.jpg', '//i1.mifile.cn/a4/xmad_15452706663199_aRFIT.jpg');
INSERT INTO `slider` VALUES (4, 'http://www.mi.com/mitv4x/55/', '', '//i1.mifile.cn/a4/xmad_15452123429944_suCqP.jpg', '//i1.mifile.cn/a4/xmad_15452123429944_suCqP.jpg');
INSERT INTO `slider` VALUES (5, 'https://www.mi.com/mibookair-12/?cfrom=search', '', '//i1.mifile.cn/a4/xmad_15451388199604_kOuBa.jpg', '//i1.mifile.cn/a4/xmad_15451388199604_kOuBa.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='启动图片';

-- ----------------------------
-- Records of splash
-- ----------------------------
BEGIN;
INSERT INTO `splash` VALUES (4, '1545376672', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/9e5429db9bf70ab328f5b37f3a6529be.jpg', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e27675ce0c828e10977c8ae4ad78655f.jpg', '1545376682', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/459dc18c790e5288d8efc27d603ff5a3.png', '5');
INSERT INTO `splash` VALUES (5, '1545631030', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/229a48bf1cdb9a63cb8d436e3cd04dd1.jpg', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/28b00363d11219ba0755001c3a9f24a5.jpg', '1545631040', 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/459dc18c790e5288d8efc27d603ff5a3.png', '5');
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of submenu
-- ----------------------------
BEGIN;
INSERT INTO `submenu` VALUES (1, '小米MIX 3', 0, 'https://www.mi.com', '1545371040448', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/mix3-320.png', '3299元起');
INSERT INTO `submenu` VALUES (2, '小米MIX 3', 0, 'https://www.mi.com/mix3/', '1545371040448', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/mix3-320.png', '3299元起');
INSERT INTO `submenu` VALUES (3, '小米8 青春版', 0, 'https://www.mi.com/mi8youth/', '1545371040448', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (4, '小米8 屏幕指纹版', 0, 'https://www.mi.com/mi8ud/', '1545371040448', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pingmu-320.png', '3199元起');
INSERT INTO `submenu` VALUES (5, '小米8', 0, 'https://www.mi.com/mi8/', '1545371040448', '小米手机', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pc-320-220-mi8.png', '2699元起');
INSERT INTO `submenu` VALUES (6, '红米6 Pro', 1, 'https://www.mi.com', '1545371040448', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/6pro320-220.png', '999元起');
INSERT INTO `submenu` VALUES (7, '红米6 Pro', 1, 'https://www.mi.com/redmi6pro/', '1545371040448', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/6pro320-220.png', '999元起');
INSERT INTO `submenu` VALUES (8, '红米6', 1, 'https://www.mi.com/redmi6/', '1545371040448', '红米', 'https://i1.mifile.cn/f/i/g/2015/cn-index/666320.png', '799元');
INSERT INTO `submenu` VALUES (9, '小米电视4S 75英寸', 2, 'https://www.mi.com', '1545371040448', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4s75.png', '7999元');
INSERT INTO `submenu` VALUES (10, '小米电视4S 75英寸', 2, 'https://www.mi.com/mitv4s/75/', '1545371040448', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4s75.png', '7999元');
INSERT INTO `submenu` VALUES (11, '小米电视4A 32英寸', 2, 'https://www.mi.com/mitv4A/32/', '1545371040448', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/32.png', '799元');
INSERT INTO `submenu` VALUES (12, '小米电视4A 43英寸青春版', 2, 'https://www.mi.com/mitv4A/43y', '1545371040448', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/4a43.png', '1399元');
INSERT INTO `submenu` VALUES (13, '小米电视4A 50英寸', 2, 'https://www.mi.com/mitv4A/50/', '1545371040448', '电视', 'https://i1.mifile.cn/f/i/g/2015/cn-index/50.png', '1899元');
INSERT INTO `submenu` VALUES (14, '小米笔记本 Air 12.5', 3, 'https://www.mi.com', '1545371040448', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/video/bijiben32012.5.jpg', '3599起');
INSERT INTO `submenu` VALUES (15, '小米笔记本 Air 12.5', 3, 'https://www.mi.com/mibookair-12/', '1545371040448', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/video/bijiben32012.5.jpg', '3599起');
INSERT INTO `submenu` VALUES (16, '小米笔记本 Air 13.3', 3, 'https://www.mi.com/mibookair-13/', '1545371040448', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/daohang13.3.jpg', '4999元起');
INSERT INTO `submenu` VALUES (17, '小米笔记本 15.6', 3, 'https://www.mi.com/milaptop/', '1545371040448', '笔记本', 'https://i1.mifile.cn/f/i/g/320x220biiben.png', '4199元起');
INSERT INTO `submenu` VALUES (18, '小米笔记本 Pro 15.6', 3, 'https://www.mi.com/mibookpro/', '1545371040448', '笔记本', 'https://i1.mifile.cn/f/i/g/2015/cn-index/WechatIMG603.png', '5599元起');
INSERT INTO `submenu` VALUES (19, '米家互联网空调（一级能效）', 4, 'https://www.mi.com', '1545371040448', '家电', 'https://i1.mifile.cn/f/i/g/2015/cn-index/yijinengxiao320.jpg', '2499元');
INSERT INTO `submenu` VALUES (20, '米家互联网空调（一级能效）', 4, 'https://item.mi.com/product/9144.html', '1545371040448', '家电', 'https://i1.mifile.cn/f/i/g/2015/cn-index/yijinengxiao320.jpg', '2499元');
INSERT INTO `submenu` VALUES (21, '米家互联网空调', 4, 'https://item.mi.com/product/8634.html', '1545371040448', '家电', 'https://i1.mifile.cn/f/i/g/2015/kongtiao320-220.jpg', '1999元');
INSERT INTO `submenu` VALUES (22, '米家空气净化器Pro', 4, 'https://item.mi.com/product/4802.html', '1545371040448', '家电', 'https://i1.mifile.cn/f/i/g/2015/gif/kongqijinghuaqi.jpg', '1499元');
INSERT INTO `submenu` VALUES (23, '小米净水器', 4, 'https://www.mi.com/water2/', '1545371040448', '家电', 'https://i1.mifile.cn/f/i/g/2015/xiaomijingshuiqi.jpg', '1999元');
INSERT INTO `submenu` VALUES (24, '小米8 青春版', 5, 'https://www.mi.com/p/2848.html', '1545371040448', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (25, '小米8 青春版', 5, 'https://www.mi.com/mi8youth/', '1545371040448', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png', '1399元起');
INSERT INTO `submenu` VALUES (26, '小米8 屏幕指纹版', 5, 'https://www.mi.com/mi8ud/', '1545371040448', '新品', 'https://i1.mifile.cn/f/i/g/2015/cn-index/pingmu-320.png', '3199元起');
INSERT INTO `submenu` VALUES (27, '小米手环3 NFC版', 5, 'https://item.mi.com/product/8810.html', '1545371040448', '新品', 'https://i1.mifile.cn/f/i/g/2015/gif/shouhuanNFC.jpg', '199元');
INSERT INTO `submenu` VALUES (28, '小米米家小白智能摄像机增强版', 5, 'https://item.mi.com/1183800003.html', '1545371040448', '新品', 'https://i1.mifile.cn/f/i/g/2015/gif/shexiangjizengqiang.jpg', '399元');
INSERT INTO `submenu` VALUES (29, '小米路由器 4', 6, 'https://www.mi.com', '1545371040448', '路由器', 'https://i1.mifile.cn/f/i/g/2015/xiaomiluyouqi4.png', '169元');
INSERT INTO `submenu` VALUES (30, '小米路由器 4', 6, 'https://item.mi.com/product/8105.html', '1545371040448', '路由器', 'https://i1.mifile.cn/f/i/g/2015/xiaomiluyouqi4.png', '169元');
INSERT INTO `submenu` VALUES (31, '小米路由器 4Q', 6, 'https://item.mi.com/1182400090.html?cfrom=search', '1545371040448', '路由器', 'https://i1.mifile.cn/f/i/g/2015/4Q.png', '99元');
INSERT INTO `submenu` VALUES (32, '小米路由器 3A', 6, 'https://www.mi.com/miwifi3a/?cfrom=search', '1545371040448', '路由器', 'https://i1.mifile.cn/f/i/g/2015/3A.png', '99元');
INSERT INTO `submenu` VALUES (33, '小米路由器 3G', 6, 'https://www.mi.com/miwifi3g/', '1545371040448', '路由器', 'https://i1.mifile.cn/f/i/g/2015/3G.png', '179元');
INSERT INTO `submenu` VALUES (34, '小米米家智能摄像机云台版', 7, 'https://www.mi.com', '1545371040448', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/yuntai.jpg', '199元');
INSERT INTO `submenu` VALUES (35, '小米米家智能摄像机云台版', 7, 'https://item.mi.com/product/8026.html', '1545371040448', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/yuntai.jpg', '199元');
INSERT INTO `submenu` VALUES (36, '米家自动洗手机套装', 7, 'https://item.mi.com/product/8881.html', '1545371040448', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/xishouj.jpg', '79元');
INSERT INTO `submenu` VALUES (37, '小米蓝牙耳机AirDots青春版', 7, 'https://item.mi.com/product/9016.html', '1545371040448', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/airdots.jpg', '199元');
INSERT INTO `submenu` VALUES (38, '小米小爱音箱mini', 7, 'https://item.mi.com/product/7832.html', '1545371040448', '智能硬件', 'https://i1.mifile.cn/f/i/g/2015/xiaoaimini.jpg', '169元');
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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for view_type
-- ----------------------------
DROP TABLE IF EXISTS `view_type`;
CREATE TABLE `view_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stat` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `block_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `view_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tab_data_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'header/sections',
  `tab_api` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type
-- ----------------------------
BEGIN;
INSERT INTO `view_type` VALUES (182, '', NULL, 'gallery', 'header', 'home/appInfo');
INSERT INTO `view_type` VALUES (183, '', NULL, 'gallery', 'header', 'home/appInfo');
INSERT INTO `view_type` VALUES (184, '', NULL, 'gallery_540', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (185, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (186, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (187, '', NULL, 'list_broadcast', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (188, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (189, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (190, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (191, 'eco_crowd', '3336177', 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (192, '', NULL, 'list_eco_pub_1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (193, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (194, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (195, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (196, '', '3312452', 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (197, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (198, 'seckill', '3312454', 'list_countdown', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (199, '', NULL, 'horizontal_recycler_list_goods', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (200, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (201, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (202, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (203, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (204, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (205, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (206, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (207, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (208, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (209, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (210, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (211, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (212, '', '3376048', 'video_image_1_2', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (213, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (214, '', '3376315', 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (215, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (216, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (217, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (218, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (219, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (220, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (221, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (222, '', '3312471', 'list_action_title', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (223, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (224, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (225, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (226, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (227, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (228, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (229, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (230, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (231, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (232, '', '3376106', 'list_action_title', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (233, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (234, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (235, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (236, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (237, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (238, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (239, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (240, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (241, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (242, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (243, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (244, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (245, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (246, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (247, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (248, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (249, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (250, '', '3312482', 'list_action_title', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (251, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (252, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (253, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (254, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (255, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (256, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (257, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (258, '', NULL, 'list_two_type1', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (259, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (260, '', '3312488', 'list_action_title', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (261, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (262, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (263, '', NULL, 'horizontal_scroll_view', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (264, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (265, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (266, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (267, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (268, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (269, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (270, '', NULL, 'divider_line', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (271, '', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
INSERT INTO `view_type` VALUES (272, 'auto_recommend', NULL, 'cells_auto_fill', 'sections', 'home/appInfo');
COMMIT;

-- ----------------------------
-- Table structure for view_type_action
-- ----------------------------
DROP TABLE IF EXISTS `view_type_action`;
CREATE TABLE `view_type_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extra` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `log_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type_action
-- ----------------------------
BEGIN;
INSERT INTO `view_type_action` VALUES (222, 222, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000129\",\"productId\":\"10000129\"}', '31apphomegallery001003#t=ad&act=product&page=home&pid=10000129&page_id=6707&bid=3312427.1&adp=2490&adm=10511');
INSERT INTO `view_type_action` VALUES (223, 223, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.mishopCrowdfunding.detail.CrowdFundingDetailFragment?pluginId=175', '{\"crowd_type\":\"2\",\"project_id\":\"1000120\"}', '31apphomegallery002003#t=ad&act=other&page=home&page_id=6707&bid=3312427.2&adp=2681&adm=10527');
INSERT INTO `view_type_action` VALUES (224, 224, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8909\",\"productId\":\"8909\"}', '31apphomegallery003003#t=ad&act=product&page=home&pid=8909&page_id=6707&bid=3312427.3&adp=2557&adm=10498');
INSERT INTO `view_type_action` VALUES (225, 225, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000129\",\"productId\":\"10000129\"}', '31apphomegallery001003#t=ad&act=product&page=home&pid=10000129&page_id=6707&bid=3312427.1&adp=2490&adm=10511');
INSERT INTO `view_type_action` VALUES (226, 226, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.mishopCrowdfunding.detail.CrowdFundingDetailFragment?pluginId=175', '{\"crowd_type\":\"2\",\"project_id\":\"1000120\"}', '31apphomegallery002003#t=ad&act=other&page=home&page_id=6707&bid=3312427.2&adp=2681&adm=10527');
INSERT INTO `view_type_action` VALUES (227, 227, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8909\",\"productId\":\"8909\"}', '31apphomegallery003003#t=ad&act=product&page=home&pid=8909&page_id=6707&bid=3312427.3&adp=2557&adm=10498');
INSERT INTO `view_type_action` VALUES (228, 228, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000129\",\"productId\":\"10000129\"}', '31apphomegallery_540001004#t=ad&act=product&page=home&pid=10000129&page_id=6707&bid=3312428.1&adp=2682&adm=10510');
INSERT INTO `view_type_action` VALUES (229, 229, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.mishopCrowdfunding.detail.CrowdFundingDetailFragment?pluginId=175', '{\"crowd_type\":\"2\",\"project_id\":\"1000120\"}', '31apphomegallery_540002004#t=ad&act=other&page=home&page_id=6707&bid=3312428.2&adp=2491&adm=10524');
INSERT INTO `view_type_action` VALUES (230, 230, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8909\",\"productId\":\"8909\"}', '31apphomegallery_540003004#t=ad&act=product&page=home&pid=8909&page_id=6707&bid=3312428.3&adp=2458&adm=10499');
INSERT INTO `view_type_action` VALUES (231, 231, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.registenew.RegisteListFragment?pluginId=142', NULL, '31apphomecells_auto_fill001005#t=ad&act=other&page=home&page_id=6707&bid=3312431.1&adp=1038&adm=1844');
INSERT INTO `view_type_action` VALUES (232, 232, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.telCharge.ChargeFrgement?pluginId=122', NULL, '31apphomecells_auto_fill002005#t=ad&act=other&page=home&page_id=6707&bid=3312431.2&adp=948&adm=1845');
INSERT INTO `view_type_action` VALUES (233, 233, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.webview.RootFragment?pluginId=111', '{\"url\":\"https:\\/\\/service.10046.mi.com\\/main_home\"}', '31apphomecells_auto_fill003005#t=ad&act=webview&page=home&page_id=6707&bid=3312431.3&adp=1037&adm=1846');
INSERT INTO `view_type_action` VALUES (234, 234, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u624b\\u673a\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1800\"}', '31apphomecells_auto_fill004005#t=ad&act=other&page=home&page_id=6707&bid=3312431.4&adp=950&adm=8438');
INSERT INTO `view_type_action` VALUES (235, 235, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u3010APP\\u901a\\u7528\\u3011\\u65b0\\u54c1\\u53d1\\u5e03\\u9891\\u9053\",\"extra_ver\":\"1670\"}', '31apphomecells_auto_fill005005#t=ad&act=other&page=home&page_id=6707&bid=3312431.5&adp=951&adm=1848');
INSERT INTO `view_type_action` VALUES (236, 236, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100996\",\"share_info\":{\"sina_content\":\"\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u5f00\\u542f\\uff0c\\u5e26\\u4f60\\u4e00\\u5f20\\u56fe\\u8bfb\\u61c2\\u5b83\",\"sina_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/a1d8eff6005334432152b42298ec906e.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100996\",\"wx_content\":\"\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u5f00\\u542f\\uff0c\\u5e26\\u4f60\\u4e00\\u5f20\\u56fe\\u8bfb\\u61c2\\u5b83\",\"wx_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/3c6b218ef9a26916f46ba3bcdd58bc23.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100996\",\"wx_title\":\"299\\u5143\\uff01\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u6b63\\u5f0f\\u5f00\\u542f\",\"wx_title_sm\":\"299\\u5143\\uff01\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u6b63\\u5f0f\\u5f00\\u542f\",\"wx_timeline_content\":\"299\\u5143\\uff01\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u6b63\\u5f0f\\u5f00\\u542f\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/3c6b218ef9a26916f46ba3bcdd58bc23.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100996\",\"wx_timeline_title\":\"299\\u5143\\uff01\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u6b63\\u5f0f\\u5f00\\u542f\",\"wx_timeline_title_sm\":\"299\\u5143\\uff01\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u4f17\\u7b79\\u6b63\\u5f0f\\u5f00\\u542f\"},\"news_id\":\"100996\"}', '31apphomelist_broadcast001021#t=normal&act=other&page=home&page_id=6707&bid=3312436.1');
INSERT INTO `view_type_action` VALUES (237, 237, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100995\",\"share_info\":{\"sina_content\":\"\\u5c0f\\u7c738 \\u91cd\\u5927\\u5347\\u7ea7\\uff0c\\u5168\\u9762\\u5347\\u7ea7\\u5230\\u4e16\\u754c\\u524d\\u4e09\\u7684\\u62cd\\u7167\\u4f53\\u9a8c\\uff0c\\u65b0\\u589e\\u4e24\\u9879\\u660e\\u661f\\u529f\\u80fd\",\"sina_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/570094cb21055288e066f9842710c0cb.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100995\",\"wx_content\":\"\\u5c0f\\u7c738 \\u91cd\\u5927\\u5347\\u7ea7\\uff0c\\u5168\\u9762\\u5347\\u7ea7\\u5230\\u4e16\\u754c\\u524d\\u4e09\\u7684\\u62cd\\u7167\\u4f53\\u9a8c\\uff0c\\u65b0\\u589e\\u4e24\\u9879\\u660e\\u661f\\u529f\\u80fd\",\"wx_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/cd4c2f5773cfcea438ae8c5750082407.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100995\",\"wx_title\":\"\\u5c0f\\u7c738 \\u4e00\\u6b21\\u201c\\u8131\\u80ce\\u6362\\u9aa8\\u201d\\u7684\\u5347\\u7ea7\\uff01\",\"wx_title_sm\":\"\\u5c0f\\u7c738 \\u4e00\\u6b21\\u201c\\u8131\\u80ce\\u6362\\u9aa8\\u201d\\u7684\\u5347\\u7ea7\\uff01\",\"wx_timeline_content\":\"\\u5c0f\\u7c738 \\u4e00\\u6b21\\u201c\\u8131\\u80ce\\u6362\\u9aa8\\u201d\\u7684\\u5347\\u7ea7\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/cd4c2f5773cfcea438ae8c5750082407.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100995\",\"wx_timeline_title\":\"\\u5c0f\\u7c738 \\u4e00\\u6b21\\u201c\\u8131\\u80ce\\u6362\\u9aa8\\u201d\\u7684\\u5347\\u7ea7\\uff01\",\"wx_timeline_title_sm\":\"\\u5c0f\\u7c738 \\u4e00\\u6b21\\u201c\\u8131\\u80ce\\u6362\\u9aa8\\u201d\\u7684\\u5347\\u7ea7\\uff01\"},\"news_id\":\"100995\"}', '31apphomelist_broadcast002021#t=normal&act=other&page=home&page_id=6707&bid=3312436.2');
INSERT INTO `view_type_action` VALUES (238, 238, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100994\",\"share_info\":{\"sina_content\":\"\\u5728\\u8fd9\\u4e2a\\u51ac\\u5929\\uff0c\\u770b\\u5c0f\\u7c73Play \\u5982\\u4f55\\u6e29\\u6696\\u4f60\\u5fc3\",\"sina_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/52bac22bbe45bd67f4e7a655f383b0f4.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100994\",\"wx_content\":\"\\u5728\\u8fd9\\u4e2a\\u51ac\\u5929\\uff0c\\u770b\\u5c0f\\u7c73Play \\u5982\\u4f55\\u6e29\\u6696\\u4f60\\u5fc3\",\"wx_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/12ace8f14be70620dcf15ab3b3dbd833.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100994\",\"wx_title\":\"\\u5c0f\\u7c73Play\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u6e29\\u6696\\u4f60\\u5fc3\",\"wx_title_sm\":\"\\u5c0f\\u7c73Play\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u6e29\\u6696\\u4f60\\u5fc3\",\"wx_timeline_content\":\"\\u5c0f\\u7c73Play\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u6e29\\u6696\\u4f60\\u5fc3\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj0.fds.api.mi-img.com\\/b2c-mimall-media\\/12ace8f14be70620dcf15ab3b3dbd833.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100994\",\"wx_timeline_title\":\"\\u5c0f\\u7c73Play\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u6e29\\u6696\\u4f60\\u5fc3\",\"wx_timeline_title_sm\":\"\\u5c0f\\u7c73Play\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u6e29\\u6696\\u4f60\\u5fc3\"},\"news_id\":\"100994\"}', '31apphomelist_broadcast003021#t=normal&act=other&page=home&page_id=6707&bid=3312436.3');
INSERT INTO `view_type_action` VALUES (239, 239, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u624b\\u673a\\u9891\\u9053-2018\",\"groupId\":\"\",\"extra_ver\":\"7741\"}', '31apphomecells_auto_fill001025#t=ad&act=other&page=home&page_id=6707&bid=3312447.1&adp=1993&adm=10245');
INSERT INTO `view_type_action` VALUES (240, 240, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill002025#t=ad&act=other&page=home&page_id=6707&bid=3312447.2&adp=1994&adm=10512');
INSERT INTO `view_type_action` VALUES (241, 241, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12.23\\u7535\\u89c6\\u54c1\\u7c7b\\u65e5\",\"groupId\":\"\",\"extra_ver\":\"8038\"}', '31apphomecells_auto_fill003025#t=ad&act=other&page=home&page_id=6707&bid=3312447.3&adp=1995&adm=10313');
INSERT INTO `view_type_action` VALUES (242, 242, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.mishopCrowdfunding.MainCrowdfundingFragment?pluginId=175', '{\"needVerison\":\"38\"}', '31apphomecells_auto_fill001030#t=normal&act=other&page=home&page_id=6707&bid=3336177.1');
INSERT INTO `view_type_action` VALUES (243, 243, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.mishopCrowdfunding.detail.CrowdFundingDetailFragment?pluginId=175', '{\"project_id\":\"1000120\",\"crowd_type\":\"2\"}', 'crowd#bid=3336177.2');
INSERT INTO `view_type_action` VALUES (244, 244, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000103\",\"productId\":\"10000103\"}', '31apphomecells_auto_fill001032#t=ad&act=product&page=home&pid=10000103&page_id=6707&bid=3312449.1&adp=392&adm=9912');
INSERT INTO `view_type_action` VALUES (245, 245, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"forceVersion\":\"27\"}', '31apphomecells_auto_fill001037#t=normal&act=other&page=home&page_id=6707&bid=3312452.1');
INSERT INTO `view_type_action` VALUES (246, 246, 'plugin', NULL, NULL, '31apphomelist_countdown001039#t=normal&act=other&page=home&page_id=6707&bid=3312454.1');
INSERT INTO `view_type_action` VALUES (247, 247, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1165100002\",\"goodsId\":\"2165100002\"}', '31activity_homeseckill#goodsid=2165100002&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.11');
INSERT INTO `view_type_action` VALUES (248, 248, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1171300021\",\"goodsId\":\"2171300015\"}', '31activity_homeseckill#goodsid=2171300015&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.12');
INSERT INTO `view_type_action` VALUES (249, 249, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1182400090\",\"goodsId\":\"2182400071\"}', '31activity_homeseckill#goodsid=2182400071&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.13');
INSERT INTO `view_type_action` VALUES (250, 250, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1183900006\",\"goodsId\":\"2183900018\"}', '31activity_homeseckill#goodsid=2183900018&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.14');
INSERT INTO `view_type_action` VALUES (251, 251, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1180200013\",\"goodsId\":\"2180200011\"}', '31activity_homeseckill#goodsid=2180200011&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.15');
INSERT INTO `view_type_action` VALUES (252, 252, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1154300014\",\"goodsId\":\"2154300016\"}', '31activity_homeseckill#goodsid=2154300016&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.16');
INSERT INTO `view_type_action` VALUES (253, 253, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1164800020\",\"goodsId\":\"2164800016\"}', '31activity_homeseckill#goodsid=2164800016&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.17');
INSERT INTO `view_type_action` VALUES (254, 254, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181500042\",\"goodsId\":\"2181500042\"}', '31activity_homeseckill#goodsid=2181500042&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.18');
INSERT INTO `view_type_action` VALUES (255, 255, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181500043\",\"goodsId\":\"2181500043\"}', '31activity_homeseckill#goodsid=2181500043&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.19');
INSERT INTO `view_type_action` VALUES (256, 256, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181500040\",\"goodsId\":\"2181500040\"}', '31activity_homeseckill#goodsid=2181500040&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.20');
INSERT INTO `view_type_action` VALUES (257, 257, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181000022\",\"goodsId\":\"2181000022\"}', '31activity_homeseckill#goodsid=2181000022&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.21');
INSERT INTO `view_type_action` VALUES (258, 258, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1164800019\",\"goodsId\":\"2164800015\"}', '31activity_homeseckill#goodsid=2164800015&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.22');
INSERT INTO `view_type_action` VALUES (259, 259, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1163900005\",\"goodsId\":\"2163900001\"}', '31activity_homeseckill#goodsid=2163900001&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.23');
INSERT INTO `view_type_action` VALUES (260, 260, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1173000019\",\"goodsId\":\"2173000008\"}', '31activity_homeseckill#goodsid=2173000008&start_time=1545818400&end_time=1545825420&page=home&page_id=6707&bid=3312454.24');
INSERT INTO `view_type_action` VALUES (261, 261, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12\\u6708\\u51c0\\u6c34\\u6d3b\\u52a8\",\"groupId\":\"\",\"extra_ver\":\"8034\"}', '31apphomecells_auto_fill001045#t=ad&act=other&page=home&page_id=6707&bid=3324193.1&adp=925&adm=10469');
INSERT INTO `view_type_action` VALUES (262, 262, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000123\",\"productId\":\"10000123\"}', '31apphomecells_auto_fill001047#t=ad&act=product&page=home&pid=10000123&page_id=6707&bid=3346141.1&adp=2038&adm=9907');
INSERT INTO `view_type_action` VALUES (263, 263, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000100\",\"goodsId\":\"\"}', '31apphomelist_two_type1001049#t=product&act=other&page=home&page_id=6707&bid=3341496.1&pid=10000100');
INSERT INTO `view_type_action` VALUES (264, 264, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000117\",\"goodsId\":\"\"}', '31apphomelist_two_type1002049#t=product&act=other&page=home&page_id=6707&bid=3341496.2&pid=10000117');
INSERT INTO `view_type_action` VALUES (265, 265, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000110\",\"goodsId\":\"\"}', '31apphomelist_two_type1001050#t=product&act=other&page=home&page_id=6707&bid=3341499.1&pid=10000110');
INSERT INTO `view_type_action` VALUES (266, 266, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000103\",\"goodsId\":\"\"}', '31apphomelist_two_type1002050#t=product&act=other&page=home&page_id=6707&bid=3341499.2&pid=10000103');
INSERT INTO `view_type_action` VALUES (267, 267, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000107\",\"goodsId\":\"\"}', '31apphomelist_two_type1001051#t=product&act=other&page=home&page_id=6707&bid=3341498.1&pid=10000107');
INSERT INTO `view_type_action` VALUES (268, 268, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000108\",\"goodsId\":\"\"}', '31apphomelist_two_type1002051#t=product&act=other&page=home&page_id=6707&bid=3341498.2&pid=10000108');
INSERT INTO `view_type_action` VALUES (269, 269, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000085\",\"goodsId\":\"\"}', '31apphomelist_two_type1001052#t=product&act=other&page=home&page_id=6707&bid=3341497.1&pid=10000085');
INSERT INTO `view_type_action` VALUES (270, 270, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000089\",\"goodsId\":\"\"}', '31apphomelist_two_type1002052#t=product&act=other&page=home&page_id=6707&bid=3341497.2&pid=10000089');
INSERT INTO `view_type_action` VALUES (271, 271, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9144\",\"productId\":\"9144\"}', '31apphomecells_auto_fill001054#t=ad&act=product&page=home&pid=9144&page_id=6707&bid=3387953.1&adp=2873&adm=10416');
INSERT INTO `view_type_action` VALUES (272, 272, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.RootFragment?pluginId=219', NULL, '31apphomevideo_image_1_2000000#t=normal&act=other&page=home&page_id=6707&bid=3376048.1');
INSERT INTO `view_type_action` VALUES (273, 273, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.RootFragment?pluginId=219', NULL, '31apphomevideo_image_1_2000000#t=normal&act=other&page=home&page_id=6707&bid=3376048.2');
INSERT INTO `view_type_action` VALUES (274, 274, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"6\"}', '31apphomecells_auto_fill001058#t=normal&act=other&page=home&page_id=6707&bid=3376315.1');
INSERT INTO `view_type_action` VALUES (275, 275, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"2\"}', '31apphomecells_auto_fill002058#t=normal&act=other&page=home&page_id=6707&bid=3376315.2');
INSERT INTO `view_type_action` VALUES (276, 276, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"1\"}', '31apphomecells_auto_fill003058#t=normal&act=other&page=home&page_id=6707&bid=3376315.3');
INSERT INTO `view_type_action` VALUES (277, 277, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8111\",\"productId\":\"8111\"}', '31apphomecells_auto_fill001060#t=ad&act=product&page=home&pid=8111&page_id=6707&bid=3312466.1&adp=1467&adm=10449');
INSERT INTO `view_type_action` VALUES (278, 278, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8912\",\"goodsId\":\"\"}', '31apphomelist_two_type1001062#t=product&act=other&page=home&page_id=6707&bid=3383580.1&pid=8912');
INSERT INTO `view_type_action` VALUES (279, 279, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6222\",\"goodsId\":\"\"}', '31apphomelist_two_type1002062#t=product&act=other&page=home&page_id=6707&bid=3383580.2&pid=6222');
INSERT INTO `view_type_action` VALUES (280, 280, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8909\",\"goodsId\":\"\"}', '31apphomelist_two_type1001063#t=product&act=other&page=home&page_id=6707&bid=3383469.1&pid=8909');
INSERT INTO `view_type_action` VALUES (281, 281, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8111\",\"goodsId\":\"\"}', '31apphomelist_two_type1002063#t=product&act=other&page=home&page_id=6707&bid=3383469.2&pid=8111');
INSERT INTO `view_type_action` VALUES (282, 282, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8911\",\"goodsId\":\"\"}', '31apphomelist_two_type1001064#t=product&act=other&page=home&page_id=6707&bid=3358235.1&pid=8911');
INSERT INTO `view_type_action` VALUES (283, 283, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8041\",\"goodsId\":\"\"}', '31apphomelist_two_type1002064#t=product&act=other&page=home&page_id=6707&bid=3358235.2&pid=8041');
INSERT INTO `view_type_action` VALUES (284, 284, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12.23\\u7535\\u89c6\\u54c1\\u7c7b\\u65e5\",\"groupId\":\"\",\"extra_ver\":\"8038\"}', '31apphomelist_action_title001066#t=normal&act=other&page=home&page_id=6707&bid=3312471.1');
INSERT INTO `view_type_action` VALUES (285, 285, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"6222\",\"productId\":\"6222\"}', '31apphomecells_auto_fill001069#t=ad&act=product&page=home&pid=6222&page_id=6707&bid=3376177.1&adp=1354&adm=10507');
INSERT INTO `view_type_action` VALUES (286, 286, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8916\",\"productId\":\"8916\"}', '31apphomecells_auto_fill001071#t=ad&act=product&page=home&pid=8916&page_id=6707&bid=3376101.1&adp=2830&adm=10044');
INSERT INTO `view_type_action` VALUES (287, 287, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8915\",\"goodsId\":\"\"}', '31apphomelist_two_type1001073#t=product&act=other&page=home&page_id=6707&bid=3364245.1&pid=8915');
INSERT INTO `view_type_action` VALUES (288, 288, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7438\",\"goodsId\":\"\"}', '31apphomelist_two_type1002073#t=product&act=other&page=home&page_id=6707&bid=3364245.2&pid=7438');
INSERT INTO `view_type_action` VALUES (289, 289, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6781\",\"goodsId\":\"\"}', '31apphomelist_two_type1001074#t=product&act=other&page=home&page_id=6707&bid=3376103.1&pid=6781');
INSERT INTO `view_type_action` VALUES (290, 290, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7866\",\"goodsId\":\"\"}', '31apphomelist_two_type1002074#t=product&act=other&page=home&page_id=6707&bid=3376103.2&pid=7866');
INSERT INTO `view_type_action` VALUES (291, 291, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8648\",\"goodsId\":\"\"}', '31apphomelist_two_type1001075#t=product&act=other&page=home&page_id=6707&bid=3376104.1&pid=8648');
INSERT INTO `view_type_action` VALUES (292, 292, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7565\",\"goodsId\":\"\"}', '31apphomelist_two_type1002075#t=product&act=other&page=home&page_id=6707&bid=3376104.2&pid=7565');
INSERT INTO `view_type_action` VALUES (293, 293, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u7b14\\u8bb0\\u672c\\u4f1a\\u573a\\u5e38\\u89c4\\u9875\\u9762\",\"groupId\":\"\",\"extra_ver\":\"7743\"}', '31apphomelist_action_title001077#t=normal&act=other&page=home&page_id=6707&bid=3376106.1');
INSERT INTO `view_type_action` VALUES (294, 294, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9114\",\"productId\":\"9114\"}', '31apphomecells_auto_fill001079#t=ad&act=product&page=home&pid=9114&page_id=6707&bid=3312484.1&adp=1254&adm=10489');
INSERT INTO `view_type_action` VALUES (295, 295, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"3377\"}', '31apphomecells_auto_fill001081#t=ad&adm=10265&adp=2024&eid=86:3:1:0:0:0:0:0:0:0&tid=adRec-78cpaAwFqwUTL0eVFuqCzg==&pid=&bid=3312475.1&page=home&page_id=6707');
INSERT INTO `view_type_action` VALUES (296, 296, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8026\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8026&page_id=');
INSERT INTO `view_type_action` VALUES (297, 297, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8634\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8634&page_id=');
INSERT INTO `view_type_action` VALUES (298, 298, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000052\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=10000052&page_id=');
INSERT INTO `view_type_action` VALUES (299, 299, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"5825\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=5825&page_id=');
INSERT INTO `view_type_action` VALUES (300, 300, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6334\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=6334&page_id=');
INSERT INTO `view_type_action` VALUES (301, 301, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8645\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8645&page_id=');
INSERT INTO `view_type_action` VALUES (302, 302, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9150\",\"productId\":\"9150\"}', '31apphomecells_auto_fill001086#t=ad&act=product&page=home&pid=9150&page_id=6707&bid=3312464.1&adp=192&adm=10517');
INSERT INTO `view_type_action` VALUES (303, 303, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8585\",\"goodsId\":\"\",\"productId\":\"8585\"}', '31apphomecells_auto_fill001088#t=ad&act=product&page=home&pid=8585&page_id=6707&bid=3312480.1&adp=13&adm=8601');
INSERT INTO `view_type_action` VALUES (304, 304, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"9144\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=9144&page_id=');
INSERT INTO `view_type_action` VALUES (305, 305, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"9011\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=9011&page_id=');
INSERT INTO `view_type_action` VALUES (306, 306, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8760\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8760&page_id=');
INSERT INTO `view_type_action` VALUES (307, 307, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8811\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8811&page_id=');
INSERT INTO `view_type_action` VALUES (308, 308, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8606\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8606&page_id=');
INSERT INTO `view_type_action` VALUES (309, 309, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8967\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8967&page_id=');
INSERT INTO `view_type_action` VALUES (310, 310, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"2018\\u65b0\\u54c1\\u53d1\\u5e03\\u9891\\u9053\",\"groupId\":\"\",\"extra_ver\":\"1670\"}', '31apphomelist_action_title001092#t=normal&act=other&page=home&page_id=6707&bid=3312482.1');
INSERT INTO `view_type_action` VALUES (311, 311, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill001097#t=ad&act=other&page=home&page_id=6707&bid=3312478.1&adp=1900&adm=10513');
INSERT INTO `view_type_action` VALUES (312, 312, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7797\",\"goodsId\":\"\"}', '31apphomecells_auto_fill001099#t=ad&adm=7918&adp=14&eid=86:3:1:0:0:0:0:0:0:0&tid=adRec-78cpaAwFqwUTL0eVFuqCzg==&pid=&bid=3312486.1&page=home&page_id=6707');
INSERT INTO `view_type_action` VALUES (313, 313, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"5145\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=5145&page_id=');
INSERT INTO `view_type_action` VALUES (314, 314, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6419\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=6419&page_id=');
INSERT INTO `view_type_action` VALUES (315, 315, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6103\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=6103&page_id=');
INSERT INTO `view_type_action` VALUES (316, 316, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8390\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8390&page_id=');
INSERT INTO `view_type_action` VALUES (317, 317, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"5006\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=5006&page_id=');
INSERT INTO `view_type_action` VALUES (318, 318, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7797\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=7797&page_id=');
INSERT INTO `view_type_action` VALUES (319, 319, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"forceVersion\":\"5\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053\",\"extra_ver\":\"1801\"}', '31apphomelist_action_title001103#t=normal&act=other&page=home&page_id=6707&bid=3312488.1');
INSERT INTO `view_type_action` VALUES (320, 320, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.webview.RootFragment?pluginId=111', '{\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100991\"}', '31apphomecells_auto_fill001105#t=ad&act=webview&page=home&page_id=6707&bid=3312490.1&adp=202&adm=10505');
INSERT INTO `view_type_action` VALUES (321, 321, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u5149\\u5927\\u94f6\\u884c\\u5c0f\\u7c73\\u8054\\u540d\\u4fe1\\u7528\\u5361\\u5f00\\u653e\\u7533\\u8bf7\\uff0c\\u5c0f\\u7c73\\u7535\\u89c6\\u5168\\u54c1\\u7c7b\\u7acb\\u51cf300\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/8b6ac3b031617d1b32ff64a9adaeae0b.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_content\":\"\\u5149\\u5927\\u94f6\\u884c\\u5c0f\\u7c73\\u8054\\u540d\\u4fe1\\u7528\\u5361\\u5f00\\u653e\\u7533\\u8bf7\\uff0c\\u5c0f\\u7c73\\u7535\\u89c6\\u5168\\u54c1\\u7c7b\\u7acb\\u51cf300\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/f132b192b490489c80d8ca798f162f77.png\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_title\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_title_sm\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_content\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/f132b192b490489c80d8ca798f162f77.png\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_timeline_title\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_title_sm\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\"},\"news_id\":\"100988\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988&needValidHost=false\"}', '31apphomehorizontal_scroll_view001106#t=normal&act=other&page=home&page_id=6707&bid=3312491.1');
INSERT INTO `view_type_action` VALUES (322, 322, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"12.19-12.25\\uff0c\\u56de\\u6536\\u624b\\u673a\\u989d\\u5916\\u8d60\\u8d2d\\u65b0\\u8865\\u8d34108\\u5143\\uff0c\\u7279\\u522b\\u652f\\u6301\\u5c0f\\u7c73Play\\u6362\\u65b0\\uff01\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/c2631384946ed2d823a98d76de20b911.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_content\":\"12.19-12.25\\uff0c\\u56de\\u6536\\u624b\\u673a\\u989d\\u5916\\u8865\\u8d34108\\u5143\\uff0c\\u652f\\u6301\\u5c0f\\u7c73Play\\u6362\\u65b0\\uff01\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/268d94c2b861da93bb2bb80f73bed845.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_title\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_title_sm\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_content\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/268d94c2b861da93bb2bb80f73bed845.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_timeline_title\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_title_sm\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\"},\"news_id\":\"100986\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986&needValidHost=false\"}', '31apphomehorizontal_scroll_view002106#t=normal&act=other&page=home&page_id=6707&bid=3312491.2');
INSERT INTO `view_type_action` VALUES (323, 323, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u5173\\u6ce8\\u201c\\u5c0f\\u7c73\\u7c73\\u7c89\\u4e4b\\u5bb6\\u201d\\u516c\\u4f17\\u53f7\\uff0c\\u56de\\u590d\\u201c\\u6545\\u5bab\\u7248\\u201d\\uff0c\\u8d62\\u53d6\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/a3bb18fcacc2361bb4d15a10b31cb8d7.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_content\":\"\\u5173\\u6ce8\\u201c\\u5c0f\\u7c73\\u7c73\\u7c89\\u4e4b\\u5bb6\\u201d\\u516c\\u4f17\\u53f7\\uff0c\\u56de\\u590d\\u201c\\u6545\\u5bab\\u7248\\u201d\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/542dcb5802b07970078798159cf328c0.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_title\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_title_sm\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_content\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/542dcb5802b07970078798159cf328c0.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_timeline_title\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_title_sm\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\"},\"news_id\":\"100968\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968&needValidHost=false\"}', '31apphomehorizontal_scroll_view003106#t=normal&act=other&page=home&page_id=6707&bid=3312491.3');
INSERT INTO `view_type_action` VALUES (324, 324, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/f30ba4f04137bf177492640493fd9401.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100985\",\"wx_content\":\"\\u7c73\\u5bb6\\u7535\\u6696\\u566812\\u670826\\u65e514\\uff1a30\\u5f00\\u542f\\u4f17\\u7b79\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/a5494b082cf3ded46a219708b7ea12aa.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100985\",\"wx_title\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\",\"wx_title_sm\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\",\"wx_timeline_content\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/a5494b082cf3ded46a219708b7ea12aa.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100985\",\"wx_timeline_title\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\",\"wx_timeline_title_sm\":\"\\u5c0f\\u7c73\\u7c73\\u5bb6\\u7167\\u7247\\u6253\\u5370\\u673a\\u4f17\\u7b79\\u552e\\u7f44\\uff0c\\u7c73\\u5bb6\\u7535\\u6696\\u566812.26\\u4f17\\u7b79\\u5f00\\u542f\"},\"news_id\":\"100985\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100985&needValidHost=false\"}', '31apphomehorizontal_scroll_view004106#t=normal&act=other&page=home&page_id=6707&bid=3312491.4');
INSERT INTO `view_type_action` VALUES (325, 325, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.RootFragment?pluginId=150', NULL, '31apphomehorizontal_scroll_view005106#t=normal&act=other&page=home&page_id=6707&bid=3312491.5');
INSERT INTO `view_type_action` VALUES (326, 326, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u7b14\\u8bb0\\u672c\\u4f1a\\u573a\\u5e38\\u89c4\\u9875\\u9762\",\"groupId\":\"\",\"extra_ver\":\"7743\"}', '31apphomecells_auto_fill001108#t=ad&act=other&page=home&page_id=6707&bid=3312493.1&adp=45&adm=10176');
INSERT INTO `view_type_action` VALUES (327, 327, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.productchannel.ui.RootFragment?pluginId=15101', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u65e7-\\u667a\\u80fd\\u9891\\u9053\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill002108#t=ad&act=channel&page=home&page_id=6707&bid=3312493.2&adp=50&adm=46');
INSERT INTO `view_type_action` VALUES (328, 328, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u751f\\u6d3b\\u5468\\u8fb9-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1799\"}', '31apphomecells_auto_fill001110#t=ad&act=other&page=home&page_id=6707&bid=3312495.1&adp=47&adm=2961');
INSERT INTO `view_type_action` VALUES (329, 329, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.productchannel.ui.RootFragment?pluginId=15101', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_ver\":\"19\",\"extra_title\":\"\\u97f3\\u4e50\\u53d1\\u70e7\"}', '31apphomecells_auto_fill002110#t=ad&act=channel&page=home&page_id=6707&bid=3312495.2&adp=48&adm=44');
INSERT INTO `view_type_action` VALUES (330, 330, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill001112#t=ad&act=other&page=home&page_id=6707&bid=3312497.1&adp=49&adm=10177');
INSERT INTO `view_type_action` VALUES (331, 331, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u5c0f\\u7c73\\u751f\\u6001\\u94fe\\u4ea7\\u54c1\\u65e5\\u672c\\u4f18\\u826f\\u8bbe\\u8ba1\\u5956\",\"groupId\":\"\",\"extra_ver\":\"7285\"}', '31apphomecells_auto_fill002112#t=ad&act=other&page=home&page_id=6707&bid=3312497.2&adp=46&adm=10178');
INSERT INTO `view_type_action` VALUES (332, 332, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u795e\\u79d8\\u65b0\\u54c1\\u8033\\u673a\",\"groupId\":\"\",\"extra_ver\":\"7973\"}', '31apphomecells_auto_fill001114#t=ad&act=other&page=home&page_id=6707&bid=3312499.1&adp=1351&adm=10361');
INSERT INTO `view_type_action` VALUES (333, 333, 'plugin', NULL, NULL, '31apphomecells_auto_fill001115#t=ad&act=other&page=home&page_id=6707&bid=3312500.1&adp=1050&adm=2050');
COMMIT;

-- ----------------------------
-- Table structure for view_type_body
-- ----------------------------
DROP TABLE IF EXISTS `view_type_body`;
CREATE TABLE `view_type_body` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `view_type_id` int(11) NOT NULL,
  `line_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `line_height` double DEFAULT NULL,
  `w` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `h` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `bg_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `recommend_flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`view_type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type_body
-- ----------------------------
BEGIN;
INSERT INTO `view_type_body` VALUES (182, 182, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (183, 183, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (184, 184, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (185, 185, NULL, NULL, '1080', '228', NULL, NULL);
INSERT INTO `view_type_body` VALUES (186, 186, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (187, 187, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (188, 188, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (189, 189, NULL, NULL, '1080', '762', NULL, NULL);
INSERT INTO `view_type_body` VALUES (190, 190, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (191, 191, NULL, NULL, '1080', '120', '#ffffff', '0');
INSERT INTO `view_type_body` VALUES (192, 192, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (193, 193, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (194, 194, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (195, 195, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (196, 196, NULL, NULL, '1080', '230', '#ffffff', '0');
INSERT INTO `view_type_body` VALUES (197, 197, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (198, 198, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (199, 199, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (200, 200, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (201, 201, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (202, 202, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (203, 203, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (204, 204, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (205, 205, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (206, 206, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (207, 207, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (208, 208, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (209, 209, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (210, 210, NULL, NULL, '1080', '420', NULL, '0');
INSERT INTO `view_type_body` VALUES (211, 211, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (212, 212, NULL, NULL, NULL, NULL, '#ffffff', NULL);
INSERT INTO `view_type_body` VALUES (213, 213, '#ffffff', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (214, 214, NULL, NULL, '1080', '360', '#ffffff', '0');
INSERT INTO `view_type_body` VALUES (215, 215, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (216, 216, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (217, 217, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (218, 218, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (219, 219, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (220, 220, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (221, 221, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (222, 222, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (223, 223, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (224, 224, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (225, 225, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (226, 226, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (227, 227, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (228, 228, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (229, 229, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (230, 230, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (231, 231, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (232, 232, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (233, 233, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (234, 234, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (235, 235, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (236, 236, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (237, 237, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (238, 238, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (239, 239, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (240, 240, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (241, 241, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (242, 242, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (243, 243, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (244, 244, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (245, 245, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (246, 246, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (247, 247, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (248, 248, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (249, 249, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (250, 250, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (251, 251, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (252, 252, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (253, 253, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (254, 254, NULL, NULL, '1080', '660', NULL, NULL);
INSERT INTO `view_type_body` VALUES (255, 255, '#ffffff', 10, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (256, 256, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (257, 257, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (258, 258, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (259, 259, '#cecece', 1, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (260, 260, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (261, 261, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (262, 262, NULL, NULL, '1080', '540', NULL, NULL);
INSERT INTO `view_type_body` VALUES (263, 263, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (264, 264, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (265, 265, NULL, NULL, '1080', '720', NULL, NULL);
INSERT INTO `view_type_body` VALUES (266, 266, '#f5f5f5', 6, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (267, 267, NULL, NULL, '1080', '720', NULL, NULL);
INSERT INTO `view_type_body` VALUES (268, 268, '#f5f5f5', 6, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (269, 269, NULL, NULL, '1080', '720', NULL, NULL);
INSERT INTO `view_type_body` VALUES (270, 270, '#f5f5f5', 24, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_body` VALUES (271, 271, NULL, NULL, '1080', '420', NULL, NULL);
INSERT INTO `view_type_body` VALUES (272, 272, NULL, NULL, '1080', '180', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for view_type_item
-- ----------------------------
DROP TABLE IF EXISTS `view_type_item`;
CREATE TABLE `view_type_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `view_type_id` int(11) NOT NULL,
  `img_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img_url_webp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w` int(11) unsigned zerofill DEFAULT NULL,
  `h` int(11) unsigned zerofill DEFAULT NULL,
  `ad_position_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  `img_url_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`view_type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type_item
-- ----------------------------
BEGIN;
INSERT INTO `view_type_item` VALUES (222, 182, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/2b185b969700f8e3d6b0d8db8c8b770e.jpeg?w=1080&h=768&bg=2C79D2', 'http://i8.mifile.cn/v1/a1/9c3ceda5-df16-d8f3-45f0-8c379e2f0778.webp?w=1080&h=768&bg=2C79D2', 00000001080, 00000000768, 2490, 10511, '#2C79D2');
INSERT INTO `view_type_item` VALUES (223, 182, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/8a88bf3748ad89768fa7215c7b8a832b.jpg?w=1080&h=768&bg=C9C2BC', 'http://i8.mifile.cn/v1/a1/96629859-18ab-146e-d6ec-fba1a09462e6.webp?w=1080&h=768&bg=C9C2BC', 00000001080, 00000000768, 2681, 10527, '#C9C2BC');
INSERT INTO `view_type_item` VALUES (224, 182, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/6da01e47727718b312efb78d9201abcb.jpg?w=1080&h=768&bg=B8C5DB', 'http://i8.mifile.cn/v1/a1/9381d702-4fc3-94eb-e41f-6374b1e25419.webp?w=1080&h=768&bg=B8C5DB', 00000001080, 00000000768, 2557, 10498, '#B8C5DB');
INSERT INTO `view_type_item` VALUES (225, 183, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/2b185b969700f8e3d6b0d8db8c8b770e.jpeg?w=1080&h=768&bg=2C79D2', 'http://i8.mifile.cn/v1/a1/9c3ceda5-df16-d8f3-45f0-8c379e2f0778.webp?w=1080&h=768&bg=2C79D2', 00000001080, 00000000768, 2490, 10511, '#2C79D2');
INSERT INTO `view_type_item` VALUES (226, 183, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/8a88bf3748ad89768fa7215c7b8a832b.jpg?w=1080&h=768&bg=C9C2BC', 'http://i8.mifile.cn/v1/a1/96629859-18ab-146e-d6ec-fba1a09462e6.webp?w=1080&h=768&bg=C9C2BC', 00000001080, 00000000768, 2681, 10527, '#C9C2BC');
INSERT INTO `view_type_item` VALUES (227, 183, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/6da01e47727718b312efb78d9201abcb.jpg?w=1080&h=768&bg=B8C5DB', 'http://i8.mifile.cn/v1/a1/9381d702-4fc3-94eb-e41f-6374b1e25419.webp?w=1080&h=768&bg=B8C5DB', 00000001080, 00000000768, 2557, 10498, '#B8C5DB');
INSERT INTO `view_type_item` VALUES (228, 184, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f39c37b7f68c3de1138ce3c2229178cd.jpg?w=1080&h=540&bg=3077D0', 'http://i8.mifile.cn/v1/a1/a4df6b8f-2880-4b26-3d4a-b7c2657573fb.webp?w=1080&h=540&bg=3077D0', 00000001080, 00000000540, 2682, 10510, '#3077D0');
INSERT INTO `view_type_item` VALUES (229, 184, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/628f31c32732e32ba55220a21f9bfc30.jpg?w=1080&h=540&bg=C1B9B1', 'http://i8.mifile.cn/v1/a1/4790f256-9cbe-ddc8-1906-b908de1a439a.webp?w=1080&h=540&bg=C1B9B1', 00000001080, 00000000540, 2491, 10524, '#C1B9B1');
INSERT INTO `view_type_item` VALUES (230, 184, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/7b47d4ac3fba526d6927a4ffd91ada97.jpg?w=1080&h=540&bg=B3BACF', 'http://i8.mifile.cn/v1/a1/ea5e9960-37f2-6e7d-de8e-df3c481f1562.webp?w=1080&h=540&bg=B3BACF', 00000001080, 00000000540, 2458, 10499, '#B3BACF');
INSERT INTO `view_type_item` VALUES (231, 185, 'http://i8.mifile.cn/b2c-mimall-media/e81e39c975bb6becee0b287d5034f882.png?w=216&h=228&bg=FCF0F0', 'http://i8.mifile.cn/v1/a1/59c9e9b7-a2d0-e3e7-68c6-231cd05d7c97.webp?w=216&h=228&bg=FCF0F0', 00000000216, 00000000228, 1038, 1844, '#FCF0F0');
INSERT INTO `view_type_item` VALUES (232, 185, 'http://i8.mifile.cn/b2c-mimall-media/d92242558664461f8f7c17b7fc663df3.png?w=216&h=228&bg=FBF3E1', 'http://i8.mifile.cn/v1/a1/34e14274-f1ee-b6bd-86cb-f858c50cab70.webp?w=216&h=228&bg=FBF3E1', 00000000216, 00000000228, 948, 1845, '#FBF3E1');
INSERT INTO `view_type_item` VALUES (233, 185, 'https://i8.mifile.cn/b2c-mimall-media/b30bbe16513d09653d73036287e6e5ba.png?w=216&h=228&bg=FFFFFF', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b30bbe16513d09653d73036287e6e5ba.png?w=216&h=228&bg=FFFFFF', 00000000216, 00000000228, 1037, 1846, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (234, 185, 'https://i8.mifile.cn/b2c-mimall-media/ca760df21f9a89ff337568fc703a4b89.jpg?w=216&h=228&bg=FFFFFF', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ca760df21f9a89ff337568fc703a4b89.jpg?w=216&h=228&bg=FFFFFF', 00000000216, 00000000228, 950, 8438, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (235, 185, 'http://i8.mifile.cn/b2c-mimall-media/6db24cff2bf2080a230e1e108c2516fd.png?w=216&h=228&bg=F7F4FB', 'http://i8.mifile.cn/v1/a1/bc5de799-0048-96ec-fa94-e04a2604eee1.webp?w=216&h=228&bg=F7F4FB', 00000000216, 00000000228, 951, 1848, '#F7F4FB');
INSERT INTO `view_type_item` VALUES (236, 187, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (237, 187, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (238, 187, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (239, 189, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d32a72e7773ff324440be8cad8a7c001.jpg?w=537&h=762&bg=8595A7', 'http://i8.mifile.cn/v1/a1/2bcfae43-5b1b-b44d-567c-b9528983f278.webp?w=537&h=762&bg=8595A7', 00000000537, 00000000762, 1993, 10245, '#8595A7');
INSERT INTO `view_type_item` VALUES (240, 189, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/0f45150e196a51aa2f70e0793bbf4d18.jpg?w=537&h=378&bg=E8EABD', 'http://i8.mifile.cn/v1/a1/c497f86e-8e8a-c48d-9fc6-1781b064d0ca.webp?w=537&h=378&bg=E8EABD', 00000000537, 00000000378, 1994, 10512, '#E8EABD');
INSERT INTO `view_type_item` VALUES (241, 189, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/769fbfd0d97e14140ed29bd1c34772cd.jpg?w=537&h=378&bg=DDBABB', 'http://i8.mifile.cn/v1/a1/83d4a193-f721-51bc-7d64-57545ff1b00d.webp?w=537&h=378&bg=DDBABB', 00000000537, 00000000378, 1995, 10313, '#DDBABB');
INSERT INTO `view_type_item` VALUES (242, 191, 'https://i8.mifile.cn/b2c-mimall-media/7cee7d4c397dd7912221be10d760f1af.jpg', 'http://i8.mifile.cn/v1/a1/29e377bc-38b0-8a01-97a1-8b36084425ec.webp', 00000001080, 00000000120, NULL, NULL, '#FAFAFA');
INSERT INTO `view_type_item` VALUES (243, 192, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/44886f61d61671b36aeb387c5c5d99a4.jpg', NULL, 00000001080, 00000000540, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (244, 194, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/419a895a91795349ee1a90573e8e27bd.jpg?w=1080&h=420&bg=C4B2CB', 'http://i8.mifile.cn/v1/a1/54120c8b-1e76-6167-a831-1f34dba5aae7.webp?w=1080&h=420&bg=C4B2CB', 00000001080, 00000000420, 392, 9912, '#C4B2CB');
INSERT INTO `view_type_item` VALUES (245, 196, 'http://i8.mifile.cn/b2c-mimall-media/be0fa28c1cc3183a71200ace08c6649d.jpg', 'http://i8.mifile.cn/v1/a1/db943e55-933b-124b-adcb-e20907712c54.webp', 00000001080, 00000000230, NULL, NULL, '#EFEFEF');
INSERT INTO `view_type_item` VALUES (246, 198, 'http://i8.mifile.cn/b2c-mimall-media/ad5f991fdf1ad821bdc871d918ba8d90.jpg?w=1080&h=120&bg=FFFFFF', 'http://i8.mifile.cn/v1/a1/df8aeaf5-0b88-e171-9dc4-d38cc5ed3f27.webp?w=1080&h=120&bg=FFFFFF', NULL, NULL, NULL, NULL, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (247, 199, 'https://i8.mifile.cn/b2c-mimall-media/2de973ab0e00cc3fa38148c994e1833a.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (248, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/8f1e1ba785cb57a1131861e5b57ab685.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (249, 199, 'https://i8.mifile.cn/b2c-mimall-media/329aff51bf0def82a60ed1dc740587ac.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (250, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/9d5a54aa2874dc9459efab29822ad0f6.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (251, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f0990f3bbdee814cb964a96791d17231.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (252, 199, 'https://i8.mifile.cn/b2c-mimall-media/d90587d981791e3e242eb94f6503de81.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (253, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b8faa70c44238b8bb4aefd7f9bdcf858.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (254, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/31b25fc426bda2e1e108a48b75fafcdd.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (255, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/bea6abcdb0aa20701dcdacfb291b72e1.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (256, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/928d6e06a6fb9563551272b323da4ffc.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (257, 199, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/fb4a5925027a3ba86ad01feeba40d049.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (258, 199, 'https://i8.mifile.cn/b2c-mimall-media/ab5006225445fa5789cbfd4a9ce15c7f.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (259, 199, 'https://i8.mifile.cn/b2c-mimall-media/cbafde0e8686bf6a1d1d6fe6a898a025.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (260, 199, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/ec79685e39e7490538274a8a92deb394.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (261, 201, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d70f36018126cda5326d30177ac413f7.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d70f36018126cda5326d30177ac413f7.jpg?f=webp&w=1080&h=420&bg=FFFFFF', 00000001080, 00000000420, 925, 10469, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (262, 203, 'https://i8.mifile.cn/b2c-mimall-media/275bfbc75e99991d64c18aacb058c935.jpg?w=1080&h=660&bg=A4ABB6', 'http://i8.mifile.cn/v1/a1/bba91c48-9f67-3dd7-41d7-313ab4bfc635.webp?w=1080&h=660&bg=A4ABB6', 00000001080, 00000000660, 2038, 9907, '#A4ABB6');
INSERT INTO `view_type_item` VALUES (263, 205, 'https://i8.mifile.cn/b2c-mimall-media/fb3fc5df8e762c4a96f0cdd59670070c.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/a14a8cc3-3f47-3224-d221-8ff8485d624d.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#A18390');
INSERT INTO `view_type_item` VALUES (264, 205, 'https://i8.mifile.cn/b2c-mimall-media/6c9d4031099deb5fc28ec57ac730df96.jpg', 'http://i8.mifile.cn/v1/a1/1c3e0097-73a6-1788-96f7-2cdb58d82ba1.webp', NULL, NULL, NULL, NULL, '#9395BA');
INSERT INTO `view_type_item` VALUES (265, 206, 'https://i8.mifile.cn/b2c-mimall-media/f1d7a0a4ba2c713b29fefa6ad26abe55.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/2c506517-9477-c928-8e77-bee18b6818a1.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#E2B7AE');
INSERT INTO `view_type_item` VALUES (266, 206, 'https://i8.mifile.cn/b2c-mimall-media/98b3aaf7fd30a6b7164de67e837ab619.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/a081da10-3758-e051-7a20-0de017f37476.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#C1A1A8');
INSERT INTO `view_type_item` VALUES (267, 207, 'https://i8.mifile.cn/b2c-mimall-media/e8461f6647dcbae7617b7783bd85396d.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/dbf22834-b9e2-d453-24a8-1a4f7e7dc702.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#C8B3BB');
INSERT INTO `view_type_item` VALUES (268, 207, 'https://i8.mifile.cn/b2c-mimall-media/c0bee80d76b0d3da60013c86a8e773ca.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/685330bb-cb82-c3c3-e3cf-106c9b9a70e6.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#7F8B90');
INSERT INTO `view_type_item` VALUES (269, 208, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/0a465c4bc19e91943150af2a33cea923.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/0662d5df-7467-da18-1d6d-0b3c10409719.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#BAA8A8');
INSERT INTO `view_type_item` VALUES (270, 208, 'https://i8.mifile.cn/b2c-mimall-media/ee44583e8167f3d250186069a26c1384.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/b14ddefc-9165-57aa-8d61-d70c6db4e2a0.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#646665');
INSERT INTO `view_type_item` VALUES (271, 210, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/23eb03e52fca670287d93febd358c073.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/23eb03e52fca670287d93febd358c073.jpg?f=webp&w=1080&h=420&bg=FFFFFF', 00000001080, 00000000420, 2873, 10416, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (272, 212, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/06098d1f17e0f82302922ddc2aaad974.jpg?w=719&h=360&bg=BBC5C8', 'http://i8.mifile.cn/v1/a1/0e226392-229c-f100-2372-ded296774172.webp?w=719&h=360&bg=BBC5C8', NULL, NULL, NULL, NULL, '#BBC5C8');
INSERT INTO `view_type_item` VALUES (273, 212, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/79c08498f5e202ec1c5d34fdb7336801.jpg?w=360&h=360&bg=F68570', 'http://i8.mifile.cn/v1/a1/63b9b260-e7da-df82-1f8f-e1cabdd57572.webp?w=360&h=360&bg=F68570', NULL, NULL, NULL, NULL, '#F68570');
INSERT INTO `view_type_item` VALUES (274, 214, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/6aa035bb2f807b0875d5ccc8ce2ee9cc.png', 'http://i8.mifile.cn/v1/a1/34dc86f1-2cc1-4d96-ddce-d0559ccea863.webp', 00000000360, 00000000360, NULL, NULL, '#2E4272');
INSERT INTO `view_type_item` VALUES (275, 214, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d573d324a83f2eba5528b4bf2e689e53.jpg', 'http://i8.mifile.cn/v1/a1/f311f9cf-d84e-0112-5884-5dca9811d055.webp', 00000000360, 00000000360, NULL, NULL, '#9D5F77');
INSERT INTO `view_type_item` VALUES (276, 214, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/80c8f91daf0cd3d6d7e15886e0862c28.png', 'http://i8.mifile.cn/v1/a1/ab7d2180-85bf-cf88-cdf8-d6838f31df55.webp', 00000000360, 00000000360, NULL, NULL, '#CDCDD0');
INSERT INTO `view_type_item` VALUES (277, 216, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9c2649c89862239b5dba7dc4f54be075.jpg?w=1080&h=660&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9c2649c89862239b5dba7dc4f54be075.jpg?f=webp&w=1080&h=660&bg=FFFFFF', 00000001080, 00000000660, 1467, 10449, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (278, 218, 'https://i8.mifile.cn/b2c-mimall-media/ef288021164c70da7744f4f23702ed41.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ef288021164c70da7744f4f23702ed41.jpg?w=1080&h=1080', NULL, NULL, NULL, NULL, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (279, 218, 'http://i8.mifile.cn/b2c-mimall-media/320ff4db8a1712f26f394170a6600eca.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/d342ccbf-e3d6-2dcc-47a3-18656f28a0cc.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#B0AD9E');
INSERT INTO `view_type_item` VALUES (280, 219, 'https://i8.mifile.cn/b2c-mimall-media/4aa77a674400f1b836b33ba1d54a8d23.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/4aa77a674400f1b836b33ba1d54a8d23.jpg?w=1080&h=1080', NULL, NULL, NULL, NULL, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (281, 219, 'https://i8.mifile.cn/b2c-mimall-media/1dc556d954f0bf0961cb292168e48470.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/4e925115-fde0-0364-814e-34471fda46e5.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#7E7359');
INSERT INTO `view_type_item` VALUES (282, 220, 'https://i8.mifile.cn/b2c-mimall-media/7d4d94788f8591e5557a4c23c3ba4307.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/7d4d94788f8591e5557a4c23c3ba4307.jpg?w=1080&h=1080', NULL, NULL, NULL, NULL, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (283, 220, 'https://i8.mifile.cn/b2c-mimall-media/b8ef4bce02ff3fdb538fb9260a5215e2.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/9d1994f2-0dac-d9cc-5102-0b0c6752210c.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#989D7C');
INSERT INTO `view_type_item` VALUES (284, 222, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (285, 224, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/525acd604413a1c24df023133b9c0157.jpg?w=1080&h=420&bg=B6394D', 'http://i8.mifile.cn/v1/a1/f812e9c1-73f5-f70b-c3c9-a102dff47947.webp?w=1080&h=420&bg=B6394D', 00000001080, 00000000420, 1354, 10507, '#B6394D');
INSERT INTO `view_type_item` VALUES (286, 226, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/bd32b3b454f81b6ba1289a9b7581fc85.jpg?w=1080&h=660&bg=BAC8C5', 'http://i8.mifile.cn/v1/a1/2627319b-cb4c-6c13-2c96-c18286c1f34e.webp?w=1080&h=660&bg=BAC8C5', 00000001080, 00000000660, 2830, 10044, '#BAC8C5');
INSERT INTO `view_type_item` VALUES (287, 228, 'https://i8.mifile.cn/b2c-mimall-media/7d9aa23fbce666684146530e4e398e81.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/48664b4c-07bb-f276-7fbb-a79a7ddd4a7e.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#C6D6D4');
INSERT INTO `view_type_item` VALUES (288, 228, 'https://i8.mifile.cn/b2c-mimall-media/c25a2b539acb59ced3befab21852e116.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/780ebdf2-669a-923b-752d-8aecb392a08b.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#808493');
INSERT INTO `view_type_item` VALUES (289, 229, 'https://i8.mifile.cn/b2c-mimall-media/8df23b0886a4f4e484057959719ec2b7.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/93aa5dda-ae56-3dac-d19a-8fd390189216.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#94909A');
INSERT INTO `view_type_item` VALUES (290, 229, 'https://i8.mifile.cn/b2c-mimall-media/bdc93c68de77684a6d1d5237d34db1b5.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/82df8302-8625-d544-8b12-cd37c8b1dd0b.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#B0ABB3');
INSERT INTO `view_type_item` VALUES (291, 230, 'https://i8.mifile.cn/b2c-mimall-media/b22c4cc61e9bd3841e5f1e999fb9b126.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/0f5dc643-183c-5bce-8de3-0f0829e9c3d5.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#717298');
INSERT INTO `view_type_item` VALUES (292, 230, 'http://i8.mifile.cn/b2c-mimall-media/19a01dfb52bd52d9a3654eab319b457e.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/28bf863f-1c2d-52b8-a2e5-186dfcbaad1e.webp?w=1080&h=1080', NULL, NULL, NULL, NULL, '#9396B6');
INSERT INTO `view_type_item` VALUES (293, 232, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (294, 234, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9096c74a8cd13c50ad517c297695fcf6.jpg?w=1080&h=420&bg=77A6D6', 'http://i8.mifile.cn/v1/a1/2b045526-292c-4fff-b0b3-71bd9732b6e0.webp?w=1080&h=420&bg=77A6D6', 00000001080, 00000000420, 1254, 10489, '#77A6D6');
INSERT INTO `view_type_item` VALUES (295, 236, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/2503f3b2cae40266d7fac839c3427de0.jpg?f=webp', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/2503f3b2cae40266d7fac839c3427de0.jpg?f=webp', 00000001080, 00000000660, 2024, 10265, '#FFFFFF');
INSERT INTO `view_type_item` VALUES (296, 238, 'https://i8.mifile.cn/b2c-mimall-media/e8121b43506f63797ef6221b4fc7f584.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (297, 238, 'https://i8.mifile.cn/b2c-mimall-media/a6d8084b0886755e37bd80145441a4fb.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (298, 239, 'http://i8.mifile.cn/b2c-mimall-media/3c2e49a0170e20754326b246fd244d03!540x541.jpg', NULL, NULL, NULL, NULL, 3486, NULL);
INSERT INTO `view_type_item` VALUES (299, 239, 'http://i8.mifile.cn/b2c-mimall-media/7beef1188a5478cce5ccd4a642c8f3d8!540x541.jpg', NULL, NULL, NULL, NULL, 1980, NULL);
INSERT INTO `view_type_item` VALUES (300, 240, 'http://i8.mifile.cn/b2c-mimall-media/1e5e065d515ba0a0303d96740ea58494!540x541.jpg', NULL, NULL, NULL, NULL, 2415, NULL);
INSERT INTO `view_type_item` VALUES (301, 240, 'https://i8.mifile.cn/b2c-mimall-media/5c43cc667982414502dd9733dce46748.jpg', NULL, NULL, NULL, NULL, 14524, NULL);
INSERT INTO `view_type_item` VALUES (302, 242, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ec188e5e399d0b1ef5973050ad09114d.jpg?w=1080&h=420&bg=A9D2DC', 'http://i8.mifile.cn/v1/a1/ee9d8e28-915d-2b78-7f2e-af289b670513.webp?w=1080&h=420&bg=A9D2DC', 00000001080, 00000000420, 192, 10517, '#A9D2DC');
INSERT INTO `view_type_item` VALUES (303, 244, 'https://i8.mifile.cn/b2c-mimall-media/e61e45911226215cbfe00cb6ef2b8525.jpg?w=1080&h=660&bg=C6C5CF', 'http://i8.mifile.cn/v1/a1/b5ce87ca-9a5c-ddf2-c574-376ed45a9b5f.webp?w=1080&h=660&bg=C6C5CF', 00000001080, 00000000660, 13, 8601, '#C6C5CF');
INSERT INTO `view_type_item` VALUES (304, 246, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/2f87fdacc03b4ec6bfb2b30843f13e18.jpg?h=541&thumb=1&w=540', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (305, 246, 'https://i8.mifile.cn/b2c-mimall-media/3705a08c51ec6c479bf7fdc1a7c33d10.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (306, 247, 'https://i8.mifile.cn/b2c-mimall-media/75bbd0b703263ed7a67ff5ae1a59f4e8.jpg', NULL, NULL, NULL, NULL, 15738, NULL);
INSERT INTO `view_type_item` VALUES (307, 247, 'https://i8.mifile.cn/b2c-mimall-media/2ea2fa11c1e7f598d282260874eb21ad.jpg', NULL, NULL, NULL, NULL, 16047, NULL);
INSERT INTO `view_type_item` VALUES (308, 248, 'https://i8.mifile.cn/b2c-mimall-media/c1d63c6afdb8648c0d66f52ece85e514.jpg', NULL, NULL, NULL, NULL, 14429, NULL);
INSERT INTO `view_type_item` VALUES (309, 248, 'https://i8.mifile.cn/b2c-mimall-media/64b1258fa765281a216e01004b9e92ba.jpg', NULL, NULL, NULL, NULL, 17508, NULL);
INSERT INTO `view_type_item` VALUES (310, 250, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (311, 252, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/80de94b7dd3f07c6f54a310114cd7a9f.jpg?w=1080&h=420&bg=89B9F5', 'http://i8.mifile.cn/v1/a1/2dbca58d-4439-561f-8069-5663bc0e913c.webp?w=1080&h=420&bg=89B9F5', 00000001080, 00000000420, 1900, 10513, '#89B9F5');
INSERT INTO `view_type_item` VALUES (312, 254, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/a0fddc7a250e6604ea9cd704b263536d.jpg', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/a0fddc7a250e6604ea9cd704b263536d.jpg', 00000001080, 00000000660, 14, 7918, '#BCBBBA');
INSERT INTO `view_type_item` VALUES (313, 256, 'http://i8.mifile.cn/b2c-mimall-media/447f3e7cba72ee9a05520f37052d9505!540x541.jpg', NULL, NULL, NULL, NULL, 1319, NULL);
INSERT INTO `view_type_item` VALUES (314, 256, 'https://i8.mifile.cn/b2c-mimall-media/94551bea476ec7bd6f37b36b6afe1a97.jpg', NULL, NULL, NULL, NULL, 15585, NULL);
INSERT INTO `view_type_item` VALUES (315, 257, 'http://i8.mifile.cn/b2c-mimall-media/714891754ad49f0196b1d96247d59cb7!540x541.jpg', NULL, NULL, NULL, NULL, 2238, NULL);
INSERT INTO `view_type_item` VALUES (316, 257, 'https://i8.mifile.cn/b2c-mimall-media/088877469096556392d903f6cc3f3ca5.jpg', NULL, NULL, NULL, NULL, 14063, NULL);
INSERT INTO `view_type_item` VALUES (317, 258, 'http://i8.mifile.cn/b2c-mimall-media/7c0adc9810058a7719a48394cc7d252d!540x541.jpg', NULL, NULL, NULL, NULL, 1241, NULL);
INSERT INTO `view_type_item` VALUES (318, 258, 'https://i8.mifile.cn/b2c-mimall-media/b38a95198475d2c8be1e11cab147fc22.jpg', NULL, NULL, NULL, NULL, 9566, NULL);
INSERT INTO `view_type_item` VALUES (319, 260, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (320, 262, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/5c64e8d31a4be81084edd98a0cc05b10.jpg?w=1080&h=540&bg=6B6F66', 'http://i8.mifile.cn/v1/a1/b13ecaeb-526f-0098-a5f8-89f7b09e4f55.webp?w=1080&h=540&bg=6B6F66', 00000001080, 00000000540, 202, 10505, '#6B6F66');
INSERT INTO `view_type_item` VALUES (321, 263, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8b6ac3b031617d1b32ff64a9adaeae0b.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (322, 263, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c2631384946ed2d823a98d76de20b911.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (323, 263, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a3bb18fcacc2361bb4d15a10b31cb8d7.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (324, 263, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/f30ba4f04137bf177492640493fd9401.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (325, 263, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/abe84f9b97c371af8517ec5c11acc79c.jpg', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (326, 265, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/1952e16193123c1c075154aafbb33d4b.png?w=537&h=720&bg=C0A491', 'http://i8.mifile.cn/v1/a1/46c44f3e-479d-a999-dd2d-98fb39b51e17.webp?w=537&h=720&bg=C0A491', 00000000537, 00000000720, 45, 10176, '#C0A491');
INSERT INTO `view_type_item` VALUES (327, 265, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ff2370a65b84bba2dc8c93fbb8a7ad72.png?w=537&h=720&bg=E8CFCB', 'http://i8.mifile.cn/v1/a1/b79cb907-3ae4-2a35-6756-b243b386a95a.webp?w=537&h=720&bg=E8CFCB', 00000000537, 00000000720, 50, 46, '#E8CFCB');
INSERT INTO `view_type_item` VALUES (328, 267, 'http://i8.mifile.cn/b2c-mimall-media/62133edc88f785bbfcde0a30bba63a0c.jpg?w=537&h=720&bg=94979F', 'http://i8.mifile.cn/v1/a1/1a8f5c31-f50c-5be0-3df0-f2c5c839e345.webp?w=537&h=720&bg=94979F', 00000000537, 00000000720, 47, 2961, '#94979F');
INSERT INTO `view_type_item` VALUES (329, 267, 'http://i8.mifile.cn/b2c-mimall-media/6026e71efbfd9d257b8d76e348f4f9a7.jpg?w=537&h=720&bg=9BB5C4', 'http://i8.mifile.cn/v1/a1/8cfcd654-4af5-9ae6-c6cc-1ba9d28be8e8.webp?w=537&h=720&bg=9BB5C4', 00000000537, 00000000720, 48, 44, '#9BB5C4');
INSERT INTO `view_type_item` VALUES (330, 269, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f5781d83bc223151cf8b937a1e2c44ab.png?w=537&h=720&bg=D9D8C3', 'http://i8.mifile.cn/v1/a1/52866372-7fe5-76c2-29a0-9ae32d07b8ff.webp?w=537&h=720&bg=D9D8C3', 00000000537, 00000000720, 49, 10177, '#D9D8C3');
INSERT INTO `view_type_item` VALUES (331, 269, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/3a78fce15175638ac379d2764d6a57e3.jpg?w=537&h=720&bg=B4C5BB', 'http://i8.mifile.cn/v1/a1/9b87efa9-910a-1dcb-e09a-49f33b1c7655.webp?w=537&h=720&bg=B4C5BB', 00000000537, 00000000720, 46, 10178, '#B4C5BB');
INSERT INTO `view_type_item` VALUES (332, 271, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9a811f841696e4c501aa03fdd8cb4cc5.jpg?w=1080&h=420&bg=3C3A4E', 'http://i8.mifile.cn/v1/a1/028bb973-bd6f-3e29-7755-0dacfa562d1e.webp?w=1080&h=420&bg=3C3A4E', 00000001080, 00000000420, 1351, 10361, '#3C3A4E');
INSERT INTO `view_type_item` VALUES (333, 272, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e95ade2750a7fde92369b416c7d3176d.jpg?w=1080&h=180&bg=F2EFEC', 'http://i8.mifile.cn/v1/a1/452c4951-df06-f114-6c48-c5940408a905.webp?w=1080&h=180&bg=F2EFEC', 00000001080, 00000000180, 1050, 2050, '#F2EFEC');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
