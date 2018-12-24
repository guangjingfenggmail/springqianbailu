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

 Date: 24/12/2018 18:24:55
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
) ENGINE=InnoDB AUTO_INCREMENT=878 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type_action
-- ----------------------------
BEGIN;
INSERT INTO `view_type_action` VALUES (776, 786, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.live.RootFragment?pluginId=206', '{\"live_code\":\"xpzb_20181224\"}', '31apphomegallery_540001004#t=ad&act=other&page=home&page_id=6707&bid=3312428.1&adp=2682&adm=10463');
INSERT INTO `view_type_action` VALUES (777, 787, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u5723\\u8bde\\u8282\\u6d3b\\u52a8\",\"groupId\":\"\",\"extra_ver\":\"8002\"}', '31apphomegallery_540002004#t=ad&act=other&page=home&page_id=6707&bid=3312428.2&adp=2491&adm=10417');
INSERT INTO `view_type_action` VALUES (778, 788, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"6222\",\"productId\":\"6222\"}', '31apphomegallery_540003004#t=ad&act=product&page=home&pid=6222&page_id=6707&bid=3312428.3&adp=2458&adm=10447');
INSERT INTO `view_type_action` VALUES (779, 789, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.registenew.RegisteListFragment?pluginId=142', NULL, '31apphomecells_auto_fill001005#t=ad&act=other&page=home&page_id=6707&bid=3312431.1&adp=1038&adm=1844');
INSERT INTO `view_type_action` VALUES (780, 790, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.telCharge.ChargeFrgement?pluginId=122', NULL, '31apphomecells_auto_fill002005#t=ad&act=other&page=home&page_id=6707&bid=3312431.2&adp=948&adm=1845');
INSERT INTO `view_type_action` VALUES (781, 791, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.webview.RootFragment?pluginId=111', '{\"url\":\"https:\\/\\/service.10046.mi.com\\/main_home\"}', '31apphomecells_auto_fill003005#t=ad&act=webview&page=home&page_id=6707&bid=3312431.3&adp=1037&adm=1846');
INSERT INTO `view_type_action` VALUES (782, 792, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u624b\\u673a\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1800\"}', '31apphomecells_auto_fill004005#t=ad&act=other&page=home&page_id=6707&bid=3312431.4&adp=950&adm=8438');
INSERT INTO `view_type_action` VALUES (783, 793, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u3010APP\\u901a\\u7528\\u3011\\u65b0\\u54c1\\u53d1\\u5e03\\u9891\\u9053\",\"extra_ver\":\"1670\"}', '31apphomecells_auto_fill005005#t=ad&act=other&page=home&page_id=6707&bid=3312431.5&adp=951&adm=1848');
INSERT INTO `view_type_action` VALUES (784, 795, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"share_info\":{\"sina_content\":\"\\u5149\\u5927\\u94f6\\u884c\\u5c0f\\u7c73\\u8054\\u540d\\u4fe1\\u7528\\u5361\\u5f00\\u653e\\u7533\\u8bf7\\uff0c\\u5c0f\\u7c73\\u7535\\u89c6\\u5168\\u54c1\\u7c7b\\u7acb\\u51cf300\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/8b6ac3b031617d1b32ff64a9adaeae0b.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_content\":\"\\u5149\\u5927\\u94f6\\u884c\\u5c0f\\u7c73\\u8054\\u540d\\u4fe1\\u7528\\u5361\\u5f00\\u653e\\u7533\\u8bf7\\uff0c\\u5c0f\\u7c73\\u7535\\u89c6\\u5168\\u54c1\\u7c7b\\u7acb\\u51cf300\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/f132b192b490489c80d8ca798f162f77.png\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_title\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_title_sm\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_content\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/f132b192b490489c80d8ca798f162f77.png\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100988\",\"wx_timeline_title\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\",\"wx_timeline_title_sm\":\"\\u4f60\\u6709\\u4e00\\u5f20300\\u5143\\u5c0f\\u7c73\\u7535\\u89c6\\u65e0\\u5957\\u8def\\u4f18\\u60e0\\u5238\\u5f85\\u9886\\u53d6\\uff01\"},\"news_id\":\"100988\"}', '31apphomelist_broadcast001021#t=normal&act=other&page=home&page_id=6707&bid=3312436.1');
INSERT INTO `view_type_action` VALUES (785, 796, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100987\",\"share_info\":{\"sina_content\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u65b0\\u54c1\\u7c7b\\u624b\\u673a\\u53d1\\u5e03\\u4f1a\\uff0c\\u597d\\u624b\\u673a\\u81ea\\u5e26\\u6d41\\u91cf\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/c74b42b980d6f832498b6e92a0d14a7c.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100987\",\"wx_content\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u65b0\\u54c1\\u7c7b\\u624b\\u673a\\u53d1\\u5e03\\u4f1a\\uff0c\\u597d\\u624b\\u673a\\u81ea\\u5e26\\u6d41\\u91cf\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/5c1351fa9ee69da94308bb9d8360d724.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100987\",\"wx_title\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u7684\\u5c0f\\u7c73Play\\u5373\\u5c06\\u6b63\\u5f0f\\u53d1\\u5e03\",\"wx_title_sm\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u7684\\u5c0f\\u7c73Play\\u5373\\u5c06\\u6b63\\u5f0f\\u53d1\\u5e03\",\"wx_timeline_content\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u7684\\u5c0f\\u7c73Play\\u5373\\u5c06\\u6b63\\u5f0f\\u53d1\\u5e03\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/5c1351fa9ee69da94308bb9d8360d724.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100987\",\"wx_timeline_title\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u7684\\u5c0f\\u7c73Play\\u5373\\u5c06\\u6b63\\u5f0f\\u53d1\\u5e03\",\"wx_timeline_title_sm\":\"\\u4eca\\u5929\\u4e0b\\u53482\\u70b9\\uff0c\\u81ea\\u5e26\\u6d41\\u91cf\\u7684\\u5c0f\\u7c73Play\\u5373\\u5c06\\u6b63\\u5f0f\\u53d1\\u5e03\"},\"news_id\":\"100987\"}', '31apphomelist_broadcast002021#t=normal&act=other&page=home&page_id=6707&bid=3312436.2');
INSERT INTO `view_type_action` VALUES (786, 797, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"share_info\":{\"sina_content\":\"12.19-12.25\\uff0c\\u56de\\u6536\\u624b\\u673a\\u989d\\u5916\\u8d60\\u8d2d\\u65b0\\u8865\\u8d34108\\u5143\\uff0c\\u7279\\u522b\\u652f\\u6301\\u5c0f\\u7c73Play\\u6362\\u65b0\\uff01\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/c2631384946ed2d823a98d76de20b911.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_content\":\"12.19-12.25\\uff0c\\u56de\\u6536\\u624b\\u673a\\u989d\\u5916\\u8865\\u8d34108\\u5143\\uff0c\\u652f\\u6301\\u5c0f\\u7c73Play\\u6362\\u65b0\\uff01\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/268d94c2b861da93bb2bb80f73bed845.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_title\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_title_sm\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_content\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/268d94c2b861da93bb2bb80f73bed845.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100986\",\"wx_timeline_title\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\",\"wx_timeline_title_sm\":\"\\u5723\\u8bde\\u9001\\u60ca\\u559c\\uff0c\\u4ee5\\u65e7\\u6362\\u65b0\\u673a\\uff01\"},\"news_id\":\"100986\"}', '31apphomelist_broadcast003021#t=normal&act=other&page=home&page_id=6707&bid=3312436.3');
INSERT INTO `view_type_action` VALUES (787, 799, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u624b\\u673a\\u9891\\u9053-2018-\\u4e34\\u65f6\\u4e09\\u62fc\",\"groupId\":\"\",\"extra_ver\":\"8019\"}', '31apphomecells_auto_fill001025#t=ad&act=other&page=home&page_id=6707&bid=3312447.1&adp=1993&adm=10245');
INSERT INTO `view_type_action` VALUES (788, 800, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill002025#t=ad&act=other&page=home&page_id=6707&bid=3312447.2&adp=1994&adm=10132');
INSERT INTO `view_type_action` VALUES (789, 801, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12.23\\u7535\\u89c6\\u54c1\\u7c7b\\u65e5\",\"groupId\":\"\",\"extra_ver\":\"8038\"}', '31apphomecells_auto_fill003025#t=ad&act=other&page=home&page_id=6707&bid=3312447.3&adp=1995&adm=10313');
INSERT INTO `view_type_action` VALUES (790, 803, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000117\",\"productId\":\"10000117\"}', '31apphomecells_auto_fill001032#t=ad&act=product&page=home&pid=10000117&page_id=6707&bid=3312449.1&adp=392&adm=10198');
INSERT INTO `view_type_action` VALUES (791, 805, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"forceVersion\":\"27\"}', '31apphomecells_auto_fill001037#t=normal&act=other&page=home&page_id=6707&bid=3312452.1');
INSERT INTO `view_type_action` VALUES (792, 807, 'plugin', NULL, NULL, '31apphomelist_countdown001039#t=normal&act=other&page=home&page_id=6707&bid=3312454.1');
INSERT INTO `view_type_action` VALUES (793, 808, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1182600005\",\"goodsId\":\"2182600005\"}', '31activity_homeseckill#goodsid=2182600005&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.11');
INSERT INTO `view_type_action` VALUES (794, 809, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1173100005\",\"goodsId\":\"2173100001\"}', '31activity_homeseckill#goodsid=2173100001&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.12');
INSERT INTO `view_type_action` VALUES (795, 810, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1182500054\",\"goodsId\":\"2182500046\"}', '31activity_homeseckill#goodsid=2182500046&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.13');
INSERT INTO `view_type_action` VALUES (796, 811, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1165100002\",\"goodsId\":\"2165100002\"}', '31activity_homeseckill#goodsid=2165100002&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.14');
INSERT INTO `view_type_action` VALUES (797, 812, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1164800020\",\"goodsId\":\"2164800016\"}', '31activity_homeseckill#goodsid=2164800016&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.15');
INSERT INTO `view_type_action` VALUES (798, 813, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181000016\",\"goodsId\":\"2181000016\"}', '31activity_homeseckill#goodsid=2181000016&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.16');
INSERT INTO `view_type_action` VALUES (799, 814, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181000022\",\"goodsId\":\"2181000022\"}', '31activity_homeseckill#goodsid=2181000022&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.17');
INSERT INTO `view_type_action` VALUES (800, 815, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1181000017\",\"goodsId\":\"2181000017\"}', '31activity_homeseckill#goodsid=2181000017&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.18');
INSERT INTO `view_type_action` VALUES (801, 816, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1182400090\",\"goodsId\":\"2182400071\"}', '31activity_homeseckill#goodsid=2182400071&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.19');
INSERT INTO `view_type_action` VALUES (802, 817, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1171300021\",\"goodsId\":\"2171300015\"}', '31activity_homeseckill#goodsid=2171300015&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.20');
INSERT INTO `view_type_action` VALUES (803, 818, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1183700001\",\"goodsId\":\"2183700002\"}', '31activity_homeseckill#goodsid=2183700002&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.21');
INSERT INTO `view_type_action` VALUES (804, 819, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.instantpurchase.RootFragment?pluginId=156', '{\"commodityId\":\"1183700005\",\"goodsId\":\"2183700024\"}', '31activity_homeseckill#goodsid=2183700024&start_time=1545645600&end_time=1545652620&page=home&page_id=6707&bid=3312454.22');
INSERT INTO `view_type_action` VALUES (805, 821, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000103\",\"productId\":\"10000103\"}', '31apphomecells_auto_fill001045#t=ad&act=product&page=home&pid=10000103&page_id=6707&bid=3324193.1&adp=925&adm=9912');
INSERT INTO `view_type_action` VALUES (806, 823, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"10000123\",\"productId\":\"10000123\"}', '31apphomecells_auto_fill001047#t=ad&act=product&page=home&pid=10000123&page_id=6707&bid=3346141.1&adp=2038&adm=9907');
INSERT INTO `view_type_action` VALUES (807, 825, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000100\",\"goodsId\":\"\"}', '31apphomelist_two_type1001049#t=product&act=other&page=home&page_id=6707&bid=3341496.1&pid=10000100');
INSERT INTO `view_type_action` VALUES (808, 826, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000117\",\"goodsId\":\"\"}', '31apphomelist_two_type1002049#t=product&act=other&page=home&page_id=6707&bid=3341496.2&pid=10000117');
INSERT INTO `view_type_action` VALUES (809, 827, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000110\",\"goodsId\":\"\"}', '31apphomelist_two_type1001050#t=product&act=other&page=home&page_id=6707&bid=3341499.1&pid=10000110');
INSERT INTO `view_type_action` VALUES (810, 828, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000103\",\"goodsId\":\"\"}', '31apphomelist_two_type1002050#t=product&act=other&page=home&page_id=6707&bid=3341499.2&pid=10000103');
INSERT INTO `view_type_action` VALUES (811, 829, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000107\",\"goodsId\":\"\"}', '31apphomelist_two_type1001051#t=product&act=other&page=home&page_id=6707&bid=3341498.1&pid=10000107');
INSERT INTO `view_type_action` VALUES (812, 830, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000108\",\"goodsId\":\"\"}', '31apphomelist_two_type1002051#t=product&act=other&page=home&page_id=6707&bid=3341498.2&pid=10000108');
INSERT INTO `view_type_action` VALUES (813, 831, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000085\",\"goodsId\":\"\"}', '31apphomelist_two_type1001052#t=product&act=other&page=home&page_id=6707&bid=3341497.1&pid=10000085');
INSERT INTO `view_type_action` VALUES (814, 832, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000089\",\"goodsId\":\"\"}', '31apphomelist_two_type1002052#t=product&act=other&page=home&page_id=6707&bid=3341497.2&pid=10000089');
INSERT INTO `view_type_action` VALUES (815, 834, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12\\u6708\\u51c0\\u6c34\\u6d3b\\u52a8\",\"groupId\":\"\",\"extra_ver\":\"8034\"}', '31apphomecells_auto_fill001054#t=ad&act=other&page=home&page_id=6707&bid=3387953.1&adp=2873&adm=10469');
INSERT INTO `view_type_action` VALUES (816, 836, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.RootFragment?pluginId=219', NULL, '31apphomevideo_image_1_2000000#t=normal&act=other&page=home&page_id=6707&bid=3376048.1');
INSERT INTO `view_type_action` VALUES (817, 837, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.RootFragment?pluginId=219', NULL, '31apphomevideo_image_1_2000000#t=normal&act=other&page=home&page_id=6707&bid=3376048.2');
INSERT INTO `view_type_action` VALUES (818, 839, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"6\"}', '31apphomecells_auto_fill001058#t=normal&act=other&page=home&page_id=6707&bid=3376315.1');
INSERT INTO `view_type_action` VALUES (819, 840, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"2\"}', '31apphomecells_auto_fill002058#t=normal&act=other&page=home&page_id=6707&bid=3376315.2');
INSERT INTO `view_type_action` VALUES (820, 841, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.videochannel.DetailFragment?pluginId=219', '{\"video_id\":\"1\"}', '31apphomecells_auto_fill003058#t=normal&act=other&page=home&page_id=6707&bid=3376315.3');
INSERT INTO `view_type_action` VALUES (821, 843, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8111\",\"productId\":\"8111\"}', '31apphomecells_auto_fill001060#t=ad&act=product&page=home&pid=8111&page_id=6707&bid=3312466.1&adp=1467&adm=10449');
INSERT INTO `view_type_action` VALUES (822, 845, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8912\",\"goodsId\":\"\"}', '31apphomelist_two_type1001062#t=product&act=other&page=home&page_id=6707&bid=3383580.1&pid=8912');
INSERT INTO `view_type_action` VALUES (823, 846, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6222\",\"goodsId\":\"\"}', '31apphomelist_two_type1002062#t=product&act=other&page=home&page_id=6707&bid=3383580.2&pid=6222');
INSERT INTO `view_type_action` VALUES (824, 847, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8909\",\"goodsId\":\"\"}', '31apphomelist_two_type1001063#t=product&act=other&page=home&page_id=6707&bid=3383469.1&pid=8909');
INSERT INTO `view_type_action` VALUES (825, 848, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8111\",\"goodsId\":\"\"}', '31apphomelist_two_type1002063#t=product&act=other&page=home&page_id=6707&bid=3383469.2&pid=8111');
INSERT INTO `view_type_action` VALUES (826, 849, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8911\",\"goodsId\":\"\"}', '31apphomelist_two_type1001064#t=product&act=other&page=home&page_id=6707&bid=3358235.1&pid=8911');
INSERT INTO `view_type_action` VALUES (827, 850, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8041\",\"goodsId\":\"\"}', '31apphomelist_two_type1002064#t=product&act=other&page=home&page_id=6707&bid=3358235.2&pid=8041');
INSERT INTO `view_type_action` VALUES (828, 852, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"12.23\\u7535\\u89c6\\u54c1\\u7c7b\\u65e5\",\"groupId\":\"\",\"extra_ver\":\"8038\"}', '31apphomelist_action_title001066#t=normal&act=other&page=home&page_id=6707&bid=3312471.1');
INSERT INTO `view_type_action` VALUES (829, 854, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9144\",\"productId\":\"9144\"}', '31apphomecells_auto_fill001069#t=ad&act=product&page=home&pid=9144&page_id=6707&bid=3376177.1&adp=1354&adm=10416');
INSERT INTO `view_type_action` VALUES (830, 856, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"8916\",\"productId\":\"8916\"}', '31apphomecells_auto_fill001071#t=ad&act=product&page=home&pid=8916&page_id=6707&bid=3376101.1&adp=2830&adm=10044');
INSERT INTO `view_type_action` VALUES (831, 858, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8915\",\"goodsId\":\"\"}', '31apphomelist_two_type1001073#t=product&act=other&page=home&page_id=6707&bid=3364245.1&pid=8915');
INSERT INTO `view_type_action` VALUES (832, 859, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7438\",\"goodsId\":\"\"}', '31apphomelist_two_type1002073#t=product&act=other&page=home&page_id=6707&bid=3364245.2&pid=7438');
INSERT INTO `view_type_action` VALUES (833, 860, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6781\",\"goodsId\":\"\"}', '31apphomelist_two_type1001074#t=product&act=other&page=home&page_id=6707&bid=3376103.1&pid=6781');
INSERT INTO `view_type_action` VALUES (834, 861, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7866\",\"goodsId\":\"\"}', '31apphomelist_two_type1002074#t=product&act=other&page=home&page_id=6707&bid=3376103.2&pid=7866');
INSERT INTO `view_type_action` VALUES (835, 862, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8648\",\"goodsId\":\"\"}', '31apphomelist_two_type1001075#t=product&act=other&page=home&page_id=6707&bid=3376104.1&pid=8648');
INSERT INTO `view_type_action` VALUES (836, 863, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7565\",\"goodsId\":\"\"}', '31apphomelist_two_type1002075#t=product&act=other&page=home&page_id=6707&bid=3376104.2&pid=7565');
INSERT INTO `view_type_action` VALUES (837, 865, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u7b14\\u8bb0\\u672c\\u4f1a\\u573a\\u5e38\\u89c4\\u9875\\u9762\",\"groupId\":\"\",\"extra_ver\":\"7743\"}', '31apphomelist_action_title001077#t=normal&act=other&page=home&page_id=6707&bid=3376106.1');
INSERT INTO `view_type_action` VALUES (838, 867, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9114\",\"productId\":\"9114\"}', '31apphomecells_auto_fill001079#t=ad&act=product&page=home&pid=9114&page_id=6707&bid=3312484.1&adp=1254&adm=10394');
INSERT INTO `view_type_action` VALUES (839, 869, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"4348\"}', '31apphomecells_auto_fill001081#t=ad&adm=9648&adp=2024&eid=86:3:1:0:0:0:0:0:0:0&tid=adRec-78cpaAwFqwUTL0eVFuqCzg==&pid=&bid=3312475.1&page=home&page_id=6707');
INSERT INTO `view_type_action` VALUES (840, 871, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8026\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8026&page_id=');
INSERT INTO `view_type_action` VALUES (841, 872, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8634\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8634&page_id=');
INSERT INTO `view_type_action` VALUES (842, 873, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6298\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=6298&page_id=');
INSERT INTO `view_type_action` VALUES (843, 874, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7598\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=7598&page_id=');
INSERT INTO `view_type_action` VALUES (844, 875, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"6334\",\"goodsId\":\"\"}', 'recom_home-stuff_17-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=6334&page_id=');
INSERT INTO `view_type_action` VALUES (845, 876, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"5825\",\"goodsId\":\"\"}', 'recom_home-stuff_17-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=5825&page_id=');
INSERT INTO `view_type_action` VALUES (846, 878, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u4f17\\u7b79\\uff1a\\u7c73\\u5bb6\\u7535\\u6696\\u5668\\u9884\\u7ea6\\u9875\\u9762\",\"groupId\":\"\",\"extra_ver\":\"8012\"}', '31apphomecells_auto_fill001086#t=ad&act=other&page=home&page_id=6707&bid=3312464.1&adp=192&adm=10451');
INSERT INTO `view_type_action` VALUES (847, 880, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"9017\"}', '31apphomecells_auto_fill001088#t=ad&adm=10439&adp=13&eid=86:3:1:0:0:0:0:0:0:0&tid=adRec-78cpaAwFqwUTL0eVFuqCzg==&pid=&bid=3312480.1&page=home&page_id=6707');
INSERT INTO `view_type_action` VALUES (848, 882, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"9144\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=9144&page_id=');
INSERT INTO `view_type_action` VALUES (849, 883, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"9011\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=9011&page_id=');
INSERT INTO `view_type_action` VALUES (850, 884, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8760\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8760&page_id=');
INSERT INTO `view_type_action` VALUES (851, 885, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8828\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8828&page_id=');
INSERT INTO `view_type_action` VALUES (852, 886, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8871\",\"goodsId\":\"\"}', 'recom_home-stuff_12-1#eid=83:3:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8871&page_id=');
INSERT INTO `view_type_action` VALUES (853, 887, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8790\",\"goodsId\":\"\"}', 'recom_home-stuff_12-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=8790&page_id=');
INSERT INTO `view_type_action` VALUES (854, 889, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"2018\\u65b0\\u54c1\\u53d1\\u5e03\\u9891\\u9053\",\"groupId\":\"\",\"extra_ver\":\"1670\"}', '31apphomelist_action_title001092#t=normal&act=other&page=home&page_id=6707&bid=3312482.1');
INSERT INTO `view_type_action` VALUES (855, 891, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"7575\",\"productId\":\"7575\"}', '31apphomecells_auto_fill001097#t=ad&act=product&page=home&pid=7575&page_id=6707&bid=3312478.1&adp=1900&adm=10170');
INSERT INTO `view_type_action` VALUES (856, 893, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"goodsId\":\"\",\"commodityId\":\"7797\"}', '31apphomecells_auto_fill001099#t=ad&adm=9652&adp=14&eid=86:3:1:0:0:0:0:0:0:0&tid=adRec-78cpaAwFqwUTL0eVFuqCzg==&pid=&bid=3312486.1&page=home&page_id=6707');
INSERT INTO `view_type_action` VALUES (857, 895, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"10000101\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=10000101&page_id=');
INSERT INTO `view_type_action` VALUES (858, 896, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"4984\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=4984&page_id=');
INSERT INTO `view_type_action` VALUES (859, 897, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"8105\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=8105&page_id=');
INSERT INTO `view_type_action` VALUES (860, 898, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"7832\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=7832&page_id=');
INSERT INTO `view_type_action` VALUES (861, 899, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"4348\",\"goodsId\":\"\"}', 'recom_home-stuff_24-1#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.1&pid=4348&page_id=');
INSERT INTO `view_type_action` VALUES (862, 900, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.goodsdetail.GoodsDetailFragment?pluginId=101', '{\"commodityId\":\"3377\",\"goodsId\":\"\"}', 'recom_home-stuff_24-2#eid=83:2:2:0:1:0:0:0:0:0&tid=&page=home-stuff&bid=3312524.2&pid=3377&page_id=');
INSERT INTO `view_type_action` VALUES (863, 902, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"forceVersion\":\"5\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053\",\"extra_ver\":\"1801\"}', '31apphomelist_action_title001103#t=normal&act=other&page=home&page_id=6707&bid=3312488.1');
INSERT INTO `view_type_action` VALUES (864, 904, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.webview.RootFragment?pluginId=111', '{\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100975\"}', '31apphomecells_auto_fill001105#t=ad&act=webview&page=home&page_id=6707&bid=3312490.1&adp=202&adm=10389');
INSERT INTO `view_type_action` VALUES (865, 905, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u8bc4\\u4ef7\\u6652\\u56fe\\u53c2\\u4e0e\\u9001\\u8c6a\\u793c\\u6d3b\\u52a8\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/1836f01bd97fee82694b43af41f1a59e.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100969\",\"wx_content\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u8bc4\\u4ef7\\u6652\\u56fe\\u53c2\\u4e0e\\u9001\\u8c6a\\u793c\\u6d3b\\u52a8\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/5f3ec9bfc6dd7694674078e37187ea4b.png\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100969\",\"wx_title\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u4e13\\u4eab\\u798f\\u5229\",\"wx_title_sm\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u4e13\\u4eab\\u798f\\u5229\",\"wx_timeline_content\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u4e13\\u4eab\\u798f\\u5229\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/5f3ec9bfc6dd7694674078e37187ea4b.png\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100969\",\"wx_timeline_title\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u4e13\\u4eab\\u798f\\u5229\",\"wx_timeline_title_sm\":\"\\u7c73\\u5bb6\\u65b0\\u98ce\\u673a\\u7528\\u6237\\u4e13\\u4eab\\u798f\\u5229\"},\"news_id\":\"100969\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100969&needValidHost=false\"}', '31apphomehorizontal_scroll_view001106#t=normal&act=other&page=home&page_id=6707&bid=3312491.1');
INSERT INTO `view_type_action` VALUES (866, 906, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u5173\\u6ce8\\u201c\\u5c0f\\u7c73\\u7c73\\u7c89\\u4e4b\\u5bb6\\u201d\\u516c\\u4f17\\u53f7\\uff0c\\u56de\\u590d\\u201c\\u6545\\u5bab\\u7248\\u201d\\uff0c\\u8d62\\u53d6\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/a3bb18fcacc2361bb4d15a10b31cb8d7.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_content\":\"\\u5173\\u6ce8\\u201c\\u5c0f\\u7c73\\u7c73\\u7c89\\u4e4b\\u5bb6\\u201d\\u516c\\u4f17\\u53f7\\uff0c\\u56de\\u590d\\u201c\\u6545\\u5bab\\u7248\\u201d\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/542dcb5802b07970078798159cf328c0.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_title\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_title_sm\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_content\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/542dcb5802b07970078798159cf328c0.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968\",\"wx_timeline_title\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\",\"wx_timeline_title_sm\":\"\\u798f\\u5229\\u6765\\u4e86\\uff01\\u6765\\u8fd9\\u91cc\\u8d62\\u53d6\\u4f60\\u7684\\u5c0f\\u7c73MIX 3\\u6545\\u5bab\\u7279\\u522b\\u7248F\\u7801\\uff01\"},\"news_id\":\"100968\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100968&needValidHost=false\"}', '31apphomehorizontal_scroll_view002106#t=normal&act=other&page=home&page_id=6707&bid=3312491.2');
INSERT INTO `view_type_action` VALUES (867, 907, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\\u5c0f\\u7c73\\u5546\\u57ce\\u73b0\\u5f00\\u542f\\u9884\\u7ea6\\uff0c\\u5feb\\u6765\\u4e00\\u5c55\\u6b4c\\u5589\\u5427\\uff01\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/32e2004ae7a3b20f574aea13a68e207b.jpg\",\"sina_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100967\",\"wx_content\":\"\\u201c\\u4eea\\u201d\\u5e45\\u8033\\u673a\\u00b7\\u987d\\u97f3\\u7cfb\\u5217\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/ecb49dc4858f73f17ebb6c382a491ea1.jpg\",\"wx_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100967\",\"wx_title\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\",\"wx_title_sm\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\",\"wx_timeline_content\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/ecb49dc4858f73f17ebb6c382a491ea1.jpg\",\"wx_timeline_link\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100967\",\"wx_timeline_title\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\",\"wx_timeline_title_sm\":\"\\u4e0a\\u65b0\\u5566\\uff01\\u5c0f\\u7c73\\u84dd\\u7259K\\u6b4c\\u8033\\u673a\\u6545\\u5bab\\u7279\\u522b\\u7248\\u6765\\u4e86~\"},\"news_id\":\"100967\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100967&needValidHost=false\"}', '31apphomehorizontal_scroll_view003106#t=normal&act=other&page=home&page_id=6707&bid=3312491.3');
INSERT INTO `view_type_action` VALUES (868, 908, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.WebFragment?pluginId=150', '{\"open_type\":\"article_v2\",\"share_info\":{\"sina_content\":\"\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\u4f7f\\u7528\\u8bc4\\u6d4b\\uff0c\\u6ee1\\u6ee1\\u4e00\\u7f50\\u5b50\\u67d4\\u5149\\uff0c\\u4f53\\u9a8c\\u5347\\u7ea7\",\"sina_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/d85ec2768bfaaa782fea30e8177203e7.jpg\",\"sina_link\":\"https:\\/\\/b.d.mi.com\\/content\\/content\\/editArticle?id=100965\",\"wx_content\":\"\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\u4f7f\\u7528\\u8bc4\\u6d4b\\uff0c\\u6ee1\\u6ee1\\u4e00\\u7f50\\u5b50\\u67d4\\u5149\\uff0c\\u4f53\\u9a8c\\u5347\\u7ea7\",\"wx_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/720fe9bea9086ec825d87bc3dcd5489c.jpg\",\"wx_link\":\"https:\\/\\/b.d.mi.com\\/content\\/content\\/editArticle?id=100965\",\"wx_title\":\"\\u300c\\u65b0\\u54c1\\u6d4b\\u8bc4\\u300d\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\uff1a\\u7ed9\\u4f60\\u201c\\u8be5\\u6b7b\\u7684\\u201d\\u6e29\\u67d4\",\"wx_title_sm\":\"\\u300c\\u65b0\\u54c1\\u6d4b\\u8bc4\\u300d\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\uff1a\\u7ed9\\u4f60\\u201c\\u8be5\\u6b7b\\u7684\\u201d\\u6e29\\u67d4\",\"wx_timeline_content\":\"\\u300c\\u65b0\\u54c1\\u6d4b\\u8bc4\\u300d\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\uff1a\\u7ed9\\u4f60\\u201c\\u8be5\\u6b7b\\u7684\\u201d\\u6e29\\u67d4\",\"wx_timeline_img\":\"https:\\/\\/cdn.cnbj1.fds.api.mi-img.com\\/mi-mall\\/720fe9bea9086ec825d87bc3dcd5489c.jpg\",\"wx_timeline_link\":\"https:\\/\\/b.d.mi.com\\/content\\/content\\/editArticle?id=100965\",\"wx_timeline_title\":\"\\u300c\\u65b0\\u54c1\\u6d4b\\u8bc4\\u300d\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\uff1a\\u7ed9\\u4f60\\u201c\\u8be5\\u6b7b\\u7684\\u201d\\u6e29\\u67d4\",\"wx_timeline_title_sm\":\"\\u300c\\u65b0\\u54c1\\u6d4b\\u8bc4\\u300d\\u7c73\\u5bb6\\u5e8a\\u5934\\u706f2\\uff1a\\u7ed9\\u4f60\\u201c\\u8be5\\u6b7b\\u7684\\u201d\\u6e29\\u67d4\"},\"news_id\":\"100965\",\"url\":\"https:\\/\\/s1.mi.com\\/m\\/shopnews\\/?nid=100965&needValidHost=false\"}', '31apphomehorizontal_scroll_view004106#t=normal&act=other&page=home&page_id=6707&bid=3312491.4');
INSERT INTO `view_type_action` VALUES (869, 909, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.channel.ui.RootFragment?pluginId=150', NULL, '31apphomehorizontal_scroll_view005106#t=normal&act=other&page=home&page_id=6707&bid=3312491.5');
INSERT INTO `view_type_action` VALUES (870, 911, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u7b14\\u8bb0\\u672c\\u4f1a\\u573a\\u5e38\\u89c4\\u9875\\u9762\",\"groupId\":\"\",\"extra_ver\":\"7743\"}', '31apphomecells_auto_fill001108#t=ad&act=other&page=home&page_id=6707&bid=3312493.1&adp=45&adm=10176');
INSERT INTO `view_type_action` VALUES (871, 912, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.productchannel.ui.RootFragment?pluginId=15101', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u65e7-\\u667a\\u80fd\\u9891\\u9053\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill002108#t=ad&act=channel&page=home&page_id=6707&bid=3312493.2&adp=50&adm=46');
INSERT INTO `view_type_action` VALUES (872, 914, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u751f\\u6d3b\\u5468\\u8fb9-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1799\"}', '31apphomecells_auto_fill001110#t=ad&act=other&page=home&page_id=6707&bid=3312495.1&adp=47&adm=2961');
INSERT INTO `view_type_action` VALUES (873, 915, 'plugin', 'ShopPlugin://com.xiaomi.shop.plugin.productchannel.ui.RootFragment?pluginId=15101', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_ver\":\"19\",\"extra_title\":\"\\u97f3\\u4e50\\u53d1\\u70e7\"}', '31apphomecells_auto_fill002110#t=ad&act=channel&page=home&page_id=6707&bid=3312495.2&adp=48&adm=44');
INSERT INTO `view_type_action` VALUES (874, 917, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/recommendChannel\",\"extra_title\":\"\\u667a\\u80fd\\u9891\\u9053-\\u65e7\",\"groupId\":\"\",\"extra_ver\":\"1801\"}', '31apphomecells_auto_fill001112#t=ad&act=other&page=home&page_id=6707&bid=3312497.1&adp=49&adm=10177');
INSERT INTO `view_type_action` VALUES (875, 918, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u5c0f\\u7c73\\u751f\\u6001\\u94fe\\u4ea7\\u54c1\\u65e5\\u672c\\u4f18\\u826f\\u8bbe\\u8ba1\\u5956\",\"groupId\":\"\",\"extra_ver\":\"7285\"}', '31apphomecells_auto_fill002112#t=ad&act=other&page=home&page_id=6707&bid=3312497.2&adp=46&adm=10178');
INSERT INTO `view_type_action` VALUES (876, 920, 'plugin', 'ShopPlugin://com.xiaomi.shop2.plugin.hdchannel.RootFragment?pluginId=15102', '{\"extra_url\":\"http:\\/\\/api.m.mi.com\\/v1\\/home\\/activity_page\",\"extra_title\":\"\\u795e\\u79d8\\u65b0\\u54c1\\u8033\\u673a\",\"groupId\":\"\",\"extra_ver\":\"7973\"}', '31apphomecells_auto_fill001114#t=ad&act=other&page=home&page_id=6707&bid=3312499.1&adp=1351&adm=10361');
INSERT INTO `view_type_action` VALUES (877, 921, 'plugin', NULL, NULL, '31apphomecells_auto_fill001115#t=ad&act=other&page=home&page_id=6707&bid=3312500.1&adp=1050&adm=2050');
COMMIT;

-- ----------------------------
-- Table structure for view_type_item
-- ----------------------------
DROP TABLE IF EXISTS `view_type_item`;
CREATE TABLE `view_type_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sections_index` int(11) DEFAULT NULL,
  `img_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img_url_webp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img_url_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `w` int(11) unsigned zerofill DEFAULT NULL,
  `h` int(11) unsigned zerofill DEFAULT NULL,
  `ad_position_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  `view_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stat` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `line_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `line_height` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title_logo_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=922 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of view_type_item
-- ----------------------------
BEGIN;
INSERT INTO `view_type_item` VALUES (786, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/55e03c3e2f8b57d7fafc3e7e771e649b.jpg?w=1080&h=540&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/55e03c3e2f8b57d7fafc3e7e771e649b.jpg?f=webp&w=1080&h=540&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000540, 2682, 10463, 'gallery_540', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (787, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/ec07009535108a586d8e7d4d7fe96262.jpg?w=1080&h=540&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/ec07009535108a586d8e7d4d7fe96262.jpg?f=webp&w=1080&h=540&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000540, 2491, 10417, 'gallery_540', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (788, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/56617622c3f2d449a4d13ce4cd71b2ee.jpg?w=1080&h=540&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/56617622c3f2d449a4d13ce4cd71b2ee.jpg?f=webp&w=1080&h=540&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000540, 2458, 10447, 'gallery_540', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (789, NULL, 'http://i8.mifile.cn/b2c-mimall-media/e81e39c975bb6becee0b287d5034f882.png?w=216&h=228&bg=FCF0F0', 'http://i8.mifile.cn/v1/a1/59c9e9b7-a2d0-e3e7-68c6-231cd05d7c97.webp?w=216&h=228&bg=FCF0F0', '#FCF0F0', 00000000216, 00000000228, 1038, 1844, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (790, NULL, 'http://i8.mifile.cn/b2c-mimall-media/d92242558664461f8f7c17b7fc663df3.png?w=216&h=228&bg=FBF3E1', 'http://i8.mifile.cn/v1/a1/34e14274-f1ee-b6bd-86cb-f858c50cab70.webp?w=216&h=228&bg=FBF3E1', '#FBF3E1', 00000000216, 00000000228, 948, 1845, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (791, NULL, 'https://i8.mifile.cn/b2c-mimall-media/b30bbe16513d09653d73036287e6e5ba.png?w=216&h=228&bg=FFFFFF', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b30bbe16513d09653d73036287e6e5ba.png?w=216&h=228&bg=FFFFFF', '#FFFFFF', 00000000216, 00000000228, 1037, 1846, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (792, NULL, 'https://i8.mifile.cn/b2c-mimall-media/ca760df21f9a89ff337568fc703a4b89.jpg?w=216&h=228&bg=FFFFFF', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ca760df21f9a89ff337568fc703a4b89.jpg?w=216&h=228&bg=FFFFFF', '#FFFFFF', 00000000216, 00000000228, 950, 8438, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (793, NULL, 'http://i8.mifile.cn/b2c-mimall-media/6db24cff2bf2080a230e1e108c2516fd.png?w=216&h=228&bg=F7F4FB', 'http://i8.mifile.cn/v1/a1/bc5de799-0048-96ec-fa94-e04a2604eee1.webp?w=216&h=228&bg=F7F4FB', '#F7F4FB', 00000000216, 00000000228, 951, 1848, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (794, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (795, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_broadcast', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (796, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_broadcast', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (797, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_broadcast', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (798, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (799, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d32a72e7773ff324440be8cad8a7c001.jpg?w=537&h=762&bg=8595A7', 'http://i8.mifile.cn/v1/a1/2bcfae43-5b1b-b44d-567c-b9528983f278.webp?w=537&h=762&bg=8595A7', '#8595A7', 00000000537, 00000000762, 1993, 10245, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (800, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/af7beea6025f7bedfc0b73262d88b8c9.jpg?w=537&h=378&bg=D4D3B8', 'http://i8.mifile.cn/v1/a1/e4db2c88-59bb-7ed2-81f6-a42419857ae4.webp?w=537&h=378&bg=D4D3B8', '#D4D3B8', 00000000537, 00000000378, 1994, 10132, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (801, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c84a1148f3c3ee3317dfc996d32f02a0.jpg?w=537&h=378&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c84a1148f3c3ee3317dfc996d32f02a0.jpg?f=webp&w=537&h=378&bg=FFFFFF', '#FFFFFF', 00000000537, 00000000378, 1995, 10313, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (802, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (803, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/810c3115dfd8a31becf561c1b28b1d91.jpg?w=1080&h=420&bg=76ABD9', 'http://i8.mifile.cn/v1/a1/e896f1d0-708e-6e13-f9b8-e4d7f0e19c03.webp?w=1080&h=420&bg=76ABD9', '#76ABD9', 00000001080, 00000000420, 392, 10198, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (804, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (805, NULL, 'http://i8.mifile.cn/b2c-mimall-media/be0fa28c1cc3183a71200ace08c6649d.jpg', 'http://i8.mifile.cn/v1/a1/db943e55-933b-124b-adcb-e20907712c54.webp', '#EFEFEF', 00000001080, 00000000230, NULL, NULL, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (806, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (807, NULL, 'http://i8.mifile.cn/b2c-mimall-media/ad5f991fdf1ad821bdc871d918ba8d90.jpg?w=1080&h=120&bg=FFFFFF', 'http://i8.mifile.cn/v1/a1/df8aeaf5-0b88-e171-9dc4-d38cc5ed3f27.webp?w=1080&h=120&bg=FFFFFF', '#FFFFFF', NULL, NULL, NULL, NULL, 'list_countdown', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (808, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/cca3f6a51f38d4de9b458303206996ad.png', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (809, NULL, 'https://i8.mifile.cn/b2c-mimall-media/815b80f26a127a9369995b1b73640037.png', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (810, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d69e7a884514d139b06e0af6f9ced673.png', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (811, NULL, 'https://i8.mifile.cn/b2c-mimall-media/2de973ab0e00cc3fa38148c994e1833a.png', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (812, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b8faa70c44238b8bb4aefd7f9bdcf858.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (813, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d7239eaa8c92605a2af6d59f9e2ad433.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (814, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/fb4a5925027a3ba86ad01feeba40d049.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (815, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/273ec6cf75cb260b7c2cdb3b15a4cee9.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (816, NULL, 'https://i8.mifile.cn/b2c-mimall-media/329aff51bf0def82a60ed1dc740587ac.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (817, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/8f1e1ba785cb57a1131861e5b57ab685.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (818, NULL, 'https://i8.mifile.cn/b2c-mimall-media/e300c59b7b6a8a55cf4d182bb1dfa4aa.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (819, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f25f1575326928974ce19eca26f6a2e3.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_recycler_list_goods', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (820, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (821, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/419a895a91795349ee1a90573e8e27bd.jpg?w=1080&h=420&bg=C4B2CB', 'http://i8.mifile.cn/v1/a1/54120c8b-1e76-6167-a831-1f34dba5aae7.webp?w=1080&h=420&bg=C4B2CB', '#C4B2CB', 00000001080, 00000000420, 925, 9912, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (822, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (823, NULL, 'https://i8.mifile.cn/b2c-mimall-media/275bfbc75e99991d64c18aacb058c935.jpg?w=1080&h=660&bg=A4ABB6', 'http://i8.mifile.cn/v1/a1/bba91c48-9f67-3dd7-41d7-313ab4bfc635.webp?w=1080&h=660&bg=A4ABB6', '#A4ABB6', 00000001080, 00000000660, 2038, 9907, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (824, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (825, NULL, 'https://i8.mifile.cn/b2c-mimall-media/fb3fc5df8e762c4a96f0cdd59670070c.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/a14a8cc3-3f47-3224-d221-8ff8485d624d.webp?w=1080&h=1080', '#A18390', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (826, NULL, 'https://i8.mifile.cn/b2c-mimall-media/6c9d4031099deb5fc28ec57ac730df96.jpg', 'http://i8.mifile.cn/v1/a1/1c3e0097-73a6-1788-96f7-2cdb58d82ba1.webp', '#9395BA', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (827, NULL, 'https://i8.mifile.cn/b2c-mimall-media/f1d7a0a4ba2c713b29fefa6ad26abe55.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/2c506517-9477-c928-8e77-bee18b6818a1.webp?w=1080&h=1080', '#E2B7AE', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (828, NULL, 'https://i8.mifile.cn/b2c-mimall-media/98b3aaf7fd30a6b7164de67e837ab619.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/a081da10-3758-e051-7a20-0de017f37476.webp?w=1080&h=1080', '#C1A1A8', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (829, NULL, 'https://i8.mifile.cn/b2c-mimall-media/e8461f6647dcbae7617b7783bd85396d.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/dbf22834-b9e2-d453-24a8-1a4f7e7dc702.webp?w=1080&h=1080', '#C8B3BB', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (830, NULL, 'https://i8.mifile.cn/b2c-mimall-media/c0bee80d76b0d3da60013c86a8e773ca.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/685330bb-cb82-c3c3-e3cf-106c9b9a70e6.webp?w=1080&h=1080', '#7F8B90', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (831, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/0a465c4bc19e91943150af2a33cea923.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/0662d5df-7467-da18-1d6d-0b3c10409719.webp?w=1080&h=1080', '#BAA8A8', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (832, NULL, 'https://i8.mifile.cn/b2c-mimall-media/ee44583e8167f3d250186069a26c1384.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/b14ddefc-9165-57aa-8d61-d70c6db4e2a0.webp?w=1080&h=1080', '#646665', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (833, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (834, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d70f36018126cda5326d30177ac413f7.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d70f36018126cda5326d30177ac413f7.jpg?f=webp&w=1080&h=420&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000420, 2873, 10469, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (835, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (836, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/06098d1f17e0f82302922ddc2aaad974.jpg?w=719&h=360&bg=BBC5C8', 'http://i8.mifile.cn/v1/a1/0e226392-229c-f100-2372-ded296774172.webp?w=719&h=360&bg=BBC5C8', '#BBC5C8', NULL, NULL, NULL, NULL, 'video_image_1_2', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (837, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/79c08498f5e202ec1c5d34fdb7336801.jpg?w=360&h=360&bg=F68570', 'http://i8.mifile.cn/v1/a1/63b9b260-e7da-df82-1f8f-e1cabdd57572.webp?w=360&h=360&bg=F68570', '#F68570', NULL, NULL, NULL, NULL, 'video_image_1_2', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (838, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '1', NULL);
INSERT INTO `view_type_item` VALUES (839, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/6aa035bb2f807b0875d5ccc8ce2ee9cc.png', 'http://i8.mifile.cn/v1/a1/34dc86f1-2cc1-4d96-ddce-d0559ccea863.webp', '#2E4272', 00000000360, 00000000360, NULL, NULL, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (840, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d573d324a83f2eba5528b4bf2e689e53.jpg', 'http://i8.mifile.cn/v1/a1/f311f9cf-d84e-0112-5884-5dca9811d055.webp', '#9D5F77', 00000000360, 00000000360, NULL, NULL, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (841, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/80c8f91daf0cd3d6d7e15886e0862c28.png', 'http://i8.mifile.cn/v1/a1/ab7d2180-85bf-cf88-cdf8-d6838f31df55.webp', '#CDCDD0', 00000000360, 00000000360, NULL, NULL, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (842, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (843, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9c2649c89862239b5dba7dc4f54be075.jpg?w=1080&h=660&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9c2649c89862239b5dba7dc4f54be075.jpg?f=webp&w=1080&h=660&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000660, 1467, 10449, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (844, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (845, NULL, 'https://i8.mifile.cn/b2c-mimall-media/ef288021164c70da7744f4f23702ed41.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ef288021164c70da7744f4f23702ed41.jpg?w=1080&h=1080', '#FFFFFF', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (846, NULL, 'http://i8.mifile.cn/b2c-mimall-media/320ff4db8a1712f26f394170a6600eca.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/d342ccbf-e3d6-2dcc-47a3-18656f28a0cc.webp?w=1080&h=1080', '#B0AD9E', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (847, NULL, 'https://i8.mifile.cn/b2c-mimall-media/4aa77a674400f1b836b33ba1d54a8d23.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/4aa77a674400f1b836b33ba1d54a8d23.jpg?w=1080&h=1080', '#FFFFFF', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (848, NULL, 'https://i8.mifile.cn/b2c-mimall-media/1dc556d954f0bf0961cb292168e48470.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/4e925115-fde0-0364-814e-34471fda46e5.webp?w=1080&h=1080', '#7E7359', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (849, NULL, 'https://i8.mifile.cn/b2c-mimall-media/7d4d94788f8591e5557a4c23c3ba4307.jpg?w=1080&h=1080', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/7d4d94788f8591e5557a4c23c3ba4307.jpg?w=1080&h=1080', '#FFFFFF', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (850, NULL, 'https://i8.mifile.cn/b2c-mimall-media/b8ef4bce02ff3fdb538fb9260a5215e2.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/9d1994f2-0dac-d9cc-5102-0b0c6752210c.webp?w=1080&h=1080', '#989D7C', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (851, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (852, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_action_title', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (853, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (854, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/23eb03e52fca670287d93febd358c073.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/23eb03e52fca670287d93febd358c073.jpg?f=webp&w=1080&h=420&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000420, 1354, 10416, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (855, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (856, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/bd32b3b454f81b6ba1289a9b7581fc85.jpg?w=1080&h=660&bg=BAC8C5', 'http://i8.mifile.cn/v1/a1/2627319b-cb4c-6c13-2c96-c18286c1f34e.webp?w=1080&h=660&bg=BAC8C5', '#BAC8C5', 00000001080, 00000000660, 2830, 10044, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (857, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (858, NULL, 'https://i8.mifile.cn/b2c-mimall-media/7d9aa23fbce666684146530e4e398e81.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/48664b4c-07bb-f276-7fbb-a79a7ddd4a7e.webp?w=1080&h=1080', '#C6D6D4', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (859, NULL, 'https://i8.mifile.cn/b2c-mimall-media/c25a2b539acb59ced3befab21852e116.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/780ebdf2-669a-923b-752d-8aecb392a08b.webp?w=1080&h=1080', '#808493', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (860, NULL, 'https://i8.mifile.cn/b2c-mimall-media/8df23b0886a4f4e484057959719ec2b7.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/93aa5dda-ae56-3dac-d19a-8fd390189216.webp?w=1080&h=1080', '#94909A', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (861, NULL, 'https://i8.mifile.cn/b2c-mimall-media/bdc93c68de77684a6d1d5237d34db1b5.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/82df8302-8625-d544-8b12-cd37c8b1dd0b.webp?w=1080&h=1080', '#B0ABB3', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (862, NULL, 'https://i8.mifile.cn/b2c-mimall-media/b22c4cc61e9bd3841e5f1e999fb9b126.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/0f5dc643-183c-5bce-8de3-0f0829e9c3d5.webp?w=1080&h=1080', '#717298', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (863, NULL, 'http://i8.mifile.cn/b2c-mimall-media/19a01dfb52bd52d9a3654eab319b457e.jpg?w=1080&h=1080', 'http://i8.mifile.cn/v1/a1/28bf863f-1c2d-52b8-a2e5-186dfcbaad1e.webp?w=1080&h=1080', '#9396B6', NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (864, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (865, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_action_title', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (866, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (867, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b494a58694a82ea2f842d549f87ead38.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b494a58694a82ea2f842d549f87ead38.jpg?f=webp&w=1080&h=420&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000420, 1254, 10394, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (868, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (869, NULL, 'http://i8.mifile.cn/v1/a1/0d168fda-51c7-8d8d-7f2b-7a0f977e461d.webp', 'http://i8.mifile.cn/v1/a1/0d168fda-51c7-8d8d-7f2b-7a0f977e461d.webp', '#FFFFFF', 00000001080, 00000000660, 2024, 9648, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (870, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (871, NULL, 'https://i8.mifile.cn/b2c-mimall-media/e8121b43506f63797ef6221b4fc7f584.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (872, NULL, 'https://i8.mifile.cn/b2c-mimall-media/a6d8084b0886755e37bd80145441a4fb.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (873, NULL, 'http://i8.mifile.cn/b2c-mimall-media/e9e5e8fb9e0b5d16a52df672861be5af!540x541.png', NULL, NULL, NULL, NULL, NULL, 2385, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (874, NULL, 'http://i8.mifile.cn/b2c-mimall-media/e2050a5be7fcdb5d992edfe1ef509cd6!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 8235, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (875, NULL, 'http://i8.mifile.cn/b2c-mimall-media/1e5e065d515ba0a0303d96740ea58494!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 2415, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (876, NULL, 'http://i8.mifile.cn/b2c-mimall-media/7beef1188a5478cce5ccd4a642c8f3d8!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 1980, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (877, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (878, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/28903039e52b9c794fa82072441346f2.jpg?w=1080&h=420&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/28903039e52b9c794fa82072441346f2.jpg?f=webp&w=1080&h=420&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000420, 192, 10451, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (879, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (880, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d9954268d91618ff3267e7b323b6f58d.jpg?f=webp', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d9954268d91618ff3267e7b323b6f58d.jpg?f=webp', '#C6C5CF', 00000001080, 00000000660, 13, 10439, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (881, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (882, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/2f87fdacc03b4ec6bfb2b30843f13e18.jpg?h=541&thumb=1&w=540', NULL, NULL, NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (883, NULL, 'https://i8.mifile.cn/b2c-mimall-media/3705a08c51ec6c479bf7fdc1a7c33d10.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (884, NULL, 'https://i8.mifile.cn/b2c-mimall-media/75bbd0b703263ed7a67ff5ae1a59f4e8.jpg', NULL, NULL, NULL, NULL, NULL, 15738, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (885, NULL, 'https://i8.mifile.cn/b2c-mimall-media/54e5ce47cff6ae5ffa6a34abc4b90438.jpg', NULL, NULL, NULL, NULL, NULL, 16206, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (886, NULL, 'https://i8.mifile.cn/b2c-mimall-media/875a44fb67f2de5e7bf552cbd20264a7.jpg', NULL, NULL, NULL, NULL, NULL, 16926, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (887, NULL, 'https://i8.mifile.cn/b2c-mimall-media/9cd4036dff192ee9a5f0c10dd9776ebd.jpg', NULL, NULL, NULL, NULL, NULL, 16239, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (888, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (889, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_action_title', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (890, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (891, NULL, 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/653769c174654a39eb4bd4cd63ba0cc9.jpg?w=1080&h=420&bg=B5CAD5', 'http://i8.mifile.cn/v1/a1/3dcd9ab1-18a8-7717-e16f-c8c519e930d7.webp?w=1080&h=420&bg=B5CAD5', '#B5CAD5', 00000001080, 00000000420, 1900, 10170, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (892, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (893, NULL, 'http://i8.mifile.cn/v1/a1/a9c1fab9-16e8-68ca-51b4-0b6b3f0c7cb8.webp', 'http://i8.mifile.cn/v1/a1/a9c1fab9-16e8-68ca-51b4-0b6b3f0c7cb8.webp', '#BCBBBA', 00000001080, 00000000660, 14, 9652, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (894, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#ffffff', '10', NULL);
INSERT INTO `view_type_item` VALUES (895, NULL, 'https://i8.mifile.cn/b2c-mimall-media/e8bb9149f581b54ef7d9121217f56717.jpg', NULL, NULL, NULL, NULL, NULL, 12547, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (896, NULL, 'http://i8.mifile.cn/b2c-mimall-media/26569c7e152d8977492ecd94a5d63925!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 1215, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (897, NULL, 'https://i8.mifile.cn/b2c-mimall-media/ffe8610a808d8254fb5d37b141d0bf5f.jpg', NULL, NULL, NULL, NULL, NULL, 11740, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (898, NULL, 'https://i8.mifile.cn/b2c-mimall-media/67b72f719a7832c34d095f0fe57014b8.png', NULL, NULL, NULL, NULL, NULL, 9321, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (899, NULL, 'http://i8.mifile.cn/b2c-mimall-media/88caa88b73ca4aaeb5f5b1c6609574cc!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 782, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (900, NULL, 'http://i8.mifile.cn/b2c-mimall-media/b27deb71a5f9bc06617fb8f4d52cb9e8!540x541.jpg', NULL, NULL, NULL, NULL, NULL, 349, 'list_two_type1', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (901, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#cecece', '1', NULL);
INSERT INTO `view_type_item` VALUES (902, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'list_action_title', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (903, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (904, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/bbb247e594ca223828db3c2730b64863.jpg?w=1080&h=540&bg=FFFFFF', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/bbb247e594ca223828db3c2730b64863.jpg?f=webp&w=1080&h=540&bg=FFFFFF', '#FFFFFF', 00000001080, 00000000540, 202, 10389, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (905, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/1836f01bd97fee82694b43af41f1a59e.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_scroll_view', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (906, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a3bb18fcacc2361bb4d15a10b31cb8d7.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_scroll_view', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (907, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/32e2004ae7a3b20f574aea13a68e207b.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_scroll_view', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (908, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d85ec2768bfaaa782fea30e8177203e7.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_scroll_view', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (909, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/abe84f9b97c371af8517ec5c11acc79c.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'horizontal_scroll_view', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (910, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (911, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/1952e16193123c1c075154aafbb33d4b.png?w=537&h=720&bg=C0A491', 'http://i8.mifile.cn/v1/a1/46c44f3e-479d-a999-dd2d-98fb39b51e17.webp?w=537&h=720&bg=C0A491', '#C0A491', 00000000537, 00000000720, 45, 10176, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (912, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/ff2370a65b84bba2dc8c93fbb8a7ad72.png?w=537&h=720&bg=E8CFCB', 'http://i8.mifile.cn/v1/a1/b79cb907-3ae4-2a35-6756-b243b386a95a.webp?w=537&h=720&bg=E8CFCB', '#E8CFCB', 00000000537, 00000000720, 50, 46, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (913, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '6', NULL);
INSERT INTO `view_type_item` VALUES (914, NULL, 'http://i8.mifile.cn/b2c-mimall-media/62133edc88f785bbfcde0a30bba63a0c.jpg?w=537&h=720&bg=94979F', 'http://i8.mifile.cn/v1/a1/1a8f5c31-f50c-5be0-3df0-f2c5c839e345.webp?w=537&h=720&bg=94979F', '#94979F', 00000000537, 00000000720, 47, 2961, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (915, NULL, 'http://i8.mifile.cn/b2c-mimall-media/6026e71efbfd9d257b8d76e348f4f9a7.jpg?w=537&h=720&bg=9BB5C4', 'http://i8.mifile.cn/v1/a1/8cfcd654-4af5-9ae6-c6cc-1ba9d28be8e8.webp?w=537&h=720&bg=9BB5C4', '#9BB5C4', 00000000537, 00000000720, 48, 44, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (916, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '6', NULL);
INSERT INTO `view_type_item` VALUES (917, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f5781d83bc223151cf8b937a1e2c44ab.png?w=537&h=720&bg=D9D8C3', 'http://i8.mifile.cn/v1/a1/52866372-7fe5-76c2-29a0-9ae32d07b8ff.webp?w=537&h=720&bg=D9D8C3', '#D9D8C3', 00000000537, 00000000720, 49, 10177, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (918, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/3a78fce15175638ac379d2764d6a57e3.jpg?w=537&h=720&bg=B4C5BB', 'http://i8.mifile.cn/v1/a1/9b87efa9-910a-1dcb-e09a-49f33b1c7655.webp?w=537&h=720&bg=B4C5BB', '#B4C5BB', 00000000537, 00000000720, 46, 10178, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (919, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'divider_line', NULL, '#f5f5f5', '24', NULL);
INSERT INTO `view_type_item` VALUES (920, NULL, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9a811f841696e4c501aa03fdd8cb4cc5.jpg?w=1080&h=420&bg=3C3A4E', 'http://i8.mifile.cn/v1/a1/028bb973-bd6f-3e29-7755-0dacfa562d1e.webp?w=1080&h=420&bg=3C3A4E', '#3C3A4E', 00000001080, 00000000420, 1351, 10361, 'cells_auto_fill', NULL, NULL, NULL, NULL);
INSERT INTO `view_type_item` VALUES (921, NULL, 'http://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e95ade2750a7fde92369b416c7d3176d.jpg?w=1080&h=180&bg=F2EFEC', 'http://i8.mifile.cn/v1/a1/452c4951-df06-f114-6c48-c5940408a905.webp?w=1080&h=180&bg=F2EFEC', '#F2EFEC', 00000001080, 00000000180, 1050, 2050, 'cells_auto_fill', NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
