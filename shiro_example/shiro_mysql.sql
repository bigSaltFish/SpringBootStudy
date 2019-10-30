SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(255) NOT NULL COMMENT 'url地址',
  `NAME` varchar(64) NOT NULL COMMENT 'url描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '/user', 'user:user');
INSERT INTO `t_permission` VALUES ('2', '/user/add', 'user:add');
INSERT INTO `t_permission` VALUES ('3', '/user/delete', 'user:delete');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(32) NOT NULL COMMENT '角色名称',
  `MEMO` varchar(32) NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `t_role` VALUES ('2', 'test', '测试账户');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `RID` int(11) NOT NULL COMMENT '角色id',
  `PID` int(11) NOT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和权限，中间表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1');
INSERT INTO `t_role_permission` VALUES ('1', '2');
INSERT INTO `t_role_permission` VALUES ('1', '3');
INSERT INTO `t_role_permission` VALUES ('2', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL COMMENT '用户名',
  `PASSWD` varchar(255) NOT NULL COMMENT '密码',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `STATUS` char(3) NOT NULL COMMENT '是否有效 1：有效  0：锁定',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- test密码 test
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', '2019-10-23 16:40:26', '1');
INSERT INTO `t_user` VALUES ('2', 'test', '4d1eb74a4c2e0593704b66a0f1013c6f', '2019-10-24 16:40:29', '1');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `USER_ID` int(10) NOT NULL COMMENT '用户id',
  `RID` int(10) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色，中间表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2');
