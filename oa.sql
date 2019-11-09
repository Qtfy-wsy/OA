/*
Navicat MySQL Data Transfer

Source Server         : whhc
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-05-06 23:10:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for affair
-- ----------------------------
DROP TABLE IF EXISTS `affair`;
CREATE TABLE `affair` (
  `affairId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `affairTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `affairContent` text,
  `affairState` tinyint(4) DEFAULT NULL,
  `affairModelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`affairId`),
  KEY `fk_affair_admin` (`userId`),
  KEY `fk_affair_model` (`affairModelId`),
  CONSTRAINT `affair_ibfk_1` FOREIGN KEY (`affairModelId`) REFERENCES `affairmodel` (`affairModelId`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `affair_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affair
-- ----------------------------
INSERT INTO `affair` VALUES ('14', '24', '2017-11-28 11:47:53', '<table class=\'table table-responsive table-bordered\'><tr><td width=\'20%\' align=\'right\'>出差地点</td><td>成都</td></tr><tr><td width=\'20%\' align=\'right\'>开始时间</td><td>2017-11-28T09:00</td></tr><tr><td width=\'20%\' align=\'right\'>结束时间</td><td>2017-11-30T17:30</td></tr><tr><td width=\'20%\' align=\'right\'>出差时长(小时)</td><td>32</td></tr><tr><td width=\'20%\' align=\'right\'>交通工具</td><td>飞机</td></tr><tr><td width=\'20%\' align=\'right\'>出差事由</td><td>去成都吃小吃</td></tr><tr><td width=\'20%\' align=\'right\'>报销类型</td><td>市间交通,市内交通,餐饮费,住宿费</td></tr><tr><td width=\'20%\' align=\'right\'>出差任务</td><td>业务拓展</td></tr></table>', '2', '18');
INSERT INTO `affair` VALUES ('15', '24', '2017-11-28 15:54:43', '<table class=\'table table-responsive table-bordered\'><tr><td width=\'20%\' align=\'right\'>请假类型</td><td>年假</td></tr><tr><td width=\'20%\' align=\'right\'>开始时间</td><td>2017-11-28T09:00</td></tr><tr><td width=\'20%\' align=\'right\'>结束时间</td><td>2017-11-30T17:30</td></tr><tr><td width=\'20%\' align=\'right\'>请假时长</td><td>32</td></tr><tr><td width=\'20%\' align=\'right\'>事由说明</td><td>去七浦路买衣服</td></tr></table>', '3', '19');
INSERT INTO `affair` VALUES ('16', '2', '2019-01-04 04:59:53', '<table id=\"table\" border=\"1\"><tr><td>流程发起人</td><td>马雪梅</td></tr><tr><td>出差地点</td><td></td></tr><tr><td>开始时间</td><td></td></tr><tr><td>结束时间</td><td></td></tr><tr><td>出差时长(小时)</td><td></td></tr><tr><td>交通工具</td><td>飞机</td></tr><tr><td>出差事由</td><td></td></tr><tr><td>报销类型</td><td</td></tr><tr><td>出差任务</td><td>业务拓展</td></tr></table>', '0', '18');
INSERT INTO `affair` VALUES ('17', '2', '2019-01-07 04:22:06', '<table id=\"table\" border=\"1\"><tr><td>流程发起人</td><td>马雪梅</td></tr><tr><td>打算</td><td>傻傻的</td></tr><tr><td>阿萨德</td><td>阿萨德</td></tr><tr><td>萨达</td><td>按时</td></tr></table>', '0', null);
INSERT INTO `affair` VALUES ('18', '1', '2019-03-15 10:05:48', '<table id=\"table\" border=\"1\"><tr><td>流程发起人</td><td>admin</td></tr><tr><td>出差地点</td><td>aaa</td></tr><tr><td>开始时间</td><td>11111</td></tr><tr><td>结束时间</td><td>1111</td></tr><tr><td>出差时长(小时)</td><td>12</td></tr><tr><td>交通工具</td><td>火车</td></tr><tr><td>出差事由</td><td>shhfiueh</td></tr><tr><td>报销类型</td><td>市内交通</td></tr><tr><td>出差任务</td><td>内部培训</td></tr></table>', '0', '18');
INSERT INTO `affair` VALUES ('19', '1', '2019-03-17 19:35:33', '<table id=\"table\" border=\"1\"><tr><td>流程发起人</td><td>admin</td></tr><tr><td>出差地点</td><td>11122</td></tr><tr><td>开始时间</td><td>3323</td></tr><tr><td>结束时间</td><td>2323</td></tr><tr><td>出差时长(小时)</td><td>1</td></tr><tr><td>交通工具</td><td>汽车</td></tr><tr><td>出差事由</td><td>12321</td></tr><tr><td>报销类型</td><td>市内交通</td></tr><tr><td>出差任务</td><td>内部培训</td></tr></table>', '0', '18');
INSERT INTO `affair` VALUES ('20', '2', '2019-03-17 19:37:24', '<table id=\"table\" border=\"1\"><tr><td>流程发起人</td><td>马雪梅</td></tr><tr><td>出差地点</td><td>qew</td></tr><tr><td>开始时间</td><td>111</td></tr><tr><td>结束时间</td><td>22</td></tr><tr><td>出差时长(小时)</td><td>11</td></tr><tr><td>交通工具</td><td>火车</td></tr><tr><td>出差事由</td><td>133</td></tr><tr><td>报销类型</td><td>市内交通</td></tr><tr><td>出差任务</td><td>业务支持</td></tr></table>', '1', '18');

-- ----------------------------
-- Table structure for affairchain
-- ----------------------------
DROP TABLE IF EXISTS `affairchain`;
CREATE TABLE `affairchain` (
  `affairChainId` int(11) NOT NULL AUTO_INCREMENT,
  `affairId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `affairChainOrder` tinyint(4) DEFAULT NULL,
  `affairChainTime` timestamp NULL DEFAULT NULL,
  `affairChainRemark` varchar(255) DEFAULT NULL,
  `affairChainState` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`affairChainId`),
  KEY `fk_affair_chain` (`affairId`),
  KEY `fk_chain_admin` (`userId`),
  KEY `FKBC25B58E4A8CB9` (`userId`),
  CONSTRAINT `affairchain_ibfk_1` FOREIGN KEY (`affairId`) REFERENCES `affair` (`affairId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `affairchain_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affairchain
-- ----------------------------
INSERT INTO `affairchain` VALUES ('39', '14', '19', '1', '2017-11-28 15:47:27', '给我带一点', '2');
INSERT INTO `affairchain` VALUES ('40', '14', '3', '2', '2017-11-28 15:49:30', '多放点辣', '2');
INSERT INTO `affairchain` VALUES ('41', '14', '2', '3', '2017-11-28 15:50:29', '买点贵的，反正可以报销', '2');
INSERT INTO `affairchain` VALUES ('42', '14', '11', '4', '2017-11-28 15:51:03', '去吧', '2');
INSERT INTO `affairchain` VALUES ('43', '15', '19', '1', '2017-11-28 15:55:13', '给我带一点', '2');
INSERT INTO `affairchain` VALUES ('44', '15', '3', '2', '2017-11-28 15:55:42', '去死', '3');
INSERT INTO `affairchain` VALUES ('45', '15', '11', '3', null, null, '0');
INSERT INTO `affairchain` VALUES ('46', '16', '2', '1', '2019-01-04 04:59:53', '发起人已提交', '2');
INSERT INTO `affairchain` VALUES ('47', '16', '3', '2', '2019-01-04 05:01:24', '', '2');
INSERT INTO `affairchain` VALUES ('48', '16', '2', '3', null, null, '0');
INSERT INTO `affairchain` VALUES ('49', '17', '2', '1', '2019-01-07 04:22:06', '发起人已提交', '2');
INSERT INTO `affairchain` VALUES ('50', '17', '12', '2', null, null, '0');
INSERT INTO `affairchain` VALUES ('51', '18', '1', '1', '2019-03-15 10:05:48', '发起人已提交', '2');
INSERT INTO `affairchain` VALUES ('52', '18', '3', '2', '2019-03-15 10:12:53', 'wewqerfewqe', '2');
INSERT INTO `affairchain` VALUES ('53', '18', '2', '3', null, null, '0');
INSERT INTO `affairchain` VALUES ('57', '20', '2', '1', '2019-03-17 07:36:27', '发起人已提交', '2');
INSERT INTO `affairchain` VALUES ('58', '20', '3', '2', '2019-03-17 07:37:24', '2', '1');

-- ----------------------------
-- Table structure for affairmodel
-- ----------------------------
DROP TABLE IF EXISTS `affairmodel`;
CREATE TABLE `affairmodel` (
  `affairModelId` int(11) NOT NULL AUTO_INCREMENT,
  `affairModelName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `affairChain` varchar(255) DEFAULT NULL,
  `affairTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`affairModelId`),
  KEY `fk_model_admin` (`userId`),
  CONSTRAINT `affairmodel_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affairmodel
-- ----------------------------
INSERT INTO `affairmodel` VALUES ('18', '出差申请单', '3', '-1,3,2,11', '1');
INSERT INTO `affairmodel` VALUES ('19', '请假申请单', '3', '-1,3,11', '1');

-- ----------------------------
-- Table structure for affairmodelitem
-- ----------------------------
DROP TABLE IF EXISTS `affairmodelitem`;
CREATE TABLE `affairmodelitem` (
  `modelItemId` int(11) NOT NULL AUTO_INCREMENT,
  `modelItemName` varchar(255) DEFAULT NULL,
  `modelItemType` int(11) DEFAULT NULL,
  `modelItemOption` varchar(255) DEFAULT NULL,
  `affairModelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`modelItemId`),
  KEY `fkmodelitem` (`affairModelId`),
  CONSTRAINT `affairmodelitem_ibfk_1` FOREIGN KEY (`affairModelId`) REFERENCES `affairmodel` (`affairModelId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affairmodelitem
-- ----------------------------
INSERT INTO `affairmodelitem` VALUES ('19', '出差地点', '1', '', '18');
INSERT INTO `affairmodelitem` VALUES ('20', '开始时间', '1', '', '18');
INSERT INTO `affairmodelitem` VALUES ('21', '结束时间', '1', '', '18');
INSERT INTO `affairmodelitem` VALUES ('22', '出差时长(小时)', '1', '', '18');
INSERT INTO `affairmodelitem` VALUES ('23', '交通工具', '3', '飞机,火车,汽车', '18');
INSERT INTO `affairmodelitem` VALUES ('24', '出差事由', '7', '', '18');
INSERT INTO `affairmodelitem` VALUES ('25', '报销类型', '5', '市间交通,市内交通,餐饮费,住宿费', '18');
INSERT INTO `affairmodelitem` VALUES ('26', '出差任务', '3', '业务拓展,业务支持,内部培训,业务会议', '18');
INSERT INTO `affairmodelitem` VALUES ('27', '请假类型', '8', '调休,事假,年假,婚假,产假,病假,丧假', '19');
INSERT INTO `affairmodelitem` VALUES ('28', '开始时间', '5', '', '19');
INSERT INTO `affairmodelitem` VALUES ('29', '结束时间', '5', '', '19');
INSERT INTO `affairmodelitem` VALUES ('30', '请假时长', '1', '', '19');
INSERT INTO `affairmodelitem` VALUES ('31', '事由说明', '2', '', '19');

-- ----------------------------
-- Table structure for affairtype
-- ----------------------------
DROP TABLE IF EXISTS `affairtype`;
CREATE TABLE `affairtype` (
  `affairTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `affairTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`affairTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affairtype
-- ----------------------------
INSERT INTO `affairtype` VALUES ('1', '人事');
INSERT INTO `affairtype` VALUES ('2', '财务');
INSERT INTO `affairtype` VALUES ('3', '仓库');

-- ----------------------------
-- Table structure for attendconfig
-- ----------------------------
DROP TABLE IF EXISTS `attendconfig`;
CREATE TABLE `attendconfig` (
  `dutyType` int(11) NOT NULL AUTO_INCREMENT,
  `dutyName` varchar(100) COLLATE utf8_bin NOT NULL,
  `general` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime1` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime2` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime3` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime4` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime5` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyTime6` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dutyType1` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `dutyType2` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `dutyType3` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `dutyType4` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `dutyType5` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `dutyType6` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dutyType`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of attendconfig
-- ----------------------------
INSERT INTO `attendconfig` VALUES ('1', '行政班', '0', '09:00:00', '17:30:00', null, null, null, null, '1', '2', null, null, null, null);
INSERT INTO `attendconfig` VALUES ('2', '两头班', '6,0', '08:00:00', '12:00:00', '17:30:00', '21:30:00', null, null, '1', '2', '1', '2', null, null);
INSERT INTO `attendconfig` VALUES ('16', 'asdasd', '0,3,6', '00:30:00', '06:30:00', '', '', '', '', '1', '2', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for attendduty
-- ----------------------------
DROP TABLE IF EXISTS `attendduty`;
CREATE TABLE `attendduty` (
  `userId` int(11) NOT NULL,
  `registerType` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `registerId` int(8) DEFAULT NULL,
  `remark` text COLLATE utf8_bin,
  `dutyType` int(11) DEFAULT NULL,
  `isHoliday` bit(1) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  KEY `dutyType` (`dutyType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of attendduty
-- ----------------------------
INSERT INTO `attendduty` VALUES ('1', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-04 09:00:00');
INSERT INTO `attendduty` VALUES ('1', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-04 17:30:00');
INSERT INTO `attendduty` VALUES ('2', '1', '2019-01-03 09:33:00', '1', 0xE69CAAE68993E58DA1, '1', '\0', '\0', '2019-01-03 09:00:00');
INSERT INTO `attendduty` VALUES ('2', '2', '2019-01-03 12:25:30', '2', 0xE69CAAE68993E58DA1, '1', '\0', '\0', '2019-01-03 17:30:00');
INSERT INTO `attendduty` VALUES ('12', null, null, '1', 0xE4BC91E681AF, null, '', '\0', '2019-01-05 00:00:00');
INSERT INTO `attendduty` VALUES ('1', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-05 09:00:00');
INSERT INTO `attendduty` VALUES ('1', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-05 17:30:00');
INSERT INTO `attendduty` VALUES ('2', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-05 09:00:00');
INSERT INTO `attendduty` VALUES ('2', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-05 17:30:00');
INSERT INTO `attendduty` VALUES ('12', null, null, '1', 0xE4BC91E681AF, null, '', '\0', '2019-01-05 00:00:00');
INSERT INTO `attendduty` VALUES ('1', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 09:00:00');
INSERT INTO `attendduty` VALUES ('1', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('2', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 09:00:00');
INSERT INTO `attendduty` VALUES ('2', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('12', '1', null, '1', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 08:00:00');
INSERT INTO `attendduty` VALUES ('12', '2', null, '2', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 12:00:00');
INSERT INTO `attendduty` VALUES ('12', '1', null, '3', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('12', '2', null, '4', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 21:30:00');
INSERT INTO `attendduty` VALUES ('1', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 09:00:00');
INSERT INTO `attendduty` VALUES ('1', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('2', '1', null, '1', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 09:00:00');
INSERT INTO `attendduty` VALUES ('2', '2', null, '2', 0xE69CAAE68993E58DA1, '1', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('12', '1', null, '1', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 08:00:00');
INSERT INTO `attendduty` VALUES ('12', '2', null, '2', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 12:00:00');
INSERT INTO `attendduty` VALUES ('12', '1', null, '3', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 17:30:00');
INSERT INTO `attendduty` VALUES ('12', '2', null, '4', 0xE69CAAE68993E58DA1, '2', '\0', '', '2019-01-07 21:30:00');

-- ----------------------------
-- Table structure for attendholiday
-- ----------------------------
DROP TABLE IF EXISTS `attendholiday`;
CREATE TABLE `attendholiday` (
  `holidayId` int(11) NOT NULL AUTO_INCREMENT,
  `holidayName` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `beginDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  PRIMARY KEY (`holidayId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of attendholiday
-- ----------------------------
INSERT INTO `attendholiday` VALUES ('1', '国庆长假', '2018-10-01', '2018-10-07');

-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `dailyId` int(11) NOT NULL AUTO_INCREMENT,
  `dailyTitle` varchar(255) DEFAULT NULL,
  `dailyContent` text,
  `dailyAddTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `dailyUpdateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  `dailyName` varchar(255) NOT NULL,
  `dailyReg` varchar(255) NOT NULL,
  PRIMARY KEY (`dailyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily
-- ----------------------------
INSERT INTO `daily` VALUES ('1', '周一例会材料准备', '每周周一例行会议，材料总结与收集', '2019-01-08 20:14:50', '2019-01-08 20:15:28', '2', '1', 'lihui', '* * 2 * * ?');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(50) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`departmentId`),
  KEY `fk_10` (`userId`),
  CONSTRAINT `fk_10` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '总经理办公室', '-1', '11');
INSERT INTO `department` VALUES ('2', '业务集群I-王琰', '1', '8');
INSERT INTO `department` VALUES ('3', '业务集群II-余笑', '1', '7');
INSERT INTO `department` VALUES ('4', '财务部', '1', '2');
INSERT INTO `department` VALUES ('5', '人力资源部', '1', '3');
INSERT INTO `department` VALUES ('6', '行政管理部', '1', '3');
INSERT INTO `department` VALUES ('7', '市场部', '2', '4');
INSERT INTO `department` VALUES ('8', '销售部', '3', '5');
INSERT INTO `department` VALUES ('9', '就业部', '2', '6');
INSERT INTO `department` VALUES ('10', '教学部', '3', '19');
INSERT INTO `department` VALUES ('11', '教务部', '10', '19');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) NOT NULL,
  `menuUrl` varchar(50) DEFAULT NULL,
  `mpid` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '人力资源', '', '-1');
INSERT INTO `menu` VALUES ('2', '公文模块', '', '-1');
INSERT INTO `menu` VALUES ('3', '邮箱模块', '', '-1');
INSERT INTO `menu` VALUES ('4', '个人办公', '', '-1');
INSERT INTO `menu` VALUES ('5', '系统设置', '', '-1');
INSERT INTO `menu` VALUES ('6', '考勤管理', '', '1');
INSERT INTO `menu` VALUES ('7', '公告管理', 'News', '1');
INSERT INTO `menu` VALUES ('8', '员工管理', '../Staff/viewOperate', '1');
INSERT INTO `menu` VALUES ('9', '部门管理', '../Department/getDepartment', '1');
INSERT INTO `menu` VALUES ('10', '角色管理', '../Role/viewOperate', '1');
INSERT INTO `menu` VALUES ('11', '权限管理', 'Permission', '1');
INSERT INTO `menu` VALUES ('12', '公文设计', '../affairmodule/getAffairmodule', '2');
INSERT INTO `menu` VALUES ('13', '公文管理', '', '2');
INSERT INTO `menu` VALUES ('14', '邮箱管理', 'Email', '3');
INSERT INTO `menu` VALUES ('15', '工作日志', 'Daily', '4');
INSERT INTO `menu` VALUES ('16', '行程安排', 'Schedule', '4');
INSERT INTO `menu` VALUES ('17', '菜单管理', 'Menu', '5');
INSERT INTO `menu` VALUES ('18', '个人设置', 'Setting', '5');
INSERT INTO `menu` VALUES ('19', '班次管理', '../Duty/getDuty', '6');
INSERT INTO `menu` VALUES ('20', '考勤打卡', '../Duty/userAttend', '4');
INSERT INTO `menu` VALUES ('22', '个人考勤记录', '../Duty/getUserAttendance', '4');
INSERT INTO `menu` VALUES ('23', '用户排班', '../Duty/UserDutyInfo', '6');
INSERT INTO `menu` VALUES ('24', '考勤记录', '../Duty/attendList', '6');
INSERT INTO `menu` VALUES ('25', '发布流程', '../Affair/getAffairModel', '4');
INSERT INTO `menu` VALUES ('26', '发起流程', '../affair/AffairCreate', '13');
INSERT INTO `menu` VALUES ('27', '待办流程', '../affair/AffairPend', '13');
INSERT INTO `menu` VALUES ('28', '已办流程', '../affair/AffairAlread', '13');
INSERT INTO `menu` VALUES ('29', '流程查阅', '../affair/AffairLook', '13');

-- ----------------------------
-- Table structure for mynews
-- ----------------------------
DROP TABLE IF EXISTS `mynews`;
CREATE TABLE `mynews` (
  `mynewsId` int(11) NOT NULL AUTO_INCREMENT,
  `mynewsTitle` varchar(255) DEFAULT NULL,
  `mynewsUrl` varchar(255) DEFAULT NULL,
  `mynewsAddTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `mynewsUpdateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  `mynewsState` int(11) DEFAULT NULL,
  PRIMARY KEY (`mynewsId`),
  KEY `fk_111` (`userId`),
  CONSTRAINT `fk_111` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mynews
-- ----------------------------
INSERT INTO `mynews` VALUES ('1', '春节放假通知', 'f24c9d9e-424b-49f9-8725-433c0b8f0cc6.html', '2017-11-29 10:46:05', '2017-11-29 10:46:05', '3', '1');
INSERT INTO `mynews` VALUES ('2', '2017年年终奖发放规格', '6c07ca58-36fb-4f85-9cb7-4c2d68fde569.html', '2017-11-29 10:48:03', '2017-11-29 10:48:03', '3', '1');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `newsTitle` varchar(255) DEFAULT NULL,
  `newsContent` text,
  `newsAddTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `newsUpdateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  `newsState` int(11) DEFAULT NULL,
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for operate
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `operateId` int(11) NOT NULL AUTO_INCREMENT,
  `operateName` varchar(50) NOT NULL,
  `operateAction` varchar(50) NOT NULL,
  `operateURL` varchar(50) DEFAULT NULL,
  `opid` int(11) DEFAULT NULL,
  PRIMARY KEY (`operateId`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate
-- ----------------------------
INSERT INTO `operate` VALUES ('1', '博为峰OA办公自动化系统', 'OA', '', '-1');
INSERT INTO `operate` VALUES ('6', '考勤管理', 'Roster', '', '1');
INSERT INTO `operate` VALUES ('7', '公告管理', 'News', '', '1');
INSERT INTO `operate` VALUES ('8', '员工管理', 'Staff', '', '1');
INSERT INTO `operate` VALUES ('9', '部门管理', 'Department', '', '1');
INSERT INTO `operate` VALUES ('10', '角色管理', 'Role', '', '1');
INSERT INTO `operate` VALUES ('11', '权限管理', 'Permission', '', '1');
INSERT INTO `operate` VALUES ('12', '公文设计', 'AffairModule', '', '1');
INSERT INTO `operate` VALUES ('13', '公文管理', 'Affair', '', '1');
INSERT INTO `operate` VALUES ('14', '邮箱管理', 'Email', '', '1');
INSERT INTO `operate` VALUES ('15', '工作日志', 'Daily', '', '1');
INSERT INTO `operate` VALUES ('16', '行程安排', 'Schedule', '', '1');
INSERT INTO `operate` VALUES ('17', '菜单管理', 'Menu', '', '1');
INSERT INTO `operate` VALUES ('18', '个人设置', 'Setting', '', '1');
INSERT INTO `operate` VALUES ('19', '添加公告', 'NewsAdd', '', '7');
INSERT INTO `operate` VALUES ('20', '修改公告', 'NewsUpdate', '', '7');
INSERT INTO `operate` VALUES ('21', '删除公告', 'NewsDelete', '', '7');
INSERT INTO `operate` VALUES ('22', '添加考勤', 'RosterAdd', '', '6');
INSERT INTO `operate` VALUES ('23', '修改考勤', 'RosterUpdate', '', '6');
INSERT INTO `operate` VALUES ('24', '删除考勤', 'RosterDelete', '', '6');
INSERT INTO `operate` VALUES ('25', '新增员工', 'staffAddSkip', '', '8');
INSERT INTO `operate` VALUES ('26', '修改员工', 'staffUpdateSkip', '', '8');
INSERT INTO `operate` VALUES ('27', '删除员工', 'staffDeleteSkip', '', '8');
INSERT INTO `operate` VALUES ('28', '新增部门', 'DepartmentAdd', '', '9');
INSERT INTO `operate` VALUES ('29', '修改部门', 'DepartmentUpdate', '', '9');
INSERT INTO `operate` VALUES ('30', '删除部门', 'DepartmentDelete', '', '9');
INSERT INTO `operate` VALUES ('31', '新增角色', 'roleAddSkip', '', '10');
INSERT INTO `operate` VALUES ('32', '修改角色', 'roleUpdateSkip', '', '10');
INSERT INTO `operate` VALUES ('33', '删除角色', 'roleDeleteSkip', '', '10');
INSERT INTO `operate` VALUES ('34', '新增公文模板', 'addAffairModule', '', '12');
INSERT INTO `operate` VALUES ('35', '修改公文模板', 'updateAffairModule', '', '12');
INSERT INTO `operate` VALUES ('36', '删除公文模板', 'deleteAffairModule', '', '12');
INSERT INTO `operate` VALUES ('37', '添加公告保存', 'NewsSave', '', '19');
INSERT INTO `operate` VALUES ('38', '修改公告保存', 'NewsAlter', '', '20');
INSERT INTO `operate` VALUES ('39', '添加考勤保存', 'RosterSave', '', '22');
INSERT INTO `operate` VALUES ('40', '修改考勤保存', 'RosterAlter', '', '23');
INSERT INTO `operate` VALUES ('41', '新增员工保存', 'UserSave', '', '25');
INSERT INTO `operate` VALUES ('42', '修改员工保存', 'UserAlter', '', '26');
INSERT INTO `operate` VALUES ('43', '新增部门保存', 'DepartmentSave', '', '28');
INSERT INTO `operate` VALUES ('44', '修改部门保存', 'DepartmentAlter', '', '29');
INSERT INTO `operate` VALUES ('45', '新增角色保存', 'RoleSave', '', '31');
INSERT INTO `operate` VALUES ('46', '修改角色保存', 'RoleAlter', '', '32');
INSERT INTO `operate` VALUES ('47', '新增公文模板保存', 'AffairModuleSave', '', '34');
INSERT INTO `operate` VALUES ('48', '修改公文模板保存', 'AffairModuleAlter', '', '35');
INSERT INTO `operate` VALUES ('49', '班次管理', '', null, '1');
INSERT INTO `operate` VALUES ('50', '添加班次', 'addDuty', null, '49');
INSERT INTO `operate` VALUES ('51', '删除班次', 'deleteDuty', null, '49');
INSERT INTO `operate` VALUES ('52', '更新班次', 'updateDuty', null, '49');
INSERT INTO `operate` VALUES ('53', '用户排班', '', null, '1');
INSERT INTO `operate` VALUES ('54', '排班', 'addUserDuty', null, '53');
INSERT INTO `operate` VALUES ('55', '删除排班', 'deleteUserDuty', null, '53');
INSERT INTO `operate` VALUES ('56', '更新排班', 'updateUserDuty', null, '53');
INSERT INTO `operate` VALUES ('57', '发起流程', 'AffairCreate', '', '13');
INSERT INTO `operate` VALUES ('58', '待办流程', 'AffairPend', '', '13');
INSERT INTO `operate` VALUES ('59', '已办流程', 'AffairAlread', '', '13');
INSERT INTO `operate` VALUES ('60', '流程查阅', 'AffairLook', '', '13');
INSERT INTO `operate` VALUES ('61', '添加班次保存', 'addDutyEnd', null, '50');
INSERT INTO `operate` VALUES ('62', '删除班次保存', 'deleteDutyEnd', null, '51');
INSERT INTO `operate` VALUES ('63', '更新班次保存', 'updateDutyEnd', null, '52');
INSERT INTO `operate` VALUES ('64', '排班保存', 'addUserDutyEnd', null, '54');
INSERT INTO `operate` VALUES ('65', '删除排班保存', 'deleteUserDutyEnd', null, '55');
INSERT INTO `operate` VALUES ('66', '更新排班保存', 'updateUserDutyEnd', null, '56');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) NOT NULL,
  `permissionType` varchar(50) DEFAULT NULL,
  `ppid` int(11) DEFAULT NULL,
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '人力资源', '', '-1');
INSERT INTO `permission` VALUES ('2', '公文模块', null, '-1');
INSERT INTO `permission` VALUES ('3', '邮箱模块', null, '-1');
INSERT INTO `permission` VALUES ('4', '个人办公', null, '-1');
INSERT INTO `permission` VALUES ('5', '系统设置', null, '-1');
INSERT INTO `permission` VALUES ('6', '考勤管理', null, '1');
INSERT INTO `permission` VALUES ('7', '公告管理', null, '1');
INSERT INTO `permission` VALUES ('8', '员工管理', null, '1');
INSERT INTO `permission` VALUES ('9', '部门管理', null, '1');
INSERT INTO `permission` VALUES ('10', '角色管理', null, '1');
INSERT INTO `permission` VALUES ('11', '权限管理', null, '1');
INSERT INTO `permission` VALUES ('12', '公文设计', null, '2');
INSERT INTO `permission` VALUES ('13', '公文管理', null, '2');
INSERT INTO `permission` VALUES ('14', '邮箱管理', null, '3');
INSERT INTO `permission` VALUES ('15', '工作日志', null, '4');
INSERT INTO `permission` VALUES ('16', '行程安排', null, '4');
INSERT INTO `permission` VALUES ('17', '菜单管理', null, '5');
INSERT INTO `permission` VALUES ('18', '个人设置', null, '5');
INSERT INTO `permission` VALUES ('19', '添加公告', null, '7');
INSERT INTO `permission` VALUES ('20', '修改公告', null, '7');
INSERT INTO `permission` VALUES ('21', '删除公告', null, '7');
INSERT INTO `permission` VALUES ('22', '添加班次', null, '37');
INSERT INTO `permission` VALUES ('23', '修改班次', null, '37');
INSERT INTO `permission` VALUES ('24', '删除班次', null, '37');
INSERT INTO `permission` VALUES ('25', '新增员工', null, '8');
INSERT INTO `permission` VALUES ('26', '修改员工', null, '8');
INSERT INTO `permission` VALUES ('27', '删除员工', null, '8');
INSERT INTO `permission` VALUES ('28', '新增部门', null, '9');
INSERT INTO `permission` VALUES ('29', '修改部门', null, '9');
INSERT INTO `permission` VALUES ('30', '删除部门', null, '9');
INSERT INTO `permission` VALUES ('31', '新增角色', null, '10');
INSERT INTO `permission` VALUES ('32', '修改角色', null, '10');
INSERT INTO `permission` VALUES ('33', '删除角色', null, '10');
INSERT INTO `permission` VALUES ('34', '新增公文模板', null, '12');
INSERT INTO `permission` VALUES ('35', '修改公文模板', null, '12');
INSERT INTO `permission` VALUES ('36', '删除公文模板', null, '12');
INSERT INTO `permission` VALUES ('37', '班次管理', null, '6');
INSERT INTO `permission` VALUES ('38', '用户排班', null, '6');
INSERT INTO `permission` VALUES ('39', '排班', null, '38');
INSERT INTO `permission` VALUES ('40', '删除排班', null, '38');
INSERT INTO `permission` VALUES ('41', '更新排班', null, '38');

-- ----------------------------
-- Table structure for permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `permission_menu`;
CREATE TABLE `permission_menu` (
  `permissionId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  KEY `pk_1` (`permissionId`),
  KEY `pk_2` (`menuId`),
  CONSTRAINT `pk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`permissionId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `pk_2` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_menu
-- ----------------------------
INSERT INTO `permission_menu` VALUES ('1', '1');
INSERT INTO `permission_menu` VALUES ('2', '2');
INSERT INTO `permission_menu` VALUES ('3', '3');
INSERT INTO `permission_menu` VALUES ('4', '4');
INSERT INTO `permission_menu` VALUES ('5', '5');
INSERT INTO `permission_menu` VALUES ('6', '6');
INSERT INTO `permission_menu` VALUES ('7', '7');
INSERT INTO `permission_menu` VALUES ('8', '8');
INSERT INTO `permission_menu` VALUES ('9', '9');
INSERT INTO `permission_menu` VALUES ('10', '10');
INSERT INTO `permission_menu` VALUES ('11', '11');
INSERT INTO `permission_menu` VALUES ('12', '12');
INSERT INTO `permission_menu` VALUES ('13', '13');
INSERT INTO `permission_menu` VALUES ('14', '14');
INSERT INTO `permission_menu` VALUES ('15', '15');
INSERT INTO `permission_menu` VALUES ('16', '16');
INSERT INTO `permission_menu` VALUES ('17', '17');
INSERT INTO `permission_menu` VALUES ('18', '18');
INSERT INTO `permission_menu` VALUES ('37', '19');
INSERT INTO `permission_menu` VALUES ('38', '23');

-- ----------------------------
-- Table structure for permission_operate
-- ----------------------------
DROP TABLE IF EXISTS `permission_operate`;
CREATE TABLE `permission_operate` (
  `permissionId` int(11) NOT NULL,
  `operateId` int(11) NOT NULL,
  KEY `pk_7` (`permissionId`),
  KEY `pk_8` (`operateId`),
  CONSTRAINT `pk_7` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`permissionId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `pk_8` FOREIGN KEY (`operateId`) REFERENCES `operate` (`operateId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_operate
-- ----------------------------
INSERT INTO `permission_operate` VALUES ('6', '6');
INSERT INTO `permission_operate` VALUES ('7', '7');
INSERT INTO `permission_operate` VALUES ('8', '8');
INSERT INTO `permission_operate` VALUES ('9', '9');
INSERT INTO `permission_operate` VALUES ('10', '10');
INSERT INTO `permission_operate` VALUES ('11', '11');
INSERT INTO `permission_operate` VALUES ('12', '12');
INSERT INTO `permission_operate` VALUES ('13', '13');
INSERT INTO `permission_operate` VALUES ('14', '14');
INSERT INTO `permission_operate` VALUES ('15', '15');
INSERT INTO `permission_operate` VALUES ('16', '16');
INSERT INTO `permission_operate` VALUES ('17', '17');
INSERT INTO `permission_operate` VALUES ('18', '18');
INSERT INTO `permission_operate` VALUES ('19', '19');
INSERT INTO `permission_operate` VALUES ('20', '20');
INSERT INTO `permission_operate` VALUES ('21', '21');
INSERT INTO `permission_operate` VALUES ('23', '23');
INSERT INTO `permission_operate` VALUES ('24', '24');
INSERT INTO `permission_operate` VALUES ('25', '25');
INSERT INTO `permission_operate` VALUES ('26', '26');
INSERT INTO `permission_operate` VALUES ('27', '27');
INSERT INTO `permission_operate` VALUES ('28', '28');
INSERT INTO `permission_operate` VALUES ('29', '29');
INSERT INTO `permission_operate` VALUES ('30', '30');
INSERT INTO `permission_operate` VALUES ('31', '31');
INSERT INTO `permission_operate` VALUES ('32', '32');
INSERT INTO `permission_operate` VALUES ('33', '33');
INSERT INTO `permission_operate` VALUES ('34', '34');
INSERT INTO `permission_operate` VALUES ('35', '35');
INSERT INTO `permission_operate` VALUES ('36', '36');
INSERT INTO `permission_operate` VALUES ('19', '37');
INSERT INTO `permission_operate` VALUES ('20', '38');
INSERT INTO `permission_operate` VALUES ('22', '39');
INSERT INTO `permission_operate` VALUES ('23', '40');
INSERT INTO `permission_operate` VALUES ('25', '41');
INSERT INTO `permission_operate` VALUES ('26', '42');
INSERT INTO `permission_operate` VALUES ('28', '43');
INSERT INTO `permission_operate` VALUES ('29', '44');
INSERT INTO `permission_operate` VALUES ('31', '45');
INSERT INTO `permission_operate` VALUES ('32', '46');
INSERT INTO `permission_operate` VALUES ('37', '49');
INSERT INTO `permission_operate` VALUES ('22', '50');
INSERT INTO `permission_operate` VALUES ('24', '51');
INSERT INTO `permission_operate` VALUES ('23', '52');
INSERT INTO `permission_operate` VALUES ('39', '54');
INSERT INTO `permission_operate` VALUES ('40', '55');
INSERT INTO `permission_operate` VALUES ('41', '56');
INSERT INTO `permission_operate` VALUES ('38', '53');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  `departmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  KEY `fk_11` (`departmentId`),
  CONSTRAINT `fk_11` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('2', '超级管理员', null);
INSERT INTO `role` VALUES ('3', '总经理', '1');
INSERT INTO `role` VALUES ('4', '副总经理', '1');
INSERT INTO `role` VALUES ('5', '财务经理', '4');
INSERT INTO `role` VALUES ('6', '出纳', '4');
INSERT INTO `role` VALUES ('7', '会计', '4');
INSERT INTO `role` VALUES ('8', '人力资源经理', '5');
INSERT INTO `role` VALUES ('9', '招聘主管', '5');
INSERT INTO `role` VALUES ('10', '薪酬主管', '5');
INSERT INTO `role` VALUES ('11', '招聘专员', '5');
INSERT INTO `role` VALUES ('12', '薪酬专员', '5');
INSERT INTO `role` VALUES ('13', '行政经理', '6');
INSERT INTO `role` VALUES ('14', '行政专员', '6');
INSERT INTO `role` VALUES ('15', '前台', '6');
INSERT INTO `role` VALUES ('16', '法务', '6');
INSERT INTO `role` VALUES ('17', '市场经理', '7');
INSERT INTO `role` VALUES ('18', '网络推广', '7');
INSERT INTO `role` VALUES ('19', '广告宣传', '7');
INSERT INTO `role` VALUES ('20', '销售经理', '8');
INSERT INTO `role` VALUES ('21', '电话销售', '8');
INSERT INTO `role` VALUES ('22', '产品顾问', '8');
INSERT INTO `role` VALUES ('23', '就业经理', '9');
INSERT INTO `role` VALUES ('24', '就业主管', '9');
INSERT INTO `role` VALUES ('25', '就业顾问', '9');
INSERT INTO `role` VALUES ('26', '教学经理', '10');
INSERT INTO `role` VALUES ('27', '讲师', '10');
INSERT INTO `role` VALUES ('29', '分管业务副总I-王琰', '2');
INSERT INTO `role` VALUES ('30', '分管业务副总II-余笑', '3');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `roleId` int(11) NOT NULL,
  `permissionId` int(11) NOT NULL,
  KEY `pk_5` (`roleId`),
  KEY `pk_6` (`permissionId`),
  CONSTRAINT `pk_5` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `pk_6` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`permissionId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('2', '2');
INSERT INTO `role_permission` VALUES ('2', '3');
INSERT INTO `role_permission` VALUES ('2', '4');
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '6');
INSERT INTO `role_permission` VALUES ('2', '7');
INSERT INTO `role_permission` VALUES ('2', '8');
INSERT INTO `role_permission` VALUES ('2', '9');
INSERT INTO `role_permission` VALUES ('2', '10');
INSERT INTO `role_permission` VALUES ('2', '11');
INSERT INTO `role_permission` VALUES ('2', '12');
INSERT INTO `role_permission` VALUES ('2', '13');
INSERT INTO `role_permission` VALUES ('2', '14');
INSERT INTO `role_permission` VALUES ('2', '15');
INSERT INTO `role_permission` VALUES ('2', '16');
INSERT INTO `role_permission` VALUES ('2', '17');
INSERT INTO `role_permission` VALUES ('2', '18');
INSERT INTO `role_permission` VALUES ('2', '19');
INSERT INTO `role_permission` VALUES ('2', '20');
INSERT INTO `role_permission` VALUES ('2', '21');
INSERT INTO `role_permission` VALUES ('2', '22');
INSERT INTO `role_permission` VALUES ('2', '23');
INSERT INTO `role_permission` VALUES ('2', '24');
INSERT INTO `role_permission` VALUES ('2', '25');
INSERT INTO `role_permission` VALUES ('2', '26');
INSERT INTO `role_permission` VALUES ('2', '27');
INSERT INTO `role_permission` VALUES ('2', '28');
INSERT INTO `role_permission` VALUES ('2', '29');
INSERT INTO `role_permission` VALUES ('2', '30');
INSERT INTO `role_permission` VALUES ('2', '31');
INSERT INTO `role_permission` VALUES ('2', '32');
INSERT INTO `role_permission` VALUES ('2', '33');
INSERT INTO `role_permission` VALUES ('2', '34');
INSERT INTO `role_permission` VALUES ('2', '35');
INSERT INTO `role_permission` VALUES ('2', '36');
INSERT INTO `role_permission` VALUES ('3', '1');
INSERT INTO `role_permission` VALUES ('3', '2');
INSERT INTO `role_permission` VALUES ('3', '3');
INSERT INTO `role_permission` VALUES ('3', '4');
INSERT INTO `role_permission` VALUES ('3', '5');
INSERT INTO `role_permission` VALUES ('3', '6');
INSERT INTO `role_permission` VALUES ('3', '7');
INSERT INTO `role_permission` VALUES ('3', '8');
INSERT INTO `role_permission` VALUES ('3', '9');
INSERT INTO `role_permission` VALUES ('3', '10');
INSERT INTO `role_permission` VALUES ('3', '11');
INSERT INTO `role_permission` VALUES ('3', '12');
INSERT INTO `role_permission` VALUES ('3', '13');
INSERT INTO `role_permission` VALUES ('3', '14');
INSERT INTO `role_permission` VALUES ('3', '15');
INSERT INTO `role_permission` VALUES ('3', '16');
INSERT INTO `role_permission` VALUES ('3', '17');
INSERT INTO `role_permission` VALUES ('3', '18');
INSERT INTO `role_permission` VALUES ('3', '19');
INSERT INTO `role_permission` VALUES ('3', '20');
INSERT INTO `role_permission` VALUES ('3', '21');
INSERT INTO `role_permission` VALUES ('3', '22');
INSERT INTO `role_permission` VALUES ('3', '23');
INSERT INTO `role_permission` VALUES ('3', '24');
INSERT INTO `role_permission` VALUES ('3', '25');
INSERT INTO `role_permission` VALUES ('3', '26');
INSERT INTO `role_permission` VALUES ('3', '27');
INSERT INTO `role_permission` VALUES ('3', '28');
INSERT INTO `role_permission` VALUES ('3', '29');
INSERT INTO `role_permission` VALUES ('3', '30');
INSERT INTO `role_permission` VALUES ('3', '31');
INSERT INTO `role_permission` VALUES ('3', '32');
INSERT INTO `role_permission` VALUES ('3', '33');
INSERT INTO `role_permission` VALUES ('3', '34');
INSERT INTO `role_permission` VALUES ('3', '35');
INSERT INTO `role_permission` VALUES ('3', '36');
INSERT INTO `role_permission` VALUES ('26', '2');
INSERT INTO `role_permission` VALUES ('26', '3');
INSERT INTO `role_permission` VALUES ('26', '4');
INSERT INTO `role_permission` VALUES ('26', '5');
INSERT INTO `role_permission` VALUES ('26', '13');
INSERT INTO `role_permission` VALUES ('26', '14');
INSERT INTO `role_permission` VALUES ('26', '15');
INSERT INTO `role_permission` VALUES ('26', '16');
INSERT INTO `role_permission` VALUES ('26', '18');
INSERT INTO `role_permission` VALUES ('27', '2');
INSERT INTO `role_permission` VALUES ('27', '3');
INSERT INTO `role_permission` VALUES ('27', '4');
INSERT INTO `role_permission` VALUES ('27', '5');
INSERT INTO `role_permission` VALUES ('27', '13');
INSERT INTO `role_permission` VALUES ('27', '14');
INSERT INTO `role_permission` VALUES ('27', '15');
INSERT INTO `role_permission` VALUES ('27', '16');
INSERT INTO `role_permission` VALUES ('27', '18');
INSERT INTO `role_permission` VALUES ('8', '1');
INSERT INTO `role_permission` VALUES ('8', '2');
INSERT INTO `role_permission` VALUES ('8', '3');
INSERT INTO `role_permission` VALUES ('8', '4');
INSERT INTO `role_permission` VALUES ('8', '5');
INSERT INTO `role_permission` VALUES ('8', '6');
INSERT INTO `role_permission` VALUES ('8', '7');
INSERT INTO `role_permission` VALUES ('8', '8');
INSERT INTO `role_permission` VALUES ('8', '9');
INSERT INTO `role_permission` VALUES ('8', '10');
INSERT INTO `role_permission` VALUES ('8', '11');
INSERT INTO `role_permission` VALUES ('8', '12');
INSERT INTO `role_permission` VALUES ('8', '13');
INSERT INTO `role_permission` VALUES ('8', '14');
INSERT INTO `role_permission` VALUES ('8', '15');
INSERT INTO `role_permission` VALUES ('8', '16');
INSERT INTO `role_permission` VALUES ('8', '17');
INSERT INTO `role_permission` VALUES ('8', '18');
INSERT INTO `role_permission` VALUES ('8', '19');
INSERT INTO `role_permission` VALUES ('8', '20');
INSERT INTO `role_permission` VALUES ('8', '21');
INSERT INTO `role_permission` VALUES ('8', '22');
INSERT INTO `role_permission` VALUES ('8', '23');
INSERT INTO `role_permission` VALUES ('8', '24');
INSERT INTO `role_permission` VALUES ('8', '25');
INSERT INTO `role_permission` VALUES ('8', '26');
INSERT INTO `role_permission` VALUES ('8', '27');
INSERT INTO `role_permission` VALUES ('8', '28');
INSERT INTO `role_permission` VALUES ('8', '29');
INSERT INTO `role_permission` VALUES ('8', '30');
INSERT INTO `role_permission` VALUES ('8', '31');
INSERT INTO `role_permission` VALUES ('8', '32');
INSERT INTO `role_permission` VALUES ('8', '33');
INSERT INTO `role_permission` VALUES ('8', '34');
INSERT INTO `role_permission` VALUES ('8', '35');
INSERT INTO `role_permission` VALUES ('8', '36');
INSERT INTO `role_permission` VALUES ('13', '2');
INSERT INTO `role_permission` VALUES ('13', '3');
INSERT INTO `role_permission` VALUES ('13', '4');
INSERT INTO `role_permission` VALUES ('13', '5');
INSERT INTO `role_permission` VALUES ('13', '13');
INSERT INTO `role_permission` VALUES ('13', '14');
INSERT INTO `role_permission` VALUES ('13', '15');
INSERT INTO `role_permission` VALUES ('13', '16');
INSERT INTO `role_permission` VALUES ('13', '18');
INSERT INTO `role_permission` VALUES ('5', '1');
INSERT INTO `role_permission` VALUES ('5', '2');
INSERT INTO `role_permission` VALUES ('5', '3');
INSERT INTO `role_permission` VALUES ('5', '4');
INSERT INTO `role_permission` VALUES ('5', '5');
INSERT INTO `role_permission` VALUES ('5', '6');
INSERT INTO `role_permission` VALUES ('5', '7');
INSERT INTO `role_permission` VALUES ('5', '8');
INSERT INTO `role_permission` VALUES ('5', '9');
INSERT INTO `role_permission` VALUES ('5', '10');
INSERT INTO `role_permission` VALUES ('5', '11');
INSERT INTO `role_permission` VALUES ('5', '12');
INSERT INTO `role_permission` VALUES ('5', '13');
INSERT INTO `role_permission` VALUES ('5', '14');
INSERT INTO `role_permission` VALUES ('5', '15');
INSERT INTO `role_permission` VALUES ('5', '16');
INSERT INTO `role_permission` VALUES ('5', '17');
INSERT INTO `role_permission` VALUES ('5', '18');
INSERT INTO `role_permission` VALUES ('5', '19');
INSERT INTO `role_permission` VALUES ('5', '20');
INSERT INTO `role_permission` VALUES ('5', '21');
INSERT INTO `role_permission` VALUES ('5', '22');
INSERT INTO `role_permission` VALUES ('5', '23');
INSERT INTO `role_permission` VALUES ('5', '24');
INSERT INTO `role_permission` VALUES ('5', '25');
INSERT INTO `role_permission` VALUES ('5', '26');
INSERT INTO `role_permission` VALUES ('5', '27');
INSERT INTO `role_permission` VALUES ('5', '28');
INSERT INTO `role_permission` VALUES ('5', '29');
INSERT INTO `role_permission` VALUES ('5', '30');
INSERT INTO `role_permission` VALUES ('5', '31');
INSERT INTO `role_permission` VALUES ('5', '32');
INSERT INTO `role_permission` VALUES ('5', '33');
INSERT INTO `role_permission` VALUES ('5', '34');
INSERT INTO `role_permission` VALUES ('5', '35');
INSERT INTO `role_permission` VALUES ('5', '36');
INSERT INTO `role_permission` VALUES ('2', '39');
INSERT INTO `role_permission` VALUES ('2', '40');
INSERT INTO `role_permission` VALUES ('2', '41');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `scheduleId` int(11) NOT NULL AUTO_INCREMENT,
  `scheduleTitle` varchar(255) DEFAULT NULL,
  `scheduleContent` text,
  `scheduleDate` date DEFAULT NULL,
  `scheduleTime` time DEFAULT NULL,
  `scheduleAddTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `scheduleUpdateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`scheduleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '培训业务周例会', '例行培训业务全国各分中心负责人及支撑部门总监会议。', '2017-11-29', '18:31:24', '2017-11-28 18:31:34', '2017-11-28 18:31:34', '24');
INSERT INTO `schedule` VALUES ('2', '上海漕河泾开发中心教学部门会议', '例行漕河泾开发培训中心教学部、就业部、教务部沟通会议。', '2017-11-29', '18:31:28', '2017-11-28 18:31:37', '2017-11-28 18:31:37', '24');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `uid` int(255) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) COLLATE utf8_bin NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'aaa', '123');
INSERT INTO `test` VALUES ('2', 'bbb', '123');
INSERT INTO `test` VALUES ('3', 'ccc', '123');
INSERT INTO `test` VALUES ('4', 'abc', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `upwd` varchar(50) NOT NULL,
  `nickName` varchar(50) NOT NULL,
  `leaderId` int(11) DEFAULT NULL,
  `face` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', 'admin', null, null);
INSERT INTO `user` VALUES ('2', 'maxuemei', '123', '马雪梅', '11', null);
INSERT INTO `user` VALUES ('3', 'nixiaoyu', '123', '倪笑宇', '11', null);
INSERT INTO `user` VALUES ('4', 'zhangming', '590e3bb396e18aea64384c4acbec8975', '张明', '11', null);
INSERT INTO `user` VALUES ('5', 'huofang', '590e3bb396e18aea64384c4acbec8975', '霍芳', '7', null);
INSERT INTO `user` VALUES ('6', 'sunlirui', '590e3bb396e18aea64384c4acbec8975', '孙丽睿', '8', null);
INSERT INTO `user` VALUES ('7', 'yuxiao', '590e3bb396e18aea64384c4acbec8975', '余笑', '11', null);
INSERT INTO `user` VALUES ('8', 'wangyan', '590e3bb396e18aea64384c4acbec8975', '王琰', '11', null);
INSERT INTO `user` VALUES ('9', 'zhoufeng', '590e3bb396e18aea64384c4acbec8975', '周峰', '11', null);
INSERT INTO `user` VALUES ('10', 'wangwei', '590e3bb396e18aea64384c4acbec8975', '王威', '11', null);
INSERT INTO `user` VALUES ('11', 'libo', '590e3bb396e18aea64384c4acbec8975', '李波', null, null);
INSERT INTO `user` VALUES ('12', 'zhuminghua', '590e3bb396e18aea64384c4acbec8975', '朱明华', '2', null);
INSERT INTO `user` VALUES ('13', 'kangshanshan', '590e3bb396e18aea64384c4acbec8975', '康珊珊', '3', null);
INSERT INTO `user` VALUES ('14', 'xujiayao', '590e3bb396e18aea64384c4acbec8975', '徐佳瑶', '13', null);
INSERT INTO `user` VALUES ('15', 'lipingran', '590e3bb396e18aea64384c4acbec8975', '李品然', '5', null);
INSERT INTO `user` VALUES ('16', 'wanglixia', '590e3bb396e18aea64384c4acbec8975', '王丽霞', '5', null);
INSERT INTO `user` VALUES ('17', 'donghuanhuan', '590e3bb396e18aea64384c4acbec8975', '董欢欢', '6', null);
INSERT INTO `user` VALUES ('18', 'zhuqiong', '590e3bb396e18aea64384c4acbec8975', '朱琼', '17', null);
INSERT INTO `user` VALUES ('19', 'gongweibin', '590e3bb396e18aea64384c4acbec8975', '龚玮斌', '7', null);
INSERT INTO `user` VALUES ('20', 'fengrui', '590e3bb396e18aea64384c4acbec8975', '冯瑞', '19', null);
INSERT INTO `user` VALUES ('21', 'chenchen', '123', '陈晨', '19', null);
INSERT INTO `user` VALUES ('22', 'zhaokai', '590e3bb396e18aea64384c4acbec8975', '赵凯', '19', null);
INSERT INTO `user` VALUES ('23', 'caigenrong', '590e3bb396e18aea64384c4acbec8975', '蔡根荣', '19', null);
INSERT INTO `user` VALUES ('24', 'wenshuqing', '590e3bb396e18aea64384c4acbec8975', '闻书晴', '19', null);
INSERT INTO `user` VALUES ('25', 'chengfengjiao', '590e3bb396e18aea64384c4acbec8975', '陈凤娇', '3', null);

-- ----------------------------
-- Table structure for user_attend
-- ----------------------------
DROP TABLE IF EXISTS `user_attend`;
CREATE TABLE `user_attend` (
  `userId` int(11) NOT NULL,
  `dutyType` int(11) DEFAULT NULL,
  KEY `userId` (`userId`),
  KEY `dutyType` (`dutyType`),
  CONSTRAINT `user_attend_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `user_fk` FOREIGN KEY (`dutyType`) REFERENCES `attendconfig` (`dutyType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_attend
-- ----------------------------
INSERT INTO `user_attend` VALUES ('1', '1');
INSERT INTO `user_attend` VALUES ('2', '1');
INSERT INTO `user_attend` VALUES ('12', '2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  KEY `pk_3` (`userId`),
  KEY `pk_4` (`roleId`),
  CONSTRAINT `pk_3` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `pk_4` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('2', '5');
INSERT INTO `user_role` VALUES ('3', '8');
INSERT INTO `user_role` VALUES ('3', '13');
INSERT INTO `user_role` VALUES ('4', '17');
INSERT INTO `user_role` VALUES ('5', '20');
INSERT INTO `user_role` VALUES ('6', '23');
INSERT INTO `user_role` VALUES ('7', '30');
INSERT INTO `user_role` VALUES ('8', '29');
INSERT INTO `user_role` VALUES ('9', '4');
INSERT INTO `user_role` VALUES ('10', '4');
INSERT INTO `user_role` VALUES ('11', '3');
INSERT INTO `user_role` VALUES ('12', '6');
INSERT INTO `user_role` VALUES ('13', '10');
INSERT INTO `user_role` VALUES ('14', '12');
INSERT INTO `user_role` VALUES ('15', '21');
INSERT INTO `user_role` VALUES ('16', '22');
INSERT INTO `user_role` VALUES ('17', '24');
INSERT INTO `user_role` VALUES ('18', '25');
INSERT INTO `user_role` VALUES ('19', '26');
INSERT INTO `user_role` VALUES ('20', '27');
INSERT INTO `user_role` VALUES ('21', '27');
INSERT INTO `user_role` VALUES ('22', '27');
INSERT INTO `user_role` VALUES ('23', '27');
INSERT INTO `user_role` VALUES ('25', '15');

-- ----------------------------
-- View structure for department_role_user
-- ----------------------------
DROP VIEW IF EXISTS `department_role_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `department_role_user` AS select a.*,c.nickName,c.leaderId,b.roleId,b.roleName from department as a inner join role as b on a.departmentId=b.departmentId
inner join user as c on a.userId=c.userId ;

-- ----------------------------
-- View structure for menu_operate
-- ----------------------------
DROP VIEW IF EXISTS `menu_operate`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `menu_operate` AS select menuId,c.operateId,c.operateName,c.operateAction,d.permissionId 
from permission_menu as a inner join permission_operate as b on a.permissionId=b.permissionId 
inner join operate as c inner join permission_operate as d 
where c.opid =b.operateId and  c.operateId=d.operateId ;

-- ----------------------------
-- View structure for permission_menu_vo
-- ----------------------------
DROP VIEW IF EXISTS `permission_menu_vo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `permission_menu_vo` AS select b.*,c.* 
from permission_menu as a inner join permission as b on a.permissionId=b.permissionId 
inner join menu as c on a.menuId=c.menuId ;

-- ----------------------------
-- View structure for permission_operate_vo
-- ----------------------------
DROP VIEW IF EXISTS `permission_operate_vo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `permission_operate_vo` AS select b.*,c.* from permission_operate as a inner join permission as b on a.permissionId=b.permissionId 
inner join operate as c on a.operateId=c.operateId ;

-- ----------------------------
-- View structure for role_permission_vo
-- ----------------------------
DROP VIEW IF EXISTS `role_permission_vo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `role_permission_vo` AS select c.*,b.* from role_permission as a inner join permission as b on a.permissionId=b.permissionId 
																				 inner join role as c on a.roleId=c.roleId 
-- 建立权限与菜单视图
-- create view permission_menu_vo as 
-- select b.*,c.* 
-- from permission_menu as a inner join permission as b on a.permissionId=b.permissionId 
-- inner join menu as c on a.menuId=c.menuId 
-- 建立权限与操作视图
-- create view permission_operate_vo as 
-- select b.*,c.* from permission_operate as a inner join permission as b on a.permissionId=b.permissionId 
-- inner join operate as c on a.operateId=c.operateId 
-- select a.permissionId,a.permissionName,a.menuId,a.MENUname, ;

-- ----------------------------
-- View structure for user_duty
-- ----------------------------
DROP VIEW IF EXISTS `user_duty`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `user_duty` AS select a.*,b.uname,c.dutyName 
from user_attend as a inner join user as b on a.userId=b.userId 
inner join attendconfig as c on a.dutyType=c.dutyType ;

-- ----------------------------
-- View structure for user_role_vo
-- ----------------------------
DROP VIEW IF EXISTS `user_role_vo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `user_role_vo` AS select b.*,c.* from user_role as a inner join user as b on a.userId=b.userId
																	 inner join role as c on a.roleId=c.roleId ;
