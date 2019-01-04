/*
 Navicat MySQL Data Transfer

 Source Server         : qianbailu
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : 937xe

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 04/01/2019 10:51:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '图片', 0, 'http://www.979xe.com', '1545744303281');
INSERT INTO `menu` VALUES (2, '小说', 1, 'http://www.979xe.com', '1545744303281');
INSERT INTO `menu` VALUES (3, '视频', 2, 'http://www.979xe.com', '1545744303281');
INSERT INTO `menu` VALUES (4, '电影', 3, 'http://www.979xe.com', '1545744303281');
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
) ENGINE=InnoDB AUTO_INCREMENT=1251 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of novel
-- ----------------------------
BEGIN;
INSERT INTO `novel` VALUES (1201, '2018-12-30援交女学生棠棠', '2018-12-30援交女学生棠棠', '/xs/993608.html', '1546570267374', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1202, '2018-12-30我和邻家姐姐', '2018-12-30我和邻家姐姐', '/xs/993600.html', '1546570267374', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1203, '2018-12-30女同事的卫生巾', '2018-12-30女同事的卫生巾', '/xs/993601.html', '1546570267374', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1204, '2018-12-30我中了老公的圈套', '2018-12-30我中了老公的圈套', '/xs/993603.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1205, '2018-12-30别人的老婆总是最有味道', '2018-12-30别人的老婆总是最有味道', '/xs/993602.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1206, '2018-12-30办公室的秘密', '2018-12-30办公室的秘密', '/xs/993604.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1207, '2018-12-30我和表姐的秘密', '2018-12-30我和表姐的秘密', '/xs/993605.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1208, '2018-12-30我与我的租房邻居红红', '2018-12-30我与我的租房邻居红红', '/xs/993606.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1209, '2018-12-30卧铺激情', '2018-12-30卧铺激情', '/xs/993607.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1210, '2018-12-30四部曲之清晨的狂想曲', '2018-12-30四部曲之清晨的狂想曲', '/xs/993458.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1211, '2018-12-30良家妻子卷卷的阴毛', '2018-12-30良家妻子卷卷的阴毛', '/xs/993459.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1212, '2018-12-30��κ矣淹馕�S花的大奶女友', '2018-12-30��κ矣淹馕�S花的大奶女友', '/xs/993460.html', '1546570267375', 9, 1, '2018-12-30');
INSERT INTO `novel` VALUES (1213, '2018-12-29我们奇妙的第一次', '2018-12-29我们奇妙的第一次', '/xs/993048.html', '1546570267375', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1214, '2018-12-29隔壁的正妹', '2018-12-29隔壁的正妹', '/xs/993049.html', '1546570267375', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1215, '2018-12-29给小流氓们准备的特殊节目', '2018-12-29给小流氓们准备的特殊节目', '/xs/993050.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1216, '2018-12-29总统套房里的师兄妹', '2018-12-29总统套房里的师兄妹', '/xs/993051.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1217, '2018-12-29一次动心的嫖娼过程', '2018-12-29一次动心的嫖娼过程', '/xs/993053.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1218, '2018-12-29淫窟男孩', '2018-12-29淫窟男孩', '/xs/993054.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1219, '2018-12-29准爸爸嫖娼记', '2018-12-29准爸爸嫖娼记', '/xs/993052.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1220, '2018-12-29两小无猜时的性爱', '2018-12-29两小无猜时的性爱', '/xs/993055.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1221, '2018-12-29侠女也淫荡', '2018-12-29侠女也淫荡', '/xs/993056.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1222, '2018-12-29久不放纵后的一次风流', '2018-12-29久不放纵后的一次风流', '/xs/993057.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1223, '2018-12-29残虐俱乐部', '2018-12-29残虐俱乐部', '/xs/993059.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1224, '2018-12-29毒贩的报复', '2018-12-29毒贩的报复', '/xs/993060.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1225, '2018-12-29昂贵神秘的计划', '2018-12-29昂贵神秘的计划', '/xs/993058.html', '1546570267376', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1226, '2018-12-29度假村里好风光', '2018-12-29度假村里好风光', '/xs/993041.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1227, '2018-12-29纵欲的生活', '2018-12-29纵欲的生活', '/xs/993042.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1228, '2018-12-29燃烧我的卡路里', '2018-12-29燃烧我的卡路里', '/xs/993043.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1229, '2018-12-29网友是个好女人', '2018-12-29网友是个好女人', '/xs/993044.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1230, '2018-12-29泌尿系统的女医生', '2018-12-29泌尿系统的女医生', '/xs/993045.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1231, '2018-12-29我的sm女王', '2018-12-29我的sm女王', '/xs/993046.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1232, '2018-12-29孩提时的性事', '2018-12-29孩提时的性事', '/xs/993047.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1233, '2018-12-29在KTV喝懵了我被无套内射', '2018-12-29在KTV喝懵了我被无套内射', '/xs/992871.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1234, '2018-12-29女友爸妈在家我们偷偷做爱', '2018-12-29女友爸妈在家我们偷偷做爱', '/xs/992872.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1235, '2018-12-29警花之殇', '2018-12-29警花之殇', '/xs/992873.html', '1546570267377', 9, 1, '2018-12-29');
INSERT INTO `novel` VALUES (1236, '2018-12-28一个古老的故事', '2018-12-28一个古老的故事', '/xs/992456.html', '1546570267377', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1237, '2018-12-28从小就爱熟女', '2018-12-28从小就爱熟女', '/xs/992457.html', '1546570267377', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1238, '2018-12-28调剂白如水的夫妻生活', '2018-12-28调剂白如水的夫妻生活', '/xs/992458.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1239, '2018-12-28市长的情人', '2018-12-28市长的情人', '/xs/992460.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1240, '2018-12-28帮同一栋楼里的熟妇老公升职', '2018-12-28帮同一栋楼里的熟妇老公升职', '/xs/992461.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1241, '2018-12-28美艳母女的热情招待', '2018-12-28美艳母女的热情招待', '/xs/992459.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1242, '2018-12-28老阿姨性爱欢乐', '2018-12-28老阿姨性爱欢乐', '/xs/992462.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1243, '2018-12-28久旱的美妇', '2018-12-28久旱的美妇', '/xs/992463.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1244, '2018-12-28买房子 玩女人', '2018-12-28买房子 玩女人', '/xs/992449.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1245, '2018-12-28做爱的时候 是忘了伤心事的', '2018-12-28做爱的时候 是忘了伤心事的', '/xs/992451.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1246, '2018-12-28人到中年不得已', '2018-12-28人到中年不得已', '/xs/992450.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1247, '2018-12-28与情人的完美关系', '2018-12-28与情人的完美关系', '/xs/992452.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1248, '2018-12-28比我大几岁的女人 梅', '2018-12-28比我大几岁的女人 梅', '/xs/992453.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1249, '2018-12-28操翻良家熟女的震撼爽感', '2018-12-28操翻良家熟女的震撼爽感', '/xs/992454.html', '1546570267378', 9, 1, '2018-12-28');
INSERT INTO `novel` VALUES (1250, '2018-12-28不是小姐', '2018-12-28不是小姐', '/xs/992455.html', '1546570267378', 9, 1, '2018-12-28');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
-- Records of submenu
-- ----------------------------
BEGIN;
INSERT INTO `submenu` VALUES (1, '亚洲色图', 0, '/tupianqu/YSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (2, '偷拍自拍', 0, '/tupianqu/TSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (3, '欧美色图', 0, '/tupianqu/OSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (4, '清纯唯美', 0, '/tupianqu/QSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (5, '美腿丝袜', 0, '/tupianqu/MSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (6, '少妇熟女', 0, '/tupianqu/SSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (7, '明星淫乱', 0, '/tupianqu/MXSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (8, '卡通动漫', 0, '/tupianqu/KSE/', '1545744483242', '图片');
INSERT INTO `submenu` VALUES (9, '激情小说', 1, '/xiaoshuoqu/jiqingxiaoshuo/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (10, '家庭乱伦', 1, '/xiaoshuoqu/jiatingluanlun/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (11, '校园春色', 1, '/xiaoshuoqu/xiaoyuanchunse/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (12, '武侠玄幻', 1, '/xiaoshuoqu/wuxiaxuanhuan/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (13, '淫妻交换', 1, '/xiaoshuoqu/yinqijiaohuan/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (14, '强奸系列', 1, '/xiaoshuoqu/qiangjianxilie/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (15, '长篇连载', 1, '/xiaoshuoqu/changpianlianzai/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (16, '另类小说', 1, '/xiaoshuoqu/lingleixiaoshuo/', '1545744483242', '小说');
INSERT INTO `submenu` VALUES (17, '偷拍自拍', 2, '/AV/toupaizipai/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (18, '亚洲性爱', 2, '/AV/yazhouxingai/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (19, '欧美性爱', 2, '/AV/oumeixingai/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (20, '经典三级', 2, '/AV/jingdiansanji/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (21, '有码系列', 2, '/AV/youmaxilie/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (22, '中文字幕', 2, '/AV/zhongwenzimu/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (23, '人妻系列', 2, '/AV/renqixilie/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (24, '无码系列', 2, '/AV/wumaxilie/', '1545744483242', '视频');
INSERT INTO `submenu` VALUES (25, '偷拍自拍', 3, '/movie/toupaizipai/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (26, '中文有码', 3, '/movie/zhongwenyouma/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (27, '中文无码', 3, '/movie/zhongwenwuma/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (28, '日本有码', 3, '/movie/ribenyouma/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (29, '日本无码', 3, '/movie/ribenwuma/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (30, '三级剧情', 3, '/movie/sanjijuqing/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (31, '卡通动漫', 3, '/movie/katongdongman/', '1545744483242', '电影');
INSERT INTO `submenu` VALUES (32, '欧美无码', 3, '/movie/oumeiwuma/', '1545744483242', '电影');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
